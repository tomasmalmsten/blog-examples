package com.tomasmalmsten.example.jaxb;

import javax.xml.bind.annotation.XmlElement;

class Property {
  @XmlElement(name = "name")
  private String name;

  @XmlElement(name = "value")
  private String value;

  Property() {
  }

  Property(String name, String value) {
    this.name = name;
    this.value = value;
  }

  String value() {
    return value;
  }

  String name() {
    return name;
  }
}
