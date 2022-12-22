package com.didiglobal.comp.carmodellist.optionarea.rideoption;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.CollectionUtils;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarChoiceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didi.travel.psnger.model.response.estimate.SelectedValueParams;
import com.didiglobal.comp.carmodellist.optionarea.rideoption.IAnycarRideOptionView;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnycarRideOptionPresenter extends AbsAnycarRideOptionPresenter implements PopupSelectView.OnPopupSelectListClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f49821a = -1;

    /* renamed from: b */
    private List<PopupSelectModel> f49822b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f49823c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NewEstimateChoosedOpration f49824d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<CarChoiceModel> f49825e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IAnycarRideOptionView f49826f;

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (FormStore.getInstance().isAccessibleCar()) {
            this.f49821a = 1;
            this.f49823c = 1;
        } else {
            this.f49821a = 0;
            this.f49823c = 0;
        }
        if (anyCarEstimateItemModel != null) {
            NewEstimateChoosedOpration newEstimateChoosedOpration = anyCarEstimateItemModel.extraChoice;
            this.f49824d = newEstimateChoosedOpration;
            if (!(newEstimateChoosedOpration == null || newEstimateChoosedOpration.operationData == null)) {
                List<CarChoiceModel> list = this.f49824d.operationData.operationChoices;
                this.f49825e = list;
                if (!CollectionUtils.isEmpty((Collection) list) && this.f49825e.size() > 1) {
                    List<PopupSelectModel> asList = Arrays.asList(new PopupSelectModel[]{new PopupSelectModel("1", this.f49825e.get(0).choiceText), new PopupSelectModel("2", this.f49825e.get(1).choiceText)});
                    this.f49822b = asList;
                    this.f49826f.setSelectListData(asList);
                }
                if (this.f49824d.selectedText != null && !TextUtils.isEmpty(this.f49824d.selectedText.getContent())) {
                    this.f49826f.setNewContent(this.f49824d.selectedText);
                } else if (this.f49824d.operationData.operationText != null) {
                    this.f49826f.setNewContent(this.f49824d.operationData.operationText);
                }
                if (!TextUtils.isEmpty(this.f49824d.operationData.operationIcon)) {
                    this.f49826f.setOptionIcon(this.f49824d.operationData.operationIcon);
                }
                if (!TextUtils.isEmpty(this.f49824d.operationData.operationTitle)) {
                    this.f49826f.setDialogTitle(this.f49824d.operationData.operationTitle);
                }
                this.f49826f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!Utils.isFastDoubleClick()) {
                            AnycarRideOptionPresenter.this.onClickable(view);
                            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_noextras_ck", (Map<String, Object>) new HashMap());
                        }
                    }
                });
                this.f49826f.setOnConfirmListener(new IAnycarRideOptionView.OnConfirmListener() {
                    public void onConfirm(View view) {
                        AnycarRideOptionPresenter anycarRideOptionPresenter = AnycarRideOptionPresenter.this;
                        int unused = anycarRideOptionPresenter.f49821a = anycarRideOptionPresenter.f49823c;
                        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                        if (newEstimateItem != null) {
                            newEstimateItem.addSelectedValueJsonObject(ComponentType.RIDE_OPTION, (JsonObject) null);
                        }
                        if (AnycarRideOptionPresenter.this.f49821a == 1) {
                            FormStore.getInstance().setAccessibleCar(true);
                            if (AnycarRideOptionPresenter.this.f49824d.operationData.operationChoices.size() > AnycarRideOptionPresenter.this.f49821a) {
                                CarChoiceModel carChoiceModel = AnycarRideOptionPresenter.this.f49824d.operationData.operationChoices.get(AnycarRideOptionPresenter.this.f49821a);
                                SelectedValueParams selectedValueParams = carChoiceModel.getselectValue();
                                if (selectedValueParams != null && !TextUtils.isEmpty(selectedValueParams.customFeature)) {
                                    AnycarRideOptionPresenter.this.f49824d.selectedValue = selectedValueParams.customFeature;
                                }
                                if (newEstimateItem != null) {
                                    newEstimateItem.addSelectedValueJsonObject(ComponentType.RIDE_OPTION, carChoiceModel.selectValueObject);
                                }
                            }
                        } else {
                            FormStore.getInstance().setAccessibleCar(false);
                            AnycarRideOptionPresenter.this.f49824d.selectedValue = "0";
                        }
                        AnycarRideOptionPresenter.this.f49824d.selectedText = ((CarChoiceModel) AnycarRideOptionPresenter.this.f49825e.get(AnycarRideOptionPresenter.this.f49821a)).selectedText;
                        if (AnycarRideOptionPresenter.this.f49826f != null) {
                            AnycarRideOptionPresenter.this.f49826f.setNewContent(AnycarRideOptionPresenter.this.f49824d.selectedText);
                            AnycarRideOptionPresenter.this.f49826f.closeSelectMore();
                        }
                    }
                });
            }
        }
        this.f49826f.setOnPopupSelectListClickListener(this);
    }

    public AnycarRideOptionPresenter(IAnycarRideOptionView iAnycarRideOptionView) {
        this.f49826f = iAnycarRideOptionView;
    }

    public void onClickable(View view) {
        this.f49826f.showSelectMore(this.f49821a);
    }

    public void onItemClick(int i) {
        this.f49823c = i;
        List<CarChoiceModel> list = this.f49825e;
        if (list != null && i < list.size() && this.f49826f != null && this.f49825e.get(i).selectedText != null) {
            this.f49826f.setSelectedPosition(i);
        }
    }

    public void onCloseButtonClick() {
        IAnycarRideOptionView iAnycarRideOptionView = this.f49826f;
        if (iAnycarRideOptionView != null) {
            iAnycarRideOptionView.closeSelectMore();
        }
    }
}
