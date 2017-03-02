import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;

public class Ventana extends JFrame{
    //Atributos
    private static Container contentpane;
    //Constructor
    Ventana(){
        initComponents();
    }
    //Función que inicia los componentes de la ventana
    private void initComponents(){
        //Componentes de la venatana
        setVisible(true);
        setSize(900,780);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        contentpane = getContentPane();
        Menu menu = new Menu();
        Ventana.addPanel(menu);
    }
    /* Función para añadir un nuevo panel a la ventana*/
    public static void addPanel(JPanel panel){
        contentpane.add(panel);
    }

}