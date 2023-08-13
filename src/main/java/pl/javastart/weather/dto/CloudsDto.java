
package pl.javastart.weather.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("Clouds")
public class CloudsDto {

    private long all;

}
