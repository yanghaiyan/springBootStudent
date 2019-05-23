package com.druid.demo.service.impl;

import com.druid.demo.dao.BaseDao;
import com.druid.demo.entity.Student;
import com.druid.demo.entity.User;
import com.druid.demo.service.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

  private static final Logger logger= LoggerFactory.getLogger(BaseServiceImpl.class);

  protected abstract BaseDao<T> getMapper();

  @Override
  public boolean insert(T entity)  {
    boolean falg=false;
    try {
      getMapper().insert(entity);
      falg=true;
    } catch (Exception e) {
      logger.error("����"+getClassName(entity)+"ʧ��!ԭ����:",e);
    }
    return falg;
  }


  @Override
  public boolean update(T entity){
    boolean falg=false;
    try {
      getMapper().update(entity);
      falg=true;
    } catch (Exception e) {
      logger.error("����"+getClassName(entity)+"ʧ��!ԭ����:",e);
    }
    return falg;
  }

  @Override
  public boolean deleteByPrimaryKey(int id)  {
    boolean falg=false;
    try {
      getMapper().deleteByPrimaryKey(id);
      falg=true;
    } catch (Exception e) {
      logger.error("id:"+id+"ɾ��ʧ��!ԭ����:",e);
    }
    return falg;
  }

  @Override
  public boolean delete(T entity){
    boolean falg=false;
    try {
      getMapper().delete(entity);
      falg=true;
    } catch (Exception e) {
      logger.error("ɾ��"+getClassName(entity)+"ʧ��!ԭ����:",e);
    }
    return falg;
  }

  @Override
  public T findByPrimaryKey(int id) {
    T obj = null;
    try {
      obj = getMapper().findByPrimaryKey(id);
    } catch (Exception e) {
      logger.error("id:"+id+"��ѯʧ��!ԭ����:",e);
    }
    return obj;
  }

  @Override
  public T findByEntity(T entity) {
    T obj = null;
    try {
      obj = getMapper().findByEntity(entity);
    } catch (Exception e) {
      logger.error("��ѯ"+getClassName(entity)+"ʧ��!ԭ����:",e);
    }
    return obj;
  }

  @Override
  public List<T> findByListEntity(T entity) {
    List<T> list = null;
    try {
      Page<?> page =PageHelper.startPage(1,2);
      System.out.println(getClassName(entity)+"���õ�һҳ��������!");
      list = getMapper().findByListEntity(entity);
      System.out.println("�ܹ���:"+page.getTotal()+"������,ʵ�ʷ���:"+list.size()+"��������!");
    } catch (Exception e) {
      logger.error("��ѯ"+getClassName(entity)+"ʧ��!ԭ����:",e);
    }
    return list;
  }

  @Override
  public List<T> findAll() {
    List<T> list = null;
    try {
      list =  getMapper().findAll();
    } catch (Exception e) {
      logger.error("��ѯʧ��!ԭ����:",e);
    }
    return list;
  }

  @Override
  public Object findByObject(Object obj) {
    Object result = null;
    try {
      result = getMapper().findByObject(obj);
    } catch (Exception e) {
      logger.error("��ѯ"+obj+"ʧ��!ԭ����:",e);
    }
    return result;
  }

  private String getClassName(T t){
    String str="";
    if(t instanceof User){
      str="User";
    }else if(t instanceof Student){
      str="Studnet";
    }
    return str;
  }
}
