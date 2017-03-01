import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.ArrayList;

public class Jugador {
    private JLabel imgPlayer;
    private ImageIcon img;
    private int serial;
    private int nro_de_cartones;
    /*Jugador tendra una lista de catones según la elección que haya elegido el usuario*/
    ArrayList <Carton> carton = new ArrayList();
    Jugador(int serial){
        this.serial = serial;
    }

    Jugador (){

    }

    public void setLabel(JLabel label){
        this.imgPlayer = label;
    }
    public JLabel getLabel(){
        return this.imgPlayer;
    }
    public int getSerial(){
        return this.serial;
    }

    public void setNroDeCartones(int nro_de_cartones){
        this.nro_de_cartones = nro_de_cartones;
    }

    public int getNroDeCartones(){
        return this.nro_de_cartones;
    }

    public void addCarton(Carton carton){
        carton.add(carton);
    }

}