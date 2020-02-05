/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import WeatherAPIfiveday.ForecastData;
import WeatherAPIfiveday.OpenWeatherResponse;
import WeatherAPIfiveday.Weather;
import WeatherAPIoneday.Destination;
import com.google.gson.Gson;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.AbstractTableModel;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author franz
 */
public class Forecast5DayModel extends AbstractTableModel{
    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String PATH = "forecast";
    private static String APPID = "525975d6b4575459d7dc0ade4f6ab386";
    private static String URI_ICON = "http://openweathermap.org/img/wn/";
    private static String ICON_END = "@2x.png";
    private ArrayList<ForecastData> forecastdata = new ArrayList<>();
    private static final String[] COLNAMES = {"Destination","Time","Temperature","Windspeed","Humidity","Pressure","Icon"};
    
    @Override
    public int getRowCount() {
        return forecastdata.size();
    }

    @Override
    public int getColumnCount() {
        return COLNAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ForecastData f = forecastdata.get(rowIndex);
        return f;
    }
    public Image getWeatherIcon(String id) {
        Image image = null;
        try {
            URL url = new URL(URI_ICON + id + ICON_END);
            image = ImageIO.read(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(OpenWeatherResponse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OpenWeatherResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    
    public void addForecastData(Destination destination)
    {
        forecastdata.clear();
        Client c = ClientBuilder.newClient();

        
            Response r = c.target(URI)
                    .path(PATH)
                    .queryParam("appid", APPID)
                    .queryParam("zip", destination.getZipcode()+",at")
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            String jsonString = r.readEntity(String.class);
            OpenWeatherResponse owr = new Gson().fromJson(jsonString, OpenWeatherResponse.class);
            java.util.List<WeatherAPIfiveday.List> data = owr.getList();
            LocalDateTime ldt;
            
            for(WeatherAPIfiveday.List l : data)
            {
                String time = l.getDt_txt().split(" ")[1];
                if(time.equals("12:00:00"))
                {
                    for (Weather weather : l.getWeather()) {
                        Image icon = getWeatherIcon(weather.getIcon());
                        
                        ldt = LocalDateTime.parse(l.getDt_txt(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        ForecastData d = new ForecastData(destination.getDestinationname(),  icon,l.getMain().getTemp(),  l.getMain().getHumidity(), l.getMain().getPressure(),l.getWind().getSpeed(), ldt);
                        forecastdata.add(d);
                        fireTableRowsInserted(forecastdata.size() - 1, forecastdata.size() - 1);
                    }
                }
            } 
    }
}
