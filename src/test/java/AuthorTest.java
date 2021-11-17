/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;
import pl.polsl.lab.stanislaw.czembor.model.Author;
import pl.polsl.lab.stanislaw.czembor.model.AuthorBuilder;
import pl.polsl.lab.stanislaw.czembor.model.Book;
import pl.polsl.lab.stanislaw.czembor.model.BookBuilder;
import pl.polsl.lab.stanislaw.czembor.model.Rating;
import pl.polsl.lab.stanislaw.czembor.model.RatingBuilder;

/**
 *
 * @author stani
 */
public class AuthorTest {
    private Author author;
    
     @BeforeEach
    public void setUp() throws RatingException {
//      given
        Rating testRating1 = new RatingBuilder().setValue(7).setDescription("Test1").createRating();
        Rating testRating2 = new RatingBuilder().setValue(8).setDescription("Test2").createRating();
        List<Rating> testRatings = new ArrayList<>();
        testRatings.add(testRating1);
        testRatings.add(testRating2);
        Book book = new BookBuilder().setTitle("testTitle").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre").setRatings(testRatings).createBook();
        List<Book> books = new ArrayList<>();
        books.add(book);
        author = new AuthorBuilder().setName("testName").setLastName("testLastName").setBibliography(books).createAuthor();
    }
    
    @Test
    public void   testAddBook(){
//      when
        author.addBook( new BookBuilder().setTitle("testTitle1").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre").setRatings(null).createBook());
//      then
        assertEquals(2,author.getBibliography().size(),0.01, "Succesfull adition of a book");
    }
    
}
