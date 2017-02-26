import java.lang.*;
public class SincronizandoHilos{
    public static void main(String[] args){
        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);
        hilo1.start();
        hilo2.start();
    }
}

class HilosVarios extends Thread{
    public void run(){
        for (int i = 0; i < 15; i++){
            System.out.println("Ejecutando hilo "+ getName());
            try {
                Thread.sleep(70);                
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}
/*Implica que el hilo no se ejecutará hasta que se termine el hilo que 
se le pasa por parametros*/
class HilosVarios2 extends Thread{
    private Thread hilo;
    public HilosVarios2(Thread hilo){
        this.hilo = hilo;
    }
    public void run(){
        try {
            hilo.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 15; i++){
            System.out.println("Ejecutando hilo "+ getName());
            try {
                Thread.sleep(70);                
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}