package com.cardinalcommerce.p060a;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.permission.runtime.Permission;

/* renamed from: com.cardinalcommerce.a.setMaxLines */
public final class setMaxLines {

    /* renamed from: f */
    private static int f2878f = 0;

    /* renamed from: g */
    private static int f2879g = 1;

    /* renamed from: a */
    private boolean f2880a = false;

    /* renamed from: b */
    private boolean f2881b = false;

    /* renamed from: c */
    private boolean f2882c = false;

    /* renamed from: d */
    private boolean f2883d = false;

    /* renamed from: e */
    private boolean f2884e = false;

    public final boolean Cardinal() {
        boolean z;
        int i = f2878f;
        int i2 = i & 43;
        int i3 = (i ^ 43) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2879g = i4 % 128;
        if (i4 % 2 == 0) {
            z = this.f2880a;
            int i5 = 19 / 0;
        } else {
            z = this.f2880a;
        }
        int i6 = f2879g;
        int i7 = i6 ^ 75;
        int i8 = (((i6 & 75) | i7) << 1) - i7;
        f2878f = i8 % 128;
        int i9 = i8 % 2;
        return z;
    }

    public final boolean getInstance() {
        boolean z;
        int i = f2879g;
        boolean z2 = true;
        int i2 = ((((i ^ 19) | (i & 19)) << 1) - (~(-(((~i) & 19) | (i & -20))))) - 1;
        f2878f = i2 % 128;
        if ((i2 % 2 != 0 ? 'K' : 16) != 16) {
            z = this.f2881b;
            int i3 = 33 / 0;
        } else {
            z = this.f2881b;
        }
        int i4 = f2878f;
        int i5 = i4 & 123;
        int i6 = ((i4 ^ 123) | i5) << 1;
        int i7 = -((i4 | 123) & (~i5));
        int i8 = (i6 ^ i7) + ((i7 & i6) << 1);
        f2879g = i8 % 128;
        if (i8 % 2 != 0) {
            z2 = false;
        }
        if (!z2) {
            return z;
        }
        int i9 = 22 / 0;
        return z;
    }

    public final boolean init() {
        boolean z;
        int i = f2879g;
        int i2 = (i ^ 35) + ((i & 35) << 1);
        f2878f = i2 % 128;
        if ((i2 % 2 != 0 ? 17 : ';') != ';') {
            z = this.f2882c;
            int i3 = 58 / 0;
        } else {
            z = this.f2882c;
        }
        int i4 = f2878f;
        int i5 = (i4 | 89) << 1;
        int i6 = -(((~i4) & 89) | (i4 & -90));
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f2879g = i7 % 128;
        int i8 = i7 % 2;
        return z;
    }

    public final boolean configure() {
        boolean z;
        int i = f2878f;
        int i2 = (i & 21) + (i | 21);
        f2879g = i2 % 128;
        if ((i2 % 2 == 0 ? 10 : 'M') != 'M') {
            z = this.f2883d;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            z = this.f2883d;
        }
        int i3 = f2878f;
        int i4 = i3 & 95;
        int i5 = (((i3 | 95) & (~i4)) - (~(-(-(i4 << 1))))) - 1;
        f2879g = i5 % 128;
        int i6 = i5 % 2;
        return z;
    }

    public final boolean cca_continue() {
        int i = f2878f;
        int i2 = (i & 27) - (~(i | 27));
        boolean z = true;
        int i3 = i2 - 1;
        f2879g = i3 % 128;
        int i4 = i3 % 2;
        boolean z2 = this.f2884e;
        int i5 = f2879g + 67;
        f2878f = i5 % 128;
        if (i5 % 2 != 0) {
            z = false;
        }
        if (z) {
            return z2;
        }
        int i6 = 19 / 0;
        return z2;
    }

    public setMaxLines(Context context) {
        boolean z = false;
        this.f2880a = ContextCompat.checkSelfPermission(context, Permission.READ_PHONE_STATE) == 0;
        if (Build.VERSION.SDK_INT >= 31) {
            this.f2881b = ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0;
        } else {
            this.f2881b = ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH") == 0;
        }
        this.f2882c = ContextCompat.checkSelfPermission(context, Permission.ACCESS_COARSE_LOCATION) == 0;
        this.f2883d = ContextCompat.checkSelfPermission(context, Permission.ACCESS_FINE_LOCATION) == 0;
        this.f2884e = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_WIFI_STATE") == 0 ? true : z;
    }
}
