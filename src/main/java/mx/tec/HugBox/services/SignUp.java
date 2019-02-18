package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUp implements ISignUp{

    @Override
    public Users createUser(String mail, String password) {
        Connection conn = Conexion.getConnection();

        String sql = "SELECT email FROM Users WHERE email = ?";
        try{

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mail);
            ResultSet rs = ps.executeQuery();
            if(! rs.next()) {

                String sql2 = "INSERT INTO users (email, password) VALUES (?, sha2(?,224))";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, mail);
                ps2.setString(2, password);
                ps2.execute();

                ps2.close();
            }
            ps.close();
            rs.close();
            conn.close();

        }catch(Exception ex){
            System.out.println(this.getClass().toString()
                    .concat(ex.getMessage()));
        }
        return null;
    }
}
