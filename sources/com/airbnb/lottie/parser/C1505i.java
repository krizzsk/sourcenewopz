package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.parser.i */
/* compiled from: KeyframesParser */
class C1505i {

    /* renamed from: a */
    static JsonReader.Options f1615a = JsonReader.Options.m1436of("k");

    private C1505i() {
    }

    /* renamed from: a */
    static <T> List<Keyframe<T>> m1425a(JsonReader jsonReader, LottieComposition lottieComposition, float f, C1523u<T> uVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(f1615a) != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    arrayList.add(C1504h.m1422a(jsonReader, lottieComposition, f, uVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(C1504h.m1422a(jsonReader, lottieComposition, f, uVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(C1504h.m1422a(jsonReader, lottieComposition, f, uVar, false));
            }
        }
        jsonReader.endObject();
        m1426a(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public static <T> void m1426a(List<? extends Keyframe<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Keyframe keyframe = (Keyframe) list.get(i2);
            i2++;
            Keyframe keyframe2 = (Keyframe) list.get(i2);
            keyframe.endFrame = Float.valueOf(keyframe2.startFrame);
            if (keyframe.endValue == null && keyframe2.startValue != null) {
                keyframe.endValue = keyframe2.startValue;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).createPath();
                }
            }
        }
        Keyframe keyframe3 = (Keyframe) list.get(i);
        if ((keyframe3.startValue == null || keyframe3.endValue == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
