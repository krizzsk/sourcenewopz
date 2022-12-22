package com.cardinalcommerce.p060a;

import androidx.exifinterface.media.ExifInterface;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.util.GlobalCountryCode;
import com.facebook.appevents.UserDataStore;
import java.util.Hashtable;

/* renamed from: com.cardinalcommerce.a.DSAUtil */
public final class DSAUtil extends BCDSTU4145PublicKey {

    /* renamed from: A */
    private static ASN1ObjectIdentifier f2357A = IESCipher.ECIESwithDESedeCBC.f2445b_;

    /* renamed from: B */
    private static ASN1ObjectIdentifier f2358B = IESCipher.ECIESwithDESedeCBC.f2446c_;

    /* renamed from: C */
    private static ASN1ObjectIdentifier f2359C = KeyFactorySpi.setEnableDFSync;

    /* renamed from: D */
    private static ASN1ObjectIdentifier f2360D = KeyFactorySpi.setUICustomization;

    /* renamed from: E */
    private static ASN1ObjectIdentifier f2361E = KeyFactorySpi.getUICustomization;

    /* renamed from: F */
    private static ASN1ObjectIdentifier f2362F = f2359C;

    /* renamed from: G */
    private static ASN1ObjectIdentifier f2363G = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");

    /* renamed from: H */
    private static ASN1ObjectIdentifier f2364H = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");

    /* renamed from: I */
    private static final Hashtable f2365I = new Hashtable();

    /* renamed from: J */
    private static final Hashtable f2366J = new Hashtable();

    /* renamed from: a */
    private static ASN1ObjectIdentifier f2367a = new ASN1ObjectIdentifier("2.5.4.6").getInstance();

    /* renamed from: b */
    private static ASN1ObjectIdentifier f2368b = new ASN1ObjectIdentifier("2.5.4.10").getInstance();

    /* renamed from: c */
    private static ASN1ObjectIdentifier f2369c = new ASN1ObjectIdentifier("2.5.4.11").getInstance();

    /* renamed from: d */
    private static ASN1ObjectIdentifier f2370d = new ASN1ObjectIdentifier("2.5.4.12").getInstance();

    /* renamed from: e */
    private static ASN1ObjectIdentifier f2371e = new ASN1ObjectIdentifier("2.5.4.3").getInstance();

    /* renamed from: f */
    private static ASN1ObjectIdentifier f2372f = new ASN1ObjectIdentifier("2.5.4.5").getInstance();

    /* renamed from: g */
    private static ASN1ObjectIdentifier f2373g = new ASN1ObjectIdentifier("2.5.4.9").getInstance();

    /* renamed from: h */
    private static ASN1ObjectIdentifier f2374h = new ASN1ObjectIdentifier("2.5.4.7").getInstance();

    /* renamed from: i */
    private static ASN1ObjectIdentifier f2375i = new ASN1ObjectIdentifier("2.5.4.8").getInstance();
    public static final KeyPairGeneratorSpi.C1980EC init = new DSAUtil();

    /* renamed from: j */
    private static ASN1ObjectIdentifier f2376j = new ASN1ObjectIdentifier("2.5.4.4").getInstance();

    /* renamed from: k */
    private static ASN1ObjectIdentifier f2377k = new ASN1ObjectIdentifier("2.5.4.42").getInstance();

    /* renamed from: l */
    private static ASN1ObjectIdentifier f2378l = new ASN1ObjectIdentifier("2.5.4.43").getInstance();

    /* renamed from: m */
    private static ASN1ObjectIdentifier f2379m = new ASN1ObjectIdentifier("2.5.4.44").getInstance();

    /* renamed from: n */
    private static ASN1ObjectIdentifier f2380n = new ASN1ObjectIdentifier("2.5.4.45").getInstance();

    /* renamed from: o */
    private static ASN1ObjectIdentifier f2381o = new ASN1ObjectIdentifier("2.5.4.15").getInstance();

    /* renamed from: p */
    private static ASN1ObjectIdentifier f2382p = new ASN1ObjectIdentifier("2.5.4.17").getInstance();

    /* renamed from: q */
    private static ASN1ObjectIdentifier f2383q = new ASN1ObjectIdentifier("2.5.4.46").getInstance();

    /* renamed from: r */
    private static ASN1ObjectIdentifier f2384r = new ASN1ObjectIdentifier("2.5.4.65").getInstance();

    /* renamed from: s */
    private static ASN1ObjectIdentifier f2385s = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1").getInstance();

    /* renamed from: t */
    private static ASN1ObjectIdentifier f2386t = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2").getInstance();

    /* renamed from: u */
    private static ASN1ObjectIdentifier f2387u = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3").getInstance();

    /* renamed from: v */
    private static ASN1ObjectIdentifier f2388v = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4").getInstance();

