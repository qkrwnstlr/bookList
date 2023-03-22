package com.parkjunsik.webkit640.booklist.controller;

import com.parkjunsik.webkit640.booklist.dto.AddBookDTO;
import com.parkjunsik.webkit640.booklist.dto.FindBookDTO;
import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import com.parkjunsik.webkit640.booklist.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("book")
  @ResponseBody
  public List<BookEntity> getAllBook(@ModelAttribute FindBookDTO findBookDTO) {
    System.out.println("book");
    return bookService.getBookWithFilter(findBookDTO);
  }

  @PostMapping("book/add")
  @ResponseBody
  public BookEntity addBook(@RequestBody AddBookDTO addBookDTO) {
    return bookService.addNewBook(addBookDTO.toEntity());
  }

  @PostMapping("book/delete")
  @ResponseBody
  public void deleteBook(@RequestParam Long id) {
    bookService.deleteBook(id);
  }
}
