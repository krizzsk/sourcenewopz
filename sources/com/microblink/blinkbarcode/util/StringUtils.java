package com.microblink.blinkbarcode.util;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: line */
public class StringUtils {
    static {
        HashSet hashSet = new HashSet(10);
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            hashSet.add(Character.valueOf(c));
        }
        Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet(36);
        for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
            hashSet2.add(Character.valueOf(c2));
        }
        for (char c3 = 'A'; c3 <= 'Z'; c3 = (char) (c3 + 1)) {
            hashSet2.add(Character.valueOf(c3));
        }
        for (char c4 = 'a'; c4 <= 'z'; c4 = (char) (c4 + 1)) {
            hashSet2.add(Character.valueOf(c4));
        }
        Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet(36);
        for (char c5 = '0'; c5 <= '9'; c5 = (char) (c5 + 1)) {
            hashSet3.add(Character.valueOf(c5));
        }
        for (char c6 = 'A'; c6 <= 'Z'; c6 = (char) (c6 + 1)) {
            hashSet3.add(Character.valueOf(c6));
        }
        Collections.unmodifiableSet(hashSet3);
    }

    public static String convertByteArrayToString(byte[] bArr) {
        String[] strArr = {"UTF-8", "ISO-8859-1", "UTF-16", "US-ASCII"};
        int i = 0;
        while (i < 4) {
            try {
                return Charset.forName(strArr[i]).newDecoder().decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException unused) {
                i++;
            }
        }
        return new String(bArr, Charset.forName("US-ASCII"));
    }
}
