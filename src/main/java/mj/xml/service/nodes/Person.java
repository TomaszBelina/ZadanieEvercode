package mj.xml.service.nodes;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjakubowicz on 2016-09-26.
 */

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    public final static String NODE_ID = "P";

    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @XmlElement(name = "address")
    private List<Address> addresss = new ArrayList<Address>();

    @XmlElement(name = "phone")
    private List<Phone> phone = new ArrayList<Phone>();

    @XmlElement(name = "family")
    private List<Family> family = new ArrayList<Family>();

    @XmlAttribute(name = "firstname")
    private String firstName;

    @XmlAttribute(name = "lastname")
    private String lastName;

    public List<Address> getAddresss() {
        return addresss;
    }

    public void setAddresss(List<Address> addresss) {
        this.addresss = addresss;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
