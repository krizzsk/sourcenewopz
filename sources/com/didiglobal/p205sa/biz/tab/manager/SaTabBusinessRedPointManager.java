package com.didiglobal.p205sa.biz.tab.manager;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.app.business.ISaTabObserver;
import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.tab.model.SaTabMenuModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\tH\u0002J6\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0006J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010\u001f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0005J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\tH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaTabBusinessRedPointManager;", "", "()V", "saTabObserverList", "Ljava/util/ArrayList;", "Lcom/didi/sdk/app/business/ISaTabObserver;", "Lkotlin/collections/ArrayList;", "saTabPointInfoMap", "Ljava/util/HashMap;", "", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel$TabPointInfo;", "Lkotlin/collections/HashMap;", "addObserver", "", "observer", "getSaTabPointInfo", "groupId", "getTabInfo", "getTargetView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tabList", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "notifyTabDown", "notifyTabRedPoint", "show", "", "notifyTabTip", "tip", "notifyTabUp", "removeObserver", "setTabInfo", "info", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabBusinessRedPointManager */
/* compiled from: SaTabBusinessRedPointManager.kt */
public final class SaTabBusinessRedPointManager {
    public static final SaTabBusinessRedPointManager INSTANCE = new SaTabBusinessRedPointManager();

    /* renamed from: a */
    private static ArrayList<ISaTabObserver> f51225a = new ArrayList<>();

    /* renamed from: b */
    private static HashMap<String, SaTabFragment.TabModel.TabPointInfo> f51226b = new HashMap<>();

    private SaTabBusinessRedPointManager() {
    }

    public final View getTargetView(String str, RecyclerView recyclerView, ArrayList<SaTabFragment.TabModel> arrayList) {
        SaTabFragment.TabModel tabModel;
        int i;
        RecyclerView.LayoutManager layoutManager;
        View findViewByPosition;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "groupId");
        if (arrayList == null) {
            tabModel = null;
        } else {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                SaTabMenuModel tabMenu = ((SaTabFragment.TabModel) obj).getTabMenu();
                if (TextUtils.equals(tabMenu == null ? null : tabMenu.getTabId(), str)) {
                    break;
                }
            }
            tabModel = (SaTabFragment.TabModel) obj;
        }
        if (arrayList == null) {
            i = -1;
        } else {
            i = CollectionsKt.indexOf(arrayList, tabModel);
        }
        if (i == -1 || recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findViewByPosition = layoutManager.findViewByPosition(i)) == null) {
            return null;
        }
        return findViewByPosition;
    }

    public final void addObserver(ISaTabObserver iSaTabObserver) {
        Intrinsics.checkNotNullParameter(iSaTabObserver, "observer");
        f51225a.add(iSaTabObserver);
    }

    public final void removeObserver(ISaTabObserver iSaTabObserver) {
        Intrinsics.checkNotNullParameter(iSaTabObserver, "observer");
        f51225a.remove(iSaTabObserver);
    }

    /* renamed from: a */
    private final SaTabFragment.TabModel.TabPointInfo m36691a(String str) {
        SaTabFragment.TabModel.TabPointInfo tabPointInfo = f51226b.get(str);
        return tabPointInfo == null ? new SaTabFragment.TabModel.TabPointInfo() : tabPointInfo;
    }

    /* renamed from: a */
    private final void m36692a(SaTabFragment.TabModel.TabPointInfo tabPointInfo, String str) {
        f51226b.put(str, tabPointInfo);
    }

    public final SaTabFragment.TabModel.TabPointInfo getSaTabPointInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        return f51226b.get(str);
    }

    public final void notifyTabRedPoint(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        SaTabFragment.TabModel.TabPointInfo a = m36691a(str);
        a.setHasPoint(z);
        INSTANCE.m36692a(a, str);
        ArrayList<ISaTabObserver> arrayList = f51225a;
        if (arrayList != null) {
            for (ISaTabObserver iSaTabObserver : arrayList) {
                if (iSaTabObserver != null) {
                    iSaTabObserver.notifyTabRedPoint(str, z);
                }
            }
        }
    }

    public final void notifyTabTip(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        Intrinsics.checkNotNullParameter(str2, "tip");
        SaTabFragment.TabModel.TabPointInfo a = m36691a(str);
        a.setTipPoint(str2);
        INSTANCE.m36692a(a, str);
        ArrayList<ISaTabObserver> arrayList = f51225a;
        if (arrayList != null) {
            for (ISaTabObserver iSaTabObserver : arrayList) {
                if (iSaTabObserver != null) {
                    iSaTabObserver.notifyTabTip(str, str2);
                }
            }
        }
    }

    public final void notifyTabUp(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        SaTabFragment.TabModel.TabPointInfo a = m36691a(str);
        a.setUp(true);
        INSTANCE.m36692a(a, str);
        ArrayList<ISaTabObserver> arrayList = f51225a;
        if (arrayList != null) {
            for (ISaTabObserver iSaTabObserver : arrayList) {
                if (iSaTabObserver != null) {
                    iSaTabObserver.notifyTabUp(str);
                }
            }
        }
    }

    public final void notifyTabDown(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        SaTabFragment.TabModel.TabPointInfo a = m36691a(str);
        a.setUp(false);
        INSTANCE.m36692a(a, str);
        ArrayList<ISaTabObserver> arrayList = f51225a;
        if (arrayList != null) {
            for (ISaTabObserver iSaTabObserver : arrayList) {
                if (iSaTabObserver != null) {
                    iSaTabObserver.notifyTabDown(str);
                }
            }
        }
    }
}
