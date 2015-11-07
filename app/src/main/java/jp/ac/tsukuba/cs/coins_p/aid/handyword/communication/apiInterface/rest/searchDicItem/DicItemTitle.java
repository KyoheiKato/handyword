
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.searchDicItem;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DicItemTitle {

    private String ItemID;
    private String LocID;
    private String Title;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ItemID
     */
    public String getItemID() {
        return ItemID;
    }

    /**
     * 
     * @param ItemID
     *     The ItemID
     */
    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    /**
     * 
     * @return
     *     The LocID
     */
    public String getLocID() {
        return LocID;
    }

    /**
     * 
     * @param LocID
     *     The LocID
     */
    public void setLocID(String LocID) {
        this.LocID = LocID;
    }

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
