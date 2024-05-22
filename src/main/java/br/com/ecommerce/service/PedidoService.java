package br.com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
}
