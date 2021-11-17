package pl.polsl.lab.stanislaw.czembor.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pl.polsl.lab.stanislaw.czembor.model.Author;
import pl.polsl.lab.stanislaw.czembor.model.Book;
import pl.polsl.lab.stanislaw.czembor.controller.MainViewController;
import pl.polsl.lab.stanislaw.czembor.model.Author;
import pl.polsl.lab.stanislaw.czembor.model.Book;
import pl.polsl.lab.stanislaw.czembor.model.BookBuilder;
import pl.polsl.lab.stanislaw.czembor.model.Rating;
import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;
import pl.polsl.lab.stanislaw.czembor.model.AuthorBuilder;
import pl.polsl.lab.stanislaw.czembor.model.RatingBuilder;
import pl.polsl.lab.stanislaw.czembor.view.MainView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author stani
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Rating shiningRating1 = new RatingBuilder().setValue(7).setDescription("Great book").createRating();
            Rating shiningRating2 = new RatingBuilder().setValue(8).setDescription("Terrifying").createRating();

            List<Rating> ratingsShining = new ArrayList<>();
            ratingsShining.add(shiningRating1);
            ratingsShining.add(shiningRating2);
            Book shining = new BookBuilder().setTitle("Shining").setReleaseDate(LocalDate.of(1985, 05, 11)).setGenre("Horror").setRatings(ratingsShining).createBook();
            List<Book> books = new ArrayList<>();
            books.add(shining);
            Author king = new AuthorBuilder().setName("Steven").setLastName("King").setBibliography(books).createAuthor();
            List<Author> authors = new ArrayList<>();
            authors.add(king);

            MainView view = new MainView();
            MainViewController controller = new MainViewController(view, authors);
            controller.displayMenu();
            controller.updateView();
        } catch (RatingException e) {
            System.out.println(e);
        }
    }

}
