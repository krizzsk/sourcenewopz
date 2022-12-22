package org.apache.commons.codec2;

public interface Encoder {
    Object encode(Object obj) throws EncoderException;
}
