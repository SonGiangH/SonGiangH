package com.ecommerce.dao.impl;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO USER(FIRST_NAME, PHONE) VALUE(?,?)";

        jdbcTemplate.update(sql, user.getFirstName(), user.getPhone());
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE USER SET FIRST_NAME = ?, PHONE = ? WHERE ID = ?";

        jdbcTemplate.update(sql, user.getFirstName(), user.getPhone(), user.getId());
    }

    @Override
    public void deleteUserById(int id) {
        String sql = "DELETE FROM USER WHERE ID = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM USER WHERE ID = ? ";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {        // queryForObject truyen vao Object[]
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();

                user.setId(resultSet.getInt("ID"));
                user.setFirstName(resultSet.getString("FIRST_NAME"));
                user.setPhone(resultSet.getString("PHONE"));

                return user;
            }
        });
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM USER ";

        return jdbcTemplate.query(sql, new Object[] {} ,new RowMapper<User>() {                 // query truyen vao mang trang Object
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {

                User user = new User();

                user.setId(resultSet.getInt("ID"));
                user.setFirstName(resultSet.getString("FIRST_NAME"));
                user.setPhone(resultSet.getString("PHONE"));

                return user;
            }
        });
    }
}
