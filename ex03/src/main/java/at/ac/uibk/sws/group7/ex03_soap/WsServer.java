package at.ac.uibk.sws.group7.ex03_soap;

import at.ac.uibk.sws.group7.ex03_soap.services.ProductService;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

/**
 *
 */
public class WsServer {
    public static final String URL = "http://localhost:4434/productService";
    public static final String WSDL_URL = WsServer.URL + "?wsdl";
    public static final QName QNAME = new QName("http://services.ex03_soap.group7.sws.uibk.ac.at/", "ProductServiceService");

    public static void main(String[] args) {
        // Enable logging of all communication on the console.
        enableLogging();

        Endpoint.publish(URL, new ProductService());
        System.out.println("WS server running on '" + URL + "'.");
    }

    private static void enableLogging() {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
    }
}
