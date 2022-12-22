package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;

/* renamed from: com.cardinalcommerce.a.setOnHoverListener */
public abstract class setOnHoverListener {

    /* renamed from: com.cardinalcommerce.a.setOnHoverListener$getInstance */
    public static class getInstance {
        /* access modifiers changed from: private */
        public static final getInstance Cardinal = new getInstance();

        private getInstance() {
        }
    }

    public static void Cardinal(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] instance = setOnCreateContextMenuListener.getInstance();
        int[] instance2 = setOnCreateContextMenuListener.getInstance();
        setImportantForAutofill.Cardinal(getInstance.Cardinal, bArr, 0, instance, instance2);
        setOnCreateContextMenuListener.cca_continue(instance2, instance, instance, instance2);
        setOnCreateContextMenuListener.init(instance2, instance2);
        setOnCreateContextMenuListener.getInstance(instance, instance2, instance);
        setOnCreateContextMenuListener.getInstance(instance);
        setOnCreateContextMenuListener.configure(instance, bArr2, 0);
    }

    public static boolean Cardinal(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = (i2 << 2) + 0;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            iArr[i2] = (bArr[i5 + 1] << Ascii.CAN) | (bArr[i3] & 255) | ((bArr[i4] & 255) << 8) | ((bArr[i5] & 255) << 16);
        }
        iArr[0] = iArr[0] & -8;
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        iArr[7] = iArr[7] | 1073741824;
        int[] instance = setOnCreateContextMenuListener.getInstance();
        setOnCreateContextMenuListener.Cardinal(bArr2, 0, instance);
        int[] instance2 = setOnCreateContextMenuListener.getInstance();
        setOnCreateContextMenuListener.getInstance(instance, instance2, 0);
        int[] instance3 = setOnCreateContextMenuListener.getInstance();
        instance3[0] = 1;
        int[] instance4 = setOnCreateContextMenuListener.getInstance();
        instance4[0] = 1;
        int[] instance5 = setOnCreateContextMenuListener.getInstance();
        int[] instance6 = setOnCreateContextMenuListener.getInstance();
        int[] instance7 = setOnCreateContextMenuListener.getInstance();
        int i6 = 254;
        int i7 = 1;
        while (true) {
            setOnCreateContextMenuListener.cca_continue(instance4, instance5, instance6, instance4);
            setOnCreateContextMenuListener.cca_continue(instance2, instance3, instance5, instance2);
            setOnCreateContextMenuListener.getInstance(instance6, instance2, instance6);
            setOnCreateContextMenuListener.getInstance(instance4, instance5, instance4);
            setOnCreateContextMenuListener.cca_continue(instance5, instance5);
            setOnCreateContextMenuListener.cca_continue(instance2, instance2);
            setOnCreateContextMenuListener.cca_continue(instance5, instance2, instance7);
            setOnCreateContextMenuListener.Cardinal(instance7, instance3);
            setOnCreateContextMenuListener.configure(instance3, instance2, instance3);
            setOnCreateContextMenuListener.getInstance(instance3, instance7, instance3);
            setOnCreateContextMenuListener.getInstance(instance2, instance5, instance2);
            setOnCreateContextMenuListener.cca_continue(instance6, instance4, instance4, instance5);
            setOnCreateContextMenuListener.cca_continue(instance4, instance4);
            setOnCreateContextMenuListener.cca_continue(instance5, instance5);
            setOnCreateContextMenuListener.getInstance(instance5, instance, instance5);
            i6--;
            int i8 = (iArr[i6 >>> 5] >>> (i6 & 31)) & 1;
            int i9 = i7 ^ i8;
            setOnCreateContextMenuListener.cca_continue(i9, instance2, instance4);
            setOnCreateContextMenuListener.cca_continue(i9, instance3, instance5);
            if (i6 < 3) {
                break;
            }
            i7 = i8;
        }
        for (int i10 = 0; i10 < 3; i10++) {
            int[] instance8 = setOnCreateContextMenuListener.getInstance();
            int[] instance9 = setOnCreateContextMenuListener.getInstance();
            setOnCreateContextMenuListener.cca_continue(instance2, instance3, instance8, instance9);
            setOnCreateContextMenuListener.cca_continue(instance8, instance8);
            setOnCreateContextMenuListener.cca_continue(instance9, instance9);
            setOnCreateContextMenuListener.getInstance(instance8, instance9, instance2);
            setOnCreateContextMenuListener.cca_continue(instance8, instance9, instance8);
            setOnCreateContextMenuListener.Cardinal(instance8, instance3);
            setOnCreateContextMenuListener.configure(instance3, instance9, instance3);
            setOnCreateContextMenuListener.getInstance(instance3, instance8, instance3);
        }
        setOnCreateContextMenuListener.init(instance3, instance3);
        setOnCreateContextMenuListener.getInstance(instance2, instance3, instance2);
        setOnCreateContextMenuListener.getInstance(instance2);
        setOnCreateContextMenuListener.configure(instance2, bArr3, i);
        return !setForegroundTintBlendMode.Cardinal(bArr3, i, 32);
    }
}
