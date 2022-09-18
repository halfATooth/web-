package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    void addTag(Tag tag);
    List<Tag> getTags();
    boolean deleteTags();
    void updateTags(Tag tag);
}
