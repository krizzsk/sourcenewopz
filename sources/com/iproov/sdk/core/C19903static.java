package com.iproov.sdk.core;

import com.google.common.base.Ascii;
import com.iproov.sdk.core.C19798break;
import com.iproov.sdk.core.exception.IProovException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONException;
import p093switch.C3115do;
import p093switch.C3124new;

/* renamed from: com.iproov.sdk.core.static */
/* compiled from: SecurityReport */
public class C19903static {

    /* renamed from: a */
    static final C19898import[] f54335a = {C19898import.AND1, C19898import.AND2, C19898import.AND3, C19898import.AND4, C19898import.AND5, C19898import.AND6, C19898import.AND7, C19898import.AND8, C19898import.AND9, C19898import.AND10, C19898import.AND11, C19898import.AND12, C19898import.AND13, C19898import.AND14};

    /* renamed from: b */
    static final C19798break.C19799do[] f54336b = {C19798break.C19799do.AND15, C19798break.C19799do.AND16, C19798break.C19799do.AND17, C19798break.C19799do.AND18, C19798break.C19799do.AND19};

    /* renamed from: c */
    static final C19904super[] f54337c = {C19904super.AND20, C19904super.AND21, C19904super.AND22, C19904super.AND23, C19904super.AND24, C19904super.AND25, C19904super.AND26, C19904super.AND27, C19904super.AND28, C19904super.AND29, C19904super.AND30, C19904super.AND31, C19904super.AND32};

    /* renamed from: a */
    private static boolean m39254a(C19898import importR) {
        return C19797b.m38871a(importR) == Boolean.TRUE;
    }

    /* renamed from: b */
    private static byte[] m39258b(String str) {
        return new StringBuilder(str).reverse().toString().getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: a */
    private static boolean m39253a(C19798break.C19799do doVar) {
        return C19797b.m38870a(doVar) == Boolean.TRUE;
    }

    /* renamed from: a */
    private static void m39250a(int i) {
        try {
            for (Method method : Class.forName(C19802catch.m38913a()).getMethods()) {
                if (method.getName().equals("error")) {
                    method.invoke((Object) null, new Object[]{Integer.valueOf(i)});
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static void m39251a(int i, int i2, int i3) {
        if (i2 != i3) {
            m39250a(i);
        }
    }

    /* renamed from: a */
    private static void m39252a(JSONArray jSONArray) {
        int i;
        try {
            int i2 = 0;
            for (C19898import importR : f54335a) {
                i2 = i + 1;
                m39251a(i2, jSONArray.getInt(i2), 1);
            }
            for (C19798break.C19799do doVar : f54336b) {
                if (doVar == C19798break.C19799do.AND17 || doVar == C19798break.C19799do.AND18) {
                    i++;
                } else {
                    i++;
                    m39251a(i, jSONArray.getInt(i), 0);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static String m39249a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(0);
        for (C19898import a : f54335a) {
            jSONArray.put(m39259do(Boolean.valueOf(m39254a(a))));
        }
        for (C19798break.C19799do a2 : f54336b) {
            jSONArray.put(m39259do(Boolean.valueOf(m39253a(a2))));
        }
        for (C19904super a3 : f54337c) {
            jSONArray.put(m39259do(C19797b.m38872a(a3)));
        }
        m39252a(jSONArray);
        return jSONArray.toString();
    }

    /* renamed from: do */
    public static Object m39259do(Object obj) {
        return obj instanceof Boolean ? Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0) : obj;
    }

    /* renamed from: a */
    static byte[] m39255a(String str) throws NoSuchAlgorithmException {
        byte[] bArr = new byte[16];
        System.arraycopy(C3115do.m4023do(C3124new.m4036do(m39258b(str))), 0, bArr, 0, 16);
        return bArr;
    }

    /* renamed from: a */
    static byte[] m39256a(byte[] bArr, String str) throws IProovException {
        try {
            return C19796a.m38869a(m39249a(), m39255a(str), bArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IProovException("Unknown data", e);
        }
    }

    /* renamed from: a */
    static byte[] m39257a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length + 12)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        int length = bArr.length + bArr2.length;
        bArr3[length] = (byte) (bArr2.length >> 16);
        bArr3[length + 1] = (byte) (bArr2.length >> 8);
        bArr3[length + 2] = (byte) bArr2.length;
        bArr3[length + 3] = 0;
        bArr3[length + 4] = 0;
        bArr3[length + 5] = 0;
        bArr3[length + 6] = 0;
        bArr3[length + 7] = 0;
        bArr3[length + 8] = 0;
        bArr3[length + 9] = 0;
        bArr3[length + 10] = 34;
        bArr3[length + 11] = Ascii.ESC;
        return bArr3;
    }

    /* renamed from: do */
    public static byte[] m39260do(byte[] bArr, byte[] bArr2, String str) throws IProovException {
        return m39257a(bArr, m39256a(bArr2, str));
    }
}
