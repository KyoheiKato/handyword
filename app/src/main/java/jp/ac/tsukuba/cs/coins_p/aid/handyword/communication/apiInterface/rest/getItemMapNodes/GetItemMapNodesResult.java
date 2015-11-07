
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getItemMapNodes;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GetItemMapNodesResult {

    private String Xmlns;
    private String ErrorMessage;
    private String NodeCount;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getItemMapNodes.NodeList NodeList;
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
     *     The NodeCount
     */
    public String getNodeCount() {
        return NodeCount;
    }

    /**
     * 
     * @param NodeCount
     *     The NodeCount
     */
    public void setNodeCount(String NodeCount) {
        this.NodeCount = NodeCount;
    }

    /**
     * 
     * @return
     *     The NodeList
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getItemMapNodes.NodeList getNodeList() {
        return NodeList;
    }

    /**
     * 
     * @param NodeList
     *     The NodeList
     */
    public void setNodeList(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getItemMapNodes.NodeList NodeList) {
        this.NodeList = NodeList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
