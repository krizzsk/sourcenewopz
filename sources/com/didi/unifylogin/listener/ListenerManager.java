package com.didi.unifylogin.listener;

import com.didi.unifylogin.listener.LoginListeners;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListenerManager {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<LoginListeners.LoginListener> f44790a = new ConcurrentLinkedQueue<>();

    /* renamed from: b */
    private static ConcurrentLinkedQueue<LoginListeners.LoginJumpListener> f44791b = new ConcurrentLinkedQueue<>();

    /* renamed from: c */
    private static ConcurrentLinkedQueue<LoginListeners.LoginOutListener> f44792c = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    private static ConcurrentLinkedQueue<LoginListeners.TokenListener> f44793d = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    private static LoginListeners.LoginInterceptor f44794e;

    /* renamed from: f */
    private static LoginListeners.CancelAccFinishListener f44795f;

    /* renamed from: g */
    private static LoginListeners.LocationListener f44796g;

    /* renamed from: h */
    private static LoginListeners.GlobalizationListener f44797h;

    /* renamed from: i */
    private static LoginListeners.WebViewListener f44798i;

    /* renamed from: j */
    private static LoginListeners.CustomStateFragment f44799j;

    /* renamed from: k */
    private static LoginListeners.ModifyPasswordListener f44800k;

    /* renamed from: l */
    private static LoginListeners.SetCellListener f44801l;

    /* renamed from: m */
    private static LoginListeners.InputCPFListener f44802m;

    /* renamed from: n */
    private static LoginListeners.ModifyEmailListener f44803n;

    /* renamed from: o */
    private static LoginListeners.VerifyCodeListener f44804o;

    /* renamed from: p */
    private static LoginListeners.LoginBaseActivityDelegate f44805p;

    /* renamed from: q */
    private static LoginListeners.GuidePermissionsDelegate f44806q;

    /* renamed from: r */
    private static LoginListeners.LoadingViewListener f44807r;

    /* renamed from: s */
    private static LoginListeners.FaceListener f44808s;

    /* renamed from: t */
    private static LoginListeners.WhatsAppListener f44809t;

    /* renamed from: u */
    private static LoginListeners.GetParamsListener f44810u;

    /* renamed from: v */
    private static LoginListeners.FirstInstallListener f44811v;

    /* renamed from: w */
    private static LoginListeners.InfoAutoFillListener f44812w;

    /* renamed from: x */
    private static LoginListeners.ShowSkipListener f44813x;

    /* renamed from: y */
    private static LoginListeners.IPreLoginListener f44814y;

    /* renamed from: z */
    private static LoginListeners.ShowEmailSuffixListener f44815z;

    public static LoginListeners.ShowEmailSuffixListener getEmailSuffixListener() {
        return f44815z;
    }

    public static void setEmailSuffixListener(LoginListeners.ShowEmailSuffixListener showEmailSuffixListener) {
        f44815z = showEmailSuffixListener;
    }

    public static LoginListeners.WhatsAppListener getWhatsAppListener() {
        return f44809t;
    }

    public static void setParamsListener(LoginListeners.GetParamsListener getParamsListener) {
        f44810u = getParamsListener;
    }

    public static LoginListeners.GetParamsListener getParamsListener() {
        return f44810u;
    }

    public static void setWhatsAppListener(LoginListeners.WhatsAppListener whatsAppListener) {
        f44809t = whatsAppListener;
    }

    public static LoginListeners.LoadingViewListener getLoadingViewListener() {
        return f44807r;
    }

    public static void setLoadingViewListener(LoginListeners.LoadingViewListener loadingViewListener) {
        f44807r = loadingViewListener;
    }

    public static void addLoginListener(LoginListeners.LoginListener loginListener) {
        f44790a.add(loginListener);
    }

    public static void removeLoginListener(LoginListeners.LoginListener loginListener) {
        f44790a.remove(loginListener);
    }

    public static void addLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener) {
        f44791b.add(loginJumpListener);
    }

    public static void removeLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener) {
        f44791b.remove(loginJumpListener);
    }

    public static LoginListeners.InputCPFListener getCpfInputListener() {
        return f44802m;
    }

    public static void setCpfInputListener(LoginListeners.InputCPFListener inputCPFListener) {
        f44802m = inputCPFListener;
    }

    public static void addTokenListener(LoginListeners.TokenListener tokenListener) {
        f44793d.add(tokenListener);
    }

    public static void removeTokenListener(LoginListeners.TokenListener tokenListener) {
        f44793d.remove(tokenListener);
    }

    public static ConcurrentLinkedQueue<LoginListeners.LoginListener> getLoginListeners() {
        return f44790a;
    }

    public static ConcurrentLinkedQueue<LoginListeners.LoginJumpListener> getLoginJumpListeners() {
        return f44791b;
    }

    public static ConcurrentLinkedQueue<LoginListeners.TokenListener> getTokenListeners() {
        return f44793d;
    }

    public static LoginListeners.CancelAccFinishListener getCAFinishListener() {
        return f44795f;
    }

    public static void setCAFinishListener(LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        f44795f = cancelAccFinishListener;
    }

    public static LoginListeners.CustomStateFragment getCustomStateFragment() {
        return f44799j;
    }

    public static void setCustomStateFragmen(LoginListeners.CustomStateFragment customStateFragment) {
        f44799j = customStateFragment;
    }

    public static LoginListeners.LocationListener getLocationListener() {
        return f44796g;
    }

    public static LoginListeners.GlobalizationListener getGlobalizationListener() {
        return f44797h;
    }

    public static void setLocationListener(LoginListeners.LocationListener locationListener) {
        f44796g = locationListener;
    }

    public static void setGlobalizationListener(LoginListeners.GlobalizationListener globalizationListener) {
        f44797h = globalizationListener;
    }

    public static LoginListeners.LoginInterceptor getLoginInterceptor() {
        return f44794e;
    }

    public static void setLoginInterceptor(LoginListeners.LoginInterceptor loginInterceptor) {
        f44794e = loginInterceptor;
    }

    public static LoginListeners.WebViewListener getWebViewListener() {
        return f44798i;
    }

    public static void setWebViewListener(LoginListeners.WebViewListener webViewListener) {
        f44798i = webViewListener;
    }

    public static LoginListeners.ModifyPasswordListener getModifyPasswordListener() {
        return f44800k;
    }

    public static void setModifyPasswordListener(LoginListeners.ModifyPasswordListener modifyPasswordListener) {
        f44800k = modifyPasswordListener;
    }

    public static ConcurrentLinkedQueue<LoginListeners.LoginOutListener> getLoginOutListeners() {
        return f44792c;
    }

    public static void addLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        f44792c.add(loginOutListener);
    }

    public static void removeLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        f44792c.remove(loginOutListener);
    }

    public static LoginListeners.SetCellListener getSetCellListener() {
        return f44801l;
    }

    public static void setSetCellListener(LoginListeners.SetCellListener setCellListener) {
        f44801l = setCellListener;
    }

    public static void setActivityDelegate(LoginListeners.LoginBaseActivityDelegate loginBaseActivityDelegate) {
        f44805p = loginBaseActivityDelegate;
    }

    public static LoginListeners.LoginBaseActivityDelegate getActivityDelegate() {
        return f44805p;
    }

    public static void setModifyEmailListener(LoginListeners.ModifyEmailListener modifyEmailListener) {
        f44803n = modifyEmailListener;
    }

    public static LoginListeners.ModifyEmailListener getModifyEmailListener() {
        return f44803n;
    }

    public static LoginListeners.VerifyCodeListener getVerifyCodeListener() {
        return f44804o;
    }

    public static void setVerifyCodeListener(LoginListeners.VerifyCodeListener verifyCodeListener) {
        f44804o = verifyCodeListener;
    }

    public static void setGuidePermissionsDelegate(LoginListeners.GuidePermissionsDelegate guidePermissionsDelegate) {
        f44806q = guidePermissionsDelegate;
    }

    public static LoginListeners.GuidePermissionsDelegate getGuidePermissionsDelegate() {
        return f44806q;
    }

    public static void setFaceListener(LoginListeners.FaceListener faceListener) {
        f44808s = faceListener;
    }

    public static LoginListeners.FaceListener getFaceListener() {
        return f44808s;
    }

    public static void setFirstInstallListener(LoginListeners.FirstInstallListener firstInstallListener) {
        f44811v = firstInstallListener;
    }

    public static LoginListeners.FirstInstallListener getFirstInstallListener() {
        return f44811v;
    }

    public static LoginListeners.InfoAutoFillListener getInfoAutoFillListener() {
        return f44812w;
    }

    public static void setInfoAutoFillListener(LoginListeners.InfoAutoFillListener infoAutoFillListener) {
        f44812w = infoAutoFillListener;
    }

    public static void setShowSkipListener(LoginListeners.ShowSkipListener showSkipListener) {
        f44813x = showSkipListener;
    }

    public static LoginListeners.ShowSkipListener getShowSkipListener() {
        return f44813x;
    }

    public static LoginListeners.IPreLoginListener getPreLoginListener() {
        return f44814y;
    }

    public static void setPreLoginListener(LoginListeners.IPreLoginListener iPreLoginListener) {
        f44814y = iPreLoginListener;
    }
}
