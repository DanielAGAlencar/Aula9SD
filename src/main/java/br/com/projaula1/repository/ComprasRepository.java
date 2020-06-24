package br.com.projaula1.repository;

import br.com.projaula1.model.Compras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComprasRepository extends MongoRepository<Compras, String> {
}
