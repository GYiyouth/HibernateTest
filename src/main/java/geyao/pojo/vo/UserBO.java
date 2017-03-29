package geyao.pojo.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by geyao on 2017/3/30.
 */
@Service
@DependsOn(value = "userDAO")
public class UserBO {
    @Resource(name = "userDAO")
    private UserDAO userDAO;

    @Transactional
    public void saveUser(User user){
        userDAO.saveUser(user);
        System.out.println("完成啦");
        user.setName("ge yao");
        userDAO.saveUser(user);
        System.out.println("完成啦");
    }
}
