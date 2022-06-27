package com.mypc.cadastroalunoescola.Controller;

import com.mypc.cadastroalunoescola.dto.request.AlunoDTO;
import com.mypc.cadastroalunoescola.dto.response.AlunoDTOResponse;
import com.mypc.cadastroalunoescola.model.Aluno;
import com.mypc.cadastroalunoescola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoRestController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTOResponse>> buscarTodos(){
        List<AlunoDTOResponse> alunoDTOResponses = new ArrayList<>();
        alunoService.buscarTodos().iterator().forEachRemaining(aluno ->
                alunoDTOResponses.add(new AlunoDTOResponse(aluno)));
        return ResponseEntity.ok(alunoDTOResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTOResponse> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(new AlunoDTOResponse(alunoService.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<AlunoDTOResponse> inserir(@RequestBody AlunoDTO alunoDTO){
        Aluno aluno = alunoService.inserir(alunoDTO.convertToAluno());
        return ResponseEntity.ok(new AlunoDTOResponse(aluno));
    }

    @PostMapping("/{id}")
    public ResponseEntity<AlunoDTOResponse> atualizar(@PathVariable int id, @RequestBody AlunoDTO alunoDTO){
        Aluno aluno = alunoService.inserir(alunoDTO.convertToAluno());
        return ResponseEntity.ok(new AlunoDTOResponse(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoDTOResponse> deletar(@PathVariable int id){
        alunoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
