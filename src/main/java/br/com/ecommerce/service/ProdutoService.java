package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dto.ClienteRequestDTO;
import br.com.ecommerce.dto.ClienteResponseDTO;
import br.com.ecommerce.dto.ProdutoResponseDTO;
import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> buscarProduto() {
		return repository.findAll();
	}

	public Optional<Produto> buscarProduto(Long id) {
		return repository.findById(id);
	}

	public ResponseEntity<Produto> inserirProduto(Produto produto) {
	    Produto p = new Produto();
	    p.setCategoria(produto.getCategoria());
	    p.setNome(produto.getNome());
	    	    
	    return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
