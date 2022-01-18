/******************************************************************
MiRadio.java
Clase que implementa la interfaz de radio.

@since	17/1/2022
******************************************************************/
public class MiRadio implements Radio{

    public MiRadio(){}
    
    boolean on = false;
    boolean frequency = false;
    double station;
    double[] savedStationsAM = {530,540,550,560,570,580,590,600,610,620,630,640};

    @Override
    public boolean isOn() {
                
        return on;
    }

    @Override
    public void turnOnOff() {
        on= !on;        
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
        return frequency;
    }

    @Override
    public void switchAMFM() {
        frequency = !frequency;
        // TODO Auto-generated method stub
        
    }
    
}
