package com.parkjunsik.webkit640.booklist.dto;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import lombok.Data;

@Data
public class AddBookDTO {
  private String title;
  private String writer;
  private String category;
  private String country;
  private String genre;
  private int price;
  private String description;

  public BookEntity toEntity() {
    BookEntity book = new BookEntity();
    book.setTitle(title);
    book.setWriter(writer);
    book.setCategory(category);
    book.setCountry(country);
    book.setGenre(genre);
    book.setPrice(price);
    book.setDescription(description);
    return book;
  }
}
