package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.DayOff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DayOffMapper extends BaseMapper<DayOff> {
    void addDayOff(DayOff dayOff);
    List<DayOff> getDayOff(Integer id);
}
