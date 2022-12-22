package com.cardinalcommerce.dependencies.internal.nimbusds.jwt;

import com.cardinalcommerce.p060a.setAddStatesFromChildren;
import com.cardinalcommerce.p060a.setDescendantFocusability;
import com.cardinalcommerce.p060a.setLayoutTransition;
import com.cardinalcommerce.p060a.valueOf;
import com.facebook.AuthenticationTokenClaims;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class JWTClaimsSet implements Serializable {
    private final Map<String, Object> getInstance;

    /* renamed from: com.cardinalcommerce.dependencies.internal.nimbusds.jwt.JWTClaimsSet$init */
    public static class C2158init {
        final Map<String, Object> getInstance = new LinkedHashMap();
    }

    private /* synthetic */ JWTClaimsSet(Map map, byte b) {
        this(map);
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(AuthenticationTokenClaims.JSON_KEY_ISS);
        hashSet.add(AuthenticationTokenClaims.JSON_KEY_SUB);
        hashSet.add(AuthenticationTokenClaims.JSON_KEY_AUD);
        hashSet.add(AuthenticationTokenClaims.JSON_KEY_EXP);
        hashSet.add("nbf");
        hashSet.add(AuthenticationTokenClaims.JSON_KEY_IAT);
        hashSet.add(AuthenticationTokenClaims.JSON_KEY_JIT);
        Collections.unmodifiableSet(hashSet);
    }

    private JWTClaimsSet(Map<String, Object> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.getInstance = linkedHashMap;
        linkedHashMap.putAll(map);
    }

    /* access modifiers changed from: package-private */
    public setLayoutTransition getInstance() {
        setLayoutTransition setlayouttransition = new setLayoutTransition();
        for (Map.Entry next : this.getInstance.entrySet()) {
            if (next.getValue() instanceof Date) {
                setlayouttransition.put(next.getKey(), Long.valueOf(((Date) next.getValue()).getTime() / 1000));
            } else if (AuthenticationTokenClaims.JSON_KEY_AUD.equals(next.getKey())) {
                List<String> Cardinal = Cardinal();
                if (Cardinal != null && !Cardinal.isEmpty()) {
                    if (Cardinal.size() == 1) {
                        setlayouttransition.put(AuthenticationTokenClaims.JSON_KEY_AUD, Cardinal.get(0));
                    } else {
                        setDescendantFocusability setdescendantfocusability = new setDescendantFocusability();
                        setdescendantfocusability.addAll(Cardinal);
                        setlayouttransition.put(AuthenticationTokenClaims.JSON_KEY_AUD, setdescendantfocusability);
                    }
                }
            } else if (next.getValue() != null) {
                setlayouttransition.put(next.getKey(), next.getValue());
            }
        }
        return setlayouttransition;
    }

    public static JWTClaimsSet getInstance(String str) throws ParseException {
        setLayoutTransition init = valueOf.init(str);
        C2158init init2 = new C2158init();
        for (String str2 : init.keySet()) {
            if (str2.equals(AuthenticationTokenClaims.JSON_KEY_ISS)) {
                init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_ISS, (String) valueOf.getInstance(init, AuthenticationTokenClaims.JSON_KEY_ISS, String.class));
            } else if (str2.equals(AuthenticationTokenClaims.JSON_KEY_SUB)) {
                init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_SUB, (String) valueOf.getInstance(init, AuthenticationTokenClaims.JSON_KEY_SUB, String.class));
            } else if (str2.equals(AuthenticationTokenClaims.JSON_KEY_AUD)) {
                Object obj = init.get(AuthenticationTokenClaims.JSON_KEY_AUD);
                if (obj instanceof String) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((String) valueOf.getInstance(init, AuthenticationTokenClaims.JSON_KEY_AUD, String.class));
                    init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_AUD, arrayList);
                } else {
                    List list = null;
                    if (obj instanceof List) {
                        String[] configure = valueOf.configure(init, AuthenticationTokenClaims.JSON_KEY_AUD);
                        if (configure != null) {
                            list = Arrays.asList(configure);
                        }
                        init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_AUD, list);
                    } else if (obj == null) {
                        init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_AUD, (Object) null);
                    }
                }
            } else if (str2.equals(AuthenticationTokenClaims.JSON_KEY_EXP)) {
                init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_EXP, new Date(valueOf.cca_continue(init, AuthenticationTokenClaims.JSON_KEY_EXP) * 1000));
            } else if (str2.equals("nbf")) {
                init2.getInstance.put("nbf", new Date(valueOf.cca_continue(init, "nbf") * 1000));
            } else if (str2.equals(AuthenticationTokenClaims.JSON_KEY_IAT)) {
                init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_IAT, new Date(valueOf.cca_continue(init, AuthenticationTokenClaims.JSON_KEY_IAT) * 1000));
            } else if (str2.equals(AuthenticationTokenClaims.JSON_KEY_JIT)) {
                init2.getInstance.put(AuthenticationTokenClaims.JSON_KEY_JIT, (String) valueOf.getInstance(init, AuthenticationTokenClaims.JSON_KEY_JIT, String.class));
            } else {
                init2.getInstance.put(str2, init.get(str2));
            }
        }
        return new JWTClaimsSet(init2.getInstance, (byte) 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JWTClaimsSet)) {
            return false;
        }
        return Objects.equals(this.getInstance, ((JWTClaimsSet) obj).getInstance);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.getInstance});
    }

    private List<String> Cardinal() {
        List list;
        Object obj = this.getInstance.get(AuthenticationTokenClaims.JSON_KEY_AUD);
        if (obj instanceof String) {
            return Collections.singletonList((String) obj);
        }
        try {
            String[] configure = configure(AuthenticationTokenClaims.JSON_KEY_AUD);
            if (configure == null) {
                list = null;
            } else {
                list = Collections.unmodifiableList(Arrays.asList(configure));
            }
            return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
        } catch (ParseException unused) {
            return Collections.emptyList();
        }
    }

    private String[] configure(String str) throws ParseException {
        if (this.getInstance.get(str) == null) {
            return null;
        }
        try {
            List list = (List) this.getInstance.get(str);
            int size = list.size();
            String[] strArr = new String[size];
            int i = 0;
            while (i < size) {
                try {
                    strArr[i] = (String) list.get(i);
                    i++;
                } catch (ClassCastException unused) {
                    StringBuilder sb = new StringBuilder("The \"");
                    sb.append(str);
                    sb.append("\" claim is not a list / JSON array of strings");
                    throw new ParseException(sb.toString(), 0);
                }
            }
            return strArr;
        } catch (ClassCastException unused2) {
            StringBuilder sb2 = new StringBuilder("The \"");
            sb2.append(str);
            sb2.append("\" claim is not a list / JSON array");
            throw new ParseException(sb2.toString(), 0);
        }
    }

    public final String toString() {
        return setLayoutTransition.Cardinal(getInstance(), setAddStatesFromChildren.init);
    }
}
