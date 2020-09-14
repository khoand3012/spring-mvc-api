package com.edu.restwebapp.repositories;

import com.edu.restwebapp.models.BookPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {
    @Query(value = "SELECT B FROM BookPublisher B WHERE B.name LIKE %?1% AND B.country LIKE %?2%")
    public Page<BookPublisher> getBookPublisherByName(Pageable pageable, String name, @Nullable String country);
}
