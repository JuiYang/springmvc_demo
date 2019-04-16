package com.liyu.springhibernate.dao;

import com.liyu.springhibernate.domain.Book;

import java.util.List;

public interface BookDao {
    Book findById(Long id);
    List findAll();
}
