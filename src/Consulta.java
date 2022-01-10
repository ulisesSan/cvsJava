import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
//Esta clase realiza las consultas para retornarlas y sean tratadas como sea necesario
public class Consulta {
    public static boolean consulta(String sql,String pass, String Usuario, String base)throws IOException {
        //ResultSet resultado = null;
        Conexion data = new Conexion();
        try{
            data.Base = base;
            data.Usuario = Usuario;
            data.Clave = pass;
            Statement sentencia = Conexion.conexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
