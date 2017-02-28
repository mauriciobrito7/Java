import javax.swing.JPanel;
import java.awt.Color;
/*Clase principal del juego*//*Clase principal del juego*/
public class Bingo extends JPanel{
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;

    Bingo(){
        //Color de fondo de la lamina
        setBackground(new Color(22,79,142));

        jugador1 = new Jugador(1);
        jugador2 = new Jugador(2);
        jugador3 = new Jugador(3);
    }
    public static void main(String[] args){
        Ventana miVentana = new Ventana();
        miVentana.setVisible(true);
    }
}