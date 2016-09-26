package mj.xml.service.nodes;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjakubowicz on 2016-09-26.
 */
@XmlRootElement(name = "family")
@XmlAccessorType(XmlAccessType.FIELD)
public class Family {

    public final static String NODE_ID = "F";

    public Family() {

    }

    public Family(String name, String born) {
        this.name = name;
        this.born = born;
    }

    @XmlElement(name = "address")
    private List<Address> addresss = new ArrayList<Address>();

    @XmlElement(name = "phone")
    private List<Phone> phone = new ArrayList<Phone>();

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "born")
    private String born;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }


}
