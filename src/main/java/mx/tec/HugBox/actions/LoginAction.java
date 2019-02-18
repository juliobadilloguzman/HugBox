package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import mx.tec.HugBox.models.Users;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("default")


public class LoginAction extends ActionSupport implements ModelDriven<Users> {

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    @Override
    public Users getModel() {
        return new Users();
    }


}
