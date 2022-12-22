package com.cardinalcommerce.p060a;

import com.appsflyer.AppsFlyerLibCore;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.C1943EC;
import com.cardinalcommerce.p060a.C1944GM;
import com.cardinalcommerce.p060a.DSA;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.ElGamal;
import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.IES;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.RSA;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.didi.raven.config.RavenConstants;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.xpanel.xcard.ParseHelper;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.asn1.ASN1Encoding;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.DSASigner */
public final class DSASigner extends getThreeDSRequestorAppURL {
    public BigInteger Cardinal;
    public BigInteger CardinalError;

    /* renamed from: a */
    private BigInteger f2355a;

    /* renamed from: b */
    private setThreeDSRequestorAppURL f2356b;
    public BigInteger cca_continue;
    public BigInteger cleanup;
    public BigInteger configure;
    public BigInteger getInstance;
    public BigInteger init;
    public BigInteger values;

    public DSASigner(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.f2356b = null;
        this.f2355a = BigInteger.valueOf(0);
        this.cca_continue = bigInteger;
        this.configure = bigInteger2;
        this.getInstance = bigInteger3;
        this.init = bigInteger4;
        this.Cardinal = bigInteger5;
        this.cleanup = bigInteger6;
        this.values = bigInteger7;
        this.CardinalError = bigInteger8;
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSA */
    public final class detDSA extends getThreeDSRequestorAppURL implements KeyFactorySpi {
        private setProxyAddress ASN1ObjectIdentifier;
        private isEnableLogging CardinalInitService;
        private isEnableLogging CardinalValidateReceiver;
        public isEnableLogging getErrorDescription;
        public isEnableLogging getPayment;
        private KeyAgreementSpi.MQVwithSHA512CKDF onValidated;

        public detDSA(setProxyAddress setproxyaddress, isEnableLogging isenablelogging, KeyAgreementSpi.MQVwithSHA512CKDF mQVwithSHA512CKDF, isEnableLogging isenablelogging2, isEnableLogging isenablelogging3) {
            this.ASN1ObjectIdentifier = setproxyaddress;
            this.CardinalInitService = isenablelogging;
            this.onValidated = mQVwithSHA512CKDF;
            this.getPayment = isenablelogging2;
            this.getErrorDescription = null;
            this.CardinalValidateReceiver = isenablelogging3;
        }

        public static detDSA getInstance(Object obj) {
            if (obj != null) {
                return new detDSA(setThreeDSRequestorAppURL.cca_continue(obj));
            }
            return null;
        }

        private detDSA(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            Enumeration cca_continue = setthreedsrequestorappurl.cca_continue();
            this.ASN1ObjectIdentifier = (setProxyAddress) cca_continue.nextElement();
            this.CardinalInitService = (isEnableLogging) cca_continue.nextElement();
            Object nextElement = cca_continue.nextElement();
            this.onValidated = nextElement instanceof KeyAgreementSpi.MQVwithSHA512CKDF ? (KeyAgreementSpi.MQVwithSHA512CKDF) nextElement : nextElement != null ? new KeyAgreementSpi.MQVwithSHA512CKDF(setThreeDSRequestorAppURL.cca_continue(nextElement)) : null;
            while (cca_continue.hasMoreElements()) {
                setLocationDataConsentGiven setlocationdataconsentgiven = (setLocationDataConsentGiven) cca_continue.nextElement();
                if (setlocationdataconsentgiven instanceof getType) {
                    getType gettype = (getType) setlocationdataconsentgiven;
                    int i = gettype.Cardinal;
                    if (i == 0) {
                        this.getPayment = isEnableLogging.cca_continue(gettype);
                    } else if (i == 1) {
                        this.getErrorDescription = isEnableLogging.cca_continue(gettype);
                    } else {
                        StringBuilder sb = new StringBuilder("unknown tag value ");
                        sb.append(gettype.Cardinal);
                        throw new IllegalArgumentException(sb.toString());
                    }
                } else {
                    this.CardinalValidateReceiver = (isEnableLogging) setlocationdataconsentgiven;
                }
            }
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.ASN1ObjectIdentifier);
            setforegroundtintblendmode.cca_continue.addElement(this.CardinalInitService);
            setforegroundtintblendmode.cca_continue.addElement(this.onValidated);
            isEnableLogging isenablelogging = this.getPayment;
            if (isenablelogging != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 0, isenablelogging));
            }
            isEnableLogging isenablelogging2 = this.getErrorDescription;
            if (isenablelogging2 != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 1, isenablelogging2));
            }
            setforegroundtintblendmode.cca_continue.addElement(this.CardinalValidateReceiver);
            return new ValidateResponse(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSA224 */
    public interface detDSA224 {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier(getInstance, "1.1.2");
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(CardinalRenderType, "2");
        public static final ASN1ObjectIdentifier CardinalEnvironment;
        public static final ASN1ObjectIdentifier CardinalError;
        public static final ASN1ObjectIdentifier CardinalRenderType;
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(CardinalRenderType, "3");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(getInstance, "1.2.3");
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(getInstance, RavenConstants.SDK_VERSION);
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(getInstance, "1.3.3");
        public static final ASN1ObjectIdentifier getWarnings;
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier(getInstance, ParseHelper.XCARD_VERSION);
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(getInstance, "2.1.1"), "1");
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(CardinalError, "2");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("1.2.643.7"), "1");
            getInstance = aSN1ObjectIdentifier;
            configure = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1.2.2");
            new ASN1ObjectIdentifier(getInstance, "1.4.1");
            new ASN1ObjectIdentifier(getInstance, "1.4.2");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(getInstance, "1.6");
            CardinalError = aSN1ObjectIdentifier2;
            getWarnings = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(getInstance, "2.1.2");
            CardinalRenderType = aSN1ObjectIdentifier3;
            CardinalEnvironment = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
            new ASN1ObjectIdentifier(getInstance, "2.5.1.1");
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSA256 */
    public final class detDSA256 {
        private static KeyAgreementSpi.DHC Cardinal = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC");
                BigInteger cca_continue3 = detDSA256.cca_continue("E87579C11079F43DD824993C2CEE5ED3");
                byte[] instance = setTextDirection.getInstance("000E0D4D696E6768756151750CC03A4473D03679");
                BigInteger cca_continue4 = detDSA256.cca_continue("FFFFFFFE0000000075A30D1B9038A115");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04161FF7528B899B2D0C28607CA52C5B86CF5AC8395BAFEB13C02DA292DDED7A83")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC CardinalActionCode = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                BigInteger cca_continue2 = detDSA256.cca_continue("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC");
                BigInteger cca_continue3 = detDSA256.cca_continue("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00");
                byte[] instance = setTextDirection.getInstance("D09E8800291CB85396CC6717393284AAA0DA64BA");
                BigInteger cca_continue4 = detDSA256.cca_continue("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0400C6858E06B70404E9CD9E3ECB662395B4429C648139053FB521F828AF606B4D3DBAA14B5E77EFE75928FE1DC127A2FFA8DE3348B3C1856A429BF97E7E31C2E5BD66011839296A789A3BC0045C8A5FB42C7D1BD998F54449579B446817AFBD17273E662C97EE72995EF42640C550B9013FAD0761353C7086A272C24088BE94769FD16650")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC CardinalConfigurationParameters = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("03E5A88919D7CAFCBF415F07C2176573B2");
                BigInteger cca_continue2 = detDSA256.cca_continue("04B8266A46C55657AC734CE38F018F2192");
                byte[] instance = setTextDirection.getInstance("985BD3ADBAD4D696E676875615175A21B43A97E3");
                BigInteger cca_continue3 = detDSA256.cca_continue("0400000000000000016954A233049BA98F");
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(131, 2, 3, 8, cca_continue, cca_continue2, cca_continue3, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("040356DCD8F2F95031AD652D23951BB366A80648F06D867940A5366D9E265DE9EB240F")), cca_continue3, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC CardinalEnvironment = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F");
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(7);
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141");
                BigInteger valueOf2 = BigInteger.valueOf(1);
                BigInteger bigInteger2 = new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16);
                new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16);
                getSDKAppID cca_continue3 = detDSA256.cca_continue(new getSDKAppID.C2008init(cca_continue, bigInteger, valueOf, cca_continue2, valueOf2), new setOnDragListener(bigInteger2, new BigInteger[]{new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16), new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16)}, new BigInteger[]{new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16), new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16)}, new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16), new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16), 272));
                return new KeyAgreementSpi.C1970DH(cca_continue3, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue3, setTextDirection.getInstance("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")), cca_continue2, valueOf2, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC CardinalError = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70");
                BigInteger cca_continue3 = detDSA256.cca_continue("B4E134D3FB59EB8BAB57274904664D5AF50388BA");
                byte[] instance = setTextDirection.getInstance("B99B99B099B323E02709A4D696E6768756151751");
                BigInteger cca_continue4 = detDSA256.cca_continue("0100000000000000000000351EE786A818F3A1A16B");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0452DCB034293A117E1F4FF11B30F7199D3144CE6DFEAFFEF2E331F296E071FA0DF9982CFEA7D43F2E")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC CardinalRenderType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001");
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE");
                BigInteger cca_continue3 = detDSA256.cca_continue("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4");
                byte[] instance = setTextDirection.getInstance("BD71344799D5C7FCDC45B59FA3B9AB8F6A948BC5");
                BigInteger cca_continue4 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC CardinalUiType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF");
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC");
                BigInteger cca_continue3 = detDSA256.cca_continue("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF");
                byte[] instance = setTextDirection.getInstance("A335926AA319A27A1D00896A6773A4827ACDAC73");
                BigInteger cca_continue4 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB73617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC cca_continue = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF");
                BigInteger cca_continue2 = detDSA256.cca_continue("D6031998D1B3BBFEBF59CC9BBFF9AEE1");
                BigInteger cca_continue3 = detDSA256.cca_continue("5EEEFCA380D02919DC2C6558BB6D8A5D");
                byte[] instance = setTextDirection.getInstance("004D696E67687561517512D8F03431FCE63B88F4");
                BigInteger cca_continue4 = detDSA256.cca_continue("3FFFFFFF7FFFFFFFBE0024720613B5A3");
                BigInteger valueOf = BigInteger.valueOf(4);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("047B6AA5D85E572983E6FB32A7CDEBC14027B6916A894D3AEE7106FE805FC34B44")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC cleanup = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF");
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC");
                BigInteger cca_continue3 = detDSA256.cca_continue("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45");
                byte[] instance = setTextDirection.getInstance("1053CDE42C14D696E67687561517533BF3F83345");
                BigInteger cca_continue4 = detDSA256.cca_continue("0100000000000000000001F4C8F927AED3CA752257");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("044A96B5688EF573284664698968C38BB913CBFC8223A628553168947D59DCC912042351377AC5FB32")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC configure = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("DB7C2ABF62E35E668076BEAD208B");
                BigInteger cca_continue2 = detDSA256.cca_continue("DB7C2ABF62E35E668076BEAD2088");
                BigInteger cca_continue3 = detDSA256.cca_continue("659EF8BA043916EEDE8911702B22");
                byte[] instance = setTextDirection.getInstance("00F50B028E4D696E676875615175290472783FB1");
                BigInteger cca_continue4 = detDSA256.cca_continue("DB7C2ABF62E35E7628DFAC6561C5");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0409487239995A5EE76B55F9C2F098A89CE5AF8724C0A23E0E0FF77500")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC getActionCode = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger valueOf2 = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("04000000000000000000020108A2E0CC0D99F8A5EF");
                BigInteger valueOf3 = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(163, 3, 6, 7, valueOf, valueOf2, cca_continue, valueOf3));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0402FE13C0537BBC11ACAA07D793DE4E6D5E5C94EEE80289070FB05D38FF58321F2E800536D538CCDAA3D9")), cca_continue, valueOf3, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC getChallengeTimeout = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("020A601907B8C953CA1481EB10512F78744A3205FD");
                byte[] instance = setTextDirection.getInstance("85E25BFE5C86226CDB12016F7553F9D0E693A268");
                BigInteger cca_continue2 = detDSA256.cca_continue("040000000000000000000292FE77E70C12A4234C33");
                BigInteger valueOf2 = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(163, 3, 6, 7, valueOf, cca_continue, cca_continue2, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0403F0EBA16286A2D57EA0991168D4994637E8343E3600D51FBC6C71A0094FA2CDD545B11C5C0C797324F1")), cca_continue2, valueOf2, instance);
            }
        };
        private static KeyAgreementSpi.DHC getEnvironment = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2");
                BigInteger cca_continue2 = detDSA256.cca_continue("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9");
                byte[] instance = setTextDirection.getInstance("24B7B137C8A14D696E6768756151756FD0DA2E5C");
                BigInteger cca_continue3 = detDSA256.cca_continue("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B");
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(163, 3, 6, 7, cca_continue, cca_continue2, cca_continue3, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("040369979697AB43897789566789567F787A7876A65400435EDB42EFAFB2989D51FEFCE3C80988F41FF883")), cca_continue3, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC getInstance = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73");
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(7);
                BigInteger cca_continue2 = detDSA256.cca_continue("0100000000000000000001B8FA16DFAB9ACA16B6B3");
                BigInteger valueOf2 = BigInteger.valueOf(1);
                BigInteger bigInteger2 = new BigInteger("9ba48cba5ebcb9b6bd33b92830b2a2e0e192f10a", 16);
                new BigInteger("c39c6c3b3a36d7701b9c71a1f5804ae5d0003f4", 16);
                getSDKAppID cca_continue3 = detDSA256.cca_continue(new getSDKAppID.C2008init(cca_continue, bigInteger, valueOf, cca_continue2, valueOf2), new setOnDragListener(bigInteger2, new BigInteger[]{new BigInteger("9162fbe73984472a0a9e", 16), new BigInteger("-96341f1138933bc2f505", 16)}, new BigInteger[]{new BigInteger("127971af8721782ecffa3", 16), new BigInteger("9162fbe73984472a0a9e", 16)}, new BigInteger("9162fbe73984472a0a9d0590", 16), new BigInteger("96341f1138933bc2f503fd44", 16), 176));
                return new KeyAgreementSpi.C1970DH(cca_continue3, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue3, setTextDirection.getInstance("043B4C382CE37AA192A4019E763036F4F5DD4D7EBB938CF935318FDCED6BC28286531733C3F03C4FEE")), cca_continue2, valueOf2, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC getProxyAddress = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01");
                BigInteger cca_continue2 = detDSA256.cca_continue("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814");
                byte[] instance = setTextDirection.getInstance("103FAEC74D696E676875615175777FC5B191EF30");
                BigInteger cca_continue3 = detDSA256.cca_continue("01000000000000000000000000C7F34A778F443ACC920EBA49");
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(193, 15, cca_continue, cca_continue2, cca_continue3, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0401F481BC5F0FF84A74AD6CDF6FDEF4BF6179625372D8C0C5E10025E399F2903712CCF3EA9E3A1AD17FB0B3201B6AF7CE1B05")), cca_continue3, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC getRenderType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD");
                byte[] instance = setTextDirection.getInstance("74D59FF07F6B413D0EA14B344B20A2DB049B50C3");
                BigInteger cca_continue2 = detDSA256.cca_continue("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7");
                BigInteger valueOf2 = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(233, 74, valueOf, cca_continue, cca_continue2, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0400FAC9DFCBAC8313BB2139F1BB755FEF65BC391F8B36F8F8EB7371FD558B01006A08A41903350678E58528BEBF8A0BEFF867A7CA36716F7E01F81052")), cca_continue2, valueOf2, instance);
            }
        };
        private static KeyAgreementSpi.DHC getRequestTimeout = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("07A11B09A76B562144418FF3FF8C2570B8");
                BigInteger cca_continue2 = detDSA256.cca_continue("0217C05610884B63B9C6C7291678F9D341");
                byte[] instance = setTextDirection.getInstance("4D696E676875615175985BD3ADBADA21B43A97E2");
                BigInteger cca_continue3 = detDSA256.cca_continue("0400000000000000023123953A9464B54D");
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(131, 2, 3, 8, cca_continue, cca_continue2, cca_continue3, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("040081BAF91FDF9833C40F9C181343638399078C6E7EA38C001F73C8134B1B4EF9E150")), cca_continue3, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC getSDKVersion = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37");
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(3);
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D");
                BigInteger valueOf2 = BigInteger.valueOf(1);
                BigInteger bigInteger2 = new BigInteger("bb85691939b869c1d087f601554b96b80cb4f55b35f433c2", 16);
                new BigInteger("3d84f26c12238d7b4f3d516613c1759033b1a5800175d0b1", 16);
                getSDKAppID cca_continue3 = detDSA256.cca_continue(new getSDKAppID.C2008init(cca_continue, bigInteger, valueOf, cca_continue2, valueOf2), new setOnDragListener(bigInteger2, new BigInteger[]{new BigInteger("71169be7330b3038edb025f1", 16), new BigInteger("-b3fb3400dec5c4adceb8655c", 16)}, new BigInteger[]{new BigInteger("12511cfe811d0f4e6bc688b4d", 16), new BigInteger("71169be7330b3038edb025f1", 16)}, new BigInteger("71169be7330b3038edb025f1d0f9", 16), new BigInteger("b3fb3400dec5c4adceb8655d4c94", 16), 208));
                return new KeyAgreementSpi.C1970DH(cca_continue3, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue3, setTextDirection.getInstance("04DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D")), cca_continue2, valueOf2, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC getString = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("003088250CA6E7C7FE649CE85820F7");
                BigInteger cca_continue2 = detDSA256.cca_continue("00E8BEE4D3E2260744188BE0E9C723");
                byte[] instance = setTextDirection.getInstance("10E723AB14D696E6768756151756FEBF8FCB49A9");
                BigInteger cca_continue3 = detDSA256.cca_continue("0100000000000000D9CCEC8A39E56F");
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(113, 9, cca_continue, cca_continue2, cca_continue3, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04009D73616F35F4AB1407D73562C10F00A52830277958EE84D1315ED31886")), cca_continue3, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC getThreeDSRequestorAppURL = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A");
                byte[] instance = setTextDirection.getInstance("2AA058F73A0E33AB486B0F610410C53A7F132310");
                BigInteger cca_continue2 = detDSA256.cca_continue("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47");
                BigInteger valueOf2 = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(571, 2, 5, 10, valueOf, cca_continue, cca_continue2, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("040303001D34B856296C16C0D40D3CD7750A93D1D2955FA80AA5F40FC8DB7B2ABDBDE53950F4C0D293CDD711A35B67FB1499AE60038614F1394ABFA3B4C850D927E1E7769C8EEC2D19037BF27342DA639B6DCCFFFEB73D69D78C6C27A6009CBBCA1980F8533921E8A684423E43BAB08A576291AF8F461BB2A8B3531D2F0485C19B16E2F1516E23DD3C1A4827AF1B8AC15B")), cca_continue2, valueOf2, instance);
            }
        };
        private static Hashtable getUICustomization = new Hashtable();
        private static KeyAgreementSpi.DHC getUiType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5");
                BigInteger valueOf2 = BigInteger.valueOf(4);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(239, 158, bigInteger, valueOf, cca_continue, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0429A0B6A887A983E9730988A68727A8B2D126C44CC2CC7B2A6555193035DC76310804F12E549BDB011C103089E73510ACB275FC312A5DC6B76553F0CA")), cca_continue, valueOf2, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC getWarnings = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF");
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC");
                BigInteger cca_continue3 = detDSA256.cca_continue("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1");
                byte[] instance = setTextDirection.getInstance("3045AE6FC8422F64ED579528D38120EAE12196D5");
                BigInteger cca_continue4 = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF101207192B95FFC8DA78631011ED6B24CDD573F977A11E794811")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC init = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("DB7C2ABF62E35E668076BEAD208B");
                BigInteger cca_continue2 = detDSA256.cca_continue("6127C24C05F38A0AAAF65C0EF02C");
                BigInteger cca_continue3 = detDSA256.cca_continue("51DEF1815DB5ED74FCC34C85D709");
                byte[] instance = setTextDirection.getInstance("002757A1114D696E6768756151755316C05E0BD4");
                BigInteger cca_continue4 = detDSA256.cca_continue("36DF0AAFD8B8D7597CA10520D04B");
                BigInteger valueOf = BigInteger.valueOf(4);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("044BA30AB5E892B4E1649DD0928643ADCD46F5882E3747DEF36E956E97")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC isEnableDFSync = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001");
                BigInteger valueOf2 = BigInteger.valueOf(4);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(571, 2, 5, 10, bigInteger, valueOf, cca_continue, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04026EB7A859923FBC82189631F8103FE4AC9CA2970012D5D46024804801841CA44370958493B205E647DA304DB4CEB08CBBD1BA39494776FB988B47174DCA88C7E2945283A01C89720349DC807F4FBF374F4AEADE3BCA95314DD58CEC9F307A54FFC61EFC006D8A2C9D4979C0AC44AEA74FBEBBB9F772AEDCB620B01A7BA7AF1B320430C8591984F601CD4C143EF1C7A3")), cca_continue, valueOf2, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC setChallengeTimeout = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF");
                BigInteger valueOf2 = BigInteger.valueOf(4);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(233, 74, bigInteger, valueOf, cca_continue, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04017232BA853A7E731AF129F22FF4149563A419C26BF50A4C9D6EEFAD612601DB537DECE819B7F70F555A67C427A8CD9BF18AEB9B56E0C11056FAE6A3")), cca_continue, valueOf2, (byte[]) null);
            }
        };
        private static Hashtable setEnableDFSync = new Hashtable();
        private static KeyAgreementSpi.DHC setEnvironment = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B");
                BigInteger cca_continue2 = detDSA256.cca_continue("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE");
                byte[] instance = setTextDirection.getInstance("10B7B4D696E676875615175137C8A16FD0DA2211");
                BigInteger cca_continue3 = detDSA256.cca_continue("010000000000000000000000015AAB561B005413CCD4EE99D5");
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(193, 15, cca_continue, cca_continue2, cca_continue3, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0400D9B67D192E0367C803F39E1A7E82CA14A651350AAE617E8F01CE94335607C304AC29E7DEFBD9CA01F596F927224CDECF6C")), cca_continue3, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC setProxyAddress = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("027B680AC8B8596DA5A4AF8A19A0303FCA97FD7645309FA2A581485AF6263E313B79A2F5");
                byte[] instance = setTextDirection.getInstance("77E2B07370EB0F832A6DD5B62DFC88CD06BB84BE");
                BigInteger cca_continue2 = detDSA256.cca_continue("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEF90399660FC938A90165B042A7CEFADB307");
                BigInteger valueOf2 = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(283, 5, 7, 12, valueOf, cca_continue, cca_continue2, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0405F939258DB7DD90E1934F8C70B0DFEC2EED25B8557EAC9C80E2E198F8CDBECD86B1205303676854FE24141CB98FE6D4B20D02B4516FF702350EDDB0826779C813F0DF45BE8112F4")), cca_continue2, valueOf2, instance);
            }
        };
        private static KeyAgreementSpi.DHC setRenderType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61");
                BigInteger valueOf2 = BigInteger.valueOf(4);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(283, 5, 7, 12, bigInteger, valueOf, cca_continue, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("040503213F78CA44883F1A3B8162F188E553CD265F23C1567A16876913B0C2AC245849283601CCDA380F1C9E318D90F95D07E5426FE87E45C0E8184698E45962364E34116177DD2259")), cca_continue, valueOf2, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC setRequestTimeout = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("00689918DBEC7E5A0DD6DFC0AA55C7");
                BigInteger cca_continue2 = detDSA256.cca_continue("0095E9A9EC9B297BD4BF36E059184F");
                byte[] instance = setTextDirection.getInstance("10C0FB15760860DEF1EEF4D696E676875615175D");
                BigInteger cca_continue3 = detDSA256.cca_continue("010000000000000108789B2496AF93");
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(113, 9, cca_continue, cca_continue2, cca_continue3, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("0401A57A6A7B26CA5EF52FCDB816479700B3ADC94ED1FE674C06E695BABA1D")), cca_continue3, valueOf, instance);
            }
        };
        private static Hashtable setThreeDSRequestorAppURL = new Hashtable();
        private static KeyAgreementSpi.DHC setUICustomization = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F");
                byte[] instance = setTextDirection.getInstance("4099B5A457F9D69F79213D094C4BCD4D4262210B");
                BigInteger cca_continue2 = detDSA256.cca_continue("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173");
                BigInteger valueOf2 = BigInteger.valueOf(2);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(409, 87, valueOf, cca_continue, cca_continue2, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("04015D4860D088DDB3496B0C6064756260441CDE4AF1771D4DB01FFE5B34E59703DC255A868A1180515603AEAB60794E54BB7996A70061B1CFAB6BE5F32BBFA78324ED106A7636B9C5A7BD198D0158AA4F5488D08F38514F1FDF4B4F40D2181B3681C364BA0273C706")), cca_continue2, valueOf2, instance);
            }
        };
        private static KeyAgreementSpi.DHC setUiType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(1);
                BigInteger cca_continue = detDSA256.cca_continue("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF");
                BigInteger valueOf2 = BigInteger.valueOf(4);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.cca_continue(409, 87, bigInteger, valueOf, cca_continue, valueOf2));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("040060F05F658F49C1AD3AB1890F7184210EFD0987E307C84C27ACCFB8F9F67CC2C460189EB5AAAA62EE222EB1B35540CFE902374601E369050B7C4E42ACBA1DACBF04299C3460782F918EA427E6325165E9EA10E3DA5F6C42E9C55215AA9CA27A5863EC48D8E0286B")), cca_continue, valueOf2, (byte[]) null);
            }
        };
        private static KeyAgreementSpi.DHC valueOf = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF");
                BigInteger cca_continue2 = detDSA256.cca_continue("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC");
                BigInteger cca_continue3 = detDSA256.cca_continue("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B");
                byte[] instance = setTextDirection.getInstance("C49D360886E704936A6678E1139D26B7819F7E90");
                BigInteger cca_continue4 = detDSA256.cca_continue("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID init = detDSA256.init((getSDKAppID) new getSDKAppID.C2008init(cca_continue, cca_continue2, cca_continue3, cca_continue4, valueOf));
                return new KeyAgreementSpi.C1970DH(init, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(init, setTextDirection.getInstance("046B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C2964FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5")), cca_continue4, valueOf, instance);
            }
        };
        private static KeyAgreementSpi.DHC values = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger cca_continue = detDSA256.cca_continue("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D");
                BigInteger bigInteger = getSDKReferenceNumber.CardinalError;
                BigInteger valueOf = BigInteger.valueOf(5);
                BigInteger cca_continue2 = detDSA256.cca_continue("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7");
                BigInteger valueOf2 = BigInteger.valueOf(1);
                BigInteger bigInteger2 = new BigInteger("fe0e87005b4e83761908c5131d552a850b3f58b749c37cf5b84d6768", 16);
                new BigInteger("60dcd2104c4cbc0be6eeefc2bdd610739ec34e317f9b33046c9e4788", 16);
                getSDKAppID cca_continue3 = detDSA256.cca_continue(new getSDKAppID.C2008init(cca_continue, bigInteger, valueOf, cca_continue2, valueOf2), new setOnDragListener(bigInteger2, new BigInteger[]{new BigInteger("6b8cf07d4ca75c88957d9d670591", 16), new BigInteger("-b8adf1378a6eb73409fa6c9c637d", 16)}, new BigInteger[]{new BigInteger("1243ae1b4d71613bc9f780a03690e", 16), new BigInteger("6b8cf07d4ca75c88957d9d670591", 16)}, new BigInteger("6b8cf07d4ca75c88957d9d67059037a4", 16), new BigInteger("b8adf1378a6eb73409fa6c9c637ba7f5", 16), 240));
                return new KeyAgreementSpi.C1970DH(cca_continue3, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue3, setTextDirection.getInstance("04A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5")), cca_continue2, valueOf2, (byte[]) null);
            }
        };

        public static ASN1ObjectIdentifier Cardinal(String str) {
            return (ASN1ObjectIdentifier) setEnableDFSync.get(setAnimation.getInstance(str));
        }

        public static Enumeration configure() {
            return setThreeDSRequestorAppURL.elements();
        }

        public static KeyAgreementSpi.C1970DH getInstance(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            KeyAgreementSpi.DHC dhc = (KeyAgreementSpi.DHC) getUICustomization.get(aSN1ObjectIdentifier);
            if (dhc == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        static /* synthetic */ getSDKAppID init(getSDKAppID getsdkappid) {
            return getsdkappid;
        }

        public static String init(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (String) setThreeDSRequestorAppURL.get(aSN1ObjectIdentifier);
        }

        public static KeyAgreementSpi.C1970DH init(String str) {
            KeyAgreementSpi.DHC dhc;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) setEnableDFSync.get(setAnimation.getInstance(str));
            if (aSN1ObjectIdentifier == null || (dhc = (KeyAgreementSpi.DHC) getUICustomization.get(aSN1ObjectIdentifier)) == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        static /* synthetic */ BigInteger cca_continue(String str) {
            return new BigInteger(1, setTextDirection.getInstance(str));
        }

        static /* synthetic */ getSDKAppID cca_continue(getSDKAppID getsdkappid, setOnDragListener setondraglistener) {
            getSDKAppID.C2007configure cca_continue2 = getsdkappid.cca_continue();
            cca_continue2.init = new setOnKeyListener(getsdkappid, setondraglistener);
            return cca_continue2.cca_continue();
        }

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = detDSASha3_224.getSDKVersion;
            KeyAgreementSpi.DHC dhc = configure;
            setEnableDFSync.put("secp112r1", aSN1ObjectIdentifier);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier, "secp112r1");
            getUICustomization.put(aSN1ObjectIdentifier, dhc);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = detDSASha3_224.cleanup;
            KeyAgreementSpi.DHC dhc2 = init;
            setEnableDFSync.put("secp112r2", aSN1ObjectIdentifier2);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier2, "secp112r2");
            getUICustomization.put(aSN1ObjectIdentifier2, dhc2);
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = detDSASha3_224.getProxyAddress;
            KeyAgreementSpi.DHC dhc3 = Cardinal;
            setEnableDFSync.put("secp128r1", aSN1ObjectIdentifier3);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier3, "secp128r1");
            getUICustomization.put(aSN1ObjectIdentifier3, dhc3);
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = detDSASha3_224.getChallengeTimeout;
            KeyAgreementSpi.DHC dhc4 = cca_continue;
            setEnableDFSync.put("secp128r2", aSN1ObjectIdentifier4);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier4, "secp128r2");
            getUICustomization.put(aSN1ObjectIdentifier4, dhc4);
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = detDSASha3_224.getWarnings;
            KeyAgreementSpi.DHC dhc5 = getInstance;
            setEnableDFSync.put("secp160k1", aSN1ObjectIdentifier5);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier5, "secp160k1");
            getUICustomization.put(aSN1ObjectIdentifier5, dhc5);
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = detDSASha3_224.CardinalError;
            KeyAgreementSpi.DHC dhc6 = cleanup;
            setEnableDFSync.put("secp160r1", aSN1ObjectIdentifier6);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier6, "secp160r1");
            getUICustomization.put(aSN1ObjectIdentifier6, dhc6);
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = detDSASha3_224.setChallengeTimeout;
            KeyAgreementSpi.DHC dhc7 = CardinalError;
            setEnableDFSync.put("secp160r2", aSN1ObjectIdentifier7);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier7, "secp160r2");
            getUICustomization.put(aSN1ObjectIdentifier7, dhc7);
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = detDSASha3_224.setEnvironment;
            KeyAgreementSpi.DHC dhc8 = getSDKVersion;
            setEnableDFSync.put("secp192k1", aSN1ObjectIdentifier8);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier8, "secp192k1");
            getUICustomization.put(aSN1ObjectIdentifier8, dhc8);
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = detDSASha3_224.getThreeDSRequestorAppURL;
            KeyAgreementSpi.DHC dhc9 = getWarnings;
            setEnableDFSync.put("secp192r1", aSN1ObjectIdentifier9);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier9, "secp192r1");
            getUICustomization.put(aSN1ObjectIdentifier9, dhc9);
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = detDSASha3_224.getEnvironment;
            KeyAgreementSpi.DHC dhc10 = values;
            setEnableDFSync.put("secp224k1", aSN1ObjectIdentifier10);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier10, "secp224k1");
            getUICustomization.put(aSN1ObjectIdentifier10, dhc10);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = detDSASha3_224.getRenderType;
            KeyAgreementSpi.DHC dhc11 = CardinalRenderType;
            setEnableDFSync.put("secp224r1", aSN1ObjectIdentifier11);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier11, "secp224r1");
            getUICustomization.put(aSN1ObjectIdentifier11, dhc11);
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = detDSASha3_224.CardinalRenderType;
            KeyAgreementSpi.DHC dhc12 = CardinalEnvironment;
            setEnableDFSync.put("secp256k1", aSN1ObjectIdentifier12);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier12, "secp256k1");
            getUICustomization.put(aSN1ObjectIdentifier12, dhc12);
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = detDSASha3_224.isEnableDFSync;
            KeyAgreementSpi.DHC dhc13 = valueOf;
            setEnableDFSync.put("secp256r1", aSN1ObjectIdentifier13);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier13, "secp256r1");
            getUICustomization.put(aSN1ObjectIdentifier13, dhc13);
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = detDSASha3_224.getUiType;
            KeyAgreementSpi.DHC dhc14 = CardinalUiType;
            setEnableDFSync.put("secp384r1", aSN1ObjectIdentifier14);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier14, "secp384r1");
            getUICustomization.put(aSN1ObjectIdentifier14, dhc14);
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = detDSASha3_224.setRenderType;
            KeyAgreementSpi.DHC dhc15 = CardinalActionCode;
            setEnableDFSync.put("secp521r1", aSN1ObjectIdentifier15);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier15, "secp521r1");
            getUICustomization.put(aSN1ObjectIdentifier15, dhc15);
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = detDSASha3_224.init;
            KeyAgreementSpi.DHC dhc16 = getString;
            setEnableDFSync.put("sect113r1", aSN1ObjectIdentifier16);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier16, "sect113r1");
            getUICustomization.put(aSN1ObjectIdentifier16, dhc16);
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = detDSASha3_224.values;
            KeyAgreementSpi.DHC dhc17 = setRequestTimeout;
            setEnableDFSync.put("sect113r2", aSN1ObjectIdentifier17);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier17, "sect113r2");
            getUICustomization.put(aSN1ObjectIdentifier17, dhc17);
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = detDSASha3_224.CardinalUiType;
            KeyAgreementSpi.DHC dhc18 = getRequestTimeout;
            setEnableDFSync.put("sect131r1", aSN1ObjectIdentifier18);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier18, "sect131r1");
            getUICustomization.put(aSN1ObjectIdentifier18, dhc18);
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = detDSASha3_224.getString;
            KeyAgreementSpi.DHC dhc19 = CardinalConfigurationParameters;
            setEnableDFSync.put("sect131r2", aSN1ObjectIdentifier19);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier19, "sect131r2");
            getUICustomization.put(aSN1ObjectIdentifier19, dhc19);
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = detDSASha3_224.Cardinal;
            KeyAgreementSpi.DHC dhc20 = getActionCode;
            setEnableDFSync.put("sect163k1", aSN1ObjectIdentifier20);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier20, "sect163k1");
            getUICustomization.put(aSN1ObjectIdentifier20, dhc20);
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = detDSASha3_224.cca_continue;
            KeyAgreementSpi.DHC dhc21 = getEnvironment;
            setEnableDFSync.put("sect163r1", aSN1ObjectIdentifier21);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier21, "sect163r1");
            getUICustomization.put(aSN1ObjectIdentifier21, dhc21);
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = detDSASha3_224.valueOf;
            KeyAgreementSpi.DHC dhc22 = getChallengeTimeout;
            setEnableDFSync.put("sect163r2", aSN1ObjectIdentifier22);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier22, "sect163r2");
            getUICustomization.put(aSN1ObjectIdentifier22, dhc22);
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = detDSASha3_224.CardinalConfigurationParameters;
            KeyAgreementSpi.DHC dhc23 = getProxyAddress;
            setEnableDFSync.put("sect193r1", aSN1ObjectIdentifier23);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier23, "sect193r1");
            getUICustomization.put(aSN1ObjectIdentifier23, dhc23);
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = detDSASha3_224.setRequestTimeout;
            KeyAgreementSpi.DHC dhc24 = setEnvironment;
            setEnableDFSync.put("sect193r2", aSN1ObjectIdentifier24);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier24, "sect193r2");
            getUICustomization.put(aSN1ObjectIdentifier24, dhc24);
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = detDSASha3_224.getRequestTimeout;
            KeyAgreementSpi.DHC dhc25 = setChallengeTimeout;
            setEnableDFSync.put("sect233k1", aSN1ObjectIdentifier25);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier25, "sect233k1");
            getUICustomization.put(aSN1ObjectIdentifier25, dhc25);
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = detDSASha3_224.getActionCode;
            KeyAgreementSpi.DHC dhc26 = getRenderType;
            setEnableDFSync.put("sect233r1", aSN1ObjectIdentifier26);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier26, "sect233r1");
            getUICustomization.put(aSN1ObjectIdentifier26, dhc26);
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = detDSASha3_224.getInstance;
            KeyAgreementSpi.DHC dhc27 = getUiType;
            setEnableDFSync.put("sect239k1", aSN1ObjectIdentifier27);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier27, "sect239k1");
            getUICustomization.put(aSN1ObjectIdentifier27, dhc27);
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = detDSASha3_224.CardinalEnvironment;
            KeyAgreementSpi.DHC dhc28 = setRenderType;
            setEnableDFSync.put("sect283k1", aSN1ObjectIdentifier28);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier28, "sect283k1");
            getUICustomization.put(aSN1ObjectIdentifier28, dhc28);
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = detDSASha3_224.CardinalActionCode;
            KeyAgreementSpi.DHC dhc29 = setProxyAddress;
            setEnableDFSync.put("sect283r1", aSN1ObjectIdentifier29);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier29, "sect283r1");
            getUICustomization.put(aSN1ObjectIdentifier29, dhc29);
            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = detDSASha3_224.setProxyAddress;
            KeyAgreementSpi.DHC dhc30 = setUiType;
            setEnableDFSync.put("sect409k1", aSN1ObjectIdentifier30);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier30, "sect409k1");
            getUICustomization.put(aSN1ObjectIdentifier30, dhc30);
            ASN1ObjectIdentifier aSN1ObjectIdentifier31 = detDSASha3_224.setUiType;
            KeyAgreementSpi.DHC dhc31 = setUICustomization;
            setEnableDFSync.put("sect409r1", aSN1ObjectIdentifier31);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier31, "sect409r1");
            getUICustomization.put(aSN1ObjectIdentifier31, dhc31);
            ASN1ObjectIdentifier aSN1ObjectIdentifier32 = detDSASha3_224.getUICustomization;
            KeyAgreementSpi.DHC dhc32 = isEnableDFSync;
            setEnableDFSync.put("sect571k1", aSN1ObjectIdentifier32);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier32, "sect571k1");
            getUICustomization.put(aSN1ObjectIdentifier32, dhc32);
            ASN1ObjectIdentifier aSN1ObjectIdentifier33 = detDSASha3_224.setEnableDFSync;
            KeyAgreementSpi.DHC dhc33 = getThreeDSRequestorAppURL;
            setEnableDFSync.put("sect571r1", aSN1ObjectIdentifier33);
            setThreeDSRequestorAppURL.put(aSN1ObjectIdentifier33, "sect571r1");
            getUICustomization.put(aSN1ObjectIdentifier33, dhc33);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSA384 */
    public final class detDSA384 {
        private static KeyAgreementSpi.DHC Cardinal = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("D7C134AA264366862A18302575D0FB98D116BC4B6DDEBCA3A5A7939F", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("D7C134AA264366862A18302575D1D787B09F075797DA89F57EC8C0FF", 16), new BigInteger("68A5E62CA9CE6C1C299803A6C1530B514E182AD8B0042A59CAD29F43", 16), new BigInteger("2580F63CCFE44138870713B1A92369E33E2135D266DBB372386C400B", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("040D9029AD2C7E5CF4340823B2A87DC68C9E4CE3174C1E6EFDEE12C07D58AA56F772C0726F24C6B89E4ECDAC24354B9E99CAA3F6D3761402CD")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC CardinalActionCode = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B31F166E6CAC0425A7CF3AB6AF6B7FC3103B883202E9046565", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC53", 16), new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC50", 16), new BigInteger("7F519EADA7BDA81BD826DBA647910F8C4B9346ED8CCDC64E4B1ABD11756DCE1D2074AA263B88805CED70355A33B471EE", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("0418DE98B02DB9A306F2AFCD7235F72A819B80AB12EBD653172476FECD462AABFFC4FF191B946A5F54D8D0AA2F418808CC25AB056962D30651A114AFD2755AD336747F93475B7A1FCA3B88F2B6A208CCFE469408584DC2B2912675BF5B9E582928")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC CardinalEnvironment = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B31F166E6CAC0425A7CF3AB6AF6B7FC3103B883202E9046565", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("8CB91E82A3386D280F5D6F7E50E641DF152F7109ED5456B412B1DA197FB71123ACD3A729901D1A71874700133107EC53", 16), new BigInteger("7BC382C63D8C150C3C72080ACE05AFA0C2BEA28E4FB22787139165EFBA91F90F8AA5814A503AD4EB04A8C7DD22CE2826", 16), new BigInteger("4A8C7DD22CE28268B39B55416F0447C2FB77DE107DCD2A62E880EA53EEB62D57CB4390295DBC9943AB78696FA504C11", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("041D1C64F068CF45FFA2A63A81B7C13F6B8847A3E77EF14FE3DB7FCAFE0CBD10E8E826E03436D646AAEF87B2E247D4AF1E8ABE1D7520F9C2A45CB1EB8E95CFD55262B70B29FEEC5864E19C054FF99129280E4646217791811142820341263C5315")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC CardinalError = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("D7C134AA264366862A18302575D0FB98D116BC4B6DDEBCA3A5A7939F", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("D7C134AA264366862A18302575D1D787B09F075797DA89F57EC8C0FF", 16), new BigInteger("D7C134AA264366862A18302575D1D787B09F075797DA89F57EC8C0FC", 16), new BigInteger("4B337D934104CD7BEF271BF60CED1ED20DA14C08B3BB64F18A60888D", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("046AB1E344CE25FF3896424E7FFE14762ECB49F8928AC0C76029B4D5800374E9F5143E568CD23F3F4D7C0D4B1E41C8CC0D1C6ABD5F1A46DB4C")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC CardinalRenderType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA70330870553E5C414CA92619418661197FAC10471DB1D381085DDADDB58796829CA90069", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA703308717D4D9B009BC66842AECDA12AE6A380E62881FF2F2D82C68528AA6056583A48F3", 16), new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA703308717D4D9B009BC66842AECDA12AE6A380E62881FF2F2D82C68528AA6056583A48F0", 16), new BigInteger("7CBBBCF9441CFAB76E1890E46884EAE321F70C0BCB4981527897504BEC3E36A62BCDFA2304976540F6450085F2DAE145C22553B465763689180EA2571867423E", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("04640ECE5C12788717B9C1BA06CBC2A6FEBA85842458C56DDE9DB1758D39C0313D82BA51735CDB3EA499AA77A7D6943A64F7A3F25FE26F06B51BAA2696FA9035DA5B534BD595F5AF0FA2C892376C84ACE1BB4E3019B71634C01131159CAE03CEE9D9932184BEEF216BD71DF2DADF86A627306ECFF96DBB8BACE198B61E00F8B332")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC CardinalUiType = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA70330870553E5C414CA92619418661197FAC10471DB1D381085DDADDB58796829CA90069", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("AADD9DB8DBE9C48B3FD4E6AE33C9FC07CB308DB3B3C9D20ED6639CCA703308717D4D9B009BC66842AECDA12AE6A380E62881FF2F2D82C68528AA6056583A48F3", 16), new BigInteger("7830A3318B603B89E2327145AC234CC594CBDD8D3DF91610A83441CAEA9863BC2DED5D5AA8253AA10A2EF1C98B9AC8B57F1117A72BF2C7B9E7C1AC4D77FC94CA", 16), new BigInteger("3DF91610A83441CAEA9863BC2DED5D5AA8253AA10A2EF1C98B9AC8B57F1117A72BF2C7B9E7C1AC4D77FC94CADC083E67984050B75EBAE5DD2809BD638016F723", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("0481AEE4BDD82ED9645A21322E9C4C6A9385ED9F70B5D916C1B43B62EEF4D0098EFF3B1F78E2D0D48D50D1687B93B97D5F7C6D5047406A5E688B352209BCB9F8227DDE385D566332ECC0EABFA9CF7822FDF209F70024A57B1AA000C55B881F8111B2DCDE494A5F485E5BCA4BD88A2763AED1CA2B2FA8F0540678CD1E0F3AD80892")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC cca_continue = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("C302F41D932A36CDA7A3462F9E9E916B5BE8F1029AC4ACC1", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("C302F41D932A36CDA7A3463093D18DB78FCE476DE1A86297", 16), new BigInteger("C302F41D932A36CDA7A3463093D18DB78FCE476DE1A86294", 16), new BigInteger("13D56FFAEC78681E68F9DEB43B35BEC2FB68542E27897B79", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("043AE9E58C82F63C30282E1FE7BBF43FA72C446AF6F4618129097E2C5667C2223A902AB5CA449D0084B7E5B3DE7CCC01C9")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC cleanup = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D718C397AA3B561A6F7901E0E82974856A7", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D726E3BF623D52620282013481D1F6E5377", 16), new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D726E3BF623D52620282013481D1F6E5374", 16), new BigInteger("662C61C430D84EA4FE66A7733D0B76B7BF93EBC4AF2F49256AE58101FEE92B04", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("04A3E8EB3CC1CFE7B7732213B23A656149AFA142C47AAFBC2B79A191562E1305F42D996C823439C56D7F7B22E14644417E69BCB6DE39D027001DABE8F35B25C9BE")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC configure = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("C302F41D932A36CDA7A3462F9E9E916B5BE8F1029AC4ACC1", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("C302F41D932A36CDA7A3463093D18DB78FCE476DE1A86297", 16), new BigInteger("6A91174076B1E0E19C39C031FE8685C1CAE040E5C69A28EF", 16), new BigInteger("469A28EF7C28CCA3DC721D044F4496BCCA7EF4146FBF25C9", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("04C0A0647EAAB6A48753B033C56CB0F0900A2F5C4853375FD614B690866ABD5BB88B5F4828C1490002E6773FA2FA299B8F")), bigInteger, bigInteger2);
            }
        };
        private static Hashtable getActionCode = new Hashtable();
        private static KeyAgreementSpi.DHC getInstance = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("E95E4A5F737059DC60DF5991D45029409E60FC09", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("E95E4A5F737059DC60DFC7AD95B3D8139515620F", 16), new BigInteger("E95E4A5F737059DC60DFC7AD95B3D8139515620C", 16), new BigInteger("7A556B6DAE535B7B51ED2C4D7DAA7A0B5C55F380", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("04B199B13B9B34EFC1397E64BAEB05ACC265FF2378ADD6718B7C7C1961F0991B842443772152C9E0AD")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC getSDKVersion = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D718C397AA3B561A6F7901E0E82974856A7", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("A9FB57DBA1EEA9BC3E660A909D838D726E3BF623D52620282013481D1F6E5377", 16), new BigInteger("7D5A0975FC2C3057EEF67530417AFFE7FB8055C126DC5C6CE94A4B44F330B5D9", 16), new BigInteger("26DC5C6CE94A4B44F330B5D9BBD77CBF958416295CF7E1CE6BCCDC18FF8C07B6", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("048BD2AEB9CB7E57CB2C4B482FFC81B7AFB9DE27E1E3BD23C23A4453BD9ACE3262547EF835C3DAC4FD97F8461A14611DC9C27745132DED8E545C1D54C72F046997")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC getWarnings = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA5B68F12A32D482EC7EE8658E98691555B44C59311", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA6F6F40DEF4F92B9EC7893EC28FCD412B1F1B32E27", 16), new BigInteger("3EE30B568FBAB0F883CCEBD46D3F3BB8A2A73513F5EB79DA66190EB085FFA9F492F375A97D860EB4", 16), new BigInteger("520883949DFDBC42D3AD198640688A6FE13F41349554B49ACC31DCCD884539816F5EB4AC8FB1F1A6", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("0443BD7E9AFB53D8B85289BCC48EE5BFE6F20137D10A087EB6E7871E2A10A599C710AF8D0D39E2061114FDD05545EC1CC8AB4093247F77275E0743FFED117182EAA9C77877AAAC6AC7D35245D1692E8EE1")), bigInteger, bigInteger2);
            }
        };
        private static KeyAgreementSpi.DHC init = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("E95E4A5F737059DC60DF5991D45029409E60FC09", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("E95E4A5F737059DC60DFC7AD95B3D8139515620F", 16), new BigInteger("340E7BE2A280EB74E2BE61BADA745D97E8F7C300", 16), new BigInteger("1E589A8595423412134FAA2DBDEC95C8D8675E58", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("04BED5AF16EA3F6A4F62938C4631EB5AF7BDBCDBC31667CB477A1A8EC338F94741669C976316DA6321")), bigInteger, bigInteger2);
            }
        };
        private static Hashtable setRequestTimeout = new Hashtable();
        private static Hashtable valueOf = new Hashtable();
        private static KeyAgreementSpi.DHC values = new KeyAgreementSpi.DHC() {
            public final KeyAgreementSpi.C1970DH init() {
                BigInteger bigInteger = new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA5B68F12A32D482EC7EE8658E98691555B44C59311", 16);
                BigInteger bigInteger2 = new BigInteger("01", 16);
                getSDKAppID cca_continue = detDSA384.cca_continue((getSDKAppID) new getSDKAppID.C2008init(new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA6F6F40DEF4F92B9EC7893EC28FCD412B1F1B32E27", 16), new BigInteger("D35E472036BC4FB7E13C785ED201E065F98FCFA6F6F40DEF4F92B9EC7893EC28FCD412B1F1B32E24", 16), new BigInteger("A7F561E038EB1ED560B3D147DB782013064C19F27ED27C6780AAF77FB8A547CEB5B4FEF422340353", 16), bigInteger, bigInteger2));
                return new KeyAgreementSpi.C1970DH(cca_continue, new KeyAgreementSpi.DHwithSHA224KDFAndSharedInfo(cca_continue, setTextDirection.getInstance("04925BE9FB01AFC6FB4D3E7D4990010F813408AB106C4F09CB7EE07868CC136FFF3357F624A21BED5263BA3A7A27483EBF6671DBEF7ABB30EBEE084E58A0B077AD42A5A0989D1EE71B1B9BC0455FB0D2C3")), bigInteger, bigInteger2);
            }
        };

        static /* synthetic */ getSDKAppID cca_continue(getSDKAppID getsdkappid) {
            return getsdkappid;
        }

        public static ASN1ObjectIdentifier cca_continue(String str) {
            return (ASN1ObjectIdentifier) valueOf.get(setAnimation.getInstance(str));
        }

        public static KeyAgreementSpi.C1970DH getInstance(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            KeyAgreementSpi.DHC dhc = (KeyAgreementSpi.DHC) getActionCode.get(aSN1ObjectIdentifier);
            if (dhc != null) {
                return dhc.cca_continue();
            }
            return null;
        }

        public static Enumeration getInstance() {
            return setRequestTimeout.elements();
        }

        public static String init(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (String) setRequestTimeout.get(aSN1ObjectIdentifier);
        }

        public static KeyAgreementSpi.C1970DH configure(String str) {
            KeyAgreementSpi.DHC dhc;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) valueOf.get(setAnimation.getInstance(str));
            if (aSN1ObjectIdentifier == null || (dhc = (KeyAgreementSpi.DHC) getActionCode.get(aSN1ObjectIdentifier)) == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = detDSA512.CardinalEnvironment;
            KeyAgreementSpi.DHC dhc = init;
            valueOf.put(setAnimation.getInstance("brainpoolP160r1"), aSN1ObjectIdentifier);
            setRequestTimeout.put(aSN1ObjectIdentifier, "brainpoolP160r1");
            getActionCode.put(aSN1ObjectIdentifier, dhc);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = detDSA512.CardinalUiType;
            KeyAgreementSpi.DHC dhc2 = getInstance;
            valueOf.put(setAnimation.getInstance("brainpoolP160t1"), aSN1ObjectIdentifier2);
            setRequestTimeout.put(aSN1ObjectIdentifier2, "brainpoolP160t1");
            getActionCode.put(aSN1ObjectIdentifier2, dhc2);
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = detDSA512.valueOf;
            KeyAgreementSpi.DHC dhc3 = configure;
            valueOf.put(setAnimation.getInstance("brainpoolP192r1"), aSN1ObjectIdentifier3);
            setRequestTimeout.put(aSN1ObjectIdentifier3, "brainpoolP192r1");
            getActionCode.put(aSN1ObjectIdentifier3, dhc3);
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = detDSA512.getRequestTimeout;
            KeyAgreementSpi.DHC dhc4 = cca_continue;
            valueOf.put(setAnimation.getInstance("brainpoolP192t1"), aSN1ObjectIdentifier4);
            setRequestTimeout.put(aSN1ObjectIdentifier4, "brainpoolP192t1");
            getActionCode.put(aSN1ObjectIdentifier4, dhc4);
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = detDSA512.getActionCode;
            KeyAgreementSpi.DHC dhc5 = Cardinal;
            valueOf.put(setAnimation.getInstance("brainpoolP224r1"), aSN1ObjectIdentifier5);
            setRequestTimeout.put(aSN1ObjectIdentifier5, "brainpoolP224r1");
            getActionCode.put(aSN1ObjectIdentifier5, dhc5);
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = detDSA512.CardinalConfigurationParameters;
            KeyAgreementSpi.DHC dhc6 = CardinalError;
            valueOf.put(setAnimation.getInstance("brainpoolP224t1"), aSN1ObjectIdentifier6);
            setRequestTimeout.put(aSN1ObjectIdentifier6, "brainpoolP224t1");
            getActionCode.put(aSN1ObjectIdentifier6, dhc6);
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = detDSA512.setRequestTimeout;
            KeyAgreementSpi.DHC dhc7 = getSDKVersion;
            valueOf.put(setAnimation.getInstance("brainpoolP256r1"), aSN1ObjectIdentifier7);
            setRequestTimeout.put(aSN1ObjectIdentifier7, "brainpoolP256r1");
            getActionCode.put(aSN1ObjectIdentifier7, dhc7);
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = detDSA512.getString;
            KeyAgreementSpi.DHC dhc8 = cleanup;
            valueOf.put(setAnimation.getInstance("brainpoolP256t1"), aSN1ObjectIdentifier8);
            setRequestTimeout.put(aSN1ObjectIdentifier8, "brainpoolP256t1");
            getActionCode.put(aSN1ObjectIdentifier8, dhc8);
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = detDSA512.getEnvironment;
            KeyAgreementSpi.DHC dhc9 = getWarnings;
            valueOf.put(setAnimation.getInstance("brainpoolP320r1"), aSN1ObjectIdentifier9);
            setRequestTimeout.put(aSN1ObjectIdentifier9, "brainpoolP320r1");
            getActionCode.put(aSN1ObjectIdentifier9, dhc9);
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = detDSA512.getProxyAddress;
            KeyAgreementSpi.DHC dhc10 = values;
            valueOf.put(setAnimation.getInstance("brainpoolP320t1"), aSN1ObjectIdentifier10);
            setRequestTimeout.put(aSN1ObjectIdentifier10, "brainpoolP320t1");
            getActionCode.put(aSN1ObjectIdentifier10, dhc10);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = detDSA512.setChallengeTimeout;
            KeyAgreementSpi.DHC dhc11 = CardinalEnvironment;
            valueOf.put(setAnimation.getInstance("brainpoolP384r1"), aSN1ObjectIdentifier11);
            setRequestTimeout.put(aSN1ObjectIdentifier11, "brainpoolP384r1");
            getActionCode.put(aSN1ObjectIdentifier11, dhc11);
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = detDSA512.getChallengeTimeout;
            KeyAgreementSpi.DHC dhc12 = CardinalActionCode;
            valueOf.put(setAnimation.getInstance("brainpoolP384t1"), aSN1ObjectIdentifier12);
            setRequestTimeout.put(aSN1ObjectIdentifier12, "brainpoolP384t1");
            getActionCode.put(aSN1ObjectIdentifier12, dhc12);
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = detDSA512.setEnvironment;
            KeyAgreementSpi.DHC dhc13 = CardinalUiType;
            valueOf.put(setAnimation.getInstance("brainpoolP512r1"), aSN1ObjectIdentifier13);
            setRequestTimeout.put(aSN1ObjectIdentifier13, "brainpoolP512r1");
            getActionCode.put(aSN1ObjectIdentifier13, dhc13);
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = detDSA512.getRenderType;
            KeyAgreementSpi.DHC dhc14 = CardinalRenderType;
            valueOf.put(setAnimation.getInstance("brainpoolP512t1"), aSN1ObjectIdentifier14);
            setRequestTimeout.put(aSN1ObjectIdentifier14, "brainpoolP512t1");
            getActionCode.put(aSN1ObjectIdentifier14, dhc14);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSA512 */
    public interface detDSA512 {
        public static final ASN1ObjectIdentifier Cardinal;
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(CardinalError, "2");
        public static final ASN1ObjectIdentifier CardinalConfigurationParameters = new ASN1ObjectIdentifier(CardinalRenderType, "6");
        public static final ASN1ObjectIdentifier CardinalEnvironment;
        public static final ASN1ObjectIdentifier CardinalError;
        public static final ASN1ObjectIdentifier CardinalRenderType;
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(CardinalRenderType, "2");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(getInstance, "2.2");
        public static final ASN1ObjectIdentifier cleanup;
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier getActionCode = new ASN1ObjectIdentifier(CardinalRenderType, "5");
        public static final ASN1ObjectIdentifier getChallengeTimeout = new ASN1ObjectIdentifier(CardinalRenderType, "12");
        public static final ASN1ObjectIdentifier getEnvironment = new ASN1ObjectIdentifier(CardinalRenderType, "9");
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier getProxyAddress = new ASN1ObjectIdentifier(CardinalRenderType, "10");
        public static final ASN1ObjectIdentifier getRenderType = new ASN1ObjectIdentifier(CardinalRenderType, "14");
        public static final ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier(CardinalRenderType, "4");
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(configure, "3");
        public static final ASN1ObjectIdentifier getString = new ASN1ObjectIdentifier(CardinalRenderType, "8");
        public static final ASN1ObjectIdentifier getWarnings;
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier(getInstance, "2.3");
        public static final ASN1ObjectIdentifier setChallengeTimeout = new ASN1ObjectIdentifier(CardinalRenderType, "11");
        public static final ASN1ObjectIdentifier setEnvironment = new ASN1ObjectIdentifier(CardinalRenderType, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
        public static final ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier(CardinalRenderType, "7");
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(CardinalRenderType, "3");
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(configure, "4");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.3");
            getInstance = aSN1ObjectIdentifier;
            Cardinal = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2.1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(getInstance, "3.1");
            configure = aSN1ObjectIdentifier2;
            getWarnings = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(getInstance, "3.2");
            CardinalError = aSN1ObjectIdentifier3;
            cleanup = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(getInstance, "3.2.8"), "1"), "1");
            CardinalRenderType = aSN1ObjectIdentifier4;
            CardinalEnvironment = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSASha3_224 */
    public interface detDSASha3_224 {
        public static final ASN1ObjectIdentifier Cardinal;
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
        public static final ASN1ObjectIdentifier CardinalConfigurationParameters = new ASN1ObjectIdentifier(configure, ScarShareReportModel.CHANNEL_MESSENGER);
        public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier(configure, "16");
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(configure, "8");
        public static final ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier(configure, "10");
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(configure, ScarShareReportModel.CHANNEL_WHATSAPP);
        public static final ASN1ObjectIdentifier Payment = new ASN1ObjectIdentifier(setUICustomization, "14.1");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(configure, "2");
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(configure, "7");
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier getActionCode = new ASN1ObjectIdentifier(configure, "27");
        public static final ASN1ObjectIdentifier getChallengeTimeout = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_DEMO_CHECK);
        public static final ASN1ObjectIdentifier getEnvironment = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT);
        public static final ASN1ObjectIdentifier getErrorNumber = new ASN1ObjectIdentifier(setUICustomization, "15.3");
        public static final ASN1ObjectIdentifier getExtendedData = new ASN1ObjectIdentifier(setUICustomization, "15.0");
        public static final ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier(configure, "3");
        public static final ASN1ObjectIdentifier getJSON = new ASN1ObjectIdentifier(setUICustomization, "14.3");
        public static final ASN1ObjectIdentifier getPayment = new ASN1ObjectIdentifier(setUICustomization, "15.2");
        public static final ASN1ObjectIdentifier getProcessorTransactionId = new ASN1ObjectIdentifier(setUICustomization, "15.1");
        public static final ASN1ObjectIdentifier getProxyAddress = new ASN1ObjectIdentifier(configure, "28");
        public static final ASN1ObjectIdentifier getRenderType = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_START_VIDEO_TAKE);
        public static final ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier(configure, ScarShareReportModel.CHANNEL_LINE);
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(configure, "6");
        public static final ASN1ObjectIdentifier getString = new ASN1ObjectIdentifier(configure, ScarShareReportModel.CHANNEL_TWITTER);
        public static final ASN1ObjectIdentifier getThreeDSRequestorAppURL = KeyAgreementSpi.ECKAEGwithSHA1KDF.setEnableLogging;
        public static final ASN1ObjectIdentifier getType = new ASN1ObjectIdentifier(setUICustomization, "14.2");
        public static final ASN1ObjectIdentifier getUICustomization = new ASN1ObjectIdentifier(configure, AppsFlyerLibCore.f1788);
        public static final ASN1ObjectIdentifier getUiType = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE);
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier(configure, "9");
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier(configure, "4");
        public static final ASN1ObjectIdentifier isEnableDFSync = KeyAgreementSpi.ECKAEGwithSHA1KDF.getExtendedData;
        public static final ASN1ObjectIdentifier isEnableLogging = new ASN1ObjectIdentifier(setUICustomization, "11.2");
        public static final ASN1ObjectIdentifier isLocationDataConsentGiven;
        public static final ASN1ObjectIdentifier setChallengeTimeout = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_PHOTO_DEMO_CHECK);
        public static final ASN1ObjectIdentifier setEnableDFSync = new ASN1ObjectIdentifier(configure, "39");
        public static final ASN1ObjectIdentifier setEnableLogging = new ASN1ObjectIdentifier(setUICustomization, "14.0");
        public static final ASN1ObjectIdentifier setEnvironment = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE);
        public static final ASN1ObjectIdentifier setLocationDataConsentGiven = new ASN1ObjectIdentifier(setUICustomization, "11.3");
        public static final ASN1ObjectIdentifier setProxyAddress = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_YES);
        public static final ASN1ObjectIdentifier setRenderType = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO);
        public static final ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier(configure, ScarShareReportModel.CHANNEL_EMAIL);
        public static final ASN1ObjectIdentifier setThreeDSRequestorAppURL = new ASN1ObjectIdentifier(setUICustomization, "11.1");
        public static final ASN1ObjectIdentifier setUICustomization;
        public static final ASN1ObjectIdentifier setUiType = new ASN1ObjectIdentifier(configure, "37");
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(configure, DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(configure, "5");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.132.0");
            configure = aSN1ObjectIdentifier;
            Cardinal = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.132.1");
            setUICustomization = aSN1ObjectIdentifier2;
            isLocationDataConsentGiven = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "11.0");
            new ASN1ObjectIdentifier(setUICustomization, "16.0");
            new ASN1ObjectIdentifier(setUICustomization, "16.1");
            new ASN1ObjectIdentifier(setUICustomization, "16.2");
            new ASN1ObjectIdentifier(setUICustomization, "16.3");
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSASha3_256 */
    public final class detDSASha3_256 extends getThreeDSRequestorAppURL {
        public setThreeDSRequestorAppURL init;

        public detDSASha3_256(int i, BigInteger bigInteger, getProxyAddress getproxyaddress) {
            this(i, bigInteger, (PrivateKeyInfo) null, getproxyaddress);
        }

        public detDSASha3_256(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.init = setthreedsrequestorappurl;
        }

        public final PrivateKeyInfo cca_continue() {
            return (PrivateKeyInfo) getInstance(1);
        }

        public final setLocationDataConsentGiven init() {
            return getInstance(0);
        }

        public final setLocationDataConsentGiven values() {
            return this.init;
        }

        public detDSASha3_256(int i, BigInteger bigInteger, PrivateKeyInfo privateKeyInfo, getProxyAddress getproxyaddress) {
            byte[] Cardinal = setSelected.Cardinal((i + 7) / 8, bigInteger);
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(1));
            setforegroundtintblendmode.cca_continue.addElement(new EdEC(Cardinal));
            if (getproxyaddress != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 0, getproxyaddress));
            }
            if (privateKeyInfo != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 1, privateKeyInfo));
            }
            this.init = new GOST(setforegroundtintblendmode);
        }

        private setLocationDataConsentGiven getInstance(int i) {
            Enumeration cca_continue = this.init.cca_continue();
            while (true) {
                setLocationDataConsentGiven setlocationdataconsentgiven = null;
                if (!cca_continue.hasMoreElements()) {
                    return null;
                }
                getProxyAddress getproxyaddress = (getProxyAddress) cca_continue.nextElement();
                if (getproxyaddress instanceof getType) {
                    getType gettype = (getType) getproxyaddress;
                    if (gettype.Cardinal == i) {
                        if (gettype.getInstance != null) {
                            setlocationdataconsentgiven = gettype.getInstance.values();
                        }
                        return setlocationdataconsentgiven.values();
                    }
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSASha3_384 */
    public final class detDSASha3_384 extends getThreeDSRequestorAppURL {
        public int cca_continue;
        public int configure;
        public int getInstance;
        public int init;

        detDSASha3_384(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.getInstance = new BigInteger(1, setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0)).Cardinal).intValue();
            if (setthreedsrequestorappurl.Cardinal(1) instanceof setProxyAddress) {
                this.cca_continue = new BigInteger(1, ((setProxyAddress) setthreedsrequestorappurl.Cardinal(1)).Cardinal).intValue();
            } else if (setthreedsrequestorappurl.Cardinal(1) instanceof setThreeDSRequestorAppURL) {
                setThreeDSRequestorAppURL cca_continue2 = setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl.Cardinal(1));
                this.cca_continue = new BigInteger(1, setProxyAddress.Cardinal((Object) cca_continue2.Cardinal(0)).Cardinal).intValue();
                this.configure = new BigInteger(1, setProxyAddress.Cardinal((Object) cca_continue2.Cardinal(1)).Cardinal).intValue();
                this.init = new BigInteger(1, setProxyAddress.Cardinal((Object) cca_continue2.Cardinal(2)).Cardinal).intValue();
            } else {
                throw new IllegalArgumentException("object parse error");
            }
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.getInstance));
            if (this.configure == 0) {
                setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.cca_continue));
            } else {
                setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) this.cca_continue));
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) this.configure));
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) this.init));
                setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$detDSASha3_512 */
    public final class detDSASha3_512 {
        private static final BigInteger Cardinal = BigInteger.valueOf(1);
        private static String cca_continue;
        private static BCRSAPublicKey[] configure = new BCRSAPublicKey[10];
        private static ASN1ObjectIdentifier[] getInstance = new ASN1ObjectIdentifier[10];
        private static final BigInteger init = BigInteger.valueOf(0);

        public static BCRSAPublicKey init(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            int parseInt;
            String str = aSN1ObjectIdentifier.init;
            if (str.startsWith(cca_continue) && (parseInt = Integer.parseInt(str.substring(str.lastIndexOf(46) + 1))) >= 0) {
                BCRSAPublicKey[] bCRSAPublicKeyArr = configure;
                if (parseInt < bCRSAPublicKeyArr.length) {
                    return bCRSAPublicKeyArr[parseInt];
                }
            }
            return null;
        }

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(dsaSha3_512.configure.init);
            sb.append(".2.");
            cca_continue = sb.toString();
            BigInteger[] bigIntegerArr = {new BigInteger("400000000000000000002BEC12BE2262D39BCF14D", 16), new BigInteger("3FFFFFFFFFFFFFFFFFFFFFB12EBCC7D7F29FF7701F", 16), new BigInteger("800000000000000000000189B4E67606E3825BB2831", 16), new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFB981960435FE5AB64236EF", 16), new BigInteger("40000000000000000000000069A779CAC1DABC6788F7474F", 16), new BigInteger("1000000000000000000000000000013E974E72F8A6922031D2603CFE0D7", 16), new BigInteger("800000000000000000000000000000006759213AF182E987D3E17714907D470D", 16), new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC079C2F3825DA70D390FBBA588D4604022B7B7", 16), new BigInteger("40000000000000000000000000000000000000000000009C300B75A3FA824F22428FD28CE8812245EF44049B2D49", 16), new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFBA3175458009A8C0A724F02F81AA8A1FCBAF80D90C7A95110504CF", 16)};
            BigInteger[] bigIntegerArr2 = {BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(4), BigInteger.valueOf(2), BigInteger.valueOf(2), BigInteger.valueOf(2)};
            getSDKAppID.cca_continue[] cca_continueArr = {new getSDKAppID.cca_continue(163, 3, 6, 7, Cardinal, new BigInteger("5FF6108462A2DC8210AB403925E638A19C1455D21", 16), bigIntegerArr[0], bigIntegerArr2[0]), new getSDKAppID.cca_continue(167, 6, Cardinal, new BigInteger("6EE3CEEB230811759F20518A0930F1A4315A827DAC", 16), bigIntegerArr[1], bigIntegerArr2[1]), new getSDKAppID.cca_continue(173, 1, 2, 10, init, new BigInteger("108576C80499DB2FC16EDDF6853BBB278F6B6FB437D9", 16), bigIntegerArr[2], bigIntegerArr2[2]), new getSDKAppID.cca_continue(179, 1, 2, 4, Cardinal, new BigInteger("4A6E0856526436F2F88DD07A341E32D04184572BEB710", 16), bigIntegerArr[3], bigIntegerArr2[3]), new getSDKAppID.cca_continue(191, 9, Cardinal, new BigInteger("7BC86E2102902EC4D5890E8B6B4981ff27E0482750FEFC03", 16), bigIntegerArr[4], bigIntegerArr2[4]), new getSDKAppID.cca_continue(233, 1, 4, 9, Cardinal, new BigInteger("06973B15095675534C7CF7E64A21BD54EF5DD3B8A0326AA936ECE454D2C", 16), bigIntegerArr[5], bigIntegerArr2[5]), new getSDKAppID.cca_continue(257, 12, init, new BigInteger("1CEF494720115657E18F938D7A7942394FF9425C1458C57861F9EEA6ADBE3BE10", 16), bigIntegerArr[6], bigIntegerArr2[6]), new getSDKAppID.cca_continue(307, 2, 4, 8, Cardinal, new BigInteger("393C7F7D53666B5054B5E6C6D3DE94F4296C0C599E2E2E241050DF18B6090BDC90186904968BB", 16), bigIntegerArr[7], bigIntegerArr2[7]), new getSDKAppID.cca_continue(367, 21, Cardinal, new BigInteger("43FC8AD242B0B7A6F3D1627AD5654447556B47BF6AA4A64B0C2AFE42CADAB8F93D92394C79A79755437B56995136", 16), bigIntegerArr[8], bigIntegerArr2[8]), new getSDKAppID.cca_continue(431, 1, 3, 5, Cardinal, new BigInteger("03CE10490F6A708FC26DFE8C3D27C4F94E690134D5BFF988D8D28AAEAEDE975936C66BAC536B18AE2DC312CA493117DAA469C640CAF3", 16), bigIntegerArr[9], bigIntegerArr2[9])};
            int i = 0;
            ChallengeParameters[] challengeParametersArr = {cca_continueArr[0].Cardinal(new BigInteger("2E2F85F5DD74CE983A5C4237229DAF8A3F35823BE", 16), new BigInteger("3826F008A8C51D7B95284D9D03FF0E00CE2CD723A", 16), false), cca_continueArr[1].Cardinal(new BigInteger("7A1F6653786A68192803910A3D30B2A2018B21CD54", 16), new BigInteger("5F49EB26781C0EC6B8909156D98ED435E45FD59918", 16), false), cca_continueArr[2].Cardinal(new BigInteger("4D41A619BCC6EADF0448FA22FAD567A9181D37389CA", 16), new BigInteger("10B51CC12849B234C75E6DD2028BF7FF5C1CE0D991A1", 16), false), cca_continueArr[3].Cardinal(new BigInteger("6BA06FE51464B2BD26DC57F48819BA9954667022C7D03", 16), new BigInteger("25FBC363582DCEC065080CA8287AAFF09788A66DC3A9E", 16), false), cca_continueArr[4].Cardinal(new BigInteger("714114B762F2FF4A7912A6D2AC58B9B5C2FCFE76DAEB7129", 16), new BigInteger("29C41E568B77C617EFE5902F11DB96FA9613CD8D03DB08DA", 16), false), cca_continueArr[5].Cardinal(new BigInteger("3FCDA526B6CDF83BA1118DF35B3C31761D3545F32728D003EEB25EFE96", 16), new BigInteger("9CA8B57A934C54DEEDA9E54A7BBAD95E3B2E91C54D32BE0B9DF96D8D35", 16), false), cca_continueArr[6].Cardinal(new BigInteger("02A29EF207D0E9B6C55CD260B306C7E007AC491CA1B10C62334A9E8DCD8D20FB7", 16), new BigInteger("10686D41FF744D4449FCCF6D8EEA03102E6812C93A9D60B978B702CF156D814EF", 16), false), cca_continueArr[7].Cardinal(new BigInteger("216EE8B189D291A0224984C1E92F1D16BF75CCD825A087A239B276D3167743C52C02D6E7232AA", 16), new BigInteger("5D9306BACD22B7FAEB09D2E049C6E2866C5D1677762A8F2F2DC9A11C7F7BE8340AB2237C7F2A0", 16), false), cca_continueArr[8].Cardinal(new BigInteger("324A6EDDD512F08C49A99AE0D3F961197A76413E7BE81A400CA681E09639B5FE12E59A109F78BF4A373541B3B9A1", 16), new BigInteger("1AB597A5B4477F59E39539007C7F977D1A567B92B043A49C6B61984C3FE3481AAF454CD41BA1F051626442B3C10", 16), false), cca_continueArr[9].Cardinal(new BigInteger("1A62BA79D98133A16BBAE7ED9A8E03C32E0824D57AEF72F88986874E5AAE49C27BED49A2A95058068426C2171E99FD3B43C5947C857D", 16), new BigInteger("70B5E1E14031C1F70BBEFE96BDDE66F451754B4CA5F48DA241F331AA396B8D1839A855C1769B1EA14BA53308B5E2723724E090E02DB9", 16), false)};
            int i2 = 0;
            while (true) {
                BCRSAPublicKey[] bCRSAPublicKeyArr = configure;
                if (i2 >= bCRSAPublicKeyArr.length) {
                    break;
                }
                bCRSAPublicKeyArr[i2] = new BCRSAPublicKey(cca_continueArr[i2], challengeParametersArr[i2], bigIntegerArr[i2], bigIntegerArr2[i2]);
                i2++;
            }
            while (true) {
                ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = getInstance;
                if (i < aSN1ObjectIdentifierArr.length) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cca_continue);
                    sb2.append(i);
                    aSN1ObjectIdentifierArr[i] = new ASN1ObjectIdentifier(sb2.toString());
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsa224 */
    public final class dsa224 extends getThreeDSRequestorAppURL {
        private static final byte[] cca_continue = {-87, -42, -21, 69, -15, 60, 112, -126, Byte.MIN_VALUE, -60, -106, 123, 35, Ascii.f53596US, 94, -83, -10, 88, -21, -92, -64, 55, 41, Ascii.f53588GS, 56, -39, 107, -16, 37, -54, 78, Ascii.ETB, -8, -23, 114, Ascii.f53584CR, -58, Ascii.NAK, -76, 58, 40, -105, 95, 11, -63, -34, -93, 100, 56, -75, 100, -22, 44, Ascii.ETB, -97, -48, Ascii.DC2, 62, 109, -72, -6, -59, 121, 4};
        public ASN1ObjectIdentifier Cardinal;
        public dsa384 getInstance;
        private byte[] init = cca_continue;

        private dsa224(dsa384 dsa384) {
            this.getInstance = dsa384;
        }

        public dsa224(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            this.Cardinal = aSN1ObjectIdentifier;
        }

        public static byte[] cca_continue() {
            return setForegroundTintBlendMode.cca_continue(cca_continue);
        }

        public final byte[] Cardinal() {
            return setForegroundTintBlendMode.cca_continue(this.init);
        }

        public final boolean configure() {
            return this.Cardinal != null;
        }

        public static dsa224 configure(Object obj) {
            dsa224 dsa224;
            if (obj != null) {
                setThreeDSRequestorAppURL cca_continue2 = setThreeDSRequestorAppURL.cca_continue(obj);
                if (cca_continue2.Cardinal(0) instanceof ASN1ObjectIdentifier) {
                    dsa224 = new dsa224(ASN1ObjectIdentifier.getInstance(cca_continue2.Cardinal(0)));
                } else {
                    getProxyAddress Cardinal2 = cca_continue2.Cardinal(0);
                    dsa224 = new dsa224(Cardinal2 instanceof dsa384 ? (dsa384) Cardinal2 : Cardinal2 != null ? new dsa384(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null);
                }
                if (cca_continue2.getInstance() == 2) {
                    byte[] cca_continue3 = isEnableDFSync.init(cca_continue2.Cardinal(1)).cca_continue();
                    dsa224.init = cca_continue3;
                    if (cca_continue3.length != cca_continue.length) {
                        throw new IllegalArgumentException("object parse error");
                    }
                }
                return dsa224;
            }
            throw new IllegalArgumentException("object parse error");
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = this.Cardinal;
            if (aSN1ObjectIdentifier != null) {
                setforegroundtintblendmode.cca_continue.addElement(aSN1ObjectIdentifier);
            } else {
                setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            }
            if (!setForegroundTintBlendMode.Cardinal(this.init, cca_continue)) {
                setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.init));
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsa384 */
    public final class dsa384 extends getThreeDSRequestorAppURL {
        public detDSASha3_384 Cardinal;
        private isEnableDFSync CardinalError;
        public setProxyAddress cca_continue;
        private BigInteger configure = BigInteger.valueOf(0);
        private isEnableDFSync getInstance;
        public setProxyAddress init;

        public final byte[] cca_continue() {
            return setForegroundTintBlendMode.cca_continue(this.CardinalError.cca_continue());
        }

        public final byte[] init() {
            return setForegroundTintBlendMode.cca_continue(this.getInstance.cca_continue());
        }

        dsa384(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            int i = 0;
            if (setthreedsrequestorappurl.Cardinal(0) instanceof getType) {
                getType gettype = (getType) setthreedsrequestorappurl.Cardinal(0);
                if (!gettype.init() || gettype.Cardinal != 0) {
                    throw new IllegalArgumentException("object parse error");
                }
                this.configure = new BigInteger(setProxyAddress.Cardinal((Object) gettype.getInstance()).Cardinal);
                i = 1;
            }
            getProxyAddress Cardinal2 = setthreedsrequestorappurl.Cardinal(i);
            this.Cardinal = Cardinal2 instanceof detDSASha3_384 ? (detDSASha3_384) Cardinal2 : Cardinal2 != null ? new detDSASha3_384(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null;
            int i2 = i + 1;
            this.cca_continue = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(i2));
            int i3 = i2 + 1;
            this.getInstance = isEnableDFSync.init(setthreedsrequestorappurl.Cardinal(i3));
            int i4 = i3 + 1;
            this.init = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(i4));
            this.CardinalError = isEnableDFSync.init(setthreedsrequestorappurl.Cardinal(i4 + 1));
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            if (this.configure.compareTo(BigInteger.valueOf(0)) != 0) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 0, new setProxyAddress(this.configure)));
            }
            setforegroundtintblendmode.cca_continue.addElement(this.Cardinal);
            setforegroundtintblendmode.cca_continue.addElement(this.cca_continue);
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            setforegroundtintblendmode.cca_continue.addElement(this.init);
            setforegroundtintblendmode.cca_continue.addElement(this.CardinalError);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsa512 */
    public final class dsa512 extends getThreeDSRequestorAppURL {
        public isEnableLogging Cardinal;

        dsa512(isEnableLogging isenablelogging) {
            this.Cardinal = isenablelogging;
        }

        public final setLocationDataConsentGiven values() {
            return this.Cardinal;
        }

        public final boolean configure() {
            return this.Cardinal.cca_continue.size() > 1;
        }

        public final dsaSha3_256 init() {
            if (this.Cardinal.cca_continue.size() == 0) {
                return null;
            }
            return dsaSha3_256.Cardinal((getProxyAddress) this.Cardinal.cca_continue.elementAt(0));
        }

        public final dsaSha3_256[] Cardinal() {
            int size = this.Cardinal.cca_continue.size();
            dsaSha3_256[] dsasha3_256Arr = new dsaSha3_256[size];
            for (int i = 0; i != size; i++) {
                dsasha3_256Arr[i] = dsaSha3_256.Cardinal((getProxyAddress) this.Cardinal.cca_continue.elementAt(i));
            }
            return dsasha3_256Arr;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsaSha3_224 */
    public final class dsaSha3_224 extends getThreeDSRequestorAppURL implements setEnvironment {
        private static KeyPairGeneratorSpi.C1980EC cca_continue = DSAUtil.init;
        private boolean Cardinal;
        public dsa512[] configure;
        private int getInstance;
        private KeyPairGeneratorSpi.C1980EC init;

        private dsaSha3_224(KeyPairGeneratorSpi.C1980EC ec, dsaSha3_224 dsasha3_224) {
            this.configure = dsasha3_224.configure;
            this.init = ec;
        }

        private dsaSha3_224(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this(cca_continue, setthreedsrequestorappurl);
        }

        public static dsaSha3_224 cca_continue(KeyPairGeneratorSpi.C1980EC ec, Object obj) {
            if (obj instanceof dsaSha3_224) {
                return new dsaSha3_224(ec, (dsaSha3_224) obj);
            }
            if (obj != null) {
                return new dsaSha3_224(ec, setThreeDSRequestorAppURL.cca_continue(obj));
            }
            return null;
        }

        public static dsaSha3_224 getInstance(Object obj) {
            if (obj instanceof dsaSha3_224) {
                return (dsaSha3_224) obj;
            }
            if (obj != null) {
                return new dsaSha3_224(setThreeDSRequestorAppURL.cca_continue(obj));
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof dsaSha3_224) && !(obj instanceof setThreeDSRequestorAppURL)) {
                return false;
            }
            if (values().equals(((getProxyAddress) obj).values())) {
                return true;
            }
            try {
                return this.init.Cardinal(this, new dsaSha3_224(setThreeDSRequestorAppURL.cca_continue((Object) ((getProxyAddress) obj).values())));
            } catch (Exception unused) {
                return false;
            }
        }

        public final int hashCode() {
            if (this.Cardinal) {
                return this.getInstance;
            }
            this.Cardinal = true;
            int configure2 = this.init.configure(this);
            this.getInstance = configure2;
            return configure2;
        }

        public final String toString() {
            return this.init.getInstance(this);
        }

        public final setLocationDataConsentGiven values() {
            return new GOST((getProxyAddress[]) this.configure);
        }

        public static dsaSha3_224 init(getType gettype) {
            setThreeDSRequestorAppURL configure2 = setThreeDSRequestorAppURL.configure(gettype, true);
            if (configure2 != null) {
                return new dsaSha3_224(setThreeDSRequestorAppURL.cca_continue((Object) configure2));
            }
            return null;
        }

        private dsaSha3_224(KeyPairGeneratorSpi.C1980EC ec, setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.init = ec;
            this.configure = new dsa512[setthreedsrequestorappurl.getInstance()];
            Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
            int i = 0;
            while (cca_continue2.hasMoreElements()) {
                dsa512[] dsa512Arr = this.configure;
                int i2 = i + 1;
                Object nextElement = cca_continue2.nextElement();
                dsa512Arr[i] = nextElement instanceof dsa512 ? (dsa512) nextElement : nextElement != null ? new dsa512(isEnableLogging.Cardinal(nextElement)) : null;
                i = i2;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsaSha3_256 */
    public final class dsaSha3_256 extends getThreeDSRequestorAppURL {
        public ASN1ObjectIdentifier configure;
        public getProxyAddress getInstance;

        private dsaSha3_256(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.configure = (ASN1ObjectIdentifier) setthreedsrequestorappurl.Cardinal(0);
            this.getInstance = setthreedsrequestorappurl.Cardinal(1);
        }

        public static dsaSha3_256 Cardinal(Object obj) {
            if (obj instanceof dsaSha3_256) {
                return (dsaSha3_256) obj;
            }
            if (obj != null) {
                return new dsaSha3_256(setThreeDSRequestorAppURL.cca_continue(obj));
            }
            throw new IllegalArgumentException("null value in getInstance()");
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.configure);
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsaSha3_384 */
    public final class dsaSha3_384 {
        private final int cca_continue;
        private final byte[][] configure;
        private final InputStream getInstance;

        public dsaSha3_384() {
        }

        public static byte[] Cardinal(int i) {
            return new byte[]{(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) (i >>> 24)};
        }

        private static String cca_continue(String str, byte[] bArr) {
            String instance;
            String instance2 = setAnimation.getInstance();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("    ");
            String obj = sb.toString();
            stringBuffer.append(instance2);
            for (int i = 0; i < bArr.length; i += 32) {
                int length = bArr.length - i;
                stringBuffer.append(obj);
                if (length > 32) {
                    stringBuffer.append(setAnimation.cca_continue(setTextDirection.init(bArr, i, 32)));
                    stringBuffer.append("    ");
                    instance = getInstance(bArr, i, 32);
                } else {
                    stringBuffer.append(setAnimation.cca_continue(setTextDirection.init(bArr, i, bArr.length - i)));
                    for (int length2 = bArr.length - i; length2 != 32; length2++) {
                        stringBuffer.append("  ");
                    }
                    stringBuffer.append("    ");
                    instance = getInstance(bArr, i, bArr.length - i);
                }
                stringBuffer.append(instance);
                stringBuffer.append(instance2);
            }
            return stringBuffer.toString();
        }

        public static int getInstance(int i) {
            int i2 = -1;
            while (i != 0) {
                i2++;
                i >>>= 1;
            }
            return i2;
        }

        private static String getInstance(byte[] bArr, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = i; i3 != i + i2; i3++) {
                if (bArr[i3] >= 32 && bArr[i3] <= 126) {
                    stringBuffer.append((char) bArr[i3]);
                }
            }
            return stringBuffer.toString();
        }

        private static void init(String str, boolean z, setLocationDataConsentGiven setlocationdataconsentgiven, StringBuffer stringBuffer) {
            StringBuilder sb;
            int i;
            while (true) {
                String instance = setAnimation.getInstance();
                if (setlocationdataconsentgiven instanceof setThreeDSRequestorAppURL) {
                    Enumeration cca_continue2 = ((setThreeDSRequestorAppURL) setlocationdataconsentgiven).cca_continue();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("    ");
                    String obj = sb2.toString();
                    stringBuffer.append(str);
                    stringBuffer.append(setlocationdataconsentgiven instanceof ValidateResponse ? "BER Sequence" : setlocationdataconsentgiven instanceof GOST ? "DER Sequence" : "Sequence");
                    while (true) {
                        stringBuffer.append(instance);
                        while (cca_continue2.hasMoreElements()) {
                            Object nextElement = cca_continue2.nextElement();
                            if (nextElement == null || nextElement.equals(ECGOST.Mappings.Cardinal)) {
                                stringBuffer.append(obj);
                                stringBuffer.append("NULL");
                            } else {
                                init(obj, z, nextElement instanceof setLocationDataConsentGiven ? (setLocationDataConsentGiven) nextElement : ((getProxyAddress) nextElement).values(), stringBuffer);
                            }
                        }
                        return;
                    }
                } else if (setlocationdataconsentgiven instanceof getType) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("    ");
                    String obj2 = sb3.toString();
                    stringBuffer.append(str);
                    stringBuffer.append(setlocationdataconsentgiven instanceof onValidated ? "BER Tagged [" : "Tagged [");
                    getType gettype = (getType) setlocationdataconsentgiven;
                    stringBuffer.append(Integer.toString(gettype.Cardinal));
                    stringBuffer.append(VersionRange.RIGHT_CLOSED);
                    if (!gettype.init()) {
                        stringBuffer.append(" IMPLICIT ");
                    }
                    stringBuffer.append(instance);
                    setlocationdataconsentgiven = gettype.getInstance != null ? gettype.getInstance.values() : null;
                    str = obj2;
                } else if (setlocationdataconsentgiven instanceof isEnableLogging) {
                    Enumeration elements = ((isEnableLogging) setlocationdataconsentgiven).cca_continue.elements();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append("    ");
                    String obj3 = sb4.toString();
                    stringBuffer.append(str);
                    stringBuffer.append(setlocationdataconsentgiven instanceof CardinalValidateReceiver ? "BER Set" : setlocationdataconsentgiven instanceof GOST.Mappings ? "DER Set" : "Set");
                    while (true) {
                        stringBuffer.append(instance);
                        while (elements.hasMoreElements()) {
                            Object nextElement2 = elements.nextElement();
                            if (nextElement2 == null) {
                                stringBuffer.append(obj3);
                                stringBuffer.append("NULL");
                            } else {
                                init(obj3, z, nextElement2 instanceof setLocationDataConsentGiven ? (setLocationDataConsentGiven) nextElement2 : ((getProxyAddress) nextElement2).values(), stringBuffer);
                            }
                        }
                        return;
                    }
                } else if (setlocationdataconsentgiven instanceof isEnableDFSync) {
                    isEnableDFSync isenabledfsync = (isEnableDFSync) setlocationdataconsentgiven;
                    if (setlocationdataconsentgiven instanceof getErrorNumber) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("BER Constructed Octet String[");
                        i = isenabledfsync.cca_continue().length;
                    } else {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("DER Octet String[");
                        i = isenabledfsync.cca_continue().length;
                    }
                    sb.append(i);
                    sb.append("] ");
                    stringBuffer.append(sb.toString());
                    if (z) {
                        stringBuffer.append(cca_continue(str, isenabledfsync.cca_continue()));
                        return;
                    } else {
                        stringBuffer.append(instance);
                        return;
                    }
                } else if (setlocationdataconsentgiven instanceof ASN1ObjectIdentifier) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    sb5.append("ObjectIdentifier(");
                    sb5.append(((ASN1ObjectIdentifier) setlocationdataconsentgiven).init);
                    sb5.append(")");
                    sb5.append(instance);
                    stringBuffer.append(sb5.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof setChallengeTimeout) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append("Boolean(");
                    sb6.append(((setChallengeTimeout) setlocationdataconsentgiven).init());
                    sb6.append(")");
                    sb6.append(instance);
                    stringBuffer.append(sb6.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof setProxyAddress) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str);
                    sb7.append("Integer(");
                    sb7.append(new BigInteger(((setProxyAddress) setlocationdataconsentgiven).Cardinal));
                    sb7.append(")");
                    sb7.append(instance);
                    stringBuffer.append(sb7.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof PrivateKeyInfo) {
                    PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) setlocationdataconsentgiven;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str);
                    sb8.append("DER Bit String[");
                    sb8.append(privateKeyInfo.getInstance().length);
                    sb8.append(", ");
                    sb8.append(privateKeyInfo.cleanup());
                    sb8.append("] ");
                    stringBuffer.append(sb8.toString());
                    if (z) {
                        stringBuffer.append(cca_continue(str, privateKeyInfo.getInstance()));
                        return;
                    } else {
                        stringBuffer.append(instance);
                        return;
                    }
                } else if (setlocationdataconsentgiven instanceof DSA.Mappings) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(str);
                    sb9.append("IA5String(");
                    sb9.append(((DSA.Mappings) setlocationdataconsentgiven).init());
                    sb9.append(") ");
                    sb9.append(instance);
                    stringBuffer.append(sb9.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof RSA.Mappings) {
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(str);
                    sb10.append("UTF8String(");
                    sb10.append(((RSA.Mappings) setlocationdataconsentgiven).init());
                    sb10.append(") ");
                    sb10.append(instance);
                    stringBuffer.append(sb10.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof C1944GM.Mappings) {
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(str);
                    sb11.append("PrintableString(");
                    sb11.append(((C1944GM.Mappings) setlocationdataconsentgiven).init());
                    sb11.append(") ");
                    sb11.append(instance);
                    stringBuffer.append(sb11.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof readObject) {
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(str);
                    sb12.append("VisibleString(");
                    sb12.append(((readObject) setlocationdataconsentgiven).init());
                    sb12.append(") ");
                    sb12.append(instance);
                    stringBuffer.append(sb12.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof SubjectPublicKeyInfo) {
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(str);
                    sb13.append("BMPString(");
                    sb13.append(((SubjectPublicKeyInfo) setlocationdataconsentgiven).init());
                    sb13.append(") ");
                    sb13.append(instance);
                    stringBuffer.append(sb13.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof IES.Mappings) {
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(str);
                    sb14.append("T61String(");
                    sb14.append(((IES.Mappings) setlocationdataconsentgiven).init());
                    sb14.append(") ");
                    sb14.append(instance);
                    stringBuffer.append(sb14.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof C1943EC.Mappings) {
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append(str);
                    sb15.append("GraphicString(");
                    sb15.append(((C1943EC.Mappings) setlocationdataconsentgiven).init());
                    sb15.append(") ");
                    sb15.append(instance);
                    stringBuffer.append(sb15.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof X509) {
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(str);
                    sb16.append("VideotexString(");
                    sb16.append(((X509) setlocationdataconsentgiven).init());
                    sb16.append(") ");
                    sb16.append(instance);
                    stringBuffer.append(sb16.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof Payment) {
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(str);
                    sb17.append("UTCTime(");
                    sb17.append(((Payment) setlocationdataconsentgiven).getInstance());
                    sb17.append(") ");
                    sb17.append(instance);
                    stringBuffer.append(sb17.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof setRenderType) {
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append(str);
                    sb18.append("GeneralizedTime(");
                    sb18.append(((setRenderType) setlocationdataconsentgiven).getInstance());
                    sb18.append(") ");
                    sb18.append(instance);
                    stringBuffer.append(sb18.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof getJSON) {
                    stringBuffer.append(configure(ASN1Encoding.BER, str, z, setlocationdataconsentgiven, instance));
                    return;
                } else if (setlocationdataconsentgiven instanceof DSA) {
                    stringBuffer.append(configure(ASN1Encoding.DER, str, z, setlocationdataconsentgiven, instance));
                    return;
                } else if (setlocationdataconsentgiven instanceof AlgorithmParameterGeneratorSpi) {
                    stringBuffer.append(configure("", str, z, setlocationdataconsentgiven, instance));
                    return;
                } else if (setlocationdataconsentgiven instanceof getChallengeTimeout) {
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append(str);
                    sb19.append("DER Enumerated(");
                    sb19.append(new BigInteger(((getChallengeTimeout) setlocationdataconsentgiven).configure));
                    sb19.append(")");
                    sb19.append(instance);
                    stringBuffer.append(sb19.toString());
                    return;
                } else if (setlocationdataconsentgiven instanceof getRenderType) {
                    getRenderType getrendertype = (getRenderType) setlocationdataconsentgiven;
                    StringBuilder sb20 = new StringBuilder();
                    sb20.append(str);
                    sb20.append("External ");
                    sb20.append(instance);
                    stringBuffer.append(sb20.toString());
                    StringBuilder sb21 = new StringBuilder();
                    sb21.append(str);
                    sb21.append("    ");
                    str = sb21.toString();
                    if (getrendertype.getInstance() != null) {
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append(str);
                        sb22.append("Direct Reference: ");
                        sb22.append(getrendertype.getInstance().init);
                        sb22.append(instance);
                        stringBuffer.append(sb22.toString());
                    }
                    if (getrendertype.cleanup() != null) {
                        StringBuilder sb23 = new StringBuilder();
                        sb23.append(str);
                        sb23.append("Indirect Reference: ");
                        sb23.append(getrendertype.cleanup().toString());
                        sb23.append(instance);
                        stringBuffer.append(sb23.toString());
                    }
                    if (getrendertype.init() != null) {
                        init(str, z, getrendertype.init(), stringBuffer);
                    }
                    StringBuilder sb24 = new StringBuilder();
                    sb24.append(str);
                    sb24.append("Encoding: ");
                    sb24.append(getrendertype.cca_continue());
                    sb24.append(instance);
                    stringBuffer.append(sb24.toString());
                    setlocationdataconsentgiven = getrendertype.CardinalError();
                } else {
                    StringBuilder sb25 = new StringBuilder();
                    sb25.append(str);
                    sb25.append(setlocationdataconsentgiven.toString());
                    sb25.append(instance);
                    stringBuffer.append(sb25.toString());
                    return;
                }
            }
        }

        private static String configure(String str, String str2, boolean z, setLocationDataConsentGiven setlocationdataconsentgiven, String str3) {
            if (setlocationdataconsentgiven == null || (setlocationdataconsentgiven instanceof setRequestTimeout)) {
                setRequestTimeout setrequesttimeout = (setRequestTimeout) setlocationdataconsentgiven;
                StringBuffer stringBuffer = new StringBuffer();
                if (setrequesttimeout.Cardinal()) {
                    try {
                        byte[] encoded = setrequesttimeout.getEncoded();
                        byte[] cca_continue2 = setRequestTimeout.cca_continue(16, encoded);
                        if ((encoded[0] & 32) != 0) {
                            cca_continue2[0] = (byte) (cca_continue2[0] | 32);
                        }
                        setThreeDSRequestorAppURL cca_continue3 = setThreeDSRequestorAppURL.cca_continue((Object) setLocationDataConsentGiven.getInstance(cca_continue2));
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(str);
                        sb.append(" ApplicationSpecific[");
                        sb.append(setrequesttimeout.getInstance());
                        sb.append(Const.jaRight);
                        sb.append(str3);
                        stringBuffer.append(sb.toString());
                        Enumeration cca_continue4 = cca_continue3.cca_continue();
                        while (cca_continue4.hasMoreElements()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str2);
                            sb2.append("    ");
                            init(sb2.toString(), z, (setLocationDataConsentGiven) cca_continue4.nextElement(), stringBuffer);
                        }
                    } catch (IOException e) {
                        stringBuffer.append(e);
                    }
                    return stringBuffer.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(str);
                sb3.append(" ApplicationSpecific[");
                sb3.append(setrequesttimeout.getInstance());
                sb3.append("] (");
                sb3.append(setAnimation.cca_continue(setTextDirection.configure(setrequesttimeout.cca_continue())));
                sb3.append(")");
                sb3.append(str3);
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder("unknown object in getInstance: ");
            sb4.append(setlocationdataconsentgiven.getClass().getName());
            throw new IllegalArgumentException(sb4.toString());
        }

        public static String cca_continue(Object obj) {
            setLocationDataConsentGiven values;
            StringBuffer stringBuffer = new StringBuffer();
            if (obj instanceof setLocationDataConsentGiven) {
                values = (setLocationDataConsentGiven) obj;
            } else if (obj instanceof getProxyAddress) {
                values = ((getProxyAddress) obj).values();
            } else {
                StringBuilder sb = new StringBuilder("unknown object type ");
                sb.append(obj.toString());
                return sb.toString();
            }
            init("", false, values, stringBuffer);
            return stringBuffer.toString();
        }

        public dsaSha3_384(InputStream inputStream) {
            this(inputStream, KeyAgreementSpi.Cardinal(inputStream));
        }

        public dsaSha3_384(InputStream inputStream, int i) {
            this.getInstance = inputStream;
            this.cca_continue = i;
            this.configure = new byte[11][];
        }

        public final setLocationDataConsentGiven init(boolean z, int i) throws IOException {
            if (!z) {
                return new RSA(false, i, new EdEC(((IESCipher) this.getInstance).configure()));
            }
            setForegroundTintBlendMode configure2 = configure();
            if (!(this.getInstance instanceof KeyAgreementSpi.DHUwithSHA224CKDF)) {
                return configure2.cca_continue.size() == 1 ? new RSA(true, i, (getProxyAddress) configure2.cca_continue.elementAt(0)) : new RSA(false, i, C1943EC.getInstance(configure2));
            }
            if (configure2.cca_continue.size() == 1) {
                return new onValidated(true, i, (getProxyAddress) configure2.cca_continue.elementAt(0));
            }
            return new onValidated(false, i, getErrorDescription.getInstance(configure2));
        }

        public final getProxyAddress Cardinal() throws IOException {
            int read = this.getInstance.read();
            if (read == -1) {
                return null;
            }
            InputStream inputStream = this.getInstance;
            boolean z = false;
            if (inputStream instanceof KeyAgreementSpi.DHUwithSHA224CKDF) {
                KeyAgreementSpi.DHUwithSHA224CKDF dHUwithSHA224CKDF = (KeyAgreementSpi.DHUwithSHA224CKDF) inputStream;
                dHUwithSHA224CKDF.cca_continue = false;
                dHUwithSHA224CKDF.init();
            }
            int init = getUiType.init(this.getInstance, read);
            if ((read & 32) != 0) {
                z = true;
            }
            int instance = getUiType.getInstance(this.getInstance, this.cca_continue);
            if (instance >= 0) {
                IESCipher iESCipher = new IESCipher(this.getInstance, instance);
                if ((read & 64) != 0) {
                    return new AlgorithmParameterGeneratorSpi(z, init, iESCipher.configure());
                }
                if ((read & 128) != 0) {
                    return new CardinalInitService(z, init, new dsaSha3_384(iESCipher));
                }
                if (z) {
                    if (init == 4) {
                        return new getPayment(new dsaSha3_384(iESCipher));
                    }
                    if (init == 8) {
                        return new C1895DH(new dsaSha3_384(iESCipher));
                    }
                    if (init == 16) {
                        return new ElGamal.Mappings(new dsaSha3_384(iESCipher));
                    }
                    if (init == 17) {
                        return new C1944GM(new dsaSha3_384(iESCipher));
                    }
                    StringBuilder sb = new StringBuilder("unknown tag ");
                    sb.append(init);
                    sb.append(" encountered");
                    throw new IOException(sb.toString());
                } else if (init == 4) {
                    return new EdEC.Mappings(iESCipher);
                } else {
                    try {
                        return getUiType.Cardinal(init, iESCipher, this.configure);
                    } catch (IllegalArgumentException e) {
                        throw new getEnvironment("corrupted stream detected", e);
                    }
                }
            } else if (z) {
                dsaSha3_384 dsasha3_384 = new dsaSha3_384(new KeyAgreementSpi.DHUwithSHA224CKDF(this.getInstance, this.cca_continue), this.cca_continue);
                if ((read & 64) != 0) {
                    return new getProcessorTransactionId(init, dsasha3_384);
                }
                if ((read & 128) != 0) {
                    return new CardinalInitService(true, init, dsasha3_384);
                }
                if (init == 4) {
                    return new getPayment(dsasha3_384);
                }
                if (init == 8) {
                    return new C1895DH(dsasha3_384);
                }
                if (init == 16) {
                    return new isValidated(dsasha3_384);
                }
                if (init == 17) {
                    return new onSetupCompleted(dsasha3_384);
                }
                StringBuilder sb2 = new StringBuilder("unknown BER object encountered: 0x");
                sb2.append(Integer.toHexString(init));
                throw new getEnvironment(sb2.toString());
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        }

        public final setForegroundTintBlendMode configure() throws IOException {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            while (true) {
                getProxyAddress Cardinal = Cardinal();
                if (Cardinal == null) {
                    return setforegroundtintblendmode;
                }
                if (Cardinal instanceof KeyAgreementSpi.DHUwithSHA1CKDF) {
                    setforegroundtintblendmode.cca_continue.addElement(((KeyAgreementSpi.DHUwithSHA1CKDF) Cardinal).getInstance());
                } else {
                    setforegroundtintblendmode.cca_continue.addElement(Cardinal.values());
                }
            }
        }

        public static setKeyboardNavigationCluster cca_continue(byte[] bArr) {
            setKeyboardNavigationCluster setkeyboardnavigationcluster;
            DSABase dSABase = new DSABase(bArr);
            String cca_continue2 = setAnimation.cca_continue(dSABase.configure());
            if ("ssh-rsa".equals(cca_continue2)) {
                setkeyboardnavigationcluster = new ISOSignatureSpi.WhirlpoolWithRSAEncryption(false, dSABase.init(), dSABase.init());
            } else if ("ssh-dss".equals(cca_continue2)) {
                setkeyboardnavigationcluster = new BCGOST3410PrivateKey(dSABase.init(), new BCGOST3410PublicKey(dSABase.init(), dSABase.init(), dSABase.init()));
            } else if (cca_continue2.startsWith("ecdsa")) {
                String cca_continue3 = setAnimation.cca_continue(dSABase.configure());
                if (cca_continue3.startsWith("nist")) {
                    String substring = cca_continue3.substring(4);
                    StringBuilder sb = new StringBuilder();
                    sb.append(substring.substring(0, 1));
                    sb.append("-");
                    sb.append(substring.substring(1));
                    cca_continue3 = sb.toString();
                }
                KeyAgreementSpi.C1970DH configure2 = IESCipher.ECIESwithCipher.configure(cca_continue3);
                if (configure2 != null) {
                    getSDKAppID getsdkappid = configure2.cca_continue;
                    setkeyboardnavigationcluster = new DigestSignatureSpi(getsdkappid.configure(dSABase.configure()), new BCRSAPublicKey(getsdkappid, configure2.getInstance.cca_continue(), configure2.Cardinal, configure2.init, configure2.init()));
                } else {
                    StringBuilder sb2 = new StringBuilder("unable to find curve for ");
                    sb2.append(cca_continue2);
                    sb2.append(" using curve name ");
                    sb2.append(cca_continue3);
                    throw new IllegalStateException(sb2.toString());
                }
            } else {
                setkeyboardnavigationcluster = cca_continue2.startsWith("ssh-ed25519") ? new DigestSignatureSpi.RIPEMD256(dSABase.configure(), 0) : null;
            }
            if (setkeyboardnavigationcluster == null) {
                throw new IllegalArgumentException("unable to parse key");
            } else if (!dSABase.cca_continue()) {
                return setkeyboardnavigationcluster;
            } else {
                throw new IllegalArgumentException("uncoded key has trailing data");
            }
        }

        public static byte[] configure(setKeyboardNavigationCluster setkeyboardnavigationcluster) throws IOException {
            if (setkeyboardnavigationcluster instanceof ISOSignatureSpi.WhirlpoolWithRSAEncryption) {
                if (!setkeyboardnavigationcluster.getInstance()) {
                    ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) setkeyboardnavigationcluster;
                    BigInteger bigInteger = whirlpoolWithRSAEncryption.Cardinal;
                    BigInteger bigInteger2 = whirlpoolWithRSAEncryption.configure;
                    PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl = new PKCS12BagAttributeCarrierImpl();
                    byte[] configure2 = setAnimation.configure("ssh-rsa");
                    pKCS12BagAttributeCarrierImpl.init((long) configure2.length);
                    try {
                        pKCS12BagAttributeCarrierImpl.configure.write(configure2);
                        byte[] byteArray = bigInteger.toByteArray();
                        pKCS12BagAttributeCarrierImpl.init((long) byteArray.length);
                        try {
                            pKCS12BagAttributeCarrierImpl.configure.write(byteArray);
                            byte[] byteArray2 = bigInteger2.toByteArray();
                            pKCS12BagAttributeCarrierImpl.init((long) byteArray2.length);
                            try {
                                pKCS12BagAttributeCarrierImpl.configure.write(byteArray2);
                                return pKCS12BagAttributeCarrierImpl.Cardinal();
                            } catch (IOException e) {
                                throw new IllegalStateException(e.getMessage(), e);
                            }
                        } catch (IOException e2) {
                            throw new IllegalStateException(e2.getMessage(), e2);
                        }
                    } catch (IOException e3) {
                        throw new IllegalStateException(e3.getMessage(), e3);
                    }
                } else {
                    throw new IllegalArgumentException("RSAKeyParamaters was for encryption");
                }
            } else if (setkeyboardnavigationcluster instanceof DigestSignatureSpi) {
                PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl2 = new PKCS12BagAttributeCarrierImpl();
                DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) setkeyboardnavigationcluster;
                if (digestSignatureSpi.init.Cardinal instanceof setCCAPadding) {
                    byte[] configure3 = setAnimation.configure("ecdsa-sha2-".concat("nistp256"));
                    pKCS12BagAttributeCarrierImpl2.init((long) configure3.length);
                    try {
                        pKCS12BagAttributeCarrierImpl2.configure.write(configure3);
                        byte[] configure4 = setAnimation.configure("nistp256");
                        pKCS12BagAttributeCarrierImpl2.init((long) configure4.length);
                        try {
                            pKCS12BagAttributeCarrierImpl2.configure.write(configure4);
                            byte[] configure5 = digestSignatureSpi.cca_continue.configure(false);
                            pKCS12BagAttributeCarrierImpl2.init((long) configure5.length);
                            try {
                                pKCS12BagAttributeCarrierImpl2.configure.write(configure5);
                                return pKCS12BagAttributeCarrierImpl2.Cardinal();
                            } catch (IOException e4) {
                                throw new IllegalStateException(e4.getMessage(), e4);
                            }
                        } catch (IOException e5) {
                            throw new IllegalStateException(e5.getMessage(), e5);
                        }
                    } catch (IOException e6) {
                        throw new IllegalStateException(e6.getMessage(), e6);
                    }
                } else {
                    StringBuilder sb = new StringBuilder("unable to derive ssh curve name for ");
                    sb.append(digestSignatureSpi.init.Cardinal.getClass().getName());
                    throw new IllegalArgumentException(sb.toString());
                }
            } else if (setkeyboardnavigationcluster instanceof BCGOST3410PrivateKey) {
                PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl3 = new PKCS12BagAttributeCarrierImpl();
                byte[] configure6 = setAnimation.configure("ssh-dss");
                pKCS12BagAttributeCarrierImpl3.init((long) configure6.length);
                try {
                    pKCS12BagAttributeCarrierImpl3.configure.write(configure6);
                    BCGOST3410PrivateKey bCGOST3410PrivateKey = (BCGOST3410PrivateKey) setkeyboardnavigationcluster;
                    byte[] byteArray3 = bCGOST3410PrivateKey.Cardinal.init.toByteArray();
                    pKCS12BagAttributeCarrierImpl3.init((long) byteArray3.length);
                    try {
                        pKCS12BagAttributeCarrierImpl3.configure.write(byteArray3);
                        byte[] byteArray4 = bCGOST3410PrivateKey.Cardinal.getInstance.toByteArray();
                        pKCS12BagAttributeCarrierImpl3.init((long) byteArray4.length);
                        try {
                            pKCS12BagAttributeCarrierImpl3.configure.write(byteArray4);
                            byte[] byteArray5 = bCGOST3410PrivateKey.Cardinal.cca_continue.toByteArray();
                            pKCS12BagAttributeCarrierImpl3.init((long) byteArray5.length);
                            try {
                                pKCS12BagAttributeCarrierImpl3.configure.write(byteArray5);
                                byte[] byteArray6 = bCGOST3410PrivateKey.cca_continue.toByteArray();
                                pKCS12BagAttributeCarrierImpl3.init((long) byteArray6.length);
                                try {
                                    pKCS12BagAttributeCarrierImpl3.configure.write(byteArray6);
                                    return pKCS12BagAttributeCarrierImpl3.Cardinal();
                                } catch (IOException e7) {
                                    throw new IllegalStateException(e7.getMessage(), e7);
                                }
                            } catch (IOException e8) {
                                throw new IllegalStateException(e8.getMessage(), e8);
                            }
                        } catch (IOException e9) {
                            throw new IllegalStateException(e9.getMessage(), e9);
                        }
                    } catch (IOException e10) {
                        throw new IllegalStateException(e10.getMessage(), e10);
                    }
                } catch (IOException e11) {
                    throw new IllegalStateException(e11.getMessage(), e11);
                }
            } else if (setkeyboardnavigationcluster instanceof DigestSignatureSpi.RIPEMD256) {
                PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl4 = new PKCS12BagAttributeCarrierImpl();
                byte[] configure7 = setAnimation.configure("ssh-ed25519");
                pKCS12BagAttributeCarrierImpl4.init((long) configure7.length);
                try {
                    pKCS12BagAttributeCarrierImpl4.configure.write(configure7);
                    byte[] encoded = ((DigestSignatureSpi.RIPEMD256) setkeyboardnavigationcluster).getEncoded();
                    pKCS12BagAttributeCarrierImpl4.init((long) encoded.length);
                    try {
                        pKCS12BagAttributeCarrierImpl4.configure.write(encoded);
                        return pKCS12BagAttributeCarrierImpl4.Cardinal();
                    } catch (IOException e12) {
                        throw new IllegalStateException(e12.getMessage(), e12);
                    }
                } catch (IOException e13) {
                    throw new IllegalStateException(e13.getMessage(), e13);
                }
            } else {
                StringBuilder sb2 = new StringBuilder("unable to convert ");
                sb2.append(setkeyboardnavigationcluster.getClass().getName());
                sb2.append(" to private key");
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        public static String configure(int i) {
            if (i == 0) {
                return "qTESLA-I";
            }
            if (i == 1) {
                return "qTESLA-III-size";
            }
            if (i == 2) {
                return "qTESLA-III-speed";
            }
            if (i == 3) {
                return "qTESLA-p-I";
            }
            if (i == 4) {
                return "qTESLA-p-III";
            }
            throw new IllegalArgumentException("unknown security category: ".concat(String.valueOf(i)));
        }

        public static PrivateKeyInfo Cardinal(setKeyboardNavigationCluster setkeyboardnavigationcluster, isEnableLogging isenablelogging) throws IOException {
            if (setkeyboardnavigationcluster instanceof setSaveEnabled) {
                setSaveEnabled setsaveenabled = (setSaveEnabled) setkeyboardnavigationcluster;
                return new PrivateKeyInfo(setScrollY.cca_continue(setsaveenabled.configure), new EdEC(setsaveenabled.configure()), isenablelogging);
            } else if (setkeyboardnavigationcluster instanceof setFocusedByDefault) {
                setFocusedByDefault setfocusedbydefault = (setFocusedByDefault) setkeyboardnavigationcluster;
                return new PrivateKeyInfo(new stdDSA(PQCObjectIdentifiers.Cardinal, new setSoundEffectsEnabled(setScrollY.getInstance(setfocusedbydefault.init))), new EdEC(setfocusedbydefault.cca_continue()));
            } else if (setkeyboardnavigationcluster instanceof setFilterTouchesWhenObscured) {
                stdDSA stddsa = new stdDSA(PQCObjectIdentifiers.values);
                short[] configure2 = ((setFilterTouchesWhenObscured) setkeyboardnavigationcluster).configure();
                byte[] bArr = new byte[(configure2.length << 1)];
                for (int i = 0; i != configure2.length; i++) {
                    short s = configure2[i];
                    int i2 = i << 1;
                    bArr[i2] = (byte) s;
                    bArr[i2 + 1] = (byte) (s >>> 8);
                }
                return new PrivateKeyInfo(stddsa, new EdEC(bArr));
            } else if (setkeyboardnavigationcluster instanceof setTranslationZ) {
                setTranslationZ settranslationz = (setTranslationZ) setkeyboardnavigationcluster;
                stdDSA stddsa2 = new stdDSA(PQCObjectIdentifiers.CardinalError, new setHasTransientState(settranslationz.configure.Cardinal, setScrollY.init(settranslationz.cca_continue)));
                byte[] Cardinal = settranslationz.Cardinal();
                int i3 = settranslationz.configure.init.getInstance.getInstance;
                int i4 = settranslationz.configure.Cardinal;
                int Cardinal2 = (int) setVerticalFadingEdgeEnabled.Cardinal(Cardinal, 4);
                if (setVerticalFadingEdgeEnabled.cca_continue(i4, (long) Cardinal2)) {
                    byte[] Cardinal3 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal, 4, i3);
                    int i5 = i3 + 4;
                    byte[] Cardinal4 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal, i5, i3);
                    int i6 = i5 + i3;
                    byte[] Cardinal5 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal, i6, i3);
                    int i7 = i6 + i3;
                    byte[] Cardinal6 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal, i7, i3);
                    int i8 = i7 + i3;
                    return new PrivateKeyInfo(stddsa2, new setHapticFeedbackEnabled(Cardinal2, Cardinal3, Cardinal4, Cardinal5, Cardinal6, setVerticalFadingEdgeEnabled.Cardinal(Cardinal, i8, Cardinal.length - i8)));
                }
                throw new IllegalArgumentException("index out of bounds");
            } else if (setkeyboardnavigationcluster instanceof setTranslationX) {
                setTranslationX settranslationx = (setTranslationX) setkeyboardnavigationcluster;
                stdDSA stddsa3 = new stdDSA(PQCObjectIdentifiers.getWarnings, new setWillNotCacheDrawing(settranslationx.init.getInstance, settranslationx.init.configure, setScrollY.init(settranslationx.configure)));
                byte[] Cardinal7 = settranslationx.Cardinal();
                int i9 = settranslationx.init.Cardinal.init.getInstance.getInstance;
                int i10 = settranslationx.init.getInstance;
                int i11 = (i10 + 7) / 8;
                int Cardinal8 = (int) setVerticalFadingEdgeEnabled.Cardinal(Cardinal7, i11);
                if (setVerticalFadingEdgeEnabled.cca_continue(i10, (long) Cardinal8)) {
                    byte[] Cardinal9 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal7, i11, i9);
                    int i12 = i11 + i9;
                    byte[] Cardinal10 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal7, i12, i9);
                    int i13 = i12 + i9;
                    byte[] Cardinal11 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal7, i13, i9);
                    int i14 = i13 + i9;
                    byte[] Cardinal12 = setVerticalFadingEdgeEnabled.Cardinal(Cardinal7, i14, i9);
                    int i15 = i14 + i9;
                    return new PrivateKeyInfo(stddsa3, new setLayoutDirection(Cardinal8, Cardinal9, Cardinal10, Cardinal11, Cardinal12, setVerticalFadingEdgeEnabled.Cardinal(Cardinal7, i15, Cardinal7.length - i15)));
                }
                throw new IllegalArgumentException("index out of bounds");
            } else {
                throw new IOException("key parameters not recognized");
            }
        }

        public static SubjectPublicKeyInfo getInstance(setKeyboardNavigationCluster setkeyboardnavigationcluster) throws IOException {
            if (setkeyboardnavigationcluster instanceof setImportantForAccessibility) {
                setImportantForAccessibility setimportantforaccessibility = (setImportantForAccessibility) setkeyboardnavigationcluster;
                return new SubjectPublicKeyInfo(setScrollY.cca_continue(setimportantforaccessibility.getInstance), setimportantforaccessibility.init());
            } else if (setkeyboardnavigationcluster instanceof setHovered) {
                setHovered sethovered = (setHovered) setkeyboardnavigationcluster;
                return new SubjectPublicKeyInfo(new stdDSA(PQCObjectIdentifiers.Cardinal, new setSoundEffectsEnabled(setScrollY.getInstance(sethovered.init))), sethovered.Cardinal());
            } else if (setkeyboardnavigationcluster instanceof setAccessibilityHeading) {
                return new SubjectPublicKeyInfo(new stdDSA(PQCObjectIdentifiers.values), ((setAccessibilityHeading) setkeyboardnavigationcluster).configure());
            } else {
                if (setkeyboardnavigationcluster instanceof setAnimationMatrix) {
                    setAnimationMatrix setanimationmatrix = (setAnimationMatrix) setkeyboardnavigationcluster;
                    return new SubjectPublicKeyInfo(new stdDSA(PQCObjectIdentifiers.CardinalError, new setHasTransientState(setanimationmatrix.Cardinal.Cardinal, setScrollY.init(setanimationmatrix.cca_continue))), (getProxyAddress) new setAllowClickWhenDisabled(setanimationmatrix.configure(), setanimationmatrix.Cardinal()));
                } else if (setkeyboardnavigationcluster instanceof setZ) {
                    setZ setz = (setZ) setkeyboardnavigationcluster;
                    return new SubjectPublicKeyInfo(new stdDSA(PQCObjectIdentifiers.getWarnings, new setWillNotCacheDrawing(setz.getInstance.getInstance, setz.getInstance.configure, setScrollY.init(setz.configure))), (getProxyAddress) new setWillNotDraw(setz.Cardinal(), setz.configure()));
                } else {
                    throw new IOException("key parameters not recognized");
                }
            }
        }

        public static setBackgroundDrawable Cardinal(setBackgroundTintList setbackgroundtintlist, setForegroundTintMode setforegroundtintmode) {
            setBackgroundTintList setbackgroundtintlist2 = setbackgroundtintlist;
            setForegroundTintMode setforegroundtintmode2 = setforegroundtintmode;
            Class<int> cls = int.class;
            int i = setbackgroundtintlist2.configure;
            int i2 = 1 << i;
            int length = setforegroundtintmode2.init.length - 1;
            if (setforegroundtintmode2.init[length] == 0) {
                length = -1;
            }
            int[] iArr = new int[2];
            iArr[1] = i2;
            iArr[0] = length;
            int[][] iArr2 = (int[][]) Array.newInstance(cls, iArr);
            int[] iArr3 = new int[2];
            iArr3[1] = i2;
            iArr3[0] = length;
            int[][] iArr4 = (int[][]) Array.newInstance(cls, iArr3);
            for (int i3 = 0; i3 < i2; i3++) {
                int[] iArr5 = iArr4[0];
                int i4 = setforegroundtintmode2.init[setforegroundtintmode2.Cardinal];
                for (int i5 = setforegroundtintmode2.Cardinal - 1; i5 >= 0; i5--) {
                    i4 = getInstance(i4, i3, setforegroundtintmode2.getInstance.getInstance) ^ setforegroundtintmode2.init[i5];
                }
                iArr5[i3] = setbackgroundtintlist2.cca_continue(i4, (1 << setbackgroundtintlist2.configure) - 2);
            }
            for (int i6 = 1; i6 < length; i6++) {
                for (int i7 = 0; i7 < i2; i7++) {
                    iArr4[i6][i7] = getInstance(iArr4[i6 - 1][i7], i7, setbackgroundtintlist2.getInstance);
                }
            }
            for (int i8 = 0; i8 < length; i8++) {
                for (int i9 = 0; i9 < i2; i9++) {
                    for (int i10 = 0; i10 <= i8; i10++) {
                        int i11 = (length + i10) - i8;
                        iArr2[i8][i9] = getInstance(iArr4[i10][i9], (i11 < 0 || i11 > setforegroundtintmode2.Cardinal) ? 0 : setforegroundtintmode2.init[i11], setbackgroundtintlist2.getInstance) ^ iArr2[i8][i9];
                    }
                }
            }
            int[] iArr6 = new int[2];
            iArr6[1] = (i2 + 31) >>> 5;
            iArr6[0] = length * i;
            int[][] iArr7 = (int[][]) Array.newInstance(cls, iArr6);
            for (int i12 = 0; i12 < i2; i12++) {
                int i13 = i12 >>> 5;
                int i14 = 1 << (i12 & 31);
                for (int i15 = 0; i15 < length; i15++) {
                    int i16 = iArr2[i15][i12];
                    for (int i17 = 0; i17 < i; i17++) {
                        if (((i16 >>> i17) & 1) != 0) {
                            int[] iArr8 = iArr7[(((i15 + 1) * i) - i17) - 1];
                            iArr8[i13] = iArr8[i13] ^ i14;
                        }
                    }
                }
            }
            return new setBackgroundDrawable(i2, iArr7);
        }

        public static boolean getInstance(int[] iArr, int[] iArr2) {
            if (iArr.length != iArr2.length) {
                return false;
            }
            boolean z = true;
            for (int length = iArr.length - 1; length >= 0; length--) {
                z &= iArr[length] == iArr2[length];
            }
            return z;
        }

        public static int Cardinal(byte[] bArr, int i) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            byte b = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
            return ((bArr[i3 + 1] & 255) << Ascii.CAN) | b | ((bArr[i3] & 255) << 16);
        }

        public static int Cardinal(byte[] bArr, int i, int i2) {
            int i3 = 0;
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                i3 |= (bArr[i + i4] & 255) << (i4 << 3);
            }
            return i3;
        }

        public static void cca_continue(int i, byte[] bArr, int i2) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) i;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i >>> 8);
            bArr[i4] = (byte) (i >>> 16);
            bArr[i4 + 1] = (byte) (i >>> 24);
        }

        public static int getInstance(int i, int i2, int i3) {
            int Cardinal = Cardinal(i, i3);
            int Cardinal2 = Cardinal(i2, i3);
            int i4 = 0;
            if (Cardinal2 != 0) {
                int i5 = -1;
                for (int i6 = i3; i6 != 0; i6 >>>= 1) {
                    i5++;
                }
                int i7 = 1 << i5;
                while (Cardinal != 0) {
                    if (((byte) (Cardinal & 1)) == 1) {
                        i4 ^= Cardinal2;
                    }
                    Cardinal >>>= 1;
                    Cardinal2 <<= 1;
                    if (Cardinal2 >= i7) {
                        Cardinal2 ^= i3;
                    }
                }
            }
            return i4;
        }

        private static int Cardinal(int i, int i2) {
            if (i2 == 0) {
                System.err.println("Error: to be divided by 0");
                return 0;
            }
            while (true) {
                int i3 = -1;
                int i4 = -1;
                for (int i5 = i; i5 != 0; i5 >>>= 1) {
                    i4++;
                }
                int i6 = -1;
                for (int i7 = i2; i7 != 0; i7 >>>= 1) {
                    i6++;
                }
                if (i4 < i6) {
                    return i;
                }
                int i8 = -1;
                for (int i9 = i; i9 != 0; i9 >>>= 1) {
                    i8++;
                }
                for (int i10 = i2; i10 != 0; i10 >>>= 1) {
                    i3++;
                }
                i ^= i2 << (i8 - i3);
            }
        }

        public static boolean init(int i) {
            if (i == 0) {
                return false;
            }
            int i2 = -1;
            for (int i3 = i; i3 != 0; i3 >>>= 1) {
                i2++;
            }
            int i4 = i2 >>> 1;
            int i5 = 2;
            for (int i6 = 0; i6 < i4; i6++) {
                i5 = getInstance(i5, i5, i);
                int i7 = i5 ^ 2;
                int i8 = i;
                while (i8 != 0) {
                    int Cardinal = Cardinal(i7, i8);
                    i7 = i8;
                    i8 = Cardinal;
                }
                if (i7 != 1) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsaSha3_512 */
    public interface dsaSha3_512 {
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(init, "1.3.1.1.1.1");
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier init;

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.804.2.1.1.1");
            init = aSN1ObjectIdentifier;
            configure = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1.3.1.1");
            new ASN1ObjectIdentifier(init, "1.2.2.1");
            new ASN1ObjectIdentifier(init, "1.2.2.2");
            new ASN1ObjectIdentifier(init, "1.2.2.3");
            new ASN1ObjectIdentifier(init, "1.2.2.4");
            new ASN1ObjectIdentifier(init, "1.2.2.5");
            new ASN1ObjectIdentifier(init, "1.2.2.6");
            new ASN1ObjectIdentifier(init, "1.1.3.1.1");
            new ASN1ObjectIdentifier(init, "1.1.3.1.2");
            new ASN1ObjectIdentifier(init, "1.1.3.1.3");
            new ASN1ObjectIdentifier(init, "1.1.3.2.1");
            new ASN1ObjectIdentifier(init, "1.1.3.2.2");
            new ASN1ObjectIdentifier(init, "1.1.3.2.3");
            new ASN1ObjectIdentifier(init, "1.1.3.3.1");
            new ASN1ObjectIdentifier(init, "1.1.3.3.2");
            new ASN1ObjectIdentifier(init, "1.1.3.3.3");
            new ASN1ObjectIdentifier(init, "1.1.3.4.1");
            new ASN1ObjectIdentifier(init, "1.1.3.4.2");
            new ASN1ObjectIdentifier(init, "1.1.3.4.3");
            new ASN1ObjectIdentifier(init, "1.1.3.5.1");
            new ASN1ObjectIdentifier(init, "1.1.3.5.2");
            new ASN1ObjectIdentifier(init, "1.1.3.5.3");
            new ASN1ObjectIdentifier(init, "1.1.3.6.1");
            new ASN1ObjectIdentifier(init, "1.1.3.6.2");
            new ASN1ObjectIdentifier(init, "1.1.3.6.3");
            new ASN1ObjectIdentifier(init, "1.1.3.7.1");
            new ASN1ObjectIdentifier(init, "1.1.3.7.2");
            new ASN1ObjectIdentifier(init, "1.1.3.7.3");
            new ASN1ObjectIdentifier(init, "1.1.3.8.1");
            new ASN1ObjectIdentifier(init, "1.1.3.8.2");
            new ASN1ObjectIdentifier(init, "1.1.3.8.3");
            new ASN1ObjectIdentifier(init, "1.1.3.9.1");
            new ASN1ObjectIdentifier(init, "1.1.3.9.2");
            new ASN1ObjectIdentifier(init, "1.1.3.9.3");
            new ASN1ObjectIdentifier(init, "1.1.3.10.1");
            new ASN1ObjectIdentifier(init, "1.1.3.10.2");
            new ASN1ObjectIdentifier(init, "1.1.3.10.3");
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$noneDSA */
    public final class noneDSA implements Enumeration {
        private getUiType getInstance;
        private Object init;

        public noneDSA() {
        }

        private static setLocationDataConsentGiven getInstance(String str) {
            try {
                return setLocationDataConsentGiven.getInstance(setTextDirection.getInstance(str.substring(1)));
            } catch (IOException e) {
                throw new IllegalStateException("unknown encoding in name: ".concat(String.valueOf(e)));
            }
        }

        public static void getInstance(StringBuffer stringBuffer, dsa512 dsa512, Hashtable hashtable) {
            if (dsa512.configure()) {
                dsaSha3_256[] Cardinal = dsa512.Cardinal();
                boolean z = true;
                for (int i = 0; i != Cardinal.length; i++) {
                    if (z) {
                        z = false;
                    } else {
                        stringBuffer.append('+');
                    }
                    init(stringBuffer, Cardinal[i], hashtable);
                }
            } else if (dsa512.init() != null) {
                init(stringBuffer, dsa512.init(), hashtable);
            }
        }

        public static String init(getProxyAddress getproxyaddress) {
            int i;
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            if (!(getproxyaddress instanceof getExtendedData) || (getproxyaddress instanceof IES)) {
                try {
                    stringBuffer.append('#');
                    stringBuffer.append(setTextDirection.cca_continue(getproxyaddress.values().init(ASN1Encoding.DER)));
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Other value has no encoded form");
                }
            } else {
                String init2 = ((getExtendedData) getproxyaddress).init();
                if (init2.length() > 0 && init2.charAt(0) == '#') {
                    stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                }
                stringBuffer.append(init2);
            }
            int length = stringBuffer.length();
            int i3 = 2;
            if (!(stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#')) {
                i3 = 0;
            }
            while (i != length) {
                char charAt = stringBuffer.charAt(i);
                if (!(charAt == '\"' || charAt == '\\' || charAt == '+' || charAt == ',')) {
                    switch (charAt) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            i++;
                            continue;
                    }
                }
                stringBuffer.insert(i, "\\");
                i += 2;
                length++;
            }
            if (stringBuffer.length() > 0) {
                while (stringBuffer.length() > i2 && stringBuffer.charAt(i2) == ' ') {
                    stringBuffer.insert(i2, "\\");
                    i2 += 2;
                }
            }
            int length2 = stringBuffer.length() - 1;
            while (length2 >= 0 && stringBuffer.charAt(length2) == ' ') {
                stringBuffer.insert(length2, IOUtils.DIR_SEPARATOR_WINDOWS);
                length2--;
            }
            return stringBuffer.toString();
        }

        private static void init(StringBuffer stringBuffer, dsaSha3_256 dsasha3_256, Hashtable hashtable) {
            String str = (String) hashtable.get(dsasha3_256.configure);
            if (str != null) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append(dsasha3_256.configure.init);
            }
            stringBuffer.append('=');
            stringBuffer.append(init(dsasha3_256.getInstance));
        }

        public static String configure(String str) {
            String instance = setAnimation.getInstance(str);
            if (instance.length() > 0 && instance.charAt(0) == '#') {
                setLocationDataConsentGiven instance2 = getInstance(instance);
                if (instance2 instanceof getExtendedData) {
                    instance = setAnimation.getInstance(((getExtendedData) instance2).init());
                }
            }
            if (instance.length() > 1) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i2 < instance.length() && instance.charAt(i) == '\\' && instance.charAt(i2) == ' ') {
                        i += 2;
                    } else {
                        int length = instance.length() - 1;
                    }
                }
                int length2 = instance.length() - 1;
                while (true) {
                    int i3 = length2 - 1;
                    if (i3 > 0 && instance.charAt(i3) == '\\' && instance.charAt(length2) == ' ') {
                        length2 -= 2;
                    } else if (i > 0 || length2 < instance.length() - 1) {
                        instance = instance.substring(i, length2 + 1);
                    }
                }
                instance = instance.substring(i, length2 + 1);
            }
            if (instance.indexOf("  ") < 0) {
                return instance;
            }
            StringBuffer stringBuffer = new StringBuffer();
            char charAt = instance.charAt(0);
            stringBuffer.append(charAt);
            for (int i4 = 1; i4 < instance.length(); i4++) {
                char charAt2 = instance.charAt(i4);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                    charAt = charAt2;
                }
            }
            return stringBuffer.toString();
        }

        public static boolean configure(dsa512 dsa512, dsa512 dsa5122) {
            boolean configure = dsa512.configure();
            if (dsa5122.configure() != configure) {
                return false;
            }
            if (!configure) {
                return cca_continue(dsa512.init(), dsa5122.init());
            }
            if (dsa512.Cardinal.cca_continue.size() != dsa5122.Cardinal.cca_continue.size()) {
                return false;
            }
            dsaSha3_256[] Cardinal = dsa512.Cardinal();
            dsaSha3_256[] Cardinal2 = dsa5122.Cardinal();
            if (Cardinal.length != Cardinal2.length) {
                return false;
            }
            for (int i = 0; i != Cardinal.length; i++) {
                if (!cca_continue(Cardinal[i], Cardinal2[i])) {
                    return false;
                }
            }
            return true;
        }

        private static boolean cca_continue(dsaSha3_256 dsasha3_256, dsaSha3_256 dsasha3_2562) {
            if (dsasha3_256 == dsasha3_2562) {
                return true;
            }
            return dsasha3_256 != null && dsasha3_2562 != null && dsasha3_256.configure.equals(dsasha3_2562.configure) && configure(init(dsasha3_256.getInstance)).equals(configure(init(dsasha3_2562.getInstance)));
        }

        public noneDSA(byte[] bArr) {
            this.getInstance = new getUiType(bArr, (byte) 0);
            this.init = configure();
        }

        public final boolean hasMoreElements() {
            return this.init != null;
        }

        public final Object nextElement() {
            Object obj = this.init;
            this.init = configure();
            return obj;
        }

        private Object configure() {
            try {
                return this.getInstance.cca_continue();
            } catch (IOException e) {
                throw new setUICustomization("malformed DER construction: ".concat(String.valueOf(e)), e);
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$stdDSA */
    public final class stdDSA extends getThreeDSRequestorAppURL {
        public getProxyAddress cca_continue;
        public ASN1ObjectIdentifier init;

        public stdDSA(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            if (setthreedsrequestorappurl.getInstance() <= 0 || setthreedsrequestorappurl.getInstance() > 2) {
                StringBuilder sb = new StringBuilder("Bad sequence size: ");
                sb.append(setthreedsrequestorappurl.getInstance());
                throw new IllegalArgumentException(sb.toString());
            }
            this.init = ASN1ObjectIdentifier.getInstance(setthreedsrequestorappurl.Cardinal(0));
            this.cca_continue = setthreedsrequestorappurl.getInstance() == 2 ? setthreedsrequestorappurl.Cardinal(1) : null;
        }

        public stdDSA(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            this.init = aSN1ObjectIdentifier;
        }

        public stdDSA(ASN1ObjectIdentifier aSN1ObjectIdentifier, getProxyAddress getproxyaddress) {
            this.init = aSN1ObjectIdentifier;
            this.cca_continue = getproxyaddress;
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.init);
            getProxyAddress getproxyaddress = this.cca_continue;
            if (getproxyaddress != null) {
                setforegroundtintblendmode.cca_continue.addElement(getproxyaddress);
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    public DSASigner(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.f2356b = null;
        Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
        BigInteger bigInteger = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
        if (bigInteger.intValue() == 0 || bigInteger.intValue() == 1) {
            this.f2355a = bigInteger;
            this.cca_continue = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            this.configure = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            this.getInstance = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            this.init = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            this.Cardinal = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            this.cleanup = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            this.values = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            this.CardinalError = new BigInteger(((setProxyAddress) cca_continue2.nextElement()).Cardinal);
            if (cca_continue2.hasMoreElements()) {
                this.f2356b = (setThreeDSRequestorAppURL) cca_continue2.nextElement();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for RSA private key");
    }

    /* renamed from: com.cardinalcommerce.a.DSASigner$dsa256 */
    public abstract class dsa256 {
        private static getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
            getAcsTransactionID getacstransactionid2 = getacstransactionid;
            for (int i = 1; i < getacstransactionid.cca_continue(); i++) {
                getacstransactionid2 = getacstransactionid2.configure().cca_continue(getacstransactionid);
            }
            return getacstransactionid2;
        }

        private static getAcsTransactionID configure(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid) {
            getAcsTransactionID getacstransactionid2;
            if (getacstransactionid.cleanup()) {
                return getacstransactionid;
            }
            getAcsTransactionID configure = getsdkappid.configure(getSDKReferenceNumber.CardinalError);
            Random random = new Random();
            int cca_continue = getacstransactionid.cca_continue();
            do {
                getAcsTransactionID configure2 = getsdkappid.configure(new BigInteger(cca_continue, random));
                getAcsTransactionID getacstransactionid3 = getacstransactionid;
                getacstransactionid2 = configure;
                for (int i = 1; i <= cca_continue - 1; i++) {
                    getAcsTransactionID configure3 = getacstransactionid3.configure();
                    getacstransactionid2 = getacstransactionid2.configure().cca_continue(configure3.init(configure2));
                    getacstransactionid3 = configure3.cca_continue(getacstransactionid);
                }
                if (!getacstransactionid3.cleanup()) {
                    return null;
                }
            } while (getacstransactionid2.configure().cca_continue(getacstransactionid2).cleanup());
            return getacstransactionid2;
        }

        public static byte[] init(ChallengeParameters challengeParameters) {
            ChallengeParameters CardinalRenderType = challengeParameters.CardinalRenderType();
            getAcsTransactionID sDKVersion = CardinalRenderType.getSDKVersion();
            byte[] CardinalEnvironment = sDKVersion.CardinalEnvironment();
            if (!sDKVersion.cleanup()) {
                if (CardinalRenderType.CardinalEnvironment()) {
                    getAcsTransactionID instance = CardinalRenderType.CardinalError().getInstance(sDKVersion);
                    getAcsTransactionID getacstransactionid = instance;
                    for (int i = 1; i < instance.cca_continue(); i++) {
                        getacstransactionid = getacstransactionid.configure().cca_continue(instance);
                    }
                    if (getacstransactionid.CardinalError()) {
                        int length = CardinalEnvironment.length - 1;
                        CardinalEnvironment[length] = (byte) (1 | CardinalEnvironment[length]);
                    } else {
                        int length2 = CardinalEnvironment.length - 1;
                        CardinalEnvironment[length2] = (byte) (CardinalEnvironment[length2] & 254);
                    }
                } else {
                    throw new IllegalStateException("point not in normal form");
                }
            }
            return CardinalEnvironment;
        }

        public static ChallengeParameters cca_continue(getSDKAppID getsdkappid, byte[] bArr) {
            getAcsTransactionID configure = getsdkappid.configure(BigInteger.valueOf((long) (bArr[bArr.length - 1] & 1)));
            getAcsTransactionID configure2 = getsdkappid.configure(new BigInteger(1, bArr));
            if (!Cardinal(configure2).equals(getsdkappid.cleanup())) {
                configure2 = configure2.init();
            }
            getAcsTransactionID getacstransactionid = null;
            if (configure2.cleanup()) {
                getacstransactionid = getsdkappid.getWarnings().values();
            } else {
                getAcsTransactionID configure3 = configure(getsdkappid, configure2.configure().getSDKVersion().init(getsdkappid.getWarnings()).cca_continue(getsdkappid.cleanup()).cca_continue(configure2));
                if (configure3 != null) {
                    if (!Cardinal(configure3).equals(configure)) {
                        configure3 = configure3.init();
                    }
                    getacstransactionid = configure2.init(configure3);
                }
            }
            if (getacstransactionid != null) {
                ChallengeParameters Cardinal = getsdkappid.Cardinal(configure2.Cardinal(), getacstransactionid.Cardinal(), false);
                if (Cardinal.getActionCode()) {
                    return Cardinal;
                }
                throw new IllegalArgumentException("Invalid point coordinates");
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public static void configure(int[] iArr) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            int i5 = iArr[4];
            int i6 = iArr[5];
            int i7 = iArr[6];
            int i8 = iArr[7];
            int i9 = iArr[8];
            int i10 = iArr[9];
            int i11 = iArr[10];
            int i12 = iArr[11];
            int i13 = iArr[12];
            int i14 = iArr[13];
            int i15 = i3 + (i2 >>> 28);
            int i16 = i7 + (i6 >>> 28);
            int i17 = i11 + (i10 >>> 28);
            int i18 = iArr[14] + (i14 >>> 28);
            int i19 = i4 + (i15 >>> 28);
            int i20 = i8 + (i16 >>> 28);
            int i21 = i12 + (i17 >>> 28);
            int i22 = iArr[15] + (i18 >>> 28);
            int i23 = i22 >>> 28;
            int i24 = i + i23;
            int i25 = i5 + (i19 >>> 28);
            int i26 = i9 + i23 + (i20 >>> 28);
            int i27 = i13 + (i21 >>> 28);
            iArr[0] = i24 & 268435455;
            iArr[1] = (i2 & 268435455) + (i24 >>> 28);
            iArr[2] = i15 & 268435455;
            iArr[3] = i19 & 268435455;
            iArr[4] = i25 & 268435455;
            iArr[5] = (i6 & 268435455) + (i25 >>> 28);
            iArr[6] = i16 & 268435455;
            iArr[7] = i20 & 268435455;
            iArr[8] = i26 & 268435455;
            iArr[9] = (i10 & 268435455) + (i26 >>> 28);
            iArr[10] = i17 & 268435455;
            iArr[11] = i21 & 268435455;
            iArr[12] = i27 & 268435455;
            iArr[13] = (i14 & 268435455) + (i27 >>> 28);
            iArr[14] = i18 & 268435455;
            iArr[15] = i22 & 268435455;
        }

        public static void cca_continue(int[] iArr, int[] iArr2, int i) {
            for (int i2 = 0; i2 < 16; i2++) {
                iArr2[i2 + 0] = iArr[i2];
            }
        }

        public static void cca_continue(int i, int[] iArr, int[] iArr2) {
            int i2 = 0 - i;
            for (int i3 = 0; i3 < 16; i3++) {
                int i4 = iArr[i3];
                int i5 = iArr2[i3];
                int i6 = (i4 ^ i5) & i2;
                iArr[i3] = i4 ^ i6;
                iArr2[i3] = i5 ^ i6;
            }
        }

        public static void getInstance(byte[] bArr, int i, int[] iArr) {
            getInstance(bArr, 0, iArr, 0);
            getInstance(bArr, 7, iArr, 2);
            getInstance(bArr, 14, iArr, 4);
            getInstance(bArr, 21, iArr, 6);
            getInstance(bArr, 28, iArr, 8);
            getInstance(bArr, 35, iArr, 10);
            getInstance(bArr, 42, iArr, 12);
            getInstance(bArr, 49, iArr, 14);
        }

        private static int init(byte[] bArr, int i) {
            int i2 = i + 1;
            return ((bArr[i2 + 1] & 255) << 16) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        }

        private static int Cardinal(byte[] bArr, int i) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
        }

        private static void getInstance(byte[] bArr, int i, int[] iArr, int i2) {
            int Cardinal = Cardinal(bArr, i);
            int init = init(bArr, i + 4);
            iArr[i2] = 268435455 & Cardinal;
            iArr[i2 + 1] = (init << 4) | (Cardinal >>> 28);
        }

        public static void configure(int[] iArr, byte[] bArr, int i) {
            init(iArr, 0, bArr, i);
            init(iArr, 2, bArr, i + 7);
            init(iArr, 4, bArr, i + 14);
            init(iArr, 6, bArr, i + 21);
            init(iArr, 8, bArr, i + 28);
            init(iArr, 10, bArr, i + 35);
            init(iArr, 12, bArr, i + 42);
            init(iArr, 14, bArr, i + 49);
        }

        private static void getInstance(int i, byte[] bArr, int i2) {
            bArr[i2] = (byte) i;
            int i3 = i2 + 1;
            bArr[i3] = (byte) (i >>> 8);
            int i4 = i3 + 1;
            bArr[i4] = (byte) (i >>> 16);
            bArr[i4 + 1] = (byte) (i >>> 24);
        }

        private static void init(int[] iArr, int i, byte[] bArr, int i2) {
            int i3 = iArr[i];
            int i4 = iArr[i + 1];
            getInstance((i4 << 28) | i3, bArr, i2);
            int i5 = i4 >>> 4;
            int i6 = i2 + 4;
            bArr[i6] = (byte) i5;
            int i7 = i6 + 1;
            bArr[i7] = (byte) (i5 >>> 8);
            bArr[i7 + 1] = (byte) (i5 >>> 16);
        }

        public static void getInstance(int[] iArr, int[] iArr2) {
            int[] iArr3 = new int[16];
            Cardinal(iArr, iArr3);
            cca_continue(iArr3, iArr3);
            int i = 2;
            while (true) {
                i--;
                if (i > 0) {
                    cca_continue(iArr3, iArr3);
                } else {
                    cca_continue(iArr3, iArr, iArr2);
                    return;
                }
            }
        }

        public static boolean cca_continue(int[] iArr) {
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                i |= iArr[i2];
            }
            return i == 0;
        }

        public static void getInstance(int[] iArr, int i, int[] iArr2) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            int i6 = iArr[4];
            int i7 = iArr[5];
            int i8 = iArr[6];
            int i9 = iArr[7];
            int i10 = iArr[8];
            int i11 = iArr[9];
            int i12 = iArr[10];
            int i13 = iArr[11];
            int i14 = iArr[12];
            int i15 = iArr[13];
            int i16 = iArr[14];
            int i17 = i6;
            long j = (long) i3;
            long j2 = (long) i;
            long j3 = j * j2;
            int i18 = i2;
            int i19 = i14;
            long j4 = ((long) i7) * j2;
            int i20 = ((int) j3) & 268435455;
            long j5 = ((long) i11) * j2;
            int i21 = ((int) j4) & 268435455;
            long j6 = ((long) i15) * j2;
            int i22 = ((int) j5) & 268435455;
            long j7 = (j3 >>> 28) + (((long) i4) * j2);
            iArr2[2] = ((int) j7) & 268435455;
            long j8 = j7 >>> 28;
            long j9 = (j4 >>> 28) + (((long) i8) * j2);
            iArr2[6] = ((int) j9) & 268435455;
            long j10 = (j5 >>> 28) + (((long) i12) * j2);
            iArr2[10] = ((int) j10) & 268435455;
            long j11 = (j6 >>> 28) + (((long) i16) * j2);
            iArr2[14] = ((int) j11) & 268435455;
            long j12 = j8 + (((long) i5) * j2);
            iArr2[3] = ((int) j12) & 268435455;
            long j13 = (j9 >>> 28) + (((long) i9) * j2);
            iArr2[7] = ((int) j13) & 268435455;
            long j14 = (j10 >>> 28) + (((long) i13) * j2);
            iArr2[11] = ((int) j14) & 268435455;
            long j15 = (j11 >>> 28) + (((long) iArr[15]) * j2);
            iArr2[15] = ((int) j15) & 268435455;
            long j16 = j15 >>> 28;
            long j17 = (j12 >>> 28) + (((long) i17) * j2);
            iArr2[4] = ((int) j17) & 268435455;
            long j18 = (j13 >>> 28) + j16 + (((long) i10) * j2);
            iArr2[8] = ((int) j18) & 268435455;
            long j19 = (j14 >>> 28) + (((long) i19) * j2);
            iArr2[12] = ((int) j19) & 268435455;
            long j20 = j16 + (((long) i18) * j2);
            iArr2[0] = ((int) j20) & 268435455;
            iArr2[1] = i20 + ((int) (j20 >>> 28));
            iArr2[5] = i21 + ((int) (j17 >>> 28));
            iArr2[9] = i22 + ((int) (j18 >>> 28));
            iArr2[13] = (((int) j6) & 268435455) + ((int) (j19 >>> 28));
        }

        public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            int i5 = iArr[4];
            int i6 = iArr[5];
            int i7 = iArr[6];
            int i8 = iArr[7];
            int i9 = iArr[8];
            int i10 = iArr[9];
            int i11 = iArr[10];
            int i12 = iArr[11];
            int i13 = iArr[12];
            int i14 = iArr[13];
            int i15 = iArr[14];
            int i16 = i8;
            int i17 = iArr[15];
            int i18 = iArr2[0];
            int i19 = iArr2[1];
            int i20 = iArr2[2];
            int i21 = iArr2[3];
            int i22 = iArr2[4];
            int i23 = iArr2[5];
            int i24 = iArr2[6];
            int i25 = iArr2[7];
            int i26 = iArr2[8];
            int i27 = iArr2[9];
            int i28 = iArr2[10];
            int i29 = iArr2[11];
            int i30 = iArr2[12];
            int i31 = iArr2[13];
            int i32 = iArr2[14];
            int i33 = iArr2[15];
            int i34 = i + i9;
            int i35 = i2 + i10;
            int i36 = i3 + i11;
            int i37 = i4 + i12;
            int i38 = i5 + i13;
            int i39 = i6 + i14;
            int i40 = i7 + i15;
            int i41 = i16 + i17;
            int i42 = i19 + i27;
            int i43 = i21 + i29;
            int i44 = i23 + i31;
            int i45 = i25 + i33;
            long j = (long) i;
            int i46 = i9;
            long j2 = (long) i18;
            long j3 = j * j2;
            long j4 = j;
            long j5 = (long) i16;
            long j6 = j2;
            long j7 = (long) i19;
            long j8 = j5 * j7;
            long j9 = j5;
            long j10 = (long) i7;
            long j11 = j7;
            long j12 = (long) i20;
            long j13 = j8 + (j10 * j12);
            long j14 = j10;
            long j15 = (long) i6;
            long j16 = j12;
            long j17 = (long) i21;
            long j18 = j13 + (j15 * j17);
            long j19 = j15;
            long j20 = (long) i5;
            long j21 = j17;
            long j22 = (long) i22;
            long j23 = j18 + (j20 * j22);
            long j24 = j20;
            long j25 = (long) i4;
            long j26 = j22;
            long j27 = (long) i23;
            long j28 = j23 + (j25 * j27);
            long j29 = j25;
            long j30 = (long) i3;
            long j31 = j27;
            long j32 = (long) i24;
            long j33 = j28 + (j30 * j32);
            long j34 = j30;
            long j35 = (long) i2;
            long j36 = j32;
            long j37 = (long) i25;
            long j38 = j33 + (j35 * j37);
            long j39 = j37;
            long j40 = (long) i46;
            long j41 = j35;
            long j42 = (long) i26;
            long j43 = j40 * j42;
            long j44 = j40;
            long j45 = (long) i17;
            long j46 = j42;
            long j47 = (long) i27;
            long j48 = j45 * j47;
            long j49 = (long) i15;
            long j50 = j45;
            long j51 = (long) i28;
            long j52 = j48 + (j49 * j51);
            long j53 = (long) i14;
            long j54 = j49;
            long j55 = (long) i29;
            long j56 = (long) i13;
            long j57 = j53;
            long j58 = (long) i30;
            long j59 = j52 + (j53 * j55) + (j56 * j58);
            long j60 = (long) i12;
            long j61 = j56;
            long j62 = (long) i31;
            long j63 = (long) i11;
            long j64 = j60;
            long j65 = (long) i32;
            long j66 = j59 + (j60 * j62) + (j63 * j65);
            long j67 = j63;
            long j68 = (long) i10;
            long j69 = j65;
            long j70 = (long) i33;
            long j71 = j66 + (j68 * j70);
            long j72 = j70;
            long j73 = (long) i34;
            long j74 = j62;
            long j75 = (long) (i18 + i26);
            long j76 = j73 * j75;
            int i47 = i41;
            long j77 = j73;
            long j78 = (long) i47;
            long j79 = j75;
            long j80 = (long) i42;
            long j81 = j78 * j80;
            long j82 = j78;
            long j83 = (long) i40;
            long j84 = j80;
            long j85 = (long) (i20 + i28);
            long j86 = j81 + (j83 * j85);
            int i48 = i39;
            long j87 = j83;
            long j88 = (long) i48;
            long j89 = j85;
            long j90 = (long) i43;
            long j91 = j86 + (j88 * j90);
            long j92 = j88;
            long j93 = (long) i38;
            long j94 = j90;
            long j95 = (long) (i22 + i30);
            long j96 = j91 + (j93 * j95);
            int i49 = i37;
            long j97 = j93;
            long j98 = (long) i49;
            long j99 = j95;
            long j100 = (long) i44;
            long j101 = j96 + (j98 * j100);
            long j102 = j98;
            long j103 = (long) i36;
            long j104 = j100;
            long j105 = (long) (i24 + i32);
            long j106 = j103;
            long j107 = (long) i35;
            int i50 = i45;
            long j108 = j105;
            long j109 = (long) i50;
            long j110 = j101 + (j103 * j105) + (j107 * j109);
            long j111 = j109;
            long j112 = ((j3 + j43) + j110) - j38;
            long j113 = (j71 + j76) - j3;
            long j114 = j112 >>> 28;
            long j115 = j113 + j110;
            int i51 = ((int) j112) & 268435455;
            long j116 = (j41 * j6) + (j4 * j11);
            long j117 = (j107 * j79) + (j77 * j84);
            long j118 = (j82 * j89) + (j87 * j94) + (j92 * j99) + (j97 * j104) + (j102 * j108) + (j106 * j111);
            long j119 = ((j116 + ((j68 * j46) + (j44 * j47))) + j118) - ((((((j9 * j16) + (j14 * j21)) + (j19 * j26)) + (j24 * j31)) + (j29 * j36)) + (j34 * j39));
            long j120 = j107;
            long j121 = j114 + j119;
            int i52 = ((int) j115) & 268435455;
            long j122 = (j115 >>> 28) + ((((((((j50 * j51) + (j54 * j55)) + (j57 * j58)) + (j61 * j74)) + (j64 * j69)) + (j67 * j72)) + j117) - j116) + j118;
            int i53 = ((int) j121) & 268435455;
            long j123 = (j34 * j6) + (j41 * j11) + (j4 * j16);
            long j124 = (j82 * j94) + (j87 * j99) + (j92 * j104) + (j97 * j108) + (j102 * j111);
            long j125 = (j121 >>> 28) + (((j123 + (((j67 * j46) + (j68 * j47)) + (j44 * j51))) + j124) - (((((j9 * j21) + (j14 * j26)) + (j19 * j31)) + (j24 * j36)) + (j29 * j39)));
            int i54 = ((int) j122) & 268435455;
            long j126 = (j122 >>> 28) + (((((((j50 * j55) + (j54 * j58)) + (j57 * j74)) + (j61 * j69)) + (j64 * j72)) + (((j106 * j79) + (j120 * j84)) + (j77 * j89))) - j123) + j124;
            int i55 = ((int) j125) & 268435455;
            long j127 = (j29 * j6) + (j34 * j11) + (j41 * j16) + (j4 * j21);
            long j128 = (j82 * j99) + (j87 * j104) + (j92 * j108) + (j97 * j111);
            long j129 = (j125 >>> 28) + (((j127 + ((((j64 * j46) + (j67 * j47)) + (j68 * j51)) + (j44 * j55))) + j128) - ((((j9 * j26) + (j14 * j31)) + (j19 * j36)) + (j24 * j39)));
            int i56 = ((int) j126) & 268435455;
            long j130 = (j126 >>> 28) + ((((((j50 * j58) + (j54 * j74)) + (j57 * j69)) + (j61 * j72)) + ((((j102 * j79) + (j106 * j84)) + (j120 * j89)) + (j77 * j94))) - j127) + j128;
            int i57 = ((int) j129) & 268435455;
            long j131 = (j24 * j6) + (j29 * j11) + (j34 * j16) + (j41 * j21) + (j4 * j26);
            long j132 = (j82 * j104) + (j87 * j108) + (j92 * j111);
            long j133 = (j129 >>> 28) + (((j131 + (((((j61 * j46) + (j64 * j47)) + (j67 * j51)) + (j68 * j55)) + (j44 * j58))) + j132) - (((j9 * j31) + (j14 * j36)) + (j19 * j39)));
            int i58 = ((int) j130) & 268435455;
            long j134 = (j130 >>> 28) + (((((j50 * j74) + (j54 * j69)) + (j57 * j72)) + (((((j97 * j79) + (j102 * j84)) + (j106 * j89)) + (j120 * j94)) + (j77 * j99))) - j131) + j132;
            int i59 = ((int) j133) & 268435455;
            long j135 = (j19 * j6) + (j24 * j11) + (j29 * j16) + (j34 * j21) + (j41 * j26) + (j4 * j31);
            long j136 = (j82 * j108) + (j87 * j111);
            long j137 = (j133 >>> 28) + (((j135 + ((((((j57 * j46) + (j61 * j47)) + (j64 * j51)) + (j67 * j55)) + (j68 * j58)) + (j44 * j74))) + j136) - ((j9 * j36) + (j14 * j39)));
            int i60 = ((int) j134) & 268435455;
            long j138 = (j134 >>> 28) + ((((j50 * j69) + (j54 * j72)) + ((((((j92 * j79) + (j97 * j84)) + (j102 * j89)) + (j106 * j94)) + (j120 * j99)) + (j77 * j104))) - j135) + j136;
            int i61 = ((int) j137) & 268435455;
            long j139 = (j14 * j6) + (j19 * j11) + (j24 * j16) + (j29 * j21) + (j34 * j26) + (j41 * j31) + (j4 * j36);
            long j140 = j82 * j111;
            long j141 = (j137 >>> 28) + (((j139 + (((((((j54 * j46) + (j57 * j47)) + (j61 * j51)) + (j64 * j55)) + (j67 * j58)) + (j68 * j74)) + (j44 * j69))) + j140) - (j9 * j39));
            int i62 = ((int) j138) & 268435455;
            long j142 = (j138 >>> 28) + (((j50 * j72) + (((((((j87 * j79) + (j92 * j84)) + (j97 * j89)) + (j102 * j94)) + (j106 * j99)) + (j120 * j104)) + (j77 * j108))) - j139) + j140;
            int i63 = ((int) j141) & 268435455;
            long j143 = (j6 * j9) + (j11 * j14) + (j19 * j16) + (j24 * j21) + (j29 * j26) + (j34 * j31) + (j41 * j36) + (j4 * j39);
            long j144 = (j141 >>> 28) + j143 + (j50 * j46) + (j47 * j54) + (j57 * j51) + (j61 * j55) + (j64 * j58) + (j67 * j74) + (j68 * j69) + (j44 * j72);
            long j145 = (j142 >>> 28) + (((((((((j82 * j79) + (j87 * j84)) + (j92 * j89)) + (j97 * j94)) + (j102 * j99)) + (j106 * j104)) + (j120 * j108)) + (j77 * j111)) - j143);
            long j146 = j145 >>> 28;
            long j147 = (j144 >>> 28) + j146 + ((long) i52);
            long j148 = j146 + ((long) i51);
            iArr3[0] = ((int) j148) & 268435455;
            iArr3[1] = i53 + ((int) (j148 >>> 28));
            iArr3[2] = i55;
            iArr3[3] = i57;
            iArr3[4] = i59;
            iArr3[5] = i61;
            iArr3[6] = i63;
            iArr3[7] = ((int) j144) & 268435455;
            iArr3[8] = ((int) j147) & 268435455;
            iArr3[9] = i54 + ((int) (j147 >>> 28));
            iArr3[10] = i56;
            iArr3[11] = i58;
            iArr3[12] = i60;
            iArr3[13] = i62;
            iArr3[14] = ((int) j142) & 268435455;
            iArr3[15] = ((int) j145) & 268435455;
        }

        private static void Cardinal(int[] iArr, int[] iArr2) {
            int[] iArr3 = new int[16];
            cca_continue(iArr, iArr3);
            cca_continue(iArr, iArr3, iArr3);
            int[] iArr4 = new int[16];
            cca_continue(iArr3, iArr4);
            cca_continue(iArr, iArr4, iArr4);
            int[] iArr5 = new int[16];
            cca_continue(iArr4, iArr5);
            int i = 3;
            int i2 = 3;
            while (true) {
                i2--;
                if (i2 <= 0) {
                    break;
                }
                cca_continue(iArr5, iArr5);
            }
            cca_continue(iArr4, iArr5, iArr5);
            int[] iArr6 = new int[16];
            cca_continue(iArr5, iArr6);
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                cca_continue(iArr6, iArr6);
            }
            cca_continue(iArr4, iArr6, iArr6);
            int[] iArr7 = new int[16];
            int i3 = 9;
            cca_continue(iArr6, iArr7);
            while (true) {
                i3--;
                if (i3 <= 0) {
                    break;
                }
                cca_continue(iArr7, iArr7);
            }
            cca_continue(iArr6, iArr7, iArr7);
            int[] iArr8 = new int[16];
            cca_continue(iArr7, iArr8);
            cca_continue(iArr, iArr8, iArr8);
            int[] iArr9 = new int[16];
            int i4 = 18;
            cca_continue(iArr8, iArr9);
            while (true) {
                i4--;
                if (i4 <= 0) {
                    break;
                }
                cca_continue(iArr9, iArr9);
            }
            cca_continue(iArr7, iArr9, iArr9);
            int[] iArr10 = new int[16];
            cca_continue(iArr9, iArr10);
            int i5 = 37;
            int i6 = 37;
            while (true) {
                i6--;
                if (i6 <= 0) {
                    break;
                }
                cca_continue(iArr10, iArr10);
            }
            cca_continue(iArr9, iArr10, iArr10);
            int[] iArr11 = new int[16];
            cca_continue(iArr10, iArr11);
            while (true) {
                i5--;
                if (i5 <= 0) {
                    break;
                }
                cca_continue(iArr11, iArr11);
            }
            cca_continue(iArr9, iArr11, iArr11);
            int[] iArr12 = new int[16];
            int i7 = 111;
            cca_continue(iArr11, iArr12);
            while (true) {
                i7--;
                if (i7 <= 0) {
                    break;
                }
                cca_continue(iArr12, iArr12);
            }
            cca_continue(iArr11, iArr12, iArr12);
            int[] iArr13 = new int[16];
            cca_continue(iArr12, iArr13);
            cca_continue(iArr, iArr13, iArr13);
            int[] iArr14 = new int[16];
            int i8 = 223;
            cca_continue(iArr13, iArr14);
            while (true) {
                i8--;
                if (i8 > 0) {
                    cca_continue(iArr14, iArr14);
                } else {
                    cca_continue(iArr14, iArr12, iArr2);
                    return;
                }
            }
        }

        public static void configure(int[] iArr, int i) {
            int i2 = iArr[15];
            int i3 = i2 & 268435455;
            int i4 = (i2 >> 28) + i;
            iArr[8] = iArr[8] + i4;
            for (int i5 = 0; i5 < 15; i5++) {
                int i6 = i4 + iArr[i5];
                iArr[i5] = i6 & 268435455;
                i4 = i6 >> 28;
            }
            iArr[15] = i3 + i4;
        }

        public static void cca_continue(int[] iArr, int[] iArr2) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            int i5 = iArr[4];
            int i6 = iArr[5];
            int i7 = iArr[6];
            int i8 = iArr[7];
            int i9 = iArr[8];
            int i10 = iArr[9];
            int i11 = iArr[10];
            int i12 = iArr[11];
            int i13 = iArr[12];
            int i14 = iArr[13];
            int i15 = iArr[14];
            int i16 = iArr[15];
            int i17 = i << 1;
            int i18 = i2 << 1;
            int i19 = i3 << 1;
            int i20 = i4 << 1;
            int i21 = i5 << 1;
            int i22 = i6 << 1;
            int i23 = i7 << 1;
            int i24 = i9 << 1;
            int i25 = i10 << 1;
            int i26 = i11 << 1;
            int i27 = i12 << 1;
            int i28 = i13 << 1;
            int i29 = i14 << 1;
            int i30 = i15 << 1;
            int i31 = i + i9;
            int i32 = i9;
            int i33 = i2 + i10;
            int i34 = i10;
            int i35 = i3 + i11;
            int i36 = i11;
            int i37 = i4 + i12;
            int i38 = i12;
            int i39 = i5 + i13;
            int i40 = i4;
            int i41 = i6 + i14;
            int i42 = i3;
            int i43 = i7 + i15;
            int i44 = i2;
            int i45 = i31 << 1;
            int i46 = i33 << 1;
            int i47 = i33;
            int i48 = i35 << 1;
            int i49 = i35;
            int i50 = i37 << 1;
            int i51 = i37;
            int i52 = i39 << 1;
            int i53 = i41 << 1;
            int i54 = i41;
            int i55 = i39;
            long j = (long) i;
            long j2 = j * j;
            long j3 = (long) i8;
            int i56 = i18;
            int i57 = i48;
            long j4 = (long) i56;
            long j5 = j3 * j4;
            long j6 = j4;
            long j7 = (long) i7;
            long j8 = j3;
            long j9 = (long) i19;
            long j10 = (long) i6;
            long j11 = j7;
            long j12 = (long) i20;
            long j13 = j10;
            long j14 = (long) i5;
            long j15 = j5 + (j7 * j9) + (j10 * j12) + (j14 * j14);
            long j16 = j14;
            long j17 = (long) i32;
            long j18 = j12;
            long j19 = (long) i16;
            long j20 = j9;
            long j21 = (long) i25;
            long j22 = j19 * j21;
            int i58 = i43 << 1;
            long j23 = (long) i15;
            long j24 = j21;
            long j25 = (long) i26;
            long j26 = j22 + (j23 * j25);
            long j27 = j23;
            long j28 = (long) i14;
            long j29 = j25;
            long j30 = (long) i27;
            long j31 = j26 + (j28 * j30);
            long j32 = j28;
            long j33 = (long) i13;
            long j34 = j33;
            long j35 = (long) i31;
            long j36 = j30;
            long j37 = (long) (i8 + i16);
            long j38 = (long) i46;
            long j39 = j37 * j38;
            long j40 = (long) i43;
            long j41 = j38;
            long j42 = (long) i57;
            long j43 = j39 + (j40 * j42);
            long j44 = j40;
            long j45 = (long) i54;
            int i59 = i58;
            long j46 = (long) i50;
            int i60 = i55;
            long j47 = j45;
            long j48 = (long) i60;
            long j49 = j43 + (j45 * j46) + (j48 * j48);
            long j50 = ((j2 + (j17 * j17)) + j49) - j15;
            long j51 = (((j31 + (j33 * j33)) + (j35 * j35)) - j2) + j49;
            int i61 = ((int) j50) & 268435455;
            int i62 = ((int) j51) & 268435455;
            int i63 = i44;
            long j52 = j48;
            long j53 = (long) i63;
            long j54 = j51 >>> 28;
            long j55 = (long) i17;
            long j56 = j53 * j55;
            long j57 = j53;
            long j58 = (long) i21;
            long j59 = (j8 * j20) + (j11 * j18) + (j13 * j58);
            long j60 = j58;
            long j61 = (long) i34;
            long j62 = j55;
            long j63 = (long) i24;
            long j64 = j61 * j63;
            long j65 = (j19 * j29) + (j27 * j36);
            long j66 = j19;
            long j67 = (long) i28;
            long j68 = j65 + (j32 * j67);
            long j69 = j67;
            long j70 = (long) i47;
            int i64 = i45;
            long j71 = j61;
            long j72 = (long) i64;
            long j73 = (j37 * j42) + (j44 * j46);
            long j74 = j42;
            long j75 = (long) i52;
            long j76 = j73 + (j47 * j75);
            long j77 = (j50 >>> 28) + (((j56 + j64) + j76) - j59);
            int i65 = i59;
            long j78 = j54 + ((j68 + (j70 * j72)) - j56) + j76;
            long j79 = j78 >>> 28;
            int i66 = ((int) j77) & 268435455;
            long j80 = (long) i42;
            long j81 = (j80 * j62) + (j57 * j57);
            long j82 = j80;
            long j83 = (long) i36;
            long j84 = (j83 * j63) + (j71 * j71);
            long j85 = j83;
            long j86 = (long) i49;
            long j87 = (j86 * j72) + (j70 * j70);
            long j88 = (j37 * j46) + (j44 * j75) + (j47 * j47);
            long j89 = ((j81 + j84) + j88) - (((j8 * j18) + (j11 * j60)) + (j13 * j13));
            long j90 = (j77 >>> 28) + j89;
            long j91 = j79 + (((((j66 * j36) + (j27 * j69)) + (j32 * j32)) + j87) - j81) + j88;
            int i67 = ((int) j90) & 268435455;
            int i68 = ((int) j91) & 268435455;
            int i69 = i40;
            int i70 = ((int) j78) & 268435455;
            long j92 = (long) i69;
            long j93 = (j92 * j62) + (j82 * j6);
            long j94 = j92;
            long j95 = (long) i22;
            long j96 = (j8 * j60) + (j11 * j95);
            long j97 = j95;
            long j98 = (long) i38;
            long j99 = (j98 * j63) + (j85 * j24);
            long j100 = j66 * j69;
            long j101 = j98;
            long j102 = (long) i29;
            long j103 = j100 + (j27 * j102);
            long j104 = j102;
            long j105 = (long) i51;
            long j106 = j75 * j37;
            long j107 = j37;
            long j108 = (long) i53;
            long j109 = j106 + (j44 * j108);
            long j110 = (j90 >>> 28) + (((j93 + j99) + j109) - j96);
            long j111 = (j91 >>> 28) + ((j103 + ((j105 * j72) + (j86 * j41))) - j93) + j109;
            long j112 = (j16 * j62) + (j94 * j6) + (j82 * j82);
            long j113 = (j52 * j72) + (j105 * j41) + (j86 * j86);
            long j114 = (j107 * j108) + (j44 * j44);
            long j115 = (j110 >>> 28) + (((j112 + (((j34 * j63) + (j101 * j24)) + (j85 * j85))) + j114) - ((j8 * j97) + (j11 * j11)));
            int i71 = ((int) j111) & 268435455;
            long j116 = (j111 >>> 28) + ((((j66 * j104) + (j27 * j27)) + j113) - j112) + j114;
            long j117 = (j13 * j62) + (j16 * j6) + (j94 * j20);
            int i72 = i23;
            int i73 = ((int) j116) & 268435455;
            int i74 = ((int) j115) & 268435455;
            int i75 = i30;
            int i76 = ((int) j110) & 268435455;
            long j118 = (j47 * j72) + (j52 * j41) + (j105 * j74);
            long j119 = j105;
            long j120 = ((long) i65) * j107;
            long j121 = (j115 >>> 28) + (((j117 + (((j32 * j63) + (j34 * j24)) + (j101 * j29))) + j120) - (((long) i72) * j8));
            long j122 = (j116 >>> 28) + (((((long) i75) * j66) + j118) - j117) + j120;
            long j123 = (j11 * j62) + (j13 * j6) + (j16 * j20) + (j94 * j94);
            long j124 = (j44 * j72) + (j47 * j41) + (j52 * j74) + (j119 * j119);
            long j125 = j107 * j107;
            long j126 = (j121 >>> 28) + (((j123 + ((((j27 * j63) + (j32 * j24)) + (j34 * j29)) + (j101 * j101))) + j125) - (j8 * j8));
            long j127 = (j122 >>> 28) + (((j66 * j66) + j124) - j123) + j125;
            long j128 = (j8 * j62) + (j11 * j6) + (j13 * j20) + (j16 * j18);
            long j129 = (j126 >>> 28) + (j63 * j66) + (j27 * j24) + (j32 * j29) + (j34 * j36) + j128;
            long j130 = (j127 >>> 28) + (((((j72 * j107) + (j44 * j41)) + (j47 * j74)) + (j52 * j46)) - j128);
            long j131 = j130 >>> 28;
            long j132 = (j129 >>> 28) + j131 + ((long) i62);
            long j133 = j131 + ((long) i61);
            iArr2[0] = ((int) j133) & 268435455;
            iArr2[1] = i66 + ((int) (j133 >>> 28));
            iArr2[2] = i67;
            iArr2[3] = i76;
            iArr2[4] = i74;
            iArr2[5] = ((int) j121) & 268435455;
            iArr2[6] = ((int) j126) & 268435455;
            iArr2[7] = ((int) j129) & 268435455;
            iArr2[8] = ((int) j132) & 268435455;
            iArr2[9] = i70 + ((int) (j132 >>> 28));
            iArr2[10] = i68;
            iArr2[11] = i71;
            iArr2[12] = i73;
            iArr2[13] = ((int) j122) & 268435455;
            iArr2[14] = ((int) j127) & 268435455;
            iArr2[15] = ((int) j130) & 268435455;
        }

        public static boolean getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
            int[] iArr4 = new int[16];
            int[] iArr5 = new int[16];
            cca_continue(iArr, iArr4);
            cca_continue(iArr4, iArr2, iArr4);
            cca_continue(iArr4, iArr5);
            cca_continue(iArr4, iArr, iArr4);
            cca_continue(iArr5, iArr, iArr5);
            cca_continue(iArr5, iArr2, iArr5);
            int[] iArr6 = new int[16];
            Cardinal(iArr5, iArr6);
            cca_continue(iArr6, iArr4, iArr6);
            int[] iArr7 = new int[16];
            cca_continue(iArr6, iArr7);
            cca_continue(iArr7, iArr2, iArr7);
            Cardinal(iArr, iArr7, iArr7);
            configure(iArr7, 1);
            configure(iArr7, -1);
            boolean cca_continue = cca_continue(iArr7);
            if (!cca_continue) {
                return false;
            }
            for (int i = 0; i < 16; i++) {
                iArr3[i + 0] = iArr6[i];
            }
            return true;
        }

        public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            int i5 = iArr[4];
            int i6 = iArr[5];
            int i7 = iArr[6];
            int i8 = iArr[7];
            int i9 = iArr[8];
            int i10 = iArr[9];
            int i11 = iArr[10];
            int i12 = iArr[11];
            int i13 = iArr[12];
            int i14 = iArr[13];
            int i15 = iArr[14];
            int i16 = iArr[15];
            int i17 = iArr2[0];
            int i18 = iArr2[1];
            int i19 = iArr2[2];
            int i20 = iArr2[3];
            int i21 = iArr2[4];
            int i22 = iArr2[5];
            int i23 = iArr2[6];
            int i24 = iArr2[7];
            int i25 = iArr2[8];
            int i26 = iArr2[9];
            int i27 = iArr2[10];
            int i28 = iArr2[11];
            int i29 = iArr2[12];
            int i30 = iArr2[13];
            int i31 = (i2 + 536870910) - i18;
            int i32 = (i6 + 536870910) - i22;
            int i33 = (i10 + 536870910) - i26;
            int i34 = (i14 + 536870910) - i30;
            int i35 = ((i3 + 536870910) - i19) + (i31 >>> 28);
            int i36 = ((i7 + 536870910) - i23) + (i32 >>> 28);
            int i37 = ((i11 + 536870910) - i27) + (i33 >>> 28);
            int i38 = ((i15 + 536870910) - iArr2[14]) + (i34 >>> 28);
            int i39 = ((i4 + 536870910) - i20) + (i35 >>> 28);
            int i40 = ((i8 + 536870910) - i24) + (i36 >>> 28);
            int i41 = ((i12 + 536870910) - i28) + (i37 >>> 28);
            int i42 = ((i16 + 536870910) - iArr2[15]) + (i38 >>> 28);
            int i43 = i42 >>> 28;
            int i44 = ((i + 536870910) - i17) + i43;
            int i45 = ((i5 + 536870910) - i21) + (i39 >>> 28);
            int i46 = ((i9 + 536870908) - i25) + i43 + (i40 >>> 28);
            int i47 = ((i13 + 536870910) - i29) + (i41 >>> 28);
            iArr3[0] = i44 & 268435455;
            iArr3[1] = (i31 & 268435455) + (i44 >>> 28);
            iArr3[2] = i35 & 268435455;
            iArr3[3] = i39 & 268435455;
            iArr3[4] = i45 & 268435455;
            iArr3[5] = (i32 & 268435455) + (i45 >>> 28);
            iArr3[6] = i36 & 268435455;
            iArr3[7] = i40 & 268435455;
            iArr3[8] = i46 & 268435455;
            iArr3[9] = (i33 & 268435455) + (i46 >>> 28);
            iArr3[10] = i37 & 268435455;
            iArr3[11] = i41 & 268435455;
            iArr3[12] = i47 & 268435455;
            iArr3[13] = (i34 & 268435455) + (i47 >>> 28);
            iArr3[14] = i38 & 268435455;
            iArr3[15] = i42 & 268435455;
        }
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.f2355a));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.cca_continue));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.configure));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.getInstance));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.init));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.Cardinal));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.cleanup));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.values));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.CardinalError));
        setThreeDSRequestorAppURL setthreedsrequestorappurl = this.f2356b;
        if (setthreedsrequestorappurl != null) {
            setforegroundtintblendmode.cca_continue.addElement(setthreedsrequestorappurl);
        }
        return new GOST(setforegroundtintblendmode);
    }
}
