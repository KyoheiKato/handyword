package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface.soap.getDicItemReferenceRanking;

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class GetDicItemReferenceRankingResponse {

    private String Xmlns;
    private GetDicItemReferenceRankingResult GetDicItemReferenceRankingResult;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The Xmlns
     */
    public String getXmlns() {
        return Xmlns;
    }

    /**
     *
     * @param Xmlns
     * The -xmlns
     */
    public void setXmlns(String Xmlns) {
        this.Xmlns = Xmlns;
    }

    /**
     *
     * @return
     * The GetDicItemReferenceRankingResult
     */
    public GetDicItemReferenceRankingResult getGetDicItemReferenceRankingResult() {
        return GetDicItemReferenceRankingResult;
    }

    /**
     *
     * @param GetDicItemReferenceRankingResult
     * The GetDicItemReferenceRankingResult
     */
    public void setGetDicItemReferenceRankingResult(GetDicItemReferenceRankingResult GetDicItemReferenceRankingResult) {
        this.GetDicItemReferenceRankingResult = GetDicItemReferenceRankingResult;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}