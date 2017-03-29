package geyao.pojo.vo;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import geyao.tool.BeanFactory;

import javax.annotation.Resource;

/**
 * Created by geyao on 2017/3/29.
 */
@Component
@DependsOn("userBO")
class UserTest {
    @Resource(name = "userBO")
    private UserBO userBO;
    @Autowired
    private SessionFactory sessionFactory;
    @org.junit.jupiter.api.Test
    void setName() {
        User user = BeanFactory.getBean("user", User.class);
        user.setName("ge yao");
        System.out.println(user);
    }

    @Test
    void saveUser() {
        User user = BeanFactory.getBean("user", User.class);
        user.setName("yao ge");
        System.out.println(userBO);
        userBO.saveUser(user);
    }

    public UserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(UserBO userBO) {
        this.userBO = userBO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}