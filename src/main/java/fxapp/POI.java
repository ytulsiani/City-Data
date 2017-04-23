package fxapp;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by zackmudge on 4/23/17.
 */
public class POI {
    private SimpleStringProperty locationName = new SimpleStringProperty();
    private SimpleStringProperty flag = new SimpleStringProperty();
    private SimpleStringProperty dateFlagged = new SimpleStringProperty();
    private SimpleStringProperty zipCode = new SimpleStringProperty();
    private SimpleStringProperty city = new SimpleStringProperty();
    private SimpleStringProperty state = new SimpleStringProperty();

    public POI(String locationName1, String flag1, String dateFlagged1, String zipCode1, String city1, String state1) {
        System.out.println(locationName1);
        locationName.set(locationName1);
        System.out.println("HELOoOooooooo");
        flag.set(flag1);
        dateFlagged.set(dateFlagged1);
        zipCode.set(zipCode1);
        city.set(city1);
        state.set(state1);
    }
    public SimpleStringProperty getLocation() {
       return locationName;
    }
    public SimpleStringProperty getFlag() {
        return flag;
    }
    public SimpleStringProperty getDate() {
        return dateFlagged;
    }
    public SimpleStringProperty getZipcode() {
        return zipCode;
    }
    public SimpleStringProperty getCity() {
        return city;
    }
    public SimpleStringProperty getState() {
        return state;
    }

}
