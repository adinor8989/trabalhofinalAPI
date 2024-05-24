package br.com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.entity.Categoria;
import br.com.ecommerce.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {
	
	

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscarid (Long id) {
		Optional<Categoria> categorias = repository.findById(id);
		return categorias.get();
	}
	
	public Categoria inserirCategoria(Categoria categoria) {
			return repository.save(categoria);
	}
	
	public Categoria alterarCategoria(Categoria categoria, Long id) {
		Optional<Categoria> categoriaExistente = repository.findById(id);
		if (categoriaExistente != null) {
			categoria.setNome(categoria.getNome());
			return repository.save(categoria);
		} else {
			 throw new EntityNotFoundException("Categoria não encontrada");
		}
		
		
	}
	
	
	
	
}
