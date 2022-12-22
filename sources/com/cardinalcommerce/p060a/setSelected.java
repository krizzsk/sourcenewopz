package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.setSelected */
public final class setSelected {

    /* renamed from: a */
    private static final BigInteger f2988a = BigInteger.valueOf(2);

    /* renamed from: b */
    private static final BigInteger f2989b = BigInteger.valueOf(3);

    /* renamed from: c */
    private static final BigInteger f2990c = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);

    /* renamed from: d */
    private static final int f2991d = BigInteger.valueOf(743).bitLength();
    public static final BigInteger getInstance = BigInteger.valueOf(0);
    public static final BigInteger init = BigInteger.valueOf(1);

    public static byte[] Cardinal(int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i) {
            return byteArray;
        }
        int i2 = 0;
        if (byteArray[0] == 0) {
            i2 = 1;
        }
        int length = byteArray.length - i2;
        if (length <= i) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, i2, bArr, i - length, length);
            return bArr;
        }
        throw new IllegalArgumentException("standard length exceeded for value");
    }

    /* renamed from: a */
    private static byte[] m2090a(int i, SecureRandom secureRandom) throws IllegalArgumentException {
        if (i > 0) {
            int i2 = (i + 7) / 8;
            byte[] bArr = new byte[i2];
            secureRandom.nextBytes(bArr);
            bArr[0] = (byte) (((byte) (255 >>> ((i2 << 3) - i))) & bArr[0]);
            return bArr;
        }
        throw new IllegalArgumentException("bitLength must be at least 1");
    }

    public static BigInteger cca_continue(byte[] bArr, int i, int i2) {
        if (!(i == 0 && i2 == bArr.length)) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        return new BigInteger(1, bArr);
    }

    public static byte[] cca_continue(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    public static BigInteger configure(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigInteger;
        if (i < 2) {
            throw new IllegalArgumentException("bitLength < 2");
        } else if (i == 2) {
            return secureRandom.nextInt() < 0 ? f2988a : f2989b;
        } else {
            do {
                byte[] a = m2090a(i, secureRandom);
                a[0] = (byte) (((byte) (1 << (7 - ((a.length * 8) - i)))) | a[0]);
                int length = a.length - 1;
                a[length] = (byte) (a[length] | 1);
                bigInteger = new BigInteger(1, a);
                if (i > f2991d) {
                    while (!bigInteger.gcd(f2990c).equals(init)) {
                        bigInteger = bigInteger.add(f2988a);
                    }
                }
            } while (!bigInteger.isProbablePrime(i2));
            return bigInteger;
        }
    }

    public static BigInteger configure(int i, SecureRandom secureRandom) {
        return new BigInteger(1, m2090a(i, secureRandom));
    }

    public static int init(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) / 8;
    }

    public static BigInteger init(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        int compareTo = bigInteger.compareTo(bigInteger2);
        if (compareTo >= 0) {
            if (compareTo <= 0) {
                return bigInteger;
            }
            throw new IllegalArgumentException("'min' may not be greater than 'max'");
        } else if (bigInteger.bitLength() > bigInteger2.bitLength() / 2) {
            return init(getInstance, bigInteger2.subtract(bigInteger), secureRandom).add(bigInteger);
        } else {
            for (int i = 0; i < 1000; i++) {
                BigInteger bigInteger3 = new BigInteger(1, m2090a(bigInteger2.bitLength(), secureRandom));
                if (bigInteger3.compareTo(bigInteger) >= 0 && bigInteger3.compareTo(bigInteger2) <= 0) {
                    return bigInteger3;
                }
            }
            return new BigInteger(1, m2090a(bigInteger2.subtract(bigInteger).bitLength() - 1, secureRandom)).add(bigInteger);
        }
    }
}
