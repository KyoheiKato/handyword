
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DicInfo {

    private String DicID;
    private String FullName;
    private String ShortName;
    private String Publisher;
    private String Abbrev;
    private String StartItemID;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.ScopeList ScopeList;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.SearchOptionList SearchOptionList;
    private String DefSearchOptionIndex;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.ItemMapList ItemMapList;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DicID
     */
    public String getDicID() {
        return DicID;
    }

    /**
     * 
     * @param DicID
     *     The DicID
     */
    public void setDicID(String DicID) {
        this.DicID = DicID;
    }

    /**
     * 
     * @return
     *     The FullName
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * 
     * @param FullName
     *     The FullName
     */
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    /**
     * 
     * @return
     *     The ShortName
     */
    public String getShortName() {
        return ShortName;
    }

    /**
     * 
     * @param ShortName
     *     The ShortName
     */
    public void setShortName(String ShortName) {
        this.ShortName = ShortName;
    }

    /**
     * 
     * @return
     *     The Publisher
     */
    public String getPublisher() {
        return Publisher;
    }

    /**
     * 
     * @param Publisher
     *     The Publisher
     */
    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    /**
     * 
     * @return
     *     The Abbrev
     */
    public String getAbbrev() {
        return Abbrev;
    }

    /**
     * 
     * @param Abbrev
     *     The Abbrev
     */
    public void setAbbrev(String Abbrev) {
        this.Abbrev = Abbrev;
    }

    /**
     * 
     * @return
     *     The StartItemID
     */
    public String getStartItemID() {
        return StartItemID;
    }

    /**
     * 
     * @param StartItemID
     *     The StartItemID
     */
    public void setStartItemID(String StartItemID) {
        this.StartItemID = StartItemID;
    }

    /**
     * 
     * @return
     *     The ScopeList
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.ScopeList getScopeList() {
        return ScopeList;
    }

    /**
     * 
     * @param ScopeList
     *     The ScopeList
     */
    public void setScopeList(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.ScopeList ScopeList) {
        this.ScopeList = ScopeList;
    }

    /**
     * 
     * @return
     *     The SearchOptionList
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.SearchOptionList getSearchOptionList() {
        return SearchOptionList;
    }

    /**
     * 
     * @param SearchOptionList
     *     The SearchOptionList
     */
    public void setSearchOptionList(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.SearchOptionList SearchOptionList) {
        this.SearchOptionList = SearchOptionList;
    }

    /**
     * 
     * @return
     *     The DefSearchOptionIndex
     */
    public String getDefSearchOptionIndex() {
        return DefSearchOptionIndex;
    }

    /**
     * 
     * @param DefSearchOptionIndex
     *     The DefSearchOptionIndex
     */
    public void setDefSearchOptionIndex(String DefSearchOptionIndex) {
        this.DefSearchOptionIndex = DefSearchOptionIndex;
    }

    /**
     * 
     * @return
     *     The ItemMapList
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.ItemMapList getItemMapList() {
        return ItemMapList;
    }

    /**
     * 
     * @param ItemMapList
     *     The ItemMapList
     */
    public void setItemMapList(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.ItemMapList ItemMapList) {
        this.ItemMapList = ItemMapList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
