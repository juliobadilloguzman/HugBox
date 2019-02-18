package mx.tec.HugBox.services;

import mx.tec.HugBox.models.Users;
import mx.tec.HugBox.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService implements ILoginService {

    @Override
    public Users verifyUser(String email, String password) {
        try {
            Connection connection = Conexion.getConnection();
            String query = "SELECT idUsers,email,password FROM users WHERE (email=? AND password = sha2(?,224))";
            PreparedStatement psmt = connection.prepareStatement(query);
            psmt.setString(1, email);
            psmt.setString(2, password);
            ResultSet rs = psmt.executeQuery();

            //Enters if the result set is not empty
            if (rs.next()){
                Users user = new Users();
                user.setIdUsers(rs.getInt("idUsers"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                rs.close();
                psmt.close();
                connection.close();
                return user;
            }
            rs.close();
            psmt.close();
            connection.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}