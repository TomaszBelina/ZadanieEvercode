package mj.xml.service.impl;

/**
 * Created by mjakubowicz on 2016-09-26.
 */
public enum NodeEnum {
    PERSON("person","P"),
    PHONE("phone","T"),
    ADDRESS("addres", "A"),
    FAMILY("family","F");

    private String name;
    private String mark;

    NodeEnum(String name, String mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }
}
