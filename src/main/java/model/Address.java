package model;

import javax.persistence.Embeddable;

/**
 * Created by Thoughtworks on 15/9/5.
 */
@Embeddable
public class Address {
    private String street;
    private String zipCode;
}
