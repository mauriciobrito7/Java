import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Menu extends JPanel implements MouseListener{
    //Estilos
	Estilos styles = new Estilos();
    //Componentes
    private Componentes componente = new Componentes();
    //Labels
    private JLabel labelTitle;
    private JLabel labelItem;
    private JLabel labelItemExit;
    private JLabel labelOptionOne;
    private JLabel labelOptionTwo;
    private JLabel labelOptionThree;
    private JLabel labelBack;
    private JLabel labelChoice1;
    private JLabel labelChoice2;
    private JLabel labelChoice3;
    private ImageIcon image;
    private String path = new String("./img/");
    private JPanel panelCharacter = new JPanel();
    private FlowLayout layout;
    private Bingo bingo = new Bingo();
    private Jugador jugador = new Jugador(); 
    private JLabel option = new JLabel();
    private JLabel modeGame1;
    private JLabel modeGame2;         
    private JLabel modeGame3;         
             
    Menu(){
        //Color de fondo de la lamina
        setBackground(new Color(22,79,142));
        setLayout(setFlowLayout(1080, 60));
        //Establecer imagenes para la elección del usuario
        image = new ImageIcon(this.path+"p1_.png");
        labelChoice1 = new JLabel(image);
        image = new ImageIcon(this.path+"p2_.png");
        labelChoice2 = new JLabel(image);
        image = new ImageIcon(this.path+"p3_.png");
        labelChoice3 = new JLabel(image);       
        addPrincipalComponents();                          
    }
    private FlowLayout setFlowLayout(int w, int h){
        layout = new FlowLayout(BoxLayout.Y_AXIS,w,h);
        return layout;
    }
     /*Se deja de visualizar y luego se visualiza la lamina para que dibuje los labels si se hace con el método repaint tenia que redimensionar la pantalla para que se pudieran visualizar los nuevos componentes*/
    private void repaintLabel(){
        this.setVisible(false);
        this.setVisible(true);
    }
    private void setNroDeCartones(Jugador jugador){
        String x;
        do{
            x = JOptionPane.showInputDialog("Ingrese un numero de cartones para el jugador "+jugador.getSerial()+":");   
        }while(Integer.parseInt(x) < 1 || Integer.parseInt(x) > 2 );
        jugador.setNroDeCartones(Integer.parseInt(x));
        System.out.println("El jugador "+jugador.getSerial()+" ha elegido el numero de cartones "+ jugador.getNroDeCartones());
    }
    private void addPrincipalComponents(){
        labelTitle = componente.makeMainTitleLabel("UNEGITO");
        labelItem = componente.makeItemTitleLabel("Jugar");
        labelItemExit = componente.makeItemTitleLabel("Salir");

        labelItem.addMouseListener(this);
        labelItemExit.addMouseListener(this);

        add(labelTitle); 
        add(labelItem);
        add(labelItemExit);
    }

    private void removePrincipalComponents(){
            remove(labelTitle);
    		remove(labelItem);
            remove(labelItemExit);
            repaintLabel();
    }
    private void addSecondComponents(){
        labelTitle = componente.makeMainTitleLabel("JUGADORES");
        labelOptionOne = componente.makeItemTitleLabel("2 Jugadores");
        labelOptionTwo = componente.makeItemTitleLabel("3 Jugadores");
        labelBack = componente.makeItemTitleLabel("Volver");

        labelOptionOne.addMouseListener(this);
        labelOptionTwo.addMouseListener(this);
        labelBack.addMouseListener(this);

        add(labelTitle);
        add(labelOptionOne); 
        add(labelOptionTwo);
        add(labelBack);
    }

    private void removeSecondComponents(){
        remove(labelTitle);
        remove(labelOptionOne);
        remove(labelOptionTwo);
        remove(labelBack);
        repaintLabel();
    }
    private void addChoiceImg(JLabel option, Jugador jugador ){
        this.jugador = jugador;
        this.option = option;
        System.out.println("Estas entrando con el jugador : "+jugador.getSerial());
        //panel donde van las imagenes de los usuarios
        panelCharacter = new JPanel();
        panelCharacter.setLayout(new GridLayout(1,3));
        if(jugador != bingo.jugador3){
            labelTitle = componente.makeMainTitleLabel("Jugador "+this.jugador.getSerial()+" elige personsaje :");
            labelChoice1.addMouseListener(this);
            labelChoice2.addMouseListener(this);
            labelChoice3.addMouseListener(this);          
        }else if(jugador == bingo.jugador3){
             System.out.println("Estas con el jugador 3");             
             labelTitle = componente.makeMainTitleLabel("Jugador "+this.jugador.getSerial()+" sera:");
        } 
    
        //Si ya fue elegido un personaje no se coloca para la elección
        if(labelChoice1 != bingo.jugador1.getLabel() && labelChoice2 
        != bingo.jugador2.getLabel()){
            panelCharacter.add(labelChoice1);
            bingo.jugador3.setLabel(labelChoice1);                     
        } 
        
        if(labelChoice2 != bingo.jugador1.getLabel() && labelChoice2
        != bingo.jugador2.getLabel()){
            panelCharacter.add(labelChoice2);
            bingo.jugador3.setLabel(labelChoice2);                      
        }

        if(labelChoice3 != bingo.jugador1.getLabel() && labelChoice3
        != bingo.jugador2.getLabel()){
            panelCharacter.add(labelChoice3);
            bingo.jugador3.setLabel(labelChoice3);                      
        }
        add(this.labelTitle); 
        if(jugador == bingo.jugador3)
            add(bingo.jugador3.getLabel());  
        add(panelCharacter);            
        add(labelBack);
    }

    private void removeChoiceImg(){
        remove(labelTitle);
        remove(panelCharacter);
        remove(labelBack);
        repaintLabel();
    }

    private void addModeGame(){
        labelTitle = componente.makeMainTitleLabel("MODO DE JUEGO");
        modeGame1 = componente.makeItemTitleLabel("Horizontal");
        modeGame2 = componente.makeItemTitleLabel("Carton lleno");
        modeGame3 = componente.makeItemTitleLabel("Mixto");        

        modeGame1.addMouseListener(this);
        modeGame2.addMouseListener(this);
        modeGame3.addMouseListener(this);

        add(labelTitle);
        add(modeGame1); 
        add(modeGame2);
        add(modeGame3);
    }

    private void startBingo(int i){
        setVisible(false);
        Ventana.addPanel(bingo);
    }

    //Metodos de Eventos
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this.labelItem){
            this.labelItem.setForeground(styles.COLOR_HOVER);        
        }
        else if(e.getSource() == this.labelItemExit){
            this.labelItemExit.setForeground(styles.COLOR_HOVER);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == this.labelItem ){
            //Se remueven los viejos componentes
            removePrincipalComponents();
            addSecondComponents();
        }else if(e.getSource() == this.labelOptionOne){
            removeSecondComponents();
            addChoiceImg(this.labelOptionOne, bingo.jugador1);
        }else if(e.getSource() == this.labelChoice1){ //Si se elige el caracter 1
            setNroDeCartones(this.jugador);
		    this.jugador.setLabel(labelChoice1);
            removeChoiceImg();
            if(jugador == bingo.jugador3){
                 remove(bingo.jugador3.getLabel());
                 addModeGame();
            }
            if( jugador == bingo.jugador2)
                addChoiceImg(option, bingo.jugador3);   
            else if (jugador == bingo.jugador1)
                addChoiceImg(option, bingo.jugador2);        
        }else if(e.getSource() == this.labelChoice2){ //Si se elige el caracter 2
            setNroDeCartones(this.jugador);
		    this.jugador.setLabel(labelChoice2);
            removeChoiceImg();
            if(jugador == bingo.jugador3){
                 remove(bingo.jugador3.getLabel());
                 addModeGame();
            }
            if( jugador == bingo.jugador2)
                addChoiceImg(option, bingo.jugador3);   
            else if (jugador == bingo.jugador1)
                addChoiceImg(option, bingo.jugador2); 
        }else if(e.getSource() == this.labelChoice3){ //Si se elige el caracter 3
            setNroDeCartones(this.jugador);
		    this.jugador.setLabel(labelChoice3);
            removeChoiceImg();
            if(jugador == bingo.jugador3){
                 remove(bingo.jugador3.getLabel());
                 addModeGame();
            }
            if( jugador == bingo.jugador2)
                addChoiceImg(option, bingo.jugador3);   
            else if (jugador == bingo.jugador1)
                addChoiceImg(option, bingo.jugador2); 
        }else if(e.getSource() == this.modeGame1){
            System.out.println("comenzo");
        	startBingo(1);
        }else if(e.getSource() == this.modeGame2){
            System.out.println("comenzo");            
        	startBingo(2);
        }else if(e.getSource() == this.modeGame3){
            System.out.println("comenzo");            
        	startBingo(3);
        }else if(e.getSource() == this.labelItemExit){
        	System.exit(0);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.labelItem ){
            this.labelItem.setForeground(styles.COLOR_FONT);
        }
        else if(e.getSource() == this.labelItemExit){
            this.labelItemExit.setForeground(styles.COLOR_FONT);
        }
    }

}