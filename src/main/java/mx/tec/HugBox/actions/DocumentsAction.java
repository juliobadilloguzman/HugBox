package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import mx.tec.HugBox.models.Documents;
import mx.tec.HugBox.services.DocumentsService;

import java.io.FileInputStream;

public class DocumentsAction extends ActionSupport implements ModelDriven<Documents> {
    private Documents document;
    private String link;
    private String filename;
    private FileInputStream fileInputStream;
    private String type;

    public String getFinalFileName() {
        return finalFileName;
    }

    public void setFinalFileName(String finalFileName) {
        this.finalFileName = finalFileName+type;
    }

    private String finalFileName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Documents getDocument() {
        return document;
    }

    public void setDocument(Documents document) {
        this.document = document;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("El li¡nk es:");
        System.out.println(link);
        DocumentsService _documentService = new DocumentsService();
        document = _documentService.linkADocument(link);
        if(document== null){
            return ERROR;
        }
        filename = document.getFilename();
        System.out.println("El file es: + " + document.getFilename());
        System.out.println("El tipo es: " +  document.getType());

        fileInputStream = new FileInputStream(document.getContent());
        System.out.println("El input stream es: " +  this.getFileInputStream());
        return SUCCESS;
        //fileInputStream = new FileInputStream(document.getContent());
        //return DOWNLOAD;
    }
    public String linkDownload(){


        return SUCCESS;
    }
    @Override
    public Documents getModel() {
        return null;
    }
}