package name.medin.tutorial.adf.intro.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EmployeeHelper {
    
    public EmployeeHelper() {
    }

    private String action;

    /**
     *Set the action
     * @param action the action value
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     *Get the action
     * @return the action value.
     */
    public String getAction() {
        return action;
    }
}
