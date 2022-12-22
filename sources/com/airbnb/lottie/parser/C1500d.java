package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.parser.d */
/* compiled from: FontParser */
class C1500d {

    /* renamed from: a */
    private static final JsonReader.Options f1604a = JsonReader.Options.m1436of("fFamily", "fName", "fStyle", "ascent");

    private C1500d() {
    }

    /* renamed from: a */
    static Font m1409a(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1604a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                str2 = jsonReader.nextString();
            } else if (selectName == 2) {
                str3 = jsonReader.nextString();
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                f = (float) jsonReader.nextDouble();
            }
        }
        jsonReader.endObject();
        return new Font(str, str2, str3, f);
    }
}
