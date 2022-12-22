package com.didi.foundation.sdk.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.didi.foundation.sdk.depsdowngrade.DependencyDowngradeToggle;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.foundation.sdk.swarm.AuthenticationServiceImpl;
import com.didi.unifylogin.api.LoginConfigApi;
import com.didi.unifylogin.api.LoginCountryEnum;
import com.didi.unifylogin.api.LoginInitParam;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.entrance.OneLoginActivity;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.login.MsLoginFacade;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

@ServiceProvider({LoginServiceProvider.class})
public class LoginServiceImpl implements LoginServiceProvider {

    /* renamed from: a */
    private static ArrayList<LoginCountryEnum> f21248a;

    public String getCityId() {
        return null;
    }

    static {
        ArrayList<LoginCountryEnum> arrayList = new ArrayList<>();
        f21248a = arrayList;
        arrayList.add(LoginCountryEnum.AUSTRALIA);
        f21248a.add(LoginCountryEnum.BRASIL);
        f21248a.add(LoginCountryEnum.CHAIN);
        f21248a.add(LoginCountryEnum.HONG_KONG);
        f21248a.add(LoginCountryEnum.JAPAN);
        f21248a.add(LoginCountryEnum.MEXICO);
        f21248a.add(LoginCountryEnum.TAIWAN);
        f21248a.add(LoginCountryEnum.COSTARICA);
        f21248a.add(LoginCountryEnum.COLOMBIA);
    }

    public void addLoginListener(LoginCallbacks.LoginListener loginListener) {
        if (loginListener != null) {
            OneLoginFacade.getFunction().addLoginListener(loginListener);
        }
    }

    public void addLogoutListener(LoginCallbacks.LoginOutListener loginOutListener) {
        if (loginOutListener != null) {
            OneLoginFacade.getFunction().addLoginOutListener(loginOutListener);
        }
    }

    public String getCountryCode() {
        return OneLoginFacade.getStore().getCountryCode();
    }

    public Intent getLoginIntent(Context context) {
        if (context == null) {
            return null;
        }
        m15625a(context);
        return new Intent(context, OneLoginActivity.class);
    }

    public String getPhone() {
        return OneLoginFacade.getStore().getPhone();
    }

    public String getToken() {
        return OneLoginFacade.getStore().getToken();
    }

    public String getUid() {
        return OneLoginFacade.getStore().getUid();
    }

    public void go2Login(Context context) {
        if (context != null) {
            m15625a(context);
            OneLoginFacade.getAction().go2Login(context);
        }
    }

    public void go2ModifyEmail(Context context, LoginCallbacks.ModifyEmailListener modifyEmailListener) {
        if (context != null) {
            OneLoginFacade.getAction().go2ModifyEmail(context, modifyEmailListener);
        }
    }

    public void go2ModifyPassword(Context context, LoginCallbacks.ModifyPasswordListener modifyPasswordListener) {
        if (context != null) {
            OneLoginFacade.getAction().go2ModifyPassword(context, modifyPasswordListener);
        }
    }

    public void go2ModifyPhone(Context context, LoginCallbacks.SetCellListener setCellListener) {
        if (context != null) {
            OneLoginFacade.getAction().go2ChangePhone(context, setCellListener);
        }
    }

    public void go2SetThirdParty(Context context) {
        OneLoginFacade.getAction().go2SetThirdParty(context);
    }

