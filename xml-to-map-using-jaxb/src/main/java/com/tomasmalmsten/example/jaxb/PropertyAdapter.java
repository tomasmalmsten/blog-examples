package com.tomasmalmsten.example.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;

class PropertyAdapter extends XmlAdapter<Properties, Map<String, String>> {

  @Override
  public Map<String, String> unmarshal(Properties in) throws Exception {
    HashMap<String, String> hashMap = new HashMap<>();
    for (Property entry : in.entries()) {
      hashMap.put(entry.name(), entry.value());
    }
    return hashMap;
  }

  @Override
  public Properties marshal(Map<String, String> map) throws Exception {
    Properties props = new Properties();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      props.addEntry(new Property(entry.getKey(), entry.getValue()));
    }
    return props;
  }

}
