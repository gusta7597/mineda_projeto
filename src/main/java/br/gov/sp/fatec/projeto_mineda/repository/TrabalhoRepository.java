package br.gov.sp.fatec.projeto_mineda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.projeto_mineda.entity.Trabalho;

public interface TrabalhoRepository extends CrudRepository<Trabalho, Long> {
    
    // Criado com base no item 2 da avaliação
    @Query("SELECT t FROM Trabalho t WHERE t.nome LIKE %:palavra% AND t.nota > :nota")
    List<Trabalho> findByTituloContainingAndNotaGreaterThan(
        @Param("palavra") String palavra, 
        @Param("nota") int nota
    );
}