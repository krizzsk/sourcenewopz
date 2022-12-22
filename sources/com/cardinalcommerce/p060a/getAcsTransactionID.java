package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.util.Random;

/* renamed from: com.cardinalcommerce.a.getAcsTransactionID */
public abstract class getAcsTransactionID implements getSDKReferenceNumber {

    /* renamed from: com.cardinalcommerce.a.getAcsTransactionID$configure */
    public static abstract class C1997configure extends getAcsTransactionID {
    }

    /* renamed from: com.cardinalcommerce.a.getAcsTransactionID$getInstance */
    public static abstract class getInstance extends getAcsTransactionID {
        public int CardinalRenderType() {
            int cca_continue = cca_continue();
            getAcsTransactionID getacstransactionid = this;
            getAcsTransactionID getacstransactionid2 = getacstransactionid;
            for (int i = 1; i < cca_continue; i++) {
                getacstransactionid2 = getacstransactionid2.configure();
                getacstransactionid = getacstransactionid.cca_continue(getacstransactionid2);
            }
            if (getacstransactionid.cleanup()) {
                return 0;
            }
            if (getacstransactionid.CardinalError()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public abstract getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid);

    public getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return init(getacstransactionid).cca_continue(getacstransactionid2.init(getacstransactionid3));
    }

    public abstract BigInteger Cardinal();

    public boolean CardinalActionCode() {
        return Cardinal().testBit(0);
    }

    public final byte[] CardinalEnvironment() {
        return setSelected.Cardinal((cca_continue() + 7) / 8, Cardinal());
    }

    public boolean CardinalError() {
        return getWarnings() == 1;
    }

    public abstract int cca_continue();

    public abstract getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid);

