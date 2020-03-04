package hw_3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cars_DAO cars_dao = new Cars_DAO();
        cars_dao.insert("model s", 280);
        cars_dao.insert("model s", 280);
        cars_dao.update(4, "model y", 230);
        cars_dao.delete(1);
        List<Cars> cars = cars_dao.get();
        System.out.println(cars);
    }
}
