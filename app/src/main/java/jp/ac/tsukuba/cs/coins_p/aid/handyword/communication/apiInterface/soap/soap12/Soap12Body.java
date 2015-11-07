package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.soap.soap12;

import java.util.HashMap;
import java.util.Map;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.soap.getDicItem.GetDicItemResponse;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.soap.getDicItemReferenceRanking.GetDicItemReferenceRankingResponse;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Soap12Body {

    private GetDicItemResponse GetDicItemResponse;
    private GetDicItemReferenceRankingResponse GetDicItemReferenceRankingResponse;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     *
     * @return
     * The GetDicItemResponse
     */
    public GetDicItemResponse getGetDicItemResponse() {
        return GetDicItemResponse;
    }

    /**
     *
     * @param GetDicItemResponse
     * The GetDicItemResponse
     */
    public void setGetDicItemResponse(GetDicItemResponse GetDicItemResponse) {
        this.GetDicItemResponse = GetDicItemResponse;
    }

    /**
     *
     * @return
     * The GetDicItemReferenceRankingResponse
     */
    public GetDicItemReferenceRankingResponse getGetDicItemReferenceRankingResponse() {
        return GetDicItemReferenceRankingResponse;
    }

    /**
     *
     * @param GetDicItemReferenceRankingResponse
     * The GetDicItemReferenceRankingResponse
     */
    public void setGetDicItemReferenceRankingResponse(GetDicItemReferenceRankingResponse GetDicItemReferenceRankingResponse) {
        this.GetDicItemReferenceRankingResponse = GetDicItemReferenceRankingResponse;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}