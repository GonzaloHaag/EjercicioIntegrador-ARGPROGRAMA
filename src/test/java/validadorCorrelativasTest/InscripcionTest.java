package validadorCorrelativasTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validadorCorrelativas.Alumno;
import validadorCorrelativas.Inscripcion;
import validadorCorrelativas.Materia;

public class InscripcionTest {

    /*
    Para no andar repitiendo tanto el nombre del alumno y de la
    materia, puedo inicializar atributos en mi test
     */
    private Alumno juan;
    private Materia programacion1;
    private Materia programacion2;
    @BeforeEach //Significa que se va a ejecutar antes de comenzar cualquier Test
    public void init() {
        this.juan = new Alumno("Juan","4224123"); //Debo pasarle nombre y nro de legajo
        this.programacion1 = new Materia("Programacion1");
        this.programacion2 = new Materia("Programacion2");

        /*
        A PROGRAMACION2 DEBO AGREGARLE PROGRAMACION1 COMO CORRELATIVA:
         */
        this.programacion2.agregarCorrelativas(this.programacion1);
    }
    @Test
    public void juanSePuedeAnotarAProgramacion1(){

        Inscripcion inscripcionDeJuanAProgra1 = new Inscripcion(this.juan,this.programacion1);

        /*
        El test debe pasar ya que programacion1 no tiene correlativas
         */
        Assertions.assertTrue(inscripcionDeJuanAProgra1.aprobada());

    }
    @Test
    public void juanNoSePuedeAnotarAProgra2() {

        Inscripcion inscripcionDeJuanAProgra2 = new Inscripcion(this.juan,this.programacion2);


        Assertions.assertFalse(inscripcionDeJuanAProgra2.aprobada());
        /*
        Este test va a pasar si aprobada nos devuelve false, ya que
        queremos que no se pueda a inscribir porque no tiene cursada
        programacion 1
         */


    }

    @Test
    public void juanSePuedeAnotarAProgra2() {

        /*
        Ahora se va a poder anotar a programacion2 porque le estamos
        diciendo que tiene aprobada programacion1
         */

        this.juan.agregarMateriaAprobada(this.programacion1);
        Inscripcion inscripcionDeJuanAProgra2 = new Inscripcion(this.juan,this.programacion2);


        Assertions.assertTrue(inscripcionDeJuanAProgra2.aprobada());
        /*
       Deberia pasar el test ya que juan tiene aprobada a programacion1
       y programacion1 es correlativa con programacion2
         */


    }
}
