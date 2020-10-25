package com.forest.image.util;

import com.forest.image.config.MailProperties;
import com.forest.image.dto.MailMsgDTO;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Forest
 * @date 2020年10月25日 17:20
 */
@Component
@AllArgsConstructor
@EnableConfigurationProperties(MailProperties.class)
public class MailUtils {
    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    /**
     * 邮件发送
     *
     * @param
     * @return
     * @author dongyang
     * @date 2020/10/25 5:26 下午
     */
    public void sendMail(MailMsgDTO dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("生产环境异常:" + dto.getTitle());
        message.setText(dto.getText());
        message.setTo(mailProperties.getSendTo());
        message.setFrom(mailProperties.getSendFrom());
        javaMailSender.send(message);
    }
}
