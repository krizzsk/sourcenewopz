package com.cardinalcommerce.p060a;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.getType */
public abstract class getType extends setLocationDataConsentGiven implements getActionCode {
    public int Cardinal;

    /* renamed from: a */
    boolean f2585a = true;
    public getProxyAddress getInstance = null;

    public getType(boolean z, int i, getProxyAddress getproxyaddress) {
        if (getproxyaddress instanceof setEnvironment) {
            this.f2585a = true;
        } else {
            this.f2585a = z;
        }
        this.Cardinal = i;
        if (this.f2585a) {
            this.getInstance = getproxyaddress;
            return;
        }
        getproxyaddress.values();
        this.getInstance = getproxyaddress;
    }

    public static getType cca_continue(Object obj) {
        if (obj == null || (obj instanceof getType)) {
            return (getType) obj;
        }
        StringBuilder sb = new StringBuilder("unknown object in getInstance: ");
        sb.append(obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof getType)) {
            return false;
        }
        getType gettype = (getType) setlocationdataconsentgiven;
        if (this.Cardinal != gettype.Cardinal || this.f2585a != gettype.f2585a) {
            return false;
        }
        getProxyAddress getproxyaddress = this.getInstance;
        return getproxyaddress == null ? gettype.getInstance == null : getproxyaddress.values().equals(gettype.getInstance.values());
    }

    /* access modifiers changed from: package-private */
    public abstract void cca_continue(setEnableDFSync setenabledfsync) throws IOException;

    public final setLocationDataConsentGiven getInstance() {
        return values();
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getSDKVersion() {
        return new RSA(this.f2585a, this.Cardinal, this.getInstance);
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getWarnings() {
        return new writeObject(this.f2585a, this.Cardinal, this.getInstance);
    }

    public int hashCode() {
        int i = this.Cardinal;
        getProxyAddress getproxyaddress = this.getInstance;
        return getproxyaddress != null ? i ^ getproxyaddress.hashCode() : i;
    }

    public final boolean init() {
        return this.f2585a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        sb.append(this.Cardinal);
        sb.append(Const.jaRight);
        sb.append(this.getInstance);
        return sb.toString();
    }
}
