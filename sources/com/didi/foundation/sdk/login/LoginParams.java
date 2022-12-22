package com.didi.foundation.sdk.login;

import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.unifylogin.base.log.LogListener;
import com.didi.unifylogin.base.net.LoginNetModeListener;

public class LoginParams {

    /* renamed from: a */
    private int f21237a;

    /* renamed from: b */
    private int f21238b;

    /* renamed from: c */
    private LoginCallbacks.LocationListener f21239c;

    /* renamed from: d */
    private LoginCallbacks.RiskParamListener f21240d;

    /* renamed from: e */
    private LoginCallbacks.WebViewListener f21241e;

    /* renamed from: f */
    private LogListener f21242f;

    /* renamed from: g */
    private LoginNetModeListener f21243g;

    /* renamed from: h */
    private LoginCallbacks.LoginListener f21244h;

    /* renamed from: i */
    private LoginCallbacks.LoginOutListener f21245i;

    /* renamed from: j */
    private boolean f21246j;

    LoginParams(Builder builder) {
        this.f21237a = builder.mAppId;
        this.f21238b = builder.mDefCountryId;
        this.f21239c = builder.mLocationListener;
        this.f21240d = builder.mRiskParamListener;
        this.f21241e = builder.mWebViewListener;
        this.f21242f = builder.mLogListener;
        this.f21243g = builder.mNetModeListener;
        this.f21244h = builder.mLoginListener;
        this.f21245i = builder.mLogoutListener;
        this.f21246j = builder.mIsGlobal;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63143a() {
        return this.f21237a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63144b() {
        return this.f21238b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public LoginCallbacks.LocationListener mo63145c() {
        return this.f21239c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public LoginCallbacks.RiskParamListener mo63146d() {
        return this.f21240d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public LoginCallbacks.WebViewListener mo63147e() {
        return this.f21241e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public LogListener mo63148f() {
        return this.f21242f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public LoginNetModeListener mo63149g() {
        return this.f21243g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public LoginCallbacks.LoginListener mo63150h() {
        return this.f21244h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public LoginCallbacks.LoginOutListener mo63151i() {
        return this.f21245i;
    }

    public boolean isGlobal() {
        return this.f21246j;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int mAppId;
        /* access modifiers changed from: private */
        public int mDefCountryId = -1;
        /* access modifiers changed from: private */
        public boolean mIsGlobal = true;
        /* access modifiers changed from: private */
        public LoginCallbacks.LocationListener mLocationListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.LogListener mLogListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.LoginListener mLoginListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.LoginOutListener mLogoutListener;
        /* access modifiers changed from: private */
        public LoginNetModeListener mNetModeListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.RiskParamListener mRiskParamListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.WebViewListener mWebViewListener;

        public Builder(int i) {
            this.mAppId = i;
        }

        public Builder setDefCountryId(int i) {
            this.mDefCountryId = i;
            return this;
        }

        public Builder setLocationListener(LoginCallbacks.LocationListener locationListener) {
            this.mLocationListener = locationListener;
            return this;
        }

        public Builder setRiskParamListener(LoginCallbacks.RiskParamListener riskParamListener) {
            this.mRiskParamListener = riskParamListener;
            return this;
        }

        public Builder setWebViewListener(LoginCallbacks.WebViewListener webViewListener) {
            this.mWebViewListener = webViewListener;
            return this;
        }

        public Builder setLogListener(LoginCallbacks.LogListener logListener) {
            this.mLogListener = logListener;
            return this;
        }

        public Builder setNetModeListener(LoginNetModeListener loginNetModeListener) {
            this.mNetModeListener = loginNetModeListener;
            return this;
        }

        public Builder setLoginListener(LoginCallbacks.LoginListener loginListener) {
            this.mLoginListener = loginListener;
            return this;
        }

        public Builder setLogoutListener(LoginCallbacks.LoginOutListener loginOutListener) {
            this.mLogoutListener = loginOutListener;
            return this;
        }

        public Builder setGlobal(boolean z) {
            this.mIsGlobal = z;
            return this;
        }

        public LoginParams build() {
            return new LoginParams(this);
        }
    }
}
