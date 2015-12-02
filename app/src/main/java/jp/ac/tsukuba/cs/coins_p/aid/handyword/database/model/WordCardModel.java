package jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model;

import android.content.Context;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;

public class WordCardModel {

    private static final WordCardModel instance = new WordCardModel();

    private Realm realmInstance;

    private WordCardModel() {
        realmInstance = null;
    }

    public static WordCardModel getInstance() {
        return instance;
    }

    public void initRealmInstance(Context context) {
        if (realmInstance == null)
            realmInstance = Realm.getInstance(context);
    }

    public void saveWordCard(WordCard wordCard) {
        realmInstance.beginTransaction();
        wordCard.setId(getNextPrimaryKey());
        realmInstance.copyToRealm(wordCard);
        realmInstance.commitTransaction();
    }

    public void updateWordCard(WordCard wordCard) {
        realmInstance.beginTransaction();
        wordCard.setUpdatedAt(new Date());
        realmInstance.copyToRealmOrUpdate(wordCard);
        realmInstance.commitTransaction();
    }

    public List<WordCard> findAll() {
        return realmInstance.where(WordCard.class).findAll();
    }

    private int getNextPrimaryKey() {
        int res;
        if(realmInstance.where(WordCard.class).max("id") != null) {
            res = realmInstance.where(WordCard.class).max("id").intValue() + 1;
        } else {
            res = 0;
        }
        return res;
    }
}