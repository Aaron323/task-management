package cn.com.betasoft.taskmanagement.service;

import cn.com.betasoft.taskmanagement.dao.ResourceDao;
import cn.com.betasoft.taskmanagement.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceService {
    @Autowired
    ResourceDao resourceDao;
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }
}
