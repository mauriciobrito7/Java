import java.lang.Runnable;

public class EjemploLista{
    public static void main(String[] args){
        //Lista para pedidos de animales
        Lista lista = new Lista();
        //Pedidos de animales
        Animales leon = new Animales("leo","leon",3,"macho");
        Animales zorro = new Animales("Zepo","zorro",5,"macho");
        Animales vaca  = new Animales("Cow","vaca",1,"hembra");
        Animales mono = new Animales("monkey","mono",2,"hembra");
        Animales cebra = new Animales("rayitas","cebra",3,"hembra");
        Animales cerdo = new Animales("pig","cerdo",4,"macho");
        Animales pinguino = new Animales("Coco","pinguino",1,"macho");        
        
        //haciendo pedidos o enlistando a la lista de deseos
        lista.insertarAlInicio(leon);
        lista.insertarAlInicio(zorro);
        lista.insertarAlInicio(vaca);
        lista.insertarAlInicio(mono);
        lista.insertarAlInicio(cebra);
        lista.insertarAlInicio(cerdo);
        lista.insertarAlInicio(pinguino);
    
        lista.listar();
        lista.listar();
    }
}