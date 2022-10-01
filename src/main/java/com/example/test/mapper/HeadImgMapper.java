package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.HeadImg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeadImgMapper extends BaseMapper<HeadImg> {
    Integer addImg(HeadImg headImg);
    Integer updateImg(HeadImg headImg);
    String getFileName(String num);
}
