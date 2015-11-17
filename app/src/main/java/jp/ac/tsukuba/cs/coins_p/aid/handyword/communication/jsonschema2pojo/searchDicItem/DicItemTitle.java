
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem;

import com.google.gson.annotations.Expose;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.core.Resolve;

import java.util.HashMap;
import java.util.Map;

@Root(strict = false)
public class DicItemTitle {

    @Element
    private String ItemID;
    @Element
    private String LocID;
    @Element(data = true, required = true)
    private String Title;

    /**
     * @return
     *     The ItemID
     */
    public String getItemID() {
        return ItemID;
    }

    /**
     * @param ItemID
     *     The ItemID
     */
    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    /**
     * @return
     *     The LocID
     */
    public String getLocID() {
        return LocID;
    }

    /**
     * @param LocID
     *     The LocID
     */
    public void setLocID(String LocID) {
        this.LocID = LocID;
    }

    /**
     * @return
     *     The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title
     *     The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
