package jp.ac.tsukuba.cs.coins_p.aid.handyword.dataschema;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;

@Getter
@Root(name = "root")
public class TranslationEntity {
    @Element(name = "string")
    private String translatedString;
}