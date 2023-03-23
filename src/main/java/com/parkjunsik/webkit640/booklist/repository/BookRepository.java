package com.parkjunsik.webkit640.booklist.repository;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
  BookEntity save(BookEntity book);
  Page<BookEntity> findAll(Pageable pageable);
  List<BookEntity> findAll(@Nullable Specification<BookEntity> spec);
  Optional<BookEntity> findById(Long id);
  void deleteById(Long id);
}
