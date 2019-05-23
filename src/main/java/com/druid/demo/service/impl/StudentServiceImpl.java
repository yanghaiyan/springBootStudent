package com.druid.demo.service.impl;

import com.druid.demo.dao.BaseDao;
import com.druid.demo.dao.master.StudentDao;
import com.druid.demo.entity.Student;
import com.druid.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author as
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

  @Autowired
  private StudentDao studentDao;

  @Override
  protected BaseDao<Student> getMapper() {
    return this.studentDao;
  }
}
