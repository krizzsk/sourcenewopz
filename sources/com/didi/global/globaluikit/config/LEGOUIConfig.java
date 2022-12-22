package com.didi.global.globaluikit.config;

import android.graphics.Rect;

public class LEGOUIConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f22368a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f22369b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Rect f22370c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f22371d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f22372e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f22373f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f22374g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f22375h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Rect f22376i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Rect f22377j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f22378k;

    public int getDrawerTitleTextSize() {
        return this.f22368a;
    }

    public int getDrawerContentTextSize() {
        return this.f22369b;
    }

    public Rect getDrawerOutMargin() {
        return this.f22370c;
    }

    public int getDrawerCornerRadius() {
        return this.f22371d;
    }

    public int getDrawerBgColor() {
        return this.f22372e;
    }

    public float getDrawerBgAlpha() {
        return this.f22373f;
    }

    public int getDrawerBtnRes() {
        return this.f22378k;
    }

    public int getDrawerHoriBtnInterval() {
        return this.f22374g;
    }

    public Rect getHoriBtnLayoutOutMargin() {
        return this.f22376i;
    }

    public Rect getVertiBtnLayoutOutMargin() {
        return this.f22377j;
    }

    public int getDrawerVertiBtnInterval() {
        return this.f22375h;
    }

    public static class Builder {
        private final LEGOUIConfig config = new LEGOUIConfig();

        public LEGOUIConfig build() {
            return this.config;
        }

        public Builder setDrawerTitleTextSize(int i) {
            int unused = this.config.f22368a = i;
            return this;
        }

        public Builder setDrawerContentTextSize(int i) {
            int unused = this.config.f22369b = i;
            return this;
        }

        public Builder setDrawerOutMargin(Rect rect) {
            Rect unused = this.config.f22370c = rect;
            return this;
        }

        public Builder setHoriBtnLayoutOutMargin(Rect rect) {
            Rect unused = this.config.f22376i = rect;
            return this;
        }

        public Builder setVertiBtnLayoutOutMargin(Rect rect) {
            Rect unused = this.config.f22377j = rect;
            return this;
        }

        public Builder setDrawerCornerRadius(int i) {
            int unused = this.config.f22371d = i;
            return this;
        }

        public Builder setDrawerBgColor(int i) {
            int unused = this.config.f22372e = i;
            return this;
        }

        public Builder setDrawerBgAlpha(float f) {
            float unused = this.config.f22373f = f;
            return this;
        }

        public Builder setDrawerBtnRes(int i) {
            int unused = this.config.f22378k = i;
            return this;
        }

        public Builder setDrawerHoriBtnInterval(int i) {
            int unused = this.config.f22374g = i;
            return this;
        }

        public Builder setDrawerVertiBtnInterval(int i) {
            int unused = this.config.f22375h = i;
            return this;
        }
    }
}
