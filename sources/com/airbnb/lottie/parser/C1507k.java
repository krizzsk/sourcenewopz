package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.didi.raven.config.RavenKey;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.parser.k */
/* compiled from: MergePathsParser */
class C1507k {

    /* renamed from: a */
    private static final JsonReader.Options f1616a = JsonReader.Options.m1436of(RavenKey.NAME, "mm", "hd");

    private C1507k() {
    }

    /* renamed from: a */
    static MergePaths m1428a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1616a);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (selectName != 2) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
