package name.medin.tutorial.adf.intro.view;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;

public class EmployeeHelper {
    public EmployeeHelper() {
        super();
    }
    private String action;

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void ApplyCriteria(ValueChangeEvent valueChangeEvent) {
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dc = bindings.getIteratorBinding("EmployeesView", null, "EmployeesViewIterator");
        ViewObject vo = dc.getViewObject();
        ViewCriteria vc = vo.getViewCriteriaManager().getViewCriteria((String) valueChangeEvent.getNewValue());
        dc.getViewObject().applyViewCriteria(vc);
        dc.getViewObject().executeQuery();
    }

}
