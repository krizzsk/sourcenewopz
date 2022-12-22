package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.util.Hashtable;

/* renamed from: com.cardinalcommerce.a.SignatureSpiLe */
public final class SignatureSpiLe extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private static final String[] f2478a = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    /* renamed from: b */
    private static final Hashtable f2479b = new Hashtable();

    /* renamed from: c */
    private getChallengeTimeout f2480c;

    private SignatureSpiLe(int i) {
        this.f2480c = new getChallengeTimeout(i);
    }

    public final setLocationDataConsentGiven values() {
        return this.f2480c;
    }

    public static SignatureSpiLe getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        int intValue = new BigInteger(getChallengeTimeout.configure(obj).configure).intValue();
        Integer valueOf = Integer.valueOf(intValue);
        if (!f2479b.containsKey(valueOf)) {
            f2479b.put(valueOf, new SignatureSpiLe(intValue));
        }
        return (SignatureSpiLe) f2479b.get(valueOf);
    }

    public final String toString() {
        int intValue = new BigInteger(this.f2480c.configure).intValue();
        return "CRLReason: ".concat(String.valueOf((intValue < 0 || intValue > 10) ? "invalid" : f2478a[intValue]));
    }
}
