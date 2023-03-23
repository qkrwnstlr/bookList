package com.parkjunsik.webkit640.booklist.controller;

import com.parkjunsik.webkit640.booklist.dto.AddBookDTO;
import com.parkjunsik.webkit640.booklist.dto.FindBookDTO;
import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import com.parkjunsik.webkit640.booklist.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("book")
  @ResponseBody
  public List<BookEntity> getAllBook(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
    return bookService.getAllBook(pageable);
  }

  @GetMapping("book/filter")
  @ResponseBody
  public List<BookEntity> getBook(@ModelAttribute FindBookDTO findBookDTO) {
    return bookService.getBookWithFilter(findBookDTO);
  }

  @PostMapping("book/add")
  @ResponseBody
  public BookEntity addBook(@RequestBody AddBookDTO addBookDTO) {
    return bookService.addNewBook(addBookDTO.toEntity());
  }

  @PostMapping("book/edit/{id}")
  @ResponseBody
  public BookEntity editBook(@PathVariable Long id, @RequestBody AddBookDTO addBookDTO) {
    BookEntity bookEntity = addBookDTO.toEntity();
    bookEntity.setId(id);
    return bookService.updateBook(bookEntity);
  }

  @PostMapping("book/delete/{id}")
  @ResponseBody
  public void deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
  }
}
