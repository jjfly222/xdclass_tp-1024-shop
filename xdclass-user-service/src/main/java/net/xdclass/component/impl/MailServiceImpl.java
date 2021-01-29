package net.xdclass.component.impl;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.component.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
public class MailServiceImpl implements MailService {

    /**
     *  springboot 提供的一个发送邮件的简单抽象，直接注入即可
     */
    @Autowired
    private JavaMailSender mailSender;


    @Value("${spring.mail.from}")
    private String from;

    /**
     * 发送邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendMail(String to, String subject, String content) {

        //创建一个邮箱消息对象
        SimpleMailMessage message = new SimpleMailMessage();

        //配置邮箱发送人
        message.setFrom(from);

        //邮件的收件人
        message.setTo(to);

        //邮件的主题
        message.setSubject(subject);

        //邮件的内容
        message.setText(content);

        mailSender.send(message);

        log.info("邮件发送成功:{}",message.toString());

    }
}
