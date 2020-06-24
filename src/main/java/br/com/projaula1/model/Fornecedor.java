package br.com.projaula1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document

public class Fornecedor implements Serializable {

    @Id
    private int id;
    private String nome;
    private int telefone;
    private int cnpj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cpf) {
        this.cnpj = cnpj;
    }
}

