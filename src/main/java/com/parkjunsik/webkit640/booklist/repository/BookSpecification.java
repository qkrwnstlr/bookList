package com.parkjunsik.webkit640.booklist.repository;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BookSpecification {
  public static Specification<BookEntity> findBook(Map<String, Object> map) {
    return ((root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      for (String key : map.keySet()) {
        if (map.get(key) == null) continue;
        if (Objects.equals(key, "title")) {
          System.out.println("title");
          predicates.add(criteriaBuilder.like(root.get(key), "%" + map.get(key).toString() + "%"));
        } else predicates.add(criteriaBuilder.equal(root.get(key), map.get(key)));
      }
      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    });
  }
}
