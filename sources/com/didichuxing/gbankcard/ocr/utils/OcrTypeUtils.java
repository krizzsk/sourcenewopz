package com.didichuxing.gbankcard.ocr.utils;

public class OcrTypeUtils {
    public static final int TYPE_DIDI_ALPHA = 2;
    public static final int TYPE_DIDI_CARDIO = 1;

    public static boolean isUsingDidiCardIO(int i) {
        return i == 1;
    }
}
