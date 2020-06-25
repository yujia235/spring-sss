package com.yujia.service;

import com.yujia.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> findAllSortById();

    User findById(Integer id);

    User save(User user);

    void deleteById(Integer id);

    List<User> selectBySql(String userName, String passWord);
}
