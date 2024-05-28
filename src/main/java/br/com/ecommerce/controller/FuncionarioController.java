package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.entity.Funcionario;
import br.com.ecommerce.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
		return ResponseEntity.ok(funcionarioService.getAllFuncionarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
		return ResponseEntity.ok(funcionarioService.getFuncionarioById(id));
	}

	@PostMapping
	public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.saveFuncionario(funcionario));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		Funcionario funcionarioAtualizado = funcionarioService.atualizar(id, funcionario);
		if (funcionarioAtualizado != null) {
			return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
		funcionarioService.deleteFuncionario(id);
		return ResponseEntity.noContent().build();
	}
}
