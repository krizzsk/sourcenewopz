package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.x509;

import com.cardinalcommerce.dependencies.internal.bouncycastle.util.p064io.pem.PemObject;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getUiType;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import com.cardinalcommerce.p060a.setViewTranslationCallback;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encoding;

public class PKIXCertPath extends CertPath {
    static final List getInstance;
    private final JWEObject Cardinal = new JWSObject();
    private List init;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("PkiPath");
        arrayList.add("PEM");
        arrayList.add("PKCS7");
        getInstance = Collections.unmodifiableList(arrayList);
    }

    PKIXCertPath(InputStream inputStream, String str) throws CertificateException {
        super("X.509");
        try {
            if (!str.equalsIgnoreCase("PkiPath")) {
                if (!str.equalsIgnoreCase("PKCS7")) {
                    if (!str.equalsIgnoreCase("PEM")) {
                        throw new CertificateException("unsupported encoding: ".concat(String.valueOf(str)));
                    }
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                this.init = new ArrayList();
                CertificateFactory cca_continue = this.Cardinal.cca_continue("X.509");
                while (true) {
                    Certificate generateCertificate = cca_continue.generateCertificate(bufferedInputStream);
                    if (generateCertificate == null) {
                        break;
                    }
                    this.init.add(generateCertificate);
                }
            } else {
                setLocationDataConsentGiven cca_continue2 = new getUiType(inputStream).cca_continue();
                if (cca_continue2 instanceof setThreeDSRequestorAppURL) {
                    Enumeration cca_continue3 = ((setThreeDSRequestorAppURL) cca_continue2).cca_continue();
                    this.init = new ArrayList();
                    CertificateFactory cca_continue4 = this.Cardinal.cca_continue("X.509");
                    while (cca_continue3.hasMoreElements()) {
                        this.init.add(0, cca_continue4.generateCertificate(new ByteArrayInputStream(((getProxyAddress) cca_continue3.nextElement()).values().init(ASN1Encoding.DER))));
                    }
                } else {
                    throw new CertificateException("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");
                }
            }
            this.init = cca_continue(this.init);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("IOException throw while decoding CertPath:\n");
            sb.append(e.toString());
            throw new CertificateException(sb.toString());
        } catch (NoSuchProviderException e2) {
            StringBuilder sb2 = new StringBuilder("BouncyCastle provider not found while trying to get a CertificateFactory:\n");
            sb2.append(e2.toString());
            throw new CertificateException(sb2.toString());
        }
    }

    PKIXCertPath(List list) {
        super("X.509");
        this.init = cca_continue((List) new ArrayList(list));
    }

    private static setLocationDataConsentGiven Cardinal(X509Certificate x509Certificate) throws CertificateEncodingException {
        try {
            return new getUiType(x509Certificate.getEncoded()).cca_continue();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Exception while encoding certificate: ");
            sb.append(e.toString());
            throw new CertificateEncodingException(sb.toString());
        }
    }

    private static List cca_continue(List list) {
        boolean z;
        boolean z2;
        if (list.size() < 2) {
            return list;
        }
        X500Principal issuerX500Principal = ((X509Certificate) list.get(0)).getIssuerX500Principal();
        int i = 1;
        while (true) {
            if (i != list.size()) {
                if (!issuerX500Principal.equals(((X509Certificate) list.get(i)).getSubjectX500Principal())) {
                    z = false;
                    break;
                }
                issuerX500Principal = ((X509Certificate) list.get(i)).getIssuerX500Principal();
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            int i3 = 0;
            while (true) {
                if (i3 == list.size()) {
                    z2 = false;
                    break;
                } else if (((X509Certificate) list.get(i3)).getIssuerX500Principal().equals(subjectX500Principal)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z2) {
                arrayList.add(x509Certificate);
                list.remove(i2);
            }
        }
        if (arrayList.size() > 1) {
            return arrayList2;
        }
        for (int i4 = 0; i4 != arrayList.size(); i4++) {
            X500Principal issuerX500Principal2 = ((X509Certificate) arrayList.get(i4)).getIssuerX500Principal();
            int i5 = 0;
            while (true) {
                if (i5 >= list.size()) {
                    break;
                }
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i5);
                if (issuerX500Principal2.equals(x509Certificate2.getSubjectX500Principal())) {
                    arrayList.add(x509Certificate2);
                    list.remove(i5);
                    break;
                }
                i5++;
            }
        }
        return list.size() > 0 ? arrayList2 : arrayList;
    }

    private static byte[] cca_continue(getProxyAddress getproxyaddress) throws CertificateEncodingException {
        try {
            return getproxyaddress.values().init(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CertificateEncodingException("Exception thrown: ".concat(String.valueOf(e)));
        }
    }

    public List getCertificates() {
        return Collections.unmodifiableList(new ArrayList(this.init));
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        Iterator<String> encodings = getEncodings();
        if (!encodings.hasNext()) {
            return null;
        }
        String next = encodings.next();
        if (next instanceof String) {
            return getEncoded(next);
        }
        return null;
    }

    public Iterator getEncodings() {
        return getInstance.iterator();
    }

    public byte[] getEncoded(String str) throws CertificateEncodingException {
        if (str.equalsIgnoreCase("PkiPath")) {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            List list = this.init;
            ListIterator listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                setforegroundtintblendmode.cca_continue.addElement(Cardinal((X509Certificate) listIterator.previous()));
            }
            return cca_continue((getProxyAddress) new GOST(setforegroundtintblendmode));
        }
        int i = 0;
        if (str.equalsIgnoreCase("PKCS7")) {
            KeyAgreementSpi.MQVwithSHA512CKDF mQVwithSHA512CKDF = new KeyAgreementSpi.MQVwithSHA512CKDF(KeyFactorySpi.setUiType, (getProxyAddress) null);
            setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
            while (i != this.init.size()) {
                setforegroundtintblendmode2.cca_continue.addElement(Cardinal((X509Certificate) this.init.get(i)));
                i++;
            }
            return cca_continue((getProxyAddress) new KeyAgreementSpi.MQVwithSHA512CKDF(KeyFactorySpi.isEnableDFSync, new DSASigner.detDSA(new setProxyAddress(1), new GOST.Mappings(), mQVwithSHA512CKDF, new GOST.Mappings(setforegroundtintblendmode2), new GOST.Mappings())));
        } else if (str.equalsIgnoreCase("PEM")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            setViewTranslationCallback setviewtranslationcallback = new setViewTranslationCallback(new OutputStreamWriter(byteArrayOutputStream));
            while (i != this.init.size()) {
                try {
                    setviewtranslationcallback.configure(new PemObject("CERTIFICATE", ((X509Certificate) this.init.get(i)).getEncoded()));
                    i++;
                } catch (Exception unused) {
                    throw new CertificateEncodingException("can't encode certificate for PEM encoded path");
                }
            }
            setviewtranslationcallback.close();
            return byteArrayOutputStream.toByteArray();
        } else {
            throw new CertificateEncodingException("unsupported encoding: ".concat(String.valueOf(str)));
        }
    }
}
