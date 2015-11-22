package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import lombok.Getter;
import lombok.Setter;

public class Translation {
    @Getter @Setter
    String translatedString = "";

    public String translate(String stringToTranslate){
        TranslationCommunication translationCommunication = new TranslationCommunication(this);

        translationCommunication.setStringToTranslate(stringToTranslate);
        translationCommunication.start();
        try {
            translationCommunication.join();
        } catch (InterruptedException e) {}
        return translatedString;
    }
}
