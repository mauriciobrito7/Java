import java.lang.Thread;

public class BancoSinSicronizar{
    public static void main (String[] args){

    }
}
class Banco{
    private final double[] cuentas;
    public Banco(){
        cuentas = new double[100];
        for(int i = 0; i <= cuentas.length; i++){
            cuentas[i] = 2000;
        }
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad){
        if(cuentas[cuentaOrigen] < cantidad){
            return;
        }
        System.out.println(Thread.currentThread());
        cuentas[cuentaOrigen] -= cantidad;//dinero que sale de la cuentaOrigen
        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
        cuentas[cuentaDestino] += cantidad;
        System.out.printf("Saldo total: %10.2f \n", getSaldoTotal());
    }

    public double getSaldoTotal(){
        double suma_cuentas = 0;
        for(double a: cuentas){
            suma_cuentas += a;
        }
        return suma_cuentas;
    }
}