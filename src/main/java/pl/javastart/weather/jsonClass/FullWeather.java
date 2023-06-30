
package pl.javastart.weather.jsonClass;

import lombok.Data;

import java.util.List;
@Data
public class FullWeather {

    private List<Weather> weather;
    private String base;
    private Main main;
    private long visibility;
    private Wind wind;
    private Clouds clouds;
    private String name;

}
