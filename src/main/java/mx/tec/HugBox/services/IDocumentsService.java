package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Documents;

import java.io.File;
import java.util.ArrayList;

public interface IDocumentsService {
    Documents createDocument(int idUser, String fileName, File content, String type);
    Documents linkADocument(int idUser, String link);
    ArrayList<Documents> showDocuments(int idUser );

}
