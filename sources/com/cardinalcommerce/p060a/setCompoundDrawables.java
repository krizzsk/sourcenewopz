package com.cardinalcommerce.p060a;

import java.util.concurrent.Executors;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setCompoundDrawables */
public final class setCompoundDrawables implements Runnable {

    /* renamed from: a */
    private static int f2745a = 0;

    /* renamed from: b */
    private static int f2746b = 1;
    public setCompoundDrawableTintMode cca_continue = new setCompoundDrawableTintMode();
    public setCompoundDrawablesRelative getInstance;

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String] */
    public final JSONObject getInstance() {
        JSONObject jSONObject = new JSONObject();
        ? r1 = 0;
        try {
            boolean z = false;
            if ((this.getInstance != null ? 'C' : 17) != 17) {
                int i = f2745a;
                int i2 = ((i ^ 27) - (~(-(-((i & 27) << 1))))) - 1;
                f2746b = i2 % 128;
                if ((i2 % 2 == 0 ? '0' : 5) != 5) {
                    jSONObject.putOpt("BluetoothData", this.getInstance.init());
                    int i3 = 1 / 0;
                } else {
                    jSONObject.putOpt("BluetoothData", this.getInstance.init());
                }
            }
            if ((this.cca_continue != null ? Typography.quote : VersionRange.LEFT_OPEN) != '(') {
                int i4 = f2746b;
                int i5 = i4 & 91;
                int i6 = -(-((i4 ^ 91) | i5));
                int i7 = ((i5 | i6) << 1) - (i6 ^ i5);
                f2745a = i7 % 128;
                if (i7 % 2 != 0) {
                    z = true;
                }
                if (!z) {
                    jSONObject.putOpt("NetworkData", this.cca_continue.getInstance());
                } else {
                    jSONObject.putOpt("NetworkData", this.cca_continue.getInstance());
                    int length = r1.length;
                }
            }
            int i8 = f2746b + 39;
            f2745a = i8 % 128;
            int i9 = i8 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), r1);
        }
        int i10 = f2746b;
        int i11 = ((i10 | 14) << 1) - (i10 ^ 14);
        int i12 = (i11 ^ -1) + ((i11 & -1) << 1);
        f2745a = i12 % 128;
        int i13 = i12 % 2;
        return jSONObject;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [com.cardinalcommerce.a.setCompoundDrawablesRelative, com.cardinalcommerce.a.setCompoundDrawableTintMode, java.lang.Object] */
    public final void run() {
        int i = f2745a;
        int i2 = i & 3;
        int i3 = ((((i ^ 3) | i2) << 1) - (~(-((i | 3) & (~i2))))) - 1;
        f2746b = i3 % 128;
        int i4 = i3 % 2;
        ? r2 = 0;
        if (!(this.getInstance == null)) {
            int i5 = f2745a;
            int i6 = ((i5 ^ 65) | (i5 & 65)) << 1;
            int i7 = -(((~i5) & 65) | (i5 & -66));
            int i8 = (i6 & i7) + (i7 | i6);
            f2746b = i8 % 128;
            int i9 = i8 % 2;
            Executors.newSingleThreadExecutor().execute(this.getInstance);
            this.getInstance = r2;
            int i10 = f2746b;
            int i11 = (i10 | 23) << 1;
            int i12 = -(i10 ^ 23);
            int i13 = ((i11 | i12) << 1) - (i12 ^ i11);
            f2745a = i13 % 128;
            int i14 = i13 % 2;
        }
        char c = 'b';
        if ((this.cca_continue != null ? 1 : 'O') == 1) {
            int i15 = f2745a;
            int i16 = (i15 ^ 54) + ((i15 & 54) << 1);
            int i17 = (i16 ^ -1) + ((i16 & -1) << 1);
            f2746b = i17 % 128;
            if ((i17 % 2 == 0 ? 'b' : '$') != 'b') {
                Executors.newSingleThreadExecutor().execute(this.cca_continue);
                this.cca_continue = r2;
            } else {
                Executors.newSingleThreadExecutor().execute(this.cca_continue);
                this.cca_continue = r2;
                super.hashCode();
            }
            int i18 = f2745a;
            int i19 = i18 & 83;
            int i20 = (i19 - (~((i18 ^ 83) | i19))) - 1;
            f2746b = i20 % 128;
            int i21 = i20 % 2;
        }
        int i22 = f2746b;
        int i23 = i22 & 97;
        int i24 = (i22 | 97) & (~i23);
        int i25 = i23 << 1;
        int i26 = (i24 ^ i25) + ((i24 & i25) << 1);
        f2745a = i26 % 128;
        if (i26 % 2 != 0) {
            c = 'J';
        }
        if (c == 'J') {
            int i27 = 79 / 0;
        }
    }
}
