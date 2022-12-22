package com.cardinalcommerce.p060a;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.common.base.Ascii;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setRequestTimeout */
public abstract class setRequestTimeout extends setLocationDataConsentGiven {
    protected final int cca_continue;
    protected final byte[] getInstance;
    protected final boolean init;

    setRequestTimeout(boolean z, int i, byte[] bArr) {
        this.init = z;
        this.cca_continue = i;
        this.getInstance = setForegroundTintBlendMode.cca_continue(bArr);
    }

    public static byte[] cca_continue(int i, byte[] bArr) throws IOException {
        int i2;
        if ((bArr[0] & Ascii.f53596US) == 31) {
            i2 = 2;
            byte b = bArr[1] & 255;
            if ((b & Byte.MAX_VALUE) != 0) {
                while ((b & 128) != 0) {
                    int i3 = i2 + 1;
                    b = bArr[i2] & 255;
                    i2 = i3;
                }
            } else {
                throw new IOException("corrupted stream - invalid high tag number found");
            }
        } else {
            i2 = 1;
        }
        int length = (bArr.length - i2) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i2, bArr2, 1, length - 1);
        bArr2[0] = 16;
        return bArr2;
    }

    public final boolean Cardinal() {
        return this.init;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof setRequestTimeout)) {
            return false;
        }
        setRequestTimeout setrequesttimeout = (setRequestTimeout) setlocationdataconsentgiven;
        return this.init == setrequesttimeout.init && this.cca_continue == setrequesttimeout.cca_continue && setForegroundTintBlendMode.Cardinal(this.getInstance, setrequesttimeout.getInstance);
    }

    public final byte[] cca_continue() {
        return setForegroundTintBlendMode.cca_continue(this.getInstance);
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        return KeyAgreementSpi.m1817a(this.cca_continue) + KeyAgreementSpi.Cardinal(this.getInstance.length) + this.getInstance.length;
    }

    public final int getInstance() {
        return this.cca_continue;
    }

    public int hashCode() {
        return (this.init ^ this.cca_continue) ^ setForegroundTintBlendMode.init(this.getInstance) ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        int i = this.init ? 96 : 64;
        int i2 = this.cca_continue;
        byte[] bArr = this.getInstance;
        setenabledfsync.cca_continue(i, i2);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Const.jaLeft);
        if (Cardinal()) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(this.cca_continue));
        stringBuffer.append(Const.jaRight);
        if (this.getInstance != null) {
            stringBuffer.append(" #");
            str = setTextDirection.cca_continue(this.getInstance);
        } else {
            str = " #null";
        }
        stringBuffer.append(str);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
}
