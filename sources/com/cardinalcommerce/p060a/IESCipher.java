package com.cardinalcommerce.p060a;

import androidx.exifinterface.media.ExifInterface;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.util.GlobalCountryCode;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.facebook.appevents.UserDataStore;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.asn1.ASN1Encoding;
import rui.config.RConfigConstants;

/* renamed from: com.cardinalcommerce.a.IESCipher */
public final class IESCipher extends KeyAgreementSpi.DHUwithSHA1KDF {

    /* renamed from: b */
    private static final byte[] f2441b = new byte[0];

    /* renamed from: a */
    int f2442a;

    /* renamed from: c */
    private final int f2443c;

    /* renamed from: com.cardinalcommerce.a.IESCipher$ECIES */
    public abstract class ECIES {
        public abstract setLocationDataConsentGiven Cardinal();
    }

    /* renamed from: com.cardinalcommerce.a.IESCipher$IESwithAESCBC */
    public final class IESwithAESCBC extends setThreeDSRequestorAppURL {
        private int cca_continue = -1;

        public IESwithAESCBC() {
        }

        public IESwithAESCBC(getProxyAddress getproxyaddress) {
            super(getproxyaddress);
        }

        public IESwithAESCBC(setForegroundTintBlendMode setforegroundtintblendmode) {
            super(setforegroundtintblendmode);
        }

        private int cleanup() throws IOException {
            if (this.cca_continue < 0) {
                int i = 0;
                Enumeration cca_continue2 = cca_continue();
                while (cca_continue2.hasMoreElements()) {
                    i += ((getProxyAddress) cca_continue2.nextElement()).values().getWarnings().configure();
                }
                this.cca_continue = i;
            }
            return this.cca_continue;
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            setEnableDFSync init = setenabledfsync.init();
            int cleanup = cleanup();
            setenabledfsync.configure(48);
            setenabledfsync.Cardinal(cleanup);
            Enumeration cca_continue2 = cca_continue();
            while (cca_continue2.hasMoreElements()) {
                init.init((getProxyAddress) cca_continue2.nextElement());
            }
        }

        /* access modifiers changed from: package-private */
        public final int configure() throws IOException {
            int cleanup = cleanup();
            return KeyAgreementSpi.Cardinal(cleanup) + 1 + cleanup;
        }
    }

