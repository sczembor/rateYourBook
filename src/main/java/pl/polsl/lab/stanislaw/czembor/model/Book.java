package pl.polsl.lab.stanislaw.czembor.model;

import java.util.List;
import java.time.LocalDate;

/**
 * Model class to represent books
 *
 * @author stani
 */
public class Book {

    private String title;
    private LocalDate releaseDate;
    private String genre;
    private List<Rating> ratings;

    /**
     * Book Constructor
     *
     * @param title title of the book
     * @param releaseDate release date of the book
     * @param genre genre of the book
     * @param ratings list of ratings of the book
     */
    public Book(String title, LocalDate releaseDate, String genre, List<Rating> ratings) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.ratings = ratings;
    }

    /**
     * Book Constructor
     *
     * @param title title of the book
     */
    public Book(String title) {
        this.title = title;
    }

    /**
     * Book title getter
     *
     * @return title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Book title setter
     *
     * @param title title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Book release date getter
     *
     * @return release date of the book
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Book release date setter
     *
     * @param releaseDate release date of the book
     */
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Book genre getter
     *
     * @return genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Book genre setter
     *
     * @param genre genre of the book
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Book ratings getter
     *
     * @return List of the book's ratings
     */
    public List<Rating> getRatings() {
        return ratings;
    }

    /**
     * Average book rating value
     *
     * @return average of the book's ratings
     */
    public double getAverageRating() {
        if (ratings == null) {
            return 0;
        }
        int sum = 0;
        for (Rating rating : ratings) {
            sum = sum + rating.getValue();
        }
        return (double) sum / (double) ratings.size();
    }

    /**
     * Book ratings setter
     *
     * @param ratings List of the book's ratings
     */
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
    
    /**
     * Method to add a rating to the ratings list
     * 
     * @param rating Rating object
     */
    public void addRating(Rating rating){
        this.ratings.add(rating);
    }

}
