package hw_3;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cars {
    private int car_id;
    private String model;
    private int max_speed;

    public static Cars of(ResultSet resultSet) {
        Cars car = new Cars();
        try {
            car.setCar_id(resultSet.getInt("car_id"));
            car.setModel(resultSet.getString("model"));
            car.setMax_speed(resultSet.getInt("max_speed"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }


    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "car_id=" + car_id +
                ", model='" + model + '\'' +
                ", max_speed=" + max_speed +
                '}';
    }
}
