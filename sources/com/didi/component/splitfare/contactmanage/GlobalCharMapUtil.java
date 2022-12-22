package com.didi.component.splitfare.contactmanage;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class GlobalCharMapUtil {
    public static final Map<Character, Character> charMap;

    static {
        HashMap hashMap = new HashMap();
        charMap = hashMap;
        hashMap.put(193, 'A');
        charMap.put(225, 'A');
        charMap.put(226, 'A');
        charMap.put(194, 'A');
        charMap.put(195, 'A');
        charMap.put(227, 'A');
        charMap.put(224, 'A');
        charMap.put(192, 'A');
        charMap.put(199, 'C');
        charMap.put(231, 'C');
        charMap.put(201, 'E');
        charMap.put(233, 'E');
        charMap.put(202, 'E');
        charMap.put(234, 'E');
        charMap.put(205, 'I');
        charMap.put(237, 'I');
        charMap.put(211, 'O');
        charMap.put(243, 'O');
        charMap.put(212, 'O');
        charMap.put(244, 'O');
        charMap.put(213, 'O');
        charMap.put(245, 'O');
        Map<Character, Character> map = charMap;
        Character valueOf = Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_UT);
        map.put(218, valueOf);
        charMap.put(250, valueOf);
        charMap.put(220, valueOf);
        charMap.put(252, valueOf);
        charMap.put(209, 'N');
        charMap.put(241, 'N');
    }

    public static char getGroupChar(char c) {
        if ('a' <= c && c <= 'z') {
            c = (char) (c - ' ');
        }
        if (charMap.containsKey(Character.valueOf(c))) {
            c = charMap.get(Character.valueOf(c)).charValue();
        }
        if (c > 'Z' || c < 'A') {
            return '#';
        }
        return c;
    }

    public static char getGroupCharForSort(char c) {
        if ('a' <= c && c <= 'z') {
            c = (char) (c - ' ');
        }
        return charMap.containsKey(Character.valueOf(c)) ? charMap.get(Character.valueOf(c)).charValue() : c;
    }
}
