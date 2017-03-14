public final class Impresora extends MiColaProceso{
    private static final Impresora impresora = new Impresora();
  
    public static Impresora getImpresora(){
        return impresora;
    }

    public void mandarImprimir(Trabajo t){
        encolar(t);
        imprimir();
    }

    public void imprimir(){
        while(!isVacia()){
            System.out.println("Se imprimio :"+obtener().getTitulo());
            eliminar();
        }
    }
}