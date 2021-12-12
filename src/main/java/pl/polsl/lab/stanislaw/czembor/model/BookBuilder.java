
package pl.polsl.lab.stanislaw.czembor.model;

import java.time.LocalDate;
import java.util.List;


public class BookBuilder {

    private String title;
    private LocalDate releaseDate;
    private String genre;
    private List<Rating> ratings;

    public BookBuilder() {
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public BookBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public BookBuilder setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public Book createBook() {
        return new Book(title, releaseDate, genre, ratings);
    }
    
}
