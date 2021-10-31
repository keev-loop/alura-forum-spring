package br.com.alura.forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.alura.forum.service.AutenticacaoService;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private AutenticacaoService _autentifacaoServ;
	
	
	// CONFIGURAÇÕES DE AUTENTICAÇÃO
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(_autentifacaoServ).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	// CONFIGURAÇÕES DE AUTORIZAÇÃO
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/topicos").permitAll()
			.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
			.anyRequest().authenticated()
			.and().formLogin();
	}
	
	
	// CONFIGURAÇÕES DE RECURSOS ESTATICOS(CSS, JS, IMAGES, ETC)
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
	
}
