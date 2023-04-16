package validadorCorrelativas;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    /*
    Alumno tiene 3 atributos y un metodo que indica si esta aprobada
     */
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String legajo) {
        /*
        CONSTRUCTOR
        Cada vez que alguien quiera instanciar el alumno, debe
        poner el nombre y el legajo
         */
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
    public void agregarMateriaAprobada(Materia materia) {
        /*
        Metodo para agregar una materia a la coleccion de
        materiasAprobadas
         */
        this.materiasAprobadas.add(materia);
    }

    public boolean tenesCorrelativa(Materia materiaCorrelativa) {
        /*
        Tengo que fijarme si la materia que estoy recibiendo
        por parametro, esta en la coleccion de materias aprobadas
        Utilizamos un contains
         */
        return this.materiasAprobadas.contains(materiaCorrelativa);
    }
    @Override //Para cambiar el comportamiento del metodo toString(Ya que viene con java)
    public String toString() {
        return this.nombre;
    }
}
