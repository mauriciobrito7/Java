public class NodoProceso{
    private Trabajo trabajo;
    private NodoProceso siguiente = null;

    public NodoProceso(Trabajo trabajo){
        this.trabajo = trabajo;
    }

    public void setSiguiente(NodoProceso siguiente){
        this.siguiente = siguiente;
    }
    public NodoProceso getSiguiente(){
        return siguiente;
    }

    public Trabajo getTrabajo(){
        return trabajo;
    }
}