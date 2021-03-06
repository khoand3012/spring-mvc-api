package com.edu.restwebapp.controllers;

import com.edu.restwebapp.models.BookPublisher;
import com.edu.restwebapp.repositories.BookPublisherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PublisherController {
    private final BookPublisherRepository bookPublisherRepository;

    public PublisherController(BookPublisherRepository bookPublisherRepository) {
        this.bookPublisherRepository = bookPublisherRepository;
    }

    @GetMapping("/publishers")
    public Page<BookPublisher> getPublishers(Pageable pageable) {
        return bookPublisherRepository.findAll(pageable);
    }

    @PostMapping("/publishers")
    public BookPublisher createNewPublisher(@Valid @RequestBody BookPublisher bookPublisher) {
        return bookPublisherRepository.save(bookPublisher);
    }
    @GetMapping("/publisher")
    public Page<BookPublisher> getBookPublisherByName(Pageable pageable, @RequestParam String name, @RequestParam(required = false) String country) {
        return bookPublisherRepository.getBookPublisherByName(pageable, name, country);
    }
}
