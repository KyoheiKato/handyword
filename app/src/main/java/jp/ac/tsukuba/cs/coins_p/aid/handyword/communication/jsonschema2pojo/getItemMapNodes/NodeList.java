
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getItemMapNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class NodeList {

    private List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getItemMapNodes.ItemMapNode> ItemMapNode = new ArrayList<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getItemMapNodes.ItemMapNode>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ItemMapNode
     */
    public List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getItemMapNodes.ItemMapNode> getItemMapNode() {
        return ItemMapNode;
    }

    /**
     * 
     * @param ItemMapNode
     *     The ItemMapNode
     */
    public void setItemMapNode(List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getItemMapNodes.ItemMapNode> ItemMapNode) {
        this.ItemMapNode = ItemMapNode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
