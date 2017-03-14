/* Se va a implementar una cola de procesado de trabajo. Imaginemos que estamos haciendo un servidor de impresión y tenemos que imprimir documentos muy largos con varias páginas y esos documentos tardan un par de minutos en imprimir además nuestra impresora solo puede imprimir un trabajo a la vez, necesitamos una forma adecuada de poder controlar el uso que se hace de nuestra impresora y para ello necesitamos un servidor que sea capaz de procesar correctamente los distintos trabajos que nuestros empleados o usuarios van a mandar por ejemplo los libros que tengamos que imprimir. Entonces nos interesa trabajar con una estructura parecida a una cola porque de ese modo podemos asignar los trabajos en un orden de impresión a medida que van llegando de modo que si un empleado manda su trabajo se manda a imprimir y si otro  empleado manda a la vez su trabajo se manda a la cola despues del primero para que se imprima despues pero siempre respetando un orden, no se pueden mandar un trabajo y esperar a que se imprima de inmediato si tenemos otros trabajos en cola.*/

public class Computadora{
    
    public static void main(String[] args){
        Usuario mauricio = new Usuario();
        Trabajo t = new Trabajo("Juego de tronos", "Mauricio");
        Usuario estefania = new Usuario();
        Trabajo t2 = new Trabajo("Java patron de diseños", "Estefania");
        Usuario antonio = new Usuario();
        Trabajo t3 = new Trabajo("Taller", "Antonio");

        mauricio.impresora.mandarImprimir(t);
        estefania.impresora.mandarImprimir(t2);
        antonio.impresora.mandarImprimir(t3);
    }
}