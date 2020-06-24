package br.com.projaula1.rabbit;

import br.com.projaula1.model.Cliente;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClienteProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queuecliente")
    @Autowired
    private Queue queue;

    public void send(final Cliente cliente){
        rabbitTemplate.convertAndSend(this.queue.getName(), cliente);
    }
}