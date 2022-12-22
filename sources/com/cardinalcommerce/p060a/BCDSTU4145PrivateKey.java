package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.facebook.appevents.UserDataStore;
import java.util.Hashtable;

/* renamed from: com.cardinalcommerce.a.BCDSTU4145PrivateKey */
public final class BCDSTU4145PrivateKey extends BCDSTU4145PublicKey {

    /* renamed from: A */
    private static ASN1ObjectIdentifier f2177A = new ASN1ObjectIdentifier("2.5.4.26").getInstance();

    /* renamed from: B */
    private static ASN1ObjectIdentifier f2178B = new ASN1ObjectIdentifier("2.5.4.33").getInstance();

    /* renamed from: C */
    private static ASN1ObjectIdentifier f2179C = new ASN1ObjectIdentifier("2.5.4.14").getInstance();

    /* renamed from: D */
    private static ASN1ObjectIdentifier f2180D = new ASN1ObjectIdentifier("2.5.4.34").getInstance();

    /* renamed from: E */
    private static ASN1ObjectIdentifier f2181E = new ASN1ObjectIdentifier("2.5.4.5").getInstance();

    /* renamed from: F */
    private static ASN1ObjectIdentifier f2182F = new ASN1ObjectIdentifier("2.5.4.4").getInstance();

    /* renamed from: G */
    private static ASN1ObjectIdentifier f2183G = new ASN1ObjectIdentifier("2.5.4.8").getInstance();

    /* renamed from: H */
    private static ASN1ObjectIdentifier f2184H = new ASN1ObjectIdentifier("2.5.4.9").getInstance();

    /* renamed from: I */
    private static ASN1ObjectIdentifier f2185I = new ASN1ObjectIdentifier("2.5.4.20").getInstance();

    /* renamed from: J */
    private static ASN1ObjectIdentifier f2186J = new ASN1ObjectIdentifier("2.5.4.22").getInstance();

    /* renamed from: K */
    private static ASN1ObjectIdentifier f2187K = new ASN1ObjectIdentifier("2.5.4.21").getInstance();

    /* renamed from: L */
    private static ASN1ObjectIdentifier f2188L = new ASN1ObjectIdentifier("2.5.4.12").getInstance();

    /* renamed from: M */
    private static ASN1ObjectIdentifier f2189M = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1").getInstance();

    /* renamed from: N */
    private static ASN1ObjectIdentifier f2190N = new ASN1ObjectIdentifier("2.5.4.50").getInstance();

    /* renamed from: O */
    private static ASN1ObjectIdentifier f2191O = new ASN1ObjectIdentifier("2.5.4.35").getInstance();

    /* renamed from: P */
    private static ASN1ObjectIdentifier f2192P = new ASN1ObjectIdentifier("2.5.4.24").getInstance();

    /* renamed from: Q */
    private static ASN1ObjectIdentifier f2193Q = new ASN1ObjectIdentifier("2.5.4.45").getInstance();

    /* renamed from: R */
    private static final Hashtable f2194R = new Hashtable();

    /* renamed from: S */
    private static final Hashtable f2195S = new Hashtable();

    /* renamed from: a */
    private static ASN1ObjectIdentifier f2196a = new ASN1ObjectIdentifier("2.5.4.15").getInstance();

    /* renamed from: b */
    private static ASN1ObjectIdentifier f2197b = new ASN1ObjectIdentifier("2.5.4.6").getInstance();

    /* renamed from: c */
    private static ASN1ObjectIdentifier f2198c = new ASN1ObjectIdentifier("2.5.4.3").getInstance();

    /* renamed from: d */
    private static ASN1ObjectIdentifier f2199d = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25").getInstance();

    /* renamed from: e */
    private static ASN1ObjectIdentifier f2200e = new ASN1ObjectIdentifier("2.5.4.13").getInstance();

    /* renamed from: f */
    private static ASN1ObjectIdentifier f2201f = new ASN1ObjectIdentifier("2.5.4.27").getInstance();

