package jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.Setter;


@Root(name = "string")
public class TranslationResult {
    @Getter @Setter
    private String translatedString;
}