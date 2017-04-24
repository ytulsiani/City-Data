package fxapp;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Mahati on 4/23/2017.
 */
public class POIReport {
    private SimpleStringProperty poiLocation = new SimpleStringProperty();
    private SimpleStringProperty city = new SimpleStringProperty();
    private SimpleStringProperty state = new SimpleStringProperty();
    private SimpleStringProperty moldMin = new SimpleStringProperty();
    private SimpleStringProperty moldAvg = new SimpleStringProperty();
    private SimpleStringProperty moldMax = new SimpleStringProperty();
    private SimpleStringProperty aqMin = new SimpleStringProperty();
    private SimpleStringProperty aqAvg= new SimpleStringProperty();
    private SimpleStringProperty aqMax = new SimpleStringProperty();
    private SimpleStringProperty numDP = new SimpleStringProperty();
    private SimpleStringProperty flagged = new SimpleStringProperty();

    public POIReport(String poiLocation1, String city1, String state1, String moldMin1,
                     String moldAvg1, String moldMax1, String aqMin1, String aqAvg1, String aqMax1,
                     String numDP1, String flagged1) {
        poiLocation.set(poiLocation1);
        city.set(city1);
        state.set(state1);
        moldMin.set(moldMin1);
        moldAvg.set(moldAvg1);
        moldMax.set(moldMax1);
        aqMin.set(aqMin1);
        aqAvg.set(aqAvg1);
        aqMax.set(aqMax1);
        numDP.set(numDP1);
        flagged.set(flagged1);
    }
    public SimpleStringProperty getPOILocation() {
        return poiLocation;
    }
    public SimpleStringProperty getCity() {
        return city;
    }
    public SimpleStringProperty getState() {
        return state;
    }
    public SimpleStringProperty getMoldMin() {
        return moldMin;
    }
    public SimpleStringProperty getMoldAvg() {
        return moldAvg;
    }
    public SimpleStringProperty getMoldMax() {
        return moldMax;
    }
    public SimpleStringProperty getAQMin() {
        return aqMin;
    }
    public SimpleStringProperty getAQAvg() {
        return aqAvg;
    }
    public SimpleStringProperty getAQMax() {
        return aqMax;
    }
    public SimpleStringProperty getNumDP() {
        return numDP;
    }
    public SimpleStringProperty getFlagged() {
        return flagged;
    }
}
