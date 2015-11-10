
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchDicItemResult {

    private String Xmlns;
    private String ErrorMessage;
    private String TotalHitCount;
    private String ItemCount;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem.TitleList TitleList;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Xmlns
     */
    public String getXmlns() {
        return Xmlns;
    }

    /**
     * 
     * @param Xmlns
     *     The -xmlns
     */
    public void setXmlns(String Xmlns) {
        this.Xmlns = Xmlns;
    }

    /**
     * 
     * @return
     *     The ErrorMessage
     */
    public String getErrorMessage() {
        return ErrorMessage;
    }

    /**
     * 
     * @param ErrorMessage
     *     The ErrorMessage
     */
    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    /**
     * 
     * @return
     *     The TotalHitCount
     */
    public String getTotalHitCount() {
        return TotalHitCount;
    }

    /**
     * 
     * @param TotalHitCount
     *     The TotalHitCount
     */
    public void setTotalHitCount(String TotalHitCount) {
        this.TotalHitCount = TotalHitCount;
    }

    /**
     * 
     * @return
     *     The ItemCount
     */
    public String getItemCount() {
        return ItemCount;
    }

    /**
     * 
     * @param ItemCount
     *     The ItemCount
     */
    public void setItemCount(String ItemCount) {
        this.ItemCount = ItemCount;
    }

    /**
     * 
     * @return
     *     The TitleList
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem.TitleList getTitleList() {
        return TitleList;
    }

    /**
     * 
     * @param TitleList
     *     The TitleList
     */
    public void setTitleList(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem.TitleList TitleList) {
        this.TitleList = TitleList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
