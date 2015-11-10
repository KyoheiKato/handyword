
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DicInfoList {

    private List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.DicInfo> DicInfo = new ArrayList<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.DicInfo>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DicInfo
     */
    public List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.DicInfo> getDicInfo() {
        return DicInfo;
    }

    /**
     * 
     * @param DicInfo
     *     The DicInfo
     */
    public void setDicInfo(List<jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicList.DicInfo> DicInfo) {
        this.DicInfo = DicInfo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
