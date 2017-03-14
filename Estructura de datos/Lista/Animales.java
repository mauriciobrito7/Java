public class Animales{
    private String nombre = new String();
    private String tipo = new String();
    private int edad;
    private String sexo = new String();

    public Animales(String nombre, String tipo, int edad, String sexo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getTipo(){
        return this.tipo;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getSexo(){
        return this.sexo;
    }
}