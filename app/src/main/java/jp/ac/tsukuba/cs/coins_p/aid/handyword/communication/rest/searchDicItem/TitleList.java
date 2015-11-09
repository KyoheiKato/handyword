
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.searchDicItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TitleList {

    private List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.searchDicItem.DicItemTitle> DicItemTitle = new ArrayList<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.searchDicItem.DicItemTitle>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DicItemTitle
     */
    public List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.searchDicItem.DicItemTitle> getDicItemTitle() {
        return DicItemTitle;
    }

    /**
     * 
     * @param DicItemTitle
     *     The DicItemTitle
     */
    public void setDicItemTitle(List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.searchDicItem.DicItemTitle> DicItemTitle) {
        this.DicItemTitle = DicItemTitle;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
