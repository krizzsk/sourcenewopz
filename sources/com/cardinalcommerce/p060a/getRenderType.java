package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.C1895DH;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.getRenderType */
public abstract class getRenderType extends setLocationDataConsentGiven {
    protected setLocationDataConsentGiven Cardinal;
    protected setProxyAddress cca_continue;
    protected ASN1ObjectIdentifier configure;
    protected setLocationDataConsentGiven getInstance;
    protected int init;

    private void getInstance(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid encoding value: ".concat(String.valueOf(i)));
        }
        this.init = i;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        setLocationDataConsentGiven setlocationdataconsentgiven2;
        setProxyAddress setproxyaddress;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (!(setlocationdataconsentgiven instanceof getRenderType)) {
            return false;
        }
        if (this == setlocationdataconsentgiven) {
            return true;
        }
        getRenderType getrendertype = (getRenderType) setlocationdataconsentgiven;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = this.configure;
        if (aSN1ObjectIdentifier2 != null && ((aSN1ObjectIdentifier = getrendertype.configure) == null || !aSN1ObjectIdentifier.equals(aSN1ObjectIdentifier2))) {
            return false;
        }
        setProxyAddress setproxyaddress2 = this.cca_continue;
        if (setproxyaddress2 != null && ((setproxyaddress = getrendertype.cca_continue) == null || !setproxyaddress.equals(setproxyaddress2))) {
            return false;
        }
        setLocationDataConsentGiven setlocationdataconsentgiven3 = this.Cardinal;
        if (setlocationdataconsentgiven3 == null || ((setlocationdataconsentgiven2 = getrendertype.Cardinal) != null && setlocationdataconsentgiven2.equals(setlocationdataconsentgiven3))) {
            return this.getInstance.equals(getrendertype.getInstance);
        }
        return false;
    }

    public final setLocationDataConsentGiven CardinalError() {
        return this.getInstance;
    }

    public final int cca_continue() {
        return this.init;
    }

    public final setProxyAddress cleanup() {
        return this.cca_continue;
    }

    /* access modifiers changed from: package-private */
    public int configure() throws IOException {
        return getEncoded().length;
    }

    public final ASN1ObjectIdentifier getInstance() {
        return this.configure;
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getSDKVersion() {
        return this instanceof C1895DH.Mappings ? this : new C1895DH.Mappings(this.configure, this.cca_continue, this.Cardinal, this.init, this.getInstance);
    }

    public int hashCode() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.configure;
        int hashCode = aSN1ObjectIdentifier != null ? aSN1ObjectIdentifier.hashCode() : 0;
        setProxyAddress setproxyaddress = this.cca_continue;
        if (setproxyaddress != null) {
            hashCode ^= setproxyaddress.hashCode();
        }
        setLocationDataConsentGiven setlocationdataconsentgiven = this.Cardinal;
        if (setlocationdataconsentgiven != null) {
            hashCode ^= setlocationdataconsentgiven.hashCode();
        }
        return hashCode ^ this.getInstance.hashCode();
    }

    public final setLocationDataConsentGiven init() {
        return this.Cardinal;
    }

    public getRenderType(setForegroundTintBlendMode setforegroundtintblendmode) {
        if (setforegroundtintblendmode.cca_continue.size() > 0) {
            int i = 0;
            setLocationDataConsentGiven values = ((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(0)).values();
            if (values instanceof ASN1ObjectIdentifier) {
                this.configure = (ASN1ObjectIdentifier) values;
                if (setforegroundtintblendmode.cca_continue.size() > 1) {
                    values = ((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(1)).values();
                    i = 1;
                } else {
                    throw new IllegalArgumentException("too few objects in input vector");
                }
            }
            if (values instanceof setProxyAddress) {
                this.cca_continue = (setProxyAddress) values;
                i++;
                if (setforegroundtintblendmode.cca_continue.size() > i) {
                    values = ((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(i)).values();
                } else {
                    throw new IllegalArgumentException("too few objects in input vector");
                }
            }
            if (!(values instanceof getType)) {
                this.Cardinal = values;
                i++;
                if (setforegroundtintblendmode.cca_continue.size() > i) {
                    values = ((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(i)).values();
                } else {
                    throw new IllegalArgumentException("too few objects in input vector");
                }
            }
            if (setforegroundtintblendmode.cca_continue.size() != i + 1) {
                throw new IllegalArgumentException("input vector too large");
            } else if (values instanceof getType) {
                getType gettype = (getType) values;
                getInstance(gettype.Cardinal);
                this.getInstance = gettype.getInstance != null ? gettype.getInstance.values() : null;
            } else {
                throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
            }
        } else {
            throw new IllegalArgumentException("too few objects in input vector");
        }
    }

    public getRenderType(ASN1ObjectIdentifier aSN1ObjectIdentifier, setProxyAddress setproxyaddress, setLocationDataConsentGiven setlocationdataconsentgiven, int i, setLocationDataConsentGiven setlocationdataconsentgiven2) {
        this.configure = aSN1ObjectIdentifier;
        this.cca_continue = setproxyaddress;
        this.Cardinal = setlocationdataconsentgiven;
        getInstance(i);
        this.getInstance = setlocationdataconsentgiven2.values();
    }
}
