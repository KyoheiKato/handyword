package jp.ac.tsukuba.cs.coins_p.aid.handyword.dataschema;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.Setter;

@Root(name = "root")
public class TranslationResult {
    @Getter @Setter
    @Element(name = "string")
    private String translatedString;
}