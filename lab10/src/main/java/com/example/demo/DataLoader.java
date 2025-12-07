package com.example.demo;


import com.example.demo.Location;
import com.example.demo.WeatherData;
import com.example.demo.repository.location.LocationRepository;
import com.example.demo.repository.weatherdata.WeatherDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class DataLoader implements CommandLineRunner {

    private final LocationRepository locationRepository;
    private final WeatherDataRepository weatherDataRepository;
    private final JdbcTemplate jdbcTemplate;

    public DataLoader(LocationRepository locationRepository,
                      WeatherDataRepository weatherDataRepository,
                      JdbcTemplate jdbcTemplate) {
        this.locationRepository = locationRepository;
        this.weatherDataRepository = weatherDataRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        weatherDataRepository.deleteAll();
        locationRepository.deleteAll();

        jdbcTemplate.execute("ALTER TABLE location ALTER COLUMN id RESTART WITH 1");
        jdbcTemplate.execute("ALTER TABLE weather_data ALTER COLUMN id RESTART WITH 1");

        System.out.println("Baza danych wyczyszczona i liczniki zresetowane.");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Location loc1 = new Location("Warsaw", "Poland", "PL");
        Location loc2 = new Location("Berlin", "Germany", "DE");
        Location loc3 = new Location("Paris", "France", "FR");

        locationRepository.save(loc1);
        locationRepository.save(loc2);
        locationRepository.save(loc3);

        WeatherData wd1 = new WeatherData();
        wd1.setDate(sdf.parse("2023-10-01"));
        wd1.setTemperature(15.0);
        wd1.setDescription("Sunny");
        wd1.setLocation(loc1);
        weatherDataRepository.save(wd1);

        WeatherData wd2 = new WeatherData();
        wd2.setDate(sdf.parse("2023-10-02"));
        wd2.setTemperature(14.5);
        wd2.setDescription("Cloudy");
        wd2.setLocation(loc1);
        weatherDataRepository.save(wd2);

        WeatherData wd3 = new WeatherData();
        wd3.setDate(sdf.parse("2023-12-01"));
        wd3.setTemperature(2.0);
        wd3.setDescription("Snow");
        wd3.setLocation(loc1);
        weatherDataRepository.save(wd3);

        WeatherData wd4 = new WeatherData();
        wd4.setDate(sdf.parse("2023-10-05"));
        wd4.setTemperature(12.0);
        wd4.setDescription("Rain");
        wd4.setLocation(loc2);
        weatherDataRepository.save(wd4);

        System.out.println("Dane startowe załadowane.");
    }
}