package com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.RSA;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getString;
import com.cardinalcommerce.p060a.getThreeDSRequestorAppURL;
import com.cardinalcommerce.p060a.getType;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.isEnableLogging;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setSelected;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;

public class PrivateKeyInfo extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private setProxyAddress f3135a;

    /* renamed from: b */
    private getString f3136b;
    public DSASigner.stdDSA cca_continue;
    public isEnableLogging configure;
    public isEnableDFSync init;

    public PrivateKeyInfo(DSASigner.stdDSA stddsa, getProxyAddress getproxyaddress) throws IOException {
        this(stddsa, getproxyaddress, (isEnableLogging) null, (byte[]) null);
    }

    public PrivateKeyInfo(DSASigner.stdDSA stddsa, getProxyAddress getproxyaddress, isEnableLogging isenablelogging) throws IOException {
        this(stddsa, getproxyaddress, isenablelogging, (byte[]) null);
    }

    public PrivateKeyInfo(DSASigner.stdDSA stddsa, getProxyAddress getproxyaddress, isEnableLogging isenablelogging, byte[] bArr) throws IOException {
        this.f3135a = new setProxyAddress(bArr != null ? setSelected.init : setSelected.getInstance);
        this.cca_continue = stddsa;
        this.init = new EdEC(getproxyaddress);
        this.configure = isenablelogging;
        this.f3136b = bArr == null ? null : new com.cardinalcommerce.p060a.PrivateKeyInfo(bArr);
    }

    public static PrivateKeyInfo init(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new PrivateKeyInfo(setThreeDSRequestorAppURL.cca_continue(obj));
        }
        return null;
    }

    public final boolean cca_continue() {
        return this.f3136b != null;
    }

    private PrivateKeyInfo(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
        setProxyAddress Cardinal = setProxyAddress.Cardinal(cca_continue2.nextElement());
        this.f3135a = Cardinal;
        BigInteger bigInteger = new BigInteger(Cardinal.Cardinal);
        if (bigInteger.compareTo(setSelected.getInstance) < 0 || bigInteger.compareTo(setSelected.init) > 0) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        int intValue = bigInteger.intValue();
        Object nextElement = cca_continue2.nextElement();
        this.cca_continue = nextElement instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) nextElement : nextElement != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue(nextElement)) : null;
        this.init = isEnableDFSync.init(cca_continue2.nextElement());
        int i = -1;
        while (cca_continue2.hasMoreElements()) {
            getType gettype = (getType) cca_continue2.nextElement();
            int i2 = gettype.Cardinal;
            if (i2 > i) {
                if (i2 == 0) {
                    this.configure = isEnableLogging.cca_continue(gettype);
                } else if (i2 != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                } else if (intValue > 0) {
                    this.f3136b = com.cardinalcommerce.p060a.PrivateKeyInfo.getInstance(gettype);
                } else {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                i = i2;
            } else {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
        }
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(this.f3135a);
        setforegroundtintblendmode.cca_continue.addElement(this.cca_continue);
        setforegroundtintblendmode.cca_continue.addElement(this.init);
        isEnableLogging isenablelogging = this.configure;
        if (isenablelogging != null) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 0, isenablelogging));
        }
        getString getstring = this.f3136b;
        if (getstring != null) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 1, getstring));
        }
        return new GOST(setforegroundtintblendmode);
    }
}
