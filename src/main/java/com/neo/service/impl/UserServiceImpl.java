package com.neo.service.impl;

import com.neo.dao.UserDao;
import com.neo.entity.User;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserDao userDao;


    @Override
    public List<User> getUserList() {
        return userDao.getAll();
    }

    @Override
    public User findUserById(String id) {
        return userDao.getOne(id);
    }

    @Override
    public void save(User user) {
         userDao.insert(user);
    }

    @Override
    public void edit(User user) {
       userDao.update(user);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @Override
    public void delete(String id) {
        userDao.delete(id);
    }
}
