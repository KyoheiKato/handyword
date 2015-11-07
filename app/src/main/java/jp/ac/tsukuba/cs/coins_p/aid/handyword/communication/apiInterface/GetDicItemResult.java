package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface;

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class GetDicItemResult {

    private String DicID;
    private String ItemID;
    private String LocID;
    private String Title;
    private String Head;
    private String Body;
    private Map<String, Object> additionalProperties = new HashMap<>();

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
     * The LocID
     */
    public String getLocID() {
        return LocID;
    }

    /**
     *
     * @param LocID
     * The LocID
     */
    public void setLocID(String LocID) {
        this.LocID = LocID;
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
     * The Head
     */
    public String getHead() {
        return Head;
    }

    /**
     *
     * @param Head
     * The Head
     */
    public void setHead(String Head) {
        this.Head = Head;
    }

    /**
     *
     * @return
     * The Body
     */
    public String getBody() {
        return Body;
    }

    /**
     *
     * @param Body
     * The Body
     */
    public void setBody(String Body) {
        this.Body = Body;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}