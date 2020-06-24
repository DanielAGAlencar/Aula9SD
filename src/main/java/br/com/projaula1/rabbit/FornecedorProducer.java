package br.com.projaula1.rabbit;

import br.com.projaula1.model.Fornecedor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FornecedorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queuefornecedor")
    @Autowired
    private Queue queue;

    public void send(final Fornecedor fornecedor){
        rabbitTemplate.convertAndSend(this.queue.getName(), fornecedor);
    }
}