package at.ac.uibk.sws.group7.ex03_soap.exceptions;

import javax.xml.ws.WebFault;

/**
 * Created by shasi on 4/15/18.
 */
@WebFault(name = "ProductNotFoundBean")
public class ProductNotFoundException extends Exception {
    private ProductNotFoundBean faultInfo;


    public ProductNotFoundException(String message, ProductNotFoundBean faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public ProductNotFoundException(String message, ProductNotFoundBean faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public ProductNotFoundBean getFaultInfo() {
        return faultInfo;
    }
}
