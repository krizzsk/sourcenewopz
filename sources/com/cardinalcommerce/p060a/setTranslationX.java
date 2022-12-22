package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setTranslationX */
public final class setTranslationX extends setX {
    private final byte[] Cardinal;
    private final byte[] CardinalError;
    private final long cca_continue;
    private final byte[] getInstance;
    private final setRotationX getSDKVersion;
    public final setTranslationY init;
    private final byte[] values;

    /* renamed from: com.cardinalcommerce.a.setTranslationX$getInstance */
    public static class getInstance {
        public byte[] Cardinal = null;
        public byte[] cca_continue = null;
        final setTranslationY configure;
        public byte[] getInstance = null;
        public setRotationX getSDKVersion = null;
        public long init = 0;
        public byte[] values = null;

        public getInstance(setTranslationY settranslationy) {
            this.configure = settranslationy;
        }
    }

    public /* synthetic */ setTranslationX(getInstance getinstance, byte b) {
        this(getinstance);
    }

    private setTranslationX(getInstance getinstance) {
        super(true, getinstance.configure.getInstance().configure());
        setTranslationY settranslationy = getinstance.configure;
        this.init = settranslationy;
        if (settranslationy != null) {
            int i = settranslationy.Cardinal.init.getInstance.getInstance;
            this.cca_continue = getinstance.init;
            byte[] cca_continue2 = getinstance.getInstance;
            if (cca_continue2 == null) {
                this.Cardinal = new byte[i];
            } else if (cca_continue2.length == i) {
                this.Cardinal = cca_continue2;
            } else {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            byte[] configure = getinstance.cca_continue;
            if (configure == null) {
                this.getInstance = new byte[i];
            } else if (configure.length == i) {
                this.getInstance = configure;
            } else {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            byte[] init2 = getinstance.Cardinal;
            if (init2 == null) {
                this.values = new byte[i];
            } else if (init2.length == i) {
                this.values = init2;
            } else {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            byte[] Cardinal2 = getinstance.values;
            if (Cardinal2 == null) {
                this.CardinalError = new byte[i];
            } else if (Cardinal2.length == i) {
                this.CardinalError = Cardinal2;
            } else {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            setRotationX setrotationx = getinstance.getSDKVersion;
            if (setrotationx != null) {
                this.getSDKVersion = setrotationx;
                return;
            }
            if (!setVerticalFadingEdgeEnabled.cca_continue(this.init.getInstance, getinstance.init) || init2 == null || cca_continue2 == null) {
                this.getSDKVersion = new setRotationX();
            } else {
                this.getSDKVersion = new setRotationX(this.init, getinstance.init, init2, cca_continue2);
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public final byte[] Cardinal() {
        int i = this.init.Cardinal.init.getInstance.getInstance;
        int i2 = (this.init.getInstance + 7) / 8;
        int i3 = i2 + i;
        int i4 = i3 + i;
        int i5 = i4 + i;
        byte[] bArr = new byte[(i + i5)];
        setVerticalFadingEdgeEnabled.cca_continue(bArr, setVerticalFadingEdgeEnabled.Cardinal(this.cca_continue, i2), 0);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.Cardinal, i2);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.getInstance, i3);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.values, i4);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.CardinalError, i5);
        try {
            return setForegroundTintBlendMode.cca_continue(bArr, setVerticalFadingEdgeEnabled.cca_continue((Object) this.getSDKVersion));
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("error serializing bds state: ");
            sb.append(e.getMessage());
            throw new IllegalStateException(sb.toString(), e);
        }
    }
}
