package br.com.projaula1.service;

import br.com.projaula1.model.Compras;
import br.com.projaula1.rabbit.ComprasProducer;
import br.com.projaula1.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    @Autowired
    private ComprasProducer comprasProducer;

    public Compras sendComprasRabbit(Compras compras){
        comprasProducer.send(compras);
        return compras;
    }

    public void save(Compras compras){
        comprasRepository.save(compras);
    }
    public List<Compras> findAll(){
        return comprasRepository.findAll();
    }
    public Optional<Compras> findById(String id){
        return comprasRepository.findById(id);
    }
    public void delete(String id){
        comprasRepository.deleteById(id);
    }

    public void deleteAll(){
        comprasRepository.deleteAll();
    }
}