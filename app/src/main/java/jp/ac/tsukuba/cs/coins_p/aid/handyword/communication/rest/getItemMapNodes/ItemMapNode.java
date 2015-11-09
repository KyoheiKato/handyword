
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getItemMapNodes;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ItemMapNode {

    private String Title;
    private String RefItemID;
    private String RefLocID;
    private String ChildCount;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getItemMapNodes.ChildNodes ChildNodes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * 
     * @param Title
     *     The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * 
     * @return
     *     The RefItemID
     */
    public String getRefItemID() {
        return RefItemID;
    }

    /**
     * 
     * @param RefItemID
     *     The RefItemID
     */
    public void setRefItemID(String RefItemID) {
        this.RefItemID = RefItemID;
    }

    /**
     * 
     * @return
     *     The RefLocID
     */
    public String getRefLocID() {
        return RefLocID;
    }

    /**
     * 
     * @param RefLocID
     *     The RefLocID
     */
    public void setRefLocID(String RefLocID) {
        this.RefLocID = RefLocID;
    }

    /**
     * 
     * @return
     *     The ChildCount
     */
    public String getChildCount() {
        return ChildCount;
    }

    /**
     * 
     * @param ChildCount
     *     The ChildCount
     */
    public void setChildCount(String ChildCount) {
        this.ChildCount = ChildCount;
    }

    /**
     * 
     * @return
     *     The ChildNodes
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getItemMapNodes.ChildNodes getChildNodes() {
        return ChildNodes;
    }

    /**
     * 
     * @param ChildNodes
     *     The ChildNodes
     */
    public void setChildNodes(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getItemMapNodes.ChildNodes ChildNodes) {
        this.ChildNodes = ChildNodes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
