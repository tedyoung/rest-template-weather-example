package com.tedmyoung.resttemplateweatherexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class WeatherExampleTests {

  public static final String WEATHER_API_URL = "https://basic-weather.herokuapp.com/api/zip/{zip}";

  @Test
  public void getWeatherAsString() throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    String weatherUrl = "https://basic-weather.herokuapp.com/api/zip/94404";

    String response = restTemplate.getForObject(weatherUrl, String.class);

    System.out.println("Response:");
    System.out.println("-------------------");
    System.out.println(response);
    System.out.println("-------------------");
    System.out.println();
  }






  @Test
  public void getWeatherAsStringWithStatus() throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    String weatherUrl = "https://basic-weather.herokuapp.com/api/zip/94404";

    ResponseEntity<String> response =
        restTemplate.getForEntity(weatherUrl, String.class);

    assertThat(response.getStatusCode())
        .isEqualTo(HttpStatus.OK);
    assertThat(response.getBody())
        .isNotEmpty();

    System.out.println();
    System.out.println("Status: " + response.getStatusCode());
    System.out.println("Headers: " + response.getHeaders());
    System.out.println("-------------------");
    System.out.println("Full response body:");
    System.out.println("-------------------");
    System.out.println(response.getBody());
    System.out.println("-------------------");
    System.out.println();
  }




  @Test
  public void getWeatherAsDto() throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    String weatherUrl = "https://basic-weather.herokuapp.com/api/zip/94404";

    WeatherResponse response =
        restTemplate.getForObject(weatherUrl, WeatherResponse.class);

    assertThat(response.getLocation())
        .isEqualTo("San Mateo");

    assertThat(response.getTemp())
        .isGreaterThan(50);

    System.out.println();
    System.out.println();
    System.out.println("The Weather API returned:");
    System.out.println(response);
    System.out.println();
  }




  @Test
  public void getWeatherAsDtoWithTemplateVariables() throws Exception {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("zip", "78729");

    RestTemplate restTemplate = new RestTemplate();

    WeatherResponse response =
        restTemplate.getForObject(WEATHER_API_URL,
                                  WeatherResponse.class,
                                  uriVariables);

    assertThat(response.getLocation())
        .isEqualTo("Austin");

    System.out.println();
    System.out.println();
    System.out.println("The Weather API returned:");
    System.out.println(response);
    System.out.println();
  }

}
