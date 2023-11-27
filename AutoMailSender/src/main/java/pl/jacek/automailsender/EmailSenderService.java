package pl.jacek.automailsender;

import jakarta.mail.internet.InternetAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.jacek.automailsender.model.MailRequestModel;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender mailSender;

    public SimpleMailMessage prepareEmail(MailRequestModel requestModel) {
        SimpleMailMessage mailReadyToSend = new SimpleMailMessage();
        mailReadyToSend.setTo(requestModel.getEmailTo());
        mailReadyToSend.setText(requestModel.getBody());
        mailReadyToSend.setSubject(requestModel.getSubject());
        return mailReadyToSend;
    }

    public String sendEmail(MailRequestModel requestModel) throws InterruptedException {
        SimpleMailMessage simpleMailMessage = prepareEmail(requestModel);
        for(int i = 0; i < requestModel.getHowManyTimes(); i++) {
            mailSender.send(simpleMailMessage);
            Thread.sleep(requestModel.getDelay());
        }
        return "Mail with subject: " + requestModel.getSubject() +
                ", has been sent " + requestModel.getHowManyTimes() + " times";
    }
}
