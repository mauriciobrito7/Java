import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
//Clase que ayuda a crear los cartones para el jugador
public class Carton extends JPanel{
    //Lista de Label que se agregaran a la grilla
    ArrayList <JLabel> labelItems = new ArrayList(); 
    private Componentes componente = new Componentes();
    private JLabel labe;

    Carton(){
        setBackground(new Color(22,79,142));
        setLayout(new GridLayout(6,7));
        initComponents("U");
        initComponents("N");         
        initComponents("E");         
        initComponents("G");         
        initComponents("I");         
        initComponents("T");         
        initComponents("O");

        for(int i = 0; i< 35; i++){
            initComponents("1");         
        }
        for(int x=0; x<labelItems.size(); x++) {
            add(labelItems.get(x));
        }
                                                  
    }

    private void initComponents(String name){
        JLabel label = componente.makeAItemCarton(name);
        labelItems.add(label);
    }

}