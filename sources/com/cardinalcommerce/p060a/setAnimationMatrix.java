package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setAnimationMatrix */
public final class setAnimationMatrix extends setRight {
    public final setStateListAnimator Cardinal;
    private final byte[] configure;
    private final int getInstance;
    private final byte[] init;

    /* renamed from: com.cardinalcommerce.a.setAnimationMatrix$configure */
    public static class C2033configure {
        public byte[] configure = null;
        public byte[] getInstance = null;
        final setStateListAnimator init;

        public C2033configure(setStateListAnimator setstatelistanimator) {
            this.init = setstatelistanimator;
        }
    }

    public /* synthetic */ setAnimationMatrix(C2033configure configure2, byte b) {
        this(configure2);
    }

    public final byte[] Cardinal() {
        return setVerticalFadingEdgeEnabled.cca_continue(this.configure);
    }

    public final byte[] configure() {
        return setVerticalFadingEdgeEnabled.cca_continue(this.init);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private setAnimationMatrix(C2033configure configure2) {
        super(false, configure2.init.init.getInstance.f2854a.configure());
        int i = 0;
        setStateListAnimator setstatelistanimator = configure2.init;
        this.Cardinal = setstatelistanimator;
        if (setstatelistanimator != null) {
            int i2 = setstatelistanimator.init.getInstance.getInstance;
            this.getInstance = this.Cardinal.f2997a != null ? this.Cardinal.f2997a.init() : i;
            byte[] instance = configure2.getInstance;
            if (instance == null) {
                this.configure = new byte[i2];
            } else if (instance.length == i2) {
                this.configure = instance;
            } else {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            byte[] configure3 = configure2.configure;
            if (configure3 == null) {
                this.init = new byte[i2];
            } else if (configure3.length == i2) {
                this.init = configure3;
            } else {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public final byte[] init() {
        byte[] bArr;
        int i = this.Cardinal.init.getInstance.getInstance;
        int i2 = this.getInstance;
        int i3 = 0;
        if (i2 != 0) {
            bArr = new byte[(i + 4 + i)];
            setMinimumWidth.getInstance(i2, bArr, 0);
            i3 = 4;
        } else {
            bArr = new byte[(i + i)];
        }
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.configure, i3);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.init, i3 + i);
        return bArr;
    }
}
