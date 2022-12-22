package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setBottom;

/* renamed from: com.cardinalcommerce.a.setAlpha */
final class setAlpha extends setBottom {

    /* renamed from: a */
    final int f2667a;

    /* renamed from: b */
    final int f2668b;

    /* renamed from: com.cardinalcommerce.a.setAlpha$getInstance */
    public static class getInstance extends setBottom.C2035init<getInstance> {
        int cca_continue = 0;
        int getInstance = 0;

        protected getInstance() {
            super(2);
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ setBottom.C2035init configure() {
            return this;
        }
    }

    /* synthetic */ setAlpha(getInstance getinstance, byte b) {
        this(getinstance);
    }

    /* access modifiers changed from: protected */
    public final byte[] getInstance() {
        byte[] instance = super.getInstance();
        setMinimumWidth.getInstance(0, instance, 16);
        setMinimumWidth.getInstance(this.f2667a, instance, 20);
        setMinimumWidth.getInstance(this.f2668b, instance, 24);
        return instance;
    }

    private setAlpha(getInstance getinstance) {
        super(getinstance);
        this.f2667a = getinstance.getInstance;
        this.f2668b = getinstance.cca_continue;
    }
}
