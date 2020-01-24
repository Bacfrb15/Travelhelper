/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.WeatherData;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author franz
 */
public class WeatherDataRenderer implements TableCellRenderer{
    
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setText(value.toString());
        WeatherData d = (WeatherData) value;
        
        switch(column)
        {
            case 0: label.setText(d.getDestination());
            case 1: label.setIcon(d.getIcon());
            case 2: label.setText(String.format("%.2f", d.getTemp()));
            case 3: label.setText(String.format("%.2f", d.getWindspeed()));
            case 4: label.setText(String.format("%.2f", d.getHumidity()));
            case 5: label.setText(String.format("%.2f", d.getPressure()));
        }
        
        return label;

    }
}
