package validadorCorrelativas;

import java.time.LocalDate;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;
    private LocalDate fecha; //LocalDate permite representar la fecha

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = LocalDate.now(); //Fecha actual utilizamos el .now()
    }
    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    /*
    Inscripcion tiene un metodo para saber si la materia esta aprobada
     */
    public boolean aprobada() {
        /*
        ¿Como sabemos si la inscripcion esta aceptada?
        La inscripcion esta aceptada si la materia No tiene correlativas
        o si la materia tiene correlativas y el alumno cumple con
        todas ellas
         */
        return  !this.materia.tenesCorrelativas() || this.materia.puedeCursar(this.alumno);
    }

    public String leyendaEstado() {
        return this.aprobada()?"Aprobada" : "Rechazada";
        /*
        Operador ternario:
        Si esta aprobada devuelve "Aprobada" sino "Rechazada"
         */
    }
}
