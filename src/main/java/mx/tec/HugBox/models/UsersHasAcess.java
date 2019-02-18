package mx.tec.HugBox.models;

import java.io.Serializable;

public class UsersHasAcess implements Serializable {
   private int idUsers;
   private int idDocuments;
   private int idAcess;

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public int getIdDocuments() {
        return idDocuments;
    }

    public void setIdDocuments(int idDocuments) {
        this.idDocuments = idDocuments;
    }

    public int getIdAcess() {
        return idAcess;
    }

    public void setIdAcess(int idAcess) {
        this.idAcess = idAcess;
    }
}
