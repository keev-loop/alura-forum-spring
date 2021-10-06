package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.forum.modelo.Topico;


@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

	// @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	// List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
