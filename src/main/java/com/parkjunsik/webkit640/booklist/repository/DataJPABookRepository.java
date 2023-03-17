package com.parkjunsik.webkit640.booklist.repository;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DataJPABookRepository extends JpaRepository<BookEntity, Long>, BookRepository {
  @Override
  Optional<List<BookEntity>> findByTitleLike(String title);

  @Override
  Optional<List<BookEntity>> findByWriter(String writer);

  @Override
  Optional<List<BookEntity>> findByCategory(String category);

  @Override
  Optional<List<BookEntity>> findByCountry(String Country);

  @Override
  Optional<List<BookEntity>> findByGenre(String genre);
}
