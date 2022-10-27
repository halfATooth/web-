package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Practice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PracticeMapper extends BaseMapper<Practice> {
    void addPractice(Practice practice);
    void deletePractice(String eventId);
    void updatePractice(Practice practice);
    Practice getPractice(String eventId);
    List<Practice> getAllKindsPractice(String num);
    List<Practice> getOneTypePractice(String num,String type);
}
