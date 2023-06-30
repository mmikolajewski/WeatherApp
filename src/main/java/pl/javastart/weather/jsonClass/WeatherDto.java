package pl.javastart.weather.jsonClass;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class WeatherDto {
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
