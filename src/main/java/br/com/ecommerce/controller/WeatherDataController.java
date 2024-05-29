package br.com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.dto.WeatherDataResponseDTO;
import br.com.ecommerce.service.WeatherDataService;

@RestController
@RequestMapping("/weather")
public class WeatherDataController {
    
    @Autowired
    private WeatherDataService weatherDataService;
    
    @GetMapping
    public ResponseEntity<WeatherDataResponseDTO> getWeatherData(@RequestParam double latitude, @RequestParam double longitude) {
        WeatherDataResponseDTO responseDTO = weatherDataService.getWeatherData(latitude, longitude);
        System.out.println(responseDTO);
        return ResponseEntity.ok(responseDTO);
    }
}



