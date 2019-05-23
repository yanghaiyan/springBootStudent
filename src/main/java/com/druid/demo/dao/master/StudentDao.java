package com.druid.demo.dao.master;

import com.druid.demo.dao.BaseDao;
import com.druid.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StudentDao extends BaseDao<Student> {

}
