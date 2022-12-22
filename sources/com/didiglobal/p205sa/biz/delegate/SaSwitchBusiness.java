package com.didiglobal.p205sa.biz.delegate;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.app.business.ISaSwitchBusiness;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@ServiceProvider({ISaSwitchBusiness.class})
@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/delegate/SaSwitchBusiness;", "Lcom/didi/sdk/app/business/ISaSwitchBusiness;", "()V", "forceLogin", "", "link", "", "switch", "", "groupType", "bundle", "Landroid/os/Bundle;", "switchBusiness", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.delegate.SaSwitchBusiness */
/* compiled from: SaSwitchBusiness.kt */
public final class SaSwitchBusiness implements ISaSwitchBusiness {
    /* renamed from: switch  reason: not valid java name */
    public void m47059switch(String str, String str2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "groupType");
        Intrinsics.checkNotNullParameter(str2, "link");
        if (!m36676a(str2) || OneLoginFacade.getStore().isLoginNow()) {
            m36675a(str, str2, bundle);
            return;
        }
        OneLoginFacade.getFunction().addLoginListener(new SaSwitchBusiness$switch$1(this, str, str2, bundle));
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            OneLoginFacade.getAction().go2Login(currentActivity);
        }
    }

    /* renamed from: a */
    private final boolean m36676a(String str) {
        if (StringsKt.startsWith$default(SuperAppBusinessManager.INSTANCE.getCOMMON_H5_SCHEME(), str, false, 2, (Object) null) && Intrinsics.areEqual((Object) "1", (Object) Uri.parse(str).getQueryParameter("forceLogin"))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36675a(String str, String str2, Bundle bundle) {
        SwitchTypeEvent switchTypeEvent = new SwitchTypeEvent(str);
        switchTypeEvent.scheme = str2;
        switchTypeEvent.extraBundle = bundle;
        EventBus.getDefault().post(switchTypeEvent);
    }
}
