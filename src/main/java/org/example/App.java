package org.example;

import validadorCorrelativas.Alumno;
import validadorCorrelativas.Inscripcion;
import validadorCorrelativas.Materia;
import validadorCorrelativas.excepciones.AlumnoNoExisteException;
import validadorCorrelativas.excepciones.MateriaNoExisteException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        System.out.println( "Comenzar ejercicio integrador" );
        /*
        Ahora debo leer un archivo inscripciones.csv
        Y otro archivo que deberia tener el alumno y la materia
        que ya curso

         */
       List<Materia> materias = materias();
       List<Alumno> alumnos = alumnos();

       //Lectura del archivo inscripciones.csv
        String rutaArchivo = "C:\\Users\\Lalo\\IdeaProjects\\Clase10-EjercicioIntegrador\\inscripciones.csv";

        for(String unaLineaDeInscripcion : Files.readAllLines(Paths.get(rutaArchivo))) {
            String[] datos = unaLineaDeInscripcion.split(";");
            /*
            Ahora me separara el string en un array separando cada vez que
            encuentra un ;
             */

            Inscripcion inscripcion = generarInscripcionAPartirDeDatos(datos,alumnos,materias);
            mostrarPorPantallaEstadoDeInscripcion(inscripcion);


            //Deberiamos escribir otro archivo

        }

    }

    private  static void mostrarPorPantallaEstadoDeInscripcion(Inscripcion inscripcion) {
        System.out.println("La inscripcion del alumno " + inscripcion.getAlumno() + " a la materia " + inscripcion.getMateria() + " fue " + inscripcion.leyendaEstado());
    }
    private static Inscripcion generarInscripcionAPartirDeDatos(String[] datos,List<Alumno> alumnos, List<Materia> materias) {
       Alumno alumno = buscarAlumnoPorLegajo(datos[1],alumnos); //El legajo esta en la posicion[1]
       Materia materia = buscarMateriaPorId(datos[3],materias); //en datos[3] se encuentra el id de la materia

        Inscripcion inscripcion = new Inscripcion(alumno,materia);
        return inscripcion;
    }

    private static Materia buscarMateriaPorId(String id, List<Materia> materias) {
        Optional<Materia> supuestaMateria = materias.stream().filter(m -> m.getId().equals(id)).findFirst();

        if(!supuestaMateria.isPresent()) {
            throw new MateriaNoExisteException();

        }

        return supuestaMateria.get();
    }
    private static Alumno buscarAlumnoPorLegajo(String legajo, List<Alumno> alumnos) {
        /*
        Ahora recorro la coleccion de alumnos, y me voy a quedar con
        aquellos que el numero de legajo coincida con el que haya venido
        en el archivo
         */
        Optional<Alumno> supuestoAlumno = alumnos.stream().filter(a -> a.getLegajo().equals(legajo)).findFirst();
        /*
        El metodo findFirst me hace asegurar que existe el alumno
         */
        if(!supuestoAlumno.isPresent()) {
            //Lanzo excepcion y digo que el legajo no coincide con ningun alumno
           throw  new AlumnoNoExisteException("No se encontraron coincidencias para el legajo " + legajo);
        }
        Alumno alumno = supuestoAlumno.get(); //obtengo el alumno que encontro
        return alumno;
    }
    private static List<Materia> materias() {
        /*
        Lo que deberiamos hacer aca es leer un archivo con todas las
        materias
         */
        List<Materia> materias = new ArrayList<>();
        Materia progra1 = new Materia("Programacion1");

        progra1.setId("1");
        Materia progra2 = new Materia("Programacion2");
        progra2.setId("2");

        /*
        Le voy a agregar correlativas a una materia
         */
        progra2.agregarCorrelativas(progra1);
        /*
        Ahora agrego las materias a la coleccion
         */
        materias.add(progra1);
        materias.add(progra2);
        return  materias; //Devuelvo la coleccion
    }

    private static List<Alumno> alumnos() {
        /*
        Simulo que leo un archivo de alumnos
         */
        List<Alumno> alumnos = new ArrayList<>();
        Alumno juan = new Alumno("Juan","3232");
        Alumno belen = new Alumno("Belen","51321");
        alumnos.add(juan);
        alumnos.add(belen);
        return  alumnos;
    }
}
