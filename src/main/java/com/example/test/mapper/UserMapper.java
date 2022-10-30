package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Comments;
import com.example.test.bean.Follow;
import com.example.test.bean.Like;
import com.example.test.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
    Integer getLikes(String num);
    void addFollow(Follow follow);
    void addComments(Comments comments);
    List<String> getFollowers(String num);//谁关注了我
    List<String> getIdols(String num);//我关注了谁
    List<Comments> getComments(String num);
    //教师端功能
    List<String> getStudentsNum(String name);//传入教师的名字
}
