
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getDicList;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchOption {

    private String XmlnsD5p1;
    private String D5p1Nil;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The XmlnsD5p1
     */
    public String getXmlnsD5p1() {
        return XmlnsD5p1;
    }

    /**
     * 
     * @param XmlnsD5p1
     *     The -xmlns:d5p1
     */
    public void setXmlnsD5p1(String XmlnsD5p1) {
        this.XmlnsD5p1 = XmlnsD5p1;
    }

    /**
     * 
     * @return
     *     The D5p1Nil
     */
    public String getD5p1Nil() {
        return D5p1Nil;
    }

    /**
     * 
     * @param D5p1Nil
     *     The -d5p1:nil
     */
    public void setD5p1Nil(String D5p1Nil) {
        this.D5p1Nil = D5p1Nil;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
