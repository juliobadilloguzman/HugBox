package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Documents;
import mx.tec.HugBox.utils.Conexion;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class DocumentsService implements IDocumentsService{

    @Override
    public Documents createDocument(int idUser, String fileName, File content, String type) {
        return null;
    }

    @Override
    public Documents linkADocument(int idUser, String link) {
        return null;
    }

    @Override
    public ArrayList<Documents> showDocuments(int idUser) {
        ArrayList<Documents> result = new ArrayList<Documents>();
        try {
            Connection connection = Conexion.getConnection();
            String query = "CALL showDocuments(?)";
            CallableStatement csmt = connection.prepareCall(query);
            csmt.setInt(1, idUser);
            ResultSet rs = csmt.executeQuery();

            //Enters if the result set is not empty
            while (rs.next()){
                Documents row = new Documents();
                row.setIdDocuments(rs.getInt("idDocuments"));
                row.setFilename(rs.getString("filename"));
                row.setContent(BlobToFile(rs.getBinaryStream("content"), rs.getString("filename")) );
                row.setLink(rs.getString("link"));
                row.setType(rs.getString("type"));
                result.add(row);
                System.out.println(result.size());
            }
            rs.close();
            csmt.close();
            connection.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    File BlobToFile(InputStream input, String nombre){
        try {
            File file = new File("/Users/julioguzman/Documents", nombre);
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(input, outputStream);
            outputStream.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
