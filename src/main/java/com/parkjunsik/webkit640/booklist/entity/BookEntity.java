package com.parkjunsik.webkit640.booklist.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="book")
public class BookEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String writer;
  private String country;
  private String genre;
  private int price;
  private String description;
}
