package mj.xml.service.impl;

import mj.stream.service.IStreamReader;
import mj.xml.service.IXmlParser;
import mj.xml.service.nodes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mjakubowicz on 2016-09-25.
 */

@Service("xmlParserService")
public class XmlParser implements IXmlParser {

    @Autowired
    private IStreamReader streamReader;

    @Override
    public People parseXmlFromStreamToJaxbElement(InputStream inputStream, String path) {
        List<String> nodes = streamReader.getTextLinesFromStram(inputStream);
        People people = createXmlStructur(nodes);
        return people;
    }

    private People createXmlStructur(List<String> nodes){
        People people = new People();
        if (nodes != null) {
            Iterator<String> iter = nodes.iterator();
            Family tmpFamily = null;
            Person tmpPerson = null;
            while(iter.hasNext()){
                String[] nodeData = iter.next().split("|");
                switch(nodeData[0]){
                    case Person.NODE_ID:
                        if(tmpFamily != null){
                            tmpPerson.getFamily().add(tmpFamily);
                            tmpFamily = null;
                        }
                        if(tmpPerson != null){
                            people.getPersonList().add(tmpPerson);
                        }
                        tmpPerson = new Person(nodeData[1], nodeData[2]);
                        break;
                    case Family.NODE_ID:
                        if(tmpFamily != null){
                            tmpPerson.getFamily().add(tmpFamily);
                        }
                        tmpFamily = new Family(nodeData[1], nodeData[2]);
                        break;
                    case Address.NODE_ID:
                        Address address = new Address(nodeData[1], nodeData[2], nodeData[3]);
                        if(tmpFamily != null){
                            tmpFamily.getAddresss().add(address);
                        }else{
                            tmpPerson.getAddresss().add(address);
                        }
                        break;
                    case Phone.NODE_ID:
                        Phone phone = new Phone(nodeData[1], nodeData[2]);
                        if(tmpFamily != null){
                            tmpFamily.getPhone().add(phone);
                        }else{
                            tmpPerson.getPhone().add(phone);
                        }
                        break;
                    default:
                        //TODO dodać logger i obsłużyć sytuacje błędnych danych wejściowych
                        break;
                }
            }
            people.getPersonList().add(tmpPerson);
        }
        return people;
    }


    @Override
    public void marshalToFile(People people) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(people.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(people, new File( "people.xml" ) );

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}