

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
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void saveStation(int position, double station) {
        // TODO Auto-generated method stub
        //Revisa si es de los botones de FM
        if(station<108.0&&station>87.6){
            //Si es FM los almacena en uno de los botones de FM
            savedStations[position]=station;
            
        //Revisa si es de los botones de AM
        }else if(station<1611&&station>529){

            //Si es AM los almacena en uno de los botones de AM
            savedStations[position]=station;
            
        }

    }

    @Override
    public double getSavedStation(int position) {
        // TODO Auto-generated method stub
        //revisa la posición para saber si es FM
        if(position>11){

           //Al momento de apachar el botón esa emisora empieza a sonar en la frecuencia en la que esté
            stationFM=savedStations[position];

        //revisa la posición para saber si es AM
        }else if(position<12){

            //Al momento de apachar el botón esa emisora empieza a sonar en la frecuencia en la que esté
            stationAM=savedStations[position];
            
        }

        return savedStations[position];
    }

    @Override
    public boolean getFrequency() {
        // TODO Auto-generated method stub
        //Este método regresa la frecuencia si es AM o FM
        return frequency;
    }

    @Override
    public void switchAMFM() {
        //Este método cambia de frecuencia AM a FM
        //AM es positivo y FM es negativo
        frequency = !frequency;
        // TODO Auto-generated method stub
        
    }

    
    
}
