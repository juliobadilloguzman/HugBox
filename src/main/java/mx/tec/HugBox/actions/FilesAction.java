package mx.tec.HugBox.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import mx.tec.HugBox.models.Documents;
import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.services.DocumentsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.Servlet;
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

    private static Logger logger = LogManager.getLogger(Servlet.class.getName());

    @Override
    public String execute() throws Exception {


        ValueStack stack = ActionContext.getContext().getValueStack();

        DocumentsService _documentService = new DocumentsService();

        listaDocumentos = _documentService.showDocuments((Integer) session.get("UserId"));


        return SUCCESS;
    }

    public String fileUpload(){

        DocumentsService _documentService = new DocumentsService();

        if( _documentService.createDocument((Integer) session.get("UserId"), documento.getFilename(), documento.getContent(), documento.getType()) ==null){
            logger.debug("No se pudo crear el documento con nombre: " + documento.getFilename() + " para el usuario con id: " + session.get("UserId"));
            return ERROR;
        }


        return SUCCESS;
    }

    @Override
    public Documents getModel() {
        return documento;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
