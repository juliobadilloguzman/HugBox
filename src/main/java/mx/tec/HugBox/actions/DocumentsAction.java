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
        System.out.println(link);
        DocumentsService _documentService = new DocumentsService();
        document = _documentService.linkADocument(link);
        if(document== null){
            return ERROR;
        }
        filename = document.getFilename();
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
