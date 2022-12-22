package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.setLeft */
public final class setLeft {

    /* renamed from: a */
    final KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f2854a;

    /* renamed from: b */
    final int f2855b;

    /* renamed from: c */
    private final setOutlineProvider f2856c;

    /* renamed from: d */
    private final int f2857d;

    /* renamed from: e */
    private final int f2858e;
    public final int getInstance;

    protected setLeft(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        if (mQVwithSHA256KDFAndSharedInfo != null) {
            this.f2854a = mQVwithSHA256KDFAndSharedInfo;
            if (mQVwithSHA256KDFAndSharedInfo != null) {
                String configure = mQVwithSHA256KDFAndSharedInfo.configure();
                int instance = configure.equals("SHAKE128") ? 32 : configure.equals("SHAKE256") ? 64 : mQVwithSHA256KDFAndSharedInfo.getInstance();
                this.getInstance = instance;
                int ceil = (int) Math.ceil(((double) (instance * 8)) / ((double) setVerticalFadingEdgeEnabled.getInstance(16)));
                this.f2857d = ceil;
                int instance2 = (setVerticalFadingEdgeEnabled.getInstance(ceil * 15) / setVerticalFadingEdgeEnabled.getInstance(16)) + 1;
                this.f2858e = instance2;
                this.f2855b = this.f2857d + instance2;
                C2020m a = C2020m.m1917a(mQVwithSHA256KDFAndSharedInfo.configure(), this.getInstance, 16, this.f2855b);
                this.f2856c = a;
                if (a == null) {
                    StringBuilder sb = new StringBuilder("cannot find OID for digest algorithm: ");
                    sb.append(mQVwithSHA256KDFAndSharedInfo.configure());
                    throw new IllegalArgumentException(sb.toString());
                }
                return;
            }
            throw new NullPointerException("digest == null");
        }
        throw new NullPointerException("digest == null");
    }
}
