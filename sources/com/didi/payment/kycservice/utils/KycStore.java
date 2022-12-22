package com.didi.payment.kycservice.utils;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/KycStore;", "", "()V", "faceStatus", "", "getFaceStatus", "()I", "setFaceStatus", "(I)V", "fullKycStatus", "getFullKycStatus", "setFullKycStatus", "latourKycStatus", "getLatourKycStatus", "setLatourKycStatus", "pixStatus", "", "getPixStatus", "()Ljava/lang/Boolean;", "setPixStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "primaryKycStatus", "getPrimaryKycStatus", "setPrimaryKycStatus", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KycStore.kt */
public final class KycStore {
    public static final KycStore INSTANCE = new KycStore();

    /* renamed from: a */
    private static int f30931a;

    /* renamed from: b */
    private static int f30932b;

    /* renamed from: c */
    private static int f30933c;

    /* renamed from: d */
    private static int f30934d;

    /* renamed from: e */
    private static Boolean f30935e;

    private KycStore() {
    }

    public final int getPrimaryKycStatus() {
        return f30931a;
    }

    public final void setPrimaryKycStatus(int i) {
        f30931a = i;
    }

    public final int getFullKycStatus() {
        return f30932b;
    }

    public final void setFullKycStatus(int i) {
        f30932b = i;
    }

    public final int getFaceStatus() {
        return f30933c;
    }

    public final void setFaceStatus(int i) {
        f30933c = i;
    }

    public final int getLatourKycStatus() {
        return f30934d;
    }

    public final void setLatourKycStatus(int i) {
        f30934d = i;
    }

    public final Boolean getPixStatus() {
        return f30935e;
    }

    public final void setPixStatus(Boolean bool) {
        f30935e = bool;
    }
}
