package br.com.projaula1.repository;

import br.com.projaula1.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {
}
