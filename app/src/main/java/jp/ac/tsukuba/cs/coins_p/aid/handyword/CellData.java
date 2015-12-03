package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import java.util.Date;
import lombok.Data;

@Data
public class CellData {

    private int id;
    private String word;
    private String translatedWord;

    public CellData(int id, String word, String translatedWord){
        this.id = id;
        this.word = word;
        this.translatedWord = translatedWord;
    }
}