package br.com.projaula1.controller;

import br.com.projaula1.constant.Constants;
import br.com.projaula1.model.Compras;
import br.com.projaula1.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @PostMapping(Constants.API_COMPRAS)
    public void save(@RequestBody Compras compras){
        comprasService.sendComprasRabbit(compras);
    }

    @GetMapping(Constants.API_COMPRAS)
    public List<Compras> findAll(){
        return comprasService.findAll();
    }

    @PutMapping(Constants.API_COMPRAS)
    public void update(@RequestBody Compras compras){
        comprasService.save(compras);
    }

    @DeleteMapping(Constants.API_COMPRAS + "/{id}")
    public void delete(@PathVariable("id") String id){
        comprasService.delete(id);
    }

    @GetMapping(Constants.API_COMPRAS + "/{id}")
    public Optional<Compras> findById(@PathVariable("id") String id){
        return comprasService.findById(id);
    }
}
