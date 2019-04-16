package com.liyu.Utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataSourceMain {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_properties.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println("c3p0连接信息： " + dataSource.getConnection());
    }
}
