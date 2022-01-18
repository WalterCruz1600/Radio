
/**
 * Defines all the methods that a Radio should have.
 */
public interface Radio {
    /**
     * Get the current state of the radio.
     * @return boolean indicating if the Radio is on.
     */
    public boolean isOn();
    /**
     * Switch the on state of the Radio.
     */
    public void turnOnOff();
    /**
     * Move forward into the station dial.
     * @param station boolean indicating if the frequency is AM or FM. true = AM
     */
    public void nextStation(boolean station);
     /**
     * Move backwards into the station dial.
     * @param station boolean indicating if the frequency is AM or FM. true = AM.
     */
    public void prevStation(boolean station);
    /**
     * Get the current station selected.
     * @return double indicating the current station selected.
     */
    public double getStation();
    /**
     * Save a station on the favorites array.
     * @param position index indicating where to store the station.
     * @param station double indicating the station.
     */
    public void saveStation(int position, double station);
    /**
     * Get a saved station on the favorites array
     * @param position index indicating which station to pick.
     */
    public double getSavedStation(int position);
    /**
     * Get the current frequency.
     * @return boolean indicating if it is AM or FM. true = AM.
     */
    public boolean getFrequency();
    /**
     * Switch the frequency selected.
     */
    public void switchAMFM();
}