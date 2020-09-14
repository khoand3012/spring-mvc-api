package com.edu.restwebapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private String author;

    @Column(name = "published_year")
    private int publishedYear;

    @Column(name = "description")
    @Lob
    private String description;

//    @Column(name = "genre_id")
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
//    private List<Genre> genres;

    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    @ManyToOne
    private BookPublisher publisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Genre> getGenres() {
//        return genres;
//    }

//    public void setGenres(List<Genre> genres) {
//        this.genres = genres;
//    }

    public BookPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(BookPublisher publisher) {
        this.publisher = publisher;
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", publishedYear=" + publishedYear +
//                ", description='" + description + '\'' +
//                ", genre=" + getGenresName(genres) +
//                ", publisher=" + publisher +
//                '}';
//    }

//    private String getGenresName(List<Genre> genres) {
//        String returnData = "";
//        while (genres.iterator().hasNext()) {
//            returnData.concat(genres.iterator().next().getName() + " ");
//        }
//        return returnData;
//    }

    public Book() {
    }

//    public Book(String title, String author, int publishedYear, String description) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.publishedYear = publishedYear;
//        this.description = description;
//    }

//    public Book(Long id, String title, String author, int publishedYear, String description, List<Genre> genres, BookPublisher publisher) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.publishedYear = publishedYear;
//        this.description = description;
//        this.genres = genres;
//        this.publisher = publisher;
//    }
}
