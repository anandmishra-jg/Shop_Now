package com.ShopNow.DAO;

import com.ShopNow.Models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    JdbcTemplate jdbc;

    public List<user> getAllusers(String demo){
        try{

            String query = "SELECT * FROM user where firstname=?";
            List<user> result = jdbc.query(query, new BeanPropertyRowMapper<>(user.class), demo);
            return result;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
