/*Implementa la Interface Runnavle como otra alternativa al uso de Thread
No hay dependencia de la Herencia, se usa cuando no es posible extender de la clase Thread ya que necesitamos heredar de otra clase de nuestro sistema, esto teniendo en cuenta que java n permite la herencia multiple.
Para ejecutar el hilo se debe crear una instancia de la clase que implementa Runnable, posteriormente esre objeto se envia como parametro a una instancia de Thread y se llama al metodo start()
*/

public class Principal{
    public static void main(String[] args){
        HiloEjemplo  miHilo = new HiloEjemplo();
        Thread hilo = new Thread(miHilo);
        hilo.start();
    }
}