
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getItemMapNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ChildNodes {

    private List<ItemMapNode_> ItemMapNode = new ArrayList<ItemMapNode_>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ItemMapNode
     */
    public List<ItemMapNode_> getItemMapNode() {
        return ItemMapNode;
    }

    /**
     * 
     * @param ItemMapNode
     *     The ItemMapNode
     */
    public void setItemMapNode(List<ItemMapNode_> ItemMapNode) {
        this.ItemMapNode = ItemMapNode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
