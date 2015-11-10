
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ScopeList {

    private List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.Scope> Scope = new ArrayList<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.Scope>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Scope
     */
    public List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.Scope> getScope() {
        return Scope;
    }

    /**
     * 
     * @param Scope
     *     The Scope
     */
    public void setScope(List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.Scope> Scope) {
        this.Scope = Scope;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
