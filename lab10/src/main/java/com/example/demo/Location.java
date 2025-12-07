package com.example.demo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    private String countryCode;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<WeatherData> weatherDataList;

    public Location() {
    }

    public Location(String city, String country, String countryCode) {
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public List<WeatherData> getWeatherDataList() { return weatherDataList; }
    public void setWeatherDataList(List<WeatherData> weatherDataList) { this.weatherDataList = weatherDataList; }
}