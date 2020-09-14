package com.edu.restwebapp.controllers;

import com.edu.restwebapp.exceptions.ResourceNotFoundException;
import com.edu.restwebapp.models.Book;
import com.edu.restwebapp.repositories.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/books")
    public Book createNewBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("book/{bookId}")
    public Optional<Book> getBookById(@PathVariable Long bookId) {
        return bookRepository.findById(bookId);
    }

    @PutMapping("/book/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @Valid @RequestBody Book req) {
        if (!bookRepository.existsById(bookId))
            throw new ResourceNotFoundException("Cannot find book with given id!");
        Book returnData = bookRepository.findById(bookId).map(book -> {
            if (!req.getAuthor().isEmpty() && req.getAuthor() != null) {
                book.setAuthor(req.getAuthor());
            }
            if (!req.getDescription().isEmpty() && req.getDescription() != null) {
                book.setDescription(req.getDescription());
            }
            if (req.getPublishedYear() > 0) {
                book.setPublishedYear(req.getPublishedYear());
            }
            if (!req.getDescription().isEmpty() && req.getDescription() != null) {
                book.setDescription(req.getDescription());
            }
            if(req.getPublisher() != null) {
                book.setPublisher(req.getPublisher());
            }
            return bookRepository.save(book);
        }).orElseThrow(() -> new ResourceNotFoundException("Cannot save changes!"));
        return returnData;
    }
}
