package com.didi.sdk.p146ad;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.idfa.IDFAManager;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SPUtils;
import com.didichuxing.omega.sdk.Omega;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000bJ>\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042&\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010 j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`!J<\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042$\b\u0002\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010 j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/sdk/ad/AdUtil;", "", "()V", "KEY_FIRST_OPEN", "", "ddlType", "getDdlType", "()Ljava/lang/String;", "setDdlType", "(Ljava/lang/String;)V", "fromDdl", "", "getFromDdl", "()Z", "setFromDdl", "(Z)V", "mapReady", "getTopVisibleFragment", "Landroidx/fragment/app/Fragment;", "hadTopBarBanner", "", "isFirstOpen", "context", "Landroid/content/Context;", "isInRideEntrance", "setFirstOpen", "", "setMapReady", "ready", "track", "eventName", "extraMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "trackCurrentActivity", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.AdUtil */
/* compiled from: AdUtil.kt */
public final class AdUtil {
    public static final AdUtil INSTANCE = new AdUtil();

    /* renamed from: a */
    private static boolean f34917a = false;

    /* renamed from: b */
    private static String f34918b = "";

    /* renamed from: c */
    private static boolean f34919c = false;

    /* renamed from: d */
    private static final String f34920d = "key_first_open";

    private AdUtil() {
    }

    public final boolean getFromDdl() {
        return f34917a;
    }

    public final void setFromDdl(boolean z) {
        f34917a = z;
    }

    public final String getDdlType() {
        return f34918b;
    }

    public final void setDdlType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f34918b = str;
    }

    public final boolean isFirstOpen(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object obj = SPUtils.get(context, f34920d, true);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final void setFirstOpen(boolean z, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SPUtils.put(context, f34920d, Boolean.valueOf(z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        r0 = r0.selectedGroup;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isInRideEntrance() {
        /*
            r7 = this;
            com.didi.sdk.misconfig.v2.ConfProxy r0 = com.didi.sdk.misconfig.p153v2.ConfProxy.getInstance()
            com.didi.sdk.home.model.TopBarData r0 = r0.getTopBarData()
            r1 = 0
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r0 = r1
            goto L_0x0016
        L_0x000d:
            com.didi.sdk.misconfig.model.CarGrop r0 = r0.selectedGroup
            if (r0 != 0) goto L_0x0012
            goto L_0x000b
        L_0x0012:
            java.lang.String r0 = r0.getGroupType()
        L_0x0016:
            java.lang.String r2 = "ride"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x0031
            com.didi.sdk.misconfig.v2.ConfProxy r0 = com.didi.sdk.misconfig.p153v2.ConfProxy.getInstance()
            java.lang.String r0 = r0.getSelectedType()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r0 = 0
            goto L_0x0032
        L_0x0031:
            r0 = 1
        L_0x0032:
            androidx.fragment.app.Fragment r2 = r7.m24673a()
            if (r2 != 0) goto L_0x003a
        L_0x0038:
            r1 = 0
            goto L_0x0056
        L_0x003a:
            java.lang.Class r2 = r2.getClass()
            if (r2 != 0) goto L_0x0041
            goto L_0x0038
        L_0x0041:
            java.lang.String r2 = r2.getName()
            if (r2 != 0) goto L_0x0048
            goto L_0x0038
        L_0x0048:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r5 = "HomeTemplateFragment"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 2
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r4, (int) r6, (java.lang.Object) r1)
            if (r1 != r3) goto L_0x0038
            r1 = 1
        L_0x0056:
            if (r0 == 0) goto L_0x005b
            if (r1 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r3 = 0
        L_0x005c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.p146ad.AdUtil.isInRideEntrance():boolean");
    }

    /* renamed from: a */
    private final Fragment m24673a() {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (!(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) currentActivity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "currentActivity.supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragmentManager.fragments");
        int size = fragments.size() - 1;
        if (size < 0) {
            return null;
        }
        while (true) {
            int i = size - 1;
            Fragment fragment = fragments.get(size);
            if (fragment.isVisible() && fragment.getUserVisibleHint()) {
                return fragment;
            }
            if (i < 0) {
                return null;
            }
            size = i;
        }
    }

    public final void track(String str, String str2, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "ddlType");
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        Map map = hashMap2;
        map.put("ddl_type", str2);
        String idfa = IDFAManager.getIdfa(ActivityLifecycleManager.getInstance().getCurrentActivity());
        Intrinsics.checkNotNullExpressionValue(idfa, "getIdfa(ActivityLifecycl…stance().currentActivity)");
        map.put("idfa", idfa);
        String omegaId = Omega.getOmegaId();
        Intrinsics.checkNotNullExpressionValue(omegaId, "getOmegaId()");
        map.put("oid", omegaId);
        map.put("timestamp", Long.valueOf(System.currentTimeMillis() / ((long) 1000)));
        String uid = NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getNationComponentData().loginInfo.uid");
        map.put("uid", uid);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) map);
    }

    public final int hadTopBarBanner() {
        return ConfProxy.getInstance().getTopBarData() != null ? 1 : 0;
    }

    public static /* synthetic */ void trackCurrentActivity$default(AdUtil adUtil, String str, String str2, HashMap hashMap, int i, Object obj) {
        if ((i & 4) != 0) {
            hashMap = new HashMap();
        }
        adUtil.trackCurrentActivity(str, str2, hashMap);
    }

    public final void trackCurrentActivity(String str, String str2, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "ddlType");
        Intrinsics.checkNotNullParameter(hashMap, "extraMap");
        try {
            Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
            String str3 = "";
            if (currentActivity instanceof MainActivity) {
                Fragment a = m24673a();
                if (a != null) {
                    Class<?> cls = a.getClass();
                    if (cls != null) {
                        String name = cls.getName();
                        if (name != null) {
                            str3 = name;
                        }
                    }
                }
            } else {
                str3 = currentActivity.getClass().getName();
            }
            HashMap hashMap2 = new HashMap();
            Intrinsics.checkNotNullExpressionValue(str3, "name");
            hashMap2.put("name", str3);
            hashMap2.put("ddl_type", str2);
            hashMap2.put("map_ready", Integer.valueOf(f34919c ? 1 : 0));
            hashMap2.putAll(hashMap);
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap2);
        } catch (Exception unused) {
        }
    }

    public final void setMapReady(boolean z) {
        f34919c = z;
    }
}
