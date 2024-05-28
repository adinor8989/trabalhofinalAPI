package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.entity.Avaliacao;
import br.com.ecommerce.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoService.listarAvaliacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> obterAvaliacaoPorId(@PathVariable Long id) {
        Avaliacao avaliacao = avaliacaoService.obterAvaliacaoPorId(id);
        if (avaliacao != null) {
            return ResponseEntity.ok(avaliacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.salvarAvaliacao(avaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
        Avaliacao avaliacaoExistente = avaliacaoService.obterAvaliacaoPorId(id);
        if (avaliacaoExistente != null) {
            avaliacao.setId(id);
            return ResponseEntity.ok(avaliacaoService.salvarAvaliacao(avaliacao));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAvaliacao(@PathVariable Long id) {
        Avaliacao avaliacao = avaliacaoService.obterAvaliacaoPorId(id);
        if (avaliacao != null) {
            avaliacaoService.deletarAvaliacao(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        } 
    }

}