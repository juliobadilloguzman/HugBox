package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.services.SignUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class SignUpAction extends ActionSupport implements SessionAware, ModelDriven<Users> {
    Map<String, Object> session;
    Users usuario = new Users();
    private static Logger logger = LogManager.getLogger(SignUpAction.class.getName());
    @Override
    public String execute() throws Exception {

        SignUp _signUpService = new SignUp();


        if(_signUpService.createUser(usuario.getEmail(), usuario.getPassword()) == null){

            return ERROR;
        }

        logger.info(_signUpService);

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
