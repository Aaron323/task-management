package cn.com.betasoft.taskmanagement.dao;


import cn.com.betasoft.taskmanagement.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class TaskDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Task> findAll() {
        String sql = "select * from task;";
        BeanPropertyRowMapper<Task> rowMapper = new BeanPropertyRowMapper<>(Task.class);
        List<Task> tasks = jdbcTemplate.query(sql, rowMapper);
        return tasks;
    }

    public Task findById(Long id) {
        String sql = "select * from task where id=?;";
        BeanPropertyRowMapper<Task> rowMapper = new BeanPropertyRowMapper<>(Task.class);
        Task task = jdbcTemplate.queryForObject(sql,new Object[] {id}, rowMapper);
        return task;
    }

    public void add(Task task) {
        String sql = "insert into task values(null, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, new Object[] {task.getName(), task.getStartTime(), task.getStopTime(),
                task.getDuration(), task.getProgress(), task.getPriority(), task.getResourceId()});
    }

    public void update(Task task) {
        String sql = "update task set name=?, startTime=?, stopTime=?, duration=?, progress=?, priority=?, resourceId=? where id=?;";
        jdbcTemplate.update(sql, new Object[] {task.getName(), task.getStartTime(), task.getStopTime(),
                task.getDuration(), task.getProgress(), task.getPriority(), task.getResourceId(), task.getId()});
    }

    public void delete(Long id) {
        String sql = "delete from task where id=?;";
        jdbcTemplate.update(sql, new Object[] {id});
    }
}
