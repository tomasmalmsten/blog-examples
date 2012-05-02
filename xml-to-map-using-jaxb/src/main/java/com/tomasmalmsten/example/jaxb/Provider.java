package com.tomasmalmsten.example.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "provider")
@XmlAccessorType(XmlAccessType.FIELD)
public class Provider {
  @XmlElement(name = "name")
  private String name;
  @XmlElement(name = "properties")
  @XmlJavaTypeAdapter(PropertyAdapter.class)
  private Map<String, String> properties;

  void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  String name() {
    return name;
  }

  Map<String, String> properties() {
    return properties;
  }

  void setName(String name) {
    this.name = name;
  }

}
