package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Daily;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DailyMapper extends BaseMapper<Daily> {
    void addDaily(Daily daily);
    List<Daily> getAllKindsDaily(Integer id);
    List<Daily> getOneTypeDaily(Integer id, String type);
}
