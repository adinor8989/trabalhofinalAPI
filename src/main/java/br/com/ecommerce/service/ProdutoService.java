package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dto.ProdutoRequestDTO;
import br.com.ecommerce.dto.ProdutoResponseDTO;
import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.exception.ResourceNotFoundException;
import br.com.ecommerce.repository.CategoriaRepository;
import br.com.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository catRepository;

	public List<ProdutoResponseDTO> buscarProduto() {
		return repository.findAll().stream().map((i) -> new ProdutoResponseDTO(i)).collect(Collectors.toList());
	}

	public ProdutoResponseDTO buscarProduto(Long id) {
	Optional<Produto> produto =	repository.findById(id);
	if (produto.get() == null) new ResourceNotFoundException("Produto não foi encontrado");
	return new ProdutoResponseDTO(produto.get());
	}
	

	public ProdutoResponseDTO inserirProduto(ProdutoRequestDTO produto) {
		Produto p = new Produto();
		Optional<Categoria> c = catRepository.findById(produto.getIdCategoria());
		if (c.isEmpty()) {
			 new ResourceNotFoundException("Categoria Não existe");
		} 
		p.setCategoria(c.get());
		p.setNome(produto.getNome());
		return new ProdutoResponseDTO(p);
	}
}
