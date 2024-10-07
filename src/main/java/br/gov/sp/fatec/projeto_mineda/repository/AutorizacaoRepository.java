package br.gov.sp.fatec.projeto_mineda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import br.gov.sp.fatec.projeto_mineda.entity.Autorizacao;
// import br.gov.sp.fatec.projeto_mineda.entity.Usuario;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long>{

    // public Optional<Autorizacao> getById(Long id);

    @Query("select a from Autorizacao a where a.id = ?1")
    public Optional<Autorizacao> findById(Long id);
    
}
