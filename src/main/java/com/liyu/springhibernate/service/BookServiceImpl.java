package com.liyu.springhibernate.service;

import com.liyu.springhibernate.dao.BookDao;
import com.liyu.springhibernate.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    public Book findById(Long id){
        return bookDao.findById(id);
    }
    public List<Book> findAll(){
        return bookDao.findAll();
    }
}
