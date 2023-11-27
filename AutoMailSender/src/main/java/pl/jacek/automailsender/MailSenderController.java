package pl.jacek.automailsender;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jacek.automailsender.model.MailRequestModel;

@RestController
@RequestMapping("/api/mail")
@RequiredArgsConstructor
public class MailSenderController {

    private final EmailSenderService emailSenderService;

    @PostMapping("/send")
    public String sendMail(@RequestBody MailRequestModel requestModel) throws InterruptedException {
        return emailSenderService.sendEmail(requestModel);
    }
}
