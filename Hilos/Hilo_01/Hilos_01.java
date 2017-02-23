
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Runnable;

public class Hilos_01{
    public static void main(String[] args){
        JFrame marco=new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		marco.setVisible(true);
    }
}

class PelotaHilos implements Runnable{
	
	private Pelota pelota;
	private Component componente;
	
	public PelotaHilos(Pelota unaPelota, Component unComponente){
		this.pelota =  unaPelota;
		this.componente = unComponente;
	}

	public void run(){
		for (int i=1; i<=3000; i++){
			pelota.mueve_pelota(componente.getBounds());
            try {
                Thread.sleep(6);
            } catch (Exception e) {
                //TODO: handle exception
            }
			componente.paint(componente.getGraphics());	
		}	
	}
}

class Pelota{
// Mueve la pelota invirtiendo posición si choca con limites
    private static final int TAMX=15;
    private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
	public void mueve_pelota(Rectangle2D limites){
		x+=dx;
		y+=dy;
		if(x<limites.getMinX()){
			x=limites.getMinX();
			dx=-dx;
		}
		if(x + TAMX>=limites.getMaxX()){
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		if(y<limites.getMinY()){
			y=limites.getMinY();
			dy=-dy;
		}
		if(y + TAMY>=limites.getMaxY()){
			y=limites.getMaxY()-TAMY;
			dy=-dy;
		}
	}
	
	//Forma de la pelota en su posición inicial
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}		
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------

class LaminaPelota extends JPanel{
    private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
	//Añadimos pelota a la lámina
	public void add(Pelota b){	
		pelotas.add(b);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;

		for(Pelota b: pelotas){	
			g2.fill(b.getShape());
		}
	}
}

class MarcoRebote extends JFrame{
	private LaminaPelota lamina;
    public MarcoRebote(){
		
		setBounds(600,300,400,350);
		setTitle ("Rebotes");
		lamina=new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();

		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego();
			}
		});
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				System.exit(0);	
			}
		});	
		add(laminaBotones, BorderLayout.SOUTH);
	}

	//Ponemos botones
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}

	//Añade pelota y la bota 1000 veces
	public void comienza_el_juego (){			
		Pelota pelota=new Pelota();
		lamina.add(pelota);
		Runnable r = new PelotaHilos(pelota,lamina);
		Thread t = new Thread (r);

		t.start();
	}	
}
