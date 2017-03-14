public class Nodo{
    private Animales animal;
    Nodo siguiente;

    public Nodo(Animales animal, Nodo _nodo){
        this.animal = animal;
        this.siguiente = _nodo;
    }

    public void setAnimal(Animales animal){
        this.animal = animal;
    }

    public Animales getAnimal(){
        return this.animal;
    }

    public void setSiguiente(Nodo _nodo){
        this.siguiente = _nodo;
    }

    public Nodo getSiguiente(){
        return this.siguiente;
    }

}