package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Users;

public interface ILoginService {

    Users verifyUser(String email, String password);
     int getIdByEmail(String email);

}
