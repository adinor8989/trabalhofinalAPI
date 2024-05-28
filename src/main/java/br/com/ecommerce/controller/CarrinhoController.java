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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ecommerce.dto.*;
import br.com.ecommerce.entity.Carrinho;
import br.com.ecommerce.service.CarrinhoService;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
	
	@Autowired
    private CarrinhoService carrinhoService;

       
    @GetMapping
    public ResponseEntity<List<CarrinhoResponseDTO>> getAllCarrinhos() {
        List<CarrinhoResponseDTO> carrinhos = carrinhoService.getAllCarrinhos();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoResponseDTO> getCarrinhoById(@PathVariable Long id) {
                return ResponseEntity.ok(carrinhoService.getCarrinhoById(id));
    }

    @PostMapping
    public ResponseEntity<CarrinhoResponseDTO> createCarrinho(@RequestBody CarrinhoRequestDTO carrinho) {
        CarrinhoResponseDTO savedCarrinho = carrinhoService.saveCarrinho(carrinho);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarrinho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrinho(@PathVariable Long id) {
        carrinhoService.deleteCarrinho(id);
        return ResponseEntity.noContent().build();
    }
}
