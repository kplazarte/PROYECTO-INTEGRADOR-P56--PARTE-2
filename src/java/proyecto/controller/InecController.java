package proyecto.controller;

import proyecto.entities.Inec;
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

@Named("inecController")
@SessionScoped
public class InecController implements Serializable {

    @EJB
    private proyecto.controller.InecFacade ejbFacade;
    private List<Inec> items = null;
    private Inec selected;

    public InecController() {
    }

    public Inec getSelected() {
        return selected;
    }

    public void setSelected(Inec selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getInecPK().setSkTiempo(selected.getDimTiempo().getSkTiempo());
        selected.getInecPK().setSkTipo(selected.getDimTipo().getSkTipo());
        selected.getInecPK().setSkProduccion(selected.getDimProduccion().getSkProduccion());
        selected.getInecPK().setSkConsumoIntermedio(selected.getDimConsumoIntermedio().getSkConsumoIntermedio());
    }

    protected void initializeEmbeddableKey() {
        selected.setInecPK(new proyecto.entities.InecPK());
    }

    private InecFacade getFacade() {
        return ejbFacade;
    }

    public Inec prepareCreate() {
        selected = new Inec();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InecCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InecUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InecDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Inec> getItems() {
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

    public Inec getInec(proyecto.entities.InecPK id) {
        return getFacade().find(id);
    }

    public List<Inec> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Inec> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Inec.class)
    public static class InecControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InecController controller = (InecController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inecController");
            return controller.getInec(getKey(value));
        }

        proyecto.entities.InecPK getKey(String value) {
            proyecto.entities.InecPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new proyecto.entities.InecPK();
            key.setSkTiempo(Integer.parseInt(values[0]));
            key.setSkConsumoIntermedio(Integer.parseInt(values[1]));
            key.setSkProduccion(Integer.parseInt(values[2]));
            key.setSkTipo(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(proyecto.entities.InecPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getSkTiempo());
            sb.append(SEPARATOR);
            sb.append(value.getSkConsumoIntermedio());
            sb.append(SEPARATOR);
            sb.append(value.getSkProduccion());
            sb.append(SEPARATOR);
            sb.append(value.getSkTipo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Inec) {
                Inec o = (Inec) object;
                return getStringKey(o.getInecPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Inec.class.getName()});
                return null;
            }
        }

    }

}
