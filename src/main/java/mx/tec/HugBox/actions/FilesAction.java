package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import mx.tec.HugBox.models.Documents;
import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.services.DocumentsService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.struts2.interceptor.SessionAware;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FilesAction extends ActionSupport implements SessionAware, ModelDriven<Documents> {
    Map<String, Object> session;
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
        int myId=0;
        if (session.containsKey("UserId")){

            myId=(Integer)session.get("UserId");
        }

        ValueStack stack = ActionContext.getContext().getValueStack();

        DocumentsService _documentService = new DocumentsService();

        listaDocumentos = _documentService.showDocuments(myId);

        System.out.println("lista es: " + listaDocumentos);

        return SUCCESS;
    }

    public String fileUpload(){
        int myId=0;
        if (session.containsKey("UserId")){

            myId=(Integer)session.get("UserId");
        }
        DocumentsService _documentService = new DocumentsService();

        System.out.println("***DATOS***");
        System.out.println("Filaname: " +  documento.getFilename());
        System.out.println("Conent: " +  documento.getContent());
        System.out.println("Type: " + documento.getType());


        if( _documentService.createDocument(myId, documento.getFilename(), documento.getContent(), documento.getType()) ==null){
            return ERROR;
        }


        return SUCCESS;
    }
    @Override
    public Documents getModel() {
        return documento;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = session;
    }
}