    /* renamed from: g */
    private static ASN1ObjectIdentifier f2202g = new ASN1ObjectIdentifier("2.5.4.49").getInstance();
    public static final KeyPairGeneratorSpi.C1980EC getInstance = new BCDSTU4145PrivateKey();

    /* renamed from: h */
    private static ASN1ObjectIdentifier f2203h = new ASN1ObjectIdentifier("2.5.4.46").getInstance();

    /* renamed from: i */
    private static ASN1ObjectIdentifier f2204i = new ASN1ObjectIdentifier("2.5.4.47").getInstance();

    /* renamed from: j */
    private static ASN1ObjectIdentifier f2205j = new ASN1ObjectIdentifier("2.5.4.23").getInstance();

    /* renamed from: k */
    private static ASN1ObjectIdentifier f2206k = new ASN1ObjectIdentifier("2.5.4.44").getInstance();

    /* renamed from: l */
    private static ASN1ObjectIdentifier f2207l = new ASN1ObjectIdentifier("2.5.4.42").getInstance();

    /* renamed from: m */
    private static ASN1ObjectIdentifier f2208m = new ASN1ObjectIdentifier("2.5.4.51").getInstance();

    /* renamed from: n */
    private static ASN1ObjectIdentifier f2209n = new ASN1ObjectIdentifier("2.5.4.43").getInstance();

    /* renamed from: o */
    private static ASN1ObjectIdentifier f2210o = new ASN1ObjectIdentifier("2.5.4.25").getInstance();

    /* renamed from: p */
    private static ASN1ObjectIdentifier f2211p = new ASN1ObjectIdentifier("2.5.4.7").getInstance();

    /* renamed from: q */
    private static ASN1ObjectIdentifier f2212q = new ASN1ObjectIdentifier("2.5.4.31").getInstance();

    /* renamed from: r */
    private static ASN1ObjectIdentifier f2213r = new ASN1ObjectIdentifier("2.5.4.41").getInstance();

    /* renamed from: s */
    private static ASN1ObjectIdentifier f2214s = new ASN1ObjectIdentifier("2.5.4.10").getInstance();

    /* renamed from: t */
    private static ASN1ObjectIdentifier f2215t = new ASN1ObjectIdentifier("2.5.4.11").getInstance();

    /* renamed from: u */
    private static ASN1ObjectIdentifier f2216u = new ASN1ObjectIdentifier("2.5.4.32").getInstance();

    /* renamed from: v */
    private static ASN1ObjectIdentifier f2217v = new ASN1ObjectIdentifier("2.5.4.19").getInstance();

    /* renamed from: w */
    private static ASN1ObjectIdentifier f2218w = new ASN1ObjectIdentifier("2.5.4.16").getInstance();

    /* renamed from: x */
    private static ASN1ObjectIdentifier f2219x = new ASN1ObjectIdentifier("2.5.4.17").getInstance();

    /* renamed from: y */
    private static ASN1ObjectIdentifier f2220y = new ASN1ObjectIdentifier("2.5.4.18").getInstance();

    /* renamed from: z */
    private static ASN1ObjectIdentifier f2221z = new ASN1ObjectIdentifier("2.5.4.28").getInstance();

    /* renamed from: T */
    private Hashtable f2222T = configure(f2194R);

