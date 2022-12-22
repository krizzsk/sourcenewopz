package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.cardinalcommerce.a.setThreeDSRequestorAppURL */
public abstract class setThreeDSRequestorAppURL extends setLocationDataConsentGiven implements KeyAgreementSpi.ECKAEGwithSHA512KDF<getProxyAddress> {
    protected Vector configure;

    protected setThreeDSRequestorAppURL() {
        this.configure = new Vector();
    }

    protected setThreeDSRequestorAppURL(getProxyAddress getproxyaddress) {
        Vector vector = new Vector();
        this.configure = vector;
        vector.addElement(getproxyaddress);
    }

    protected setThreeDSRequestorAppURL(getProxyAddress[] getproxyaddressArr) {
        this.configure = new Vector();
        for (int i = 0; i != getproxyaddressArr.length; i++) {
            this.configure.addElement(getproxyaddressArr[i]);
        }
    }

    public static setThreeDSRequestorAppURL cca_continue(Object obj) {
        while (obj != null && !(obj instanceof setThreeDSRequestorAppURL)) {
            if (obj instanceof setEnableLogging) {
                obj = ((setEnableLogging) obj).values();
            } else if (obj instanceof byte[]) {
                try {
                    return cca_continue((Object) getInstance((byte[]) obj));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder("failed to construct sequence from byte[]: ");
                    sb.append(e.getMessage());
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                if (obj instanceof getProxyAddress) {
                    setLocationDataConsentGiven values = ((getProxyAddress) obj).values();
                    if (values instanceof setThreeDSRequestorAppURL) {
                        return (setThreeDSRequestorAppURL) values;
                    }
                }
                StringBuilder sb2 = new StringBuilder("unknown object in getInstance: ");
                sb2.append(obj.getClass().getName());
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return (setThreeDSRequestorAppURL) obj;
    }

    public getProxyAddress Cardinal(int i) {
        return (getProxyAddress) this.configure.elementAt(i);
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return true;
    }

    public Enumeration cca_continue() {
        return this.configure.elements();
    }

    /* access modifiers changed from: package-private */
    public abstract void cca_continue(setEnableDFSync setenabledfsync) throws IOException;

    public int getInstance() {
        return this.configure.size();
    }

    /* access modifiers changed from: package-private */
    public setLocationDataConsentGiven getSDKVersion() {
        GOST gost = new GOST();
        gost.configure = this.configure;
        return gost;
    }

    /* access modifiers changed from: package-private */
    public setLocationDataConsentGiven getWarnings() {
        IESCipher.IESwithAESCBC iESwithAESCBC = new IESCipher.IESwithAESCBC();
        iESwithAESCBC.configure = this.configure;
        return iESwithAESCBC;
    }

    public final getProxyAddress[] init() {
        getProxyAddress[] getproxyaddressArr = new getProxyAddress[getInstance()];
        for (int i = 0; i != getInstance(); i++) {
            getproxyaddressArr[i] = Cardinal(i);
        }
        return getproxyaddressArr;
    }

    public Iterator<getProxyAddress> iterator() {
        return new setForegroundTintBlendMode.C2049init(init());
    }

    public String toString() {
        return this.configure.toString();
    }

    public static setThreeDSRequestorAppURL configure(getType gettype, boolean z) {
        setLocationDataConsentGiven setlocationdataconsentgiven = null;
        if (!z) {
            if (gettype.getInstance != null) {
                setlocationdataconsentgiven = gettype.getInstance.values();
            }
            if (gettype.init()) {
                return gettype instanceof onValidated ? new ValidateResponse((getProxyAddress) setlocationdataconsentgiven) : new IESCipher.IESwithAESCBC((getProxyAddress) setlocationdataconsentgiven);
            }
            if (setlocationdataconsentgiven instanceof setThreeDSRequestorAppURL) {
                return (setThreeDSRequestorAppURL) setlocationdataconsentgiven;
            }
            StringBuilder sb = new StringBuilder("unknown object in getInstance: ");
            sb.append(gettype.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        } else if (gettype.init()) {
            if (gettype.getInstance != null) {
                setlocationdataconsentgiven = gettype.getInstance.values();
            }
            return cca_continue((Object) setlocationdataconsentgiven.values());
        } else {
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
    }

    protected setThreeDSRequestorAppURL(setForegroundTintBlendMode setforegroundtintblendmode) {
        this.configure = new Vector();
        for (int i = 0; i != setforegroundtintblendmode.cca_continue.size(); i++) {
            this.configure.addElement((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(i));
        }
    }

    public int hashCode() {
        Enumeration cca_continue = cca_continue();
        int instance = getInstance();
        while (cca_continue.hasMoreElements()) {
            instance = (instance * 17) ^ ((getProxyAddress) cca_continue.nextElement()).hashCode();
        }
        return instance;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof setThreeDSRequestorAppURL)) {
            return false;
        }
        setThreeDSRequestorAppURL setthreedsrequestorappurl = (setThreeDSRequestorAppURL) setlocationdataconsentgiven;
        if (getInstance() != setthreedsrequestorappurl.getInstance()) {
            return false;
        }
        Enumeration cca_continue = cca_continue();
        Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
        while (cca_continue.hasMoreElements()) {
            setLocationDataConsentGiven values = ((getProxyAddress) cca_continue.nextElement()).values();
            setLocationDataConsentGiven values2 = ((getProxyAddress) cca_continue2.nextElement()).values();
            if (values != values2 && !values.equals(values2)) {
                return false;
            }
        }
        return true;
    }
}
