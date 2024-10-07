package br.gov.sp.fatec.projeto_mineda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.projeto_mineda.entity.Trabalho;
import br.gov.sp.fatec.projeto_mineda.service.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin 
public class TrabalhoController {

     @Autowired
    private TrabalhoService trabalhoService;

    // Rota para cadastro de um trabalho
    @PostMapping(value = "/cadastro")
    public ResponseEntity<Trabalho> cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        try {
            Trabalho novoTrabalho = trabalhoService.cadastrarTrabalho(trabalho);
            return ResponseEntity.ok(novoTrabalho);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);  // Retorna 400 em caso de erro de validação
        }
    }

    // Rota para listar todos os trabalhos
    @GetMapping(value = "/listar")
    public ResponseEntity<List<Trabalho>> listarTodos() {
        List<Trabalho> trabalhos = trabalhoService.listarTodos();
        return ResponseEntity.ok(trabalhos);
    }

    // Rota para buscar por título e nota
    @GetMapping(value = "/buscar")
    public ResponseEntity<List<Trabalho>> buscarPorTituloENota(
            @RequestParam("palavra") String palavra,
            @RequestParam("nota") int nota) {
        List<Trabalho> trabalhos = trabalhoService.buscarPorTituloENota(palavra, nota);
        return ResponseEntity.ok(trabalhos);
    }
    
}
