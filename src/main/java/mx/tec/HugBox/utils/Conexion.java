package mx.tec.HugBox.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Servlet;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Logger logger = LogManager.getLogger(Servlet.class.getName());

    public static Connection getConnection(){
        String cadena = "jdbc:mysql://localhost:8889/ladw_db01?user=root&password=root&useSSL=false";
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(cadena);
            logger.debug("Se conecto a la base de datos");

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            logger.debug("NO SE PUDO CONECTAR A LA BASE DE DATOS");
        }
        return connection;
    }

    public static void main(String[] args) {
        if(getConnection() != null){
            System.out.println("Se conectó");
        }else{
            System.out.println("Algo pasó");
        }
    }

}
