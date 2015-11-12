
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem;

import android.util.Xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")

@Root(name = "DicItemTitle")
public class DicItemTitle {

    @Element(name = "ItemID", required = false)
    private String ItemID;

    @Element(name = "LocID", required = false)
    private String LocID;

    @Element(name = "Title", required = false, data = true)
    private Xml Title;

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
    public Xml getTitle() {
        return Title;
    }

    /**
     * 
     * @param Title
     *     The Title
     */
    public void setTitle(Xml Title) {
        this.Title = Title;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}