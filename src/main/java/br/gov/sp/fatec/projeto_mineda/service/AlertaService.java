package br.gov.sp.fatec.projeto_mineda.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projeto_mineda.entity.Alerta;
import br.gov.sp.fatec.projeto_mineda.repository.AlertaRepository;

@Service
public class AlertaService implements IAlertaService {
    
    @Autowired
    private AlertaRepository alertaRepo;

    public Alerta cadastrarAlerta(Alerta alerta) {
        
        if (alerta.getMensagem() == null || alerta.getMensagem().isEmpty()) {
            throw new IllegalArgumentException("A mensagem deve estar preenchida!");
        }

        alerta.setData_hora_geracao(LocalDateTime.now());
        
        return alertaRepo.save(alerta);
    }

    public List<Alerta> listarTodos() {
        return (List<Alerta>) alertaRepo.findAll();
    }

    public List<Alerta> buscarPorDataSupeInferior(LocalDateTime param, LocalDateTime param_inf) {
        return alertaRepo.findByDataHoraGeracaoGreaterThanLessThan(param, param_inf);
    }
}
