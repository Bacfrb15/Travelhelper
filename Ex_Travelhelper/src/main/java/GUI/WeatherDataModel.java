/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Destination;
import BL.WeatherData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author franz
 */
public class WeatherDataModel extends AbstractTableModel{
    private ArrayList<WeatherData> weatherdata = new ArrayList<>();
    private static final String[] COLNAMES = {"Destination","Country","Temperature","Windspeed","Humidity","Pressure"};
    
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
    public void addWeatherData(WeatherData d)
    {
        weatherdata.add(d);
        fireTableRowsInserted(weatherdata.size()-1, weatherdata.size()-1);
    }
}
