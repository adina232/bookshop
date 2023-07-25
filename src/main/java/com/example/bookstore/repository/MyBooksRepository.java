package com.example.bookstore.repository;

import com.example.bookstore.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBookList, Integer> {
}
