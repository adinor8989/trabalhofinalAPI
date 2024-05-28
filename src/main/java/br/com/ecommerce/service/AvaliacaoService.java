package br.com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.entity.Avaliacao;
import br.com.ecommerce.repository.AvaliacaoRepository;

    @Service
	public class AvaliacaoService {

	    @Autowired
	    private AvaliacaoRepository avaliacaoRepository;

	    public List<Avaliacao> listarAvaliacoes() {
	        return avaliacaoRepository.findAll();
	    }

	    public Avaliacao obterAvaliacaoPorId(Long id) {
	        return avaliacaoRepository.findById(id).orElse(null);
	    }

	    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
	        return avaliacaoRepository.save(avaliacao);
	    }

	    public void deletarAvaliacao(Long id) {
	        avaliacaoRepository.deleteById(id);
	    }
	}