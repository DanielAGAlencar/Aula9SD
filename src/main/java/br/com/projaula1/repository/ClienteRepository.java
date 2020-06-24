package br.com.projaula1.repository;

import br.com.projaula1.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
