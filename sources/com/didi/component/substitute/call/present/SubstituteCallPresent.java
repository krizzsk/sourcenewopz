package com.didi.component.substitute.call.present;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.ScNoviceGuidanceActivity;
import com.didi.component.substitute.call.model.ContactModel;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.util.SPUtils;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didi/component/substitute/call/present/SubstituteCallPresent;", "Lcom/didi/component/substitute/call/present/AbsSubstituteCallPresent;", "params", "Lcom/didi/component/core/ComponentParams;", "(Lcom/didi/component/core/ComponentParams;)V", "isFromHomePage", "", "mCountryCode", "", "mId", "", "mName", "mOpenHistoryLis", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "", "mPhone", "mSCNoviceGuidance", "mShowSubstitutesCallGuidance", "mSimpleRequestLis", "Lcom/didi/component/substitute/call/model/ContactModel;", "mType", "mXELogicCallback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "reqCallback", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onRemove", "onSuccess", "jsonObject", "Lcom/google/gson/JsonObject;", "reStatus", "setPageSource", "showNoviceGuidanceForSubstituteCall", "educationPopupCount", "simpleRequest", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallPresent.kt */
public final class SubstituteCallPresent extends AbsSubstituteCallPresent {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f16086a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f16087b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f16088c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f16089d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f16090e;

    /* renamed from: f */
    private boolean f16091f;

    /* renamed from: g */
    private boolean f16092g;

    /* renamed from: h */
    private final XEResponseCallback f16093h = new SubstituteCallPresent$mXELogicCallback$1(this);

    /* renamed from: i */
    private final XEReqJSONParamsCallbackImpl f16094i = new SubstituteCallPresent$reqCallback$1(this);

    /* renamed from: j */
    private final BaseEventPublisher.OnEventListener<Integer> f16095j = new SubstituteCallPresent$mSCNoviceGuidance$1(this);

    /* renamed from: k */
    private final BaseEventPublisher.OnEventListener<Integer> f16096k = new SubstituteCallPresent$mOpenHistoryLis$1(this);

    /* renamed from: l */
    private final BaseEventPublisher.OnEventListener<ContactModel> f16097l = new SubstituteCallPresent$mSimpleRequestLis$1(this);

    public SubstituteCallPresent(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11802a(JsonObject jsonObject) {
        JsonObject asJsonObject;
        if (jsonObject != null && jsonObject.has("data") && (asJsonObject = jsonObject.getAsJsonObject("data")) != null) {
            GsonUtils.fromJsonAsync(asJsonObject.toString(), SubstituteCallModel.class, new SubstituteCallPresent$onSuccess$1$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m11803b() {
        this.f16086a = 0;
        this.f16089d = 0;
        this.f16087b = null;
        this.f16088c = null;
        this.f16090e = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m11804c() {
        XEngineReq.simpleRequest(XERequestKey.SCENE_ESTIMATE, XERequestKey.SingleCompRefresh.REQUEST_KEY_SUBSTITUTE_CALL);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_NOVICE_GUIDANCE_FOR_SUBSTITUTE_CALL, this.f16095j, Integer.class);
        subscribe(BaseEventKeys.Estimate.EVENT_OPEN_SUBSTITUTE_CALL, this.f16096k, Integer.class);
        subscribe(BaseEventKeys.Estimate.EVENT_SIMPLE_REQUEST_SUBSTITUTE_CALL, this.f16097l, ContactModel.class);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_SUBSTITUTE_CALL, XERequestKey.SCENE_ESTIMATE, this.f16093h);
        xERegisterModel.requestParams = this.f16094i;
        XERegister.registerTemplate(xERegisterModel);
        m11801a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_NOVICE_GUIDANCE_FOR_SUBSTITUTE_CALL, this.f16095j, Integer.class);
        unsubscribe(BaseEventKeys.Estimate.EVENT_OPEN_SUBSTITUTE_CALL, this.f16096k, Integer.class);
        unsubscribe(BaseEventKeys.Estimate.EVENT_SIMPLE_REQUEST_SUBSTITUTE_CALL, this.f16097l, ContactModel.class);
        XERegister.unregisterTemplate(XERequestKey.SingleCompRefresh.REQUEST_KEY_SUBSTITUTE_CALL);
    }

    /* renamed from: a */
    private final void m11801a(Bundle bundle) {
        String string;
        if (bundle != null && (string = bundle.getString("page_source")) != null) {
            CharSequence charSequence = string;
            if (TextUtils.equals(BaseConstants.ConfirmPageExtraKeys.PAGE_SOURCE_DEEPLINK, charSequence) || TextUtils.equals("page_home_destination", charSequence) || TextUtils.equals("page_sug", charSequence)) {
                this.f16091f = true;
            }
        }
    }

    public final boolean isFromHomePage() {
        return this.f16091f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m11800a(int i) {
        if (!this.f16092g && isFromHomePage()) {
            Object obj = SPUtils.get(this.mContext, "substitute_call_count", 0);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            } else if (((Integer) obj).intValue() < i) {
                this.f16092g = true;
                Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
                if (currentActivity != null) {
                    ScNoviceGuidanceActivity.Companion companion = ScNoviceGuidanceActivity.Companion;
                    Intrinsics.checkNotNullExpressionValue(currentActivity, "activity");
                    currentActivity.startActivity(companion.getIntent(currentActivity));
                }
                if (currentActivity != null) {
                    currentActivity.overridePendingTransition(0, 0);
                }
            }
        }
    }
}
