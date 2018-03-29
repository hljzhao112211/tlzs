package jp.co.tlzs.mapper;


import jp.co.tlzs.po.User;

import java.util.List;

public interface UserMapper{
    public User get(Long id);

    public List<User> find();

    public User findByAccount(String account);

    public boolean insertUser(User user);
}
