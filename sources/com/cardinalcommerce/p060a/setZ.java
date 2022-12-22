package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setZ */
public final class setZ extends setX {
    private final byte[] Cardinal;
    private final byte[] cca_continue;
    public final setTranslationY getInstance;
    private final int init;

    /* renamed from: com.cardinalcommerce.a.setZ$getInstance */
    public static class getInstance {
        final setTranslationY Cardinal;
        public byte[] cca_continue = null;
        public byte[] init = null;

        public getInstance(setTranslationY settranslationy) {
            this.Cardinal = settranslationy;
        }
    }

    public /* synthetic */ setZ(getInstance getinstance, byte b) {
        this(getinstance);
    }

    public final byte[] Cardinal() {
        return setVerticalFadingEdgeEnabled.cca_continue(this.cca_continue);
    }

    public final byte[] configure() {
        return setVerticalFadingEdgeEnabled.cca_continue(this.Cardinal);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private setZ(getInstance getinstance) {
        super(false, getinstance.Cardinal.getInstance().configure());
        int i = 0;
        setTranslationY settranslationy = getinstance.Cardinal;
        this.getInstance = settranslationy;
        if (settranslationy != null) {
            int i2 = settranslationy.Cardinal.init.getInstance.getInstance;
            this.init = this.getInstance.f3073a != null ? this.getInstance.f3073a.init() : i;
            byte[] instance = getinstance.init;
            if (instance == null) {
                this.Cardinal = new byte[i2];
            } else if (instance.length == i2) {
                this.Cardinal = instance;
            } else {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            byte[] cca_continue2 = getinstance.cca_continue;
            if (cca_continue2 == null) {
                this.cca_continue = new byte[i2];
            } else if (cca_continue2.length == i2) {
                this.cca_continue = cca_continue2;
            } else {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public final byte[] init() {
        byte[] bArr;
        int i = this.getInstance.Cardinal.init.getInstance.getInstance;
        int i2 = this.init;
        int i3 = 0;
        if (i2 != 0) {
            bArr = new byte[(i + 4 + i)];
            setMinimumWidth.getInstance(i2, bArr, 0);
            i3 = 4;
        } else {
            bArr = new byte[(i + i)];
        }
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.Cardinal, i3);
        setVerticalFadingEdgeEnabled.cca_continue(bArr, this.cca_continue, i3 + i);
        return bArr;
    }
}
