package cn.sp.dao;

import cn.sp.bean.Person;

/**
 * @author ship
 * @Description
 * @Date: 2018-07-04 14:17
 */
public interface PersonDao {

    /**
     * 插入
     * @param person
     */
    void insert(Person person);

    /**
     * 更新文档
     * @param person
     */
    void update(Person person);

    /**
     * 删除文档
     * @param pId
     */
    void delete(int pId);

    /**
     * 查询文档
     * @param pId
     * @return
     */
    Person findByPId(int pId);
}
