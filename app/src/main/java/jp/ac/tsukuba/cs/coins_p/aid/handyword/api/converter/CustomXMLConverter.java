package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.converter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class CustomXMLConverter implements Converter {
    private static final String CHARSET = "UTF-8";
    private static final String MIME_TYPE = "application/xml; charset=" + CHARSET;

    private final Serializer serializer;
    ConversionUtils conversionUtils = new ConversionUtils();

    public CustomXMLConverter() {
        this(new Persister());
    }

    public CustomXMLConverter(Serializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        try {
            InputStream inputStream = conversionUtils.getRootAddedXML(body.in());
            return serializer.read((Class<?>) type, inputStream);
        } catch (Exception e) {
            throw new ConversionException(e);
        }
    }

    @Override
    public TypedOutput toBody(Object source) {
        OutputStreamWriter osw = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            osw = new OutputStreamWriter(bos, CHARSET);
            serializer.write(source, osw);
            osw.flush();
            return new TypedByteArray(MIME_TYPE, bos.toByteArray());
        } catch (Exception e) {
            throw new AssertionError(e);
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }
}