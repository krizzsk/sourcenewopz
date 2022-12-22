package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return parseFloat(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition, boolean z) throws IOException {
        return new AnimatableFloatValue(m1391a(jsonReader, z ? Utils.dpScale() : 1.0f, lottieComposition, FloatParser.INSTANCE));
    }

    /* renamed from: a */
    static AnimatableIntegerValue m1390a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(m1392a(jsonReader, lottieComposition, IntegerParser.INSTANCE));
    }

    /* renamed from: b */
    static AnimatablePointValue m1393b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(m1391a(jsonReader, Utils.dpScale(), lottieComposition, PointFParser.INSTANCE));
    }

    /* renamed from: c */
    static AnimatableScaleValue m1394c(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue((List<Keyframe<ScaleXY>>) m1392a(jsonReader, lottieComposition, ScaleXYParser.INSTANCE));
    }

    /* renamed from: d */
    static AnimatableShapeValue m1395d(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(m1391a(jsonReader, Utils.dpScale(), lottieComposition, ShapeDataParser.INSTANCE));
    }

    /* renamed from: e */
    static AnimatableTextFrame m1396e(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(m1392a(jsonReader, lottieComposition, DocumentDataParser.INSTANCE));
    }

    /* renamed from: f */
    static AnimatableColorValue m1397f(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(m1392a(jsonReader, lottieComposition, ColorParser.INSTANCE));
    }

    /* renamed from: a */
    static AnimatableGradientColorValue m1389a(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        return new AnimatableGradientColorValue(m1392a(jsonReader, lottieComposition, new GradientColorParser(i)));
    }

    /* renamed from: a */
    private static <T> List<Keyframe<T>> m1392a(JsonReader jsonReader, LottieComposition lottieComposition, C1523u<T> uVar) throws IOException {
        return C1505i.m1425a(jsonReader, lottieComposition, 1.0f, uVar);
    }

    /* renamed from: a */
    private static <T> List<Keyframe<T>> m1391a(JsonReader jsonReader, float f, LottieComposition lottieComposition, C1523u<T> uVar) throws IOException {
        return C1505i.m1425a(jsonReader, lottieComposition, f, uVar);
    }
}
