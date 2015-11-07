
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchOptionList {

    private List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.SearchOption> SearchOption = new ArrayList<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.SearchOption>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The SearchOption
     */
    public List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.SearchOption> getSearchOption() {
        return SearchOption;
    }

    /**
     * 
     * @param SearchOption
     *     The SearchOption
     */
    public void setSearchOption(List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.SearchOption> SearchOption) {
        this.SearchOption = SearchOption;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
