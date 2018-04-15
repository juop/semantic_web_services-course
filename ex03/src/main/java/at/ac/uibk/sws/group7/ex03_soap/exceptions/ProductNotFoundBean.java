package at.ac.uibk.sws.group7.ex03_soap.exceptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by shasi on 4/15/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductNotFoundBean", propOrder = {"message"})
public class ProductNotFoundBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
