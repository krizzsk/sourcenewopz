package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.didi.raven.config.RavenKey;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.io.IOException;

public class AnimatableTextPropertiesParser {

    /* renamed from: a */
    private static JsonReader.Options f1585a = JsonReader.Options.m1436of(Constants.FILE_ANR_KEY);

    /* renamed from: b */
    private static JsonReader.Options f1586b = JsonReader.Options.m1436of("fc", "sc", LoginOmegaUtil.ACTIONID_SW, RavenKey.TYPE);

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(f1585a) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                animatableTextProperties = m1382a(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return animatableTextProperties == null ? new AnimatableTextProperties((AnimatableColorValue) null, (AnimatableColorValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null) : animatableTextProperties;
    }

    /* renamed from: a */
    private static AnimatableTextProperties m1382a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1586b);
            if (selectName == 0) {
                animatableColorValue = AnimatableValueParser.m1397f(jsonReader, lottieComposition);
            } else if (selectName == 1) {
                animatableColorValue2 = AnimatableValueParser.m1397f(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }
}
