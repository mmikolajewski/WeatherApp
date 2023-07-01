package pl.javastart.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.javastart.weather.dto.FullWeatherDto;
import pl.javastart.weather.dto.HtmlWeatherDto;

@Service
public class OpenWeatherService {

    public HtmlWeatherDto getTownWeather(String town) throws CityWeatherNotFoundException {
        try {
            FullWeatherDto townWeatherFromApi = getTownWeatherFromApi(town);
            return getWeatherDto(townWeatherFromApi);
        } catch (HttpClientErrorException.NotFound e) {
            throw new CityWeatherNotFoundException();
        }

    }
    public FullWeatherDto getTownWeatherFromApi(String town) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + town +"&APPID=728886abb2b152bdc4056ac287cc2daf&units=metric&lang=pl";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, FullWeatherDto.class);
    }

    public HtmlWeatherDto getWeatherDto(FullWeatherDto townWeather) {
        return HtmlWeatherDto.builder()
                .town(townWeather.getName())
                .humidity(townWeather.getMainDto().getHumidity())
                .cloudCover(townWeather.getWeather().get(0).getDescription())
                .windSpeed(townWeather.getWindDto().getSpeed())
                .pressure(townWeather.getMainDto().getPressure())
                .temp(townWeather.getMainDto().getTemp())
                .tempMin(townWeather.getMainDto().getTempMin())
                .tempMax(townWeather.getMainDto().getTempMax())
                .feelsLike(townWeather.getMainDto().getFeelsLike())
                .build();
    }
}

