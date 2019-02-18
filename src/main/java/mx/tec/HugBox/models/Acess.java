package mx.tec.HugBox.models;

import java.io.Serializable;

public class Acess implements Serializable {

    private int idAcess;
    private String description;

    public int getIdAcess() {
        return idAcess;
    }

    public void setIdAcess(int idAcess) {
        this.idAcess = idAcess;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
