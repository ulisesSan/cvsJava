import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Grafico extends JFrame {

    //Se agregan los elemntos como variables
    private JPanel Principal;
    private JTextField Usr;
    private JTextField nameTable;
    private JButton buscaArchivo;
    private JTextField Pwd;
    private JTextField Name;
    private JTextField DirCSV;
    private JLabel Usuario;
    private JLabel Contraseña;
    private JLabel NombreBase;
    private JLabel NombreTabla;
    private JLabel DirArch;
    private JLabel Instuccion;

    public Grafico(){
        buscaArchivo.addActionListener(actionEvent -> {
        String usuario,contraseña, nombreB, nombreT,dirArch,sql;
        Consulta con = new Consulta();
        usuario = Usr.getText();
        contraseña = Pwd.getText();
        nombreB = Name.getText();
        nombreT = nameTable.getText();
        dirArch = DirArch.getText();
        sql= sql = "LOAD DATA LOCAL INFILE '"+dirArch+"' " +
                "INTO TABLE "+nombreT+" FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n' IGNORE 1 ROWS();";;
        if(usuario == null || contraseña == null || nombreB == null ||
                nombreT == null || dirArch == null){
            JOptionPane.showMessageDialog(null,"Tienes que llenar todos campos.");
        }else{
            try {
                con.consulta(sql,contraseña,usuario,nombreB);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        });
    }

    public void principal(){
            //super();
            configurarVentana();
            init();

    }
    public void init(){
        //Se asigna texto a los elementos de la ventana
        Usr.setText("");
        Usuario.setText("Usuario");
        Pwd.setText("");
        Contraseña.setText("Contraseña");
        Name.setText("");
        NombreBase.setText("Nombre de la base");
        nameTable.setText("");
        NombreTabla.setText("Nombre de la tabla");
        DirCSV.setText("");
        DirArch.setText("Direccion de archivo");
        buscaArchivo.setText("Aceptar");
        Instuccion.setText("Debe de agregar doble diagona invertida (\\)");
        //Se les asigna un lugar a los elementos
        Usr.setBounds(275, 50, 200, 25);
        Usuario.setBounds(75, 50,200,25);
        Pwd.setBounds(275,80,200,25);
        Contraseña.setBounds(75,80,200,25);
        Name.setBounds(275,110,200,25);
        NombreBase.setBounds(75,110,200,25);
        nameTable.setBounds(275,140,200,25);
        NombreTabla.setBounds(75,140,200,25);
        DirCSV.setBounds(275,170,200,25);
        DirArch.setBounds(75,170,200,25);
        buscaArchivo.setBounds(350,200,100,25);
        Instuccion.setBounds(50,200,300,25);
        //Se inicializan los elementos
        this.add(Usr);
        this.add(Usuario);
        this.add(nameTable);
        this.add(NombreTabla);
        this.add(Name);
        this.add(NombreBase);
        this.add(Pwd);
        this.add(Contraseña);
        this.add(DirCSV);
        this.add(DirArch);
        this.add(buscaArchivo);
        this.add(Instuccion);
    }

    private void configurarVentana() {
        //se le da un nombre a la ventana
        this.setTitle("Agrega csv a la base de datos");
        //Se le asigna un tamaño
        this.setSize(510, 310);
        //Se le hace la centracion a la ventana
        this.setLocationRelativeTo(null);
        //Se le asigna un layout a la ventana (ninguno)
        this.setLayout(null);
        //hacemos que la ventana no sea redimencionable
        this.setResizable(false);
        //Se le asigna la tarea de que cierre el proceso cuando de toca el boton de salir
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
