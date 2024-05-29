package br.com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.ecommerce.entity.Colaborador;
import br.com.ecommerce.service.ColaboradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
	@Autowired
    private ColaboradorService funcionarioService;

    
    public ColaboradorController(ColaboradorService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Colaborador> obterTodosFuncionarios() {
        return funcionarioService.obterTodosFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> obterFuncionarioPorId(@PathVariable Long id) {
        Optional<Colaborador> funcionario = funcionarioService.obterFuncionarioPorId(id);
        return funcionario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Colaborador> adicionarFuncionario(@Valid @RequestBody Colaborador funcionario) {
        Colaborador novoFuncionario = funcionarioService.salvarFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizarFuncionario(@PathVariable Long id, @Valid @RequestBody Colaborador funcionario) {
        if (!funcionarioService.existeFuncionario(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        funcionario.setId(id);
        Colaborador funcionarioAtualizado = funcionarioService.salvarFuncionario(funcionario);
        return new ResponseEntity<>(funcionarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        if (!funcionarioService.existeFuncionario(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        funcionarioService.deletarFuncionario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

