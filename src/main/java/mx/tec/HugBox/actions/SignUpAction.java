package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.services.SignUp;


public class SignUpAction extends ActionSupport implements ModelDriven<Users> {

    Users usuario = new Users();

    @Override
    public String execute() throws Exception {

        SignUp _signUpService = new SignUp();


        if(_signUpService.createUser(usuario.getEmail(), usuario.getPassword()) == null){

            return ERROR;
        }



        return SUCCESS;
    }

    @Override
    public Users getModel() {
        return usuario;
    }

}
