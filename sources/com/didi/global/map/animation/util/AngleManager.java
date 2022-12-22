package com.didi.global.map.animation.util;

import android.content.Context;
import com.didi.global.map.animation.SodaAnimEngine;

public class AngleManager {

    /* renamed from: a */
    private static final AngleManager f22836a = new AngleManager();

    /* renamed from: b */
    private int f22837b = SodaAnimEngine.DefaultAngleFrame;

    /* renamed from: c */
    private int f22838c = SodaAnimEngine.DefaultAngleFrame;

    public static AngleManager getInstant() {
        return f22836a;
    }

    public int getFromIndex() {
        return this.f22837b;
    }

    public void setFromIndex(int i) {
        this.f22837b = i;
    }

    public int getToIndex() {
        return this.f22838c;
    }

    public void setToIndex(int i) {
        this.f22838c = i;
    }

    public int[] getRotateFrames(Context context) {
        return FramesUtil.getRotateFrames(context, this.f22837b, this.f22838c);
    }

    public int[] getRunningFrames(Context context) {
        return FramesUtil.getDeliveryFrames(context, this.f22838c);
    }

    public int getRunningFrame(Context context) {
        return FramesUtil.getDeliveryFrame(context, this.f22838c);
    }

    public void destroy() {
        this.f22837b = SodaAnimEngine.DefaultAngleFrame;
        this.f22838c = SodaAnimEngine.DefaultAngleFrame;
    }
}
