

/******************************************************************
MiRadio.java
Clase que implementa la interfaz de radio.

@since	17/1/2022
******************************************************************/
public class MiRadio implements Radio{

    public MiRadio(){}
    
    boolean on = false;
    boolean frequency = false;
    double stationAM=530;
    double stationFM=87.9;
    //Aquí se encuentran los botones para guardar emisoras
    //de la posición 0-11 son AM y de la 12-23 son FM
    double[] savedStations = {530,530,530,530,530,530,530,530,530,530,530,530,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9};

    @Override
    public boolean isOn() {
     //Este método solo indica si la radio está encendida o no
        return on;
    }

    @Override
    public void turnOnOff() {
        //Este método cambia el estado de encendido a apagado y viceversa
        on= !on;        
    }

    @Override
    public void nextStation(boolean frecuency) {

        if(frecuency){
            //Si es AM entonces avanza a la siguiente emisora con +10
            stationAM = stationAM+10;
            //Si sube más de la estación máxima entonces cambia a la emisora más baja 
            if(stationAM>1610){
                stationAM=530;
            }
        }else{
            //Si es FM entonces avanza a la siguiente emisora con +0.2
            stationFM = stationFM+0.2;
            //Si sube más de la estación máxima entonces cambia a la emisora más baja 
            if(stationFM>107.9){
                stationFM=87.9;
            }
        }
        
    }

    @Override
    public void prevStation(boolean frecuency) {
        
        if(frecuency){
            //Si es AM entonces retrocede a la emisora anterior con -10
            stationAM = stationAM-10;
            //Si baja más de la estación mínima entonces cambia a la emisora más alta 
            if(stationAM<530){
                stationAM=1610;
            }
        }else{
            //Si es FM entonces retrocede a la emisora anterior con -0.2
            stationFM = stationFM-0.2;
            //Si baja más de la estación mínima entonces cambia a la emisora más alta 
            if(stationFM<87.9){
                stationFM=107.9;
            }
        }
        
    }

    @Override
    public double getStation() {
        //En este caso se regresa la estación de emisora dependiendo de la frecuencia en la que esté
        //ya sea AM o FM
        if(frequency){    
            return stationAM;
        }else{
            stationFM=(double)Math.round(stationFM * 100d) / 100d;
            return stationFM;
        }
        
    }

    @Override
    public void saveStation(int position, double station) {
        if (position>0 && position<13) { //verifica que el valor sea valido (1-12), de lo contrario no hace nada
            if(frequency){ // si es AM
                position = position-1; //cambia los valores del indice de 1-12 a 0-11
            }else{ //si es FM
                position = position+12-1; //cambia los valores del indice de 1-12 a 12-23                
            }
            savedStations[position]=station; //guarda en savedStations en la posicion correspondiente
        }
    }

    @Override
    public double getSavedStation(int position) {
        double station = 0.0; //valor inicial donde se guarara el valor que devolvera       
        if (position>0 && position<13) {//verifica que el valor sea valido (1-12), de lo contrario no hace nada
            if(frequency){ //si es AM
                stationAM=savedStations[position-1]; //Busca la emisora en las posiciones 0-11 (AM)
                station = stationAM;
            }else{ //si es FM
                stationFM=savedStations[position+12-1]; //Busca la emisora en las posiciones 12-23 (FM)
                station = stationFM;          
            }
        }
        return station;
    }

    @Override
    public boolean getFrequency() {
        return frequency;       

    }

    @Override
    public void switchAMFM() {
        //Este método cambia de frecuencia AM a FM
        //AM es positivo y FM es negativo
        frequency = !frequency;
        
    }

    
    
}
