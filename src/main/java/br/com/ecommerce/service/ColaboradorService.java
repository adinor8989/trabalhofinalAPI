package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.entity.Colaborador;
import br.com.ecommerce.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	@Autowired
    private ColaboradorRepository funcionarioRepository;

   
    public ColaboradorService(ColaboradorRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Colaborador> obterTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Colaborador> obterFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Colaborador salvarFuncionario(Colaborador funcionario) {
        // Implemente suas validações aqui
        return funcionarioRepository.save(funcionario);
    }

    public boolean existeFuncionario(Long id) {
        return funcionarioRepository.existsById(id);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
