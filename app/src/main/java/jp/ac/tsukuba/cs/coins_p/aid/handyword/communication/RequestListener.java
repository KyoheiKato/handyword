package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;


import retrofit.RetrofitError;

/**
 * REST�ʐM�̃R�[���o�b�N�ɗ��p����interface
 */
public abstract interface RequestListener<T> {
    void onSuccess(T response);
    void onFailure(RetrofitError error);
}
