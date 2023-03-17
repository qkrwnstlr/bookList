package com.parkjunsik.webkit640.booklist.controller;

import com.parkjunsik.webkit640.booklist.dto.AddBookDTO;
import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import com.parkjunsik.webkit640.booklist.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("book/add")
  @ResponseBody
  public BookEntity addBook(@RequestBody AddBookDTO addBookDTO) {
    return bookService.addNewBook(addBookDTO.toEntity());
  }

  @GetMapping("book")
  @ResponseBody
  public List<BookEntity> getAllBook() {
    return bookService.getAllBook();
  }

  @GetMapping("book/title")
  @ResponseBody
  public List<BookEntity> getBookWithTitle(@RequestParam("title") String title) {
    return bookService.getBookWithTitle(title).get();
  }
}
