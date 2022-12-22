package com.didi.unifylogin.store;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.utils.LoginLog;

public class LoginStore extends BaseStore {
    public static final String CACHE_KEY_UID = "uid";
    public static final int NEW_USER = 1;

    /* renamed from: a */
    private static final String f44867a = "LoginStore";

    /* renamed from: b */
    private static final String f44868b = "role";

    /* renamed from: c */
    private static final String f44869c = "appId";

    /* renamed from: d */
    private static final String f44870d = "Token";

    /* renamed from: e */
    private static final String f44871e = "phone";

    /* renamed from: f */
    private static final String f44872f = "hide_email";

    /* renamed from: g */
    private static final String f44873g = "plain_text_email";

    /* renamed from: h */
    private static final String f44874h = "credential";

    /* renamed from: i */
    private static final String f44875i = "countryId";
    public static boolean isDebug = false;

    /* renamed from: j */
    private static final String f44876j = "token_refresh_time";

    /* renamed from: k */
    private static final String f44877k = "double_identity";

    /* renamed from: l */
    private static final String f44878l = "is_law_checked";

    /* renamed from: m */
    private static final String f44879m = "is_data_migration";

    /* renamed from: n */
    private static final String f44880n = "finish_input_info";

    /* renamed from: o */
    private static Context f44881o;

    /* renamed from: p */
    private static volatile LoginStore f44882p;

    /* renamed from: A */
    private int f44883A = 0;

    /* renamed from: B */
    private String f44884B;

    /* renamed from: q */
    private int f44885q = -1;

    /* renamed from: r */
    private int f44886r = -1;

    /* renamed from: s */
    private String f44887s;

    /* renamed from: t */
    private String f44888t;

    /* renamed from: u */
    private String f44889u;

    /* renamed from: v */
    private String f44890v;

    /* renamed from: w */
    private String f44891w;

    /* renamed from: x */
    private long f44892x = -1;

    /* renamed from: y */
    private int f44893y = -1;

    /* renamed from: z */
    private int f44894z = -1;

    private LoginStore() {
        super("com.didi.sdk.login.c.j");
    }

    public static LoginStore getInstance() {
        if (f44882p == null) {
            synchronized (LoginStore.class) {
                if (f44882p == null) {
                    f44882p = new LoginStore();
                }
            }
        }
        return f44882p;
    }

