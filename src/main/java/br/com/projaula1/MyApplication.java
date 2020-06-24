package br.com.projaula1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class MyApplication {

    @Value("${queue.produto.name}")
    private String produtoQueue;
    @Value("${queue.fornecedor.name}")
    private String fornecedorQueue;
    @Value("${queue.cliente.name}")
    private String clienteQueue;
    @Value("${queue.compras.name}")
    private String comprasQueue;
    @Value("${queue.venda.name}")
    private String vendaQueue;


    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public Queue queueproduto(){
        return new Queue(produtoQueue, true);
    }
    @Bean
    public Queue queuefornecedor(){
        return new Queue(fornecedorQueue, true);
    }
    @Bean
    public Queue queuecliente(){
        return new Queue(clienteQueue, true);
}
    @Bean
    public Queue queuecompras(){
        return new Queue(comprasQueue, true);
    }
    @Bean
    public Queue queuevenda(){
       return new Queue(vendaQueue, true);
    }

}