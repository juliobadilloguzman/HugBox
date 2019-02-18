package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Users;

public interface ISignUp {

    public Users createUser(String mail, String password);

}
