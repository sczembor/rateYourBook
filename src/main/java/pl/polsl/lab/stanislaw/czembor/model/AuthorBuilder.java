
package pl.polsl.lab.stanislaw.czembor.model;

import java.util.List;


public class AuthorBuilder {

    private String name;
    private String lastName;
    private List<Book> bibliography;

    public AuthorBuilder() {
    }

    public AuthorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AuthorBuilder setBibliography(List<Book> bibliography) {
        this.bibliography = bibliography;
        return this;
    }

    public Author createAuthor() {
        return new Author(name, lastName, bibliography);
    }
    
}
