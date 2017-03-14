import java.lang.Runnable;
import java.awt.event.*;
import java.lang.Thread;
import java.lang.*;

public class Lista {
    Nodo inicio;
    Nodo fin;

    public Lista(){
        inicio = null;
        fin = null;
    }

    public void insertarAlInicio(Animales animal){
        Nodo nuevo = new Nodo(animal, inicio);

        inicio = nuevo;

        if(fin == null){
            fin = inicio;
        }
    }

    public void insertarAlFinal(Animales animal){

        Nodo nuevo = new Nodo(animal, null); //recordar el nodo final apunta a null
        if(inicio == null){
            fin = nuevo;
            inicio = fin;
        }else{
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

    }

    public void eliminarInicio(){
        inicio = inicio.siguiente;
    }

    public Animales extraerInicio(){
        Animales animal = inicio.getAnimal();
        inicio = inicio.getSiguiente();

        if(inicio == null){
            fin = null;
        }
        return animal;
    }

    public void listar(){
        Nodo temp = inicio;
        while(temp != null){
            System.out.println(" "+temp.getAnimal().getTipo()+" "+temp.getAnimal().getNombre()+" "+temp.getAnimal().getEdad()+" "+temp.getAnimal().getSexo());
            temp = temp.siguiente;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}