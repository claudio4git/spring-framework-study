package br.com.jccf.roomcleanernotifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RunnerAndSendMessage implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final ConfigurableApplicationContext context;

    public RunnerAndSendMessage(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper, ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
       AsyncPayload payload = new AsyncPayload();
       payload.setId(1);
       payload.setModel("ROOM");

       rabbitTemplate.convertAndSend("operations", "jccf.rooms.cleaner", objectMapper.writeValueAsString(payload));

       context.close();
    }
}
