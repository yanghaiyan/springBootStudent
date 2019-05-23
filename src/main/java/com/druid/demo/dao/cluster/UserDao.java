package com.druid.demo.dao.cluster;

import com.druid.demo.dao.BaseDao;
import com.druid.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserDao extends BaseDao<User> {

}
