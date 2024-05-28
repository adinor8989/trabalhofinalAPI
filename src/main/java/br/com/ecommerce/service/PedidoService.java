package br.com.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dto.PedidoRequestDTO;
import br.com.ecommerce.dto.PedidoResponseDTO;
import br.com.ecommerce.entity.Cliente;
import br.com.ecommerce.entity.Pedido;
import br.com.ecommerce.exception.ResourceNotFoundException;
import br.com.ecommerce.repository.ClienteRepository;
import br.com.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
    private PedidoRepository pedidoRepository;
	
	@Autowired
    private ClienteRepository clienteRepository;
    
    public List<PedidoResponseDTO> getAllPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(PedidoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public PedidoResponseDTO getPedidoById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            return new PedidoResponseDTO(pedido);
        } else {
            return null;
        }
    }
    public PedidoResponseDTO createPedido(PedidoRequestDTO pedidoRequestDTO) {
        Optional<Cliente> cliente = clienteRepository.findById(pedidoRequestDTO.getIdCliente());
        if(cliente.isEmpty()) throw new ResourceNotFoundException("Cliente não foi encontrado");
        Pedido pedido = pedidoRepository.save(new Pedido(pedidoRequestDTO , cliente.get()));
        
        return new PedidoResponseDTO(pedido);
    }
}

