public class HiloEjemplo extends Thread{

    public HiloEjemplo(String nombre){
        super(nombre);
    }
    public void run(){
        for (int i = 0; i < 10; i++){
            System.out.println("Estoy en "+getName()+" - "+i);
        }
        System.out.println("Finaliza el hilo"+getName());
    }
}