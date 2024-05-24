package br.com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Optional<Produto> buscarProduto(Long id) {
		return repository.findById(id);
	}
	
	public Produto inserirProduto(Produto produto) {
	  return repository.save(produto);
	}
}
