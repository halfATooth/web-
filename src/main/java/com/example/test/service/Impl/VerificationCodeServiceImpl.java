package com.example.test.service.Impl;

import com.example.test.bean.VerificationCode;
import com.example.test.mapper.VerificationCodeMapper;
import com.example.test.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    private VerificationCodeMapper verificationCodeMapper;
    @Override
    public Map<String, String> addCode(VerificationCode v) {
        Map<String,String> res = new HashMap<>();
        String name = v.getUsername();
        Integer vc = verificationCodeMapper.getCodeByName(name);
        if(vc == null){
            verificationCodeMapper.addCode(v);
        }else {
            verificationCodeMapper.updateCode(v);
        }
        res.put("code","0");
        res.put("msg","验证码更新");
        return res;
    }

    @Override
    public Map<String, String> checkCode(VerificationCode v) {
        Map<String,String> res = new HashMap<>();
        Integer vc = verificationCodeMapper.getCodeByName(v.getUsername());
        if(vc == null || vc==-1){
            res.put("code","1");
            res.put("msg","未发先用");
            return res;
        }
        long time = verificationCodeMapper.getTime(v.getUsername());
        if(v.getCheck_time() - time > 600){
            res.put("code","2");
            res.put("msg","验证码失效");
        }else {
            if(vc != v.getCode()){
                res.put("code","3");
                res.put("msg","验证码错误");
            }else {
                res.put("code","0");
                res.put("msg","验证成功");
                VerificationCode verificationCode = new VerificationCode(
                        v.getUsername(), v.getCheck_time(),-1
                );
                verificationCodeMapper.updateCode(verificationCode);
            }
        }
        return res;
    }
}
