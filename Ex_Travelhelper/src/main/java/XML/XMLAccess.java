/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import WeatherAPIoneday.Destination;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Christoph
 */
public class XMLAccess {

    public static XMLAccess instance;
    private Document doc;
    private static String xmlpath = "xml/destinations.xml";
    private File f;
    private XMLAccess() throws Exception {
        f = new File(xmlpath);
        SAXBuilder builder = new SAXBuilder();
        doc = builder.build(f);
    }

    public synchronized static XMLAccess getInstance() {
        if (instance == null) {
            try {
                instance = new XMLAccess();
            } catch (Exception ex) {
                Logger.getLogger(XMLAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    public ArrayList<Destination> getDestinations() {
        ArrayList<Destination> destinations = new ArrayList<>();
        Element root = doc.getRootElement();
        List<Element> destination = root.getChildren("destination");

        for (Element dest : destination) {
            Destination d = new Destination(dest.getChildText("name"), Integer.parseInt(dest.getChildText("zipcode")));
            destinations.add(d);
        }
        return destinations;
    }
    
    public void saveOnXML(Destination destination) throws IOException{
        f.delete();
        Element root = doc.getRootElement();
        XMLOutputter xmlOutput = new XMLOutputter();
     
        Element dest = new Element("destination");
        dest.addContent(new Element("name").setText(destination.getDestinationname()));
        dest.addContent(new Element("zipcode").setText(""+destination.getZipcode()));
        root.addContent(dest);
        xmlOutput.output(root, System.out);
        
        
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(root, new FileWriter(
                "xml/destinations.xml", true));
    }
}
