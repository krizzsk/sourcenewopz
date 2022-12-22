package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.X509;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.cardinalcommerce.a.setEnableDFSync */
public class setEnableDFSync {
    public OutputStream getInstance;

    /* renamed from: com.cardinalcommerce.a.setEnableDFSync$Cardinal */
    class Cardinal extends setEnableDFSync {
        private boolean configure = true;

        public Cardinal(OutputStream outputStream) {
            super(outputStream);
        }

        public final void configure(int i) throws IOException {
            if (this.configure) {
                this.configure = false;
            } else {
                setEnableDFSync.super.configure(i);
            }
        }
    }

    public setEnableDFSync(OutputStream outputStream) {
        this.getInstance = outputStream;
    }

    /* access modifiers changed from: package-private */
    public setEnableDFSync Cardinal() {
        return new ElGamal(this.getInstance);
    }

    public final void Cardinal(int i) throws IOException {
        if (i > 127) {
            int i2 = i;
            int i3 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i3++;
            }
            configure((byte) (i3 | 128));
            for (int i4 = (i3 - 1) << 3; i4 >= 0; i4 -= 8) {
                configure((byte) (i >> i4));
            }
            return;
        }
        configure((byte) i);
    }

    public void configure(int i) throws IOException {
        this.getInstance.write(i);
    }

    /* access modifiers changed from: package-private */
    public setEnableDFSync init() {
        return new X509.Mappings(this.getInstance);
    }

    public void init(getProxyAddress getproxyaddress) throws IOException {
        if (getproxyaddress != null) {
            getproxyaddress.values().cca_continue(this);
            return;
        }
        throw new IOException("null object detected");
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(int i, int i2) throws IOException {
        if (i2 < 31) {
            configure(i | i2);
            return;
        }
        configure(i | 31);
        if (i2 < 128) {
            configure(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int i3 = 4;
        bArr[4] = (byte) (i2 & 127);
        do {
            i2 >>= 7;
            i3--;
            bArr[i3] = (byte) ((i2 & 127) | 128);
        } while (i2 > 127);
        this.getInstance.write(bArr, i3, 5 - i3);
    }

    /* access modifiers changed from: package-private */
    public final void getInstance(int i, int i2, byte[] bArr) throws IOException {
        cca_continue(32, 8);
        Cardinal(bArr.length);
        this.getInstance.write(bArr);
    }
}
