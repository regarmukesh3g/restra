package org.amdocs.vm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import javax.validation.Valid;

@SpringBootApplication
public class TicketMonsterApplication {

    public static void main1(@Valid String[] args) {
        ConfigurableApplicationContext a = SpringApplication.run(TicketMonsterApplication.class, args);

//        Ticket t = a.getBean(Ticket.class);

    }

}
