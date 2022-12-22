package com.didi.component.matchtogo20.ontrip;

import android.content.Intent;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.EstimateUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.p101h5.PriceDetailWebActivity;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.matchtogo20.ontrip.view.IMTGOnTripView;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.webview.WebViewModel;

public abstract class AbsMTGOnTripPresenter extends IPresenter<IMTGOnTripView> {
    protected BusinessContext businessContext;
    protected boolean isUpdateAccept;
    protected IXpCardBindDataReadyCallback mXpanelController;

    public AbsMTGOnTripPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void updateMtgPanel() {
        if (!this.isUpdateAccept) {
            this.isUpdateAccept = true;
            doPublish(BaseEventKeys.WaitRsp.EVENT_MTG_WAIT_ACCEPT_PANEL, "");
            removeViewFromXpanel();
            doPublish(BaseEventKeys.WaitRsp.EVENT_MTG_WAIT_ACCEPT_PANEL_SHOW, false);
        }
    }

    public void onShowPriceDetailClicked() {
        Intent intent = new Intent(this.mContext, PriceDetailWebActivity.class);
        intent.setFlags(268435456);
        WebViewModel buildWebViewModel = GlobalWebUrl.buildWebViewModel(GlobalWebUrl.getEstimatePriceDetailUrl(this.mContext, (String) null));
        CarInfo popByEstimateItem = EstimateUtils.getPopByEstimateItem(this.businessContext, FormStore.getInstance().getNewEstimateItem());
        if (popByEstimateItem != null) {
            buildWebViewModel.queryParamMap.put("popname", popByEstimateItem.getName());
        }
        buildWebViewModel.queryParamMap.put("call_stage", "wait_driver");
        intent.putExtra("web_view_model", buildWebViewModel);
        this.mContext.startActivity(intent);
        SceneHelper.getInstance().setFromPriceDetail(true);
    }

    /* access modifiers changed from: protected */
    public void addViewToXpanel() {
        IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = this.mXpanelController;
        if (iXpCardBindDataReadyCallback != null) {
            iXpCardBindDataReadyCallback.ready(true);
        }
    }

    /* access modifiers changed from: protected */
    public void removeViewFromXpanel() {
        IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = this.mXpanelController;
        if (iXpCardBindDataReadyCallback != null) {
            iXpCardBindDataReadyCallback.ready(false);
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_REMOVE_CARD, ComponentType.XPANEL_CARPOOL_MATCHONTRIP);
    }
}
