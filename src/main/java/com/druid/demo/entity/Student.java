package com.druid.demo.entity;

public class Student {

  /** ѧ�����*/
  private Long id;
  /** ѧ������*/
  private String name;
  /** ѧ������*/
  private Integer age;
  /**
   * ��ȡѧ�����
   * @return  id
   */
  public Long getId() {
    return id;
  }
  /**
   * ����ѧ�����
   * @param Long id
   */
  public void setId(Long id) {
    this.id = id;
  }
  /**
   * ��ȡѧ������
   * @return  name
   */
  public String getName() {
    return name;
  }
  /**
   * ����ѧ������
   * @param String name
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * ��ȡѧ������
   * @return  age
   */
  public Integer getAge() {
    return age;
  }
  /**
   * ����ѧ������
   * @param Integer age
   */
  public void setAge(Integer age) {
    this.age = age;
  }
}
