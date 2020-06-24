package br.com.projaula1.rabbit;

import br.com.projaula1.model.Venda;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VendaProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queuevenda")
    @Autowired
    private Queue queue;

    public void send(final Venda venda){
        rabbitTemplate.convertAndSend(this.queue.getName(), venda);
    }
}