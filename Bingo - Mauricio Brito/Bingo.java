/*Clase principal del juego*/

public class Bingo{
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;

    Bingo(){
        jugador1 = new Jugador(1);
        jugador2 = new Jugador(2);
        jugador3 = new Jugador(3);
    }
    public static void main(String[] args){
        Ventana miVentana = new Ventana();
        miVentana.setVisible(true);
    }
}