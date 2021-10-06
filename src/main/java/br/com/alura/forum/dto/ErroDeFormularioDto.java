package br.com.alura.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroDeFormularioDto {

	private String campo;
	private String erro;
	
}
