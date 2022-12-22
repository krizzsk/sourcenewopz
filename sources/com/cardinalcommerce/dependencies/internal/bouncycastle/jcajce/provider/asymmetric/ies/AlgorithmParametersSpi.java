package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ies;

import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.RSA;
import com.cardinalcommerce.p060a.getErrorMessage;
import com.cardinalcommerce.p060a.getType;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Encoding;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {

    /* renamed from: a */
    private getErrorMessage f3211a;

    /* renamed from: a */
    private static boolean m2201a(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded(String str) {
        if (m2201a(str) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof getErrorMessage) {
            this.f3211a = (getErrorMessage) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (m2201a(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "IES Parameters";
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == null) {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        } else if (cls == getErrorMessage.class || cls == AlgorithmParameterSpec.class) {
            return this.f3211a;
        } else {
            throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() {
        try {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            if (this.f3211a.getInstance() != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 0, new EdEC(this.f3211a.getInstance())));
            }
            if (this.f3211a.init() != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 1, new EdEC(this.f3211a.init())));
            }
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.f3211a.Cardinal));
            if (this.f3211a.Cardinal() != null) {
                setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) this.f3211a.getInstance));
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress(this.f3211a.Cardinal()));
                setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
            }
            return new GOST(setforegroundtintblendmode).init(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding IESParameters");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr) throws IOException {
        try {
            setThreeDSRequestorAppURL setthreedsrequestorappurl = (setThreeDSRequestorAppURL) setLocationDataConsentGiven.getInstance(bArr);
            if (setthreedsrequestorappurl.getInstance() == 1) {
                this.f3211a = new getErrorMessage((byte[]) null, (byte[]) null, new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0)).Cardinal).intValue());
            } else if (setthreedsrequestorappurl.getInstance() == 2) {
                getType cca_continue = getType.cca_continue((Object) setthreedsrequestorappurl.Cardinal(0));
                if (cca_continue.Cardinal == 0) {
                    this.f3211a = new getErrorMessage(isEnableDFSync.getInstance(cca_continue, false).cca_continue(), (byte[]) null, new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1)).Cardinal).intValue());
                } else {
                    this.f3211a = new getErrorMessage((byte[]) null, isEnableDFSync.getInstance(cca_continue, false).cca_continue(), new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1)).Cardinal).intValue());
                }
            } else if (setthreedsrequestorappurl.getInstance() == 3) {
                this.f3211a = new getErrorMessage(isEnableDFSync.getInstance(getType.cca_continue((Object) setthreedsrequestorappurl.Cardinal(0)), false).cca_continue(), isEnableDFSync.getInstance(getType.cca_continue((Object) setthreedsrequestorappurl.Cardinal(1)), false).cca_continue(), new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(2)).Cardinal).intValue());
            } else if (setthreedsrequestorappurl.getInstance() == 4) {
                getType cca_continue2 = getType.cca_continue((Object) setthreedsrequestorappurl.Cardinal(0));
                getType cca_continue3 = getType.cca_continue((Object) setthreedsrequestorappurl.Cardinal(1));
                setThreeDSRequestorAppURL cca_continue4 = setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl.Cardinal(3));
                this.f3211a = new getErrorMessage(isEnableDFSync.getInstance(cca_continue2, false).cca_continue(), isEnableDFSync.getInstance(cca_continue3, false).cca_continue(), new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(2)).Cardinal).intValue(), new BigInteger(setProxyAddress.Cardinal((Object) cca_continue4.Cardinal(0)).Cardinal).intValue(), isEnableDFSync.init(cca_continue4.Cardinal(1)).cca_continue());
            }
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid IES Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid IES Parameter encoding.");
        }
    }
}
