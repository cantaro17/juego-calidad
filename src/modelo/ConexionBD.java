package modelo;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */

public class ConexionBD {

    static Connection conect = null;

    public static Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost:3307/juego", "root", "dbroot"); 
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }   
//    
//     public Connection Desconectar() {
//        try {
//            conect.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
//        }
//        return conect;
//    }   
}
