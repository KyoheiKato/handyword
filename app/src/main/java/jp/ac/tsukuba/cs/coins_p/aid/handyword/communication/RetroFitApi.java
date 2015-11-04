package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Naoya on 2015/11/04.
 */
public interface RetroFitApi {
    /**
     * �A�m�e�[�V������GET/POST/PUT/DELETE���w��B
     * �J�b�R���̓��N�G�X�g�̃z�X�g���ȍ~���w��B
     *
     * �߂�^��void�Ƃ��邱�Ƃŏ���ɕʃX���b�h�ŒʐM�������s���Ă����B
     *
     * ���\�b�h�̈����ƃA�m�e�[�V�����̑g�ݍ��킹��
     * ���N�G�X�g�p�����[�^�𐶐�����B
     * ���L�̗�ł�?name="hoge"���t�^�����
     *
     * �R�[���o�b�N��POJO�̃I�u�W�F�N�g���w�肷���POJO�ϊ����Ă����B
     */
    @GET("/news/new")
    void getNew(@Query("name") String name, Callback<ArticleList> cb);
}
