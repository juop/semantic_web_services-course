package at.ac.uibk.sws.group7.ex03_soap.services;

import at.ac.uibk.sws.group7.ex03_soap.exceptions.ProductNotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by shasi on 4/15/18.
 */
@WebService
public interface IProductService {
    /**
     * Returns the list of all products
     *
     * @return The list of products.
     */
    @WebMethod
    List<Product> getProductList();

    /**
     * Returns the product object whose id is given
     *
     * @param productId Product ID.
     * @return The product object.
     */
    @WebMethod
    Product getProduct(int productId) throws ProductNotFoundException;

    /**
     * Returns true if the order is successful, false otherwise.
     *
     * @param productId Product ID.
     * @param quantity
     * @return True if the order is successful, false otherwise.
     */
    @WebMethod
    boolean order(int productId, int quantity);
}
