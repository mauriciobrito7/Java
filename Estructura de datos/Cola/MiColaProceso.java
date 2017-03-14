public class MiColaProceso implements ColaProceso{
    
    private NodoProceso cabeza, ultimo;

    @Override
    public void encolar(Trabajo t){
        NodoProceso nuevoNodo = new NodoProceso(t);
        if(isVacia()){
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        }else{
            ultimo.setSiguiente(nuevoNodo);
        }
        ultimo = nuevoNodo;
    }

    public boolean isVacia(){
        if(cabeza == null){
            return true;
        }
        return false;
    }

    @Override
    public void eliminar(){
        if (!isVacia()){
            NodoProceso eliminar = cabeza;
            cabeza = cabeza.getSiguiente();
            eliminar.setSiguiente(null);
            if (isVacia()){
                ultimo = null;
            }
        }
    }
    @Override
    public Trabajo obtener(){
        if (isVacia()){
            return null;
        }
        return cabeza.getTrabajo();
    }

}