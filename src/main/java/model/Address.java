package model;

import javax.persistence.Embeddable;

/**
 * Created by Thoughtworks on 15/9/5.
 */
@Embeddable
public class Address {
    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    private String street;
    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
