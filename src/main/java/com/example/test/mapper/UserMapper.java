package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    String getNameById(Integer id);
    String getPwdById(Integer id);
    int addUser(User user);
    Integer getIdByName(String username);
    int setEmail(String email, String username);
    int changePwd(User user);
    String getEmail(String username);
    String getRole(Integer id);
}
