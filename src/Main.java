import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException {
        Scanner entrada = new Scanner(System.in);
        Consulta con = new Consulta();
        String Archivo = System.getProperty("user.home") + "/Desktop/Copias-de-Bases/cvs/";
        String base, ruta, usuario,contraseña, sql,tabla;
        System.out.println("Para insertar .cvs inserte los siguentes requisitos \n Base de datos \n contraseña" +
                "\n Usuario \n Direccion de su archivo");
        try{
            System.out.println("Intoduzca su usuario");
            usuario = entrada.next();
            System.out.println("Introduzca la contraseña de la base");
            contraseña = entrada.next();
            System.out.println("Introduzca el nombre de su base de datos");
            base = entrada.next();
            System.out.println("Introduzca el de su tabla");
            tabla = entrada.next();
            System.out.println("Introduzca la ruta de su archivo");
            ruta = entrada.next();
            AbrirArchivo archivo = new AbrirArchivo();
            //archivo.abrirarchivo();
            sql = "LOAD DATA LOCAL INFILE '"+ruta+"' " +
                    "INTO TABLE "+tabla+" FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n' IGNORE 1 ROWS();";
            con.consulta(sql,contraseña,usuario,base);
        }catch(IOException e){
          System.out.println(e);
        }

    }
}
