package com.mypc.cadastroalunoescola.model;

import com.mypc.cadastroalunoescola.dto.response.ColegioDTOResponse;

import javax.persistence.*;

@Entity
public class Colegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToOne
    private Endereco endereco;

    public Colegio(String nome, String cep) {
        endereco = new Endereco();
        this.nome = nome;
        this.endereco.setCep(cep);
    }
    public Colegio() {
    }

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
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public ColegioDTOResponse convertToResponse() {
        return new ColegioDTOResponse(getId(), getNome());
    }
}
