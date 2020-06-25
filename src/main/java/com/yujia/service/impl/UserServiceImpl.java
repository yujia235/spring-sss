package com.yujia.service.impl;

import com.yujia.dao.UserDao;
import com.yujia.pojo.User;
import com.yujia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllSortById() {
        return userDao.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> selectBySql(String userName, String passWord) {
        return userDao.selectBySql(userName, passWord);
    }
}
