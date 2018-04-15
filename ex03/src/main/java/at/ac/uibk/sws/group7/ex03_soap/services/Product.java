package at.ac.uibk.sws.group7.ex03_soap.services;

/**
 * Created by shasi on 4/15/18.
 */
public class Product {
    public int productId;
    public String name;
    public double price;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
