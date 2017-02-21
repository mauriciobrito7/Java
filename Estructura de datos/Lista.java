import java.util.ArrayList;
public class Lista{
    /*Clase de la api collection Java que nos permite crear listas de los  elemento que nosotros queramos crear*/
    private ArrayList <Persona> listado;

    public Lista(){
        listado = new ArrayList<>();
    }
    public void agregar(Persona persona){
        this.listado.add(persona);
    }

    public Persona obtener(int i){
        return listado.get(i);
    }

    public void mostrarPersonas(){
        for (int i = 0; i < listado.size(); i++) {
           System.out.println(""+listado.get(i).getNombre());
        }
    }
    public static void main(String[] args){

        Persona persona1 = new Persona("Mauricio");
        Persona persona2 = new Persona("Pedro");
        Persona persona3 = new Persona("Maria");
        Lista lista = new Lista();
        lista.agregar(persona1);
        lista.agregar(persona3);
        lista.agregar(persona2);        
        lista.mostrarPersonas();
    }
}