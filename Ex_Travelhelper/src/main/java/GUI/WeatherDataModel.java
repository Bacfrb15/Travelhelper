/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import WeatherAPIoneday.Destination;
import WeatherAPIoneday.OpenWeatherResponse;
import WeatherAPIoneday.Weather;
import WeatherAPIoneday.WeatherData;
import com.google.gson.Gson;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
public class WeatherDataModel extends AbstractTableModel{
    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String PATH = "weather";
    private static String APPID = "525975d6b4575459d7dc0ade4f6ab386";
    private static String URI_ICON = "http://openweathermap.org/img/wn/";
    private static String ICON_END = "@2x.png";
    private ArrayList<WeatherData> weatherdata = new ArrayList<>();
    private static final String[] COLNAMES = {"Destination","Country","Temperature","Windspeed","Humidity","Pressure","Icon"};
    
    @Override
    public int getRowCount() {
        return weatherdata.size();
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
        WeatherData d = weatherdata.get(rowIndex);
        return d;
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

    
    public void addWeatherData(ArrayList<Destination> destinations)
    {
        Client c = ClientBuilder.newClient();

        for (Destination d : destinations)
        {
            Response r = c.target(URI)
                    .path(PATH)
                    .queryParam("appid", APPID)
                    .queryParam("zip", d.getZipcode()+",at")
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            String jsonString = r.readEntity(String.class);
            OpenWeatherResponse owr = new Gson().fromJson(jsonString, OpenWeatherResponse.class);
            
            for (Weather weather : owr.getWeather())
            {
                Image icon = getWeatherIcon(weather.getIcon());
                WeatherData w = new WeatherData(d.getDestinationname(), owr.getSys().getCountry(), owr.getMain().getTemp(), owr.getWind().getSpeed(), owr.getMain().getHumidity(), owr.getMain().getPressure(), icon);
                weatherdata.add(w);
                fireTableRowsInserted(weatherdata.size()-1, weatherdata.size()-1);
            }
        } 
    }
}
