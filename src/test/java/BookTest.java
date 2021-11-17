/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;
import pl.polsl.lab.stanislaw.czembor.model.Book;
import pl.polsl.lab.stanislaw.czembor.model.Rating;
import pl.polsl.lab.stanislaw.czembor.model.RatingBuilder;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.lab.stanislaw.czembor.model.BookBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 *
 * @author stani
 */
public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() throws RatingException {
//      given
        Rating testRating1 = new RatingBuilder().setValue(7).setDescription("Test1").createRating();
        Rating testRating2 = new RatingBuilder().setValue(8).setDescription("Test2").createRating();
        List<Rating> testRatings = new ArrayList<>();
        testRatings.add(testRating1);
        testRatings.add(testRating2);
        book = new BookBuilder().setTitle("testTitle").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre").setRatings(testRatings).createBook();
    }
    
    @Test
    public void testAverageRating(){
//      when
//      then
        assertEquals(7.5, book.getAverageRating(), 0.01, "test");
    }
    
    @Test
    public void testAddRating() throws RatingException{
//      when
        Rating testRating3 = new RatingBuilder().setValue(5).setDescription("Test3").createRating();
        book.addRating(testRating3);
//      then
        assertEquals(3,book.getRatings().size(),0.01,"test");
    }
    
    @ParameterizedTest
//      given
    @CsvSource({"3, 4, 5 ,4.0", "1, 2, 3, 2.0", "5, 3, 10, 6.0"})
    void shouldGenerateTheExpectedUppercaseValue(int rating1,int rating2, int rating3 , double expectedAverage) throws RatingException {
//      when
        List<Rating> testRatings = new ArrayList<>();
        testRatings.add( new RatingBuilder().setValue(rating1).setDescription("test").createRating());
        testRatings.add( new RatingBuilder().setValue(rating2).setDescription("test").createRating());
        testRatings.add( new RatingBuilder().setValue(rating3).setDescription("test").createRating());
        Book book = new BookBuilder().setTitle("testTitle").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre").setRatings(testRatings).createBook();
//      then
        assertEquals(expectedAverage, book.getAverageRating(), "Succesfull average rating calculation");
    }
    
    
   
    
}
