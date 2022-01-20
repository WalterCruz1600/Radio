import org.junit.Test;
import org.junit.jupiter.api.io.TempDir;

import junit.framework.TestCase;


public class pruebasUnitarias extends TestCase{
    Radio MiRadio=new MiRadio();

    @Test
    //Prueba para demostrar que enciende
    public void testEncendido(){
        MiRadio.turnOnOff();

        assertEquals(true, MiRadio.isOn());
    }

    @Test
    //Prueba para demostrar que se apaga
    public void testApagado(){
        MiRadio.turnOnOff();
        MiRadio.turnOnOff();

        assertEquals(false, MiRadio.isOn());
    }
    @Test
     //Prueba de fallo de encendido
     public void testEncendidoError(){
        MiRadio.turnOnOff();

        assertEquals(false, MiRadio.isOn());
    }

    @Test
    //Prueba de cambio de FM a AM
    public void testCambiofrecuencia(){
        MiRadio.switchAMFM();

        assertEquals(true, MiRadio.getFrequency());
    }

    //Prueba de cambio de AM a FM
    public void testCambiofrecuencia2(){
        MiRadio.switchAMFM();
        MiRadio.switchAMFM();

        assertEquals(false, MiRadio.getFrequency());
    }

    @Test
     //Prueba de cambio de FM a AM PERO ERRONEA
     public void testCambiofrecuenciaError(){
        MiRadio.switchAMFM();

        assertEquals(false, MiRadio.getFrequency());
    }
    @Test
    //Prueba en frecuencia FM que aumenta la emisora
    public void testCambioEmisoraMayor(){
        MiRadio.nextStation(MiRadio.getFrequency());

        assertEquals(88.1, MiRadio.getStation());
    }

    @Test
    //Prueba en frecuencia AM que baja la emisora y que al final del DIAL cambia
    public void testCambioEmisoraMenor(){
        MiRadio.switchAMFM();
        MiRadio.prevStation(MiRadio.getFrequency());

        assertEquals(1610.0, MiRadio.getStation());
    }

    @Test
    //Prueba que la frecuencia no es la correcta y por lo tanto no va a cambiar la emisora (ERROR)
    public void testCambioEmisoraMenorError(){
        
        MiRadio.prevStation(MiRadio.getFrequency());

        assertEquals(1610.0, MiRadio.getStation());
    }

    @Test
    public void testSaveStation(){
        if (MiRadio.getFrequency()) {
            MiRadio.switchAMFM();
        }
        MiRadio.saveStation(2, 88.9);
        for (int i = 0; i < 8; i++) {
            MiRadio.nextStation(MiRadio.getFrequency());
            MiRadio.switchAMFM();
        }
        if (MiRadio.getFrequency()) {
            MiRadio.switchAMFM();
        }
        MiRadio.getSavedStation(2);

        assertEquals(88.9, MiRadio.getStation());
    }
    

}
