package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setVerticalFadingEdgeEnabled */
public final class setVerticalFadingEdgeEnabled implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public BCElGamalPublicKey getInstance;
    public BCElGamalPublicKey init;

    /* renamed from: com.cardinalcommerce.a.setVerticalFadingEdgeEnabled$getInstance */
    static class getInstance extends ObjectInputStream {
        private static final Set configure;
        private boolean Cardinal = false;
        private final Class getInstance;

        static {
            HashSet hashSet = new HashSet();
            configure = hashSet;
            hashSet.add("java.util.TreeMap");
            configure.add("java.lang.Integer");
            configure.add("java.lang.Number");
            configure.add("com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.crypto.xmss.BDS");
            configure.add("java.util.ArrayList");
            configure.add("com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.crypto.xmss.XMSSNode");
            configure.add("[B");
            configure.add("java.util.LinkedList");
            configure.add("java.util.Stack");
            configure.add("java.util.Vector");
            configure.add("[Ljava.lang.Object;");
            configure.add("com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        getInstance(Class cls, InputStream inputStream) throws IOException {
            super(inputStream);
            this.getInstance = cls;
        }

        /* access modifiers changed from: protected */
        public final Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (!this.Cardinal) {
                if (objectStreamClass.getName().equals(this.getInstance.getName())) {
                    this.Cardinal = true;
                } else {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
            } else if (!configure.contains(objectStreamClass.getName())) {
                throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    public setVerticalFadingEdgeEnabled() {
    }

    public static int Cardinal(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (((i >> i3) & 1) == 0) {
                return i3;
            }
        }
        return 0;
    }

    public static long Cardinal(byte[] bArr, int i) {
        if (bArr != null) {
            long j = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j << 8) | ((long) (bArr[i2] & 255));
            }
            return j;
        }
        throw new NullPointerException("in == null");
    }

    public static Object Cardinal(byte[] bArr, Class cls) throws IOException, ClassNotFoundException {
        getInstance getinstance = new getInstance(cls, new ByteArrayInputStream(bArr));
        Object readObject = getinstance.readObject();
        if (getinstance.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        } else if (cls.isInstance(readObject)) {
            return readObject;
        } else {
            throw new IOException("unexpected class found in ObjectInputStream");
        }
    }

    public static byte[] Cardinal(long j, int i) {
        byte[] bArr = new byte[i];
        while (true) {
            i--;
            if (i < 0) {
                return bArr;
            }
            bArr[i] = (byte) ((int) j);
            j >>>= 8;
        }
    }

    public static byte[] Cardinal(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("src == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        } else if (i + i2 <= bArr.length) {
            byte[] bArr2 = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[i3] = bArr[i + i3];
            }
            return bArr2;
        } else {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
    }

    public static byte[][] Cardinal(byte[][] bArr) {
        if (!configure(bArr)) {
            byte[][] bArr2 = new byte[bArr.length][];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = new byte[bArr[i].length];
                System.arraycopy(bArr[i], 0, bArr2[i], 0, bArr[i].length);
            }
            return bArr2;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static void cca_continue(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 == null) {
            throw new NullPointerException("src == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (bArr2.length + i <= bArr.length) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr[i + i2] = bArr2[i2];
            }
        } else {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
    }

    public static boolean cca_continue(int i, long j) {
        if (j >= 0) {
            return j < (1 << i);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static byte[] cca_continue(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] cca_continue(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        throw new NullPointerException("in == null");
    }

    public static boolean configure(long j, int i, int i2) {
        return j != 0 && (j + 1) % ((long) Math.pow((double) (1 << i), (double) i2)) == 0;
    }

    public static boolean configure(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static int getInstance(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public setVerticalFadingEdgeEnabled(BCElGamalPublicKey bCElGamalPublicKey, BCElGamalPublicKey bCElGamalPublicKey2) {
        this(bCElGamalPublicKey, bCElGamalPublicKey2, (CipherSpi.PKCS1v1_5Padding) null);
    }

    private setVerticalFadingEdgeEnabled(BCElGamalPublicKey bCElGamalPublicKey, BCElGamalPublicKey bCElGamalPublicKey2, CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding) {
        if (bCElGamalPublicKey == null) {
            throw new NullPointerException("staticPrivateKey cannot be null");
        } else if (bCElGamalPublicKey2 != null) {
            CipherSpi cipherSpi = bCElGamalPublicKey.configure;
            if (cipherSpi.equals(bCElGamalPublicKey2.configure)) {
                new CipherSpi.PKCS1v1_5Padding(cipherSpi.configure.modPow(bCElGamalPublicKey2.Cardinal, cipherSpi.Cardinal), cipherSpi);
                this.getInstance = bCElGamalPublicKey;
                this.init = bCElGamalPublicKey2;
                return;
            }
            throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
        } else {
            throw new NullPointerException("ephemeralPrivateKey cannot be null");
        }
    }
}
