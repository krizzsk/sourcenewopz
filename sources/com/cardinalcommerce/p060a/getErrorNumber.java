package com.cardinalcommerce.p060a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/* renamed from: com.cardinalcommerce.a.getErrorNumber */
public final class getErrorNumber extends isEnableDFSync {

    /* renamed from: a */
    final isEnableDFSync[] f2560a;

    /* renamed from: c */
    private final int f2561c;

    public getErrorNumber(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private getErrorNumber(byte[] bArr, byte b) {
        this(bArr, (isEnableDFSync[]) null, 1000);
    }

    private getErrorNumber(byte[] bArr, isEnableDFSync[] isenabledfsyncArr, int i) {
        super(bArr);
        this.f2560a = isenabledfsyncArr;
        this.f2561c = 1000;
    }

    public getErrorNumber(isEnableDFSync[] isenabledfsyncArr) {
        this(isenabledfsyncArr, (byte) 0);
    }

    private getErrorNumber(isEnableDFSync[] isenabledfsyncArr, byte b) {
        this(m1894a(isenabledfsyncArr), isenabledfsyncArr, 1000);
    }

    /* renamed from: a */
    private static byte[] m1894a(isEnableDFSync[] isenabledfsyncArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i != isenabledfsyncArr.length) {
            try {
                byteArrayOutputStream.write(isenabledfsyncArr[i].cca_continue());
                i++;
            } catch (ClassCastException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append(isenabledfsyncArr[i].getClass().getName());
                sb.append(" found in input should only contain DEROctetString");
                throw new IllegalArgumentException(sb.toString());
            } catch (IOException e) {
                StringBuilder sb2 = new StringBuilder("exception converting octets ");
                sb2.append(e.toString());
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return true;
    }

    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setenabledfsync.configure(36);
        setenabledfsync.configure(128);
        Enumeration CardinalError = CardinalError();
        while (CardinalError.hasMoreElements()) {
            setenabledfsync.init((getProxyAddress) CardinalError.nextElement());
        }
        setenabledfsync.configure(0);
        setenabledfsync.configure(0);
    }

    public final byte[] cca_continue() {
        return this.f2597b;
    }

    /* access modifiers changed from: package-private */
    public final int configure() throws IOException {
        Enumeration CardinalError = CardinalError();
        int i = 0;
        while (CardinalError.hasMoreElements()) {
            i += ((getProxyAddress) CardinalError.nextElement()).values().configure();
        }
        return i + 2 + 2;
    }

    public final Enumeration CardinalError() {
        if (this.f2560a != null) {
            return new Enumeration() {
                private int Cardinal = 0;

                public final boolean hasMoreElements() {
                    return this.Cardinal < getErrorNumber.this.f2560a.length;
                }

                public final Object nextElement() {
                    isEnableDFSync[] isenabledfsyncArr = getErrorNumber.this.f2560a;
                    int i = this.Cardinal;
                    this.Cardinal = i + 1;
                    return isenabledfsyncArr[i];
                }
            };
        }
        Vector vector = new Vector();
        int i = 0;
        while (i < this.f2597b.length) {
            int length = (this.f2561c + i > this.f2597b.length ? this.f2597b.length : this.f2561c + i) - i;
            byte[] bArr = new byte[length];
            System.arraycopy(this.f2597b, i, bArr, 0, length);
            vector.addElement(new EdEC(bArr));
            i += this.f2561c;
        }
        return vector.elements();
    }
}
