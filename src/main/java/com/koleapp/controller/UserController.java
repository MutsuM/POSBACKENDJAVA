package com.koleapp.controller;

import javax.annotation.Resource;

import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

	@Resource(name = "tokenServices")
	private ConsumerTokenServices tokenServices;//Es una clase de SPring Oauth

	@GetMapping(value = "/anular/{tokenId:.*}")//el ":.*" es como una expresión regular para capturar todo el valor del token, ya que en su cadena de texto, existen puntos.
	public void revokeToken(@PathVariable("tokenId") String token) {
		tokenServices.revokeToken(token);				
	}
}
