package com.mypc.cadastroalunoescola.dto.request;

import com.mypc.cadastroalunoescola.model.Notas;

public class NotasDTO {
    private int id_aluno;
    private float unidade1;
    private float unidade2;
    private float unidade3;
    private float unidade4;

    public Notas convertToNotas(){
        return new Notas(getId_aluno(), getUnidade1(), getUnidade2(), getUnidade3(), getUnidade4());
    }
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
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
}
