package at.ac.uibk.sws.group7.ex03_soap.services;

import at.ac.uibk.sws.group7.ex03_soap.exceptions.ProductNotFoundBean;
import at.ac.uibk.sws.group7.ex03_soap.exceptions.ProductNotFoundException;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shasi on 4/15/18.
 */
@WebService(endpointInterface = "at.ac.uibk.sws.group7.ex03_soap.services.IProductService")
public class ProductService implements IProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.productId = i + 1;
            p.name = "Product " + i;
            p.price = new Random().nextDouble() * 100 + 1;
            products.add(p);
        }
    }

    @Override
    public List<Product> getProductList() {
        return products;
    }

    @Override
    public Product getProduct(int productId) throws ProductNotFoundException {
        for (Product p : products)
            if (p.productId == productId)
                return p;

        String message = "Product with ID='" + productId + "' not found.";
        ProductNotFoundBean fault = new ProductNotFoundBean();
        fault.setMessage(message);

        throw new ProductNotFoundException(message, fault);
    }

    @Override
    public boolean order(int productId, int quantity) throws ProductNotFoundException {
        if (quantity > 0) {
            Product p = getProduct(productId);

            // Place order.
            return true;
        }

        return false;
    }
}
