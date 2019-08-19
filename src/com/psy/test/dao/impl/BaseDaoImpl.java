package com.psy.test.dao.impl;

import com.psy.test.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private Class clazz;

    //提供一个构造方法,构造方法中传入Class
    //如果不想子类上有构造方法，必须在父类中提供无参的构造，在无参构造中获得具体类型Class
    //具体类型的Class是参数类型中的实例类型参数
    public BaseDaoImpl() {
        //反射：1.获得代表子类对象的Class
        Class clazz = this.getClass();//正在被调用的类的Class
        Type type = clazz.getGenericSuperclass();//参数化的类型
        System.out.println(type);
        //得到的type是参数化类型，将type强制转换为参数化类型
        ParameterizedType pType = (ParameterizedType) type;
        //通过参数化类型的方法获得实际类型参数:得到一个实际类型参数数组。
        Type[] types = pType.getActualTypeArguments();
        //只获得第一个实际类型参数即可
        this.clazz = (Class) types[0];
    }

    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    //查询一个的方法
    public T findById(Serializable id) {
        return (T) this.getHibernateTemplate().get(clazz, id);
    }

    @Override
    //查询所有的方法
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
    }

    @Override
    //带条件统计个数的方法
    public Integer findCount(DetachedCriteria detachedCriteria) {
        //设置统计个数的条件
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    //分页查询方法
    public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
    }
}
