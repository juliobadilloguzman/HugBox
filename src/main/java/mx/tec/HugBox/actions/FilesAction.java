package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import mx.tec.HugBox.models.Documents;
import mx.tec.HugBox.services.DocumentsService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FilesAction extends ActionSupport {

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
}
