package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.services.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;


public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<Users> {
    Map<String, Object> session;
    Users usuario = new Users();
    private static Logger logger = LogManager.getLogger(LoginAction.class.getName());

    @Override
    public String execute() throws Exception {

        //Instancia servicio
        LoginService _loginService = new LoginService();

        //Verifica que el usuario no sea nulo, en caso de serlo, manda error
        if(_loginService.verifyUser(usuario.getEmail(), usuario.getPassword()) == null){
            return ERROR;
        }
        logger.info(usuario);
        logger.info(_loginService);

        session.put("UserId", (Integer)usuario.getIdUsers());
        return SUCCESS;
    }

    @Override
    public Users getModel() {
        return usuario;
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
