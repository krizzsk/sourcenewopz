package com.didi.unifylogin.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.api.OneLoginFacade;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InnerAuthManager {
    public static final String LOGIN_AUTH_FEEDBACK_PATH = "login_feedback";
    public static final String LOGIN_AUTH_PATH = "login_auth";
    public static final String PACKAGE_NAME_QUERY = "packagename";
    public static final String RESULT_QUERY = "result";
    public static final String SOURCE_QUERY = "source";
    public static final String TOKEN_QUERY = "token";

    /* renamed from: a */
    private static final InnerAuthManager f44664a = new InnerAuthManager();

    /* renamed from: b */
    private Context f44665b;

    /* renamed from: c */
    private String f44666c;

    /* renamed from: d */
    private String f44667d;

    /* renamed from: e */
    private String f44668e;

    /* renamed from: f */
    private Set<String> f44669f = new HashSet();

    /* renamed from: g */
    private Set<String> f44670g = new HashSet();
    public Passenger99AuthLoginHelper mPassenger99AuthLoginHelper;

    public static InnerAuthManager getInstance() {
        return f44664a;
    }

    public void initAuth(AuthParam authParam) {
        Passenger99AuthLoginHelper passenger99AuthLoginHelper = new Passenger99AuthLoginHelper(authParam);
        this.mPassenger99AuthLoginHelper = passenger99AuthLoginHelper;
        ThirdPartyLoginManager.addThirdPartyLogin(passenger99AuthLoginHelper);
    }

    public void register(Context context, Uri uri) {
        this.f44665b = context;
        this.f44669f.addAll(Arrays.asList(context.getResources().getStringArray(R.array.auth_package_name)));
        this.f44667d = uri.getQueryParameter(PACKAGE_NAME_QUERY);
        this.f44668e = uri.getQueryParameter("source");
    }

    @Deprecated
    public void auth() {
        if (OneLoginFacade.getStore().isLoginNow()) {
            this.f44665b.startActivity(new Intent("android.intent.action.VIEW", new Uri.Builder().scheme(this.f44668e).authority("one").appendPath("login").appendPath(LOGIN_AUTH_FEEDBACK_PATH).appendQueryParameter("result", String.valueOf(true)).appendQueryParameter("token", OneLoginFacade.getStore().getToken()).build()));
        }
    }

    public void notAuth() {
        this.f44665b.startActivity(new Intent("android.intent.action.VIEW", new Uri.Builder().scheme(this.f44668e).authority("one").appendPath("login").appendPath(LOGIN_AUTH_FEEDBACK_PATH).appendQueryParameter("result", String.valueOf(false)).build()));
    }

    public void onAuth(Uri uri) {
        Intent intent = new Intent();
        intent.putExtra("token", uri.getQueryParameter("token"));
        this.mPassenger99AuthLoginHelper.handleLoginResult(0, 0, intent);
    }

    public boolean requestAuth(Uri uri) {
        return uri.getPath().contains(LOGIN_AUTH_PATH);
    }

    public boolean responseAuth(Uri uri) {
        return uri.getPath().contains(LOGIN_AUTH_FEEDBACK_PATH);
    }

    public boolean illegal() {
        return TextUtils.isEmpty(this.f44667d) || !this.f44669f.contains(this.f44667d) || TextUtils.isEmpty(this.f44668e);
    }

    public static class AuthParam {
        String feedback;
        String packageName;
        String signature;

        public AuthParam(String str, String str2, String str3) {
            this.packageName = str;
            this.signature = str2;
            this.feedback = str3;
        }

        public static class Builder {
            String feedback;
            String packageName;
            String signature;

            public String getPackageName() {
                return this.packageName;
            }

            public Builder setPackageName(String str) {
                this.packageName = str;
                return this;
            }

            public String getSignature() {
                return this.signature;
            }

            public Builder setSignature(String str) {
                this.signature = str;
                return this;
            }

            public String getFeedback() {
                return this.feedback;
            }

            public Builder setFeedback(String str) {
                this.feedback = str;
                return this;
            }

            public AuthParam build() {
                return new AuthParam(this.packageName, this.signature, this.feedback);
            }
        }
    }
}