    public static void setContext(Context context) {
        f44881o = context.getApplicationContext();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            isDebug = (applicationInfo.flags & 2) != 0;
        }
    }

    public static Context getContext() {
        return f44881o;
    }

    public String getToken() {
        if (f44881o == null) {
            SystemUtils.log(5, f44867a, "context is null, failed to get token", (Throwable) null, "com.didi.unifylogin.store.LoginStore", 176);
            return "";
        }
        if (this.f44890v == null) {
            this.f44890v = m32193a(f44870d);
        }
        return this.f44890v;
    }

    public long getUid() {
        if (this.f44892x <= 0) {
            this.f44892x = m32192a("uid", -1);
        }
        return this.f44892x;
    }

    public String getPhone() {
        if (this.f44887s == null) {
            this.f44887s = m32193a("phone");
        }
        return this.f44887s;
    }

    public int getRole() {
        if (this.f44885q == -1) {
            this.f44885q = m32191a("role", -1);
        }
        return this.f44885q;
    }

    public int getAppId() {
        if (this.f44886r < 0) {
            this.f44886r = m32191a("appId", -1);
        }
        return this.f44886r;
    }

    public int getCountryId() {
        if (this.f44893y <= 0) {
            this.f44893y = m32191a("countryId", -1);
        }
        return this.f44893y;
    }

    public void setAndSaveCountryId(int i) {
        if (i >= 0) {
            this.f44893y = i;
            putAndSave(f44881o, "countryId", String.valueOf(i));
        }
    }

    public int getDefCountryId() {
        return this.f44894z;
    }

    public void setDefCountryId(int i) {
        if (i > 0) {
            this.f44894z = i;
        }
    }

    public boolean isDoubleId() {
        return m32196a(f44877k, false);
    }

    public int getUserType() {
        return this.f44883A;
    }

    public boolean isLawChecked() {
        return m32196a(f44878l, false);
    }

    public void setTemporaryToken(String str) {
        this.f44891w = str;
    }

    public String getTemporaryToken() {
        return this.f44891w;
    }

    public void setToken(String str) {
        this.f44890v = str;
    }

    public void setAndsaveToken(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f44890v = str;
            putAndSave(f44881o, f44870d, str);
            saveTokenRefreshTime();
            LoginLog.write("LoginStore saveToken()");
        }
    }

    public void setAndSaceUid(long j) {
        this.f44892x = j;
        putAndSave(f44881o, "uid", String.valueOf(j));
    }

    public void setAndSaveRole(int i) {
        if (i >= 0) {
            this.f44885q = i;
            putAndSave(f44881o, "role", String.valueOf(i));
        }
    }

    public void setAndSaveAppId(int i) {
        this.f44886r = i;
        putAndSave(f44881o, "appId", (long) i);
    }

    public void setAppId(int i) {
        this.f44886r = i;
    }

    public void setAndSavePhone(String str) {
        this.f44887s = str;
        putAndSave(f44881o, "phone", str);
    }

    public void setAndSaveHideEmail(String str) {
        this.f44888t = str;
        if (TextUtils.isEmpty(str)) {
            clearAll(f44872f);
        } else {
            putAndSave(f44881o, f44872f, str);
        }
    }

    public void setAndSavePlainTextEmail(String str) {
        this.f44889u = str;
        if (TextUtils.isEmpty(str)) {
            clearAll(f44873g);
        } else {
            putAndSave(f44881o, f44873g, this.f44889u);
        }
    }

    public String getPlainTextEmail() {
        if (TextUtils.isEmpty(this.f44889u)) {
            this.f44889u = m32193a(f44873g);
        }
        return this.f44889u;
    }

    public String getHideEmail() {
        if (TextUtils.isEmpty(this.f44888t)) {
            this.f44888t = m32193a(f44872f);
        }
        return this.f44888t;
    }

    public String getCredential() {
        if (TextUtils.isEmpty(this.f44884B)) {
            this.f44884B = m32193a(f44874h);
        }
        return this.f44884B;
    }

    public void setAndSaveCredential(String str) {
        this.f44884B = str;
        if (TextUtils.isEmpty(str)) {
            clearAll(f44874h);
        } else {
            putAndSave(f44881o, f44874h, str);
        }
    }

    public void setAndSaveDoubleId(boolean z) {
        putAndSave(f44881o, f44877k, String.valueOf(z));
    }

    public void setUserType(int i) {
        if (i > -1) {
            this.f44883A = i;
        }
    }

    public void setLawChecked(boolean z) {
        putAndSave(f44881o, f44878l, String.valueOf(z));
    }

    public void saveTokenRefreshTime() {
        putAndSave(f44881o, f44876j, String.valueOf(System.currentTimeMillis()));
    }

    public Long getTokenRefreshTime() {
        String a = getInstance().m32193a(f44876j);
        if (TextUtils.isEmpty(a)) {
            return 0L;
        }
        try {
            return Long.valueOf(Long.parseLong(a));
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public void loginOutClean() {
        this.f44890v = null;
        this.f44892x = -1;
        this.f44885q = -1;
        this.f44891w = null;
        this.f44888t = null;
        this.f44884B = null;
        clearAll(f44870d);
        clearAll("uid");
        clearAll("role");
        clearAll(f44872f);
        clearAll(f44874h);
        clearAll(f44880n);
        LoginLog.write("LoginStore loginOutClean() ");
    }

    public void cleanPhone() {
        this.f44887s = null;
        clearAll("phone");
        LoginLog.write("LoginStorecleanPhone()");
    }

    /* renamed from: a */
    private void m32195a(String str, String str2, long j, int i) {
        LoginLog.write("LoginStore saveLoginInfo() token:" + str + " ,phone:" + str2 + " ,uid:" + j + " ,countryId:" + i);
        if (!TextUtil.isEmpty(str)) {
            setTemporaryToken(str);
            setAndsaveToken(str);
        }
        if (!TextUtil.isEmpty(str2)) {
            setAndSavePhone(str2);
        }
        if (j > 0) {
            setAndSaceUid(j);
        }
        if (i > 0) {
            setAndSaveCountryId(i);
            CountryManager.getIns().saveOldCountry(f44881o, i);
        }
    }

    /* renamed from: a */
    private void m32194a(BaseLoginSuccessResponse baseLoginSuccessResponse) {
        if (baseLoginSuccessResponse != null) {
            String str = baseLoginSuccessResponse.emailPlainText;
            if (!TextUtils.isEmpty(str)) {
                setAndSavePlainTextEmail(str);
            } else {
                setAndSavePlainTextEmail("");
            }
        }
    }

    public void saveLoginInfo(BaseLoginSuccessResponse baseLoginSuccessResponse, FragmentMessenger fragmentMessenger) {
        if (baseLoginSuccessResponse != null) {
            if (fragmentMessenger != null) {
                setAndSaveHideEmail(fragmentMessenger.getHideEmail());
                setAndSaveCredential(fragmentMessenger.getCredential());
            }
            m32195a(baseLoginSuccessResponse.ticket, baseLoginSuccessResponse.cell, baseLoginSuccessResponse.uid, baseLoginSuccessResponse.countryId);
            m32194a(baseLoginSuccessResponse);
        }
    }

    public void updateLoginInfo(BaseLoginSuccessResponse baseLoginSuccessResponse) {
        if (TextUtils.isEmpty(baseLoginSuccessResponse.cell)) {
            getInstance().setAndSavePhone("");
        } else {
            getInstance().setAndSavePhone(baseLoginSuccessResponse.cell);
        }
    }

    public void dataMigration(String str, String str2, long j, int i) {
        if (!m32196a(f44879m, false)) {
            LoginLog.write("LoginStore dataMigration() token:*** ,phone:" + str2 + ",uid:" + j + ",countryId:" + i);
            m32195a(str, str2, j, i);
            setAndsaveToken(getTemporaryToken());
            putAndSave(f44881o, f44879m, String.valueOf(true));
        }
    }

    public void setFinishInputInfo(boolean z) {
        putAndSave(f44881o, f44880n, String.valueOf(z));
    }

    public boolean getFinishInputInfo() {
        return m32196a(f44880n, true);
    }

    /* renamed from: a */
    private String m32193a(String str) {
        Context context = f44881o;
        if (context == null) {
            return "";
        }
        Object inner = getInner(context, str);
        return inner instanceof byte[] ? new String((byte[]) inner) : (String) inner;
    }

    /* renamed from: a */
    private int m32191a(String str, int i) {
        try {
            String a = m32193a(str);
            if (!TextUtil.isEmpty(a)) {
                return Integer.parseInt(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /* renamed from: a */
    private long m32192a(String str, long j) {
        try {
            String a = m32193a(str);
            if (!TextUtil.isEmpty(a)) {
                return Long.parseLong(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    /* renamed from: a */
    private boolean m32196a(String str, boolean z) {
        try {
            String a = m32193a(str);
            if (!TextUtil.isEmpty(a)) {
                return Boolean.parseBoolean(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }
}
