package cn.com.betasoft.taskmanagement.dao;

import cn.com.betasoft.taskmanagement.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Resource> findAll() {
        String sql = "select * from resource;";
        BeanPropertyRowMapper<Resource> rowMapper = new BeanPropertyRowMapper<>(Resource.class);
        List<Resource> resources = jdbcTemplate.query(sql, rowMapper);
        return resources;
    }
}
