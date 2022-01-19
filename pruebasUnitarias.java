import junit.framework.TestCase;


public class pruebasUnitarias extends TestCase{
    Radio MiRadio=new MiRadio();

    //Prueba para demostrar que enciende
    public void testEncendido(){
        MiRadio.turnOnOff();

        assertEquals(true, MiRadio.isOn());
    }

    //Prueba para demostrar que se apaga
    public void testApagado(){
        MiRadio.turnOnOff();
        MiRadio.turnOnOff();

        assertEquals(false, MiRadio.isOn());
    }

     //Prueba de fallo de encendido
     public void testEncendidoError(){
        MiRadio.turnOnOff();

        assertEquals(false, MiRadio.isOn());
    }

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

     //Prueba de cambio de FM a AM PERO ERRONEA
     public void testCambiofrecuenciaError(){
        MiRadio.switchAMFM();

        assertEquals(false, MiRadio.getFrequency());
    }
    //Prueba en frecuencia FM que aumenta la emisora
    public void testCambioEmisoraMayor(){
        MiRadio.nextStation(MiRadio.getFrequency());

        assertEquals(88.1, MiRadio.getStation());
    }

    //Prueba en frecuencia AM que baja la emisora y que al final del DIAL cambia
    public void testCambioEmisoraMenor(){
        MiRadio.switchAMFM();
        MiRadio.prevStation(MiRadio.getFrequency());

        assertEquals(1610.0, MiRadio.getStation());
    }
    //Prueba que la frecuencia no es la correcta y por lo tanto no va a cambiar la emisora (ERROR)
    public void testCambioEmisoraMenorError(){
        
        MiRadio.prevStation(MiRadio.getFrequency());

        assertEquals(1610.0, MiRadio.getStation());
    }
    

}
