package org.apache.commons.codec2.language;

import org.apache.commons.codec2.EncoderException;
import org.apache.commons.codec2.StringEncoder;

public abstract class AbstractCaverphone implements StringEncoder {
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    public boolean isEncodeEqual(String str, String str2) throws EncoderException {
        return encode(str).equals(encode(str2));
    }
}
