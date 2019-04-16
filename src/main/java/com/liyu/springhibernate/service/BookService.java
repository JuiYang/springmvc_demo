package com.liyu.springhibernate.service;

import com.liyu.springhibernate.domain.Book;

import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> findAll();
}