    /* renamed from: w */
    private static ASN1ObjectIdentifier f2389w = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5").getInstance();

    /* renamed from: x */
    private static ASN1ObjectIdentifier f2390x = new ASN1ObjectIdentifier("1.3.36.8.3.14").getInstance();

    /* renamed from: y */
    private static ASN1ObjectIdentifier f2391y = new ASN1ObjectIdentifier("2.5.4.16").getInstance();

    /* renamed from: z */
    private static ASN1ObjectIdentifier f2392z = IESCipher.ECIESwithDESedeCBC.f2444a_;

    /* renamed from: K */
    private Hashtable f2393K = configure(f2365I);

    static {
        new ASN1ObjectIdentifier("2.5.4.54").getInstance();
        f2365I.put(f2367a, "C");
        f2365I.put(f2368b, "O");
        f2365I.put(f2370d, "T");
        f2365I.put(f2369c, "OU");
        f2365I.put(f2371e, GlobalCountryCode.CHINA);
        f2365I.put(f2374h, "L");
        f2365I.put(f2375i, "ST");
        f2365I.put(f2372f, "SERIALNUMBER");
        f2365I.put(f2359C, ExifInterface.LONGITUDE_EAST);
        f2365I.put(f2363G, "DC");
        f2365I.put(f2364H, "UID");
        f2365I.put(f2373g, "STREET");
        f2365I.put(f2376j, "SURNAME");
        f2365I.put(f2377k, "GIVENNAME");
        f2365I.put(f2378l, "INITIALS");
        f2365I.put(f2379m, "GENERATION");
        f2365I.put(f2361E, "unstructuredAddress");
        f2365I.put(f2360D, "unstructuredName");
        f2365I.put(f2380n, "UniqueIdentifier");
        f2365I.put(f2383q, "DN");
        f2365I.put(f2384r, "Pseudonym");
        f2365I.put(f2391y, "PostalAddress");
        f2365I.put(f2390x, "NameAtBirth");
        f2365I.put(f2388v, "CountryOfCitizenship");
        f2365I.put(f2389w, "CountryOfResidence");
        f2365I.put(f2387u, "Gender");
        f2365I.put(f2386t, "PlaceOfBirth");
        f2365I.put(f2385s, "DateOfBirth");
        f2365I.put(f2382p, "PostalCode");
        f2365I.put(f2381o, "BusinessCategory");
        f2365I.put(f2392z, "TelephoneNumber");
        f2365I.put(f2357A, "Name");
        f2365I.put(f2358B, "organizationIdentifier");
        f2366J.put("c", f2367a);
        f2366J.put("o", f2368b);
        f2366J.put(RavenKey.TYPE, f2370d);
        f2366J.put("ou", f2369c);
        f2366J.put("cn", f2371e);
        f2366J.put("l", f2374h);
        f2366J.put(UserDataStore.STATE, f2375i);
        f2366J.put("sn", f2372f);
        f2366J.put("serialnumber", f2372f);
        f2366J.put("street", f2373g);
        f2366J.put("emailaddress", f2362F);
        f2366J.put("dc", f2363G);
        f2366J.put("e", f2362F);
        f2366J.put("uid", f2364H);
        f2366J.put("surname", f2376j);
        f2366J.put("givenname", f2377k);
        f2366J.put("initials", f2378l);
        f2366J.put("generation", f2379m);
        f2366J.put("unstructuredaddress", f2361E);
        f2366J.put("unstructuredname", f2360D);
        f2366J.put("uniqueidentifier", f2380n);
        f2366J.put("dn", f2383q);
        f2366J.put("pseudonym", f2384r);
        f2366J.put("postaladdress", f2391y);
        f2366J.put("nameofbirth", f2390x);
        f2366J.put("countryofcitizenship", f2388v);
        f2366J.put("countryofresidence", f2389w);
        f2366J.put("gender", f2387u);
        f2366J.put("placeofbirth", f2386t);
        f2366J.put("dateofbirth", f2385s);
        f2366J.put("postalcode", f2382p);
        f2366J.put("businesscategory", f2381o);
        f2366J.put("telephonenumber", f2392z);
        f2366J.put("name", f2357A);
        f2366J.put("organizationidentifier", f2358B);
    }

    protected DSAUtil() {
        configure(f2366J);
    }

    public final String getInstance(DSASigner.dsaSha3_224 dsasha3_224) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = dsasha3_224.configure.length;
        DSASigner.dsa512[] dsa512Arr = new DSASigner.dsa512[length];
        System.arraycopy(dsasha3_224.configure, 0, dsa512Arr, 0, length);
        boolean z = true;
        for (int i = 0; i < length; i++) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            DSASigner.noneDSA.getInstance(stringBuffer, dsa512Arr[i], this.f2393K);
        }
        return stringBuffer.toString();
    }
}
