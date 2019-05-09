package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name="properties")
public class Property {
//CREATE TABLE properties
//(
//    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
//    city VARCHAR(100) NOT NULL,
//    state VARCHAR(25) NOT NULL,
//    zip_code INT NOT NULL,
//    value INT,
//    bedrooms INT,
//    bathrooms DOUBLE,
//    garage BOOLEAN,
//    square_footage INT,
//    PRIMARY KEY (id)
//);

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 25)
    private String state;

    @Column(nullable = false, name="zip_code")
    private int zipCode;

    @Column
    private int value;

    @Column
    private int bedrooms;

    @Column
    private double bathrooms;

    @Column
    private boolean garage;

    @Column(name="square_footage")
    private int squareFootage;


}
