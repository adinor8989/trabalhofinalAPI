package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.entity.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
