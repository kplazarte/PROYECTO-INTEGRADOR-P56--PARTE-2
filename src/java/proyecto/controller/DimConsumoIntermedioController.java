package proyecto.controller;

import proyecto.entities.DimConsumoIntermedio;
import proyecto.controller.util.JsfUtil;
import proyecto.controller.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("dimConsumoIntermedioController")
@SessionScoped
public class DimConsumoIntermedioController implements Serializable {

    @EJB
    private proyecto.controller.DimConsumoIntermedioFacade ejbFacade;
    private List<DimConsumoIntermedio> items = null;
    private DimConsumoIntermedio selected;

    public DimConsumoIntermedioController() {
    }

    public DimConsumoIntermedio getSelected() {
        return selected;
    }

    public void setSelected(DimConsumoIntermedio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DimConsumoIntermedioFacade getFacade() {
        return ejbFacade;
    }

    public DimConsumoIntermedio prepareCreate() {
        selected = new DimConsumoIntermedio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DimConsumoIntermedioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DimConsumoIntermedioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DimConsumoIntermedioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DimConsumoIntermedio> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public DimConsumoIntermedio getDimConsumoIntermedio(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<DimConsumoIntermedio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DimConsumoIntermedio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DimConsumoIntermedio.class)
    public static class DimConsumoIntermedioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DimConsumoIntermedioController controller = (DimConsumoIntermedioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dimConsumoIntermedioController");
            return controller.getDimConsumoIntermedio(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DimConsumoIntermedio) {
                DimConsumoIntermedio o = (DimConsumoIntermedio) object;
                return getStringKey(o.getSkConsumoIntermedio());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DimConsumoIntermedio.class.getName()});
                return null;
            }
        }

    }

}
