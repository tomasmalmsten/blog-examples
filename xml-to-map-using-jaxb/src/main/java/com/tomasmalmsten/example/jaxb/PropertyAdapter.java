package com.tomasmalmsten.example.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;

class PropertyAdapter extends XmlAdapter<PropertyMap, Map<String, String>> {

  @Override
  public Map<String, String> unmarshal(PropertyMap in) throws Exception {
    HashMap<String, String> hashMap = new HashMap<>();
    for (PropertyEntry entry : in.entries()) {
      hashMap.put(entry.name(), entry.value());
    }
    return hashMap;
  }

  @Override
  public PropertyMap marshal(Map<String, String> map) throws Exception {
    PropertyMap props = new PropertyMap();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      props.addEntry(new PropertyEntry(entry.getKey(), entry.getValue()));
    }
    return props;
  }

}
