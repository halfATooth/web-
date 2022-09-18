package com.example.test.service.Impl;

import com.example.test.bean.AddHonor;
import com.example.test.bean.Honor;
import com.example.test.bean.SelectedCourse;
import com.example.test.mapper.HonorMapper;
import com.example.test.mapper.StudentMapper;
import com.example.test.service.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HonorServiceImpl implements HonorService {
    @Autowired
    HonorMapper honorMapper;
    @Autowired
    StudentMapper studentMapper;
    private Integer getIdByN(Integer num){
        return studentMapper.getStuIdByNum(num);
    }
    @Override
    public Map<String, String> addHonor(Integer id, String honor) {
        Map<String, String> res = new HashMap<>();
        String[] honors = honor.split(",");
        try {
            for(int i = 0; i < honors.length; i++){
                AddHonor addHonor = new AddHonor(getIdByN(id),honors[i]);
                honorMapper.addHonor(addHonor);
            }
            res.put("code","0");
            res.put("msg","添加荣誉成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","添加荣誉失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }

    @Override
    public Map<String, String> setHonor(String details) {
        Map<String, String> res = new HashMap<>();
        Honor honor = new Honor();
        honor.setDetails(details);
        try {
            honorMapper.setHonor(honor);
            res.put("code","0");
            res.put("msg","设置荣誉信息成功");
        }catch (Exception e){
            res.put("code","1");
            res.put("msg","设置荣誉信息失败");
            res.put("error", String.valueOf(e));
        }
        return res;
    }
}
