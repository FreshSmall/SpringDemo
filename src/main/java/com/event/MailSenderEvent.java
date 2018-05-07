package com.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MailSenderEvent extends ApplicationContextEvent {

    //表明邮件发送目的地地址
    private String to;

    public MailSenderEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getIo() {
        return this.to;
    }
}
