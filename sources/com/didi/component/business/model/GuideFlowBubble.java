package com.didi.component.business.model;

import com.didi.global.globalgenerickit.model.ComponentConfigBubbleModel;

public class GuideFlowBubble {
    public String bubbleId;
    public int carLevel;
    public int comboType;
    public ComponentConfigBubbleModel componentConfigBubbleModel;
    public String icon;
    public int index;
    public int productId;
    public int size;
    public String subTitle;
    public String title;
    public String traceId;
    public int width;

    /* renamed from: x */
    public int f11320x;

    /* renamed from: y */
    public int f11321y;

    public GuideFlowBubble(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3) {
        this.f11320x = i;
        this.f11321y = i2;
        this.width = i3;
        this.index = i4;
        this.size = i5;
        this.title = str;
        this.subTitle = str2;
        this.icon = str3;
    }
}
