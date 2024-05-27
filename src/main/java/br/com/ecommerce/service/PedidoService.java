package br.com.ecommerce.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dto.PedidoResponseDTO;
import br.com.ecommerce.entity.Carrinho;
import br.com.ecommerce.entity.Cliente;
import br.com.ecommerce.entity.Pedido;
import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.repository.ClienteRepository;
import br.com.ecommerce.repository.PedidoRepository;
import br.com.ecommerce.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public PedidoResponseDTO inserir(PedidoResponseDTO pedidoDTO) {
	    Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente().getId())
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	    Pedido pedido = new Pedido();
	    pedido.setCliente(cliente);
	    pedido.setStatus(pedidoDTO.getStatus());
	    List<Carrinho> produtos = new ArrayList<>();
	    for(Carrinho carrinho : pedidoDTO.getCarrinho()) {
	        Optional<Produto> produtoOptional = produtoRepository.findById(carrinho.getProduto().getId());
	        if (produtoOptional.isPresent()) {
	            Collection<? extends Carrinho> produto = (Collection<? extends Carrinho>) produtoOptional.get();
	            produtos.addAll(produto);
	        } else {
	            throw new RuntimeException("Produto não encontrado: " + carrinho.getProduto().getId());
	        }
	    }
	    pedido.setCarrinho(produtos);
	    pedido = repository.save(pedido);
	    return new PedidoResponseDTO(pedido);
	}

		
		
		
	}
	

