public class Usuario{
    Impresora impresora;
    private Trabajo trabajo;
    
    Usuario(){
        impresora = Impresora.getImpresora();
    }
}