package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit;

import retrofit.RetrofitError;

public abstract interface RequestListener<T> {
    void onSuccess(T response);
    void onFailure(RetrofitError error);
}
