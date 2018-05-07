package com.event;

import org.springframework.context.ApplicationListener;

public class MailSenderListener implements ApplicationListener<MailSenderEvent> {

    //对MailSendEvent事件进行处理
    @Override
    public void onApplicationEvent(MailSenderEvent event) {
        MailSenderEvent mse=event;
        System.out.println("MailSendListener:向"+mse.getIo()+"发送完一封邮件");
    }
}
