package at.ac.uibk.sws.group7.ex03_soap;

import javax.xml.ws.Endpoint;

/**
 *
 */
public class WsServer {
    public static final String URL = "http://localhost:4434/productService";

    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        Endpoint.publish(URL, new ProductService());
        System.out.println("WS server running on '" + URL + "'.");
    }
}
