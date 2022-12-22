package com.didi.unifylogin.utils;

import android.content.Context;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.pojo.response.LoginPageAbTestResponse;
import org.json.JSONObject;

public class ApolloSwitch {

    /* renamed from: a */
    private static final String f44902a = "unify_login_passport_update_sdk";

    /* renamed from: b */
    private static final String f44903b = "unify_login_passport_update_sdk_ab_result_extra";

    /* renamed from: c */
    private static ApolloSwitch f44904c;

    /* renamed from: d */
    private Context f44905d;

    public static ApolloSwitch getInstance() {
        if (f44904c == null) {
            f44904c = new ApolloSwitch();
        }
        return f44904c;
    }

    private ApolloSwitch() {
    }

    public void init(Context context) {
        this.f44905d = context;
    }

    public boolean passportSdkUpdate() {
        return ((Boolean) SPUtils.get(this.f44905d, f44902a, false)).booleanValue();
    }

    public boolean isLoginSDKUIV2(boolean z) {
        return m32206a("ab_login_style", 1) == 1;
    }

    public boolean supportWhatsAppLogin() {
        return m32206a("ab_whatsapp_login", 0) == 1;
    }

    public boolean isNewWhatsApp() {
        return m32206a("ab_whatsapp_new_login", 0) == 1;
    }

    /* renamed from: a */
    private int m32206a(String str, int i) {
        String str2 = (String) SPUtils.get(this.f44905d, f44903b, "{}");
        try {
            if (!TextUtil.isEmpty(str2)) {
                return new JSONObject(str2).optInt(str, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public void updatePassportUpdateSDK(LoginPageAbTestResponse loginPageAbTestResponse) {
        if (loginPageAbTestResponse != null && loginPageAbTestResponse.errno == 0) {
            Context context = this.f44905d;
            boolean z = true;
            if (loginPageAbTestResponse.abResult != 1) {
                z = false;
            }
            SPUtils.put(context, f44902a, Boolean.valueOf(z));
            if (loginPageAbTestResponse.abResultExtra != null) {
                Context context2 = this.f44905d;
                SPUtils.put(context2, f44903b, "" + loginPageAbTestResponse.abResultExtra);
                return;
            }
            SPUtils.remove(this.f44905d, f44903b);
        }
    }
}
