package com.didi.component.rideoption;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.rideoption.IRideOptionView;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.estimate.CarChoiceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didi.travel.psnger.model.response.estimate.SelectedValueParams;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideOptionPresenter extends AbsRideOptionPresenter implements PopupSelectView.OnPopupSelectListClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f15298a = -1;

    /* renamed from: b */
    private List<PopupSelectModel> f15299b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f15300c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NewEstimateChoosedOpration f15301d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<CarChoiceModel> f15302e;

    /* renamed from: f */
    private ComponentParams f15303f;

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15304g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                ((IRideOptionView) RideOptionPresenter.this.mView).setClickable(false);
            }
        }
    };

    public RideOptionPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f15303f = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (FormStore.getInstance().isAccessibleCar()) {
            this.f15298a = 1;
            this.f15300c = 1;
        } else {
            this.f15298a = 0;
            this.f15300c = 0;
        }
        final EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            NewEstimateChoosedOpration newEstimateChoosedOpration = newEstimateItem.extraChoice;
            this.f15301d = newEstimateChoosedOpration;
            if (!(newEstimateChoosedOpration == null || newEstimateChoosedOpration.operationData == null)) {
                List<CarChoiceModel> list = this.f15301d.operationData.operationChoices;
                this.f15302e = list;
                if (!CollectionUtils.isEmpty((Collection) list) && this.f15302e.size() > 1) {
                    this.f15299b = Arrays.asList(new PopupSelectModel[]{new PopupSelectModel("1", this.f15302e.get(0).choiceText), new PopupSelectModel("2", this.f15302e.get(1).choiceText)});
                    ((IRideOptionView) this.mView).setSelectListData(this.f15299b);
                }
                if (this.f15301d.selectedText != null && !TextUtils.isEmpty(this.f15301d.selectedText.getContent())) {
                    ((IRideOptionView) this.mView).setNewContent(this.f15301d.selectedText);
                } else if (this.f15301d.operationData.operationText != null) {
                    ((IRideOptionView) this.mView).setNewContent(this.f15301d.operationData.operationText);
                }
                if (!TextUtils.isEmpty(this.f15301d.operationData.operationIcon)) {
                    ((IRideOptionView) this.mView).setOptionIcon(this.f15301d.operationData.operationIcon);
                }
                if (!TextUtils.isEmpty(this.f15301d.operationData.operationTitle)) {
                    ((IRideOptionView) this.mView).setDialogTitle(this.f15301d.operationData.operationTitle);
                }
                ((IRideOptionView) this.mView).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!Utils.isFastDoubleClick()) {
                            RideOptionPresenter.this.onClickable(view);
                            HashMap hashMap = new HashMap();
                            hashMap.put("bubble_id", newEstimateItem.estimateId);
                            hashMap.put("require_level", Integer.valueOf(newEstimateItem.getCarLevel()));
                            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_noextras_ck", (Map<String, Object>) hashMap);
                        }
                    }
                });
                ((IRideOptionView) this.mView).setOnConfirmListener(new IRideOptionView.OnConfirmListener() {
                    public void onConfirm(View view) {
                        RideOptionPresenter rideOptionPresenter = RideOptionPresenter.this;
                        int unused = rideOptionPresenter.f15298a = rideOptionPresenter.f15300c;
                        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                        if (newEstimateItem != null) {
                            newEstimateItem.addSelectedValueJsonObject(ComponentType.RIDE_OPTION, (JsonObject) null);
                        }
                        if (RideOptionPresenter.this.f15298a == 1) {
                            FormStore.getInstance().setAccessibleCar(true);
                            if (RideOptionPresenter.this.f15301d.operationData.operationChoices.size() > RideOptionPresenter.this.f15298a) {
                                CarChoiceModel carChoiceModel = RideOptionPresenter.this.f15301d.operationData.operationChoices.get(RideOptionPresenter.this.f15298a);
                                SelectedValueParams selectedValueParams = carChoiceModel.getselectValue();
                                if (selectedValueParams != null && !TextUtils.isEmpty(selectedValueParams.customFeature)) {
                                    RideOptionPresenter.this.f15301d.selectedValue = selectedValueParams.customFeature;
                                }
                                if (newEstimateItem != null) {
                                    newEstimateItem.addSelectedValueJsonObject(ComponentType.RIDE_OPTION, carChoiceModel.selectValueObject);
                                }
                            }
                        } else {
                            FormStore.getInstance().setAccessibleCar(false);
                            RideOptionPresenter.this.f15301d.selectedValue = "0";
                        }
                        RideOptionPresenter.this.f15301d.selectedText = ((CarChoiceModel) RideOptionPresenter.this.f15302e.get(RideOptionPresenter.this.f15298a)).selectedText;
                        if (RideOptionPresenter.this.mView != null) {
                            ((IRideOptionView) RideOptionPresenter.this.mView).setNewContent(RideOptionPresenter.this.f15301d.selectedText);
                            ((IRideOptionView) RideOptionPresenter.this.mView).closeSelectMore();
                        }
                    }
                });
            }
        }
        ((IRideOptionView) this.mView).setOnPopupSelectListClickListener(this);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f15304g);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f15304g);
    }

    public void onClickable(View view) {
        ((IRideOptionView) this.mView).showSelectMore(this.f15298a);
    }

    public void onItemClick(int i) {
        this.f15300c = i;
        List<CarChoiceModel> list = this.f15302e;
        if (list != null && i < list.size() && this.mView != null && this.f15302e.get(i).selectedText != null) {
            ((IRideOptionView) this.mView).setSelectedPosition(i);
        }
    }

    public void onCloseButtonClick() {
        if (this.mView != null) {
            ((IRideOptionView) this.mView).closeSelectMore();
        }
    }
}
