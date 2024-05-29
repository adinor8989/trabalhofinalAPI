package br.com.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cityName;
    private double temperature;
    private double humidity;
    private double windSpeed;
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCityName() {
        return cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public double getHumidity() {
        return humidity;
    }
    
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    
    public double getWindSpeed() {
        return windSpeed;
    }
    
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}

