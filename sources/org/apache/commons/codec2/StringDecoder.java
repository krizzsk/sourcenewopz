package org.apache.commons.codec2;

public interface StringDecoder extends Decoder {
    String decode(String str) throws DecoderException;
}
