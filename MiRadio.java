/******************************************************************
MiRadio.java
Clase que implementa la interfaz de radio.

@since	17/1/2022
******************************************************************/
public class MiRadio implements Radio{

    public MiRadio(){}
    
    boolean on = false;

    @Override
    public boolean isOn() {
                
        return on;
    }

    @Override
    public void turnOnOff() {
        if(on){
            on=false;
        }else{
            on=true;
        }        
    }

    @Override
    public void nextStation(boolean station) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void prevStation(boolean station) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getStation() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void saveStation(int position, double station) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getSavedStation(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getFrequency() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void switchAMFM() {
        // TODO Auto-generated method stub
        
    }
    
}
