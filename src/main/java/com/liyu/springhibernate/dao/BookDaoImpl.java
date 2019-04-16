package com.liyu.springhibernate.dao;

import com.liyu.springhibernate.domain.Book;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    // 获取当前线程绑定的session
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Book findById(Long id){
        String sql = "select id,bookname,stock,price from Book where id = ?1";
        Query query = getSession().createQuery(sql).setLong(1,2);
//        System.out.println(query.getParameter("stock"));
        return (Book) query.uniqueResult();
//        return (Book) query;
    }
    public List<Book> findAll(){
        String sql = "select id,bookname,stock,price from Book";
        Query query = getSession().createQuery(sql);
        List<Book> result = query.getResultList();
        for(Object object : result)
            System.out.println(object.toString());
        return result;
    }
}
