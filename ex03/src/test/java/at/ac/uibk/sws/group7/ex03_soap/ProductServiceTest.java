package at.ac.uibk.sws.group7.ex03_soap;

import at.ac.uibk.sws.group7.ex03_soap.exceptions.ProductNotFoundException;
import at.ac.uibk.sws.group7.ex03_soap.services.IProductService;
import at.ac.uibk.sws.group7.ex03_soap.services.Product;
import at.ac.uibk.sws.group7.ex03_soap.services.ProductService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Unit test for {@link ProductService}.
 */
public class ProductServiceTest {
    private static final Logger LOGGER = Logger.getLogger(ProductServiceTest.class.getName());

    private static Endpoint server;
    private static IProductService productService;

    @BeforeClass
    public static void setup() throws Exception {
        server = Endpoint.publish(WsServer.URL, new ProductService());

        LOGGER.info("Attempting to initiate service...");
        Service service = Service.create(new URL(WsServer.WSDL_URL), WsServer.QNAME);

        productService = service.getPort(IProductService.class);

        if (productService != null) {
            LOGGER.info("Found service stub.");
        } else {
            fail();
        }
    }

    @AfterClass
    public static void cleanup() {
        server.stop();
    }

    @Test
    public void testGetProduct() {
        LOGGER.info("Get product...");

        Product product = null;
        try {
            product = productService.getProduct(1);
            LOGGER.info(product.toString());
        } catch (ProductNotFoundException e) {
            // Ignore.
        }

        assertTrue(product != null);
    }

    @Test
    public void testGetProductNotFound() {
        LOGGER.info("Get product not found...");

        Product product = null;
        try {
            product = productService.getProduct(11);
        } catch (ProductNotFoundException e) {
            LOGGER.info("Error class: " + e.getClass().getName());
            LOGGER.info("Caught error. Message: " + e.getMessage());
        }

        assertTrue(product == null);
    }

    @Test
    public void testGetProductList() {
        LOGGER.info("Get product list...");

        List<Product> products = productService.getProductList();
        LOGGER.info(Arrays.toString(products.toArray()));

        assertTrue(products.size() > 0);
    }

    @Test
    public void testOrderPlaced() {
        LOGGER.info("Order product successfully...");

        try {
            assertTrue(productService.order(2, 3));
        } catch (ProductNotFoundException e) {
            fail();
        }
    }

    @Test
    public void testOrderDeclinedNotFound() {
        LOGGER.info("Order unknown product...");

        try {
            productService.order(11, 3);
            fail();
        } catch (ProductNotFoundException e) {
            // Ignore.
        }

        assertTrue(true);
    }

    @Test
    public void testOrderDeclinedQuantity() {
        LOGGER.info("Order product wrong quantity...");

        try {
            assertFalse(productService.order(1, -1));
        } catch (ProductNotFoundException e) {
            fail();
        }
    }
}
