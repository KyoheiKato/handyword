
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GetDicInfoResult {

    private String Xmlns;
    private String ErrorMessage;
    private String DicCount;
    private jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.DicInfoList DicInfoList;
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
     *     The DicCount
     */
    public String getDicCount() {
        return DicCount;
    }

    /**
     * 
     * @param DicCount
     *     The DicCount
     */
    public void setDicCount(String DicCount) {
        this.DicCount = DicCount;
    }

    /**
     * 
     * @return
     *     The DicInfoList
     */
    public jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.DicInfoList getDicInfoList() {
        return DicInfoList;
    }

    /**
     * 
     * @param DicInfoList
     *     The DicInfoList
     */
    public void setDicInfoList(jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.DicInfoList DicInfoList) {
        this.DicInfoList = DicInfoList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
