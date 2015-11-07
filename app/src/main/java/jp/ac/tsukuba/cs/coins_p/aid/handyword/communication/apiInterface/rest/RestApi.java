package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class RestApi {

    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicItem.GetDicItemResult GetDicItemResult;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.GetDicInfoResult GetDicInfoResult;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getItemMapNodes.GetItemMapNodesResult GetItemMapNodesResult;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.searchDicItem.SearchDicItemResult SearchDicItemResult;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The GetDicItemResult
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicItem.GetDicItemResult getGetDicItemResult() {
        return GetDicItemResult;
    }

    /**
     * @param GetDicItemResult The GetDicItemResult
     */
    public void setGetDicItemResult(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicItem.GetDicItemResult GetDicItemResult) {
        this.GetDicItemResult = GetDicItemResult;
    }

    /**
     *
     * @return
     * The GetDicInfoResult
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.GetDicInfoResult getGetDicInfoResult() {
        return GetDicInfoResult;
    }

    /**
     *
     * @param GetDicInfoResult
     * The GetDicInfoResult
     */
    public void setGetDicInfoResult(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getDicList.GetDicInfoResult GetDicInfoResult) {
        this.GetDicInfoResult = GetDicInfoResult;
    }

    /**
     *
     * @return
     * The GetItemMapNodesResult
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getItemMapNodes.GetItemMapNodesResult getGetItemMapNodesResult() {
        return GetItemMapNodesResult;
    }

    /**
     *
     * @param GetItemMapNodesResult
     * The GetItemMapNodesResult
     */
    public void setGetItemMapNodesResult(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.getItemMapNodes.GetItemMapNodesResult GetItemMapNodesResult) {
        this.GetItemMapNodesResult = GetItemMapNodesResult;
    }

    /**
     *
     * @return
     * The SearchDicItemResult
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.searchDicItem.SearchDicItemResult getSearchDicItemResult() {
        return SearchDicItemResult;
    }

    /**
     *
     * @param SearchDicItemResult
     * The SearchDicItemResult
     */
    public void setSearchDicItemResult(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.rest.searchDicItem.SearchDicItemResult SearchDicItemResult) {
        this.SearchDicItemResult = SearchDicItemResult;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}