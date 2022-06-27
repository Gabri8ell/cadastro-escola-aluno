package com.mypc.cadastroalunoescola.model;

import javax.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToOne
    private Colegio colegio;
    @ManyToOne
    private Endereco endereco;

    public Aluno(String nome, int id_colegio, String cep) {
        colegio = new Colegio();
        endereco = new Endereco();
        this.nome = nome;
        this.colegio.setId(id_colegio);
        this.endereco.setCep(cep);
    }

    public Aluno() {
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
    public Colegio getColegio() {
        return colegio;
    }
    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }
}
