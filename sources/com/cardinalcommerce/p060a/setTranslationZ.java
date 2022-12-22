package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setTransitionAlpha;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setTranslationZ */
public final class setTranslationZ extends setRight {
    private final byte[] Cardinal;
    private final setTouchDelegate cleanup;
    public final setStateListAnimator configure;
    private final byte[] getInstance;
    private final byte[] init;
    private final byte[] values;

    /* renamed from: com.cardinalcommerce.a.setTranslationZ$getInstance */
    public static class getInstance {
        public byte[] Cardinal = null;
        public byte[] cca_continue = null;
        public setTouchDelegate cleanup = null;
        public int configure = 0;
        public byte[] getInstance = null;
        public byte[] getWarnings = null;
        final setStateListAnimator init;

        public getInstance(setStateListAnimator setstatelistanimator) {
            this.init = setstatelistanimator;
        }
    }

    public /* synthetic */ setTranslationZ(getInstance getinstance, byte b) {
        this(getinstance);
    }

    private setTranslationZ(getInstance getinstance) {
        super(true, getinstance.init.init.getInstance.f2854a.configure());
        setStateListAnimator setstatelistanimator = getinstance.init;
        this.configure = setstatelistanimator;
        if (setstatelistanimator != null) {
            int i = setstatelistanimator.init.getInstance.getInstance;
            byte[] configure2 = getinstance.Cardinal;
            if (configure2 == null) {
                this.getInstance = new byte[i];
            } else if (configure2.length == i) {
                this.getInstance = configure2;
            } else {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            byte[] init2 = getinstance.cca_continue;
            if (init2 == null) {
                this.Cardinal = new byte[i];
            } else if (init2.length == i) {
                this.Cardinal = init2;
            } else {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            byte[] cca_continue = getinstance.getInstance;
            if (cca_continue == null) {
                this.init = new byte[i];
            } else if (cca_continue.length == i) {
                this.init = cca_continue;
            } else {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            byte[] instance = getinstance.getWarnings;
            if (instance == null) {
                this.values = new byte[i];
            } else if (instance.length == i) {
                this.values = instance;
            } else {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            setTouchDelegate settouchdelegate = getinstance.cleanup;
            if (settouchdelegate != null) {
                this.cleanup = settouchdelegate;
            } else if (getinstance.configure >= (1 << this.configure.Cardinal) - 2 || cca_continue == null || configure2 == null) {
                this.cleanup = new setTouchDelegate(this.configure, getinstance.configure);
            } else {
                this.cleanup = new setTouchDelegate(this.configure, cca_continue, configure2, new setTransitionAlpha(new setTransitionAlpha.cca_continue(), (byte) 0), getinstance.configure);
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public final byte[] Cardinal() {
        int i = this.configure.init.getInstance.getInstance;
        int i2 = i + 4;
        int i3 = i2 + i;
        int i4 = i3 + i;
        byte[] bArr = new byte[(i + i4)];
        setMinimumWidth.getInstance(this.cleanup.configure, bArr, 0);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.getInstance, 4);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.Cardinal, i2);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.init, i3);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.values, i4);
        try {
            return setForegroundTintBlendMode.cca_continue(bArr, setVerticalFadingEdgeEnabled.cca_continue((Object) this.cleanup));
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("error serializing bds state: ");
            sb.append(e.getMessage());
            throw new RuntimeException(sb.toString());
        }
    }
}
