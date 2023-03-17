package com.parkjunsik.webkit640.booklist.repository;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
  BookEntity save(BookEntity book);
  List<BookEntity> findAll();
  Optional<BookEntity> findById(Long id);
  Optional<List<BookEntity>> findByTitleLike(String title);
  Optional<List<BookEntity>> findByWriter(String writer);
  Optional<List<BookEntity>> findByCategory(String category);
  Optional<List<BookEntity>> findByCountry(String Country);
  Optional<List<BookEntity>> findByGenre(String genre);
}
