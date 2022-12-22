package com.cardinalcommerce.p060a;

import com.didi.sdk.apm.SystemUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setJustificationMode */
public class setJustificationMode extends JSONArray {

    /* renamed from: b */
    private static int f2837b = 0;

    /* renamed from: c */
    private static int f2838c = 1;

    /* renamed from: a */
    private final String f2839a = setJustificationMode.class.getSimpleName();

    setJustificationMode(String str) throws JSONException {
        super(str);
    }

    setJustificationMode() {
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [org.json.JSONObject, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0125, code lost:
        r6 = f2837b;
        r7 = r6 & 3;
        r6 = -(-((r6 ^ 3) | r7));
        r8 = (r7 ^ r6) + ((r6 & r7) << 1);
        f2838c = r8 % 128;
        r8 = r8 % 2;
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject cca_continue(java.util.HashMap<java.lang.String, java.lang.String> r12, java.lang.String r13) {
        /*
            r11 = this;
            int r0 = f2837b
            int r0 = r0 + 2
            r1 = r0 | -1
            r2 = 1
            int r1 = r1 << r2
            r0 = r0 ^ -1
            int r1 = r1 - r0
            int r0 = r1 % 128
            f2838c = r0
            r0 = 2
            int r1 = r1 % r0
            r3 = 0
            if (r1 != 0) goto L_0x0016
            r1 = 0
            goto L_0x0017
        L_0x0016:
            r1 = 1
        L_0x0017:
            if (r1 == r2) goto L_0x001b
            r1 = 1
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            r4 = 0
            int r5 = r11.length()     // Catch:{ JSONException -> 0x01c0 }
            r6 = 26
            if (r1 >= r5) goto L_0x0028
            r5 = 20
            goto L_0x002a
        L_0x0028:
            r5 = 26
        L_0x002a:
            if (r5 == r6) goto L_0x0196
            int r5 = f2838c
            r6 = r5 & -28
            int r7 = ~r5
            r7 = r7 & 27
            r6 = r6 | r7
            r5 = r5 & 27
            int r5 = r5 << r2
            int r5 = -r5
            int r5 = -r5
            r7 = r6 & r5
            r5 = r5 | r6
            int r7 = r7 + r5
            int r5 = r7 % 128
            f2837b = r5
            int r7 = r7 % r0
            if (r7 == 0) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            if (r5 == 0) goto L_0x0057
            org.json.JSONObject r5 = r11.getJSONObject(r1)     // Catch:{ JSONException -> 0x01c0 }
            java.util.Set r6 = r12.keySet()     // Catch:{ JSONException -> 0x01c0 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ JSONException -> 0x01c0 }
            r7 = 1
            goto L_0x0064
        L_0x0057:
            org.json.JSONObject r5 = r11.getJSONObject(r1)     // Catch:{ JSONException -> 0x01c0 }
            java.util.Set r6 = r12.keySet()     // Catch:{ JSONException -> 0x01c0 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ JSONException -> 0x01c0 }
            r7 = 0
        L_0x0064:
            int r8 = f2837b
            int r8 = r8 + 77
            int r9 = r8 % 128
            f2838c = r9
            int r8 = r8 % r0
        L_0x006d:
            boolean r8 = r6.hasNext()     // Catch:{ JSONException -> 0x01c0 }
            if (r8 == 0) goto L_0x0075
            r8 = 1
            goto L_0x0076
        L_0x0075:
            r8 = 0
        L_0x0076:
            if (r8 == 0) goto L_0x014a
            int r7 = f2838c
            r8 = r7 ^ 108(0x6c, float:1.51E-43)
            r7 = r7 & 108(0x6c, float:1.51E-43)
            int r7 = r7 << r2
            int r8 = r8 + r7
            int r8 = r8 - r2
            int r7 = r8 % 128
            f2837b = r7
            int r8 = r8 % r0
            java.lang.Object r7 = r6.next()     // Catch:{ JSONException -> 0x01c0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ JSONException -> 0x01c0 }
            boolean r8 = r5.has(r7)     // Catch:{ JSONException -> 0x01c0 }
            if (r8 == 0) goto L_0x0094
            r8 = 0
            goto L_0x0095
        L_0x0094:
            r8 = 1
        L_0x0095:
            if (r8 == r2) goto L_0x00e2
            int r8 = f2838c
            r9 = r8 ^ 2
            r8 = r8 & r0
            int r8 = r8 << r2
            int r9 = r9 + r8
            r8 = r9 | -1
            int r8 = r8 << r2
            r9 = r9 ^ -1
            int r8 = r8 - r9
            int r9 = r8 % 128
            f2837b = r9
            int r8 = r8 % r0
            if (r8 == 0) goto L_0x00ad
            r8 = 0
            goto L_0x00ae
        L_0x00ad:
            r8 = 1
        L_0x00ae:
            if (r8 == 0) goto L_0x00c5
            java.lang.String r8 = r5.getString(r7)     // Catch:{ JSONException -> 0x01c0 }
            java.lang.Object r9 = r12.get(r7)     // Catch:{ JSONException -> 0x01c0 }
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x01c0 }
            if (r8 != 0) goto L_0x00c0
            r8 = 0
            goto L_0x00c1
        L_0x00c0:
            r8 = 1
        L_0x00c1:
            if (r8 == 0) goto L_0x00e2
            goto L_0x013a
        L_0x00c5:
            java.lang.String r8 = r5.getString(r7)     // Catch:{ JSONException -> 0x01c0 }
            java.lang.Object r9 = r12.get(r7)     // Catch:{ JSONException -> 0x01c0 }
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x01c0 }
            super.hashCode()     // Catch:{ all -> 0x00e0 }
            r9 = 54
            if (r8 != 0) goto L_0x00db
            r8 = 54
            goto L_0x00dd
        L_0x00db:
            r8 = 33
        L_0x00dd:
            if (r8 == r9) goto L_0x00e2
            goto L_0x013a
        L_0x00e0:
            r12 = move-exception
            throw r12
        L_0x00e2:
            boolean r8 = r5.has(r7)     // Catch:{ JSONException -> 0x01c0 }
            r9 = 79
            if (r8 != 0) goto L_0x00ed
            r8 = 79
            goto L_0x00ee
        L_0x00ed:
            r8 = 2
        L_0x00ee:
            if (r8 == r9) goto L_0x00f1
            goto L_0x0125
        L_0x00f1:
            int r8 = f2838c
            r9 = r8 | 45
            int r9 = r9 << r2
            r8 = r8 ^ 45
            int r8 = -r8
            r10 = r9 & r8
            r8 = r8 | r9
            int r10 = r10 + r8
            int r8 = r10 % 128
            f2837b = r8
            int r10 = r10 % r0
            if (r10 == 0) goto L_0x0106
            r8 = 0
            goto L_0x0107
        L_0x0106:
            r8 = 1
        L_0x0107:
            if (r8 == r2) goto L_0x011a
            boolean r7 = r7.equals(r13)     // Catch:{ JSONException -> 0x01c0 }
            super.hashCode()     // Catch:{ all -> 0x0118 }
            if (r7 == 0) goto L_0x0114
            r7 = 0
            goto L_0x0115
        L_0x0114:
            r7 = 1
        L_0x0115:
            if (r7 == r2) goto L_0x0125
            goto L_0x013a
        L_0x0118:
            r12 = move-exception
            throw r12
        L_0x011a:
            boolean r7 = r7.equals(r13)     // Catch:{ JSONException -> 0x01c0 }
            if (r7 == 0) goto L_0x0122
            r7 = 1
            goto L_0x0123
        L_0x0122:
            r7 = 0
        L_0x0123:
            if (r7 == r2) goto L_0x013a
        L_0x0125:
            int r6 = f2837b
            r7 = r6 & 3
            r6 = r6 ^ 3
            r6 = r6 | r7
            int r6 = -r6
            int r6 = -r6
            r8 = r7 ^ r6
            r6 = r6 & r7
            int r6 = r6 << r2
            int r8 = r8 + r6
            int r6 = r8 % 128
            f2838c = r6
            int r8 = r8 % r0
            r7 = 0
            goto L_0x014a
        L_0x013a:
            int r7 = f2838c
            r8 = r7 ^ 121(0x79, float:1.7E-43)
            r7 = r7 & 121(0x79, float:1.7E-43)
            int r7 = r7 << r2
            int r8 = r8 + r7
            int r7 = r8 % 128
            f2837b = r7
            int r8 = r8 % r0
            r7 = 1
            goto L_0x006d
        L_0x014a:
            if (r7 == 0) goto L_0x014e
            r6 = 2
            goto L_0x0150
        L_0x014e:
            r6 = 87
        L_0x0150:
            if (r6 == r0) goto L_0x016a
            r4 = r1 & 2
            r1 = r1 | 2
            int r4 = r4 + r1
            r1 = r4 & -1
            r4 = r4 | -1
            int r1 = r1 + r4
            int r4 = f2838c
            int r4 = r4 + 99
            int r4 = r4 - r2
            int r4 = r4 - r3
            int r4 = r4 - r2
            int r5 = r4 % 128
            f2837b = r5
            int r4 = r4 % r0
            goto L_0x001c
        L_0x016a:
            int r12 = f2838c
            int r12 = r12 + 88
            int r12 = r12 - r2
            int r13 = r12 % 128
            f2837b = r13
            int r12 = r12 % r0
            if (r12 == 0) goto L_0x0178
            r12 = 2
            goto L_0x017a
        L_0x0178:
            r12 = 58
        L_0x017a:
            if (r12 == r0) goto L_0x017d
            goto L_0x017e
        L_0x017d:
            int r12 = r4.length     // Catch:{ all -> 0x0194 }
        L_0x017e:
            int r12 = f2838c
            r13 = r12 & 81
            int r1 = ~r13
            r12 = r12 | 81
            r12 = r12 & r1
            int r13 = r13 << r2
            int r13 = -r13
            int r13 = -r13
            r1 = r12 ^ r13
            r12 = r12 & r13
            int r12 = r12 << r2
            int r1 = r1 + r12
            int r12 = r1 % 128
            f2837b = r12
            int r1 = r1 % r0
            return r5
        L_0x0194:
            r12 = move-exception
            throw r12
        L_0x0196:
            int r12 = f2838c
            r13 = r12 & 13
            r12 = r12 ^ 13
            r12 = r12 | r13
            int r12 = ~r12
            int r13 = r13 - r12
            int r13 = r13 - r2
            int r12 = r13 % 128
            f2837b = r12
            int r13 = r13 % r0
            int r12 = f2838c
            int r12 = r12 + 100
            int r12 = r12 - r2
            int r13 = r12 % 128
            f2837b = r13
            int r12 = r12 % r0
            int r12 = f2837b
            r13 = r12 & 91
            r12 = r12 ^ 91
            r12 = r12 | r13
            r1 = r13 ^ r12
            r12 = r12 & r13
            int r12 = r12 << r2
            int r1 = r1 + r12
            int r12 = r1 % 128
            f2838c = r12
            int r1 = r1 % r0
        L_0x01c0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setJustificationMode.cca_continue(java.util.HashMap, java.lang.String):org.json.JSONObject");
    }

    public final void cca_continue(JSONObject jSONObject, JSONObject jSONObject2) {
        Object[] objArr;
        int i = f2837b;
        int i2 = i & 45;
        int i3 = i | 45;
        int i4 = (i2 & i3) + (i3 | i2);
        f2838c = i4 % 128;
        boolean z = false;
        int i5 = (i4 % 2 == 0 ? 0 : 1) ^ 1;
        int i6 = f2838c;
        int i7 = (((i6 ^ 111) | (i6 & 111)) << 1) - (((~i6) & 111) | (i6 & -112));
        f2837b = i7 % 128;
        int i8 = i7 % 2;
        while (true) {
            try {
                if ((i5 < length() ? '*' : ',') != ',') {
                    int i9 = f2838c;
                    int i10 = ((i9 | 98) << 1) - (i9 ^ 98);
                    int i11 = (i10 ^ -1) + ((i10 & -1) << 1);
                    f2837b = i11 % 128;
                    int i12 = i11 % 2;
                    if (!(getJSONObject(i5) != jSONObject)) {
                        int i13 = f2837b;
                        int i14 = i13 & 41;
                        int i15 = (i13 | 41) & (~i14);
                        int i16 = -(-(i14 << 1));
                        int i17 = ((i15 | i16) << 1) - (i15 ^ i16);
                        f2838c = i17 % 128;
                        objArr = null;
                        if (i17 % 2 != 0) {
                            if ((jSONObject2 != null ? 22 : 'V') != 'V') {
                                break;
                            }
                        } else {
                            int length = objArr.length;
                            if ((jSONObject2 != null ? 'Q' : 6) != 6) {
                                break;
                            }
                        }
                    }
                    int i18 = (i5 | 54) << 1;
                    int i19 = -(i5 ^ 54);
                    int i20 = ((i18 | i19) << 1) - (i19 ^ i18);
                    int i21 = i20 ^ -53;
                    i5 = (((i20 & -53) | i21) << 1) - i21;
                    int i22 = f2837b;
                    int i23 = i22 & 25;
                    int i24 = ((((i22 ^ 25) | i23) << 1) - (~(-((i22 | 25) & (~i23))))) - 1;
                    f2838c = i24 % 128;
                    int i25 = i24 % 2;
                } else {
                    int i26 = f2838c;
                    int i27 = i26 ^ 33;
                    int i28 = ((i26 & 33) | i27) << 1;
                    int i29 = -i27;
                    int i30 = ((i28 | i29) << 1) - (i28 ^ i29);
                    f2837b = i30 % 128;
                    int i31 = i30 % 2;
                    return;
                }
            } catch (JSONException e) {
                String str = this.f2839a;
                StringBuilder sb = new StringBuilder("Exception during replacing logs JSON. Error: ");
                sb.append(e.getLocalizedMessage());
                SystemUtils.log(6, str, sb.toString(), (Throwable) null, "com.cardinalcommerce.a.setJustificationMode", 79);
                return;
            }
        }
        int i32 = f2837b + 125;
        f2838c = i32 % 128;
        int i33 = i32 % 2;
        remove(i5);
        put(jSONObject2);
        int i34 = f2837b;
        int i35 = (i34 & -20) | ((~i34) & 19);
        int i36 = (i34 & 19) << 1;
        int i37 = (i35 & i36) + (i36 | i35);
        f2838c = i37 % 128;
        if (i37 % 2 == 0) {
            z = true;
        }
        if (z) {
            int length2 = objArr.length;
        }
    }
}
