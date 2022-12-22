package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup implements ContentModel {

    /* renamed from: a */
    private final String f1468a;

    /* renamed from: b */
    private final List<ContentModel> f1469b;

    /* renamed from: c */
    private final boolean f1470c;

    public ShapeGroup(String str, List<ContentModel> list, boolean z) {
        this.f1468a = str;
        this.f1469b = list;
        this.f1470c = z;
    }

    public String getName() {
        return this.f1468a;
    }

    public List<ContentModel> getItems() {
        return this.f1469b;
    }

    public boolean isHidden() {
        return this.f1470c;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f1468a + "' Shapes: " + Arrays.toString(this.f1469b.toArray()) + '}';
    }
}
