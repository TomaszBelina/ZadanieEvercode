package mj.xml.service.nodes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mjakubowicz on 2016-09-26.
 */
@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {

    public final static String NODE_ID = "T";

    public Phone() {

    }

    public Phone(String mobileNumber, String fixedNumber) {
        this.mobileNumber = mobileNumber;
        this.fixedNumber = fixedNumber;
    }

    @XmlAttribute(name = "mobile")
    private String mobileNumber;

    @XmlAttribute(name = "fixed")
    private String fixedNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFixedNumber() {
        return fixedNumber;
    }

    public void setFixedNumber(String fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

}
