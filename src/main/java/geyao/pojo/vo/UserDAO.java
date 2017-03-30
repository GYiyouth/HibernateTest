package geyao.pojo.vo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by geyao on 2017/3/29.
 */
//@Transactional
@Service("userDAO")
public class UserDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveUser(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    public void saveUser2(User user){
        hibernateTemplate.save(user);
    }

    public void updateUser(User user){
        hibernateTemplate.update(user);
    }

    public User getOne(int id){
        return hibernateTemplate.get(User.class, id);
    }

    public List<User> getUserList(String firstName){
        return  (List<User>)
                hibernateTemplate.find(
                "from User u where u.firstName like ?", firstName + "%"
        );
    }
}
