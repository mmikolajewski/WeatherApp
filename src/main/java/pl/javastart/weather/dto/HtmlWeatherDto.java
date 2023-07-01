package pl.javastart.weather.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class HtmlWeatherDto {
    private String town;

    private String cloudCover;
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private long pressure;
    private long humidity;
    private double windSpeed;

}
