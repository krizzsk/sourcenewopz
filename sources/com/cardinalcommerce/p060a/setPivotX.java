package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setBottom;

/* renamed from: com.cardinalcommerce.a.setPivotX */
final class setPivotX extends setBottom {

    /* renamed from: a */
    final int f2919a;

    /* renamed from: b */
    final int f2920b;

    /* renamed from: f */
    final int f2921f;

    /* renamed from: com.cardinalcommerce.a.setPivotX$Cardinal */
    public static class Cardinal extends setBottom.C2035init<Cardinal> {
        int Cardinal = 0;
        int cca_continue = 0;
        int getInstance = 0;

        protected Cardinal() {
            super(1);
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ setBottom.C2035init configure() {
            return this;
        }
    }

    /* synthetic */ setPivotX(Cardinal cardinal, byte b) {
        this(cardinal);
    }

    /* access modifiers changed from: protected */
    public final byte[] getInstance() {
        byte[] instance = super.getInstance();
        setMinimumWidth.getInstance(this.f2919a, instance, 16);
        setMinimumWidth.getInstance(this.f2920b, instance, 20);
        setMinimumWidth.getInstance(this.f2921f, instance, 24);
        return instance;
    }

    private setPivotX(Cardinal cardinal) {
        super(cardinal);
        this.f2919a = cardinal.getInstance;
        this.f2920b = cardinal.Cardinal;
        this.f2921f = cardinal.cca_continue;
    }
}
