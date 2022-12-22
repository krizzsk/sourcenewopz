package com.didi.component.dispatchfee.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.dispatchfee.AbsDispatchFeePresenter;
import com.didi.component.dispatchfee.IDispatchFeeView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.taxis99.R;

public class DispatchFeePresenter extends AbsDispatchFeePresenter {

    /* renamed from: a */
    NewEstimateChoosedOpration f12789a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f12790b;

    /* renamed from: c */
    private ComponentParams f12791c;

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12792d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                ((IDispatchFeeView) DispatchFeePresenter.this.mView).setClickable(false);
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12793e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (SceneHelper.getInstance().isClickDispatchFee) {
                DispatchFeePresenter.this.m8746b();
            }
        }
    };

    public DispatchFeePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f12791c = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            NewEstimateChoosedOpration newEstimateChoosedOpration = newEstimateItem.dispatchFeeChoice;
            this.f12789a = newEstimateChoosedOpration;
            if (newEstimateChoosedOpration == null) {
                ((IDispatchFeeView) this.mView).setDispatchFee(ResourcesHelper.getString(this.mContext, R.string.global_dispatch_fee_add_dispatch_fee));
            } else {
                if (newEstimateChoosedOpration.selectedText != null && !TextUtils.isEmpty(this.f12789a.selectedText.getContent())) {
                    ((IDispatchFeeView) this.mView).bindDispatchFee(this.f12789a.selectedText);
                } else if (this.f12789a.operationData == null || this.f12789a.operationData.operationText == null || TextUtils.isEmpty(this.f12789a.operationData.operationText.getContent())) {
                    ((IDispatchFeeView) this.mView).setDispatchFee(ResourcesHelper.getString(this.mContext, R.string.global_dispatch_fee_add_dispatch_fee));
                } else {
                    ((IDispatchFeeView) this.mView).bindDispatchFee(this.f12789a.operationData.operationText);
                }
                if (this.f12789a.operationData != null && !TextUtils.isEmpty(this.f12789a.operationData.operationIcon)) {
                    ((IDispatchFeeView) this.mView).setDispatchIcon(this.f12789a.operationData.operationIcon);
                }
            }
        }
        this.f12790b = 0;
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f12792d);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE, this.f12793e);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f12792d);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_NEW_GUIDE_DIALOG_FAILURE, this.f12793e);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            SceneHelper.getInstance().isClickDispatchFee = true;
            if (GlobalSPUtil.isShownTaxisDispatchFeeDialogByUser(this.mContext)) {
                m8746b();
            } else {
                doPublish(BaseEventKeys.Estimate.ESTIMATE_DISPATCH_FEE_SHOW_NEWBIE_DIALOG_EVENT);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r6.f12789a.operationData.operationChoices;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8746b() {
        /*
            r6 = this;
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r0 = r6.f12789a
            if (r0 == 0) goto L_0x00ce
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r0 = r0.operationData
            if (r0 != 0) goto L_0x000a
            goto L_0x00ce
        L_0x000a:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r0 = r6.f12789a
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r0 = r0.operationData
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarChoiceModel> r0 = r0.operationChoices
            if (r0 == 0) goto L_0x00ce
            int r1 = r0.size()
            if (r1 > 0) goto L_0x001a
            goto L_0x00ce
        L_0x001a:
            com.didi.component.dispatchfee.newui.DispatchFeeNewUiPicker r1 = new com.didi.component.dispatchfee.newui.DispatchFeeNewUiPicker
            r1.<init>()
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r6.f12789a
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r2 = r2.operationData
            java.lang.String r2 = r2.operationTitle
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0035
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r6.f12789a
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r2 = r2.operationData
            java.lang.String r2 = r2.operationTitle
            r1.setTitle(r2)
            goto L_0x0041
        L_0x0035:
            android.content.Context r2 = r6.mContext
            r3 = 2131955019(0x7f130d4b, float:1.9546554E38)
            java.lang.String r2 = com.didi.sdk.util.ResourcesHelper.getString(r2, r3)
            r1.setTitle(r2)
        L_0x0041:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r0.iterator()
        L_0x004a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005f
            java.lang.Object r4 = r3.next()
            com.didi.travel.psnger.model.response.estimate.CarChoiceModel r4 = (com.didi.travel.psnger.model.response.estimate.CarChoiceModel) r4
            if (r4 != 0) goto L_0x0059
            goto L_0x004a
        L_0x0059:
            java.lang.String r4 = r4.choiceText
            r2.add(r4)
            goto L_0x004a
        L_0x005f:
            int r3 = r2.size()
            if (r3 > 0) goto L_0x0066
            return
        L_0x0066:
            r1.setWheelData(r2)
            com.didi.component.dispatchfee.impl.DispatchFeePresenter$3 r3 = new com.didi.component.dispatchfee.impl.DispatchFeePresenter$3
            r3.<init>(r0)
            r1.setOnSelectListener(r3)
            int r0 = r6.f12790b
            r3 = 0
            if (r0 < 0) goto L_0x0086
            int r2 = r2.size()
            if (r0 >= r2) goto L_0x0086
            r0 = 1
            int[] r0 = new int[r0]
            int r2 = r6.f12790b
            r0[r3] = r2
            r1.setInitialSelect((int[]) r0)
        L_0x0086:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.didi.component.common.util.SearchIdUploadManager r2 = com.didi.component.common.util.SearchIdUploadManager.getInstance()
            java.lang.String r2 = r2.getBubbleId()
            java.lang.String r4 = "bubble_trace_id"
            r0.put(r4, r2)
            com.didi.component.business.data.form.FormStore r2 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r2 = r2.getNewEstimateItem()
            if (r2 == 0) goto L_0x00b6
            int r4 = r2.getCarLevel()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "require_level"
            r0.put(r5, r4)
            java.lang.String r2 = r2.estimateId
            java.lang.String r4 = "bubble_id"
            r0.put(r4, r2)
        L_0x00b6:
            java.lang.String r2 = "gp_orderconfirm_dispatchfee_ck"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.Object>) r0)
            androidx.fragment.app.Fragment r0 = r6.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            java.lang.String r2 = "dispatch_fee_picker"
            r1.show((androidx.fragment.app.FragmentManager) r0, (java.lang.String) r2)
            com.didi.component.common.helper.SceneHelper r0 = com.didi.component.common.helper.SceneHelper.getInstance()
            r0.isClickDispatchFee = r3
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.dispatchfee.impl.DispatchFeePresenter.m8746b():void");
    }
}
