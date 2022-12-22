package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setBottom;

/* renamed from: com.cardinalcommerce.a.setTransitionAlpha */
final class setTransitionAlpha extends setBottom {

    /* renamed from: a */
    final int f3068a;

    /* renamed from: b */
    final int f3069b;

    /* renamed from: f */
    final int f3070f;

    /* renamed from: com.cardinalcommerce.a.setTransitionAlpha$cca_continue */
    public static class cca_continue extends setBottom.C2035init<cca_continue> {
        int cca_continue = 0;
        int configure = 0;
        int init = 0;

        protected cca_continue() {
            super(0);
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ setBottom.C2035init configure() {
            return this;
        }
    }

    /* synthetic */ setTransitionAlpha(cca_continue cca_continue2, byte b) {
        this(cca_continue2);
    }

    /* access modifiers changed from: protected */
    public final byte[] getInstance() {
        byte[] instance = super.getInstance();
        setMinimumWidth.getInstance(this.f3068a, instance, 16);
        setMinimumWidth.getInstance(this.f3069b, instance, 20);
        setMinimumWidth.getInstance(this.f3070f, instance, 24);
        return instance;
    }

    private setTransitionAlpha(cca_continue cca_continue2) {
        super(cca_continue2);
        this.f3068a = cca_continue2.cca_continue;
        this.f3069b = cca_continue2.configure;
        this.f3070f = cca_continue2.init;
    }
}
