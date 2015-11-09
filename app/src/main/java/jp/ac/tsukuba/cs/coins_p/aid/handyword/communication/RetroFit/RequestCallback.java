package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * REST�ʐM�̃R�[���o�b�N
 */
public class RequestCallback<T> implements Callback<T> {

    private RequestListener<T> mListener;

    public RequestCallback(RequestListener<T> listener){
        mListener = listener;
    }

    // ����I�����ɌĂ΂��
    @Override
    public void success(T object, Response response){
        mListener.onSuccess(object);
    }

    // �ُ�I�����ɌĂ΂��
    @Override
    public void failure(RetrofitError error){
        mListener.onFailure(error);
    }
}