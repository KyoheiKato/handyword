package jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model;

import android.content.Context;

import java.util.Date;
import java.util.List;
import java.util.Random;

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

    public WordCard getRandomWordCard() {
        // TODO check id conformity
        int count = realmInstance.where(WordCard.class).findAll().size();

        WordCard randomWordCard = null;
        Random rnd = new Random();

        if (count == 0) return null;

        while (randomWordCard == null) {
            int randomId = rnd.nextInt(count) + 1;
            randomWordCard = realmInstance.where(WordCard.class).equalTo(FieldName.id, randomId).findFirst();
        }

        return randomWordCard;
    }

    public List<WordCard> findAll() {
        return realmInstance.where(WordCard.class).findAll();
    }

    private int getNextPrimaryKey() {
        if(realmInstance.where(WordCard.class).max(FieldName.id) != null) {
            return realmInstance.where(WordCard.class).max(FieldName.id).intValue() + 1;
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

    public static class FieldName {
        public static final String id = "id";
    }
}
