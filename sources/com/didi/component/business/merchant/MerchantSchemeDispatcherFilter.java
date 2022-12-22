package com.didi.component.business.merchant;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.BaseDeepLinkEvent;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.DidiLoadDexActivity;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import global.didi.pay.merchant.processor.model.MerchantSDKRequest;
import global.didi.pay.merchantcore.DSchemeConstantKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@ServiceProvider(alias = "merchant", value = {AbsSchemeDispatcherFilter.class})
@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\rH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/component/business/merchant/MerchantSchemeDispatcherFilter;", "Lcom/didi/sdk/app/scheme/AbsSchemeDispatcherFilter;", "()V", "handleIntent", "Landroid/content/Intent;", "getHandleIntent", "()Landroid/content/Intent;", "setHandleIntent", "(Landroid/content/Intent;)V", "doFilter", "", "intent", "dispatcher", "Lcom/didi/sdk/app/SchemeDispatcher;", "doPublishStick", "", "category", "", "obj", "Lcom/didi/component/business/event/BaseDeepLinkEvent;", "isComeFromMerchantSDK", "isMainActivityAlive", "tryStartMainActivity", "schemeDispatcher", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantSchemeDispatcherFilter.kt */
public final class MerchantSchemeDispatcherFilter extends AbsSchemeDispatcherFilter {
    public Intent handleIntent;

    public final Intent getHandleIntent() {
        Intent intent = this.handleIntent;
        if (intent != null) {
            return intent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("handleIntent");
        return null;
    }

    public final void setHandleIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<set-?>");
        this.handleIntent = intent;
    }

    public boolean doFilter(Intent intent, SchemeDispatcher schemeDispatcher) {
        Intrinsics.checkNotNullParameter(schemeDispatcher, "dispatcher");
        if (!m7640a(intent)) {
            return false;
        }
        if (m7639a()) {
            GlobalMerchantUnifiedPayProcessor.INS.onHandleMerchantRequest(schemeDispatcher, MerchantSDKRequest.Companion.newIns(intent));
        } else {
            m7638a(BaseEventKeys.Service.DeepLink.EVENT_HAND_MERCHANT_DEEP_LINK, new MerchantActivityDeepLinkEvent(MerchantSDKRequest.Companion.newIns(intent)));
            m7637a(schemeDispatcher);
        }
        schemeDispatcher.finish();
        return true;
    }

    /* renamed from: a */
    private final boolean m7640a(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return false;
        }
        if ((!StringsKt.equals("globalOneTravel", data.getScheme(), true) && !StringsKt.equals("taxis99OneTravel", data.getScheme(), true)) || !StringsKt.equals(DSchemeConstantKt.HOST_MERCHANT_PAY, data.getHost(), true)) {
            return false;
        }
        setHandleIntent(intent);
        return true;
    }

    /* renamed from: a */
    private final boolean m7639a() {
        return ActivityLifecycleManager.getInstance().isMainActivityRunning();
    }

    /* renamed from: a */
    private final void m7637a(SchemeDispatcher schemeDispatcher) {
        if (!m7639a()) {
            schemeDispatcher.startActivity(new Intent(schemeDispatcher, DidiLoadDexActivity.class));
            schemeDispatcher.finish();
        }
    }

    /* renamed from: a */
    private final void m7638a(String str, BaseDeepLinkEvent baseDeepLinkEvent) {
        if (!TextUtils.isEmpty(str)) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            BaseEventPublisher.getPublisher().publishSticky(str, baseDeepLinkEvent);
        }
    }
}
