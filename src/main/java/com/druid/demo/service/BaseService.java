package com.druid.demo.service;

import java.util.List;

public interface BaseService<T> {
  /**
   * ��������
   *
   * @param entity
   * @return
   * @throws
   */
  boolean insert(T entity) ;

  /**
   * ��������
   *
   * @param entity
   * @return
   * @throws
   */
  boolean update(T entity) ;

  /**
   * ����IDɾ������
   * @param id
   * @throws Exception
   * @throws
   */
  boolean deleteByPrimaryKey(int id) ;

  /**
   * ɾ������
   * @param entity
   * @throws Exception
   * @throws
   */
  boolean delete(T entity) ;


  /**
   * ����id��ѯ������¼
   *
   * @param id
   * @return
   * @throws Exception
   * @throws
   */
  T findByPrimaryKey(int id);

  /**
   * ���ݶ����ѯ������¼
   *
   * @param entity
   * @return
   * @throws Exception
   * @throws
   */
  T findByEntity(T entity);



  /**
   * ���ݶ����ѯ������¼
   * @param entity
   * @return
   */
  List<T> findByListEntity(T entity);

  /**
   * ��ѯ���м�¼
   * @return
   */
  List<T> findAll();

  /**
   * ���ݶ����ѯ��Ϣ
   *
   * @param obj
   * @return
   * @throws Exception
   * @throws
   */
  Object findByObject(Object obj);
}
