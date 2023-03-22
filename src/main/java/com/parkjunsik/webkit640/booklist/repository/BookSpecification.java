package com.parkjunsik.webkit640.booklist.repository;

import com.parkjunsik.webkit640.booklist.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BookSpecification {
  public static Specification<BookEntity> findBook(Map<String, Object> map) {
    return ((root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      //TODO : FindBookDTO의 각 요소를 List로 바꾸든가 해서 여러 종류의
      for (String key : map.keySet()) {
        // 빈 값이면 넘김 -> ObjectMapper가 null이라도 key값을 생성하기 떄문
        if (map.get(key) == null || map.get(key) == "" || Objects.equals(map.get(key).toString(), "0")) continue;
        predicates.add(classifyKey(key, map.get(key), root, criteriaBuilder));
      }
      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    });
  }

  private static Predicate classifyKey(String key, Object value, Root<BookEntity> root, CriteriaBuilder criteriaBuilder) {
    switch (key) {
      case "title": // title은 like로 포함된 모든것 검색
      case "writer": // writer은 like로 포함된 모든것 검색
        return criteriaBuilder.like(root.get(key), "%" + value.toString() + "%");
      case "price": // price는 lessThanOrEqualTo로 이하 범위 검색
        return criteriaBuilder.lessThanOrEqualTo(root.get(key), (int) value);
      default: // 나머지는 일치하는 경우만 검색
        return criteriaBuilder.equal(root.get(key), value);
    }
  }
}