package br.com.ecommerce.dto;

import java.util.List;

import jakarta.persistence.Embedded;

public class WeatherDataResponseDTO {

	private long id;
	private String name;
		
	@Embedded
	private List<WeatherDTO> weather;

	public List<WeatherDTO> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherDTO> weather) {
		this.weather = weather;
	}


	public WeatherDataResponseDTO() {
		super();
	}

	public WeatherDataResponseDTO(long id, String cityName, double temperature, double humidity, double windSpeed) {
		super();
		this.id = id;
		this.name = cityName;
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}