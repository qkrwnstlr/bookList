package com.parkjunsik.webkit640.booklist.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkjunsik.webkit640.booklist.dto.FindBookDTO;
import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import com.parkjunsik.webkit640.booklist.repository.BookRepository;
import com.parkjunsik.webkit640.booklist.repository.BookSpecification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
   * 필터에 따라 책 조회
   */
  public List<BookEntity> getBookWithFilter(FindBookDTO findBookDTO) {
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<Map<String, Object>> type = new TypeReference<>() {
    };
    System.out.println(objectMapper.convertValue(findBookDTO, type));
    return bookRepository.findAll(BookSpecification.findBook(objectMapper.convertValue(findBookDTO, type)));
  }

  /**
   * 책 정보 수정
   */
  public BookEntity updateBook(BookEntity book) {
    checkIsBookExist(book);
    return bookRepository.save(book);
  }

  /**
   * 책 정보 삭제
   */
  public void deleteBook(Long id) {
    bookRepository.deleteById(id);
  }

  /**
   * 책이 존재하는지 확인
   */
  private void checkIsBookExist(BookEntity book) {
    if (bookRepository.findById(book.getId()).isEmpty())
      throw new IllegalStateException("존재하지 않는 책입니다.");
  }
}
