package jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import lombok.Data;

@Data
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

    public WordCard(String word, String translatedWord) {
        this.word = word;
        this.translatedWord = translatedWord;
        initModelDate();
    }

    private void initModelDate() {
        Date currentTime = new Date();
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }
}
