package com.example.bookstore.controller;

import com.example.bookstore.service.MyBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {
    @Autowired
    private MyBooksService myBooksService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Integer id) {
        myBooksService.deleteById(id);

        return "redirect:/my_books";
    }


}
