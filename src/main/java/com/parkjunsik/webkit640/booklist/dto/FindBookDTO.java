package com.parkjunsik.webkit640.booklist.dto;

import lombok.Data;

@Data
public class FindBookDTO {
    private String title;
    private String writer;
    private String category;
    private String country;
    private String genre;
    private int price;
}
