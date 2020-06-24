package br.com.projaula1.rabbit;

import br.com.projaula1.model.Produto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queueproduto")
    @Autowired
    private Queue queue;

    public void send(final Produto produto){
        rabbitTemplate.convertAndSend(this.queue.getName(), produto);
    }
}