package com.edu.restwebapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_id")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

//    @Override
//    public String toString() {
//        return "Genre{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", book=" + getBooksName(books) +
//                '}';
//    }
//
//    private String getBooksName(List<Book> books) {
//        String returnData = "";
//        while (books.iterator().hasNext()) {
//            returnData.concat(books.iterator().next().getTitle() + ",");
//        }
//        return returnData;
//    }

    public Genre() {
    }

//    public Genre(Long id, String name, String description) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//    }
//
//    public Genre(Long id, String name, String description, List<Book> books) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.books = books;
//    }
}