    static {
        f2194R.put(f2196a, "businessCategory");
        f2194R.put(f2197b, "c");
        f2194R.put(f2198c, "cn");
        f2194R.put(f2199d, "dc");
        f2194R.put(f2200e, "description");
        f2194R.put(f2201f, "destinationIndicator");
        f2194R.put(f2202g, "distinguishedName");
        f2194R.put(f2203h, "dnQualifier");
        f2194R.put(f2204i, "enhancedSearchGuide");
        f2194R.put(f2205j, "facsimileTelephoneNumber");
        f2194R.put(f2206k, "generationQualifier");
        f2194R.put(f2207l, "givenName");
        f2194R.put(f2208m, "houseIdentifier");
        f2194R.put(f2209n, "initials");
        f2194R.put(f2210o, "internationalISDNNumber");
        f2194R.put(f2211p, "l");
        f2194R.put(f2212q, "member");
        f2194R.put(f2213r, "name");
        f2194R.put(f2214s, "o");
        f2194R.put(f2215t, "ou");
        f2194R.put(f2216u, "owner");
        f2194R.put(f2217v, "physicalDeliveryOfficeName");
        f2194R.put(f2218w, "postalAddress");
        f2194R.put(f2219x, "postalCode");
        f2194R.put(f2220y, "postOfficeBox");
        f2194R.put(f2221z, "preferredDeliveryMethod");
        f2194R.put(f2177A, "registeredAddress");
        f2194R.put(f2178B, "roleOccupant");
        f2194R.put(f2179C, "searchGuide");
        f2194R.put(f2180D, "seeAlso");
        f2194R.put(f2181E, "serialNumber");
        f2194R.put(f2182F, "sn");
        f2194R.put(f2183G, UserDataStore.STATE);
        f2194R.put(f2184H, "street");
        f2194R.put(f2185I, "telephoneNumber");
        f2194R.put(f2186J, "teletexTerminalIdentifier");
        f2194R.put(f2187K, "telexNumber");
        f2194R.put(f2188L, "title");
        f2194R.put(f2189M, "uid");
        f2194R.put(f2190N, "uniqueMember");
        f2194R.put(f2191O, "userPassword");
        f2194R.put(f2192P, "x121Address");
        f2194R.put(f2193Q, "x500UniqueIdentifier");
        f2195S.put("businesscategory", f2196a);
        f2195S.put("c", f2197b);
        f2195S.put("cn", f2198c);
        f2195S.put("dc", f2199d);
        f2195S.put("description", f2200e);
        f2195S.put("destinationindicator", f2201f);
        f2195S.put("distinguishedname", f2202g);
        f2195S.put("dnqualifier", f2203h);
        f2195S.put("enhancedsearchguide", f2204i);
        f2195S.put("facsimiletelephonenumber", f2205j);
        f2195S.put("generationqualifier", f2206k);
        f2195S.put("givenname", f2207l);
        f2195S.put("houseidentifier", f2208m);
        f2195S.put("initials", f2209n);
        f2195S.put("internationalisdnnumber", f2210o);
        f2195S.put("l", f2211p);
        f2195S.put("member", f2212q);
        f2195S.put("name", f2213r);
        f2195S.put("o", f2214s);
        f2195S.put("ou", f2215t);
        f2195S.put("owner", f2216u);
        f2195S.put("physicaldeliveryofficename", f2217v);
        f2195S.put("postaladdress", f2218w);
        f2195S.put("postalcode", f2219x);
        f2195S.put("postofficebox", f2220y);
        f2195S.put("preferreddeliverymethod", f2221z);
        f2195S.put("registeredaddress", f2177A);
        f2195S.put("roleoccupant", f2178B);
        f2195S.put("searchguide", f2179C);
        f2195S.put("seealso", f2180D);
        f2195S.put("serialnumber", f2181E);
        f2195S.put("sn", f2182F);
        f2195S.put(UserDataStore.STATE, f2183G);
        f2195S.put("street", f2184H);
        f2195S.put("telephonenumber", f2185I);
        f2195S.put("teletexterminalidentifier", f2186J);
        f2195S.put("telexnumber", f2187K);
        f2195S.put("title", f2188L);
        f2195S.put("uid", f2189M);
        f2195S.put("uniquemember", f2190N);
        f2195S.put("userpassword", f2191O);
        f2195S.put("x121address", f2192P);
        f2195S.put("x500uniqueidentifier", f2193Q);
    }

    protected BCDSTU4145PrivateKey() {
        configure(f2195S);
    }

    public final String getInstance(DSASigner.dsaSha3_224 dsasha3_224) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = dsasha3_224.configure.length;
        DSASigner.dsa512[] dsa512Arr = new DSASigner.dsa512[length];
        System.arraycopy(dsasha3_224.configure, 0, dsa512Arr, 0, length);
        boolean z = true;
        for (int i = length - 1; i >= 0; i--) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            DSASigner.noneDSA.getInstance(stringBuffer, dsa512Arr[i], this.f2222T);
        }
        return stringBuffer.toString();
    }
}
