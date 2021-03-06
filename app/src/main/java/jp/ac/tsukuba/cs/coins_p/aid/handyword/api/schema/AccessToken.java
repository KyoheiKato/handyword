package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import lombok.Data;

@Data
public class AccessToken {
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private int expiresIn;
    private String scope;
    private Date effectiveTime;
}