package br.com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ecommerce.dto.WeatherDataResponseDTO;

@Service
public class WeatherDataService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "676a12abafa52449188e41b9a0fb5de5";

    public WeatherDataResponseDTO getWeatherData(double latitude, double longitude) {
        String url = API_URL + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        return restTemplate.getForObject(url, WeatherDataResponseDTO.class);
    }
}

