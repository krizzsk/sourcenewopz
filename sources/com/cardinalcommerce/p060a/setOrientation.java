package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.JWK;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenKey;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URI;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setOrientation */
public final class setOrientation extends JWK {
    private final Base64URL Cardinal;
    private final Base64URL CardinalError;
    private final Base64URL cca_continue;
    private final Base64URL cleanup;
    private final Base64URL configure;
    private final Base64URL getInstance;
    private final List<C2060init> getSDKVersion;
    private final Base64URL getWarnings;
    private final Base64URL init;
    private final PrivateKey values;

    /* renamed from: com.cardinalcommerce.a.setOrientation$init */
    public static class C2060init implements Serializable {
        final Base64URL Cardinal;
        final Base64URL cca_continue;
        final Base64URL init;

        public C2060init(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) {
            if (base64URL != null) {
                this.cca_continue = base64URL;
                if (base64URL2 != null) {
                    this.init = base64URL2;
                    if (base64URL3 != null) {
                        this.Cardinal = base64URL3;
                        return;
                    }
                    throw new IllegalArgumentException("The factor CRT coefficient must not be null");
                }
                throw new IllegalArgumentException("The factor CRT exponent must not be null");
            }
            throw new IllegalArgumentException("The prime factor must not be null");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private setOrientation(com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r18, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r19, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r20, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r21, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r22, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r23, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r24, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r25, java.util.List<com.cardinalcommerce.p060a.setOrientation.C2060init> r26, com.cardinalcommerce.p060a.setVerticalGravity r27, java.util.Set<com.cardinalcommerce.p060a.setDividerPadding> r28, com.cardinalcommerce.p060a.setDownloadListener r29, java.lang.String r30, java.net.URI r31, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r32, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r33, java.util.List<com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64> r34) {
        /*
            r17 = this;
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r21
            r15 = r22
            r10 = r23
            r9 = r24
            r8 = r25
            com.cardinalcommerce.a.setBaselineAlignedChildIndex r1 = com.cardinalcommerce.p060a.setBaselineAlignedChildIndex.Cardinal
            r16 = 0
            r0 = r17
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L_0x00e7
            r11.getInstance = r12
            if (r13 == 0) goto L_0x00df
            r11.configure = r13
            java.util.List r0 = r17.getInstance()
            if (r0 == 0) goto L_0x0050
            java.util.List r0 = r17.getInstance()
            r1 = 0
            r0.get(r1)
            boolean r0 = r17.Cardinal()
            if (r0 == 0) goto L_0x0048
            goto L_0x0050
        L_0x0048:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters"
            r0.<init>(r1)
            throw r0
        L_0x0050:
            r0 = r20
            r11.init = r0
            r0 = 0
            if (r14 == 0) goto L_0x007f
            if (r15 == 0) goto L_0x007f
            r1 = r23
            r2 = r24
            if (r1 == 0) goto L_0x0083
            r3 = r25
            if (r2 == 0) goto L_0x0085
            if (r3 == 0) goto L_0x0085
            r11.cca_continue = r14
            r11.Cardinal = r15
            r11.CardinalError = r1
            r11.cleanup = r2
            r11.getWarnings = r3
            if (r26 == 0) goto L_0x0078
            java.util.List r1 = java.util.Collections.unmodifiableList(r26)
            r11.getSDKVersion = r1
            goto L_0x00ac
        L_0x0078:
            java.util.List r1 = java.util.Collections.emptyList()
            r11.getSDKVersion = r1
            goto L_0x00ac
        L_0x007f:
            r1 = r23
            r2 = r24
        L_0x0083:
            r3 = r25
        L_0x0085:
            if (r14 != 0) goto L_0x0091
            if (r15 != 0) goto L_0x0091
            if (r1 != 0) goto L_0x0091
            if (r2 != 0) goto L_0x0091
            if (r3 != 0) goto L_0x0091
            if (r26 == 0) goto L_0x009c
        L_0x0091:
            if (r14 != 0) goto L_0x00af
            if (r15 != 0) goto L_0x00af
            if (r1 != 0) goto L_0x00af
            if (r2 != 0) goto L_0x00af
            if (r3 == 0) goto L_0x009c
            goto L_0x00af
        L_0x009c:
            r11.cca_continue = r0
            r11.Cardinal = r0
            r11.CardinalError = r0
            r11.cleanup = r0
            r11.getWarnings = r0
            java.util.List r1 = java.util.Collections.emptyList()
            r11.getSDKVersion = r1
        L_0x00ac:
            r11.values = r0
            return
        L_0x00af:
            if (r14 == 0) goto L_0x00d7
            if (r15 == 0) goto L_0x00cf
            if (r1 == 0) goto L_0x00c7
            if (r2 != 0) goto L_0x00bf
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00bf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first CRT coefficient must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00c7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00cf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00df:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public exponent value must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00e7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The modulus value must not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setOrientation.<init>(com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, java.util.List, com.cardinalcommerce.a.setVerticalGravity, java.util.Set, com.cardinalcommerce.a.setDownloadListener, java.lang.String, java.net.URI, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, java.util.List):void");
    }

    private boolean Cardinal() {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) getInstance().get(0).getPublicKey();
            if (new BigInteger(1, this.configure.cca_continue()).equals(rSAPublicKey.getPublicExponent()) && new BigInteger(1, this.getInstance.cca_continue()).equals(rSAPublicKey.getModulus())) {
                return true;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final boolean init() {
        return (this.init == null && this.cca_continue == null) ? false : true;
    }

    public final setLayoutTransition cca_continue() {
        setLayoutTransition cca_continue2 = super.cca_continue();
        cca_continue2.put(CampaignValue.f40469b, this.getInstance.toString());
        cca_continue2.put("e", this.configure.toString());
        Base64URL base64URL = this.init;
        if (base64URL != null) {
            cca_continue2.put("d", base64URL.toString());
        }
        Base64URL base64URL2 = this.cca_continue;
        if (base64URL2 != null) {
            cca_continue2.put(RavenConfigKey.PHONE, base64URL2.toString());
        }
        Base64URL base64URL3 = this.Cardinal;
        if (base64URL3 != null) {
            cca_continue2.put("q", base64URL3.toString());
        }
        Base64URL base64URL4 = this.CardinalError;
        if (base64URL4 != null) {
            cca_continue2.put("dp", base64URL4.toString());
        }
        Base64URL base64URL5 = this.cleanup;
        if (base64URL5 != null) {
            cca_continue2.put("dq", base64URL5.toString());
        }
        Base64URL base64URL6 = this.getWarnings;
        if (base64URL6 != null) {
            cca_continue2.put("qi", base64URL6.toString());
        }
        List<C2060init> list = this.getSDKVersion;
        if (list != null && !list.isEmpty()) {
            setDescendantFocusability setdescendantfocusability = new setDescendantFocusability();
            for (C2060init next : this.getSDKVersion) {
                setLayoutTransition setlayouttransition = new setLayoutTransition();
                setlayouttransition.put("r", next.cca_continue.toString());
                setlayouttransition.put("d", next.init.toString());
                setlayouttransition.put(RavenKey.TYPE, next.Cardinal.toString());
                setdescendantfocusability.add(setlayouttransition);
            }
            cca_continue2.put("oth", setdescendantfocusability);
        }
        return cca_continue2;
    }

    public static setOrientation getInstance(setLayoutTransition setlayouttransition) throws ParseException {
        Base64URL base64URL;
        Base64URL base64URL2;
        Base64URL base64URL3;
        Base64URL base64URL4;
        Base64URL base64URL5;
        Base64URL base64URL6;
        Base64URL base64URL7;
        Base64URL base64URL8;
        ArrayList arrayList;
        List list;
        Base64URL base64URL9;
        Base64URL base64URL10;
        setDescendantFocusability setdescendantfocusability;
        Base64URL base64URL11;
        Base64URL base64URL12;
        Base64URL base64URL13;
        setLayoutTransition setlayouttransition2 = setlayouttransition;
        if (setBaselineAlignedChildIndex.Cardinal.equals(setBaselineAligned.init(setlayouttransition))) {
            String str = (String) valueOf.getInstance(setlayouttransition2, CampaignValue.f40469b, String.class);
            if (str == null) {
                base64URL = null;
            } else {
                base64URL = new Base64URL(str);
            }
            String str2 = (String) valueOf.getInstance(setlayouttransition2, "e", String.class);
            if (str2 == null) {
                base64URL2 = null;
            } else {
                base64URL2 = new Base64URL(str2);
            }
            String str3 = (String) valueOf.getInstance(setlayouttransition2, "d", String.class);
            if (str3 == null) {
                base64URL3 = null;
            } else {
                base64URL3 = new Base64URL(str3);
            }
            String str4 = (String) valueOf.getInstance(setlayouttransition2, RavenConfigKey.PHONE, String.class);
            if (str4 == null) {
                base64URL4 = null;
            } else {
                base64URL4 = new Base64URL(str4);
            }
            String str5 = (String) valueOf.getInstance(setlayouttransition2, "q", String.class);
            if (str5 == null) {
                base64URL5 = null;
            } else {
                base64URL5 = new Base64URL(str5);
            }
            String str6 = (String) valueOf.getInstance(setlayouttransition2, "dp", String.class);
            if (str6 == null) {
                base64URL6 = null;
            } else {
                base64URL6 = new Base64URL(str6);
            }
            String str7 = (String) valueOf.getInstance(setlayouttransition2, "dq", String.class);
            if (str7 == null) {
                base64URL7 = null;
            } else {
                base64URL7 = new Base64URL(str7);
            }
            String str8 = (String) valueOf.getInstance(setlayouttransition2, "qi", String.class);
            if (str8 == null) {
                base64URL8 = null;
            } else {
                base64URL8 = new Base64URL(str8);
            }
            if (!setlayouttransition2.containsKey("oth") || (setdescendantfocusability = (setDescendantFocusability) valueOf.getInstance(setlayouttransition2, "oth", setDescendantFocusability.class)) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(setdescendantfocusability.size());
                Iterator it = setdescendantfocusability.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof setLayoutTransition) {
                        setLayoutTransition setlayouttransition3 = (setLayoutTransition) next;
                        String str9 = (String) valueOf.getInstance(setlayouttransition3, "r", String.class);
                        if (str9 == null) {
                            base64URL11 = null;
                        } else {
                            base64URL11 = new Base64URL(str9);
                        }
                        String str10 = (String) valueOf.getInstance(setlayouttransition3, "dq", String.class);
                        if (str10 == null) {
                            base64URL12 = null;
                        } else {
                            base64URL12 = new Base64URL(str10);
                        }
                        Iterator it2 = it;
                        String str11 = (String) valueOf.getInstance(setlayouttransition3, RavenKey.TYPE, String.class);
                        if (str11 == null) {
                            base64URL13 = null;
                        } else {
                            base64URL13 = new Base64URL(str11);
                        }
                        try {
                            arrayList2.add(new C2060init(base64URL11, base64URL12, base64URL13));
                            it = it2;
                        } catch (IllegalArgumentException e) {
                            throw new ParseException(e.getMessage(), 0);
                        }
                    }
                }
                arrayList = arrayList2;
            }
            try {
                setVerticalGravity Cardinal2 = setVerticalGravity.Cardinal((String) valueOf.getInstance(setlayouttransition2, "use", String.class));
                String[] configure2 = valueOf.configure(setlayouttransition2, "key_ops");
                if (configure2 == null) {
                    list = null;
                } else {
                    list = Arrays.asList(configure2);
                }
                Set<setDividerPadding> configure3 = setDividerPadding.configure(list);
                setDownloadListener instance = setDownloadListener.getInstance((String) valueOf.getInstance(setlayouttransition2, "alg", String.class));
                String str12 = (String) valueOf.getInstance(setlayouttransition2, "kid", String.class);
                URI instance2 = valueOf.getInstance(setlayouttransition2, "x5u");
                String str13 = (String) valueOf.getInstance(setlayouttransition2, "x5t", String.class);
                if (str13 == null) {
                    base64URL9 = null;
                } else {
                    base64URL9 = new Base64URL(str13);
                }
                String str14 = (String) valueOf.getInstance(setlayouttransition2, "x5t#S256", String.class);
                if (str14 == null) {
                    base64URL10 = null;
                } else {
                    base64URL10 = new Base64URL(str14);
                }
                return new setOrientation(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, arrayList, Cardinal2, configure3, instance, str12, instance2, base64URL9, base64URL10, setBaselineAligned.Cardinal(setlayouttransition));
            } catch (IllegalArgumentException e2) {
                throw new ParseException(e2.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be RSA", 0);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof setOrientation) || !super.equals(obj)) {
            return false;
        }
        setOrientation setorientation = (setOrientation) obj;
        return Objects.equals(this.getInstance, setorientation.getInstance) && Objects.equals(this.configure, setorientation.configure) && Objects.equals(this.init, setorientation.init) && Objects.equals(this.cca_continue, setorientation.cca_continue) && Objects.equals(this.Cardinal, setorientation.Cardinal) && Objects.equals(this.CardinalError, setorientation.CardinalError) && Objects.equals(this.cleanup, setorientation.cleanup) && Objects.equals(this.getWarnings, setorientation.getWarnings) && Objects.equals(this.getSDKVersion, setorientation.getSDKVersion) && Objects.equals((Object) null, (Object) null);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.getInstance, this.configure, this.init, this.cca_continue, this.Cardinal, this.CardinalError, this.cleanup, this.getWarnings, this.getSDKVersion, null});
    }
}
