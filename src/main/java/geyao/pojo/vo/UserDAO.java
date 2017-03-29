package geyao.pojo.vo;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by geyao on 2017/3/29.
 */
//@Transactional
@Service("userDAO")
public class UserDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void saveUser(User user){
        sessionFactory.getCurrentSession().save(user);
    }
}
