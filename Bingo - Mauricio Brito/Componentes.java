import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

//LIBRERIA PARA COMPONENTES
/*Ayuda para la creación de los componentes del proyecto*/

public class Componentes {
	private Estilos styles = new Estilos();
	private JLabel label;
	private Image imagen;
	
	//Crear etiquetas para los titulos
	public JLabel  makeMainTitleLabel(String title){
		label = new JLabel(title);
		label.setForeground(styles.COLOR_TITLE);
		label.setFont(new Font(styles.FONT, Font.BOLD, styles.FONT_SIZE_TITLE));
		return label;
	}
	//Crear etiquetas para las opciones
	public JLabel makeItemTitleLabel(String title){
		label = new JLabel(title);
		label.setForeground(styles.COLOR_FONT);
        label.setFont(new Font(styles.FONT, Font.PLAIN, styles.FONT_SIZE_ITEM));
        label.setBorder(javax.swing.BorderFactory.createBevelBorder
      (javax.swing.border.BevelBorder.LOWERED));
        return label;
	}
	//Buscar imagen
	public Image makeAImage(String path){
		 // Excepcion
        try {
              imagen = ImageIO .read( new File (path)) ;
        } catch (IOException e ) {

               System.out .println( "La imagen no se ha encontrado" );
        }
		return imagen;
	}
}

