package com.mypc.cadastroalunoescola.Controller;

import com.mypc.cadastroalunoescola.dto.request.NotasDTO;
import com.mypc.cadastroalunoescola.dto.response.NotasDTOResponse;
import com.mypc.cadastroalunoescola.model.Notas;
import com.mypc.cadastroalunoescola.service.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("notas")
@RestController
public class NotasRestController {
    @Autowired
    NotasService notasService;

    @GetMapping
    public ResponseEntity<List<NotasDTOResponse>> buscarTodos(){
        List<NotasDTOResponse> notasDTOResponses = new ArrayList<>();
        notasService.buscarTodos().iterator().forEachRemaining(notas ->
                notasDTOResponses.add(new NotasDTOResponse(notas)));
        return ResponseEntity.ok(notasDTOResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotasDTOResponse> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(new NotasDTOResponse(notasService.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<NotasDTOResponse> inserir(@RequestBody NotasDTO notasDTO){
        Notas notas = notasService.inserir(notasDTO.convertToNotas());
        return ResponseEntity.ok(new NotasDTOResponse(notas));
    }

    @PostMapping("/{id}")
    public ResponseEntity<NotasDTOResponse> atualizar(@RequestBody NotasDTO notasDTO, @PathVariable int id){
        Notas notas = notasService.atualizar(id, notasDTO.convertToNotas());
        return ResponseEntity.ok(new NotasDTOResponse(notas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NotasDTOResponse> deletar(@PathVariable int id){
        notasService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
