package mj.xml.service.nodes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mjakubowicz on 2016-09-26.
 */
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    public final static String NODE_ID = "A";

    public Address() {
    }

    public Address(String street, String city, String postal) {
        this.street = street;
        this.city = city;
        this.postal = postal;
    }

    @XmlAttribute(name = "street")
    private String street;

    @XmlAttribute(name = "city")
    private String city;

    @XmlAttribute(name = "postal")
    private String postal;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

}
