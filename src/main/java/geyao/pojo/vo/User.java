package geyao.pojo.vo;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.StringTokenizer;

/**
 * Created by geyao on 2017/3/29.
 */
@Entity()
@Table(name = "users")
@org.springframework.stereotype.Component("user")
public class User {

    @Id
    @GeneratedValue()
    private Integer id;

    private String firstName;
    private String lastName;

    @Column
    public String getName(){
        return firstName + " " + lastName;
    }

    @Column
    public void setName(String name){
        StringTokenizer t = new StringTokenizer(name);
        firstName = t.nextToken();
        lastName = t.nextToken();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
