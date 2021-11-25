package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository _usuarioRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@GetMapping
	public ResponseEntity<?> exibeTodos(@PageableDefault(sort = "id", direction = Direction.ASC) Pageable paginacao) {
		Page<Usuario> usuarios = _usuarioRepo.findAll(paginacao);
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<?> criaUsuario(@RequestBody @Valid Usuario usuario) {
		try {
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			return new ResponseEntity<Usuario>(_usuarioRepo.save(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
