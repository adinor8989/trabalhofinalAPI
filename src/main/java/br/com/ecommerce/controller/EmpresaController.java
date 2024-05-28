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

import br.com.ecommerce.dto.EmpresaResponseDTO;
import br.com.ecommerce.entity.Empresa;
import br.com.ecommerce.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> listar() {
        List<EmpresaResponseDTO> empresa = service.listar();
        return ResponseEntity.ok(empresa);
    }
	@GetMapping("/{cnpj}")
	public ResponseEntity<EmpresaResponseDTO> buscarPorCnpj(@PathVariable String cnpj) {
		EmpresaResponseDTO dto = service.buscar(cnpj);
		if (dto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<EmpresaResponseDTO> inserir(@RequestBody Empresa empresaResponseDTO) {
		EmpresaResponseDTO inserir = service.inserir(empresaResponseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(inserir);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmpresaResponseDTO> atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
	    EmpresaResponseDTO atualizado = service.atualizar(id, empresa);
	    if (atualizado == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(atualizado);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
	    boolean deletado = service.deletar(id);
	    if (!deletado) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.noContent().build();
	}
}
