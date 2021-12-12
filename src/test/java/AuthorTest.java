/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        Rating testRating1 = new RatingBuilder().setValue(3).setDescription("Test1").createRating();
        Rating testRating2 = new RatingBuilder().setValue(10).setDescription("Test2").createRating();
        Rating testRating3 = new RatingBuilder().setValue(10).setDescription("Test3").createRating();
        Rating testRating4 = new RatingBuilder().setValue(9).setDescription("Test4").createRating();
        
        List<Rating> testRatings1 = new ArrayList<>();
        List<Rating> testRatings2 = new ArrayList<>();
        List<Rating> testRatings3 = new ArrayList<>();
        testRatings1.add(testRating1);
        testRatings1.add(testRating2);
        testRatings2.add(testRating2);
        testRatings3.add(testRating4);
        Book book1 = new BookBuilder().setTitle("testTitle1").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre1").setRatings(testRatings1).createBook();
        Book book2 = new BookBuilder().setTitle("testTitle2").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre2").setRatings(testRatings2).createBook();
        Book book3 = new BookBuilder().setTitle("testTitle3").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre3").setRatings(testRatings3).createBook();
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        author = new AuthorBuilder().setName("testName").setLastName("testLastName").setBibliography(books).createAuthor();
    }

    @Test
    public void shouldAddBook() {
//      when
        author.addBook(new BookBuilder().setTitle("testTitle1").setReleaseDate(LocalDate.of(2000, 01, 01)).setGenre("testGenre").setRatings(null).createBook());
//      then
        assertEquals(4, author.getBibliography().size(), 0.01, "Succesfull adition of a book");
    }
    
    @Test
    public void ShouldReturnBibliographySortedByRatingDescending(){
//      when
        List<Book> sortedList = author.getBibliographySortedByRatingDescending();
        List<Double> sortedAverageRatings = new ArrayList<>();
        for(Book book : sortedList){
            sortedAverageRatings.add(book.getAverageRating());
        }
//      then
        assertTrue(sortedAverageRatings.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).equals(sortedAverageRatings),"List not sorted in a correct order");
        
    }

}
