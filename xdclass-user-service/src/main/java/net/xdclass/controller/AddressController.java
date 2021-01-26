package net.xdclass.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.xdclass.model.AddressDO;
import net.xdclass.service.AddressService;
import net.xdclass.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

/**
 * <p>
 * 电商-公司收发货地址表 前端控制器
 * </p>
 *
 * @author 二当家小D
 * @since 2021-01-26
 */
@Api(tags = "收货地址模块")
@RestController
@RequestMapping("/api/address/v1/")
public class AddressController {


    @Autowired
    private AddressService addressService;


    @ApiOperation("根据id查找地址详情")
    @GetMapping("/find/{address_id}")
    public Object detail(
            @ApiParam(value = "地址id",required = true)
            @PathVariable("address_id") long addressId){

        AddressDO addressDO = addressService.detail(addressId);

        return JsonData.buildSuccess(addressDO);
    }

}
