package pl.jacek.automailsender.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailRequestModel {
    private String emailTo;
    private String subject;
    private String body;
    private int howManyTimes;
    private int delay;
}
