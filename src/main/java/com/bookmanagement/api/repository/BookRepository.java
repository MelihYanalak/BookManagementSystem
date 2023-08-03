package com.bookmanagement.api.repository;

import com.bookmanagement.api.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
