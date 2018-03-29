package jp.co.tlzs.service;

import jp.co.tlzs.mapper.UserMapper;
import jp.co.tlzs.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login() {
        return null;
    }


    public User login(String account) {
        return userMapper.findByAccount(account);
    }

    @Transactional
    public boolean register(User user){
        try {
            userMapper.insertUser(user);
            //add point

            //add sms

            //...
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
