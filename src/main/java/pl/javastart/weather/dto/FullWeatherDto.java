
package pl.javastart.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class FullWeatherDto {

    private List<MainWeatherDto> weather;
    private String base;
    @JsonProperty("main")
    private MainDto mainDto;
    private long visibility;
    @JsonProperty("wind")
    private WindDto windDto;
    @JsonProperty("clouds")
    private CloudsDto cloudsDto;
    private String name;

}
