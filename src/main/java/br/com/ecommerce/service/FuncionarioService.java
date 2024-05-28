package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.entity.Funcionario;
import br.com.ecommerce.exception.ResourceNotFoundException;
import br.com.ecommerce.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isEmpty())
			throw new ResourceNotFoundException("Id não encontrado");
		return funcionario.get();
	}

	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void deleteFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}

	public Funcionario atualizar(Long id, Funcionario funcionario) {
		if (funcionarioRepository.existsById(id)) {
			funcionario.setId(id);
			return funcionarioRepository.save(funcionario);
		}
		throw new ResourceNotFoundException("Funcionario com o id: " + id + " não encontrado!");
	}

}
