package mj.xml.service;

import mj.xml.service.nodes.People;
import mj.xml.service.nodes.Person;

import java.io.InputStream;

/**
 * Created by mjakubowicz on 2016-09-25.
 */
public interface IXmlParser {
    People parseXmlFromStreamToJaxbElement(InputStream inputStream, String path);

    void marshalToFile(People people);
}
