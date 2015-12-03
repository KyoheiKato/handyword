package jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import lombok.Data;

//@Data
public class WordCard extends RealmObject {
    @PrimaryKey
    private int id;
    @Required
    @Index
    private String word;
    @Required
    private String translatedWord;
    @Required
    private Date createdAt;
    @Required
    private Date updatedAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /*public WordCard(String word, String translatedWord) {
        this.word = word;
        this.translatedWord = translatedWord;
        initModelDate();
    }

    private void initModelDate() {
        Date currentTime = new Date();
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }*/
}
