package net.xdclass.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.enums.BizCodeEnum;
import net.xdclass.enums.SendCodeEnum;
import net.xdclass.component.MailService;
import net.xdclass.service.NotifyService;
import net.xdclass.util.CheckUtil;
import net.xdclass.util.CommonUtil;
import net.xdclass.util.JsonData;
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
@Slf4j
public class NotifyServiceImpl implements NotifyService {


    @Autowired
    private MailService mailService;

    /**
     * 验证码的标题
     */
    private static final String SUBJECT= "小滴课堂验证码";

    /**
     * 验证码的内容
     */
    private static final String CONTENT= "您的验证码是%s,有效时间是60秒,打死也不要告诉任何人";


    @Override
    public JsonData sendCode(SendCodeEnum sendCodeEnum, String to) {

        if(CheckUtil.isEmail(to)){
            //邮箱验证码
            String code = CommonUtil.getRandomCode(6);
            mailService.sendMail(to,SUBJECT,String.format(CONTENT,code));
            return JsonData.buildSuccess();

        } else if(CheckUtil.isPhone(to)){
            //短信验证码

        }

        return JsonData.buildResult(BizCodeEnum.CODE_TO_ERROR);
    }
}
