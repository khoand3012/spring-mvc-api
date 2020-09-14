package com.edu.restwebapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_publishers")
public class BookPublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

//    @Column(name = "book_id")
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book_publishers")
//    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    public BookPublisher() {
    }

//    public BookPublisher(Long id, String name, String country) {
//        this.id = id;
//        this.name = name;
//        this.country = country;
//    }
//
//    public BookPublisher(Long id, String name, String country, List<Book> books) {
//        this.id = id;
//        this.name = name;
//        this.country = country;
//        this.books = books;
//    }
}
