package br.com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.repository.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository repository;
}
