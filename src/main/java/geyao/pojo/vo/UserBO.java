package geyao.pojo.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by geyao on 2017/3/30.
 */
@Service
@Transactional(readOnly = false)
public class UserBO {
    @Resource(name = "userDAO")
    private UserDAO userDAO;


    @Transactional(isolation = Isolation.SERIALIZABLE,
            propagation = Propagation.REQUIRED,
            rollbackForClassName = {"SQLException"},
            rollbackFor = {SQLException.class},
            noRollbackFor = RuntimeException.class,
            noRollbackForClassName = "RuntimeException")
    public void saveUser(User user){
        userDAO.saveUser(user);
        System.out.println("完成啦");
        userDAO.saveUser(user);
        System.out.println("完成啦");
    }

    public void templateTest(User user){
        user.setName("li qian");
        userDAO.saveUser2(user);
        System.out.println(userDAO.getUserList("ge"));
        System.out.println(userDAO.getUserList("li"));
    }
}
