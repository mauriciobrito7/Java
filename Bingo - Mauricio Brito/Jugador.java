import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Jugador {
    private JLabel imgPlayer;
    private ImageIcon img;
    private int serial;

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
}