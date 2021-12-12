package pl.polsl.lab.stanislaw.czembor.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Model class to represent author of a book.
 *
 * @author stani
 */
public class Author {

    private String name;
    private String lastName;
    private List<Book> bibliography;

    /**
     * Author Constructor
     *
     * @param name name of the Author
     * @param lastName last name of the Author
     * @param bibliography list of the author's books
     */
    public Author(String name, String lastName, List<Book> bibliography) {
        this.name = name;
        this.lastName = lastName;
        this.bibliography = bibliography;
    }

    /**
     * Name of Author getter
     *
     * @return name of Author
     */
    public String getName() {
        return name;
    }
    
    public void deleteBook(String title){
        bibliography.removeIf(book -> book.getTitle().equals(title));
    }
    

    /**
     * Name of Author setter
     *
     * @param name name of the Author
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Last name of Author getter
     *
     * @return last name of Author
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * LastName of Author setter
     *
     * @param lastName last name of the Author
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Bibliography for Author getter
     *
     * @return A list of objects of a Book class
     */
    public List<Book> getBibliography() {
        if (bibliography.isEmpty()) {
            return null;
        } else {
            return bibliography;    
        }
    }

    /**
     * Returns sorted bibliography
     *
     * @return A sorted list of objects of a Book class in descending order
     * based on average rating
     */
    public List<Book> getBibliographySortedByRatingDescending() {
        return bibliography.stream()
                .sorted((o1, o2) -> {
                    if (o1.getAverageRating() == o2.getAverageRating()) {
                        return o1.getTitle().compareTo(o2.getTitle());
                    } else if (o1.getAverageRating() > o2.getAverageRating()) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .collect(Collectors.toList());

    }

    /**
     * Bibliography for Author setter
     *
     * @param bibliography A list of objects of a Book class
     */
    public void setBibliography(List<Book> bibliography) {
        this.bibliography = bibliography;
    }

    /**
     * Add book to author's bibliography
     *
     * @param book An object of a Book class
     */
    public void addBook(Book book) {
        this.bibliography.add(book);
    }

}
