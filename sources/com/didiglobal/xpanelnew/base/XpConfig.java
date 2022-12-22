package com.didiglobal.xpanelnew.base;

import com.didiglobal.xpanelnew.omega.XPanelOmegaCallback;

public class XpConfig {

    /* renamed from: a */
    private float f51604a;

    /* renamed from: b */
    private float f51605b;

    /* renamed from: c */
    private float f51606c;

    /* renamed from: d */
    private float f51607d;

    /* renamed from: e */
    private int f51608e;

    public float getCardRoundedCornerDp() {
        return this.f51604a;
    }

    private XpConfig(Builder builder) {
        this.f51604a = builder.cardRoundedCorner;
        this.f51605b = builder.defaultFoldHeight;
        this.f51606c = builder.defaultDpSecondCardShowHeight;
        this.f51607d = builder.oneCardAndXDp;
        this.f51608e = builder.firstCardHeightWillChangeTo;
    }

    public float getDefaultDpFoldHeight() {
        return this.f51605b;
    }

    public float getDefaultDpSecondCardShowHeight() {
        return this.f51606c;
    }

    public int getFirstCardHeightWillChangeTo() {
        return this.f51608e;
    }

    public float getOneCardAndXDp() {
        return this.f51607d;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public float cardRoundedCorner = 20.0f;
        /* access modifiers changed from: private */
        public float defaultDpSecondCardShowHeight = 70.0f;
        /* access modifiers changed from: private */
        public float defaultFoldHeight = 100.0f;
        /* access modifiers changed from: private */
        public int firstCardHeightWillChangeTo = 0;
        /* access modifiers changed from: private */
        public float oneCardAndXDp = 0.0f;
        private XPanelOmegaCallback xPanelOmegaCallback;

        public Builder setRoundedCorner(float f) {
            this.cardRoundedCorner = f;
            return this;
        }

        public Builder setOneCardAndXDp(float f) {
            this.oneCardAndXDp = f;
            return this;
        }

        public Builder setFirstCardHeightWillChangeTo(int i) {
            this.firstCardHeightWillChangeTo = i;
            return this;
        }

        public XpConfig build() {
            return new XpConfig(this);
        }

        public Builder setDefaultFoldHeight(float f) {
            this.defaultFoldHeight = f;
            return this;
        }

        public Builder setDefaultDpSecondCardShowHeight(float f) {
            this.defaultDpSecondCardShowHeight = f;
            return this;
        }
    }
}
