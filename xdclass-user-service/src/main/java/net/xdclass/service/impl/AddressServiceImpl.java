package net.xdclass.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.xdclass.mapper.AddressMapper;
import net.xdclass.model.AddressDO;
import net.xdclass.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public AddressDO detail(Long id) {

        AddressDO addressDO = addressMapper.selectOne(new QueryWrapper<AddressDO>().eq("id",id));


        return addressDO;
    }
}
