package com.druid.demo.controller;

import com.druid.demo.entity.Student;
import com.druid.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class StudentRestController {
  private StudentService studentService;

  @Autowired
  private void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping(value = "/student", method = RequestMethod.POST)
  public boolean addStudent(@RequestBody Student student) {
    System.out.println("��ʼ����...");
    return studentService.insert(student);
  }

  @RequestMapping(value = "/student", method = RequestMethod.PUT)
  public boolean updateStudent(@RequestBody Student student) {
    System.out.println("��ʼ����...");
    return studentService.update(student);
  }

  @RequestMapping(value = "/student", method = RequestMethod.DELETE)
  public boolean delete(@RequestBody Student student) {
    System.out.println("��ʼɾ��...");
    return studentService.delete(student);
  }

  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public List<Student> findByStudent(Student student) {
    System.out.println("��ʼ��ѯ...");
    return studentService.findByListEntity(student);
  }

}
