
package pl.javastart.weather.dto;

import lombok.Data;

@Data
public class MainWeatherDto {

    private long id;
    private String main;
    private String description;

}
