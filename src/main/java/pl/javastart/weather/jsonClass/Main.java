
package pl.javastart.weather.jsonClass;

import lombok.Data;

@Data
public class Main {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private long pressure;
    private long humidity;

}
