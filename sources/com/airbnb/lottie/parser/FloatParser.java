package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class FloatParser implements C1523u<Float> {
    public static final FloatParser INSTANCE = new FloatParser();

    private FloatParser() {
    }

    public Float parse(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(C1503g.m1414b(jsonReader) * f);
    }
}
