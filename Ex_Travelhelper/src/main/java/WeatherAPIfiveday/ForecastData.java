/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeatherAPIfiveday;

import java.awt.Image;
import java.time.LocalDateTime;

public class ForecastData {

    private Image icon;
    private double temp;
    private int humidity;
    private int pressure;
    private double windspeed;
    private LocalDateTime time;
    private String destination;

    public ForecastData(String destination, Image icon, double temp, int humidity, int pressure, double windspeed, LocalDateTime time) {
        this.destination = destination;
        this.icon = icon;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windspeed = windspeed;
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
