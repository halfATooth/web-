package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.VerificationCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VerificationCodeMapper extends BaseMapper<VerificationCode> {
    int addCode(VerificationCode v);
    int updateCode(VerificationCode v);
    Integer getCodeByName(String username);
    long getTime(String username);
}
