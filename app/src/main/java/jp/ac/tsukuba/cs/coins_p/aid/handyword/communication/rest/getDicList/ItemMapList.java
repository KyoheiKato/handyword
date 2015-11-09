
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getDicList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ItemMapList {

    private List<String> string = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The string
     */
    public List<String> getString() {
        return string;
    }

    /**
     * 
     * @param string
     *     The string
     */
    public void setString(List<String> string) {
        this.string = string;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
