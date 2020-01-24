/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author franz
 */
public class Main2 {
    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String PATH = "weather";
    private static String APPID = "525975d6b4575459d7dc0ade4f6ab386";
    
    
    public static void main(String[] args) {
        Client c = ClientBuilder.newClient();    
        Response r = c.target(URI).path(PATH).queryParam("appid", APPID).queryParam("zip", "8010,at").request(MediaType.APPLICATION_JSON).get();
        
        System.out.println(r.toString());
        
        String jsonString = r.readEntity(String.class);
        
        System.out.println(jsonString);
    }
    
}
