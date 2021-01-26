package net.xdclass.enums;

import lombok.Getter;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description 状态码定义约束，共6位数，前三位代表服务，后4位代表接口
 *  比如 商品服务210,购物车是220、用户服务230，403代表权限
 *
 **/
public enum BizCodeEnum {

    /**
     * 通用操作码
     */
    OPS_REPEAT(110001,"重复操作"),

    /**
     *验证码
     */
    CODE_TO_ERROR(240001,"接收号码不合规"),
    CODE_LIMITED(240002,"验证码发送过快"),
    CODE_ERROR(240003,"验证码错误"),
    CODE_CAPTCHA(240101,"图形验证码错误"),

    /**
     * 账号
     */
    ACCOUNT_REPEAT(250001,"账号已经存在"),
    ACCOUNT_UNREGISTER(250002,"账号不存在"),
    ACCOUNT_PWD_ERROR(250003,"账号或者密码错误");


    @Getter
    private String message;

    @Getter
    private int code;

    private BizCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }



}
