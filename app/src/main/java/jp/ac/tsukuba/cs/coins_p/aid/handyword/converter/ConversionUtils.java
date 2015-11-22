package jp.ac.tsukuba.cs.coins_p.aid.handyword.converter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ConversionUtils {

    public InputStream getRootAddedXML(InputStream inputStream){
        return getInputStreamFromString(addRootTag(getStringFromInputStream(inputStream)));
    }

    public String getStringFromInputStream(InputStream inputStream){
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e){
            throw new AssertionError(e);
        }

    }

    private String addRootTag(String string){
        String rootAddedString;
        rootAddedString = "<root>\n" + string + "\n</root>";
        return rootAddedString;
    }

    public InputStream getInputStreamFromString(String string){
        InputStream inputStream;
        try{
            inputStream = new ByteArrayInputStream(string.getBytes("utf-8"));
            return inputStream;
        } catch (UnsupportedEncodingException e){
            throw new AssertionError(e);
        }
    }

}
