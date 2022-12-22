package com.didichuxing.mas.sdk.quality.report.utils;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class BloomFilter {
    private static BloomFilter mBloomFilter;
    private volatile BitSet bits = null;
    private SimpleHash[] func;
    private AtomicBoolean isInit;
    private final int[] seeds;

    private BloomFilter() {
        int[] iArr = {11, 61, 113};
        this.seeds = iArr;
        this.func = new SimpleHash[iArr.length];
        this.isInit = new AtomicBoolean(false);
    }

    public static synchronized BloomFilter getBloomFilter() {
        BloomFilter bloomFilter;
        synchronized (BloomFilter.class) {
            if (mBloomFilter == null) {
                mBloomFilter = new BloomFilter();
            }
            bloomFilter = mBloomFilter;
        }
        return bloomFilter;
    }

    public void init(byte[] bArr, int i) {
        this.bits = new BitSet(i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = 7;
            while (i5 >= 0) {
                int i6 = i3 + 1;
                this.bits.set(i3, ((bArr[i4] & (1 << i5)) >> i5) == 1);
                i5--;
                i3 = i6;
            }
        }
        while (true) {
            int[] iArr = this.seeds;
            if (i2 < iArr.length) {
                this.func[i2] = new SimpleHash(i, iArr[i2]);
                i2++;
            } else {
                this.isInit.set(true);
                return;
            }
        }
    }

    public class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int i, int i2) {
            this.cap = i;
            this.seed = i2;
        }

        public int hash(String str) {
            int length = str.length();
            int i = 1;
            for (int i2 = 0; i2 < length; i2++) {
                i = ((this.seed * i) + str.charAt(i2)) % this.cap;
            }
            return Math.abs(i) % this.cap;
        }
    }

    public void clear() {
        this.isInit.set(false);
    }

    public boolean isInit() {
        return this.isInit.get();
    }

    public void add(String str) {
        if (str != null && str.length() != 0 && this.bits != null) {
            for (SimpleHash hash : this.func) {
                this.bits.set(hash.hash(str), true);
            }
        }
    }

    public boolean contains(String str) {
        if (!(str == null || str.length() == 0 || this.bits == null || this.bits.length() == 0)) {
            try {
                for (SimpleHash hash : this.func) {
                    if (!this.bits.get(hash.hash(str))) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
