package com.didi.beatles.p099im.service.dao;

import android.content.Context;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.utils.IMEncryptionUtil;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.service.dao.IMDaoInitTrace */
public class IMDaoInitTrace {

    /* renamed from: A */
    static final String f9611A = "new_in";
    public static final String APOLLO_ENCRYPT = "encrypt";
    public static final String APOLLO_NO_CIP = "no_cip";
    public static final String APOLLO_NO_ENC = "no_enc";
    public static final String APOLLO_TXT = "txt";

    /* renamed from: B */
    private static final String f9612B = "init";

    /* renamed from: C */
    private static final String f9613C = "none";
    /* access modifiers changed from: private */

    /* renamed from: D */
    public static String f9614D = "fail";

    /* renamed from: a */
    static final String f9615a = "open";

    /* renamed from: b */
    static final String f9616b = "create";

    /* renamed from: c */
    static final String f9617c = "encrypt_outer";

    /* renamed from: d */
    static final String f9618d = "encrypt_inner";

    /* renamed from: e */
    static final String f9619e = "encrypt_new_in";

    /* renamed from: f */
    static final String f9620f = "encrypt_update";

    /* renamed from: g */
    static final String f9621g = "no_enc_create";

    /* renamed from: h */
    static final String f9622h = "no_enc_open";

    /* renamed from: i */
    static final String f9623i = "no_enc_inner";

    /* renamed from: j */
    static final String f9624j = "no_enc_outer";

    /* renamed from: k */
    static final String f9625k = "no_enc_decrypt";

    /* renamed from: l */
    static final String f9626l = "no_enc_new";

    /* renamed from: m */
    static final String f9627m = "outer";

    /* renamed from: n */
    static final String f9628n = "encrypt_outer";

    /* renamed from: o */
    static final String f9629o = "encrypt_inner";

    /* renamed from: p */
    static final String f9630p = "encrypt_new_in";

    /* renamed from: q */
    static final String f9631q = "encrypt_create";

    /* renamed from: r */
    static final String f9632r = "encrypt_open";

    /* renamed from: s */
    static final String f9633s = "encrypt_password";

    /* renamed from: t */
    static final String f9634t = "no_enc_rebuild";

    /* renamed from: u */
    static final String f9635u = "no_enc_outer";

    /* renamed from: v */
    static final String f9636v = "no_enc_inner";

    /* renamed from: w */
    static final String f9637w = "no_enc_decrypt";

    /* renamed from: x */
    static final String f9638x = "inner";

    /* renamed from: y */
    static final String f9639y = "outer";

    /* renamed from: z */
    static final String f9640z = "encrypt";

    private IMDaoInitTrace() {
    }

    /* renamed from: com.didi.beatles.im.service.dao.IMDaoInitTrace$Builder */
    public static class Builder {
        private Map<String, Object> param = new HashMap();
        private long startTime = System.currentTimeMillis();

        public Builder() {
            this.param.put("init", "init");
            this.param.put("degree", "none");
            this.param.put("dao", IMDaoInitTrace.f9614D);
            this.param.put("key", "none");
            this.param.put("size", 0L);
            this.param.put("cost", 0L);
        }

        public void addApollo(String str) {
            this.param.put(GlobalCashierCoreModule.APOLLO, str);
        }

        /* access modifiers changed from: package-private */
        public void addAction(String str) {
            this.param.put("action", str);
        }

        /* access modifiers changed from: package-private */
        public void addDegree(String str) {
            this.param.put("degree", str);
        }

        /* access modifiers changed from: package-private */
        public void addDao(String str) {
            this.param.put("dao", str);
        }

        /* access modifiers changed from: package-private */
        public void addKey(int i, String str) {
            this.param.put("key " + i, "md5:" + IMEncryptionUtil.toMD5(str));
        }

        public void report() {
            this.param.put("time", Long.valueOf(System.currentTimeMillis() - this.startTime));
            Context context = IMContextInfoHelper.getContext();
            if (context != null) {
                this.param.put("crash", Integer.valueOf(IMPreference.getInstance(context).getCrashCount()));
            } else {
                this.param.put("crash", "");
            }
        }

        public String log() {
            return this.param.toString();
        }
    }
}
