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
    @Autowired
    private UserDAO userDAO;

    public static void main(String[] args) {
        Test test = BeanFactory.getBean("test", Test.class);
        test.user = test.userDAO.getOne(19);
        test.userBO.templateTest(test.user);
    }
}
