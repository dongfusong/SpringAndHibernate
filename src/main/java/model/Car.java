package model;

/**
 * Created by Thoughtworks on 15/9/6.
 */
public class Car {
    private String name;

    private Address address;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
