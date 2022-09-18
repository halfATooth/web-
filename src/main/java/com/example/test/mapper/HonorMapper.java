package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.AddHonor;
import com.example.test.bean.Honor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HonorMapper extends BaseMapper<Honor> {
    void setHonor(Honor honor);
    void addHonor(AddHonor addHonor);
    List<Honor> getHonor(Integer id);
    List<Honor> getSetHonor();
}
