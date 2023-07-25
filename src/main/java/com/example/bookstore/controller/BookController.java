package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.MyBookList;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.MyBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBooksService myBooksService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("bookList");
//        mav.addObject("book", bookList);

        return new ModelAndView("bookList", "book", bookList);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> myBookLists = myBooksService.getAllMyBooks();
        model.addAttribute("book", myBookLists);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") Integer id) {
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(),
                book.getPrice());
        myBooksService.saveMyBook(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
