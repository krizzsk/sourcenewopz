package com.didiglobal.p205sa.biz.tab.manager;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.business.SaTabIds;
import com.didi.sdk.monitor.SaQualityCheckTrack;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import com.didiglobal.p205sa.biz.tab.model.SaTabMenuModel;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\rH\u0002J&\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bJ\u001e\u0010\u0015\u001a\u00020\r2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaTabTrackManager;", "", "()V", "listener", "Lcom/didi/sdk/app/ActivityLifecycleManager$AppStateListener;", "tag", "", "getTab", "allModelList", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "Lkotlin/collections/ArrayList;", "onCreate", "", "onDestroy", "onHiddenChanged", "hidden", "", "register", "trackClick", "clickModel", "trackShow", "trackTabGetCountShow", "count", "", "trackTabRealCountShow", "unregister", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabTrackManager */
/* compiled from: SaTabTrackManager.kt */
public final class SaTabTrackManager {
    public static final SaTabTrackManager INSTANCE = new SaTabTrackManager();

    /* renamed from: a */
    private static String f51242a = "SaTabTrackManager";

    /* renamed from: b */
    private static ActivityLifecycleManager.AppStateListener f51243b = $$Lambda$SaTabTrackManager$HKL5QLmf21dP7fJ8NHzsJWbp8kM.INSTANCE;

    private SaTabTrackManager() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m36703b(int i) {
        if (i == 1) {
            SystemUtils.log(3, f51242a, "ActivityLifecycleManager.AppStateListener.ACTIVE", (Throwable) null, "com.didiglobal.sa.biz.tab.manager.SaTabTrackManager", 17);
            INSTANCE.trackShow(SaTabDataManager.getTabData$default(SaTabDataManager.INSTANCE, SaTabIds.TAB_HOME.getId(), (SaTabDataModel) null, 2, (Object) null));
        }
    }

    public final void onCreate() {
        m36700a();
    }

    public final void onDestroy() {
        m36702b();
    }

    /* renamed from: a */
    private final void m36700a() {
        ActivityLifecycleManager.getInstance().addAppStateListener(f51243b);
    }

    /* renamed from: b */
    private final void m36702b() {
        ActivityLifecycleManager.getInstance().removeAppStateListener(f51243b);
    }

    public final void onHiddenChanged(boolean z) {
        if (z) {
            m36702b();
        } else {
            m36700a();
        }
    }

    public final void trackShow(ArrayList<SaTabFragment.TabModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "allModelList");
        HashMap hashMap = new HashMap();
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, INSTANCE.m36699a(arrayList));
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_bottom_tab_sw", (Map<String, Object>) hashMap);
        m36701a(arrayList.size());
    }

    public final void trackClick(SaTabFragment.TabModel tabModel, ArrayList<SaTabFragment.TabModel> arrayList) {
        String tabId;
        Intrinsics.checkNotNullParameter(tabModel, "clickModel");
        Intrinsics.checkNotNullParameter(arrayList, "allModelList");
        HashMap hashMap = new HashMap();
        SaTabMenuModel tabMenu = tabModel.getTabMenu();
        String str = "";
        if (!(tabMenu == null || (tabId = tabMenu.getTabId()) == null)) {
            str = tabId;
        }
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_bottom_tab_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private final String m36699a(ArrayList<SaTabFragment.TabModel> arrayList) {
        SaTabMenuModel tabMenu;
        String tabId;
        StringBuilder sb = new StringBuilder();
        if (arrayList != null) {
            int i = 0;
            for (Object next : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SaTabFragment.TabModel tabModel = (SaTabFragment.TabModel) next;
                String str = "";
                if (!(tabModel == null || (tabMenu = tabModel.getTabMenu()) == null || (tabId = tabMenu.getTabId()) == null)) {
                    str = tabId;
                }
                sb.append(str);
                if (i != arrayList.size() - 1) {
                    sb.append("|");
                }
                i = i2;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "strBuilder.toString()");
        return sb2;
    }

    /* renamed from: a */
    private final void m36701a(int i) {
        if (i < 3) {
            SaQualityCheckTrack.trackError(SaQualityCheckTrack.TagType.sa_tab, 1, new HashMap());
        }
    }

    public final void trackTabGetCountShow(int i) {
        if (i < 3) {
            SaQualityCheckTrack.trackError(SaQualityCheckTrack.TagType.sa_tab, 2, new HashMap());
        }
    }
}
