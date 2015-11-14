
package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DicItemTitle {

    public class ItemID {
        private String ItemID;
        /**
         * @return
         *     The ItemID
         */
        public String getItemID() {
            return ItemID;
        }

        /**
         * @param ItemID
         *     The ItemID
         */
        public void setItemID(String ItemID) {
            this.ItemID = ItemID;
        }
    }

    public class LocID{
        private String LocID;
        /**
         * @return
         *     The LocID
         */
        public String getLocID() {
            return LocID;
        }

        /**
         * @param LocID
         *     The LocID
         */
        public void setLocID(String LocID) {
            this.LocID = LocID;
        }
    }

    public class Title{
        private String Title;
        /**
         * @return
         *     The Title
         */
        public String getTitle() {
            return Title;
        }

        /**
         * @param Title
         *     The Title
         */
        public void setTitle(String Title) {
            this.Title = Title;
        }
    }

    @ElementListUnion({
        @ElementList(name = "ItemID", required = false),
        @ElementList(name = "LocID", required = false),
        @ElementList(name = "Title", required = false, data = true),
    })

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
