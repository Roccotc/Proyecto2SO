
package Logica;

public class Proceso {
    
    private int id;
    private String nombre;
    private int MaxCantRecursos [] = new int[150] ;
    
    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getMaxCantRecursos() {
        return MaxCantRecursos;
    }

    public void setMaxCantRecursos(int[] MaxCantRecursos) {
        this.MaxCantRecursos = MaxCantRecursos;
    }
    
    //Constructor
    public Proceso(int id, String nombre, int[] MaxCantRecursos) {
        this.id = id;
        this.nombre = nombre;
        this.MaxCantRecursos = MaxCantRecursos;
    }

    public Proceso() {
    }

    
    
}
