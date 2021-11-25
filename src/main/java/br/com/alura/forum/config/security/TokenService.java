package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class TokenService {

	
	// CONFIGURA DADOS PADRÕES/SECRETOS
	@Value("${forum.jwt.expiration}")
	private long expiration;
	@Value("${forum.jwt.secret}")
	private String secret;
	
	
	// GERA UM NOVO TOKEN APOS AUTENTICACAO
	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + expiration);
		
		return Jwts.builder()
				.setIssuer("API do Forum da Alura")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}


	// VERIFICA SE TOKEN É VALIDO
	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch(Exception err) {
			return false;
		}		
	}


	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();	
		return Long.parseLong(claims.getSubject());
	}
	

}
