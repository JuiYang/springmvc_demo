package com.liyu.springhibernate.service;

import com.liyu.springhibernate.domain.Book;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class BookServiceImplTest {
    private BookService bookService;
    private ApplicationContext applicationContext = null;

    {
        applicationContext = new ClassPathXmlApplicationContext("spring_hibernate.xml");
        bookService = applicationContext.getBean(BookService.class);
    }

    @Test
    public void connectionSource(){
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findById() {
        System.out.println(bookService.findById((long) 2));
        System.out.println(bookService);
    }

    @Test
    public void findAll() {
        for(Book book : bookService.findAll()){
            System.out.println(book.toString());
        }
    }
}