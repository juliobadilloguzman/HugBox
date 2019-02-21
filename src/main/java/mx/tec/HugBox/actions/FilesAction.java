package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import mx.tec.HugBox.models.Documents;
import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.services.DocumentsService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FilesAction extends ActionSupport implements ModelDriven<Documents> {

    Documents documento = new Documents();

    private ArrayList<Documents> listaDocumentos;

    public ArrayList<Documents> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(ArrayList<Documents> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }



    @Override
    public String execute() throws Exception {

        ValueStack stack = ActionContext.getContext().getValueStack();

        DocumentsService _documentService = new DocumentsService();

        listaDocumentos = _documentService.showDocuments(1);

        System.out.println("lista es: " + listaDocumentos);

        return SUCCESS;
    }

    public String fileUpload(){

        DocumentsService _documentService = new DocumentsService();

        System.out.println("***DATOS***");
        System.out.println("Filaname: " +  documento.getFilename());
        System.out.println("Conent: " +  documento.getContent());
        System.out.println("Type: " + documento.getType());


        if( _documentService.createDocument(1, documento.getFilename(), documento.getContent(), documento.getType()) ==null){
            return ERROR;
        }


        return SUCCESS;
    }

    @Override
    public Documents getModel() {
        return documento;
    }

}
