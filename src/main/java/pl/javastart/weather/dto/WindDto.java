
package pl.javastart.weather.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("Wind")
public class WindDto {

    private double speed;
    private long deg;
    private double gust;

}
