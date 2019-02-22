package mx.tec.HugBox.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConnection(){
        String cadena = "jdbc:mysql://localhost/ladw_db01?user=root&password=root&useSSL=false";
        /*:8889*/
        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(cadena);


        }catch(Exception ex){
            System.out.println(ex.getMessage());
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
