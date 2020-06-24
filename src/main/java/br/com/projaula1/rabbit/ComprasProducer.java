package br.com.projaula1.rabbit;

import br.com.projaula1.model.Compras;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComprasProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queuecompras")
    @Autowired
    private Queue queue;

    public void send(final Compras compras){
        rabbitTemplate.convertAndSend(this.queue.getName(), compras);
    }
}