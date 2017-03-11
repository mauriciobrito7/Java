/*
    HILOS
    Son un mecanismo que permite la ejecución de 2 o más procesos a la misma vez (Multitarea).
    Similar a como un sistema operativo gestiona múltiples procesos.
    Se pueden crear Extendiendo la clase Thread o implementando la Interface Runnable
    Los Thread (hilos) de java corren dentro de JVM (Java Virtual Machine)
    Java soporta el concepto de hilos con clases e interfaces definidas en el paquete java.lang
    Son útiles ya que permiten que los procesos del sistema se puedan ejecutar al mismo tiempo facilitando acciones principales y acciones secundarias o en segundo plano.
*/

public class Principal{
   public static void main(String[] args){
        HiloEjemplo ejemplo = new HiloEjemplo("Uno");
        HiloEjemplo ejemplo1 = new HiloEjemplo("Dos");
        HiloEjemplo ejemplo2 = new HiloEjemplo("Tres");
        
        ejemplo.start();
        ejemplo1.start();
        ejemplo2.start();
        
    }
}