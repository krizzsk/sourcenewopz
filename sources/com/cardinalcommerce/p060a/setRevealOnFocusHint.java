package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.didi.soda.customer.C13565R2;
import com.google.common.base.Ascii;

/* renamed from: com.cardinalcommerce.a.setRevealOnFocusHint */
public abstract class setRevealOnFocusHint {

    /* renamed from: com.cardinalcommerce.a.setRevealOnFocusHint$getInstance */
    public static class getInstance {
        /* access modifiers changed from: private */
        public static final getInstance getInstance = new getInstance();

        private getInstance() {
        }
    }

    public static boolean getInstance(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        byte[] bArr4 = bArr3;
        int i2 = i;
        int[] iArr = new int[14];
        int i3 = 0;
        for (int i4 = 0; i4 < 14; i4++) {
            int i5 = (i4 << 2) + 0;
            int i6 = i5 + 1;
            byte b = (bArr[i5] & 255) | ((bArr[i6] & 255) << 8);
            int i7 = i6 + 1;
            iArr[i4] = ((bArr[i7] & 255) << 16) | b | (bArr[i7 + 1] << Ascii.CAN);
        }
        iArr[0] = iArr[0] & -4;
        iArr[13] = iArr[13] | Integer.MIN_VALUE;
        int[] iArr2 = new int[16];
        DSASigner.dsa256.getInstance(bArr2, 0, iArr2);
        int[] iArr3 = new int[16];
        for (int i8 = 0; i8 < 16; i8++) {
            iArr3[i8 + 0] = iArr2[i8];
        }
        int[] iArr4 = new int[16];
        iArr4[0] = 1;
        int[] iArr5 = new int[16];
        iArr5[0] = 1;
        int[] iArr6 = new int[16];
        int[] iArr7 = new int[16];
        int[] iArr8 = new int[16];
        int i9 = 447;
        int i10 = 1;
        while (true) {
            for (int i11 = 0; i11 < 16; i11++) {
                iArr7[i11] = iArr5[i11] + iArr6[i11];
            }
            DSASigner.dsa256.Cardinal(iArr5, iArr6, iArr5);
            for (int i12 = 0; i12 < 16; i12++) {
                iArr6[i12] = iArr3[i12] + iArr4[i12];
            }
            DSASigner.dsa256.Cardinal(iArr3, iArr4, iArr3);
            DSASigner.dsa256.cca_continue(iArr7, iArr3, iArr7);
            DSASigner.dsa256.cca_continue(iArr5, iArr6, iArr5);
            DSASigner.dsa256.cca_continue(iArr6, iArr6);
            DSASigner.dsa256.cca_continue(iArr3, iArr3);
            DSASigner.dsa256.Cardinal(iArr6, iArr3, iArr8);
            DSASigner.dsa256.getInstance(iArr8, (int) C13565R2.styleable.RUILoopView_rui_lp_outerTextColor, iArr4);
            while (i3 < 16) {
                iArr4[i3] = iArr4[i3] + iArr3[i3];
                i3++;
            }
            DSASigner.dsa256.cca_continue(iArr4, iArr8, iArr4);
            DSASigner.dsa256.cca_continue(iArr3, iArr6, iArr3);
            DSASigner.dsa256.Cardinal(iArr7, iArr5, iArr6);
            for (int i13 = 0; i13 < 16; i13++) {
                iArr5[i13] = iArr7[i13] + iArr5[i13];
            }
            DSASigner.dsa256.cca_continue(iArr5, iArr5);
            DSASigner.dsa256.cca_continue(iArr6, iArr6);
            DSASigner.dsa256.cca_continue(iArr6, iArr2, iArr6);
            i9--;
            int i14 = (iArr[i9 >>> 5] >>> (i9 & 31)) & 1;
            int i15 = i10 ^ i14;
            DSASigner.dsa256.cca_continue(i15, iArr3, iArr5);
            DSASigner.dsa256.cca_continue(i15, iArr4, iArr6);
            if (i9 < 2) {
                break;
            }
            i10 = i14;
            i3 = 0;
        }
        for (int i16 = 0; i16 < 2; i16++) {
            int[] iArr9 = new int[16];
            int[] iArr10 = new int[16];
            for (int i17 = 0; i17 < 16; i17++) {
                iArr9[i17] = iArr3[i17] + iArr4[i17];
            }
            DSASigner.dsa256.Cardinal(iArr3, iArr4, iArr10);
            DSASigner.dsa256.cca_continue(iArr9, iArr9);
            DSASigner.dsa256.cca_continue(iArr10, iArr10);
            DSASigner.dsa256.cca_continue(iArr9, iArr10, iArr3);
            DSASigner.dsa256.Cardinal(iArr9, iArr10, iArr9);
            DSASigner.dsa256.getInstance(iArr9, (int) C13565R2.styleable.RUILoopView_rui_lp_outerTextColor, iArr4);
            for (int i18 = 0; i18 < 16; i18++) {
                iArr4[i18] = iArr4[i18] + iArr10[i18];
            }
            DSASigner.dsa256.cca_continue(iArr4, iArr9, iArr4);
        }
        DSASigner.dsa256.getInstance(iArr4, iArr4);
        DSASigner.dsa256.cca_continue(iArr3, iArr4, iArr3);
        DSASigner.dsa256.configure(iArr3, 1);
        DSASigner.dsa256.configure(iArr3, -1);
        DSASigner.dsa256.configure(iArr3, bArr4, i2);
        if (!setForegroundTintBlendMode.Cardinal(bArr4, i2, 56)) {
            return true;
        }
        return false;
    }

    public static void Cardinal(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        setAutofillId.configure(getInstance.getInstance, bArr, 0, iArr, iArr2);
        DSASigner.dsa256.getInstance(iArr, iArr);
        DSASigner.dsa256.cca_continue(iArr, iArr2, iArr);
        DSASigner.dsa256.cca_continue(iArr, iArr);
        DSASigner.dsa256.configure(iArr, 1);
        DSASigner.dsa256.configure(iArr, -1);
        DSASigner.dsa256.configure(iArr, bArr2, 0);
    }
}
