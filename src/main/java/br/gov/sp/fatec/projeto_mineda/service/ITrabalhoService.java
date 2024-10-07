package br.gov.sp.fatec.projeto_mineda.service;

import java.util.List;

import br.gov.sp.fatec.projeto_mineda.entity.Trabalho;

public interface ITrabalhoService {

    // Método de cadastro
    Trabalho cadastrarTrabalho(Trabalho trabalho);

    // Método para listar todos os registros
    List<Trabalho> listarTodos();

    // Método para buscar usando a consulta personalizada
    List<Trabalho> buscarPorTituloENota(String palavra, int nota);
    
}