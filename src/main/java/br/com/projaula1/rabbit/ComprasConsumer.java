package br.com.projaula1.rabbit;

import br.com.projaula1.model.Compras;
import br.com.projaula1.service.ComprasService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ComprasConsumer {

    @Autowired
    private ComprasService comprasService;

    @RabbitListener(queues = {"${queue.compras.name}"})
    public void receive (@Payload Compras compras){
        System.out.println("Id: "+ compras.getId() + "\nDescrição: " + compras.getDescricao() + "\nProduto: " + compras.getProduto() + "\nFornecedor: " + compras.getFornecedor());
        //Inserir dado no Mongo
        comprasService.save(compras);
    }
}