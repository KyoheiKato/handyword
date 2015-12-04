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

    public WordCard getWordCard(int id){
        return realmInstance.where(WordCard.class).equalTo("id", id).findFirst();
    }

    private int getNextPrimaryKey() {
        if(realmInstance.where(WordCard.class).max("id") != null) {
            return realmInstance.where(WordCard.class).max("id").intValue() + 1;
        } else {
            return 0;
        }
    }

    public static WordCard createWordCardWith(String word, String translatedWord) {
        WordCard wordCard = new WordCard();
        wordCard.setWord(word);
        wordCard.setTranslatedWord(translatedWord);
        initDates(wordCard);
        return wordCard;
    }

    private static void initDates(WordCard wordCard) {
        Date currentTime = new Date();
        wordCard.setCreatedAt(currentTime);
        wordCard.setUpdatedAt(currentTime);
    }
}
