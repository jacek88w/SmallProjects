package pl.jacek.automailsender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AutoMailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoMailSenderApplication.class, args);

	}
}
