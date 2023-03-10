package com.didi.soda.home.topgun.widget;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/ShopImageWHRatioType;", "", "value", "", "(Ljava/lang/String;IF)V", "getValue", "()F", "RATIO_4X3", "RATIO_1X1", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBusinessItemNewView.kt */
public enum ShopImageWHRatioType {
    RATIO_4X3(1.329114f),
    RATIO_1X1(1.0f);
    
    private final float value;

    private ShopImageWHRatioType(float f) {
        this.value = f;
    }

    public final float getValue() {
        return this.value;
    }
}
