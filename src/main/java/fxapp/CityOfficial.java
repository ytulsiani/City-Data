package fxapp;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Mahati on 4/23/2017.
 */
public class CityOfficial {
    private SimpleStringProperty username = new SimpleStringProperty();
    private SimpleStringProperty email = new SimpleStringProperty();
    private SimpleStringProperty city = new SimpleStringProperty();
    private SimpleStringProperty state = new SimpleStringProperty();
    private SimpleStringProperty title = new SimpleStringProperty();

    public CityOfficial(String username1, String email1, String city1, String state1, String title1) {
        username.set(username1);
        email.set(email1);
        city.set(city1);
        state.set(state1);
        title.set(title1);
    }
    public SimpleStringProperty getUsername() {
        return username;
    }
    public SimpleStringProperty getEmail() {
        return email;
    }
    public SimpleStringProperty getCity() {
        return city;
    }
    public SimpleStringProperty getState() {
        return state;
    }
    public SimpleStringProperty getTitle() {
        return title;
    }

}
