package com.didi.component.savingcenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.webview.WebActivity;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H&J\u0006\u0010\u0017\u001a\u00020\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0006\u0010\u001c\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006$"}, mo175978d2 = {"Lcom/didi/component/savingcenter/AbsSavingCenterPresenter;", "Lcom/didi/component/common/base/BaseExpressPresenter;", "Lcom/didi/component/savingcenter/ISavingCenterView;", "params", "Lcom/didi/component/core/ComponentParams;", "(Lcom/didi/component/core/ComponentParams;)V", "componentAlphaListener", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "", "mCanShow", "", "getMCanShow", "()Z", "setMCanShow", "(Z)V", "mSavingCenterInfo", "Lcom/didi/component/savingcenter/SavingCenterInfo;", "getMSavingCenterInfo", "()Lcom/didi/component/savingcenter/SavingCenterInfo;", "setMSavingCenterInfo", "(Lcom/didi/component/savingcenter/SavingCenterInfo;)V", "getPageId", "", "getStyle", "onAdd", "", "arguments", "Landroid/os/Bundle;", "onIconClick", "onRemove", "setInfo", "info", "trackIconClick", "trackSideBarClick", "trackSideBarShow", "ScPageId", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbsSavingCenterPresenter.kt */
public abstract class AbsSavingCenterPresenter extends BaseExpressPresenter<ISavingCenterView> {

    /* renamed from: a */
    private SavingCenterInfo f15473a;

    /* renamed from: b */
    private boolean f15474b = true;

    /* renamed from: c */
    private final BaseEventPublisher.OnEventListener<Float> f15475c = new AbsSavingCenterPresenter$componentAlphaListener$1(this);

    public abstract int getPageId();

    public AbsSavingCenterPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public final SavingCenterInfo getMSavingCenterInfo() {
        return this.f15473a;
    }

    public final void setMSavingCenterInfo(SavingCenterInfo savingCenterInfo) {
        this.f15473a = savingCenterInfo;
    }

    public final boolean getMCanShow() {
        return this.f15474b;
    }

    public final void setMCanShow(boolean z) {
        this.f15474b = z;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f15475c, Float.class);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f15475c, Float.class);
    }

    public final void onIconClick() {
        SavingCenterInfo savingCenterInfo = this.f15473a;
        if (savingCenterInfo != null) {
            Intent intent = new Intent(this.mComponentParams.getActivity(), WebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(savingCenterInfo.getScH5Uri()));
            startActivity(intent);
        }
    }

    public final void setInfo(SavingCenterInfo savingCenterInfo) {
        if (savingCenterInfo == null || TextUtils.isEmpty(savingCenterInfo.getScIconUri())) {
            ((ISavingCenterView) this.mView).setVisible(false);
            return;
        }
        setMSavingCenterInfo(savingCenterInfo);
        ((ISavingCenterView) this.mView).setVisible(true);
        if (!getMCanShow() || savingCenterInfo.getScSideText() == null) {
            ((ISavingCenterView) this.mView).setShowTime(0);
        } else {
            ISavingCenterView iSavingCenterView = (ISavingCenterView) this.mView;
            Integer scShowTime = savingCenterInfo.getScShowTime();
            iSavingCenterView.setShowTime(scShowTime == null ? null : Integer.valueOf(scShowTime.intValue() * 1000));
        }
        ((ISavingCenterView) this.mView).setIcon(savingCenterInfo.getScIconUri());
        ((ISavingCenterView) this.mView).setSideText(savingCenterInfo.getScSideText());
    }

    public final void trackIconClick() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("k", "click");
        linkedHashMap.put(RavenKey.VERSION, "mainpage_entry");
        linkedHashMap.put(GlobalPayOmegaConstant.EventKey.TAB, Integer.valueOf(getPageId()));
        linkedHashMap.put("style", Integer.valueOf(getStyle()));
        GlobalOmegaUtils.trackEvent("ibt_gp_savecenter_mainpage_entry_ck", (Map<String, Object>) linkedHashMap);
    }

    public final void trackSideBarClick() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("k", "click");
        linkedHashMap.put(RavenKey.VERSION, "mainpage_banner_entry");
        linkedHashMap.put(GlobalPayOmegaConstant.EventKey.TAB, Integer.valueOf(getPageId()));
        linkedHashMap.put("style", Integer.valueOf(getStyle()));
        SavingCenterInfo savingCenterInfo = this.f15473a;
        linkedHashMap.put("submodule", savingCenterInfo == null ? null : savingCenterInfo.getScSubModle());
        GlobalOmegaUtils.trackEvent("ibt_gp_savecenter_mainpage_banner_ck", (Map<String, Object>) linkedHashMap);
    }

    public final void trackSideBarShow() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("k", "show");
        linkedHashMap.put(RavenKey.VERSION, "mainpage_banner_entry");
        linkedHashMap.put(GlobalPayOmegaConstant.EventKey.TAB, Integer.valueOf(getPageId()));
        linkedHashMap.put("style", Integer.valueOf(getStyle()));
        SavingCenterInfo savingCenterInfo = this.f15473a;
        linkedHashMap.put("submodule", savingCenterInfo == null ? null : savingCenterInfo.getScSubModle());
        GlobalOmegaUtils.trackEvent("ibt_gp_savecenter_mainpage_banner_sw", (Map<String, Object>) linkedHashMap);
    }

    public final int getStyle() {
        if (getPageId() == ScPageId.HOME.getId()) {
            return 0;
        }
        return CarOrderHelper.getOrderStatus();
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/component/savingcenter/AbsSavingCenterPresenter$ScPageId;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "HOME", "WAIT", "END", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AbsSavingCenterPresenter.kt */
    public enum ScPageId {
        HOME(1),
        WAIT(2),
        END(3);
        

        /* renamed from: id */
        private final int f15476id;

        private ScPageId(int i) {
            this.f15476id = i;
        }

        public final int getId() {
            return this.f15476id;
        }
    }
}
