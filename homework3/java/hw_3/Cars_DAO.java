package hw_3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cars_DAO {

    private Connection connection;
    public static final String SELECT = "SELECT * FROM cars;";
    public static final String INSERT = "insert into cars (model, max_speed) values(?, ?)";
    public static final String UPDATE = "update cars set model = ?, max_speed = ? where car_id = ?";
    public static final String DELETE = "delete from cars where car_id = ?";

    public Cars_DAO() {
        this.connection = ConnectionUtil.getConnection();
    }

    public List<Cars> get(){
        List<Cars> cars = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while(resultSet.next()){
                cars.add(Cars.of(resultSet));
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException("Can't use data from table");
        }
        return cars;
    }

    public int insert(String model, int max_speed){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, model);
            preparedStatement.setInt(2, max_speed);
            preparedStatement.executeUpdate();
            ResultSet key = preparedStatement.getGeneratedKeys();
            key.next();
            return key.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException("Can't insert data into table");
            return 0;
        }
    }

    public void update(int id, String model, int max_speed){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, model);
            preparedStatement.setInt(2, max_speed);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException("Can't update data into table");
        }
    }

    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException("Can't delete data into table");
        }
    }

}
