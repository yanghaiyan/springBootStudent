package com.druid.demo.entity;

public class User {

  /** ���*/
  private Long id;
  /** ����*/
  private String name;
  /** ����*/
  private Integer age;

  /**
   * ��ȡ���
   * @return  id
   */
  public Long getId() {
    return id;
  }
  /**
   * ���ñ��
   * @param Long id
   */
  public void setId(Long id) {
    this.id = id;
  }
  /**
   * ��ȡ����
   * @return  name
   */
  public String getName() {
    return name;
  }
  /**
   * ��������
   * @param String name
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * ��ȡ����
   * @return  age
   */
  public Integer getAge() {
    return age;
  }
  /**
   * ��������
   * @param Integer age
   */
  public void setAge(Integer age) {
    this.age = age;
  }
}
