package geyao.pojo.vo;

import geyao.tool.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by geyao on 2017/3/30.
 */
@Component
public class Test {
    @Autowired
    private UserBO userBO;
    @Autowired
    private User user;

    public static void main(String[] args) {
        Test test = BeanFactory.getBean("test", Test.class);
        System.out.println(test.user);
        test.user.setName("l123i qi123an");
        System.out.println(test.userBO);
        test.userBO.saveUser(test.user);
    }

    public UserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(UserBO userBO) {
        this.userBO = userBO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
