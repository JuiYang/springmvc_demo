package com.liyu.Utils;

import com.liyu.Utils.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataSourceMainTest {

    private JdbcTemplate jdbcTemplate;
    private ApplicationContext applicationContext;

    {
        applicationContext = new ClassPathXmlApplicationContext("beans_properties.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    }

    @Test
    public void testUpdate() {
        String sql = "update user set username=? where id = ? ";
        jdbcTemplate.update(sql, "2222", 2);
    }


    // 插入一条数据
    @Test
    public void testInsert(){
        String sql = "insert into user(username,name,password,email) values(?,?,?,?)";
        jdbcTemplate.update(sql,"e2","e","e","15454354@qq.com");
    }

    // 批量插入
    @Test
    public void testBatchInsert(){
        String sql = "insert into user(username,name,password,email) values(?,?,?,?)";
        List<Object[]> users = new ArrayList<Object[]>();
        users.add(new Object[]{"a","a","a","154323114554@qq.com"});
        users.add(new Object[]{"b","b","b","154554344@qq.com"});
        users.add(new Object[]{"c","c","c","1524554@qq.com"});
        users.add(new Object[]{"d","d","d","15423554@qq.com"});
        jdbcTemplate.batchUpdate(sql,users);
    }

    // 查找一条数据
    @Test
    public void testFindOne() {
        String sql = "select id,username,name,password from user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 2);
        System.out.println(user.toString());
    }

    // 查找所有
    @Test
    public void testFindAll() {
        String sql = "select id,username,name,password from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        System.out.println(users.toString());
    }

    @Test
    public void testDatasource() throws SQLException {
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println("c3p0连接信息： " + dataSource.getConnection());
    }

}