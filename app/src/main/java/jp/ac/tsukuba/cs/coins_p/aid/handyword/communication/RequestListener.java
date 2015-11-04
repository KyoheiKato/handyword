package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;


import retrofit.RetrofitError;

/**
 * REST通信のコールバックに利用するinterface
 */
public abstract interface RequestListener<T> {
    void onSuccess(T response);
    void onFailure(RetrofitError error);
}
