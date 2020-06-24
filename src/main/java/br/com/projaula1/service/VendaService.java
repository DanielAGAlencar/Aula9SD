package br.com.projaula1.service;

import br.com.projaula1.model.Venda;
import br.com.projaula1.rabbit.VendaProducer;
import br.com.projaula1.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaProducer vendaProducer;

    public Venda sendVendaRabbit(Venda venda){
        vendaProducer.send(venda);
        return venda;
    }

    public void save(Venda venda){
        vendaRepository.save(venda);
    }
    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }
    public Optional<Venda> findById(String id){
        return vendaRepository.findById(id);
    }
    public void delete(String id){
        vendaRepository.deleteById(id);
    }

    public void deleteAll(){
        vendaRepository.deleteAll();
    }
}