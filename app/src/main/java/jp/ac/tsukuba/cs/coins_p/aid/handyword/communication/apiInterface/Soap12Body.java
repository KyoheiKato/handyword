package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface;

import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Soap12Body {

    private GetDicItemResponse GetDicItemResponse;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}