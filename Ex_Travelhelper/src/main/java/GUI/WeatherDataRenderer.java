/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import WeatherAPIoneday.WeatherData;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author franz
 */
public class WeatherDataRenderer implements TableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        WeatherData d = (WeatherData) value;
        Icon icon = new ImageIcon(getScaledImage(d.getIcon(), 30, 30));
        switch(column)
        {
            case 0: label.setText(d.getDestination()); break;
            case 1: label.setText(d.getCountry()); break;
            case 2: label.setText(String.format("%.2f", d.getTemp())); break;
            case 3: label.setText(String.format("%.2f", d.getWindspeed())); break;
            case 4: label.setText(String.format("%.2f", d.getHumidity())); break;
            case 5: label.setText(String.format("%.2f", d.getPressure())); break;
            case 6: label.setIcon(icon); break;
        }
        return label;
    }
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
