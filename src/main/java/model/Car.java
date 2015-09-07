package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 15/9/6.
 */
public class Car {
    private String name;

    private Address address;

    public Car(String name) {
        this.name = name;
    }

    List<Address> carList = new ArrayList<Address>();

    @Override
    public String toString() {
        return "Car{" +
                "carList=" + carList +
                ", address=" + address +
                ", name='" + name + '\'' +
                '}';
    }
}
