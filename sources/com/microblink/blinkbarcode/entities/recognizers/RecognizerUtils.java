package com.microblink.blinkbarcode.entities.recognizers;

import java.util.ArrayList;

/* compiled from: line */
public class RecognizerUtils {
    public static Recognizer[] filterOutRecognizersThatRequireAutofocus(Recognizer[] recognizerArr) {
        ArrayList arrayList = new ArrayList();
        for (Recognizer recognizer : recognizerArr) {
            if (recognizer != null && !recognizer.requiresAutofocus()) {
                arrayList.add(recognizer);
            }
        }
        Recognizer[] recognizerArr2 = new Recognizer[arrayList.size()];
        arrayList.toArray(recognizerArr2);
        return recognizerArr2;
    }
}
