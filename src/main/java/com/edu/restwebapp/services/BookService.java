package com.edu.restwebapp.services;

import com.edu.restwebapp.dtos.BookDTO;
import com.edu.restwebapp.models.Book;
import com.edu.restwebapp.repositories.BookPublisherRepository;
import com.edu.restwebapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;
    private BookPublisherRepository bookPublisherRepository;

    public BookService(BookRepository bookRepository, BookPublisherRepository bookPublisherRepository) {
        this.bookRepository = bookRepository;
        this.bookPublisherRepository = bookPublisherRepository;
    }

//    public Book create(BookDTO bookModel) {
//        Book newRecord = new Book();
//        if (bookModel.getAuthor() != null && !bookModel.getAuthor().isEmpty()) {
//            newRecord.setAuthor(bookModel.getAuthor());
//        }
//        if (bookModel.getDescription() != null && !bookModel.getDescription().isEmpty()) {
//            newRecord.setDescription(bookModel.getDescription());
//        }
//        if(bookModel.getPublishedYear() >)
//    }

}
