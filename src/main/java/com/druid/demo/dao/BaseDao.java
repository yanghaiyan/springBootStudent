package com.druid.demo.dao;

import java.util.List;

public interface BaseDao<T> {

  void insert(T entity) throws Exception;

  int insertBatch(List<T> entityList) throws Exception;

  /**
   * ��������
   */
  void update(T entity) throws Exception;

  /**
   * ����IDɾ������
   */
  void deleteByPrimaryKey(int id) throws Exception;

  /**
   * ɾ������
   */
  void delete(T entity) throws Exception;


  /**
   * ����id��ѯ������¼
   */
  T findByPrimaryKey(int id);

  /**
   * ���ݶ����ѯ������¼
   */
  T findByEntity(T entity);


  /**
   * ���ݶ����ѯ������¼
   */
  List<T> findByListEntity(T entity);

  /**
   * ��ѯ���м�¼
   */
  List<T> findAll();

  /**
   * ���ݶ����ѯ��Ϣ
   */
  Object findByObject(Object obj);

}
