/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import javax.swing.ImageIcon;

/**
 *
 * @author franz
 */
public class WeatherData {
    private String destination;
    private String country;
    private double temp;
    private double windspeed;
    private double humidity;
    private double pressure;
    private ImageIcon icon;

    public WeatherData(String destination, String country, double temp, double windspeed, double humidity, double pressure, ImageIcon icon) {
        this.destination = destination;
        this.country = country;
        this.temp = temp;
        this.windspeed = windspeed;
        this.humidity = humidity;
        this.pressure = pressure;
        this.icon = icon;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    
    
    
}
