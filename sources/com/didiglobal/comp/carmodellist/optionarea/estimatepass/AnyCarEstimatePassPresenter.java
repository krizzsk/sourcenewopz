package com.didiglobal.comp.carmodellist.optionarea.estimatepass;

import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didiglobal.comp.carmodellist.optionarea.estimatepass.IAnyCarEstimatePassView;
import java.util.Collection;
import java.util.Iterator;

public class AnyCarEstimatePassPresenter implements IAnyCarEstimatePassView.OnCheckChangeListener {

    /* renamed from: a */
    private NewEstimateChoosedOpration f49803a;

    /* renamed from: b */
    private String f49804b;

    /* renamed from: c */
    private IAnyCarEstimatePassView f49805c;

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.estimatePass == null) {
            FormStore.getInstance().setIsHasEstimatePassData(false);
            this.f49805c.setVisibility(8);
        } else {
            NewEstimateChoosedOpration newEstimateChoosedOpration = anyCarEstimateItemModel.estimatePass;
            this.f49803a = newEstimateChoosedOpration;
            if (newEstimateChoosedOpration.operationData == null || this.f49803a.operationData.operationTextV2 == null || TextUtils.isEmpty(this.f49803a.operationData.operationTextV2.getContent())) {
                FormStore.getInstance().setIsHasEstimatePassData(false);
                this.f49805c.setVisibility(8);
            } else {
                FormStore.getInstance().setIsHasEstimatePassData(true);
                this.f49805c.setVisibility(0);
                this.f49805c.setPassRichInfo(this.f49803a.operationData.operationTextV2);
                if (!TextUtils.isEmpty(this.f49803a.operationData.link)) {
                    this.f49805c.setArrowVisibility(0);
                } else {
                    this.f49805c.setArrowVisibility(8);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_bubblepagepurchase_view_sw");
            }
            CarOperationModel carOperationModel = null;
            if (!CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
                Iterator<CarOperationModel> it = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation.iterator();
                while (true) {
                    if (it.hasNext()) {
                        CarOperationModel next = it.next();
                        if (next != null && "5".equals(next.operationType)) {
                            carOperationModel = next;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (carOperationModel != null) {
                this.f49804b = carOperationModel.toast;
                FormStore.getInstance().setPassPackageId(carOperationModel.passPackageId);
                if (carOperationModel.isShowCheckBox == 1) {
                    this.f49805c.setCheckBoxVisibility(0);
                    if (anyCarEstimateItemModel.estimatePass == null || anyCarEstimateItemModel.estimatePass.selectedValue.isEmpty()) {
                        this.f49805c.setCheck(carOperationModel.dupselectdefault);
                        FormStore.getInstance().setEstimatePassConfirm(carOperationModel.dupselectdefault);
                    } else if (anyCarEstimateItemModel.estimatePass.selectedValue.equals("1")) {
                        this.f49805c.setCheck(true);
                        FormStore.getInstance().setEstimatePassConfirm(true);
                    } else {
                        this.f49805c.setCheck(false);
                        FormStore.getInstance().setEstimatePassConfirm(false);
                    }
                } else {
                    this.f49805c.setCheckBoxVisibility(8);
                }
            }
        }
        this.f49805c.setOnCheckChangeListener(this);
    }

    public AnyCarEstimatePassPresenter(IAnyCarEstimatePassView iAnyCarEstimatePassView) {
        this.f49805c = iAnyCarEstimatePassView;
    }

    public void onCheckChange(boolean z) {
        if (z) {
            this.f49803a.selectedValue = "1";
            this.f49805c.showPassToast(this.f49804b);
            GlobalOmegaUtils.trackEvent("ibt_gp_anycar_cartype_bottom_banner_ck");
        } else {
            this.f49803a.selectedValue = "0";
        }
        FormStore.getInstance().setEstimatePassConfirm(z);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
    }
}
