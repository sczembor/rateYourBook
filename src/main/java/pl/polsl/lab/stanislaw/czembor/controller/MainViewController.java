package pl.polsl.lab.stanislaw.czembor.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;
import pl.polsl.lab.stanislaw.czembor.model.Author;
import pl.polsl.lab.stanislaw.czembor.model.Book;
import pl.polsl.lab.stanislaw.czembor.model.BookBuilder;
import pl.polsl.lab.stanislaw.czembor.model.Rating;
import pl.polsl.lab.stanislaw.czembor.view.MainView;

/**
 *
 * @author stani
 */
public class MainViewController {

    private MainView view;
    private List<Author> model;
    private String name;
    private String lastName;
    private Integer option;

    public enum Option {
        Browse, Rate, Add, Exit
    };

    /**
     * Constructor
     *
     * @param view reference to the controller's view
     * @param model reference to the controller's model
     */
    public MainViewController(MainView view, List<Author> model) {
        this.view = view;
        this.model = model;
        this.name = "";
        this.lastName = "";

    }

    /**
     * Main view getter
     *
     * @return returns a reference to the main view
     */
    public MainView getView() {
        return view;
    }

    /**
     * Main view setter
     *
     * @param view reference to the main view
     */
    public void setView(MainView view) {
        this.view = view;
    }

    /**
     * Model getter
     *
     * @return reference to the controller's model
     */
    public List<Author> getModel() {
        return model;
    }

    /**
     * Model setter
     *
     * @param model reference to the controller's model
     */
    public void setModel(List<Author> model) {
        this.model = model;
    }

    /**
     * Method that updates the view by invoking the display method
     */
    public void updateView() {
        Author author = this.findAutohrByName(this.name);
        if (author == null) {
            view.displayOutput("Author not found");
        } else {
            List<Book> books = author.getBibliography();
            if (books == null) {
                view.displayOutput("No books found");
            } else {
                books.forEach(book -> {
                    String title = book.getTitle();
                    String rating = String.valueOf(book.getAverageRating());
                    view.displayOutput("title:" + title + ", average rating:" + rating);
                });
            }
        }
    }

    /**
     * Method that finds the author by its name
     */
    private Author findAutohrByName(String name) {
        for (Author author : model) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }

    /**
     * Method that displays console input to the user
     */
    public void displayBrowseInput() {
        Scanner in = new Scanner(System.in);
        while (this.name.isEmpty()) {
            System.out.println("Enter author's name:");
            this.name = in.nextLine();
        }
        while (this.lastName.isEmpty()) {
            System.out.println("Enter author's last name:");
            this.lastName = in.nextLine();
        }
    }

    public void displayAddInput() {
        Scanner in = new Scanner(System.in);
        while (this.name.isEmpty()) {
            System.out.println("Enter author's name:");
            this.name = in.nextLine();
        }
        while (this.lastName.isEmpty()) {
            System.out.println("Enter author's last name:");
            this.lastName = in.nextLine();
        }
        String bookTitle = "";
        while (bookTitle.isEmpty()) {
            System.out.println("Enter book's name:");
            bookTitle = in.nextLine();
        }
        String releaseDate = "";
        while (releaseDate.isEmpty()) {
            System.out.println("Enter book's release date (yyyy-mm-dd):");
            releaseDate = in.nextLine();
        }
        String genre  = "";
        while(genre.isEmpty()) {
            System.out.println("Enter book's genre:");
            genre = in.nextLine();
        }
        Author author = this.findAutohrByName(this.name);
        author.addBook(new BookBuilder().setTitle(bookTitle).setReleaseDate(LocalDate.parse(releaseDate)).setGenre(genre).setRatings(null).createBook());
    }

    /**
     * Method that displays console input to the user
     */
    public void displayRateInput() {
        Scanner in = new Scanner(System.in);
        String bookName = "";
        String rateValue = "";
        String rateDescription = "";
        while (bookName.isEmpty()) {
            System.out.println("Enter book's name:");
            bookName = in.nextLine();
        }
        while (rateValue.isEmpty()) {
            System.out.println("Enter rate value (from 1 to 10):");
            rateValue = in.nextLine();
        }
        while (rateDescription.isEmpty()) {
            System.out.println("Enter short a review :");
            rateDescription = in.nextLine();
        }
        try {
            var newRating = new Rating(Integer.parseInt(rateValue), rateDescription);
        } catch (RatingException e) {
            System.out.println(e);
        }
    }

    public void displayMenu() {
        Scanner in = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("-----RateYourBook----\n0.Browse Book\n1.Rate Book\n2.Add Book\n3.Exit\nChoose option:");
            this.option = Integer.parseInt(in.nextLine());
            if (option <= 3 && option >= 0) {
                Option optionEnum = Option.values()[option];
                switch (optionEnum) {
                    case Browse:
                        this.displayBrowseInput();
                        isTrue = false;
                        break;
                    case Rate:
                        this.displayRateInput();
                        isTrue = false;
                        break;
                    case Add:
                        this.displayAddInput();
                        isTrue = false;
                        break;
                    case Exit:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Input!");
                }
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }

}
