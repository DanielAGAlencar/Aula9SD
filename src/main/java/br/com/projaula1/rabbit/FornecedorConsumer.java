package br.com.projaula1.rabbit;

import br.com.projaula1.model.Fornecedor;
import br.com.projaula1.service.FornecedorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FornecedorConsumer {

    @Autowired
    private FornecedorService fornecedorService;

    @RabbitListener(queues = {"${queue.fornecedor.name}"})
    public void receive (@Payload Fornecedor fornecedor){
        System.out.println("Id: "+ fornecedor.getId() + "\nNome: " + fornecedor.getNome() + "\nTelefone: " + fornecedor.getTelefone() + "\nCNPJ: " + fornecedor.getCnpj());
        //Inserir dado no Mongo
        fornecedorService.save(fornecedor);
    }
}