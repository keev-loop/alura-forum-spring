package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import lombok.Data;


@Data
public class AtualizacaoTopicoForm {

	@NotNull	@NotEmpty	@Size(min=5)
	private String titulo;
	@NotNull	@NotEmpty	@Size(min=10)
	private String mensagem;
	
	
	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		
		return topico;
	}

}
