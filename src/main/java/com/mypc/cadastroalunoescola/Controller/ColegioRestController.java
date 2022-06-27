package com.mypc.cadastroalunoescola.Controller;

import com.mypc.cadastroalunoescola.dto.request.ColegioDTO;
import com.mypc.cadastroalunoescola.model.Colegio;
import com.mypc.cadastroalunoescola.service.ColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("colegio")
public class ColegioRestController {

    @Autowired
    ColegioService colegioService;

    @GetMapping
    public ResponseEntity<Iterable<Colegio>> buscarTodos(){
        return  ResponseEntity.ok(colegioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colegio> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(colegioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Colegio> inserir(@RequestBody ColegioDTO colegioDTO){

        Colegio colegio = colegioService.inserir(colegioDTO.convertToColegio());
        return ResponseEntity.ok(colegio);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Colegio> atualizar(@PathVariable int id, @RequestBody ColegioDTO colegioDTO){

        Colegio colegio = colegioService.atualizar(id, colegioDTO.convertToColegio());
        return ResponseEntity.ok(colegio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Colegio> deletar(@PathVariable int id){
        colegioService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
