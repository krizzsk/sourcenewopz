package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.isEnableLogging */
public abstract class isEnableLogging extends setLocationDataConsentGiven implements KeyAgreementSpi.ECKAEGwithSHA512KDF<getProxyAddress> {
    public Vector cca_continue;
    private boolean getInstance;

    protected isEnableLogging() {
        this.cca_continue = new Vector();
        this.getInstance = false;
    }

    protected isEnableLogging(getProxyAddress getproxyaddress) {
        Vector vector = new Vector();
        this.cca_continue = vector;
        this.getInstance = false;
        vector.addElement(getproxyaddress);
    }

    protected isEnableLogging(getProxyAddress[] getproxyaddressArr) {
        this.cca_continue = new Vector();
        this.getInstance = false;
        for (int i = 0; i != getproxyaddressArr.length; i++) {
            this.cca_continue.addElement(getproxyaddressArr[i]);
        }
    }

    public static isEnableLogging Cardinal(Object obj) {
        while (obj != null && !(obj instanceof isEnableLogging)) {
            if (obj instanceof isLocationDataConsentGiven) {
                obj = ((isLocationDataConsentGiven) obj).values();
            } else if (obj instanceof byte[]) {
                try {
                    return Cardinal((Object) setLocationDataConsentGiven.getInstance((byte[]) obj));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder("failed to construct set from byte[]: ");
                    sb.append(e.getMessage());
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                if (obj instanceof getProxyAddress) {
                    setLocationDataConsentGiven values = ((getProxyAddress) obj).values();
                    if (values instanceof isEnableLogging) {
                        return (isEnableLogging) values;
                    }
                }
                StringBuilder sb2 = new StringBuilder("unknown object in getInstance: ");
                sb2.append(obj.getClass().getName());
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return (isEnableLogging) obj;
    }

    private static byte[] Cardinal(getProxyAddress getproxyaddress) {
        try {
            return getproxyaddress.values().init(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    private void cca_continue() {
        if (!this.getInstance) {
            this.getInstance = true;
            if (this.cca_continue.size() > 1) {
                int size = this.cca_continue.size() - 1;
                boolean z = true;
                while (z) {
                    int i = 0;
                    byte[] Cardinal = Cardinal((getProxyAddress) this.cca_continue.elementAt(0));
                    z = false;
                    int i2 = 0;
                    while (i2 != size) {
                        int i3 = i2 + 1;
                        byte[] Cardinal2 = Cardinal((getProxyAddress) this.cca_continue.elementAt(i3));
                        if (configure(Cardinal, Cardinal2)) {
                            Cardinal = Cardinal2;
                        } else {
                            Object elementAt = this.cca_continue.elementAt(i2);
                            Vector vector = this.cca_continue;
                            vector.setElementAt(vector.elementAt(i3), i2);
                            this.cca_continue.setElementAt(elementAt, i3);
                            i = i2;
                            z = true;
                        }
                        i2 = i3;
                    }
                    size = i;
                }
            }
        }
    }

    private static boolean configure(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i != min; i++) {
            if (bArr[i] != bArr2[i]) {
                return (bArr[i] & 255) < (bArr2[i] & 255);
            }
        }
        return min == bArr.length;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract void cca_continue(setEnableDFSync setenabledfsync) throws IOException;

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getSDKVersion() {
        if (this.getInstance) {
            GOST.Mappings mappings = new GOST.Mappings();
            mappings.cca_continue = this.cca_continue;
            return mappings;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.cca_continue.size(); i++) {
            vector.addElement(this.cca_continue.elementAt(i));
        }
        GOST.Mappings mappings2 = new GOST.Mappings();
        mappings2.cca_continue = vector;
        mappings2.cca_continue();
        return mappings2;
    }

    /* access modifiers changed from: package-private */
    public final setLocationDataConsentGiven getWarnings() {
        BCDHPublicKey bCDHPublicKey = new BCDHPublicKey();
        bCDHPublicKey.cca_continue = this.cca_continue;
        return bCDHPublicKey;
    }

    public Iterator<getProxyAddress> iterator() {
        return new setForegroundTintBlendMode.C2049init(init());
    }

    public String toString() {
        return this.cca_continue.toString();
    }

    public static isEnableLogging cca_continue(getType gettype) {
        setLocationDataConsentGiven values = gettype.getInstance != null ? gettype.getInstance.values() : null;
        if (gettype.init()) {
            return gettype instanceof onValidated ? new CardinalValidateReceiver((getProxyAddress) values) : new BCDHPublicKey((getProxyAddress) values);
        }
        if (values instanceof isEnableLogging) {
            return (isEnableLogging) values;
        }
        if (values instanceof setThreeDSRequestorAppURL) {
            setThreeDSRequestorAppURL setthreedsrequestorappurl = (setThreeDSRequestorAppURL) values;
            return gettype instanceof onValidated ? new CardinalValidateReceiver(setthreedsrequestorappurl.init()) : new BCDHPublicKey(setthreedsrequestorappurl.init());
        }
        StringBuilder sb = new StringBuilder("unknown object in getInstance: ");
        sb.append(gettype.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    protected isEnableLogging(setForegroundTintBlendMode setforegroundtintblendmode, boolean z) {
        this.cca_continue = new Vector();
        this.getInstance = false;
        for (int i = 0; i != setforegroundtintblendmode.cca_continue.size(); i++) {
            this.cca_continue.addElement((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(i));
        }
        if (z) {
            cca_continue();
        }
    }

    private getProxyAddress[] init() {
        getProxyAddress[] getproxyaddressArr = new getProxyAddress[this.cca_continue.size()];
        for (int i = 0; i != this.cca_continue.size(); i++) {
            getproxyaddressArr[i] = (getProxyAddress) this.cca_continue.elementAt(i);
        }
        return getproxyaddressArr;
    }

    public int hashCode() {
        Enumeration elements = this.cca_continue.elements();
        int size = this.cca_continue.size();
        while (elements.hasMoreElements()) {
            Object obj = (getProxyAddress) elements.nextElement();
            if (obj == null) {
                obj = ECGOST.Mappings.Cardinal;
            }
            size = (size * 17) ^ obj.hashCode();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof isEnableLogging)) {
            return false;
        }
        isEnableLogging isenablelogging = (isEnableLogging) setlocationdataconsentgiven;
        if (this.cca_continue.size() != isenablelogging.cca_continue.size()) {
            return false;
        }
        Enumeration elements = this.cca_continue.elements();
        Enumeration elements2 = isenablelogging.cca_continue.elements();
        while (elements.hasMoreElements()) {
            getProxyAddress getproxyaddress = (getProxyAddress) elements.nextElement();
            if (getproxyaddress == null) {
                getproxyaddress = ECGOST.Mappings.Cardinal;
            }
            getProxyAddress getproxyaddress2 = (getProxyAddress) elements2.nextElement();
            if (getproxyaddress2 == null) {
                getproxyaddress2 = ECGOST.Mappings.Cardinal;
            }
            setLocationDataConsentGiven values = getproxyaddress.values();
            setLocationDataConsentGiven values2 = getproxyaddress2.values();
            if (values != values2 && !values.equals(values2)) {
                return false;
            }
        }
        return true;
    }
}
