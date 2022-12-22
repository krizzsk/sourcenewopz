package com.didiglobal.p205sa.biz.tab.manager;

import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.business.SaTabIds;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.util.GSonUtil;
import com.didi.sdk.util.SPUtils;
import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import com.didiglobal.p205sa.biz.tab.model.SaTabMenuModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0002\u0007\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J(\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u000bJ(\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0002J\u001c\u0010\u001a\u001a\u00020\f2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ\u001e\u0010\u001b\u001a\u00020\f2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0002J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\fJ\u001e\u0010 \u001a\u00020\f2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0006\u0010#\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006$"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaTabDataManager;", "", "()V", "abilityId", "", "key", "listener", "com/didiglobal/sa/biz/tab/manager/SaTabDataManager$listener$1", "Lcom/didiglobal/sa/biz/tab/manager/SaTabDataManager$listener$1;", "notification", "Lkotlin/Function1;", "Lcom/didiglobal/sa/biz/tab/model/SaTabDataModel;", "", "oneConfConfigListeners", "com/didiglobal/sa/biz/tab/manager/SaTabDataManager$oneConfConfigListeners$1", "Lcom/didiglobal/sa/biz/tab/manager/SaTabDataManager$oneConfConfigListeners$1;", "getCacheData", "getTabData", "Ljava/util/ArrayList;", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "Lkotlin/collections/ArrayList;", "defaultTabId", "saTabDataModel", "handResponse", "response", "Lcom/google/gson/JsonObject;", "init", "initNotification", "onHiddenChanged", "isHidden", "", "registerListener", "request", "transModel", "str", "unregisterListener", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabDataManager */
/* compiled from: SaTabDataManager.kt */
public final class SaTabDataManager {
    public static final SaTabDataManager INSTANCE = new SaTabDataManager();

    /* renamed from: a */
    private static String f51227a = "expo/tab_menu";

    /* renamed from: b */
    private static String f51228b = "key_tab_menu";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Function1<? super SaTabDataModel, Unit> f51229c;

    /* renamed from: d */
    private static final SaTabDataManager$listener$1 f51230d = new SaTabDataManager$listener$1();

    /* renamed from: e */
    private static final SaTabDataManager$oneConfConfigListeners$1 f51231e = new SaTabDataManager$oneConfConfigListeners$1();

    private SaTabDataManager() {
    }

    /* renamed from: a */
    private final void m36696a(Function1<? super SaTabDataModel, Unit> function1) {
        f51229c = function1;
    }

    public final void init(Function1<? super SaTabDataModel, Unit> function1) {
        m36696a(function1);
        m36697b(function1);
    }

    public final void onHiddenChanged(boolean z) {
        if (z) {
            unregisterListener();
        } else {
            registerListener();
        }
    }

    public final void registerListener() {
        OneConfStore.getInstance().addOneConfChangeListener(f51231e);
    }

    public final void unregisterListener() {
        OneConfStore.getInstance().removeOneConfChangeListener(f51231e);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36697b(Function1<? super SaTabDataModel, Unit> function1) {
        SystemUtils.log(3, String.valueOf(getClass().getName()), "开始请求", (Throwable) null, "com.didiglobal.sa.biz.tab.manager.SaTabDataManager", 80);
        Map hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("curVersion", INSTANCE.m36693a().getCurVersion());
        hashMap.put("tab_menu", hashMap2);
        Bff.call(new IBffProxy.Ability.Builder(DIDIApplication.getAppContext(), f51227a).setParams(hashMap).setBffCallBack(new SaTabDataManager$request$ability$1(function1)).build());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r2 = r2.getAsJsonObject();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m36695a(com.google.gson.JsonObject r6, kotlin.jvm.functions.Function1<? super com.didiglobal.p205sa.biz.tab.model.SaTabDataModel, kotlin.Unit> r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0092
            java.lang.String r1 = "data"
            com.google.gson.JsonElement r2 = r6.get(r1)
            java.lang.String r3 = "tab_menu"
            r4 = 0
            if (r2 != 0) goto L_0x0010
        L_0x000e:
            r2 = r4
            goto L_0x001b
        L_0x0010:
            com.google.gson.JsonObject r2 = r2.getAsJsonObject()
            if (r2 != 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            com.google.gson.JsonElement r2 = r2.get(r3)
        L_0x001b:
            if (r2 != 0) goto L_0x001f
            goto L_0x0092
        L_0x001f:
            com.google.gson.JsonElement r6 = r6.get(r1)
            if (r6 != 0) goto L_0x0026
            goto L_0x0031
        L_0x0026:
            com.google.gson.JsonObject r6 = r6.getAsJsonObject()
            if (r6 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            com.google.gson.JsonElement r4 = r6.get(r3)
        L_0x0031:
            java.lang.String r6 = java.lang.String.valueOf(r4)
            com.didiglobal.sa.biz.tab.model.SaTabDataModel r1 = r5.m36694a((java.lang.String) r6)
            java.lang.String r2 = r1.getCurVersion()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0059
            com.didiglobal.sa.biz.tab.manager.SaTabTrackManager r6 = com.didiglobal.p205sa.biz.tab.manager.SaTabTrackManager.INSTANCE
            if (r1 != 0) goto L_0x004a
            goto L_0x0055
        L_0x004a:
            java.util.ArrayList r7 = r1.getTabMenu()
            if (r7 != 0) goto L_0x0051
            goto L_0x0055
        L_0x0051:
            int r0 = r7.size()
        L_0x0055:
            r6.trackTabGetCountShow(r0)
            return
        L_0x0059:
            com.didiglobal.sa.biz.tab.model.SaTabDataModel r2 = r5.m36693a()
            java.lang.String r3 = r1.getCurVersion()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r2 = r2.getCurVersion()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.equals(r3, r2)
            if (r2 == 0) goto L_0x0070
            return
        L_0x0070:
            com.didiglobal.sa.biz.tab.manager.SaTabTrackManager r2 = com.didiglobal.p205sa.biz.tab.manager.SaTabTrackManager.INSTANCE
            java.util.ArrayList r3 = r1.getTabMenu()
            if (r3 != 0) goto L_0x0079
            goto L_0x007d
        L_0x0079:
            int r0 = r3.size()
        L_0x007d:
            r2.trackTabGetCountShow(r0)
            android.app.Application r0 = com.didi.sdk.app.DIDIApplication.getAppContext()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r2 = f51228b
            com.didi.sdk.util.SPUtils.put(r0, r2, r6)
            if (r7 != 0) goto L_0x008e
            goto L_0x0091
        L_0x008e:
            r7.invoke(r1)
        L_0x0091:
            return
        L_0x0092:
            com.didiglobal.sa.biz.tab.manager.SaTabTrackManager r6 = com.didiglobal.p205sa.biz.tab.manager.SaTabTrackManager.INSTANCE
            r6.trackTabGetCountShow(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.tab.manager.SaTabDataManager.m36695a(com.google.gson.JsonObject, kotlin.jvm.functions.Function1):void");
    }

    /* renamed from: a */
    private final SaTabDataModel m36693a() {
        String str = "{\n    \"curVersion\":\"0\",\n    \"tabMenu\":[\n        {\n            \"arrowStyle\":{\n                \"icon\":\"https://s3-us01.didiglobal.com/silver-bullet-img/2022-09-13/bKOxAusSTvzgacDjbPHOe-___global_3x.png\",\n                \"text\":{\n                    \"info\":[\n                        {\n                            \"bold\":1,\n                            \"color\":\"#FF7A45\",\n                            \"font_size\":20,\n                            \"italic\":0,\n                            \"length\":3,\n                            \"link\":\"\",\n                            \"script\":0,\n                            \"start\":0,\n                            \"through\":0\n                        }\n                    ],\n                    \"text\":\"Top\"\n                }\n            },\n            \"icon\":\"https://s3-us01.didiglobal.com/silver-bullet-img/2022-09-13/G53sUZP7XboQlF0t9TooS-______3x.png\",\n            \"iconActive\":\"https://s3-us01.didiglobal.com/silver-bullet-img/2022-09-13/8d-WQL2cfTy75wvywKExY-__global_3x.png\",\n            \"tabId\":\"tab_home\",\n            \"tabName\":{\n                \"info\":[\n                    {\n                        \"bold\":0,\n                        \"color\":\"#323232\",\n                        \"font_size\":20,\n                        \"italic\":0,\n                        \"length\":4,\n                        \"link\":\"\",\n                        \"script\":0,\n                        \"start\":0,\n                        \"through\":0\n                    }\n                ],\n                \"text\":\"Home\"\n            },\n            \"tabNameActive\":{\n                \"info\":[\n                    {\n                        \"bold\":1,\n                        \"color\":\"#FF7A45\",\n                        \"font_size\":20,\n                        \"italic\":0,\n                        \"length\":4,\n                        \"link\":\"\",\n                        \"script\":0,\n                        \"start\":0,\n                        \"through\":0\n                    }\n                ],\n                \"text\":\"Home\"\n            }\n        },\n        {\n            \"arrowStyle\":{\n                \"icon\":\"\",\n                \"text\":{\n                    \"info\":[\n                        {\n                            \"bold\":0,\n                            \"color\":\"#FF7A45\",\n                            \"font_size\":20,\n                            \"italic\":0,\n                            \"length\":0,\n                            \"link\":\"\",\n                            \"script\":0,\n                            \"start\":0,\n                            \"through\":0\n                        }\n                    ],\n                    \"text\":\"\"\n                }\n            },\n            \"icon\":\"https://s3-us01.didiglobal.com/silver-bullet-img/2022-09-13/ZGjw_W00bf8t_Kciaw_G5-_______3x.png\",\n            \"iconActive\":\"https://s3-us01.didiglobal.com/silver-bullet-img/2022-09-13/mZcoDP-Zm4yfAsh4DkgoT-___global_3x.png\",\n            \"tabId\":\"tab_activity\",\n            \"tabName\":{\n                \"info\":[\n                    {\n                        \"bold\":0,\n                        \"color\":\"#323232\",\n                        \"font_size\":20,\n                        \"italic\":0,\n                        \"length\":8,\n                        \"link\":\"\",\n                        \"script\":0,\n                        \"start\":0,\n                        \"through\":0\n                    }\n                ],\n                \"text\":\"Activity\"\n            },\n            \"tabNameActive\":{\n                \"info\":[\n                    {\n                        \"bold\":1,\n                        \"color\":\"#FF7A45\",\n                        \"font_size\":20,\n                        \"italic\":0,\n                        \"length\":8,\n                        \"link\":\"\",\n                        \"script\":0,\n                        \"start\":0,\n                        \"through\":0\n                    }\n                ],\n                \"text\":\"Activity\"\n            }\n        },\n        {\n            \"arrowStyle\":{\n                \"icon\":\"\",\n                \"text\":{\n                    \"info\":[\n                        {\n                            \"bold\":0,\n                            \"color\":\"#FF7A45\",\n                            \"font_size\":20,\n                            \"italic\":0,\n                            \"length\":0,\n                            \"link\":\"\",\n                            \"script\":0,\n                            \"start\":0,\n                            \"through\":0\n                        }\n                    ],\n                    \"text\":\"\"\n                }\n            },\n            \"icon\":\"https://s3-us01.didiglobal.com/silver-bullet-img/2022-09-13/wFrQV96O-IsMGaFdgFllW-________3x.png\",\n            \"iconActive\":\"https://s3-us01.didiglobal.com/silver-bullet-img/2022-09-13/Gy-UBhfT5jtHhiOnpATfR-____global_3x.png\",\n            \"tabId\":\"tab_user\",\n            \"tabName\":{\n                \"info\":[\n                    {\n                        \"bold\":0,\n                        \"color\":\"#323232\",\n                        \"font_size\":20,\n                        \"italic\":0,\n                        \"length\":7,\n                        \"link\":\"\",\n                        \"script\":0,\n                        \"start\":0,\n                        \"through\":0\n                    }\n                ],\n                \"text\":\"Account\"\n            },\n            \"tabNameActive\":{\n                \"info\":[\n                    {\n                        \"bold\":1,\n                        \"color\":\"#FF7A45\",\n                        \"font_size\":20,\n                        \"italic\":0,\n                        \"length\":7,\n                        \"link\":\"\",\n                        \"script\":0,\n                        \"start\":0,\n                        \"through\":0\n                    }\n                ],\n                \"text\":\"Account\"\n            }\n        }\n    ]\n}";
        String str2 = (String) SPUtils.get(DIDIApplication.getAppContext(), f51228b, str);
        if (!TextUtils.isEmpty(str2)) {
            Intrinsics.checkNotNull(str2);
            str = str2;
        }
        return m36694a(str);
    }

    /* renamed from: a */
    private final SaTabDataModel m36694a(String str) {
        Boolean bool;
        Object obj;
        try {
            SaTabDataModel saTabDataModel = (SaTabDataModel) GSonUtil.objectFromJson(str, SaTabDataModel.class);
            if (SaTabUserCenterDemoteManager.INSTANCE.hideUserCenter()) {
                ArrayList<SaTabMenuModel> tabMenu = saTabDataModel.getTabMenu();
                if (tabMenu != null) {
                    Iterator it = tabMenu.iterator();
                    while (true) {
                        bool = null;
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual((Object) ((SaTabMenuModel) obj).getTabId(), (Object) SaTabIds.TAB_USER.getId())) {
                            break;
                        }
                    }
                    SaTabMenuModel saTabMenuModel = (SaTabMenuModel) obj;
                    if (saTabMenuModel != null) {
                        if (tabMenu != null) {
                            bool = Boolean.valueOf(tabMenu.remove(saTabMenuModel));
                        }
                        bool.booleanValue();
                    }
                }
            }
            Intrinsics.checkNotNullExpressionValue(saTabDataModel, "{\n            val model …          model\n        }");
            return saTabDataModel;
        } catch (Exception unused) {
            return new SaTabDataModel();
        }
    }

    public static /* synthetic */ ArrayList getTabData$default(SaTabDataManager saTabDataManager, String str, SaTabDataModel saTabDataModel, int i, Object obj) {
        if ((i & 2) != 0) {
            saTabDataModel = saTabDataManager.m36693a();
        }
        return saTabDataManager.getTabData(str, saTabDataModel);
    }

    public final ArrayList<SaTabFragment.TabModel> getTabData(String str, SaTabDataModel saTabDataModel) {
        Intrinsics.checkNotNullParameter(str, "defaultTabId");
        Intrinsics.checkNotNullParameter(saTabDataModel, "saTabDataModel");
        ArrayList<SaTabFragment.TabModel> arrayList = new ArrayList<>();
        ArrayList<SaTabMenuModel> tabMenu = saTabDataModel.getTabMenu();
        if (tabMenu != null) {
            int i = 0;
            for (Object next : tabMenu) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SaTabMenuModel saTabMenuModel = (SaTabMenuModel) next;
                SaTabFragment.TabModel tabModel = new SaTabFragment.TabModel();
                tabModel.setTabMenu(saTabMenuModel);
                tabModel.setArrowStyle(saTabMenuModel.getArrowStyle());
                if (Intrinsics.areEqual((Object) str, (Object) saTabMenuModel.getTabId())) {
                    tabModel.setClicked(true);
                }
                Unit unit = Unit.INSTANCE;
                arrayList.add(tabModel);
                i = i2;
            }
        }
        return arrayList;
    }
}
