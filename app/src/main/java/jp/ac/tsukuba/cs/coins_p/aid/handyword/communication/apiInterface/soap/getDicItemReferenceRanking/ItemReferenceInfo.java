package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.soap.getDicItemReferenceRanking;

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class ItemReferenceInfo {

    private String DicID;
    private String ItemID;
    private String DicName;
    private String Title;
    private String Count;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The DicID
     */
    public String getDicID() {
        return DicID;
    }

    /**
     *
     * @param DicID
     * The DicID
     */
    public void setDicID(String DicID) {
        this.DicID = DicID;
    }

    /**
     *
     * @return
     * The ItemID
     */
    public String getItemID() {
        return ItemID;
    }

    /**
     *
     * @param ItemID
     * The ItemID
     */
    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    /**
     *
     * @return
     * The DicName
     */
    public String getDicName() {
        return DicName;
    }

    /**
     *
     * @param DicName
     * The DicName
     */
    public void setDicName(String DicName) {
        this.DicName = DicName;
    }

    /**
     *
     * @return
     * The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     *
     * @param Title
     * The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     *
     * @return
     * The Count
     */
    public String getCount() {
        return Count;
    }

    /**
     *
     * @param Count
     * The Count
     */
    public void setCount(String Count) {
        this.Count = Count;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}