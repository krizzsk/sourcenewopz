package com.didichuxing.security.cardverify;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.util.SystemUtil;

public class DiCardVerifyParam {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f48862a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f48863b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f48864c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f48865d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f48866e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f48867f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f48868g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f48869h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f48870i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f48871j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f48872k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f48873l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f48874m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f48875n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f48876o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f48877p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f48878q;

    private DiCardVerifyParam() {
    }

    public String getUid() {
        return this.f48862a;
    }

    public String getCardIndex() {
        return this.f48863b;
    }

    public String getCountry() {
        return this.f48864c;
    }

    public String getLanguage() {
        return this.f48865d;
    }

    public String getToken() {
        return this.f48866e;
    }

    public String getTerminalId() {
        return this.f48867f;
    }

    public String getProductId() {
        return this.f48868g;
    }

    public String getCardNo() {
        return this.f48869h;
    }

    public String getLatitude() {
        return this.f48870i;
    }

    public String getLongitude() {
        return this.f48871j;
    }

    public String getIp() {
        return this.f48872k;
    }

    public String getPhone() {
        return this.f48873l;
    }

    public String getAppVersion() {
        return this.f48874m;
    }

    public String getSdkVersion() {
        return this.f48875n;
    }

    public String getOstype() {
        return this.f48876o;
    }

    public String getOs() {
        return this.f48877p;
    }

    public String getSence() {
        return this.f48878q;
    }

    public static class Builder {
        private DiCardVerifyParam param;

        public Builder(Context context) {
            DiCardVerifyParam diCardVerifyParam = new DiCardVerifyParam();
            this.param = diCardVerifyParam;
            String unused = diCardVerifyParam.f48874m = SystemUtil.getVersionName(context);
            String unused2 = this.param.f48875n = BuildConfig.VERSION_NAME;
            String unused3 = this.param.f48876o = "1";
            String unused4 = this.param.f48877p = String.valueOf(Build.VERSION.SDK_INT);
            String unused5 = this.param.f48878q = "1";
        }

        public Builder uid(String str) {
            String unused = this.param.f48862a = str;
            return this;
        }

        public Builder cardIndex(String str) {
            String unused = this.param.f48863b = str;
            return this;
        }

        public Builder country(String str) {
            String unused = this.param.f48864c = str;
            return this;
        }

        public Builder language(String str) {
            String unused = this.param.f48865d = str;
            return this;
        }

        public Builder token(String str) {
            String unused = this.param.f48866e = str;
            return this;
        }

        public Builder terminalId(String str) {
            String unused = this.param.f48867f = str;
            return this;
        }

        public Builder productId(String str) {
            String unused = this.param.f48868g = str;
            return this;
        }

        public Builder cardNo(String str) {
            String unused = this.param.f48869h = str;
            return this;
        }

        public Builder latitude(String str) {
            String unused = this.param.f48870i = str;
            return this;
        }

        public Builder longitude(String str) {
            String unused = this.param.f48871j = str;
            return this;
        }

        /* renamed from: ip */
        public Builder mo120734ip(String str) {
            String unused = this.param.f48872k = str;
            return this;
        }

        public Builder phone(String str) {
            String unused = this.param.f48873l = str;
            return this;
        }

        public DiCardVerifyParam build() {
            return this.param;
        }
    }
}
