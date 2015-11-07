package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.apiInterface;
import java.util.HashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class GetDicItemResponse {

    private String Xmlns;
    private GetDicItemResult GetDicItemResult;
    private Map<String, Object> additionalProperties = new HashMap<>();

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
     * The GetDicItemResult
     */
    public GetDicItemResult getGetDicItemResult() {
        return GetDicItemResult;
    }

    /**
     *
     * @param GetDicItemResult
     * The GetDicItemResult
     */
    public void setGetDicItemResult(GetDicItemResult GetDicItemResult) {
        this.GetDicItemResult = GetDicItemResult;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}