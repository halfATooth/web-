package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Follow;
import com.example.test.bean.Like;
import com.example.test.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    String getNameById(Integer id);
    String getPwdById(Integer id);
    void addUser(User user);
    Integer getIdByName(String username);
    int setEmail(String email, String username);
    int changePwd(User user);
    String getEmail(String username);
    String getRole(Integer id);
    void initLike(String num);
    void addLike(Like like);//增加点赞数，add指数值++，实际上是update操作
    int getLikes(String num);
    void addFollow(Follow follow);
}
