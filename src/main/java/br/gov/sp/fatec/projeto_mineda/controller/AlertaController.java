package br.gov.sp.fatec.projeto_mineda.controller;

import java.time.LocalDateTime;
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

import br.gov.sp.fatec.projeto_mineda.entity.Alerta;
import br.gov.sp.fatec.projeto_mineda.service.AlertaService;

@RestController
@RequestMapping(value = "/alerta")
@CrossOrigin 

public class AlertaController {
    
    @Autowired
    private AlertaService alertaService;

    // Rota para cadastro de um trabalho
    @PostMapping(value = "/cadastro")
    public ResponseEntity<Alerta> cadastrarTrabalho(@RequestBody Alerta alerta) {
        try {
            Alerta novoAlerta = alertaService.cadastrarAlerta(alerta);
            return ResponseEntity.ok(novoAlerta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);  // Retorna 400 em caso de erro de validação
        }
    }

    // Rota para listar todos os trabalhos
    @GetMapping(value = "/listar")
    public ResponseEntity<List<Alerta>> listarTodos() {
        List<Alerta> alertas = alertaService.listarTodos();
        return ResponseEntity.ok(alertas);
    }

    // Rota para buscar por título e nota
    @GetMapping(value = "/buscar")
    public ResponseEntity<List<Alerta>> buscarPorDataSupeInferior(
            @RequestParam("param") LocalDateTime param,
            @RequestParam("param_inf") LocalDateTime param_inf) {
        List<Alerta> alertas = alertaService.buscarPorDataSupeInferior(param, param_inf);
        return ResponseEntity.ok(alertas);
    }
}
