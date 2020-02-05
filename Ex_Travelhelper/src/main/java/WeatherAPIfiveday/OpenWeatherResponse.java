package WeatherAPIfiveday;
import java.util.List;

/**
 *
 * @author franz
 */
public class OpenWeatherResponse {

private String cod;
private long message;
private  java.util.List<WeatherAPIfiveday.List> list;
private City city;
private String dt_txt;

    public OpenWeatherResponse(String cod, long message, List<WeatherAPIfiveday.List> list, City city, String dt_txt) {
        this.cod = cod;
        this.message = message;
        this.list = list;
        this.city = city;
        this.dt_txt = dt_txt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public long getMessage() {
        return message;
    }

    public void setMessage(long message) {
        this.message = message;
    }

    public List<WeatherAPIfiveday.List> getList() {
        return list;
    }

    public void setList(List<WeatherAPIfiveday.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
 
}
