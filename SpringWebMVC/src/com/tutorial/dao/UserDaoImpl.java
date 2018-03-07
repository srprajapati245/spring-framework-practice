package com.tutorial.dao;

import com.tutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Rudra Automation on 22/06/2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findById(Integer id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String SQL = "select * from users where id = ?";

        User user = null;
        try{
            user = namedParameterJdbcTemplate.queryForObject(SQL, params, new UserMapper());
        } catch (EmptyResultDataAccessException e){
            // do noting return null
        }
        return user;
    }

    @Override
    public List<User> findAll() {

        String SQL = "select * from users";

        List<User> users = namedParameterJdbcTemplate.query(SQL, new UserMapper());
        return users;
    }

    @Override
    public void save(User user) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String SQL = "insert into users ( name, email, address, password, newsletter, framework, sex, number, country, skill ) " +
                    "values ( :name, :email, :address, :password, :newsletter, :framework, :sex, :number, :country, :skill)";

        namedParameterJdbcTemplate.update(SQL, getSqlParameterSource(user), keyHolder);
        user.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(User user) {

        String SQL = "update users set NAME=:name, EMAIL=:email, ADDRESS=:address, " +
                "PASSWORD=:password, NEWSLETTER=:newsletter, FRAMEWORK=:framework, " +
                "SEX=:sex, NUMBER=:number, COUNTRY=:country, SKILL=:skill WHERE id=:id";

        namedParameterJdbcTemplate.update(SQL, getSqlParameterSource(user));

    }

    @Override
    public void delete(Integer id) {

        String SQL = "delete from users where id = :id";
        namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource("id", id));

    }

    private SqlParameterSource getSqlParameterSource(User user){

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", user.getId());
        paramSource.addValue("name", user.getName());
        paramSource.addValue("email", user.getEmail());
        paramSource.addValue("address", user.getAddress());
        paramSource.addValue("password", user.getPassword());
        paramSource.addValue("newsletter", user.isNewsletter());

        // join String
        paramSource.addValue("framework", convertListToDelimitedString(user.getFramework()));
        paramSource.addValue("sex", user.getSex());
        paramSource.addValue("number", user.getNumber());
        paramSource.addValue("country", user.getCountry());
        paramSource.addValue("skill", convertListToDelimitedString(user.getSkill()));

        return paramSource;

    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
            user.setAddress(rs.getString("address"));
            user.setCountry(rs.getString("country"));
            user.setNewsletter(rs.getBoolean("newsletter"));
            user.setNumber(rs.getInt("number"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
            user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
            return user;
        }
    }

    private static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<String>();

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;

    }

    private String convertListToDelimitedString(List<String> list) {

        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;

    }
}
