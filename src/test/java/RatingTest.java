/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;
import pl.polsl.lab.stanislaw.czembor.model.Rating;
import pl.polsl.lab.stanislaw.czembor.model.RatingBuilder;

/**
 * 
 * @author stani
 * 
 */
public class RatingTest {

    private Rating rating;

    @Test
    public void testUpperBoundryException() throws RatingException {
//      given
//      when
        rating = new RatingBuilder().setValue(11).setDescription("test").createRating();
//      then
        fail("An exception should be thron when value > 10");

    }

    @Test
    public void testLowerBoundryException() {
        try {
//      given
//      when
            rating = new RatingBuilder().setValue(-1).setDescription("test").createRating();
//       then
            fail("An exception should be thron when value < 0");
        } catch (RatingException e) {
        }
    }

    @Test
    public void testOfException() throws RatingException {
//      given
        rating = new RatingBuilder().setValue(5).setDescription("test").createRating();
        RatingException exception = assertThrows(
                RatingException.class,
                //      when
                () -> rating.setValue(-1));
//      then
        assertEquals("Rating value must be between 1 and 10", exception.getMessage());
    }

    @ParameterizedTest
//      given
    @CsvSource({"3,3.0", "1,1.0", "5,5.0"})
    void shouldReturnIntegerConvertedToDouble(int input, double expected) throws RatingException {
//      when
        rating = new RatingBuilder().setValue(input).setDescription("test").createRating();
//      then
        assertEquals(expected, rating.getValueInDouble(), "Succesfull int to double conversion");
    }

}
