package com.smart.dao;

import com.smart.bean.Car;
import com.smart.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    private static Map<String,User> users;

    static {
        users=new HashMap<String,User>();
        User user1 = new User("王一",21,true,new Car("宝马",2000000.0));
        User user2 = new User("林二",20,false,new Car("奥拓",10000.0));
        User user3 = new User("张三",30,true,new Car("奔驰",500000.0));
        users.put("王一",user1);
        users.put("林二",user2);
        users.put("张三",user3);
    }

    public Collection<User> getAllUsers(){
        return users.values();
    }

    public User getUserByName(String username){
        return users.get(username);
    }
}
