import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
public class Carton extends JPanel{
    int[][] arrayNum = new int[6][6];
    ArrayList <JLabel> labelItems = new ArrayList(); 
    Componentes componente = new Componentes();

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