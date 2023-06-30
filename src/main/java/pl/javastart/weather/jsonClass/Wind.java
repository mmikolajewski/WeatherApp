
package pl.javastart.weather.jsonClass;

import lombok.Data;

@Data
public class Wind {

    private double speed;
    private long deg;
    private double gust;

}
