package validadorCorrelativas;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    /*
    Materia tiene dos atributos y un metodo que indica si el
    alumno puede cursar la materia
     */

    /*
    Mi archivo inscripciones.csv es asi:
    Juan;1;Programacion 2;2 -> Nombre,nro lejago,m
    Belen;2;Programacion 1;1
     */
    private String id;
    private String nombre;
    private List<Materia> correlativas; //Coleccion de materia que se llama correlativas

    public Materia(String nombre) {
        /*
        Constructor de la clase materia, debo inicializar la lista

         */
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }
    /*
    Metodo para agregar correlativas a la coleccion
     */
    public void agregarCorrelativas(Materia correlativa) {
        this.correlativas.add(correlativa); //Agrego a la coleccion lo que llega por parametro

    }
    public boolean puedeCursar(Alumno alumno) {
        /*
        El alumno puede cursar la materia si cumple todas las
        correlativas necesarias.
        Yo tengo una coleccion de correlativas, por lo tanto
        podemos utilizar el metodo allMatch

        Por cada elemento de mi coleccion de correlativas, me voy a
        fijar si el alumno la tiene
         */
        return this.correlativas.stream().allMatch(materiaCorrelativa -> alumno.tenesCorrelativa(materiaCorrelativa));
    }

    public boolean tenesCorrelativas() {
        /*
        Para saber esto, tenemos que fijarnos si la coleccion de
        materias correlativas NO esta vacia. Si esta vacia es porque
        no hay correlativas
         */
        return !this.correlativas.isEmpty(); //isEmpty significa que esta vacia, por eso lo negamos
    }
    @Override
    public String toString() {
        return this.nombre;
    }
}
