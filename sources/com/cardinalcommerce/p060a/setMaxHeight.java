package com.cardinalcommerce.p060a;

import android.content.Context;
import com.didichuxing.foundation.net.CertificateTransporter;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setMaxHeight */
public final class setMaxHeight {

    /* renamed from: c */
    private static int f2874c = 0;

    /* renamed from: d */
    private static int f2875d = 1;

    /* renamed from: a */
    private final Context f2876a;

    /* renamed from: b */
    private final setProgressBackgroundTintMode f2877b;
    public final setLines init;

    public setMaxHeight() {
    }

    public setMaxHeight(Context context) {
        this.f2877b = setProgressBackgroundTintMode.init();
        this.f2876a = context;
        this.init = setLines.init(context);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.cardinalcommerce.a.setProgressTintList, java.lang.String] */
    public final setProgressTintList init(String str) {
        setMax setmax;
        setSecondaryProgress setsecondaryprogress;
        ? r2 = 0;
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(this.init.cca_continue("dsConfigurationString", r2)).getJSONObject("dsConfigurations").getJSONObject("directoryServers").getJSONObject(str);
            if (jSONObject == null) {
                int i = f2874c;
                int i2 = i & 69;
                int i3 = ((i ^ 69) | i2) << 1;
                int i4 = -((i | 69) & (~i2));
                int i5 = (i3 & i4) + (i4 | i3);
                f2875d = i5 % 128;
                int i6 = i5 % 2;
                int i7 = f2875d;
                int i8 = ((i7 | 71) << 1) - (i7 ^ 71);
                f2874c = i8 % 128;
                if (i8 % 2 != 0) {
                    z = true;
                }
                if (!z) {
                    return r2;
                }
                int length = r2.length;
                return r2;
            }
            int i9 = f2874c;
            int i10 = (((i9 | 43) << 1) - (~(-(((~i9) & 43) | (i9 & -44))))) - 1;
            f2875d = i10 % 128;
            int i11 = i10 % 2;
            String string = jSONObject.getString("key");
            if (jSONObject.getString("type").equals("KEY")) {
                int i12 = f2875d;
                int i13 = ((((i12 ^ 105) | (i12 & 105)) << 1) - (~(-(((~i12) & 105) | (i12 & -106))))) - 1;
                f2874c = i13 % 128;
                if ((i13 % 2 != 0 ? '.' : 2) != '.') {
                    setmax = setMax.KEY;
                } else {
                    setmax = setMax.KEY;
                    int i14 = 48 / 0;
                }
            } else {
                setmax = setMax.CERTIFICATE;
                int i15 = f2875d;
                int i16 = i15 | 85;
                int i17 = i16 << 1;
                int i18 = -((~(i15 & 85)) & i16);
                int i19 = (i17 & i18) + (i18 | i17);
                f2874c = i19 % 128;
                int i20 = i19 % 2;
            }
            if (!jSONObject.getString("algorithm").equals("RSA")) {
                setsecondaryprogress = setSecondaryProgress.EC;
                int i21 = f2874c;
                int i22 = ((i21 | 51) << 1) - (i21 ^ 51);
                f2875d = i22 % 128;
                int i23 = i22 % 2;
            } else {
                int i24 = f2874c;
                int i25 = (i24 & 57) + (i24 | 57);
                f2875d = i25 % 128;
                int i26 = i25 % 2;
                setsecondaryprogress = setSecondaryProgress.RSA;
                int i27 = f2874c;
                int i28 = (i27 ^ 22) + ((i27 & 22) << 1);
                int i29 = ((i28 | -1) << 1) - (i28 ^ -1);
                f2875d = i29 % 128;
                int i30 = i29 % 2;
            }
            setProgressTintList setprogresstintlist = new setProgressTintList(string, setsecondaryprogress, setmax);
            int i31 = f2875d;
            int i32 = (i31 ^ 99) + ((i31 & 99) << 1);
            f2874c = i32 % 128;
            int i33 = i32 % 2;
            return setprogresstintlist;
        } catch (JSONException e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2877b;
            StringBuilder sb = new StringBuilder("Unable to get DSString from DSConfiguration: ");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.cca_continue("11406", sb.toString());
        }
    }

    public final String getInstance(String str) {
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(this.init.cca_continue("dsConfigurationString", str2)).getJSONObject("dsConfigurations").getJSONObject("directoryServers").getJSONObject(str);
            if ((jSONObject != null ? 23 : Matrix.MATRIX_TYPE_RANDOM_LT) == 23) {
                int i = f2875d;
                int i2 = i & 19;
                int i3 = -(-((i ^ 19) | i2));
                int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
                f2874c = i4 % 128;
                int i5 = i4 % 2;
                String string = jSONObject.getString("rootCertificate");
                if (string != null) {
                    StringBuilder sb = new StringBuilder(CertificateTransporter.BEGIN_CERTIFICATE);
                    sb.append(string);
                    sb.append(CertificateTransporter.END_CERTIFICATE);
                    String obj = sb.toString();
                    int i6 = (((f2875d + 119) - 1) + 0) - 1;
                    f2874c = i6 % 128;
                    int i7 = i6 % 2;
                    return obj;
                }
            }
            int i8 = f2874c + 61;
            f2875d = i8 % 128;
            int i9 = i8 % 2;
        } catch (JSONException e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2877b;
            StringBuilder sb2 = new StringBuilder("Unable to get DSString from DSConfiguration: ");
            sb2.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.cca_continue("11406", sb2.toString());
        }
        int i10 = f2874c;
        int i11 = (i10 | 37) << 1;
        int i12 = -(i10 ^ 37);
        int i13 = (i11 & i12) + (i12 | i11);
        f2875d = i13 % 128;
        if ((i13 % 2 == 0 ? (char) 17 : 3) != 17) {
            return str2;
        }
        super.hashCode();
        return str2;
    }

    public final boolean configure(String str) {
        int i = f2875d;
        int i2 = (i & 21) - (~(i | 21));
        boolean z = true;
        int i3 = i2 - 1;
        f2874c = i3 % 128;
        int i4 = i3 % 2;
        String cca_continue = this.init.cca_continue("dsConfigurationString", "");
        Object obj = null;
        if (cca_continue.isEmpty()) {
            int i5 = f2875d;
            int i6 = (((i5 ^ 93) | (i5 & 93)) << 1) - (((~i5) & 93) | (i5 & -94));
            f2874c = i6 % 128;
            if (i6 % 2 == 0) {
                z = false;
            }
            if (!z) {
                return false;
            }
            super.hashCode();
            return false;
        }
        int i7 = f2875d;
        int i8 = (i7 & 105) + (i7 | 105);
        f2874c = i8 % 128;
        char c = i8 % 2 != 0 ? 'Q' : 'H';
        boolean contains = cca_continue.contains(str);
        if (c == 'Q') {
            super.hashCode();
        }
        int i9 = f2875d;
        int i10 = i9 | 113;
        int i11 = i10 << 1;
        int i12 = -((~(i9 & 113)) & i10);
        int i13 = ((i11 | i12) << 1) - (i12 ^ i11);
        f2874c = i13 % 128;
        if ((i13 % 2 != 0 ? VersionRange.LEFT_OPEN : 29) != '(') {
            return contains;
        }
        super.hashCode();
        return contains;
    }
}
