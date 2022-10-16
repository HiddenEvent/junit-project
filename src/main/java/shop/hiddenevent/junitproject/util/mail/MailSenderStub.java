package shop.hiddenevent.junitproject.util.mail;

import org.springframework.stereotype.Component;

//@Component // Ioc 컨테이너 등록
public class MailSenderStub implements MailSender {
    @Override
    public boolean send() {
        return true;
    }
}
