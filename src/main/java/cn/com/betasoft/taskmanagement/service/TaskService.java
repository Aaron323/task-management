package cn.com.betasoft.taskmanagement.service;

import cn.com.betasoft.taskmanagement.dao.TaskDao;
import cn.com.betasoft.taskmanagement.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskService {
    @Autowired
    private TaskDao taskDao;

    public List<Task> findAll() {
        return taskDao.findAll();
    }

    public Task findById(Long id) {
        return taskDao.findById(id);
    }

    @Transactional
    public void add(Task task) {
        taskDao.add(task);
    }

    @Transactional
    public void update(Task task) {
        taskDao.update(task);
    }

    @Transactional
    public void delete(Long id) {
        taskDao.delete(id);
    }
}
