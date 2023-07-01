package pl.javastart.weather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.weather.dto.HtmlWeatherDto;

@Controller
public class WeatherController {

    private final OpenWeatherService openWeatherService;

    public WeatherController(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("town", "");
        model.addAttribute("townWeather", "");
        return "home";
    }

    @PostMapping("/weather")
    String town(@RequestParam(required = false) String town, RedirectAttributes redirectAttributes,Model model) {
        try {
            HtmlWeatherDto townHtmlWeatherDto = openWeatherService.getTownWeather(town);
            redirectAttributes.addFlashAttribute("townWeather", townHtmlWeatherDto);
            return "redirect:/result";
        } catch (CityWeatherNotFoundException e) {
            model.addAttribute("TownNotFound", "TownNotFound");
            return "home";
        }
    }

    @GetMapping("/result")
    String result(@ModelAttribute("townWeather") final HtmlWeatherDto htmlWeatherDto, Model model){
        model.addAttribute("townWeather", htmlWeatherDto);
        return "result";
    }
}
