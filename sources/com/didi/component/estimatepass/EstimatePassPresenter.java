package com.didi.component.estimatepass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimatepass.IEstimatePassView;
import com.didi.travel.psnger.model.response.estimate.CarOperationModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.taxis99.R;
import java.util.HashMap;

public class EstimatePassPresenter extends IPresenter<IEstimatePassView> implements IEstimatePassView.OnCheckChangeListener {

    /* renamed from: a */
    private NewEstimateChoosedOpration f13294a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f13295b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<CarOperationModel> f13296c = new BaseEventPublisher.OnEventListener<CarOperationModel>() {
        public void onEvent(String str, CarOperationModel carOperationModel) {
            if (carOperationModel != null) {
                String unused = EstimatePassPresenter.this.f13295b = carOperationModel.toast;
                FormStore.getInstance().setPassPackageId(carOperationModel.passPackageId);
                if (carOperationModel.isShowCheckBox == 1) {
                    ((IEstimatePassView) EstimatePassPresenter.this.mView).setCheckBoxVisibility(0);
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    if (newEstimateItem == null || newEstimateItem.estimatePass == null || newEstimateItem.estimatePass.selectedValue.isEmpty()) {
                        ((IEstimatePassView) EstimatePassPresenter.this.mView).setCheck(carOperationModel.dupselectdefault);
                        FormStore.getInstance().setEstimatePassConfirm(carOperationModel.dupselectdefault);
                    } else if (newEstimateItem.estimatePass.selectedValue.equals("1")) {
                        ((IEstimatePassView) EstimatePassPresenter.this.mView).setCheck(true);
                        FormStore.getInstance().setEstimatePassConfirm(true);
                    } else {
                        ((IEstimatePassView) EstimatePassPresenter.this.mView).setCheck(false);
                        FormStore.getInstance().setEstimatePassConfirm(false);
                    }
                } else {
                    ((IEstimatePassView) EstimatePassPresenter.this.mView).setCheckBoxVisibility(8);
                }
            }
        }
    };

    public EstimatePassPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.estimatePass == null) {
            FormStore.getInstance().setIsHasEstimatePassData(false);
            ((IEstimatePassView) this.mView).setVisibility(8);
        } else {
            NewEstimateChoosedOpration newEstimateChoosedOpration = newEstimateItem.estimatePass;
            this.f13294a = newEstimateChoosedOpration;
            if (newEstimateChoosedOpration.operationData == null || this.f13294a.operationData.operationTextV2 == null || TextUtils.isEmpty(this.f13294a.operationData.operationTextV2.getContent())) {
                FormStore.getInstance().setIsHasEstimatePassData(false);
                ((IEstimatePassView) this.mView).setVisibility(8);
            } else {
                FormStore.getInstance().setIsHasEstimatePassData(true);
                ((IEstimatePassView) this.mView).setVisibility(0);
                ((IEstimatePassView) this.mView).setPassRichInfo(this.f13294a.operationData.operationTextV2);
                if (!TextUtils.isEmpty(this.f13294a.operationData.link)) {
                    ((IEstimatePassView) this.mView).setArrowVisibility(0);
                } else {
                    ((IEstimatePassView) this.mView).setArrowVisibility(8);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_bubblepagepurchase_view_sw");
            }
        }
        ((IEstimatePassView) this.mView).setOnCheckChangeListener(this);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_SHOW_PASS_VIEW_OPTION, this.f13296c);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_SHOW_PASS_VIEW_OPTION, this.f13296c);
    }

    public void onCheckChange(boolean z) {
        if (z) {
            this.f13294a.selectedValue = "1";
            ((IEstimatePassView) this.mView).showPassToast(this.f13295b);
            GlobalOmegaUtils.trackEvent("ibt_gp_bubblepagepurchase_click_ck");
        } else {
            this.f13294a.selectedValue = "0";
        }
        FormStore.getInstance().setEstimatePassConfirm(z);
        doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
    }

    public void openPassWebView() {
        HashMap hashMap = new HashMap();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        String str = (newEstimateItem == null || newEstimateItem.estimatePass == null || newEstimateItem.estimatePass.operationData == null) ? "" : newEstimateItem.estimatePass.operationData.link;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(GlobalWebUrl.buildUrl(str, hashMap)));
            this.mContext.startActivity(intent);
            ((Activity) this.mContext).overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
            GlobalOmegaUtils.trackEvent("ibt_gp_bubblepagepurchase_arrow_click_ck");
        }
    }
}
