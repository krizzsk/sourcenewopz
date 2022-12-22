package com.didi.component.savingcenter;

import android.os.Bundle;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.bff.BFFStore;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.savingcenter.AbsSavingCenterPresenter;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.events.RemotionalMessageEvent;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.scan.GlobalScan;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0011\u001a\u00020\nH\u0014J\b\u0010\u0012\u001a\u00020\nH\u0014J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/component/savingcenter/HomeSavingCenterPresenter;", "Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;", "params", "Lcom/didi/component/core/ComponentParams;", "(Lcom/didi/component/core/ComponentParams;)V", "mXELogicCallback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "requestParams", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "doRequest", "", "getPageId", "", "onAdd", "arguments", "Landroid/os/Bundle;", "onBackHome", "onPageResume", "onRemove", "showMessage", "event", "Lcom/didi/sdk/events/RemotionalMessageEvent;", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSavingCenterPresenter.kt */
public final class HomeSavingCenterPresenter extends AbsSavingCenterPresenter {

    /* renamed from: a */
    private final XEReqJSONParamsCallbackImpl f15477a = new HomeSavingCenterPresenter$requestParams$1(this);

    /* renamed from: b */
    private final XEResponseCallback f15478b = new HomeSavingCenterPresenter$mXELogicCallback$1(this);

    public HomeSavingCenterPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        EventBus.getDefault().register(this);
        if (!GlobalApolloUtil.isHomeEngine()) {
            m11150b();
            return;
        }
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_SAVING_CENTER, XERequestKey.SCENE_HOME, this.f15478b);
        xERegisterModel.requestParams = this.f15477a;
        XERegister.registerTemplate(xERegisterModel);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        EventBus.getDefault().unregister(this);
        if (GlobalApolloUtil.isHomeEngine()) {
            XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_SAVING_CENTER);
        }
    }

    public int getPageId() {
        return AbsSavingCenterPresenter.ScPageId.HOME.getId();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        GLog.m7965d("HomeSavingCenterPresenter", "onBackHome");
        super.onBackHome(bundle);
        if (!GlobalApolloUtil.isHomeEngine()) {
            m11150b();
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        GLog.m7965d("HomeSavingCenterPresenter", "onPageResume");
        super.onPageResume();
        if (!GlobalApolloUtil.isHomeEngine() && BusinessContextManager.getInstance().isInHomePage()) {
            m11150b();
        }
    }

    /* renamed from: b */
    private final void m11150b() {
        setMCanShow(true);
        Map linkedHashMap = new LinkedHashMap();
        Map linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("scene", "home");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("from", GlobalScan.ScanFrom.INDEX.getFrom());
        jSONObject.put("user_type", BFFStore.getCarWanliuUserType(this.mContext));
        linkedHashMap2.put("biz_param", jSONObject);
        linkedHashMap.put(XERequestKey.REQUEST_KEY_SAVING_CENTER, linkedHashMap2);
        Bff.callImmediately(new IBffProxy.Ability.Builder(this.mContext, "expo/passenger").setParams(linkedHashMap).setBffCallBack(new HomeSavingCenterPresenter$doRequest$ability$1(this)).build());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void showMessage(RemotionalMessageEvent remotionalMessageEvent) {
        Intrinsics.checkNotNullParameter(remotionalMessageEvent, "event");
        String type = remotionalMessageEvent.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -1673503419) {
                if (hashCode != -503344496) {
                    if (hashCode != 899859624 || !type.equals("customerData")) {
                        return;
                    }
                } else if (!type.equals("emotionalData")) {
                    return;
                }
            } else if (!type.equals("didiPassData")) {
                return;
            }
            setMCanShow(false);
            ((ISavingCenterView) this.mView).setShowTime(0);
            ((ISavingCenterView) this.mView).hideSideText();
        }
    }
}
