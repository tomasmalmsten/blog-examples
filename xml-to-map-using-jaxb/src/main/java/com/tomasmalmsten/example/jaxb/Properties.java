package com.tomasmalmsten.example.jaxb;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Properties {
  @XmlElement(name = "property")
  private List<Property> entries = new ArrayList<>();

  List<Property> entries() {
    return Collections.unmodifiableList(entries);
  }

  void addEntry(Property entry) {
    entries.add(entry);
  }
}
