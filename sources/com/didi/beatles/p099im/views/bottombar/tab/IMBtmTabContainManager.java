package com.didi.beatles.p099im.views.bottombar.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.views.bottombar.tab.IMBtmTabGroup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager */
public class IMBtmTabContainManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10104a = IMBtmTabContainManager.class.getSimpleName();

    /* renamed from: b */
    private static final int f10105b = 0;

    /* renamed from: c */
    private static final int f10106c = 1;

    /* renamed from: d */
    private static final int f10107d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Context f10108e;

    /* renamed from: f */
    private final IMTabActionFactory f10109f;

    /* renamed from: g */
    private final int f10110g;

    /* renamed from: h */
    private ViewStub f10111h;

    /* renamed from: i */
    private IMBtmTabGroup f10112i;

    /* renamed from: j */
    private IMBtmTabContainCallback f10113j;

    /* renamed from: k */
    private List<IMTabActionItem> f10114k = new ArrayList();

    /* renamed from: l */
    private int f10115l = 0;

    /* renamed from: m */
    private Map<String, String> f10116m = null;

    /* renamed from: n */
    private IMBtmTabGroup.OnTabCheckedChangeListener f10117n = new IMBtmTabGroup.OnTabCheckedChangeListener() {
        public void onTabCheckedChanged(int i, boolean z, boolean z2) {
            IMLog.m6631d(IMBtmTabContainManager.f10104a, C4234I.m6591t("[onTabCheckedChanged] pluginId=", Integer.valueOf(i), " |checked=", Boolean.valueOf(z), " |isClick=", Boolean.valueOf(z2)));
            if (z && z2) {
                IMPreference.getInstance(IMBtmTabContainManager.this.f10108e).setBottomTabSelectPluginId(IMCommonContextInfoHelper.getUid(), i);
            }
            IMTabActionItem a = IMBtmTabContainManager.this.m6899b(i);
            if (a == null) {
                IMLog.m6631d(IMBtmTabContainManager.f10104a, C4234I.m6591t("[onTabCheckedChanged] load NULL tab action item with pluginId=", Integer.valueOf(i)));
            } else if (z) {
                IMBtmTabContainManager.this.m6897a(a, z2);
            }
        }
    };

    /* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager$IMBtmTabContainCallback */
    public interface IMBtmTabContainCallback {
        void invokeEmojiAction(boolean z);

        void invokeFuncAction(boolean z);

        void invokeMsgAction(boolean z);

        void invokePluginAction(IMTabActionItem iMTabActionItem, boolean z);
    }

    public IMBtmTabContainManager(View view, int i) {
        this.f10108e = view.getContext();
        this.f10110g = i;
        this.f10109f = new IMTabActionFactory();
        this.f10111h = (ViewStub) view.findViewById(R.id.im_stub_bottom_tab_group);
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f10116m = map;
    }

    public void setCallback(IMBtmTabContainCallback iMBtmTabContainCallback) {
        this.f10113j = iMBtmTabContainCallback;
    }

    public void setCheck(int i) {
        if (this.f10112i != null) {
            int a = m6893a(i);
            IMLog.m6631d(f10104a, C4234I.m6591t("[setCheck] pluginId=", Integer.valueOf(i), " |newPluginId=", Integer.valueOf(a)));
            this.f10112i.setCheckId(a, false);
        }
    }

    /* renamed from: a */
    private int m6893a(int i) {
        List<IMTabActionItem> list = this.f10114k;
        if (list == null) {
            return -1;
        }
        boolean z = false;
        Iterator<IMTabActionItem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (i == it.next().pluginId) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            return i;
        }
        return -1;
    }

    public void reset() {
        IMLog.m6631d(f10104a, "[reset]");
        setCheck(-1);
    }

    public List<IMTabActionItem> getTabActionItemList() {
        return this.f10114k;
    }

    public int getCheckedPluginId() {
        IMBtmTabGroup iMBtmTabGroup = this.f10112i;
        if (iMBtmTabGroup != null) {
            return iMBtmTabGroup.getCheckedId();
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r3 = r2.f9129id;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void refreshTabList(java.util.List<com.didi.beatles.p099im.api.entity.IMSessionExtendInfo.BottomTabInfo> r9, final int r10) {
        /*
            r8 = this;
            java.lang.String r0 = f10104a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[refreshTabList] "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.didi.beatles.p099im.utils.IMLog.m6631d(r0, r1)
            java.util.List<com.didi.beatles.im.protocol.model.IMTabActionItem> r0 = r8.f10114k
            r0.clear()
            r0 = 0
            if (r9 == 0) goto L_0x00ad
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x0026
            goto L_0x00ad
        L_0x0026:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x002f:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x009a
            java.lang.Object r2 = r9.next()
            com.didi.beatles.im.api.entity.IMSessionExtendInfo$BottomTabInfo r2 = (com.didi.beatles.p099im.api.entity.IMSessionExtendInfo.BottomTabInfo) r2
            if (r2 == 0) goto L_0x0073
            boolean r3 = r2.ignore
            if (r3 == 0) goto L_0x0042
            goto L_0x0073
        L_0x0042:
            com.didi.beatles.im.views.bottombar.tab.IMTabActionFactory r3 = r8.f10109f
            if (r3 != 0) goto L_0x0047
            goto L_0x002f
        L_0x0047:
            int r3 = r2.f9129id
            com.didi.beatles.im.views.bottombar.tab.IMTabActionFactory r4 = r8.f10109f
            android.content.Context r5 = r8.f10108e
            com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager$2 r6 = new com.didi.beatles.im.views.bottombar.tab.IMBtmTabContainManager$2
            r6.<init>(r3, r10)
            java.lang.String r7 = r2.name
            com.didi.beatles.im.protocol.model.IMTabActionItem r3 = r4.loadTabActionItem(r5, r3, r6, r7)
            if (r3 != 0) goto L_0x005b
            goto L_0x002f
        L_0x005b:
            android.view.View r4 = r3.customTabView
            if (r4 != 0) goto L_0x0069
            com.didi.beatles.im.views.bottombar.tab.IMBtmTabContentView r4 = new com.didi.beatles.im.views.bottombar.tab.IMBtmTabContentView
            android.content.Context r5 = r8.f10108e
            r4.<init>(r5)
            r3.setDefaultTabView(r4)
        L_0x0069:
            boolean r2 = r2.isEnable()
            r3.enable = r2
            r1.add(r3)
            goto L_0x002f
        L_0x0073:
            java.lang.String r3 = f10104a
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[refreshTabList] tab ignore "
            r5.append(r6)
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = "empty"
            goto L_0x008d
        L_0x0087:
            int r2 = r2.f9129id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x008d:
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4[r0] = r2
            com.didi.beatles.p099im.utils.IMLog.m6635i(r3, r4)
            goto L_0x002f
        L_0x009a:
            r8.f10114k = r1
            int r9 = r8.f10115l
            r10 = 2
            if (r9 == r10) goto L_0x00a5
            r8.m6900b()
            goto L_0x00ac
        L_0x00a5:
            java.lang.String r9 = f10104a
            java.lang.String r10 = "[refreshTabList] ###STATUS_HIDDEN###"
            com.didi.beatles.p099im.utils.IMLog.m6631d(r9, r10)
        L_0x00ac:
            return
        L_0x00ad:
            r8.f10115l = r0
            com.didi.beatles.im.views.bottombar.tab.IMBtmTabGroup r9 = r8.f10112i
            com.didi.beatles.p099im.utils.IMViewUtil.hide((android.view.View) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.bottombar.tab.IMBtmTabContainManager.refreshTabList(java.util.List, int):void");
    }

    /* renamed from: b */
    private void m6900b() {
        List<IMTabActionItem> list = this.f10114k;
        if (list == null || list.isEmpty()) {
            this.f10115l = 0;
            IMViewUtil.hide((View) this.f10112i);
            IMLog.m6631d(f10104a, "[renderTabGroup] =NULL LIST=");
            return;
        }
        this.f10115l = 1;
        if (this.f10112i == null) {
            IMBtmTabGroup iMBtmTabGroup = (IMBtmTabGroup) this.f10111h.inflate();
            this.f10112i = iMBtmTabGroup;
            iMBtmTabGroup.setOnTabCheckedChangeListener(this.f10117n);
            this.f10112i.setExtraTraceMap(this.f10116m);
        }
        IMViewUtil.show((View) this.f10112i);
        this.f10112i.bindData(this.f10114k);
    }

    public void hideTab() {
        IMLog.m6631d(f10104a, C4234I.m6591t("[hideTab] mTabStatus=", Integer.valueOf(this.f10115l)));
        if (this.f10115l == 1) {
            this.f10115l = 2;
            IMViewUtil.hide((View) this.f10112i);
        }
    }

    public void showTab() {
        IMLog.m6631d(f10104a, C4234I.m6591t("[showTab] mTabStatus=", Integer.valueOf(this.f10115l)));
        if (this.f10115l == 2) {
            m6900b();
        }
    }

    public void clear() {
        IMViewUtil.hide((View) this.f10112i);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public IMTabActionItem m6899b(int i) {
        List<IMTabActionItem> list = this.f10114k;
        if (list == null) {
            return null;
        }
        for (IMTabActionItem next : list) {
            if (next.pluginId == i) {
                return next;
            }
        }
        IMLog.m6632e(f10104a, C4234I.m6591t("[findTabAction] Null with pluginId:", Integer.valueOf(i)));
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6897a(IMTabActionItem iMTabActionItem, boolean z) {
        if (iMTabActionItem.pluginId == 4) {
            IMBtmTabContainCallback iMBtmTabContainCallback = this.f10113j;
            if (iMBtmTabContainCallback != null) {
                iMBtmTabContainCallback.invokeMsgAction(z);
            }
        } else if (iMTabActionItem.pluginId == 6) {
            IMBtmTabContainCallback iMBtmTabContainCallback2 = this.f10113j;
            if (iMBtmTabContainCallback2 != null) {
                iMBtmTabContainCallback2.invokeEmojiAction(z);
            }
        } else if (iMTabActionItem.pluginId == 5) {
            IMBtmTabContainCallback iMBtmTabContainCallback3 = this.f10113j;
            if (iMBtmTabContainCallback3 != null) {
                iMBtmTabContainCallback3.invokeFuncAction(z);
            }
        } else {
            IMBtmTabContainCallback iMBtmTabContainCallback4 = this.f10113j;
            if (iMBtmTabContainCallback4 != null) {
                iMBtmTabContainCallback4.invokePluginAction(iMTabActionItem, z);
            }
        }
    }

    public void release() {
        this.f10113j = null;
        this.f10117n = null;
        IMTabActionFactory iMTabActionFactory = this.f10109f;
        if (iMTabActionFactory != null) {
            iMTabActionFactory.release();
        }
    }
}
