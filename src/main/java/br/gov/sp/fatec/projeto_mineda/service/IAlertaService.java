package br.gov.sp.fatec.projeto_mineda.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.projeto_mineda.entity.Alerta;

public interface IAlertaService {
    // Método de cadastro
    Alerta cadastrarAlerta(Alerta alerta);

    // Método para listar todos os registros
    List<Alerta> listarTodos();

    // Método para buscar usando a consulta personalizada
    List<Alerta> buscarPorDataSupeInferior(LocalDateTime param, LocalDateTime param_inf);
}