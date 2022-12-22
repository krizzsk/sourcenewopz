package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.x509;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.BCECPublicKey;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GMCipherSpi;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.KeyFactory;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PKIXCertPath;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getType;
import com.cardinalcommerce.p060a.getUiType;
import com.cardinalcommerce.p060a.isEnableLogging;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import com.cardinalcommerce.p060a.setTooltipText;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CertificateFactory extends CertificateFactorySpi {

    /* renamed from: b */
    private static final com.cardinalcommerce.p060a.CertificateFactory f3219b = new com.cardinalcommerce.p060a.CertificateFactory("CERTIFICATE");

    /* renamed from: c */
    private static final com.cardinalcommerce.p060a.CertificateFactory f3220c = new com.cardinalcommerce.p060a.CertificateFactory("CRL");

    /* renamed from: a */
    private final JWEObject f3221a = new JWSObject();

    /* renamed from: d */
    private isEnableLogging f3222d = null;

    /* renamed from: e */
    private int f3223e = 0;

    /* renamed from: f */
    private InputStream f3224f = null;

    /* renamed from: g */
    private isEnableLogging f3225g = null;

    /* renamed from: h */
    private int f3226h = 0;

    /* renamed from: i */
    private InputStream f3227i = null;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory$init */
    class C2153init extends CertificateException {
        private Throwable init;

        public C2153init(String str, Throwable th) {
            super(str);
            this.init = th;
        }

        public final Throwable getCause() {
            return this.init;
        }
    }

    static {
        new com.cardinalcommerce.p060a.CertificateFactory("PKCS7");
    }

    public Collection engineGenerateCRLs(InputStream inputStream) throws CRLException {
        ArrayList arrayList = new ArrayList();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (true) {
            CRL engineGenerateCRL = engineGenerateCRL(bufferedInputStream);
            if (engineGenerateCRL == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCRL);
        }
    }

    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    public CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        return new PKIXCertPath(inputStream, str);
    }

    public CertPath engineGenerateCertPath(List list) throws CertificateException {
        for (Object next : list) {
            if (next != null && !(next instanceof X509Certificate)) {
                StringBuilder sb = new StringBuilder("list contains non X509Certificate object while creating CertPath\n");
                sb.append(next.toString());
                throw new CertificateException(sb.toString());
            }
        }
        return new PKIXCertPath(list);
    }

    public Collection engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate engineGenerateCertificate = engineGenerateCertificate(bufferedInputStream);
            if (engineGenerateCertificate == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCertificate);
        }
    }

    public Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.getInstance.iterator();
    }

    /* renamed from: a */
    private Certificate m2211a(setThreeDSRequestorAppURL setthreedsrequestorappurl) throws CertificateParsingException {
        BCECPublicKey bCECPublicKey = null;
        if (setthreedsrequestorappurl == null) {
            return null;
        }
        if (setthreedsrequestorappurl.getInstance() <= 1 || !(setthreedsrequestorappurl.Cardinal(0) instanceof ASN1ObjectIdentifier) || !setthreedsrequestorappurl.Cardinal(0).equals(KeyFactorySpi.isEnableDFSync)) {
            JWEObject jWEObject = this.f3221a;
            if (setthreedsrequestorappurl != null) {
                bCECPublicKey = new BCECPublicKey(setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl));
            }
            return new KeyFactory(jWEObject, bCECPublicKey);
        }
        this.f3222d = DSASigner.detDSA.getInstance(setThreeDSRequestorAppURL.configure((getType) setthreedsrequestorappurl.Cardinal(1), true)).getPayment;
        return m2210a();
    }

    /* renamed from: a */
    private Certificate m2210a() throws CertificateParsingException {
        BCECPublicKey bCECPublicKey = null;
        if (this.f3222d != null) {
            while (this.f3223e < this.f3222d.cca_continue.size()) {
                isEnableLogging isenablelogging = this.f3222d;
                int i = this.f3223e;
                this.f3223e = i + 1;
                getProxyAddress getproxyaddress = (getProxyAddress) isenablelogging.cca_continue.elementAt(i);
                if (getproxyaddress instanceof setThreeDSRequestorAppURL) {
                    JWEObject jWEObject = this.f3221a;
                    if (getproxyaddress instanceof BCECPublicKey) {
                        bCECPublicKey = (BCECPublicKey) getproxyaddress;
                    } else if (getproxyaddress != null) {
                        bCECPublicKey = new BCECPublicKey(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress));
                    }
                    return new KeyFactory(jWEObject, bCECPublicKey);
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private CRL m2213b(setThreeDSRequestorAppURL setthreedsrequestorappurl) throws CRLException {
        GMCipherSpi.SM2withBlake2b sM2withBlake2b = null;
        if (setthreedsrequestorappurl == null) {
            return null;
        }
        if (setthreedsrequestorappurl.getInstance() <= 1 || !(setthreedsrequestorappurl.Cardinal(0) instanceof ASN1ObjectIdentifier) || !setthreedsrequestorappurl.Cardinal(0).equals(KeyFactorySpi.isEnableDFSync)) {
            if (setthreedsrequestorappurl != null) {
                sM2withBlake2b = new GMCipherSpi.SM2withBlake2b(setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl));
            }
            return new PKIXCertPath(this.f3221a, sM2withBlake2b);
        }
        this.f3225g = DSASigner.detDSA.getInstance(setThreeDSRequestorAppURL.configure((getType) setthreedsrequestorappurl.Cardinal(1), true)).getErrorDescription;
        return m2212b();
    }

    /* renamed from: b */
    private CRL m2212b() throws CRLException {
        isEnableLogging isenablelogging = this.f3225g;
        GMCipherSpi.SM2withBlake2b sM2withBlake2b = null;
        if (isenablelogging == null || this.f3226h >= isenablelogging.cca_continue.size()) {
            return null;
        }
        isEnableLogging isenablelogging2 = this.f3225g;
        int i = this.f3226h;
        this.f3226h = i + 1;
        getProxyAddress getproxyaddress = (getProxyAddress) isenablelogging2.cca_continue.elementAt(i);
        if (getproxyaddress instanceof GMCipherSpi.SM2withBlake2b) {
            sM2withBlake2b = (GMCipherSpi.SM2withBlake2b) getproxyaddress;
        } else if (getproxyaddress != null) {
            sM2withBlake2b = new GMCipherSpi.SM2withBlake2b(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress));
        }
        return new PKIXCertPath(this.f3221a, sM2withBlake2b);
    }

    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        InputStream inputStream2 = this.f3224f;
        if (inputStream2 == null || inputStream2 != inputStream) {
            this.f3224f = inputStream;
            this.f3222d = null;
            this.f3223e = 0;
        }
        try {
            if (this.f3222d == null) {
                if (!inputStream.markSupported()) {
                    inputStream = new ByteArrayInputStream(setTooltipText.cca_continue(inputStream));
                }
                inputStream.mark(1);
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                inputStream.reset();
                return read != 48 ? m2211a(f3219b.configure(inputStream)) : m2211a(setThreeDSRequestorAppURL.cca_continue((Object) new getUiType(inputStream).cca_continue()));
            } else if (this.f3223e != this.f3222d.cca_continue.size()) {
                return m2210a();
            } else {
                this.f3222d = null;
                this.f3223e = 0;
                return null;
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("parsing issue: ");
            sb.append(e.getMessage());
            throw new C2153init(sb.toString(), e);
        }
    }

    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        InputStream inputStream2 = this.f3227i;
        if (inputStream2 == null || inputStream2 != inputStream) {
            this.f3227i = inputStream;
            this.f3225g = null;
            this.f3226h = 0;
        }
        try {
            if (this.f3225g == null) {
                if (!inputStream.markSupported()) {
                    inputStream = new ByteArrayInputStream(setTooltipText.cca_continue(inputStream));
                }
                inputStream.mark(1);
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                inputStream.reset();
                return read != 48 ? m2213b(f3220c.configure(inputStream)) : m2213b(setThreeDSRequestorAppURL.cca_continue((Object) new getUiType(inputStream, (byte) 0).cca_continue()));
            } else if (this.f3226h != this.f3225g.cca_continue.size()) {
                return m2212b();
            } else {
                this.f3225g = null;
                this.f3226h = 0;
                return null;
            }
        } catch (CRLException e) {
            throw e;
        } catch (Exception e2) {
            throw new CRLException(e2.toString());
        }
    }
}
