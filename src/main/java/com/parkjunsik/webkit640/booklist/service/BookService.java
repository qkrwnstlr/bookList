package com.parkjunsik.webkit640.booklist.service;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import com.parkjunsik.webkit640.booklist.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  /**
   * 새로운 책 추가
   */
  public BookEntity addNewBook(BookEntity book) {
    return bookRepository.save(book);
  }

  /**
   * 전체 책 조회
   */
  public List<BookEntity> getAllBook() {
    return bookRepository.findAll();
  }

  /**
   * id로 책 조회
   */
  public Optional<BookEntity> getBookWithId(Long id) {
    return bookRepository.findById(id);
  }

  /**
   * 제목으로 책 조회
   */
  public Optional<List<BookEntity>> getBookWithTitle(String title) {
    return bookRepository.findByTitleLike("%" + title + "%");
  }

  /**
   * 작가로 책 조회
   */
  public Optional<List<BookEntity>> getBookWithWriter(String writer) {
    return bookRepository.findByWriter(writer);
  }

  /**
   * 카테고리로 책 조회
   */
  public Optional<List<BookEntity>> getBookWithCategory(String category) {
    return bookRepository.findByCategory(category);
  }

  /**
   * 장르로 책 조회
   */
  public Optional<List<BookEntity>> getBookWithGenre(String genre) {
    return bookRepository.findByGenre(genre);
  }

  /**
   * 국가로 책 조회
   */
  public Optional<List<BookEntity>> getBookWithCountry(String country) {
    return bookRepository.findByCountry(country);
  }

  /**
   * 책 정보 수정
   */
  public BookEntity updateBook(BookEntity book) {
    checkIsBookExist(book);
    return bookRepository.save(book);
  }

  /**
   * 책이 존재하는지 확인
   */
  private void checkIsBookExist(BookEntity book) {
    if (bookRepository.findById(book.getId()).isEmpty())
      throw new IllegalStateException("존재하지 않는 책입니다.");
  }
}
