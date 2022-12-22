package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.setTranslationY */
public final class setTranslationY {
    public final setStateListAnimator Cardinal;

    /* renamed from: a */
    final setOutlineProvider f3073a;
    public final int configure;
    public final int getInstance;

    public setTranslationY(int i, int i2, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this.getInstance = i;
        this.configure = i2;
        if (i < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        } else if (i % i2 == 0) {
            int i3 = i / i2;
            if (i3 != 1) {
                setStateListAnimator setstatelistanimator = new setStateListAnimator(i3, mQVwithSHA256KDFAndSharedInfo);
                this.Cardinal = setstatelistanimator;
                this.f3073a = setScaleX.init(setstatelistanimator.init.getInstance.f2854a.configure(), this.Cardinal.init.getInstance.getInstance, 16, this.Cardinal.init.getInstance.f2855b, this.getInstance, i2);
                return;
            }
            throw new IllegalArgumentException("height / layers must be greater than 1");
        } else {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
    }

    /* access modifiers changed from: protected */
    public final KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getInstance() {
        return this.Cardinal.init.getInstance.f2854a;
    }
}
