package br.com.projaula1.rabbit;

import br.com.projaula1.model.Venda;
import br.com.projaula1.service.VendaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class VendaConsumer {

    @Autowired
    private VendaService vendaService;

    @RabbitListener(queues = {"${queue.venda.name}"})
    public void receive (@Payload Venda venda){
        System.out.println("Id: "+ venda.getId() + "\nDescrição: " + venda.getDescricao() +
                "\nProduto: " + venda.getProduto() + "\nCliente: " + venda.getCliente());
        //Inserir dado no Mongo
        vendaService.save(venda);
    }
}