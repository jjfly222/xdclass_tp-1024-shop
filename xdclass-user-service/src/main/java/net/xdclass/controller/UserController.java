package net.xdclass.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.xdclass.enums.BizCodeEnum;
import net.xdclass.request.UserRegisterRequest;
import net.xdclass.service.FileService;
import net.xdclass.service.UserService;
import net.xdclass.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 二当家小D
 * @since 2021-01-26
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/user/v1")
public class UserController {



    @Autowired
    private FileService fileService;


    @Autowired
    private UserService userService;

    /**
     * 上传用户头像
     *
     * 默认最大是1M,超过则报错
     *
     * @param file 文件
     * @return
     */
    @ApiOperation("用户头像上传")
    @PostMapping(value = "upload")
    public JsonData uploadUserImg(
            @ApiParam(value = "文件上传",required = true)
            @RequestPart("file") MultipartFile file){

        String result = fileService.uploadUserImg(file);


        return result!=null? JsonData.buildSuccess(result):JsonData.buildResult(BizCodeEnum.FILE_UPLOAD_USER_IMG_FAIL);
    }


    /**
     *  用户注册
     * @param registerRequest
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping("register")
    public JsonData register(@ApiParam("用户注册对象") @RequestBody UserRegisterRequest registerRequest){

        JsonData jsonData = userService.register(registerRequest);
        return jsonData;
    }




}

