package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.soap.getDicItemReferenceRanking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class GetDicItemReferenceRankingResult {

    private List<ItemReferenceInfo> ItemReferenceInfo = new ArrayList<ItemReferenceInfo>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The ItemReferenceInfo
     */
    public List<ItemReferenceInfo> getItemReferenceInfo() {
        return ItemReferenceInfo;
    }

    /**
     *
     * @param ItemReferenceInfo
     * The ItemReferenceInfo
     */
    public void setItemReferenceInfo(List<ItemReferenceInfo> ItemReferenceInfo) {
        this.ItemReferenceInfo = ItemReferenceInfo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}