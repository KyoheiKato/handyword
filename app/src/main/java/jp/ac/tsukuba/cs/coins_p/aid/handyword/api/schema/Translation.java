package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;

@Getter
@Root(name = "root")
public class Translation {
    @Element(name = "string")
    private String translatedString;
}