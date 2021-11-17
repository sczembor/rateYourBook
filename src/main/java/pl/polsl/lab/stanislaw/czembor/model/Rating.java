/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.stanislaw.czembor.model;

import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;

/**
 * Model class to represent rating of a book
 *
 * @author stani
 */
public class Rating {

    private int value;
    private String description;

    /**
     * Rating Constructor
     *
     * @param value value of the rating
     * @param description short review/description of the rating
     * @throws RatingException
     */
    public Rating(int value, String description) throws RatingException {
        if (value > 10 || value < 1) {
            throw new RatingException("Rating value must be between 1 and 10");
        }
        this.value = value;
        this.description = description;
    }

    /**
     * Rating value getter
     *
     * @return value of the rating
     */
    public int getValue() {
        return value;
    }
        /**
     * Rating value getter in double
     *
     * @return value of the rating in double precision
     */
    public double getValueInDouble(){
        return (double) value;
    }

    /**
     * Rating value setter
     *
     * @param value value of the rating
     * @throws RatingException
     */
    public void setValue(int value) throws RatingException {
        if (value > 10 || value < 1) {
            throw new RatingException("Rating value must be between 1 and 10");
        }
        this.value = value;
    }

    /**
     * Rating description getter
     *
     * @return description of the rating
     */
    public String getDescription() {
        return description;
    }

    /**
     * Rating description setter
     *
     * @param description description of the rating
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
