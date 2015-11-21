package jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class AccessTokenResult {

    @Getter @Setter
    @SerializedName("token_type")
    private String tokenType;

    @Getter @Setter
    @SerializedName("access_token")
    private String accessToken;

    @Getter @Setter
    @SerializedName("expires_in")
    private int expiresIn;

    @Getter @Setter
    @SerializedName("scope")
    private String scope;
}