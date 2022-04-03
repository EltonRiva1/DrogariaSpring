package br.pro.delfino.drogaria.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drogaria")
public class DrogariaControlador {
	@RequestMapping("/ola")
	public String exibirMensagem() {
		return "Programação Web com Spring";
	}
}
