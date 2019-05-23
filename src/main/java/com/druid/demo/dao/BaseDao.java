package com.druid.demo.dao;

import java.util.List;

public interface BaseDao<T> {

  void insert(T entity) throws Exception;

  int insertBatch(List<T> entityList) throws Exception;

  /**
   * 更新数据
   */
  void update(T entity) throws Exception;

  /**
   * 根据ID删除数据
   */
  void deleteByPrimaryKey(int id) throws Exception;

  /**
   * 删除数据
   */
  void delete(T entity) throws Exception;


  /**
   * 根据id查询单个记录
   */
  T findByPrimaryKey(int id);

  /**
   * 根据对象查询单个记录
   */
  T findByEntity(T entity);


  /**
   * 根据对象查询多条记录
   */
  List<T> findByListEntity(T entity);

  /**
   * 查询所有记录
   */
  List<T> findAll();

  /**
   * 根据对象查询信息
   */
  Object findByObject(Object obj);

}