    public IESCipher(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this.f2443c = i;
            this.f2442a = i;
            if (i == 0) {
                cca_continue();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    public final byte[] configure() throws IOException {
        int i = this.f2442a;
        if (i == 0) {
            return f2441b;
        }
        byte[] bArr = new byte[i];
        int init = i - setTooltipText.init(this.getInstance, bArr);
        this.f2442a = init;
        if (init == 0) {
            cca_continue();
            return bArr;
        }
        StringBuilder sb = new StringBuilder("DEF length ");
        sb.append(this.f2443c);
        sb.append(" object truncated by ");
        sb.append(this.f2442a);
        throw new EOFException(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public final int getInstance() {
        return this.f2442a;
    }

    public final int read() throws IOException {
        if (this.f2442a == 0) {
            return -1;
        }
        int read = this.getInstance.read();
        if (read >= 0) {
            int i = this.f2442a - 1;
            this.f2442a = i;
            if (i == 0) {
                cca_continue();
            }
            return read;
        }
        StringBuilder sb = new StringBuilder("DEF length ");
        sb.append(this.f2443c);
        sb.append(" object truncated by ");
        sb.append(this.f2442a);
        throw new EOFException(sb.toString());
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f2442a;
        if (i3 == 0) {
            return -1;
        }
        int read = this.getInstance.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this.f2442a - read;
            this.f2442a = i4;
            if (i4 == 0) {
                cca_continue();
            }
            return read;
        }
        StringBuilder sb = new StringBuilder("DEF length ");
        sb.append(this.f2443c);
        sb.append(" object truncated by ");
        sb.append(this.f2442a);
        throw new EOFException(sb.toString());
    }

    /* renamed from: com.cardinalcommerce.a.IESCipher$ECIESwithAESCBC */
    public class ECIESwithAESCBC extends getThreeDSRequestorAppURL {
        private static ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier("2.5.4.6");
        private static ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier("2.5.4.42");
        private static ASN1ObjectIdentifier CardinalConfigurationParameters = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
        private static ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier("2.5.4.44");
        private static ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier("2.5.4.5");
        private static ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier("2.5.4.43");
        private static ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier("2.5.4.15");
        private static ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier("2.5.4.10");
        private static ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier("2.5.4.7");
        private static ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier("2.5.4.3");
        private static ASN1ObjectIdentifier getActionCode = new ASN1ObjectIdentifier("2.5.4.65");
        private static ASN1ObjectIdentifier getChallengeTimeout = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
        private static ASN1ObjectIdentifier getEnvironment = new ASN1ObjectIdentifier("2.5.4.16");
        private static ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier("2.5.4.11");
        private static ASN1ObjectIdentifier getProxyAddress = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
        private static ASN1ObjectIdentifier getRenderType = KeyFactorySpi.getUICustomization;
        private static ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier("2.5.4.17");
        private static ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier("2.5.4.8");
        private static ASN1ObjectIdentifier getString = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
        private static Hashtable getThreeDSRequestorAppURL = new Hashtable();
        private static ASN1ObjectIdentifier getUICustomization = getUiType;
        private static ASN1ObjectIdentifier getUiType = KeyFactorySpi.setEnableDFSync;
        private static ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier("2.5.4.9");
        private static ASN1ObjectIdentifier init = new ASN1ObjectIdentifier("2.5.4.12");
        private static ASN1ObjectIdentifier isEnableDFSync = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        private static Hashtable isEnableLogging = new Hashtable();
        private static Hashtable isLocationDataConsentGiven = new Hashtable();
        private static ASN1ObjectIdentifier setChallengeTimeout = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
        private static ASN1ObjectIdentifier setEnableDFSync = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        private static final Boolean setEnableLogging = Boolean.TRUE;
        private static ASN1ObjectIdentifier setEnvironment = new ASN1ObjectIdentifier("1.3.36.8.3.14");
        private static final Boolean setLocationDataConsentGiven = Boolean.FALSE;
        private static ASN1ObjectIdentifier setProxyAddress = ECIESwithDESedeCBC.f2445b_;
        private static ASN1ObjectIdentifier setRenderType = ECIESwithDESedeCBC.f2444a_;
        private static ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier("2.5.4.46");
        private static Hashtable setUICustomization = new Hashtable();
        private static ASN1ObjectIdentifier setUiType = KeyFactorySpi.setUICustomization;
        private static ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier("2.5.4.45");
        private static ASN1ObjectIdentifier values = new ASN1ObjectIdentifier("2.5.4.4");
        private Vector Payment = new Vector();
        private setThreeDSRequestorAppURL getExtendedData;
        private boolean getJSON;
        private int getProcessorTransactionId;
        private Vector getType = new Vector();
        private Vector setThreeDSRequestorAppURL = new Vector();

        static {
            new ASN1ObjectIdentifier("2.5.4.54");
            getThreeDSRequestorAppURL.put(Cardinal, "C");
            getThreeDSRequestorAppURL.put(cca_continue, "O");
            getThreeDSRequestorAppURL.put(init, "T");
            getThreeDSRequestorAppURL.put(getInstance, "OU");
            getThreeDSRequestorAppURL.put(configure, GlobalCountryCode.CHINA);
            getThreeDSRequestorAppURL.put(cleanup, "L");
            getThreeDSRequestorAppURL.put(getSDKVersion, "ST");
            getThreeDSRequestorAppURL.put(CardinalError, "SERIALNUMBER");
            getThreeDSRequestorAppURL.put(getUiType, ExifInterface.LONGITUDE_EAST);
            getThreeDSRequestorAppURL.put(setEnableDFSync, "DC");
            getThreeDSRequestorAppURL.put(isEnableDFSync, "UID");
            getThreeDSRequestorAppURL.put(getWarnings, "STREET");
            getThreeDSRequestorAppURL.put(values, "SURNAME");
            getThreeDSRequestorAppURL.put(CardinalActionCode, "GIVENNAME");
            getThreeDSRequestorAppURL.put(CardinalRenderType, "INITIALS");
            getThreeDSRequestorAppURL.put(CardinalEnvironment, "GENERATION");
            getThreeDSRequestorAppURL.put(getRenderType, "unstructuredAddress");
            getThreeDSRequestorAppURL.put(setUiType, "unstructuredName");
            getThreeDSRequestorAppURL.put(valueOf, "UniqueIdentifier");
            getThreeDSRequestorAppURL.put(setRequestTimeout, "DN");
            getThreeDSRequestorAppURL.put(getActionCode, "Pseudonym");
            getThreeDSRequestorAppURL.put(getEnvironment, "PostalAddress");
            getThreeDSRequestorAppURL.put(setEnvironment, "NameAtBirth");
            getThreeDSRequestorAppURL.put(getChallengeTimeout, "CountryOfCitizenship");
            getThreeDSRequestorAppURL.put(getProxyAddress, "CountryOfResidence");
            getThreeDSRequestorAppURL.put(setChallengeTimeout, "Gender");
            getThreeDSRequestorAppURL.put(CardinalConfigurationParameters, "PlaceOfBirth");
            getThreeDSRequestorAppURL.put(getString, "DateOfBirth");
            getThreeDSRequestorAppURL.put(getRequestTimeout, "PostalCode");
            getThreeDSRequestorAppURL.put(CardinalUiType, "BusinessCategory");
            getThreeDSRequestorAppURL.put(setRenderType, "TelephoneNumber");
            getThreeDSRequestorAppURL.put(setProxyAddress, "Name");
            setUICustomization.put(Cardinal, "C");
            setUICustomization.put(cca_continue, "O");
            setUICustomization.put(getInstance, "OU");
            setUICustomization.put(configure, GlobalCountryCode.CHINA);
            setUICustomization.put(cleanup, "L");
            setUICustomization.put(getSDKVersion, "ST");
            setUICustomization.put(getWarnings, "STREET");
            setUICustomization.put(setEnableDFSync, "DC");
            setUICustomization.put(isEnableDFSync, "UID");
            isEnableLogging.put(Cardinal, "C");
            isEnableLogging.put(cca_continue, "O");
            isEnableLogging.put(getInstance, "OU");
            isEnableLogging.put(configure, GlobalCountryCode.CHINA);
            isEnableLogging.put(cleanup, "L");
            isEnableLogging.put(getSDKVersion, "ST");
            isEnableLogging.put(getWarnings, "STREET");
            isLocationDataConsentGiven.put("c", Cardinal);
            isLocationDataConsentGiven.put("o", cca_continue);
            isLocationDataConsentGiven.put(RavenKey.TYPE, init);
            isLocationDataConsentGiven.put("ou", getInstance);
            isLocationDataConsentGiven.put("cn", configure);
            isLocationDataConsentGiven.put("l", cleanup);
            isLocationDataConsentGiven.put(UserDataStore.STATE, getSDKVersion);
            isLocationDataConsentGiven.put("sn", CardinalError);
            isLocationDataConsentGiven.put("serialnumber", CardinalError);
            isLocationDataConsentGiven.put("street", getWarnings);
            isLocationDataConsentGiven.put("emailaddress", getUICustomization);
            isLocationDataConsentGiven.put("dc", setEnableDFSync);
            isLocationDataConsentGiven.put("e", getUICustomization);
            isLocationDataConsentGiven.put("uid", isEnableDFSync);
            isLocationDataConsentGiven.put("surname", values);
            isLocationDataConsentGiven.put("givenname", CardinalActionCode);
            isLocationDataConsentGiven.put("initials", CardinalRenderType);
            isLocationDataConsentGiven.put("generation", CardinalEnvironment);
            isLocationDataConsentGiven.put("unstructuredaddress", getRenderType);
            isLocationDataConsentGiven.put("unstructuredname", setUiType);
            isLocationDataConsentGiven.put("uniqueidentifier", valueOf);
            isLocationDataConsentGiven.put("dn", setRequestTimeout);
            isLocationDataConsentGiven.put("pseudonym", getActionCode);
            isLocationDataConsentGiven.put("postaladdress", getEnvironment);
            isLocationDataConsentGiven.put("nameofbirth", setEnvironment);
            isLocationDataConsentGiven.put("countryofcitizenship", getChallengeTimeout);
            isLocationDataConsentGiven.put("countryofresidence", getProxyAddress);
            isLocationDataConsentGiven.put("gender", setChallengeTimeout);
            isLocationDataConsentGiven.put("placeofbirth", CardinalConfigurationParameters);
            isLocationDataConsentGiven.put("dateofbirth", getString);
            isLocationDataConsentGiven.put("postalcode", getRequestTimeout);
            isLocationDataConsentGiven.put("businesscategory", CardinalUiType);
            isLocationDataConsentGiven.put("telephonenumber", setRenderType);
            isLocationDataConsentGiven.put("name", setProxyAddress);
        }

        protected ECIESwithAESCBC() {
        }

        private boolean Cardinal(String str, String str2) {
            String cca_continue2 = cca_continue(str);
            String cca_continue3 = cca_continue(str2);
            return cca_continue2.equals(cca_continue3) || configure(cca_continue2).equals(configure(cca_continue3));
        }

        private static String cca_continue(String str) {
            String instance = setAnimation.getInstance(str.trim());
            if (instance.length() <= 0 || instance.charAt(0) != '#') {
                return instance;
            }
            setLocationDataConsentGiven instance2 = getInstance(instance);
            return instance2 instanceof getExtendedData ? setAnimation.getInstance(((getExtendedData) instance2).init().trim()) : instance;
        }

        private static String configure(String str) {
            StringBuffer stringBuffer = new StringBuffer();
            if (str.length() != 0) {
                char charAt = str.charAt(0);
                stringBuffer.append(charAt);
                int i = 1;
                while (i < str.length()) {
                    char charAt2 = str.charAt(i);
                    if (charAt != ' ' || charAt2 != ' ') {
                        stringBuffer.append(charAt2);
                    }
                    i++;
                    charAt = charAt2;
                }
            }
            return stringBuffer.toString();
        }

        private static String configure(byte[] bArr) {
            int length = bArr.length;
            char[] cArr = new char[length];
            for (int i = 0; i != length; i++) {
                cArr[i] = (char) (bArr[i] & 255);
            }
            return new String(cArr);
        }

        private static setLocationDataConsentGiven getInstance(String str) {
            try {
                return setLocationDataConsentGiven.getInstance(setTextDirection.getInstance(str.substring(1)));
            } catch (IOException e) {
                throw new IllegalStateException("unknown encoding in name: ".concat(String.valueOf(e)));
            }
        }

        public int hashCode() {
            if (this.getJSON) {
                return this.getProcessorTransactionId;
            }
            this.getJSON = true;
            for (int i = 0; i != this.setThreeDSRequestorAppURL.size(); i++) {
                String configure2 = configure(cca_continue((String) this.getType.elementAt(i)));
                int hashCode = this.getProcessorTransactionId ^ this.setThreeDSRequestorAppURL.elementAt(i).hashCode();
                this.getProcessorTransactionId = hashCode;
                this.getProcessorTransactionId = configure2.hashCode() ^ hashCode;
            }
            return this.getProcessorTransactionId;
        }

        public ECIESwithAESCBC(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            Vector vector;
            this.getExtendedData = setthreedsrequestorappurl;
            Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
            while (cca_continue2.hasMoreElements()) {
                isEnableLogging Cardinal2 = isEnableLogging.Cardinal((Object) ((getProxyAddress) cca_continue2.nextElement()).values());
                int i = 0;
                while (true) {
                    if (i < Cardinal2.cca_continue.size()) {
                        setThreeDSRequestorAppURL cca_continue3 = setThreeDSRequestorAppURL.cca_continue((Object) ((getProxyAddress) Cardinal2.cca_continue.elementAt(i)).values());
                        if (cca_continue3.getInstance() == 2) {
                            this.setThreeDSRequestorAppURL.addElement(ASN1ObjectIdentifier.getInstance(cca_continue3.Cardinal(0)));
                            getProxyAddress Cardinal3 = cca_continue3.Cardinal(1);
                            if (!(Cardinal3 instanceof getExtendedData) || (Cardinal3 instanceof IES)) {
                                try {
                                    Vector vector2 = this.getType;
                                    StringBuilder sb = new StringBuilder(RConfigConstants.KEYWORD_COLOR_SIGN);
                                    sb.append(configure(setTextDirection.configure(Cardinal3.values().init(ASN1Encoding.DER))));
                                    vector2.addElement(sb.toString());
                                } catch (IOException unused) {
                                    throw new IllegalArgumentException("cannot encode value");
                                }
                            } else {
                                String init2 = ((getExtendedData) Cardinal3).init();
                                if (init2.length() <= 0 || init2.charAt(0) != '#') {
                                    vector = this.getType;
                                } else {
                                    vector = this.getType;
                                    init2 = "\\".concat(String.valueOf(init2));
                                }
                                vector.addElement(init2);
                            }
                            this.Payment.addElement(i != 0 ? setEnableLogging : setLocationDataConsentGiven);
                            i++;
                        } else {
                            throw new IllegalArgumentException("badly sized pair");
                        }
                    }
                }
            }
        }

        public final setLocationDataConsentGiven values() {
            if (this.getExtendedData == null) {
                setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
                setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
                int i = 0;
                ECIES ecies = null;
                Object obj = ecies;
                while (i != this.setThreeDSRequestorAppURL.size()) {
                    setForegroundTintBlendMode setforegroundtintblendmode3 = new setForegroundTintBlendMode();
                    Object obj2 = (ASN1ObjectIdentifier) this.setThreeDSRequestorAppURL.elementAt(i);
                    setforegroundtintblendmode3.cca_continue.addElement(obj2);
                    this.getType.elementAt(i);
                    setforegroundtintblendmode3.cca_continue.addElement(ecies.Cardinal());
                    if (obj == null || ((Boolean) this.Payment.elementAt(i)).booleanValue()) {
                        setforegroundtintblendmode2.cca_continue.addElement(new GOST(setforegroundtintblendmode3));
                    } else {
                        setforegroundtintblendmode.cca_continue.addElement(new GOST.Mappings(setforegroundtintblendmode2));
                        setforegroundtintblendmode2 = new setForegroundTintBlendMode();
                        setforegroundtintblendmode2.cca_continue.addElement(new GOST(setforegroundtintblendmode3));
                    }
                    i++;
                    obj = obj2;
                }
                setforegroundtintblendmode.cca_continue.addElement(new GOST.Mappings(setforegroundtintblendmode2));
                this.getExtendedData = new GOST(setforegroundtintblendmode);
            }
            return this.getExtendedData;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r12) {
            /*
                r11 = this;
                r0 = 1
                if (r12 != r11) goto L_0x0004
                return r0
            L_0x0004:
                boolean r1 = r12 instanceof com.cardinalcommerce.p060a.IESCipher.ECIESwithAESCBC
                r2 = 0
                if (r1 != 0) goto L_0x000e
                boolean r1 = r12 instanceof com.cardinalcommerce.p060a.setThreeDSRequestorAppURL
                if (r1 != 0) goto L_0x000e
                return r2
            L_0x000e:
                r1 = r12
                com.cardinalcommerce.a.getProxyAddress r1 = (com.cardinalcommerce.p060a.getProxyAddress) r1
                com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r1.values()
                com.cardinalcommerce.a.setLocationDataConsentGiven r3 = r11.values()
                boolean r1 = r3.equals(r1)
                if (r1 == 0) goto L_0x0020
                return r0
            L_0x0020:
                if (r12 == 0) goto L_0x0049
                boolean r1 = r12 instanceof com.cardinalcommerce.p060a.IESCipher.ECIESwithAESCBC     // Catch:{ IllegalArgumentException -> 0x00ba }
                if (r1 == 0) goto L_0x0027
                goto L_0x0049
            L_0x0027:
                boolean r1 = r12 instanceof com.cardinalcommerce.p060a.DSASigner.dsaSha3_224     // Catch:{ IllegalArgumentException -> 0x00ba }
                if (r1 == 0) goto L_0x003b
                com.cardinalcommerce.a.IESCipher$ECIESwithAESCBC r1 = new com.cardinalcommerce.a.IESCipher$ECIESwithAESCBC     // Catch:{ IllegalArgumentException -> 0x00ba }
                com.cardinalcommerce.a.DSASigner$dsaSha3_224 r12 = (com.cardinalcommerce.p060a.DSASigner.dsaSha3_224) r12     // Catch:{ IllegalArgumentException -> 0x00ba }
                com.cardinalcommerce.a.setLocationDataConsentGiven r12 = r12.values()     // Catch:{ IllegalArgumentException -> 0x00ba }
                com.cardinalcommerce.a.setThreeDSRequestorAppURL r12 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r12)     // Catch:{ IllegalArgumentException -> 0x00ba }
                r1.<init>(r12)     // Catch:{ IllegalArgumentException -> 0x00ba }
                goto L_0x004c
            L_0x003b:
                if (r12 == 0) goto L_0x0047
                com.cardinalcommerce.a.IESCipher$ECIESwithAESCBC r1 = new com.cardinalcommerce.a.IESCipher$ECIESwithAESCBC     // Catch:{ IllegalArgumentException -> 0x00ba }
                com.cardinalcommerce.a.setThreeDSRequestorAppURL r12 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r12)     // Catch:{ IllegalArgumentException -> 0x00ba }
                r1.<init>(r12)     // Catch:{ IllegalArgumentException -> 0x00ba }
                goto L_0x004c
            L_0x0047:
                r1 = 0
                goto L_0x004c
            L_0x0049:
                r1 = r12
                com.cardinalcommerce.a.IESCipher$ECIESwithAESCBC r1 = (com.cardinalcommerce.p060a.IESCipher.ECIESwithAESCBC) r1     // Catch:{ IllegalArgumentException -> 0x00ba }
            L_0x004c:
                java.util.Vector r12 = r11.setThreeDSRequestorAppURL
                int r12 = r12.size()
                java.util.Vector r3 = r1.setThreeDSRequestorAppURL
                int r3 = r3.size()
                if (r12 == r3) goto L_0x005b
                return r2
            L_0x005b:
                boolean[] r3 = new boolean[r12]
                java.util.Vector r4 = r11.setThreeDSRequestorAppURL
                java.lang.Object r4 = r4.elementAt(r2)
                java.util.Vector r5 = r1.setThreeDSRequestorAppURL
                java.lang.Object r5 = r5.elementAt(r2)
                boolean r4 = r4.equals(r5)
                r5 = -1
                if (r4 == 0) goto L_0x0074
                r5 = r12
                r4 = 0
                r6 = 1
                goto L_0x0077
            L_0x0074:
                int r4 = r12 + -1
                r6 = -1
            L_0x0077:
                if (r4 == r5) goto L_0x00b9
                java.util.Vector r7 = r11.setThreeDSRequestorAppURL
                java.lang.Object r7 = r7.elementAt(r4)
                com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r7 = (com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r7
                java.util.Vector r8 = r11.getType
                java.lang.Object r8 = r8.elementAt(r4)
                java.lang.String r8 = (java.lang.String) r8
                r9 = 0
            L_0x008a:
                if (r9 >= r12) goto L_0x00b3
                boolean r10 = r3[r9]
                if (r10 != 0) goto L_0x00b0
                java.util.Vector r10 = r1.setThreeDSRequestorAppURL
                java.lang.Object r10 = r10.elementAt(r9)
                com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r10 = (com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r10
                boolean r10 = r7.equals(r10)
                if (r10 == 0) goto L_0x00b0
                java.util.Vector r10 = r1.getType
                java.lang.Object r10 = r10.elementAt(r9)
                java.lang.String r10 = (java.lang.String) r10
                boolean r10 = r11.Cardinal(r8, r10)
                if (r10 == 0) goto L_0x00b0
                r3[r9] = r0
                r7 = 1
                goto L_0x00b4
            L_0x00b0:
                int r9 = r9 + 1
                goto L_0x008a
            L_0x00b3:
                r7 = 0
            L_0x00b4:
                if (r7 != 0) goto L_0x00b7
                return r2
            L_0x00b7:
                int r4 = r4 + r6
                goto L_0x0077
            L_0x00b9:
                return r0
            L_0x00ba:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.IESCipher.ECIESwithAESCBC.equals(java.lang.Object):boolean");
        }

        private static void cca_continue(StringBuffer stringBuffer, Hashtable hashtable, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
            int i;
            String str2 = (String) hashtable.get(aSN1ObjectIdentifier);
            if (str2 != null) {
                stringBuffer.append(str2);
            } else {
                stringBuffer.append(aSN1ObjectIdentifier.init);
            }
            stringBuffer.append('=');
            int length = stringBuffer.length();
            stringBuffer.append(str);
            int length2 = stringBuffer.length();
            if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
                length += 2;
            }
            while (i < length2 && stringBuffer.charAt(i) == ' ') {
                stringBuffer.insert(i, "\\");
                length = i + 2;
                length2++;
            }
            while (true) {
                length2--;
                if (length2 > i && stringBuffer.charAt(length2) == ' ') {
                    stringBuffer.insert(length2, IOUtils.DIR_SEPARATOR_WINDOWS);
                }
            }
            while (i <= length2) {
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
                length2++;
            }
        }

        public String toString() {
            Hashtable hashtable = getThreeDSRequestorAppURL;
            StringBuffer stringBuffer = new StringBuffer();
            Vector vector = new Vector();
            StringBuffer stringBuffer2 = null;
            for (int i = 0; i < this.setThreeDSRequestorAppURL.size(); i++) {
                if (((Boolean) this.Payment.elementAt(i)).booleanValue()) {
                    stringBuffer2.append('+');
                    cca_continue(stringBuffer2, hashtable, (ASN1ObjectIdentifier) this.setThreeDSRequestorAppURL.elementAt(i), (String) this.getType.elementAt(i));
                } else {
                    stringBuffer2 = new StringBuffer();
                    cca_continue(stringBuffer2, hashtable, (ASN1ObjectIdentifier) this.setThreeDSRequestorAppURL.elementAt(i), (String) this.getType.elementAt(i));
                    vector.addElement(stringBuffer2);
                }
            }
            boolean z = true;
            for (int i2 = 0; i2 < vector.size(); i2++) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(i2).toString());
            }
            return stringBuffer.toString();
        }
    }

    /* renamed from: com.cardinalcommerce.a.IESCipher$ECIESwithCipher */
    public final class ECIESwithCipher {
        private int configure;
        private String getInstance;

        public ECIESwithCipher() {
        }

        public static void Cardinal(Vector vector, Enumeration enumeration) {
            while (enumeration.hasMoreElements()) {
                vector.addElement(enumeration.nextElement());
            }
        }

        public static String cca_continue(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            String cca_continue = KeyAgreementSpi.CDHwithSHA384KDFAndSharedInfo.cca_continue(aSN1ObjectIdentifier);
            if (cca_continue == null) {
                cca_continue = DSASigner.detDSA256.init(aSN1ObjectIdentifier);
            }
            if (cca_continue == null) {
                cca_continue = KeyAgreementSpi.MQVwithSHA384CKDF.Cardinal(aSN1ObjectIdentifier);
            }
            if (cca_continue == null) {
                cca_continue = DSASigner.detDSA384.init(aSN1ObjectIdentifier);
            }
            if (cca_continue == null) {
                cca_continue = KeyAgreementSpi.DHUwithSHA256CKDF.getInstance(aSN1ObjectIdentifier);
            }
            if (cca_continue == null) {
                cca_continue = KeyAgreementSpi.DHwithRFC2631KDF.Cardinal(aSN1ObjectIdentifier);
            }
            if (cca_continue == null) {
                cca_continue = KeyAgreementSpi.DHwithSHA256KDF.cca_continue(aSN1ObjectIdentifier);
            }
            return cca_continue == null ? BCECGOST3410_2012PublicKey.Cardinal(aSN1ObjectIdentifier) : cca_continue;
        }

        public static KeyAgreementSpi.C1970DH configure(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            KeyAgreementSpi.C1970DH init = KeyAgreementSpi.CDHwithSHA384KDFAndSharedInfo.init(aSN1ObjectIdentifier);
            if (init == null) {
                init = DSASigner.detDSA256.getInstance(aSN1ObjectIdentifier);
            }
            if (init == null) {
                init = DSASigner.detDSA384.getInstance(aSN1ObjectIdentifier);
            }
            if (init == null) {
                init = KeyAgreementSpi.DHUwithSHA256CKDF.configure(aSN1ObjectIdentifier);
            }
            if (init == null) {
                init = init(KeyAgreementSpi.DHwithRFC2631KDF.init(aSN1ObjectIdentifier));
            }
            return init == null ? KeyAgreementSpi.DHwithSHA256KDF.getInstance(aSN1ObjectIdentifier) : init;
        }

        public static KeyAgreementSpi.C1970DH configure(String str) {
            KeyAgreementSpi.C1970DH Cardinal = KeyAgreementSpi.CDHwithSHA384KDFAndSharedInfo.Cardinal(str);
            if (Cardinal == null) {
                Cardinal = DSASigner.detDSA256.init(str);
            }
            if (Cardinal == null) {
                Cardinal = KeyAgreementSpi.MQVwithSHA384CKDF.getInstance(str);
            }
            if (Cardinal == null) {
                Cardinal = DSASigner.detDSA384.configure(str);
            }
            if (Cardinal == null) {
                Cardinal = KeyAgreementSpi.DHUwithSHA256CKDF.getInstance(str);
            }
            if (Cardinal == null) {
                Cardinal = init(KeyAgreementSpi.DHwithRFC2631KDF.cca_continue(str));
            }
            return Cardinal == null ? KeyAgreementSpi.DHwithSHA256KDF.configure(str) : Cardinal;
        }

        public static ASN1ObjectIdentifier getInstance(String str) {
            ASN1ObjectIdentifier configure2 = KeyAgreementSpi.CDHwithSHA384KDFAndSharedInfo.configure(str);
            if (configure2 == null) {
                configure2 = DSASigner.detDSA256.Cardinal(str);
            }
            if (configure2 == null) {
                configure2 = KeyAgreementSpi.MQVwithSHA384CKDF.init(str);
            }
            if (configure2 == null) {
                configure2 = DSASigner.detDSA384.cca_continue(str);
            }
            if (configure2 == null) {
                configure2 = KeyAgreementSpi.DHUwithSHA256CKDF.configure(str);
            }
            if (configure2 == null) {
                configure2 = KeyAgreementSpi.DHwithRFC2631KDF.configure(str);
            }
            return configure2 == null ? KeyAgreementSpi.DHwithSHA256KDF.init(str) : configure2;
        }

        private static KeyAgreementSpi.C1970DH init(BCRSAPublicKey bCRSAPublicKey) {
            if (bCRSAPublicKey == null) {
                return null;
            }
            return new KeyAgreementSpi.C1970DH(bCRSAPublicKey.Cardinal, bCRSAPublicKey.init, bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance, bCRSAPublicKey.init());
        }

        public ECIESwithCipher(String str) {
            this.getInstance = str;
            this.configure = 0;
        }

        public final boolean Cardinal() {
            return this.configure != -1;
        }

        public final String init() {
            int i = this.configure;
            if (i == -1) {
                return null;
            }
            int indexOf = this.getInstance.indexOf(46, i);
            if (indexOf == -1) {
                String substring = this.getInstance.substring(this.configure);
                this.configure = -1;
                return substring;
            }
            String substring2 = this.getInstance.substring(this.configure, indexOf);
            this.configure = indexOf + 1;
            return substring2;
        }
    }

    /* renamed from: com.cardinalcommerce.a.IESCipher$ECIESwithDESedeCBC */
    public interface ECIESwithDESedeCBC {

        /* renamed from: a_ */
        public static final ASN1ObjectIdentifier f2444a_ = new ASN1ObjectIdentifier("2.5.4.20").getInstance();

        /* renamed from: b_ */
        public static final ASN1ObjectIdentifier f2445b_ = new ASN1ObjectIdentifier("2.5.4.41").getInstance();

        /* renamed from: c_ */
        public static final ASN1ObjectIdentifier f2446c_ = new ASN1ObjectIdentifier("2.5.4.97").getInstance();

        /* renamed from: d_ */
        public static final ASN1ObjectIdentifier f2447d_ = new ASN1ObjectIdentifier("2.5.8.1.1").getInstance();

        /* renamed from: e_ */
        public static final ASN1ObjectIdentifier f2448e_;

        /* renamed from: f_ */
        public static final ASN1ObjectIdentifier f2449f_;

        static {
            new ASN1ObjectIdentifier("2.5.4.3").getInstance();
            new ASN1ObjectIdentifier("2.5.4.6").getInstance();
            new ASN1ObjectIdentifier("2.5.4.7").getInstance();
            new ASN1ObjectIdentifier("2.5.4.8").getInstance();
            new ASN1ObjectIdentifier("2.5.4.10").getInstance();
            new ASN1ObjectIdentifier("2.5.4.11").getInstance();
            new ASN1ObjectIdentifier("1.3.14.3.2.26").getInstance();
            new ASN1ObjectIdentifier("1.3.36.3.2.1").getInstance();
            new ASN1ObjectIdentifier("1.3.36.3.3.1.2").getInstance();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
            f2448e_ = aSN1ObjectIdentifier;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
            new ASN1ObjectIdentifier("2.5.29");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(f2448e_, DiFaceLogger.EVENT_ID_PERMISSION_PARTIAL_GRANTED_IN_APPEAL);
            f2449f_ = aSN1ObjectIdentifier2;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2").getInstance();
            new ASN1ObjectIdentifier(f2449f_, "1").getInstance();
        }
    }

    /* renamed from: com.cardinalcommerce.a.IESCipher$IES */
    public final class IES {
        private static final Map Cardinal = new HashMap();
        private static Long init = 0L;

        IES() {
        }

        private static Locale Cardinal() {
            if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
                return Locale.getDefault();
            }
            Locale[] availableLocales = Locale.getAvailableLocales();
            for (int i = 0; i != availableLocales.length; i++) {
                if ("en".equalsIgnoreCase(availableLocales[i].getLanguage())) {
                    return availableLocales[i];
                }
            }
            return Locale.getDefault();
        }

        public static Date getInstance(Date date) throws ParseException {
            Locale locale = Locale.getDefault();
            if (locale == null) {
                return date;
            }
            synchronized (Cardinal) {
                Long l = (Long) Cardinal.get(locale);
                if (l == null) {
                    long time = new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime();
                    l = time == 0 ? init : Long.valueOf(time);
                    Cardinal.put(locale, l);
                }
                if (l == init) {
                    return date;
                }
                Date date2 = new Date(date.getTime() - l.longValue());
                return date2;
            }
        }

        static {
            Cardinal();
        }
    }

    /* renamed from: com.cardinalcommerce.a.IESCipher$IESwithDESedeCBC */
    final class IESwithDESedeCBC extends setThreeDSRequestorAppURL {
        private byte[] getInstance;

        IESwithDESedeCBC(byte[] bArr) throws IOException {
            this.getInstance = bArr;
        }

        private void CardinalError() {
            DSASigner.noneDSA nonedsa = new DSASigner.noneDSA(this.getInstance);
            while (nonedsa.hasMoreElements()) {
                this.configure.addElement(nonedsa.nextElement());
            }
            this.getInstance = null;
        }

        public final synchronized getProxyAddress Cardinal(int i) {
            if (this.getInstance != null) {
                CardinalError();
            }
            return super.Cardinal(i);
        }

        public final synchronized Enumeration cca_continue() {
            if (this.getInstance == null) {
                return super.cca_continue();
            }
            return new DSASigner.noneDSA(this.getInstance);
        }

        /* access modifiers changed from: package-private */
        public final int configure() throws IOException {
            byte[] bArr = this.getInstance;
            return bArr != null ? KeyAgreementSpi.Cardinal(bArr.length) + 1 + this.getInstance.length : super.getWarnings().configure();
        }

        public final synchronized int getInstance() {
            if (this.getInstance != null) {
                CardinalError();
            }
            return super.getInstance();
        }

        /* access modifiers changed from: package-private */
        public final setLocationDataConsentGiven getSDKVersion() {
            if (this.getInstance != null) {
                CardinalError();
            }
            return super.getSDKVersion();
        }

        /* access modifiers changed from: package-private */
        public final setLocationDataConsentGiven getWarnings() {
            if (this.getInstance != null) {
                CardinalError();
            }
            return super.getWarnings();
        }

        /* access modifiers changed from: package-private */
        public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
            byte[] bArr = this.getInstance;
            if (bArr != null) {
                setenabledfsync.configure(48);
                setenabledfsync.Cardinal(bArr.length);
                setenabledfsync.getInstance.write(bArr);
                return;
            }
            super.getWarnings().cca_continue(setenabledfsync);
        }
    }
}