    public void init(final Context context) {
        m15626b(context);
        m15627c(context);
        m15624a();
        addLoginListener(new LoginCallbacks.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                context.sendBroadcast(new Intent(AuthenticationServiceImpl.ACTION_SIGN_IN));
            }
        });
        addLogoutListener(new LoginCallbacks.LoginOutListener() {
            public void onSuccess() {
                context.sendBroadcast(new Intent(AuthenticationServiceImpl.ACTION_SIGN_OUT));
            }
        });
    }

    public boolean isLogin() {
        return OneLoginFacade.getStore().isLoginNow();
    }

    public void logout(Context context) {
        OneLoginFacade.getAction().loginOut(context);
    }

    public void logout(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            OneLoginFacade.getAction().loginOut(context, str);
        } else {
            logout(context);
        }
    }

    public void go2CancellationAccount(Context context, LoginCallbacks.CancelAccFinishListener cancelAccFinishListener) {
        OneLoginFacade.getAction().go2CancellationAccount(context, cancelAccFinishListener);
    }

    public void go2CancelOrDeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        OneLoginFacade.getAction().go2CancelOrDeleteAccount(context, cancelAccFinishListener);
    }

    public void removeLoginListener(LoginCallbacks.LoginListener loginListener) {
        OneLoginFacade.getFunction().removeLoginListener(loginListener);
    }

    public void removeLogoutListener(LoginCallbacks.LoginOutListener loginOutListener) {
        OneLoginFacade.getFunction().removeLoginOutListener(loginOutListener);
    }

    public void setButtonStyle(LoginButtonStyle loginButtonStyle) {
        OneLoginFacade.getConfigApi().setButtonStyle(m15622a(loginButtonStyle));
    }

    public void setTheme(int i) {
        OneLoginFacade.getConfigApi().setTheme(i);
    }

    /* renamed from: a */
    private void m15625a(Context context) {
        LoginConfig loginConfiguration = LoginConfigService.getInstance().getLoginConfiguration();
        if (loginConfiguration != null && loginConfiguration.mo63107d() != 0) {
            OneLoginFacade.getConfigApi().setLawHint(context.getString(loginConfiguration.mo63107d()));
        }
    }

    /* renamed from: com.didi.foundation.sdk.login.LoginServiceImpl$4 */
    static /* synthetic */ class C83704 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$foundation$sdk$login$LoginButtonStyle;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.foundation.sdk.login.LoginButtonStyle[] r0 = com.didi.foundation.sdk.login.LoginButtonStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$foundation$sdk$login$LoginButtonStyle = r0
                com.didi.foundation.sdk.login.LoginButtonStyle r1 = com.didi.foundation.sdk.login.LoginButtonStyle.GRAY_BUTTON     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$foundation$sdk$login$LoginButtonStyle     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.foundation.sdk.login.LoginButtonStyle r1 = com.didi.foundation.sdk.login.LoginButtonStyle.ORANGE_GRADUAL_BUTTON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$foundation$sdk$login$LoginButtonStyle     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.foundation.sdk.login.LoginButtonStyle r1 = com.didi.foundation.sdk.login.LoginButtonStyle.ORANGE_BUTTON     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.login.LoginServiceImpl.C83704.<clinit>():void");
        }
    }

    /* renamed from: a */
    private int m15622a(LoginButtonStyle loginButtonStyle) {
        int i = C83704.$SwitchMap$com$didi$foundation$sdk$login$LoginButtonStyle[loginButtonStyle.ordinal()];
        if (i != 1) {
            return i != 2 ? 1 : 2;
        }
        return 0;
    }

    /* renamed from: b */
    private void m15626b(Context context) {
        LoginParams loginParams = LoginConfigService.getInstance().getLoginParams();
        if (loginParams != null) {
            LoginInitParam loginInitParam = new LoginInitParam(loginParams.mo63143a());
            loginInitParam.netModeListener = loginParams.mo63149g();
            loginInitParam.webViewListener = loginParams.mo63147e();
            loginInitParam.logListener = loginParams.mo63148f();
            loginInitParam.riskParamListener = loginParams.mo63146d();
            loginInitParam.defCountryId = m15621a(loginParams.mo63144b());
            loginInitParam.isGlobal = loginParams.isGlobal();
            loginInitParam.globalizationListener = new LoginListeners.GlobalizationListener() {
                public String getLanguage() {
                    return LocaleService.getInstance().getCurrentLangTag();
                }

                public Locale getSystemLocale() {
                    try {
                        return LocaleService.getInstance().getCurrentLocale();
                    } catch (Exception unused) {
                        return LoginServiceImpl.this.getDefaultLocale();
                    }
                }
            };
            OneLoginFacade.init(context, loginInitParam);
            if (loginParams.mo63150h() != null) {
                OneLoginFacade.getFunction().addLoginListener(loginParams.mo63150h());
            }
            if (loginParams.mo63151i() != null) {
                OneLoginFacade.getFunction().addLoginOutListener(loginParams.mo63151i());
                return;
            }
            return;
        }
        throw new NullPointerException("LoginConfigServiceProvider needs to be implemented!");
    }

    public Locale getDefaultLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0);
        }
        return Locale.getDefault();
    }

    /* renamed from: a */
    private int m15621a(int i) {
        if (i != -1) {
            return i;
        }
        Locale currentLocale = LocaleService.getInstance().getCurrentLocale();
        if (currentLocale == null) {
            return -1;
        }
        return m15623a(currentLocale.getCountry());
    }

    /* renamed from: a */
    private int m15623a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Iterator<LoginCountryEnum> it = f21248a.iterator();
        while (it.hasNext()) {
            LoginCountryEnum next = it.next();
            if (TextUtils.equals(str, next.getAreaCode())) {
                return next.getCountryId();
            }
        }
        return -1;
    }

    /* renamed from: c */
    private void m15627c(Context context) {
        LoginConfig loginConfiguration = LoginConfigService.getInstance().getLoginConfiguration();
        if (loginConfiguration != null) {
            OneLoginFacade.getConfigApi().setDefLawSelected(loginConfiguration.mo63113i());
            OneLoginFacade.getConfigApi().setLawUrl(loginConfiguration.mo63106c());
            OneLoginFacade.getConfigApi().setLawHint(context.getString(loginConfiguration.mo63107d()));
            OneLoginFacade.getConfigApi().setActivityDelegate(loginConfiguration.mo63115k());
            OneLoginFacade.getConfigApi().setHomeCanBack(loginConfiguration.mo63109f());
            OneLoginFacade.getConfigApi().setTheme(loginConfiguration.getTheme());
            OneLoginFacade.getConfigApi().setCanSwitchCountry(loginConfiguration.mo63108e());
            OneLoginFacade.getConfigApi().setSupportJump(loginConfiguration.mo63110g());
            OneLoginFacade.getConfigApi().setNeedPrePage(loginConfiguration.mo63112h());
            OneLoginFacade.getConfigApi().setAutoFullCode(loginConfiguration.mo63114j());
            OneLoginFacade.getConfigApi().setExchangeNamePosition(loginConfiguration.mo63117m());
            OneLoginFacade.getConfigApi().isUnifyPwd(loginConfiguration.mo63118n());
            OneLoginFacade.getConfigApi().setGuidePermissions(loginConfiguration.mo63116l());
            OneLoginFacade.getConfigApi().setDeleteAccountPageUseTextStyle(loginConfiguration.mo63104a());
            OneLoginFacade.getConfigApi().setUsePassengerUIStyle(loginConfiguration.mo63105b());
            LoginConfigApi.setTextAdapter(loginConfiguration.mo63119o());
            return;
        }
        throw new NullPointerException("LoginConfigServiceProvider is not implemented");
    }

    /* renamed from: a */
    private void m15624a() {
        ArrayList arrayList = new ArrayList();
        if (!DependencyDowngradeToggle.getInstance().isDowngradeFaceBookLogin()) {
            arrayList.add("facebook");
        }
        if (!DependencyDowngradeToggle.getInstance().isDowngradeGoogleLogin()) {
            arrayList.add("google");
        }
        MsLoginFacade.init(arrayList);
    }
}
