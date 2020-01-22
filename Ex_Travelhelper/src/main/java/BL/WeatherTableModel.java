package BL;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author franz
 */
public class WeatherTableModel extends AbstractTableModel{
    private ArrayList<Destination> datalist = new ArrayList<>();
    private static final String[] COLNAMES = {"Destination-Name","Zip-Code"};
    
    @Override
    public int getRowCount() {
        return datalist.size();
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
        Destination d = datalist.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return d.getDestinationname();
            case 1: return d.getZipcode();
            default: return "?";
        }
    }
    public void addDestination(Destination d)
    {
        datalist.add(d);
        fireTableRowsInserted(datalist.size()-1, datalist.size()-1);
    }
    
}
