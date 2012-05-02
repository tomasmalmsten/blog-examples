package com.tomasmalmsten.example.jaxb;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PropertyMap {
  @XmlElement(name = "property")
  private List<PropertyEntry> entries = new ArrayList<>();

  List<PropertyEntry> entries() {
    return Collections.unmodifiableList(entries);
  }

  void addEntry(PropertyEntry entry) {
    entries.add(entry);
  }
}
