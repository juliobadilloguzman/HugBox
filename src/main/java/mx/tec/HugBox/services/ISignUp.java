package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Users;

public interface ISignUp {

     Users createUser(String mail, String password);

}
