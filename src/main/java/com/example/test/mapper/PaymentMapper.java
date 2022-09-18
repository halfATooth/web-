package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
    void addPayment(Payment payment);
    List<Payment> getPayment(Integer id);
}