    public getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        return configure().cca_continue(getacstransactionid.init(getacstransactionid2));
    }

    public boolean cleanup() {
        return Cardinal().signum() == 0;
    }

    public abstract getAcsTransactionID configure();

    public abstract getAcsTransactionID getInstance();

    public getAcsTransactionID getInstance(int i) {
        getAcsTransactionID getacstransactionid = this;
        for (int i2 = 0; i2 < i; i2++) {
            getacstransactionid = getacstransactionid.configure();
        }
        return getacstransactionid;
    }

    public abstract getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid);

    public abstract getAcsTransactionID getSDKVersion();

    public int getWarnings() {
        return Cardinal().bitLength();
    }

    public abstract getAcsTransactionID init();

    public abstract getAcsTransactionID init(getAcsTransactionID getacstransactionid);

    public getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return init(getacstransactionid).Cardinal(getacstransactionid2.init(getacstransactionid3));
    }

    public String toString() {
        return Cardinal().toString(16);
    }

    public abstract getAcsTransactionID values();

    /* renamed from: com.cardinalcommerce.a.getAcsTransactionID$Cardinal */
    public static class Cardinal extends C1997configure {
        private BigInteger Cardinal;
        private BigInteger cca_continue;
        private BigInteger configure;

        Cardinal(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.Cardinal = bigInteger;
            this.cca_continue = bigInteger2;
            this.configure = bigInteger3;
        }

        private BigInteger Cardinal(BigInteger bigInteger) {
            if (this.cca_continue == null) {
                return bigInteger.mod(this.Cardinal);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.Cardinal.bitLength();
            boolean equals = this.cca_continue.equals(getSDKReferenceNumber.values);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.cca_continue);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.Cardinal) >= 0) {
                bigInteger = bigInteger.subtract(this.Cardinal);
            }
            return (!z || bigInteger.signum() == 0) ? bigInteger : this.Cardinal.subtract(bigInteger);
        }

        private BigInteger Cardinal(BigInteger bigInteger, BigInteger bigInteger2) {
            return Cardinal(bigInteger.multiply(bigInteger2));
        }

        static BigInteger getInstance(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return values.shiftLeft(bitLength).subtract(bigInteger);
        }

        public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
            BigInteger bigInteger = this.configure;
            BigInteger Cardinal2 = getacstransactionid.Cardinal();
            BigInteger Cardinal3 = getacstransactionid2.Cardinal();
            BigInteger Cardinal4 = getacstransactionid3.Cardinal();
            return new Cardinal(this.Cardinal, this.cca_continue, Cardinal(bigInteger.multiply(Cardinal2).add(Cardinal3.multiply(Cardinal4))));
        }

        public final BigInteger Cardinal() {
            return this.configure;
        }

        public final int cca_continue() {
            return this.Cardinal.bitLength();
        }

        public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
            BigInteger bigInteger = this.configure;
            BigInteger Cardinal2 = getacstransactionid.Cardinal();
            BigInteger Cardinal3 = getacstransactionid2.Cardinal();
            return new Cardinal(this.Cardinal, this.cca_continue, Cardinal(bigInteger.multiply(bigInteger).add(Cardinal2.multiply(Cardinal3))));
        }

        public final getAcsTransactionID configure() {
            BigInteger bigInteger = this.Cardinal;
            BigInteger bigInteger2 = this.cca_continue;
            BigInteger bigInteger3 = this.configure;
            return new Cardinal(bigInteger, bigInteger2, Cardinal(bigInteger3, bigInteger3));
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Cardinal)) {
                return false;
            }
            Cardinal cardinal = (Cardinal) obj;
            return this.Cardinal.equals(cardinal.Cardinal) && this.configure.equals(cardinal.configure);
        }

        public final getAcsTransactionID getInstance() {
            if (this.configure.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.Cardinal;
            return new Cardinal(bigInteger, this.cca_continue, bigInteger.subtract(this.configure));
        }

        public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
            return new Cardinal(this.Cardinal, this.cca_continue, Cardinal(this.configure, cca_continue(getacstransactionid.Cardinal())));
        }

        public final getAcsTransactionID getSDKVersion() {
            return new Cardinal(this.Cardinal, this.cca_continue, cca_continue(this.configure));
        }

        public final int hashCode() {
            return this.Cardinal.hashCode() ^ this.configure.hashCode();
        }

        public final getAcsTransactionID init() {
            BigInteger add = this.configure.add(getSDKReferenceNumber.values);
            if (add.compareTo(this.Cardinal) == 0) {
                add = getSDKReferenceNumber.CardinalError;
            }
            return new Cardinal(this.Cardinal, this.cca_continue, add);
        }

        public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
            return new Cardinal(this.Cardinal, this.cca_continue, Cardinal(this.configure, getacstransactionid.Cardinal()));
        }

        public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
            BigInteger bigInteger = this.configure;
            BigInteger Cardinal2 = getacstransactionid.Cardinal();
            BigInteger Cardinal3 = getacstransactionid2.Cardinal();
            BigInteger Cardinal4 = getacstransactionid3.Cardinal();
            return new Cardinal(this.Cardinal, this.cca_continue, Cardinal(bigInteger.multiply(Cardinal2).subtract(Cardinal3.multiply(Cardinal4))));
        }

        public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
            BigInteger bigInteger = this.Cardinal;
            BigInteger bigInteger2 = this.cca_continue;
            BigInteger add = this.configure.add(getacstransactionid.Cardinal());
            if (add.compareTo(this.Cardinal) >= 0) {
                add = add.subtract(this.Cardinal);
            }
            return new Cardinal(bigInteger, bigInteger2, add);
        }

        public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
            BigInteger bigInteger = this.Cardinal;
            BigInteger bigInteger2 = this.cca_continue;
            BigInteger subtract = this.configure.subtract(getacstransactionid.Cardinal());
            if (subtract.signum() < 0) {
                subtract = subtract.add(this.Cardinal);
            }
            return new Cardinal(bigInteger, bigInteger2, subtract);
        }

        public final getAcsTransactionID values() {
            if (cleanup() || CardinalError()) {
                return this;
            }
            if (!this.Cardinal.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.Cardinal.testBit(1)) {
                BigInteger add = this.Cardinal.shiftRight(2).add(getSDKReferenceNumber.values);
                BigInteger bigInteger = this.Cardinal;
                Cardinal cardinal = new Cardinal(bigInteger, this.cca_continue, this.configure.modPow(add, bigInteger));
                if (cardinal.configure().equals(this)) {
                    return cardinal;
                }
                return null;
            } else if (this.Cardinal.testBit(2)) {
                BigInteger modPow = this.configure.modPow(this.Cardinal.shiftRight(3), this.Cardinal);
                BigInteger Cardinal2 = Cardinal(modPow, this.configure);
                if (Cardinal(Cardinal2, modPow).equals(getSDKReferenceNumber.values)) {
                    Cardinal cardinal2 = new Cardinal(this.Cardinal, this.cca_continue, Cardinal2);
                    if (cardinal2.configure().equals(this)) {
                        return cardinal2;
                    }
                    return null;
                }
                Cardinal cardinal3 = new Cardinal(this.Cardinal, this.cca_continue, Cardinal(Cardinal2, getSDKReferenceNumber.CardinalEnvironment.modPow(this.Cardinal.shiftRight(2), this.Cardinal)));
                if (cardinal3.configure().equals(this)) {
                    return cardinal3;
                }
                return null;
            } else {
                BigInteger shiftRight = this.Cardinal.shiftRight(1);
                if (!this.configure.modPow(shiftRight, this.Cardinal).equals(getSDKReferenceNumber.values)) {
                    return null;
                }
                BigInteger bigInteger2 = this.configure;
                BigInteger shiftLeft = bigInteger2.shiftLeft(1);
                if (shiftLeft.compareTo(this.Cardinal) >= 0) {
                    shiftLeft = shiftLeft.subtract(this.Cardinal);
                }
                BigInteger shiftLeft2 = shiftLeft.shiftLeft(1);
                if (shiftLeft2.compareTo(this.Cardinal) >= 0) {
                    shiftLeft2 = shiftLeft2.subtract(this.Cardinal);
                }
                BigInteger add2 = shiftRight.add(getSDKReferenceNumber.values);
                BigInteger subtract = this.Cardinal.subtract(getSDKReferenceNumber.values);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger3 = new BigInteger(this.Cardinal.bitLength(), random);
                    if (bigInteger3.compareTo(this.Cardinal) < 0 && Cardinal(bigInteger3.multiply(bigInteger3).subtract(shiftLeft2)).modPow(shiftRight, this.Cardinal).equals(subtract)) {
                        BigInteger[] configure2 = configure(bigInteger3, bigInteger2, add2);
                        BigInteger bigInteger4 = configure2[0];
                        BigInteger bigInteger5 = configure2[1];
                        if (Cardinal(bigInteger5, bigInteger5).equals(shiftLeft2)) {
                            BigInteger bigInteger6 = this.Cardinal;
                            BigInteger bigInteger7 = this.cca_continue;
                            if (bigInteger5.testBit(0)) {
                                bigInteger5 = this.Cardinal.subtract(bigInteger5);
                            }
                            return new Cardinal(bigInteger6, bigInteger7, bigInteger5.shiftRight(1));
                        } else if (!bigInteger4.equals(getSDKReferenceNumber.values) && !bigInteger4.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        private BigInteger[] configure(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = getSDKReferenceNumber.values;
            BigInteger bigInteger5 = getSDKReferenceNumber.CardinalEnvironment;
            BigInteger bigInteger6 = getSDKReferenceNumber.values;
            BigInteger bigInteger7 = getSDKReferenceNumber.values;
            BigInteger bigInteger8 = bigInteger;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger6 = Cardinal(bigInteger6.multiply(bigInteger7));
                if (bigInteger3.testBit(i)) {
                    bigInteger7 = Cardinal(bigInteger6.multiply(bigInteger2));
                    bigInteger4 = Cardinal(bigInteger4.multiply(bigInteger8));
                    bigInteger5 = Cardinal(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger6)));
                    bigInteger8 = Cardinal(bigInteger8.multiply(bigInteger8).subtract(bigInteger7.shiftLeft(1)));
                } else {
                    bigInteger4 = Cardinal(bigInteger4.multiply(bigInteger5).subtract(bigInteger6));
                    BigInteger Cardinal2 = Cardinal(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger6)));
                    bigInteger5 = Cardinal(bigInteger5.multiply(bigInteger5).subtract(bigInteger6.shiftLeft(1)));
                    bigInteger8 = Cardinal2;
                    bigInteger7 = bigInteger6;
                }
            }
            BigInteger Cardinal3 = Cardinal(bigInteger6.multiply(bigInteger7));
            BigInteger Cardinal4 = Cardinal(Cardinal3.multiply(bigInteger2));
            BigInteger Cardinal5 = Cardinal(bigInteger4.multiply(bigInteger5).subtract(Cardinal3));
            BigInteger Cardinal6 = Cardinal(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(Cardinal3)));
            BigInteger Cardinal7 = Cardinal(Cardinal3.multiply(Cardinal4));
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                Cardinal5 = Cardinal(Cardinal5.multiply(Cardinal6));
                Cardinal6 = Cardinal(Cardinal6.multiply(Cardinal6).subtract(Cardinal7.shiftLeft(1)));
                Cardinal7 = Cardinal(Cardinal7.multiply(Cardinal7));
            }
            return new BigInteger[]{Cardinal5, Cardinal6};
        }

        private BigInteger cca_continue(BigInteger bigInteger) {
            int bitLength = this.Cardinal.bitLength();
            int i = (bitLength + 31) >> 5;
            int[] cca_continue2 = setDrawingCacheQuality.cca_continue(bitLength, this.Cardinal);
            int[] cca_continue3 = setDrawingCacheQuality.cca_continue(bitLength, bigInteger);
            int[] iArr = new int[i];
            setAccessibilityTraversalAfter.getInstance(cca_continue2, cca_continue3, iArr);
            return setDrawingCacheQuality.Cardinal(i, iArr);
        }
    }

    /* renamed from: com.cardinalcommerce.a.getAcsTransactionID$init */
    public static class C1998init extends getInstance {
        C1995f Cardinal;
        private int cca_continue;
        private int configure;
        private int[] init;

        public C1998init(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.cca_continue = 2;
                this.init = new int[]{i2};
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.cca_continue = 3;
                this.init = new int[]{i2, i3, i4};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.configure = i;
            this.Cardinal = new C1995f(bigInteger);
        }

        C1998init(int i, int[] iArr, C1995f fVar) {
            this.configure = i;
            this.cca_continue = iArr.length == 1 ? 2 : 3;
            this.init = iArr;
            this.Cardinal = fVar;
        }

        public static void getInstance(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
            if (!(getacstransactionid instanceof C1998init) || !(getacstransactionid2 instanceof C1998init)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            C1998init init2 = (C1998init) getacstransactionid;
            C1998init init3 = (C1998init) getacstransactionid2;
            if (init2.cca_continue != init3.cca_continue) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            } else if (init2.configure != init3.configure || !setForegroundTintBlendMode.cca_continue(init2.init, init3.init)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
            return cca_continue(getacstransactionid);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.cardinalcommerce.a.f} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.cardinalcommerce.p060a.getAcsTransactionID Cardinal(com.cardinalcommerce.p060a.getAcsTransactionID r3, com.cardinalcommerce.p060a.getAcsTransactionID r4, com.cardinalcommerce.p060a.getAcsTransactionID r5) {
            /*
                r2 = this;
                com.cardinalcommerce.a.f r0 = r2.Cardinal
                com.cardinalcommerce.a.getAcsTransactionID$init r3 = (com.cardinalcommerce.p060a.getAcsTransactionID.C1998init) r3
                com.cardinalcommerce.a.f r3 = r3.Cardinal
                com.cardinalcommerce.a.getAcsTransactionID$init r4 = (com.cardinalcommerce.p060a.getAcsTransactionID.C1998init) r4
                com.cardinalcommerce.a.f r4 = r4.Cardinal
                com.cardinalcommerce.a.getAcsTransactionID$init r5 = (com.cardinalcommerce.p060a.getAcsTransactionID.C1998init) r5
                com.cardinalcommerce.a.f r5 = r5.Cardinal
                com.cardinalcommerce.a.f r1 = r0.mo18181b((com.cardinalcommerce.p060a.C1995f) r3)
                com.cardinalcommerce.a.f r4 = r4.mo18181b((com.cardinalcommerce.p060a.C1995f) r5)
                if (r1 == r0) goto L_0x001a
                if (r1 != r3) goto L_0x0021
            L_0x001a:
                java.lang.Object r3 = r1.clone()
                r1 = r3
                com.cardinalcommerce.a.f r1 = (com.cardinalcommerce.p060a.C1995f) r1
            L_0x0021:
                r1.mo18178a((com.cardinalcommerce.p060a.C1995f) r4)
                int r3 = r2.configure
                int[] r4 = r2.init
                r1.mo18177a(r3, r4)
                com.cardinalcommerce.a.getAcsTransactionID$init r3 = new com.cardinalcommerce.a.getAcsTransactionID$init
                int r4 = r2.configure
                int[] r5 = r2.init
                r3.<init>(r4, r5, r1)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.getAcsTransactionID.C1998init.Cardinal(com.cardinalcommerce.a.getAcsTransactionID, com.cardinalcommerce.a.getAcsTransactionID, com.cardinalcommerce.a.getAcsTransactionID):com.cardinalcommerce.a.getAcsTransactionID");
        }

        public final boolean CardinalActionCode() {
            return this.Cardinal.mo18186d();
        }

        public final boolean CardinalError() {
            return this.Cardinal.mo18179a();
        }

        public final int cca_continue() {
            return this.configure;
        }

        public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
            C1995f fVar = (C1995f) this.Cardinal.clone();
            fVar.mo18178a(((C1998init) getacstransactionid).Cardinal);
            return new C1998init(this.configure, this.init, fVar);
        }

        public final boolean cleanup() {
            return this.Cardinal.mo18182b();
        }

        public final getAcsTransactionID configure() {
            int i = this.configure;
            int[] iArr = this.init;
            return new C1998init(i, iArr, this.Cardinal.mo18180b(i, iArr));
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1998init)) {
                return false;
            }
            C1998init init2 = (C1998init) obj;
            return this.configure == init2.configure && this.cca_continue == init2.cca_continue && setForegroundTintBlendMode.cca_continue(this.init, init2.init) && this.Cardinal.equals(init2.Cardinal);
        }

        public final getAcsTransactionID getInstance() {
            return this;
        }

        public final getAcsTransactionID getInstance(int i) {
            if (i <= 0) {
                return this;
            }
            int i2 = this.configure;
            int[] iArr = this.init;
            return new C1998init(i2, iArr, this.Cardinal.mo18175a(i, i2, iArr));
        }

        public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
            return init(getacstransactionid.getSDKVersion());
        }

        public final getAcsTransactionID getSDKVersion() {
            int i = this.configure;
            int[] iArr = this.init;
            return new C1998init(i, iArr, this.Cardinal.mo18184c(i, iArr));
        }

        public final int getWarnings() {
            return this.Cardinal.mo18183c();
        }

        public final int hashCode() {
            return (this.Cardinal.hashCode() ^ this.configure) ^ setForegroundTintBlendMode.cca_continue(this.init);
        }

        public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
            int i = this.configure;
            int[] iArr = this.init;
            return new C1998init(i, iArr, this.Cardinal.mo18176a(((C1998init) getacstransactionid).Cardinal, i, iArr));
        }

        public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
            return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
        }

        public final getAcsTransactionID values() {
            return (this.Cardinal.mo18182b() || this.Cardinal.mo18179a()) ? this : getInstance(this.configure - 1);
        }

        public final BigInteger Cardinal() {
            C1995f fVar = this.Cardinal;
            int a = fVar.mo18174a(fVar.f2533b.length);
            if (a == 0) {
                return getSDKReferenceNumber.CardinalError;
            }
            int i = a - 1;
            long j = fVar.f2533b[i];
            byte[] bArr = new byte[8];
            int i2 = 0;
            boolean z = false;
            for (int i3 = 7; i3 >= 0; i3--) {
                byte b = (byte) ((int) (j >>> (i3 << 3)));
                if (z || b != 0) {
                    bArr[i2] = b;
                    i2++;
                    z = true;
                }
            }
            byte[] bArr2 = new byte[((i * 8) + i2)];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i4] = bArr[i4];
            }
            for (int i5 = a - 2; i5 >= 0; i5--) {
                long j2 = fVar.f2533b[i5];
                int i6 = 7;
                while (i6 >= 0) {
                    bArr2[i2] = (byte) ((int) (j2 >>> (i6 << 3)));
                    i6--;
                    i2++;
                }
            }
            return new BigInteger(1, bArr2);
        }

        public final getAcsTransactionID init() {
            C1995f fVar;
            int i = this.configure;
            int[] iArr = this.init;
            C1995f fVar2 = this.Cardinal;
            if (fVar2.f2533b.length == 0) {
                fVar = new C1995f(new long[]{1});
            } else {
                int max = Math.max(1, fVar2.mo18174a(fVar2.f2533b.length));
                long[] jArr = new long[max];
                System.arraycopy(fVar2.f2533b, 0, jArr, 0, Math.min(fVar2.f2533b.length, max));
                jArr[0] = jArr[0] ^ 1;
                fVar = new C1995f(jArr);
            }
            return new C1998init(i, iArr, fVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.cardinalcommerce.a.f} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.cardinalcommerce.p060a.getAcsTransactionID cca_continue(com.cardinalcommerce.p060a.getAcsTransactionID r11, com.cardinalcommerce.p060a.getAcsTransactionID r12) {
            /*
                r10 = this;
                com.cardinalcommerce.a.f r0 = r10.Cardinal
                com.cardinalcommerce.a.getAcsTransactionID$init r11 = (com.cardinalcommerce.p060a.getAcsTransactionID.C1998init) r11
                com.cardinalcommerce.a.f r11 = r11.Cardinal
                com.cardinalcommerce.a.getAcsTransactionID$init r12 = (com.cardinalcommerce.p060a.getAcsTransactionID.C1998init) r12
                com.cardinalcommerce.a.f r12 = r12.Cardinal
                long[] r1 = r0.f2533b
                int r1 = r1.length
                int r1 = r0.mo18174a((int) r1)
                if (r1 != 0) goto L_0x0015
                r4 = r0
                goto L_0x003e
            L_0x0015:
                int r1 = r1 << 1
                long[] r2 = new long[r1]
                r3 = 0
                r4 = 0
            L_0x001b:
                if (r4 >= r1) goto L_0x0039
                long[] r5 = r0.f2533b
                int r6 = r4 >>> 1
                r6 = r5[r6]
                int r5 = r4 + 1
                int r8 = (int) r6
                long r8 = com.cardinalcommerce.p060a.C1995f.m1854b((int) r8)
                r2[r4] = r8
                int r4 = r5 + 1
                r8 = 32
                long r6 = r6 >>> r8
                int r7 = (int) r6
                long r6 = com.cardinalcommerce.p060a.C1995f.m1854b((int) r7)
                r2[r5] = r6
                goto L_0x001b
            L_0x0039:
                com.cardinalcommerce.a.f r4 = new com.cardinalcommerce.a.f
                r4.<init>(r2, r3, r1)
            L_0x003e:
                com.cardinalcommerce.a.f r11 = r11.mo18181b((com.cardinalcommerce.p060a.C1995f) r12)
                if (r4 != r0) goto L_0x004b
                java.lang.Object r12 = r4.clone()
                r4 = r12
                com.cardinalcommerce.a.f r4 = (com.cardinalcommerce.p060a.C1995f) r4
            L_0x004b:
                r4.mo18178a((com.cardinalcommerce.p060a.C1995f) r11)
                int r11 = r10.configure
                int[] r12 = r10.init
                r4.mo18177a(r11, r12)
                com.cardinalcommerce.a.getAcsTransactionID$init r11 = new com.cardinalcommerce.a.getAcsTransactionID$init
                int r12 = r10.configure
                int[] r0 = r10.init
                r11.<init>(r12, r0, r4)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.getAcsTransactionID.C1998init.cca_continue(com.cardinalcommerce.a.getAcsTransactionID, com.cardinalcommerce.a.getAcsTransactionID):com.cardinalcommerce.a.getAcsTransactionID");
        }
    }
}
