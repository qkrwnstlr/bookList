package com.parkjunsik.webkit640.booklist.controller;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("searchList", new ArrayList<BookEntity>());
    model.addAttribute("recommendList", new ArrayList<BookEntity>());
    return "home";
  }
}
