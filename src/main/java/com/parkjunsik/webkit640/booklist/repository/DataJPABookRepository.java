package com.parkjunsik.webkit640.booklist.repository;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DataJPABookRepository extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity>, BookRepository {
}
