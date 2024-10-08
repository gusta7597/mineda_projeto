package br.gov.sp.fatec.projeto_mineda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.projeto_mineda.entity.Alerta;

public interface AlertaRepository extends CrudRepository<Alerta, Long>{
    @Query("SELECT a FROM Alerta a WHERE a.data_hora_geracao > :paramsup and a.data_hora_geracao < :paraminf")
    List<Alerta> findByDataHoraGeracaoGreaterThanLessThan(
        @Param("paramsup") LocalDateTime param, 
        @Param("paraminf") LocalDateTime param_inf
    );
}