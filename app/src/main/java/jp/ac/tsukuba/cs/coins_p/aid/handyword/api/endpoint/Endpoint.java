package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.MicrosoftTranslateApi;

public abstract class Endpoint {
    private static final String TAG = Endpoint.class.getCanonicalName();

    protected MicrosoftTranslateApi microsoftTranslateApi;
}
