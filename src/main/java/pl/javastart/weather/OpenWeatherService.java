package pl.javastart.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.javastart.weather.jsonClass.FullWeather;
import pl.javastart.weather.jsonClass.WeatherDto;

@Service
public class OpenWeatherService {
    public FullWeather getTownWeather(String town) throws TownWeatherNotFoundException {


        String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + town +"&APPID=728886abb2b152bdc4056ac287cc2daf&units=metric&lang=pl";
        RestTemplate restTemplate = new RestTemplate();

        try {
            FullWeather response = restTemplate.getForObject(URL, FullWeather.class);
            return response;
        } catch (Exception e) {
            throw new TownWeatherNotFoundException();
        }
    }

    public WeatherDto getWeatherDto(FullWeather townWeather) {
        return WeatherDto.builder()
                .town(townWeather.getName())
                .humidity(townWeather.getMain().getHumidity())
                .cloudCover(townWeather.getWeather().get(0).getDescription())
                .windSpeed(townWeather.getWind().getSpeed())
                .pressure(townWeather.getMain().getPressure())
                .temp(townWeather.getMain().getTemp())
                .tempMin(townWeather.getMain().getTemp_min())
                .tempMax(townWeather.getMain().getTemp_max())
                .feelsLike(townWeather.getMain().getFeels_like())
                .build();
    }
}

