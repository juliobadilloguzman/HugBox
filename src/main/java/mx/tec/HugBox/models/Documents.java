package mx.tec.HugBox.models;

import java.io.File;
import java.io.Serializable;

public class Documents implements Serializable {
    private int idDocuments;
    private String filename;
    private File content;
    private String link;
    private String type;


    public int getIdDocuments() {
        return idDocuments;
    }

    public void setIdDocuments(int idDocuments) {
        this.idDocuments = idDocuments;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public File getContent() {
        return content;
    }

    public void setContent(File content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
