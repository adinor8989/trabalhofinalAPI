package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.entity.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

}
