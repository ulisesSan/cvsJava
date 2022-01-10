import java.sql.*;

public class Conexion {
    static String Base;
    static String Usuario;
    static String Clave;
    public static Connection conexion(){
        final String URL = "jdbc:mysql://localhost:3306/"+Base;
        final String USER = Usuario;
        final String CLAVE = Clave;
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL +"?allowLoadLocalInfile=true", USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
