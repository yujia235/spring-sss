package com.yujia.dao;

import com.yujia.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 定义符合SpringDataJpa要求的Dao层接口，同时继承额外两个接口
 * JpaRepository<实体类, 主键类型>：封装基本的CRUD操作
 * JpaSpecificationExecutor<实体类型>：封装复杂的查询操作（分页，排序等）
 */
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    /**
     * 针对查询使用方法总结：
     *      1.调用JpaRepository中基本查询方法
     *      2.自定义原生sql查询语句
     *      3.自定义jpql查询语句
     *      4.自定义方法名称查询：以findBy开头，属性和匹配条件兼备
     *      5.动态查询：借助JpaSpecificationExecutor中的Specification匿名对象
     */

    /**
     * 原生sql语句查询
     *
     * @param userName
     * @param passWord
     * @return
     */
    @Query(value = "select * from  user where username =  ?1 and password = ?2", nativeQuery = true)
    List<User> selectBySql(String userName, String passWord);

    /**
     * Jpql查询（类似hibernate的hql语句）：使用实体查询
     *
     * @param userName
     * @param passWord
     * @return
     */
    @Query("from User where userName = ?1 and passWord = ?2")
    List<User> selectByJpql(String userName, String passWord);

    /**
     * 方法命名规则查询
     *      方法名称以findBy开头
     *      然后按照查询的属性和匹配规则拼接即可
     * @param userName
     * @param birthday
     * @return
     */
    List<User> findByUserNameAndBirthdayLike(String userName, String birthday);
}
