package com.didi.foundation.sdk.login;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.unifylogin.api.LoginTextAdapter;
import com.didi.unifylogin.listener.LoginListeners;

public class LoginConfig {

    /* renamed from: a */
    private String f21220a;

    /* renamed from: b */
    private int f21221b;

    /* renamed from: c */
    private boolean f21222c;

    /* renamed from: d */
    private boolean f21223d;

    /* renamed from: e */
    private boolean f21224e;

    /* renamed from: f */
    private boolean f21225f;

    /* renamed from: g */
    private boolean f21226g;

    /* renamed from: h */
    private boolean f21227h;

    /* renamed from: i */
    private LoginListeners.LoginBaseActivityDelegate f21228i;

    /* renamed from: j */
    private LoginListeners.GuidePermissionsDelegate f21229j;

    /* renamed from: k */
    private boolean f21230k;

    /* renamed from: l */
    private int f21231l;

    /* renamed from: m */
    private boolean f21232m;

    /* renamed from: n */
    private boolean f21233n;

    /* renamed from: o */
    private boolean f21234o;

    /* renamed from: p */
    private FoundationLoginTextAdapter f21235p;

    public static class FoundationLoginTextAdapter extends LoginTextAdapter {
        public FoundationDialogText getResPwdWarnDialog(Context context) {
            return null;
        }
    }

    LoginConfig(final Builder builder) {
        this.f21220a = builder.mLawUrl;
        this.f21221b = builder.mLawHintResId;
        this.f21222c = builder.mCanSwitchCountry;
        this.f21223d = builder.mCanHomeBack;
        this.f21224e = builder.mIsSupportJump;
        this.f21225f = builder.mNeedPrePage;
        this.f21226g = builder.mIsDefLawSelected;
        this.f21227h = builder.mIsAutoFullCode;
        this.f21233n = builder.mDeleteAccountPageUseTextStyle;
        this.f21234o = builder.mUsePassengerUIStyle;
        this.f21228i = new LoginListeners.LoginBaseActivityDelegate() {
            public Context getAttachBaseContext(Context context, FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    return LocaleService.getInstance().attachBaseContext(builder.mLoginBaseActivityDelegate.getAttachBaseContext(context, fragmentActivity));
                }
                return LocaleService.getInstance().attachBaseContext(context);
            }

            public void onCreate(Bundle bundle, FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onCreate(bundle, fragmentActivity);
                }
            }

            public void onRestart(FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onRestart(fragmentActivity);
                }
            }

            public void onResume(FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onResume(fragmentActivity);
                }
            }

            public void onActivityResult(FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onActivityResult(fragmentActivity);
                }
            }
        };
        this.f21229j = builder.mGuidePermissionsDelegate;
        this.f21230k = builder.mIsExchangeNamePosition;
        this.f21231l = builder.mTheme;
        this.f21232m = builder.mIsUnifyPwd;
        this.f21235p = builder.mLoginTextAdapter;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo63104a() {
        return this.f21233n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo63105b() {
        return this.f21234o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo63106c() {
        return this.f21220a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo63107d() {
        return this.f21221b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo63108e() {
        return this.f21222c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo63109f() {
        return this.f21223d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo63110g() {
        return this.f21224e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo63112h() {
        return this.f21225f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo63113i() {
        return this.f21226g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo63114j() {
        return this.f21227h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public LoginListeners.LoginBaseActivityDelegate mo63115k() {
        return this.f21228i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public LoginListeners.GuidePermissionsDelegate mo63116l() {
        return this.f21229j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo63117m() {
        return this.f21230k;
    }

    public int getTheme() {
        return this.f21231l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo63118n() {
        return this.f21232m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public FoundationLoginTextAdapter mo63119o() {
        return this.f21235p;
    }

    public static class FoundationDialogText extends LoginTextAdapter.DialogText {
        public FoundationDialogText(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean mCanHomeBack;
        /* access modifiers changed from: private */
        public boolean mCanSwitchCountry;
        /* access modifiers changed from: private */
        public boolean mDeleteAccountPageUseTextStyle;
        /* access modifiers changed from: private */
        public LoginListeners.GuidePermissionsDelegate mGuidePermissionsDelegate;
        /* access modifiers changed from: private */
        public boolean mIsAutoFullCode;
        /* access modifiers changed from: private */
        public boolean mIsDefLawSelected;
        /* access modifiers changed from: private */
        public boolean mIsExchangeNamePosition;
        /* access modifiers changed from: private */
        public boolean mIsSupportJump;
        /* access modifiers changed from: private */
        public boolean mIsUnifyPwd;
        /* access modifiers changed from: private */
        public int mLawHintResId;
        /* access modifiers changed from: private */
        public String mLawUrl;
        /* access modifiers changed from: private */
        public LoginListeners.LoginBaseActivityDelegate mLoginBaseActivityDelegate;
        /* access modifiers changed from: private */
        public FoundationLoginTextAdapter mLoginTextAdapter;
        /* access modifiers changed from: private */
        public boolean mNeedPrePage;
        /* access modifiers changed from: private */
        public int mTheme;
        /* access modifiers changed from: private */
        public boolean mUsePassengerUIStyle;

        public Builder setLawUrl(String str) {
            this.mLawUrl = str;
            return this;
        }

        public Builder setLawHintResId(int i) {
            this.mLawHintResId = i;
            return this;
        }

        public Builder setCanSwitchCountry(boolean z) {
            this.mCanSwitchCountry = z;
            return this;
        }

        public Builder setCanHomeBack(boolean z) {
            this.mCanHomeBack = z;
            return this;
        }

        public Builder setSupportJump(boolean z) {
            this.mIsSupportJump = z;
            return this;
        }

        public Builder setNeedPrePage(boolean z) {
            this.mNeedPrePage = z;
            return this;
        }

        public Builder setDefLawSelected(boolean z) {
            this.mIsDefLawSelected = z;
            return this;
        }

        public Builder setAutoFullCode(boolean z) {
            this.mIsAutoFullCode = z;
            return this;
        }

        public Builder setLoginBaseActivityDelegate(LoginListeners.LoginBaseActivityDelegate loginBaseActivityDelegate) {
            this.mLoginBaseActivityDelegate = loginBaseActivityDelegate;
            return this;
        }

        public Builder setGuidePermissionsDelegate(LoginListeners.GuidePermissionsDelegate guidePermissionsDelegate) {
            this.mGuidePermissionsDelegate = guidePermissionsDelegate;
            return this;
        }

        public Builder setExchangeNamePosition(boolean z) {
            this.mIsExchangeNamePosition = z;
            return this;
        }

        public Builder setTheme(int i) {
            this.mTheme = i;
            return this;
        }

        public Builder setUnifyPwd(boolean z) {
            this.mIsUnifyPwd = z;
            return this;
        }

        public Builder setLoginTextAdapter(FoundationLoginTextAdapter foundationLoginTextAdapter) {
            this.mLoginTextAdapter = foundationLoginTextAdapter;
            return this;
        }

        public Builder setDeleteAccountPageUseTextStyle(boolean z) {
            this.mDeleteAccountPageUseTextStyle = z;
            return this;
        }

        public Builder setUsePassengerUIStyle(boolean z) {
            this.mUsePassengerUIStyle = z;
            return this;
        }

        public LoginConfig build() {
            return new LoginConfig(this);
        }
    }
}
