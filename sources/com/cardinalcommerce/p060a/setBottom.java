package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setBottom */
public abstract class setBottom {

    /* renamed from: a */
    private final int f2702a;

    /* renamed from: c */
    final int f2703c;

    /* renamed from: d */
    final long f2704d;

    /* renamed from: e */
    final int f2705e;

    /* renamed from: com.cardinalcommerce.a.setBottom$init */
    public static abstract class C2035init<T extends C2035init> {
        int CardinalError = 0;
        int cleanup = 0;
        long getSDKVersion = 0;
        final int getWarnings;

        protected C2035init(int i) {
            this.getWarnings = i;
        }

        /* access modifiers changed from: protected */
        public final T Cardinal(int i) {
            this.CardinalError = i;
            return configure();
        }

        /* access modifiers changed from: protected */
        public abstract T configure();

        /* access modifiers changed from: protected */
        public final T getInstance(long j) {
            this.getSDKVersion = j;
            return configure();
        }

        /* access modifiers changed from: protected */
        public final T init(int i) {
            this.cleanup = i;
            return configure();
        }
    }

    protected setBottom(C2035init init) {
        this.f2703c = init.CardinalError;
        this.f2704d = init.getSDKVersion;
        this.f2702a = init.getWarnings;
        this.f2705e = init.cleanup;
    }

    /* access modifiers changed from: protected */
    public byte[] getInstance() {
        byte[] bArr = new byte[32];
        setMinimumWidth.getInstance(this.f2703c, bArr, 0);
        long j = this.f2704d;
        setMinimumWidth.getInstance((int) (j >>> 32), bArr, 4);
        setMinimumWidth.getInstance((int) j, bArr, 8);
        setMinimumWidth.getInstance(this.f2702a, bArr, 12);
        setMinimumWidth.getInstance(this.f2705e, bArr, 28);
        return bArr;
    }
}
