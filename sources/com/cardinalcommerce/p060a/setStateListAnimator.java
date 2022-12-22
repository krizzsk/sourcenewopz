package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.setStateListAnimator */
public final class setStateListAnimator {
    public final int Cardinal;

    /* renamed from: a */
    final setOutlineProvider f2997a;

    /* renamed from: b */
    final int f2998b;
    public final setScaleY init;

    /* renamed from: a */
    private int m2091a() {
        int i = 2;
        while (true) {
            int i2 = this.Cardinal;
            if (i > i2) {
                throw new IllegalStateException("should never happen...");
            } else if ((i2 - i) % 2 == 0) {
                return i;
            } else {
                i++;
            }
        }
    }

    public setStateListAnimator(int i, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        if (i < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        } else if (mQVwithSHA256KDFAndSharedInfo != null) {
            this.init = new setScaleY(new setLeft(mQVwithSHA256KDFAndSharedInfo));
            this.Cardinal = i;
            this.f2998b = m2091a();
            this.f2997a = setRotationY.configure(this.init.getInstance.f2854a.configure(), this.init.getInstance.getInstance, 16, this.init.getInstance.f2855b, i);
        } else {
            throw new NullPointerException("digest == null");
        }
    }
}
