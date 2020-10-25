package com.forest.image.util;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Forest
 * @date 2020年10月25日 17:20
 */
@Component
@AllArgsConstructor
public class MailUtils {
    private final JavaMailSender javaMailSender;

    /**
     * 邮件发送
     *
     * @param
     * @return
     * @author dongyang
     * @date 2020/10/25 5:26 下午
     */
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("测试");
        message.setText("测试啊啊啊啊");
        message.setTo("bylbj23@126.com,");
        message.setFrom("bylbj23@126.com");
        javaMailSender.send(message);
    }
}
