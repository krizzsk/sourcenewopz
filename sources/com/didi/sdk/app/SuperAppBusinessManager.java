package com.didi.sdk.app;

import android.text.TextUtils;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000eJ\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/sdk/app/SuperAppBusinessManager;", "", "()V", "COMMON_H5_SCHEME", "", "getCOMMON_H5_SCHEME", "()Ljava/lang/String;", "setCOMMON_H5_SCHEME", "(Ljava/lang/String;)V", "KEY_SA_SELECT_TYPE", "SA_GROUP_ID", "", "SA_GROUP_TYPE", "activityResume", "", "commonBusinessContext", "Lcom/didi/sdk/app/BusinessContext;", "currentBusiness", "lastBusiness", "saRealShow", "getCommonBusinessContext", "getCurrentBusiness", "getLastBusiness", "isActivityResume", "isCurrentSa", "isSaRealShow", "setBusinessContext", "", "businessContext", "setCommonBusinessContext", "setCurrentBusiness", "businessType", "update", "updateActivityResume", "resume", "updateBusinessContext", "updateOther", "updateSaShow", "show", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuperAppBusinessManager.kt */
public final class SuperAppBusinessManager {
    public static final SuperAppBusinessManager INSTANCE = new SuperAppBusinessManager();
    public static final String KEY_SA_SELECT_TYPE = "sa_select_group_type";
    public static final int SA_GROUP_ID = 30008;
    public static final String SA_GROUP_TYPE = "sa_home";

    /* renamed from: a */
    private static BusinessContext f35216a;

    /* renamed from: b */
    private static String f35217b = Intrinsics.stringPlus(NationTypeUtil.getNationComponentData().getProductPreFix(), "OneTravel://one/sa_web");

    /* renamed from: c */
    private static String f35218c = "sa_home";

    /* renamed from: d */
    private static String f35219d = "sa_home";

    /* renamed from: e */
    private static boolean f35220e;

    /* renamed from: f */
    private static boolean f35221f;

    private SuperAppBusinessManager() {
    }

    public final String getCOMMON_H5_SCHEME() {
        return f35217b;
    }

    public final void setCOMMON_H5_SCHEME(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f35217b = str;
    }

    public final void setBusinessContext(BusinessContext businessContext) {
        BusinessContextManager.getInstance().mo90610a((BaseBusinessContext) businessContext);
    }

    public final BusinessContext getCommonBusinessContext() {
        return f35216a;
    }

    public final void setCommonBusinessContext(BusinessContext businessContext) {
        f35216a = businessContext;
    }

    public final void setCurrentBusiness(String str) {
        Intrinsics.checkNotNullParameter(str, ParamKeys.PARAM_FLIER_BUSINESSTYPE);
        f35219d = f35218c;
        f35218c = str;
        ConfProxy.getInstance().setSelectedType(str);
    }

    /* renamed from: a */
    private final void m24926a() {
        BusinessContext businessContext = f35216a;
        if (businessContext != null) {
            businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
        }
        BaseBusinessContext curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext();
        if (curBusinessContext instanceof BusinessContext) {
            ((BusinessContext) curBusinessContext).setCountryInfo(ConfProxy.getInstance().getCountryInfo());
        }
    }

    /* renamed from: b */
    private final void m24927b() {
        SafeToolKit.getIns().setProductId(ConfProxy.getInstance().getSelectedGroupId());
        SafeToolKit.getIns().setBusinessType(ConfProxy.getInstance().getSelectedType());
        if (Intrinsics.areEqual((Object) "bus", (Object) getCurrentBusiness())) {
            SafeToolKit.getIns().setBusinessType("ride");
        }
    }

    public final void update() {
        m24926a();
        m24927b();
    }

    public final void updateActivityResume(boolean z) {
        f35220e = z;
    }

    public final void updateSaShow(boolean z) {
        f35221f = z;
    }

    public final boolean isCurrentSa() {
        return TextUtils.equals("sa_home", f35218c) && SaApolloUtil.INSTANCE.getSaState();
    }

    public final boolean isSaRealShow() {
        return isCurrentSa() && f35221f;
    }

    public final boolean isActivityResume() {
        return f35220e;
    }

    public final String getCurrentBusiness() {
        return f35218c;
    }

    public final String getLastBusiness() {
        return f35219d;
    }
}
