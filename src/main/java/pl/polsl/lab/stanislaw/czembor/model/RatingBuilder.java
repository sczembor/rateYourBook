/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.stanislaw.czembor.model;

import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;


public class RatingBuilder {

    private int value;
    private String description;

    public RatingBuilder() {
    }

    public RatingBuilder setValue(int value) {
        this.value = value;
        return this;
    }

    public RatingBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Rating createRating() throws RatingException{
        return new Rating(value, description);
    }
    
    
}
