package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.entity.WeatherData;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}
