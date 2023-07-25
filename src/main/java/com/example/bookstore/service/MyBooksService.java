package com.example.bookstore.service;

import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBooksService {
    @Autowired
    private MyBooksRepository myBooksRepository;

    public void saveMyBook(MyBookList bookList) {
        myBooksRepository.save(bookList);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBooksRepository.findAll();
    }

    public void deleteById(Integer id) {
        myBooksRepository.deleteById(id);
    }
}
