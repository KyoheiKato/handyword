package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.soap.soap12;

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Soap12Envelope {

    private String XmlnsXsi;
    private String XmlnsXsd;
    private String XmlnsSoap12;
    private Soap12Body soap12Body;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     *
     * @return
     * The XmlnsXsi
     */
    public String getXmlnsXsi() {
        return XmlnsXsi;
    }

    /**
     *
     * @param XmlnsXsi
     * The -xmlns:xsi
     */
    public void setXmlnsXsi(String XmlnsXsi) {
        this.XmlnsXsi = XmlnsXsi;
    }

    /**
     *
     * @return
     * The XmlnsXsd
     */
    public String getXmlnsXsd() {
        return XmlnsXsd;
    }

    /**
     *
     * @param XmlnsXsd
     * The -xmlns:xsd
     */
    public void setXmlnsXsd(String XmlnsXsd) {
        this.XmlnsXsd = XmlnsXsd;
    }

    /**
     *
     * @return
     * The XmlnsSoap12
     */
    public String getXmlnsSoap12() {
        return XmlnsSoap12;
    }

    /**
     *
     * @param XmlnsSoap12
     * The -xmlns:soap12
     */
    public void setXmlnsSoap12(String XmlnsSoap12) {
        this.XmlnsSoap12 = XmlnsSoap12;
    }

    /**
     *
     * @return
     * The soap12Body
     */
    public Soap12Body getSoap12Body() {
        return soap12Body;
    }

    /**
     *
     * @param soap12Body
     * The soap12:Body
     */
    public void setSoap12Body(Soap12Body soap12Body) {
        this.soap12Body = soap12Body;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}