package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Practice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PracticeMapper extends BaseMapper<Practice> {
    void addPractice(Practice practice);
    List<Practice> getAllKindsPractice(Integer id);
    List<Practice> getOneTypePractice(Integer id,String type);
}
