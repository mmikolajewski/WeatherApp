
package pl.javastart.weather.jsonClass;

import lombok.Data;

@Data
public class Weather {

    private long id;
    private String main;
    private String description;

}
