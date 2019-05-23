package com.druid.demo.service.impl;

import com.druid.demo.dao.BaseDao;
import com.druid.demo.dao.cluster.UserDao;
import com.druid.demo.entity.User;
import com.druid.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  protected BaseDao<User> getMapper() {
    return this.userDao;
  }
}
