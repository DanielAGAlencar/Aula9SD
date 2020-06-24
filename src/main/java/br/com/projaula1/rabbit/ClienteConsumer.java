package br.com.projaula1.rabbit;

import br.com.projaula1.model.Cliente;
import br.com.projaula1.service.ClienteService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClienteConsumer {

    @Autowired
    private ClienteService clienteService;

    @RabbitListener(queues = {"${queue.cliente.name}"})
    public void receive (@Payload Cliente cliente){
        System.out.println("Id: "+ cliente.getId() + "\nNome: " + cliente.getNome() + "\nTelefone: " + cliente.getTelefone() + "\nCPF: " + cliente.getCpf());
        //Inserir dado no Mongo
        clienteService.save(cliente);
    }
}