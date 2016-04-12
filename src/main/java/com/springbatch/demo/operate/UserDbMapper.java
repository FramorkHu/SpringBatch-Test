package com.springbatch.demo.operate;


import com.springbatch.demo.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by huyan on 2016/4/12.
 */
public class UserDbMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        user.setId(resultSet.getLong("ID"));
        user.setName(resultSet.getString("NAME"));
        user.setAge(resultSet.getInt("AGE"));
        user.setBalance(resultSet.getDouble("BALANCE"));
        return user;

    }
}
