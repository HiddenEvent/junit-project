package shop.hiddenevent.junitproject.util.mail;

public class MailSenderAdapter implements MailSender {

//    private Mail mail;
//
//    public MailSenderAdapter(Mail mail) {
//        this.mail = new Mail();
//    }

    @Override
    public boolean send() {
        return true;
    }
}
