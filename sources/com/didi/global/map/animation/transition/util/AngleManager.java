package com.didi.global.map.animation.transition.util;

import android.content.Context;
import com.didi.global.map.animation.transition.SodaAnimEngine;

public class AngleManager {

    /* renamed from: a */
    private static final AngleManager f22815a = new AngleManager();

    /* renamed from: b */
    private int f22816b = SodaAnimEngine.DefaultAngleFrame;

    /* renamed from: c */
    private int f22817c = SodaAnimEngine.DefaultAngleFrame;

    public static AngleManager getInstant() {
        return f22815a;
    }

    public int getFromIndex() {
        return this.f22816b;
    }

    public void setFromIndex(int i) {
        this.f22816b = i;
    }

    public int getToIndex() {
        return this.f22817c;
    }

    public void setToIndex(int i) {
        this.f22817c = i;
    }

    public int[] getRotateFrames(Context context) {
        return FramesUtil.getRotateFrames(context, this.f22816b, this.f22817c);
    }

    public int[] getRunningFrames(Context context) {
        return FramesUtil.getDeliveryFrames(context, this.f22817c);
    }

    public int getRunningFrame(Context context) {
        return FramesUtil.getDeliveryFrame(context, this.f22817c);
    }

    public void destroy() {
        this.f22816b = SodaAnimEngine.DefaultAngleFrame;
        this.f22817c = SodaAnimEngine.DefaultAngleFrame;
    }
}
