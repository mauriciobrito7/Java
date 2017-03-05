import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
/*Clase principal del juego*//*Clase principal del juego*/
public class Bingo extends JPanel{
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;
    int optionPlayers;
    private int[] nros_U = new int[5];
    private int[] nros_N = new int[5];
    private int[] nros_E = new int[5];
    private int[] nros_G = new int[5];
    private int[] nros_I = new int[5];
    private int[] nros_T = new int[5];
    private int[] nros_O = new int[5];
    private JPanel panelPlayer1 = new JPanel();
    private JPanel panelPlayer2 = new JPanel();
    private JPanel panelPlayer3 = new JPanel();
    private Componentes componente = new Componentes();
    JLabel label = new JLabel();
    private FlowLayout layout;    

    Bingo(){
        //Color de fondo de la lamina
        setBackground(new Color(22,79,142));
        setLayout(setFlowLayout(1080, 5));
        panelPlayer1.setBackground(new Color(22,79,142));
        panelPlayer1.setLayout(setFlowLayout(10,20));
        panelPlayer2.setBackground(new Color(22,79,142));
        panelPlayer2.setLayout(setFlowLayout(10,20));
        panelPlayer3.setBackground(new Color(22,79,142));
        panelPlayer3.setLayout(setFlowLayout(10,20));        
        label = componente.makeMainTitleLabel("BINGO :");
        add(label);
        jugador1 = new Jugador(1);
        jugador2 = new Jugador(2);
        jugador3 = new Jugador(3);
        //pasarle jugador
        loadPanelPlayer();
        setCartonPlayer();
    }

    private FlowLayout setFlowLayout(int w, int h){
        layout = new FlowLayout(BoxLayout.Y_AXIS,w,h);
        return layout;
    }
    private void loadPanelPlayer(){
        label = componente.makeItemTitleLabel("Jugador 1 :");
        panelPlayer1.add(label);
        label = componente.makeItemTitleLabel("Jugador 2 :");
        panelPlayer2.add(label);
        if(optionPlayers > 2){
            label = componente.makeItemTitleLabel("Jugador 3 :");
            panelPlayer3.add(label);
        }
        
    }

    //Genera el carton para el jugador
    private void setCartonPlayer(){
        for(int i = 0; i < 2; i++){       
            createCarton(jugador1);
            panelPlayer1.add(jugador1.carton.get(i));
            createCarton(jugador2);
            panelPlayer2.add(jugador2.carton.get(i));
            if (optionPlayers >3){
                createCarton(jugador3);
                panelPlayer3.add(jugador3.carton.get(i));
            }
            
        } 
        add(panelPlayer1);
        add(panelPlayer2);
        if (optionPlayers >3){
            add(panelPlayer3); 
        }
                                     
    }
    //Obtiene numero aleatorio sin repetir
	public int random(int valorInicial,int valorFinal){ 
		return (int)(Math.random()*(valorFinal-valorInicial+1)+valorInicial);
	}
    private void generateNumberRandom(){
        int n = 0;
        for(int i = 0; i < 5; i++){
            do{
                n = random(1,10);             
            }while(n == nros_U[0] || n == nros_U[1] || n == nros_U[2] || n == nros_U[3] || n == nros_U[4]);
            nros_U[i] = n;                   
        }
        for(int i = 0; i < 5; i++){
            do{
                n = random(11,20);             
            }while(n == nros_N[0] || n == nros_N[1] || n == nros_N[2] || n == nros_N[3] || n == nros_N[4]);
            nros_N[i] = n;                   
        }
        for(int i = 0; i < 5; i++){
            do{
                n = random(21,30);             
            }while(n == nros_E[0] || n == nros_E[1] || n == nros_E[2] || n == nros_E[3] || n == nros_E[4]);
            nros_E[i] = n;                   
        }
        for(int i = 0; i < 5; i++){
            do{
                n = random(31,40);             
            }while(n == nros_G[0] || n == nros_G[1] || n == nros_G[2] || n == nros_G[3] || n == nros_G[4]);
            nros_G[i] = n;                   
        }
        for(int i = 0; i < 5; i++){
            do{
                n = random(41,50);             
            }while(n == nros_I[0] || n == nros_I[1] || n == nros_I[2] || n == nros_I[3] || n == nros_I[4]);
            nros_I[i] = n;                   
        }
        for(int i = 0; i < 5; i++){
            do{
                n = random(51,60);             
            }while(n == nros_T[0] || n == nros_T[1] || n == nros_T[2] || n == nros_T[3] || n == nros_T[4]);
            nros_T[i] = n;                   
        }
        for(int i = 0; i < 5; i++){
            do{
                n = random(61,70);             
            }while(n == nros_O[0] || n == nros_O[1] || n == nros_O[2] || n == nros_O[3] || n == nros_O[4]);
            nros_O[i] = n;                   
        }
    }
    private void createCarton(Jugador jugador){
        Carton carton = new Carton();
        generateNumberRandom();

        carton.labelItems.get(7).setText(""+nros_U[0]);
        carton.labelItems.get(14).setText(""+nros_U[1]);
        carton.labelItems.get(21).setText(""+nros_U[2]);
        carton.labelItems.get(28).setText(""+nros_U[3]);
        carton.labelItems.get(35).setText(""+nros_U[4]);

        carton.labelItems.get(8).setText(""+nros_N[0]);
        carton.labelItems.get(15).setText(""+nros_N[1]);
        carton.labelItems.get(22).setText(""+nros_N[2]);
        carton.labelItems.get(29).setText(""+nros_N[3]);
        carton.labelItems.get(36).setText(""+nros_N[4]);

        carton.labelItems.get(9).setText(""+nros_E[0]);
        carton.labelItems.get(16).setText(""+nros_E[1]);
        carton.labelItems.get(23).setText(""+nros_E[2]);
        carton.labelItems.get(30).setText(""+nros_E[3]);
        carton.labelItems.get(37).setText(""+nros_E[4]);

        carton.labelItems.get(10).setText(""+nros_G[0]);
        carton.labelItems.get(17).setText(""+nros_G[1]);
        carton.labelItems.get(24).setText(" ");
        carton.labelItems.get(31).setText(""+nros_G[3]);
        carton.labelItems.get(38).setText(""+nros_G[4]);

        carton.labelItems.get(11).setText(""+nros_I[0]);
        carton.labelItems.get(18).setText(""+nros_I[1]);
        carton.labelItems.get(25).setText(""+nros_I[2]);
        carton.labelItems.get(32).setText(""+nros_I[3]);
        carton.labelItems.get(39).setText(""+nros_I[4]);

        carton.labelItems.get(12).setText(""+nros_T[0]);
        carton.labelItems.get(19).setText(""+nros_T[1]);
        carton.labelItems.get(26).setText(""+nros_T[2]);
        carton.labelItems.get(33).setText(""+nros_T[3]);
        carton.labelItems.get(40).setText(""+nros_T[4]);

        carton.labelItems.get(13).setText(""+nros_O[0]);
        carton.labelItems.get(20).setText(""+nros_O[1]);
        carton.labelItems.get(27).setText(""+nros_O[2]);
        carton.labelItems.get(34).setText(""+nros_O[3]);
        carton.labelItems.get(41).setText(""+nros_O[4]);           

        jugador.carton.add(carton);
    }
    public static void main(String[] args){
        Ventana miVentana = new Ventana();
        miVentana.setVisible(true);
    }
}