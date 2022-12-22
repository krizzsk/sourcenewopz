package com.didi.sdk.p146ad.operation;

import com.didi.drouter.api.DRouter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.p146ad.AdManager;
import com.didi.sdk.p146ad.AdUtil;
import com.didi.sdk.p146ad.event.AdEvent;
import com.didi.sdk.p146ad.model.AdConfigItem;
import com.didi.sdk.p146ad.model.AdParams;
import com.didi.sdk.p146ad.model.AdResponseKey;
import com.didi.sdk.util.GSonUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.api.OneLoginFacade;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J$\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/sdk/ad/operation/HomeAdOperation;", "Lcom/didi/sdk/ad/operation/BaseAdOperation;", "()V", "doJumpAction", "", "url", "", "handResponse", "value", "Lcom/google/gson/JsonObject;", "appEventType", "notify", "adConfigItem", "Lcom/didi/sdk/ad/model/AdConfigItem;", "adResponseKey", "doPublish", "", "parseAdConfigItem", "data", "Lcom/google/gson/JsonElement;", "Companion", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.operation.HomeAdOperation */
/* compiled from: HomeAdOperation.kt */
public final class HomeAdOperation extends BaseAdOperation {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "HomeAdOperation";

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/sdk/ad/operation/HomeAdOperation$Companion;", "", "()V", "TAG", "", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.sdk.ad.operation.HomeAdOperation$Companion */
    /* compiled from: HomeAdOperation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m24679a(String str) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("had_top_banner", Integer.valueOf(AdUtil.INSTANCE.hadTopBarBanner()));
        map.put("is_in_index", Integer.valueOf(AdUtil.INSTANCE.isInRideEntrance() ? 1 : 0));
        AdUtil.INSTANCE.track("tech_ddl_execute_start", AdUtil.INSTANCE.getDdlType(), hashMap);
        UiThreadHandler.postDelayed(new Runnable(str) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                HomeAdOperation.m24680b(this.f$0);
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m24680b(String str) {
        Intrinsics.checkNotNullParameter(str, "$url");
        DRouter.build(str).start();
        AdUtil.INSTANCE.track("tech_ddl_execute_result", AdUtil.INSTANCE.getDdlType(), (HashMap<String, Object>) null);
    }

    public void handResponse(JsonObject jsonObject, String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(jsonObject, "value");
        Intrinsics.checkNotNullParameter(str, AdParams.APP_EVENT_TYPE);
        AdUtil.INSTANCE.track("tech_ddl_jump_link_accepted", str, (HashMap<String, Object>) null);
        AdUtil.trackCurrentActivity$default(AdUtil.INSTANCE, "tech_ddl_jump_link_accepted_current_page", str, (HashMap) null, 4, (Object) null);
        AdConfigItem a = m24676a((JsonElement) jsonObject);
        if (a != null) {
            a.setDdlType(str);
        }
        boolean z2 = false;
        if (a != null && a.needSkipIndexPage()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (Intrinsics.areEqual((Object) str, (Object) "first_open") ? true : Intrinsics.areEqual((Object) str, (Object) "session_start")) {
                if (!AdUtil.INSTANCE.isInRideEntrance()) {
                    if (ActivityLifecycleManager.getInstance().getCurrentActivity() instanceof MainActivity) {
                        HashMap hashMap = new HashMap();
                        Map map = hashMap;
                        map.put("had_top_banner", Integer.valueOf(AdUtil.INSTANCE.hadTopBarBanner()));
                        map.put("is_in_index", 0);
                        AdUtil.INSTANCE.track("tech_ddl_execute_start", str, hashMap);
                    }
                    z2 = true;
                }
                AdUtil adUtil = AdUtil.INSTANCE;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("publish", Integer.valueOf(z2 ? 1 : 0));
                Unit unit = Unit.INSTANCE;
                adUtil.trackCurrentActivity("tech_ddl_jump_link_accepted_publish", str, hashMap2);
                m24677a(a, AdResponseKey.NORMAL_AFTER_PASSPORT, z2);
            }
        } else if (!a.isInvalidUrl()) {
            NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
            if (loginInfo != null && loginInfo.isLoginNow()) {
                z2 = true;
            }
            if (z2) {
                m24679a(a.getLandingPageLink());
            } else {
                OneLoginFacade.getFunction().addLoginListener(new HomeAdOperation$handResponse$1(this, a));
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24678a(HomeAdOperation homeAdOperation, AdConfigItem adConfigItem, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        homeAdOperation.m24677a(adConfigItem, str, z);
    }

    /* renamed from: a */
    private final void m24677a(AdConfigItem adConfigItem, String str, boolean z) {
        if (adConfigItem != null) {
            if (z) {
                EventBus eventBus = EventBus.getDefault();
                AdEvent adEvent = new AdEvent();
                adEvent.setAdConfigItem(adConfigItem);
                adEvent.setType(str);
                Unit unit = Unit.INSTANCE;
                eventBus.postSticky(adEvent);
                SystemUtils.log(3, TAG, "doPublish Event", (Throwable) null, "com.didi.sdk.ad.operation.HomeAdOperation", 108);
                return;
            }
            AdManager.INSTANCE.notifyObserver(str, adConfigItem);
        }
    }

    /* renamed from: a */
    private final AdConfigItem m24676a(JsonElement jsonElement) {
        if (jsonElement == null) {
            return null;
        }
        try {
            return (AdConfigItem) GSonUtil.objectFromJson(jsonElement.toString(), AdConfigItem.class);
        } catch (Exception unused) {
            return null;
        }
    }
}
