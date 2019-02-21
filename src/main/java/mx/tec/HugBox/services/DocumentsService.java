package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Documents;
import mx.tec.HugBox.utils.Conexion;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class DocumentsService implements IDocumentsService{

    @Override
    public Documents createDocument(int idUser, String fileName, File content, String type) {
        try{
            Connection conn = Conexion.getConnection();
            String query = "CALL createDocument(?, ?, ?, ?)";
            CallableStatement csmt = conn.prepareCall(query);
            csmt.setInt(1, idUser);
            csmt.setString(2,fileName);
            csmt.setBinaryStream(3, FileToBlob(content,fileName));
            csmt.setString(4,type);

            Documents document = retrieveDocument(conn, csmt);
            if (document != null) return document;

        }catch(Exception ex){
            System.out.println(this.getClass().toString()
                    .concat(ex.getMessage()));
        }
        return null;
    }

    @Override
    public Documents linkADocument (String link) {
        try{
            Connection conn = Conexion.getConnection();
            String query = "CALL linkProcedure(?)";
            CallableStatement csmt = conn.prepareCall(query);
            csmt.setString(1, link);

            Documents document = retrieveDocument(conn, csmt);
            if (document != null) return document;

        }catch(Exception ex){
            System.out.println(this.getClass().toString()
                    .concat(ex.getMessage()));
        }
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
           // File file = new File("/Users/julioguzman/Documents", nombre);
            File file = new File("D:\\imagenes", nombre);
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(input, outputStream);
            outputStream.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    InputStream FileToBlob(File input, String nombre){
        try {
           // File file = new File("/Users/julioguzman/Documents", nombre);
            File file = new File("/D:\\imagenes", nombre);
            FileUtils.copyFile(input,file);
            InputStream targetStream = new FileInputStream(input);
            return targetStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Documents retrieveDocument(Connection conn, CallableStatement csmt) throws SQLException {
        ResultSet rs = csmt.executeQuery();

        if (rs.next()){
            Documents document = new Documents();
            document.setIdDocuments(rs.getInt("idDocuments"));
            document.setLink(rs.getString("link"));
            document.setFilename(rs.getString("filename"));
            document.setType(rs.getString("type"));
            document.setContent((BlobToFile(rs.getBinaryStream("content"), rs.getString("filename"))));
            rs.close();
            csmt.close();
            conn.close();
            return document;
        }

        rs.close();
        csmt.close();
        conn.close();
        return null;
    }
}
