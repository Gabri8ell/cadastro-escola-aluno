package com.mypc.cadastroalunoescola.dto.response;

import com.mypc.cadastroalunoescola.model.Notas;

public class NotasDTOResponse {
    private int id;
    private int id_aluno;
    private String nome_aluno;
    private float unidade1;
    private float unidade2;
    private float unidade3;
    private float unidade4;

    public NotasDTOResponse(Notas notas) {
        this.id = notas.getId();
        this.id_aluno = notas.getAluno().getId();
        this.nome_aluno = notas.getAluno().getNome();
        this.unidade1 = notas.getNota1();
        this.unidade2 = notas.getNota2();
        this.unidade3 = notas.getNota3();
        this.unidade4 = notas.getNota4();
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public float getUnidade1() {
        return unidade1;
    }

    public void setUnidade1(float unidade1) {
        this.unidade1 = unidade1;
    }

    public float getUnidade2() {
        return unidade2;
    }

    public void setUnidade2(float unidade2) {
        this.unidade2 = unidade2;
    }

    public float getUnidade3() {
        return unidade3;
    }

    public void setUnidade3(float unidade3) {
        this.unidade3 = unidade3;
    }

    public float getUnidade4() {
        return unidade4;
    }

    public void setUnidade4(float unidade4) {
        this.unidade4 = unidade4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
