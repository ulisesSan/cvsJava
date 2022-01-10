import java.io.*;
import java.awt.*;

public class AbrirArchivo {
    public void abrirarchivo(String archivo){

        try {
            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

        }catch (IOException ex) {

            System.out.println(ex);

        }
    }
}
