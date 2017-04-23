package fxapp;

import javafx.beans.property.SimpleStringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by Yash on 4/23/2017.
 */
public class DataPoint {
    private SimpleStringProperty locationName = new SimpleStringProperty();
    private SimpleStringProperty dataType = new SimpleStringProperty();
    private SimpleStringProperty dataVal = new SimpleStringProperty();
    private SimpleStringProperty dateTime = new SimpleStringProperty();
    public DataPoint(String locationName1, String dataType1, String dataVal1, String dateTime1) {
        locationName.set(locationName1);
        dataType.set(dataType1);
        dataVal.set(dataVal1);
        dateTime.set(dateTime1);

    }
    public SimpleStringProperty getLocation() {
        return locationName;
    }
    public SimpleStringProperty getDataType() {
        return dataType;
    }
    public SimpleStringProperty getDataVal() {
        return dataVal;
    }
    public SimpleStringProperty getDateTime() {return dateTime;}

}
