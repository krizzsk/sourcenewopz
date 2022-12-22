package com.didiglobal.passenger.brz.component;

import android.text.TextUtils;
import com.didi.component.business.constant.PaymentsApi;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.presenter.PayWayPresenter;
import com.didi.component.payway.view.IPayWayView;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.AssetsUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.PayWayModel;
import java.util.Collection;
import java.util.List;

public class BrzPayWayPresenter extends PayWayPresenter {

    /* renamed from: a */
    private static final String f50299a = "brz_payments/default_payments";

    /* renamed from: b */
    private static final String f50300b = "brz_payments/guarana_default_payments";

    public BrzPayWayPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void refreshPayWay(boolean z) {
        ((IPayWayView) this.mView).setClickable(true);
        ((IPayWayView) this.mView).show();
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        this.mSelectedPaywayItem.clear();
        if (estimateItem == null) {
            ((IPayWayView) this.mView).setLabel((List<PayWayModel.PayWayItem>) null);
            ((IPayWayView) this.mView).changeEnableColor(false);
            return;
        }
        PayWayModel payWayModel = new PayWayModel();
        payWayModel.payWayList = estimateItem.payWayList;
        if (CollectionUtil.isEmpty((Collection<?>) payWayModel.payWayList)) {
            payWayModel.parse(AssetsUtil.getAssetsFile(this.mContext, m36228b()));
            this.mSelectedPaywayItem = FormStore.getInstance().getPayWaySelectedItem();
            if (CollectionUtil.isEmpty((Collection<?>) payWayModel.payWayList)) {
                ((IPayWayView) this.mView).setLabel((List<PayWayModel.PayWayItem>) null);
                ((IPayWayView) this.mView).setClickable(false);
                return;
            }
        }
        if (payWayModel.payWayList != null) {
            int size = payWayModel.payWayList.size();
            for (int i = 0; i < size; i++) {
                PayWayModel.PayWayItem payWayItem = payWayModel.payWayList.get(i);
                if (PaymentsApi.containsPayment(payWayItem.getTag()) && 1 == payWayItem.isSelected()) {
                    this.mSelectedPaywayItem.add(payWayItem);
                }
            }
        }
        ((IPayWayView) this.mView).dismissPopup();
        if (z && !showGuidePopup()) {
            showPayWayGuideIfNeed(estimateItem);
        }
        if (z) {
            checkCashLimit(this.mSelectedPaywayItem);
        }
        setPayWayToForm(this.mSelectedPaywayItem);
        this.mPaywayItems = payWayModel.payWayList;
        ((IPayWayView) this.mView).setLabel(this.mSelectedPaywayItem);
        ((IPayWayView) this.mView).setContentDescription(getSelectItemsDesc(this.mSelectedPaywayItem));
    }

    /* renamed from: b */
    private String m36228b() {
        return TextUtils.equals("pt-BR", MultiLocaleStore.getInstance().getLocaleCode()) ? f50300b : f50299a;
    }
}
