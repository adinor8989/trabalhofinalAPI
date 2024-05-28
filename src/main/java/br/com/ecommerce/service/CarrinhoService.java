package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dto.CarrinhoRequestDTO;
import br.com.ecommerce.dto.CarrinhoResponseDTO;
import br.com.ecommerce.entity.Carrinho;
import br.com.ecommerce.entity.Pedido;
import br.com.ecommerce.entity.Produto;
import br.com.ecommerce.exception.ResourceNotFoundException;
import br.com.ecommerce.repository.CarrinhoRepository;
import br.com.ecommerce.repository.PedidoRepository;
import br.com.ecommerce.repository.ProdutoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

   
    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public List<CarrinhoResponseDTO> getAllCarrinhos() {
        return carrinhoRepository.findAll().stream().map((lv)-> new CarrinhoResponseDTO(lv)).collect(Collectors.toList());
    }

    public CarrinhoResponseDTO getCarrinhoById(Long id) {
    	Optional<Carrinho> carrinho = carrinhoRepository.findById(id);
    	if(carrinho.isEmpty()) throw new ResourceNotFoundException("Id não encontrado");
        return new CarrinhoResponseDTO(carrinho.get());
    }

    public CarrinhoResponseDTO saveCarrinho(CarrinhoRequestDTO carrinho) {
    	Optional<Produto> produto = produtoRepository.findById(carrinho.getIdProduto());
    	Optional<Pedido> pedido = pedidoRepository.findById(carrinho.getIdPedido());
    	if(produto.isEmpty()|| pedido.isEmpty()) throw new ResourceNotFoundException("Produto ou pedido não estão presentes");
    	
        Carrinho carrinhoSave = carrinhoRepository.save(new Carrinho(carrinho, pedido.get(),produto.get()));
        return new CarrinhoResponseDTO(carrinhoSave);
    }

    public void deleteCarrinho(Long id) {
        carrinhoRepository.deleteById(id);
    }
}
