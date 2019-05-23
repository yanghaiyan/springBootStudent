package com.druid.demo.controller;

import com.druid.demo.entity.User;
import com.druid.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {
  private UserService userService;

  @Autowired
  private void setUserService(UserService userService) {
    this.userService = userService;
  }


  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public boolean insert(@RequestBody User user) {
    System.out.println("开始新增...");
    return userService.insert(user);
  }

  @RequestMapping(value = "/user", method = RequestMethod.PUT)
  public boolean update(@RequestBody User user) {
    System.out.println("开始更新...");
    return userService.update(user);
  }

  @RequestMapping(value = "/user", method = RequestMethod.DELETE)
  public boolean delete(@RequestBody User user) {
    System.out.println("开始删除...");
    return userService.delete(user);
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public List<User> findByUser(User user) {
    System.out.println("开始查询...");
    return userService.findByListEntity(user);
  }
}
