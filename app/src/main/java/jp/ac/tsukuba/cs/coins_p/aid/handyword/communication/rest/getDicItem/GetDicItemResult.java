
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getDicItem;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GetDicItemResult {

    private String Xmlns;
    private String ErrorMessage;
    private String Head;
    private String Body;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Xmlns
     */
    public String getXmlns() {
        return Xmlns;
    }

    /**
     * 
     * @param Xmlns
     *     The -xmlns
     */
    public void setXmlns(String Xmlns) {
        this.Xmlns = Xmlns;
    }

    /**
     * 
     * @return
     *     The ErrorMessage
     */
    public String getErrorMessage() {
        return ErrorMessage;
    }

    /**
     * 
     * @param ErrorMessage
     *     The ErrorMessage
     */
    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    /**
     * 
     * @return
     *     The Head
     */
    public String getHead() {
        return Head;
    }

    /**
     * 
     * @param Head
     *     The Head
     */
    public void setHead(String Head) {
        this.Head = Head;
    }

    /**
     * 
     * @return
     *     The Body
     */
    public String getBody() {
        return Body;
    }

    /**
     * 
     * @param Body
     *     The Body
     */
    public void setBody(String Body) {
        this.Body = Body;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
