package com.yujia;

import com.yujia.dao.UserDao;
import com.yujia.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-dao.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        System.out.println("users = " + users);
    }

    @Test
    public void selectByJpql() {
        List<User> users = userDao.selectByJpql("lucy", "123");
        System.out.println("users = " + users);
    }

    @Test
    public void selectBySql() {
        List<User> users = userDao.selectBySql("lucy", "123");
        System.out.println("users = " + users);
    }

    @Test
    public void findByUserNameAndBirthdayLike() {
        List<User> users = userDao.findByUserNameAndBirthdayLike("lucy", "2020%");
        System.out.println("users = " + users);
    }

    @Test
    public void sort() {
        Sort sort = new Sort(Sort.Direction.DESC, "birthday");
        List<User> users = userDao.findAll(sort);
        System.out.println("users = " + users);
    }

    @Test
    public void pagea() {
        Pageable pageable = PageRequest.of(2, 2);
        Page<User> userPage = userDao.findAll(pageable);
        System.out.println("userPage = " + userPage);
    }


    @Test
    public void findAllBySpecificationAndSort() {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(criteriaBuilder.equal(root.get("userName"), "lucy"), criteriaBuilder.like(root.get("birthday"), "2020%"));
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> list = userDao.findAll(specification, sort);
        System.out.println("list = " + list);
    }
}
