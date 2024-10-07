package br.gov.sp.fatec.projeto_mineda.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projeto_mineda.entity.Trabalho;
import br.gov.sp.fatec.projeto_mineda.repository.TrabalhoRepository;

@Service
public class TrabalhoService implements ITrabalhoService{

    @Autowired
    private TrabalhoRepository trabalhoRepo;

		// Criado com base no item 3 da avaliação
    // Método de cadastro
    public Trabalho cadastrarTrabalho(Trabalho trabalho) {
        // Verifica se o nome (título) e o grupo estão preenchidos
        if (trabalho.getNome() == null || trabalho.getNome().isEmpty()) {
            throw new IllegalArgumentException("O título deve estar preenchido!");
        }
        if (trabalho.getGrupo() == null || trabalho.getGrupo().isEmpty()) {
            throw new IllegalArgumentException("O grupo deve estar preenchido!");
        }

        // Verifica se a data/hora de entrega foi preenchida, se não, define a atual
        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }

        // Salva o trabalho no repositório
        return trabalhoRepo.save(trabalho);
    }

    // Método para listar todos os registros
    public List<Trabalho> listarTodos() {
        return (List<Trabalho>) trabalhoRepo.findAll();
    }
    
    // Método para buscar usando a consulta criada no item 2
    public List<Trabalho> buscarPorTituloENota(String palavra, int nota) {
        return trabalhoRepo.findByTituloContainingAndNotaGreaterThan(palavra, nota);
    }
}
