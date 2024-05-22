package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
