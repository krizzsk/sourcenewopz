package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getChallengeTimeout */
public final class getChallengeTimeout extends setLocationDataConsentGiven {

    /* renamed from: a */
    private static getChallengeTimeout[] f2551a = new getChallengeTimeout[12];
    public final byte[] configure;

    public getChallengeTimeout(int i) {
        this.configure = BigInteger.valueOf((long) i).toByteArray();
    }

    private getChallengeTimeout(byte[] bArr) {
        if (setMinimumHeight.Cardinal("com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.allow_unsafe_integer") || !setProxyAddress.m2078a(bArr)) {
            this.configure = setForegroundTintBlendMode.cca_continue(bArr);
            return;
        }
        throw new IllegalArgumentException("malformed enumerated");
    }

    /* renamed from: a */
    static getChallengeTimeout m1889a(byte[] bArr) {
        if (bArr.length > 1) {
            return new getChallengeTimeout(bArr);
        }
        if (bArr.length != 0) {
            byte b = bArr[0] & 255;
            getChallengeTimeout[] getchallengetimeoutArr = f2551a;
            if (b >= getchallengetimeoutArr.length) {
                return new getChallengeTimeout(setForegroundTintBlendMode.cca_continue(bArr));
            }
            getChallengeTimeout getchallengetimeout = getchallengetimeoutArr[b];
            if (getchallengetimeout != null) {
                return getchallengetimeout;
            }
            getChallengeTimeout getchallengetimeout2 = new getChallengeTimeout(setForegroundTintBlendMode.cca_continue(bArr));
            getchallengetimeoutArr[b] = getchallengetimeout2;
            return getchallengetimeout2;
        }
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    public static getChallengeTimeout configure(Object obj) {
        if (obj == null || (obj instanceof getChallengeTimeout)) {
            return (getChallengeTimeout) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (getChallengeTimeout) getInstance((byte[]) obj);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("encoding error in getInstance: ");
                sb.append(e.toString());
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder("illegal object in getInstance: ");
            sb2.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof getChallengeTimeout)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.configure, ((getChallengeTimeout) setlocationdataconsentgiven).configure);
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.configure.length) + 1 + this.configure.length;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.init(this.configure);
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.configure;
        setenabledfsync.configure(10);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
