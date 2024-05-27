package br.com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.dto.PedidoResponseDTO;
import br.com.ecommerce.service.PedidoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping
	public PedidoResponseDTO inserir(@RequestBody PedidoResponseDTO pedidoDTO) {
		return service.inserir(pedidoDTO);
	}
	
}
