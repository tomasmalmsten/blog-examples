package com.tomasmalmsten.example.jaxb;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.CharArrayWriter;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProviderJAXBTest {
  private static final String XML = new StringBuilder()
      .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
      .append("<provider>")
      .append("<name>name</name>")
      .append("<properties>")
      .append("<property><name>eid</name><value>electronic id</value></property>")
      .append("<property><name>secret</name><value>secret token</value></property>")
      .append("<property><name>address</name><value>ip address</value></property>")
      .append("<property><name>live</name><value>oh no, not yet</value></property>")
      .append("</properties>")
      .append("</provider>")
      .toString();

  private static final Map<String, String> PROPERTIES = new HashMap<>(4);

  static {
    PROPERTIES.put("eid", "electronic id");
    PROPERTIES.put("secret", "secret token");
    PROPERTIES.put("address", "ip address");
    PROPERTIES.put("live", "oh no, not yet");
  }


  @Test
  public void unmarshall() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(Provider.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    Provider provider = (Provider) unmarshaller.unmarshal(new StringReader(XML));
    assertThat(provider.name(), equalTo("name"));
    System.out.println(provider.name());
    assertThat(provider.properties(), equalTo(Collections.unmodifiableMap(PROPERTIES)));

  }

  @Test
  public void printMarshalledXMLToStdOut() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(Provider.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    Provider provider = new Provider();
    provider.setName("name");
    Map<String, String> properties = new HashMap<>(4);
    properties.put("eid", "electronic id");
    properties.put("secret", "secret token");
    properties.put("address", "ip address");
    properties.put("live", "oh no, not yet");
    provider.setProperties(properties);
    CharArrayWriter out = new CharArrayWriter();
    marshaller.marshal(provider, out);
    System.out.println(out.toString());
  }
}
