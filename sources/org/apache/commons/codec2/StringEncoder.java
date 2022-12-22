package org.apache.commons.codec2;

public interface StringEncoder extends Encoder {
    String encode(String str) throws EncoderException;
}
