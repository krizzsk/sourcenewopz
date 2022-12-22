package com.didi.component.timepicker.impl.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.I18NUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.timepicker.AbsTimePickerPresenter;
import com.didi.component.timepicker.ITimePickerView;
import com.didi.component.timepicker.TimePickerModel;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.datepicker.LEGODatePickerCallback;
import com.didi.global.globaluikit.datepicker.model.LEGODatePickerModel;
import com.didi.global.globaluikit.datepicker.time.LEGODatePicker;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.psnger.datasource.BubbleSourceManager;
import com.didi.travel.psnger.model.response.estimate.CarDatepickInfo;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.taxis99.R;

public class NewTimePickerPresenter extends AbsTimePickerPresenter {

    /* renamed from: a */
    LEGODatePicker f16116a;

    /* renamed from: b */
    private BusinessContext f16117b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f16118c;

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Boolean> f16119d = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                ((ITimePickerView) NewTimePickerPresenter.this.mView).getView().postDelayed(new Runnable() {
                    public void run() {
                        NewTimePickerPresenter.this.updateConfig();
                        ((ITimePickerView) NewTimePickerPresenter.this.mView).setEnable(true);
                    }
                }, 500);
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16120e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            ((ITimePickerView) NewTimePickerPresenter.this.mView).setEnable(false);
        }
    };

    /* renamed from: f */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16121f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str) && NewTimePickerPresenter.this.f16118c) {
                ((ITimePickerView) NewTimePickerPresenter.this.mView).dismissNewBubble();
                boolean unused = NewTimePickerPresenter.this.f16118c = false;
            }
        }
    };

    /* renamed from: g */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16122g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str)) {
                NewTimePickerPresenter.this.m11819d();
            }
        }
    };

    /* access modifiers changed from: protected */
    public TimePickerModel getModel() {
        return null;
    }

    public String getScene() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void showBookingCouponPopupIfNeed() {
    }

    public NewTimePickerPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f16117b = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m11816b();
    }

    /* access modifiers changed from: protected */
    public void updateConfig() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carDatepickInfo == null)) {
            ((ITimePickerView) this.mView).setIcon(newEstimateItem.carDatepickInfo.icon);
            long transportTime = FormStore.getInstance().getTransportTime();
            if (transportTime > 0) {
                newEstimateItem.carDatepickInfo.title.updateText(I18NUtils.getMonthDayAndHourMinute(transportTime));
            }
            ((ITimePickerView) this.mView).bindRichInfo(newEstimateItem.carDatepickInfo.title);
        }
        if (!this.f16118c) {
            m11819d();
            return;
        }
        this.f16118c = false;
        ((ITimePickerView) this.mView).dismissNewBubble();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m11818c();
        if (this.mView != null) {
            ((ITimePickerView) this.mView).setEnable(false);
        }
    }

    /* renamed from: b */
    private void m11816b() {
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f16119d);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f16120e);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f16121f);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f16122g);
    }

    /* renamed from: c */
    private void m11818c() {
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f16119d);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f16120e);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f16121f);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f16122g);
    }

    public void showTimePickerDialog() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_reserve_ck");
        CarDatepickInfo carDatepickInfo = newEstimateItem.carDatepickInfo;
        if (carDatepickInfo != null && carDatepickInfo.beginTime > 0 && carDatepickInfo.endTime > 0) {
            LEGODatePickerModel lEGODatePickerModel = new LEGODatePickerModel();
            if (carDatepickInfo.detailTitle != null) {
                lEGODatePickerModel.title.setInfo(carDatepickInfo.detailTitle.toString());
            }
            long transportTime = FormStore.getInstance().getTransportTime();
            if (transportTime > 0) {
                lEGODatePickerModel.defaultScrolledSecond = transportTime / 1000;
            }
            lEGODatePickerModel.beginTimeSecond = carDatepickInfo.beginTime;
            lEGODatePickerModel.endTimeSecond = carDatepickInfo.endTime;
            if (carDatepickInfo.confirmTitle != null) {
                lEGODatePickerModel.confirmTitle.setInfo(carDatepickInfo.confirmTitle.toString());
            }
            lEGODatePickerModel.intervalSecond = carDatepickInfo.interval;
            lEGODatePickerModel.serviceBeginSecond = carDatepickInfo.serviceBegin;
            lEGODatePickerModel.serviceEndSecond = carDatepickInfo.serviceEnd;
            lEGODatePickerModel.today = this.mContext.getString(R.string.JpRider_1_Today_CorS);
            lEGODatePickerModel.now = this.mContext.getString(R.string.JpRider_2_Now_JiNd);
            this.f16116a = LEGOUICreator.showDatePicker(this.mContext, lEGODatePickerModel, new LEGODatePickerCallback() {
                public void onConfirmClick(long j) {
                    SystemUtils.log(6, "dongxt", "confirm " + j, (Throwable) null, "com.didi.component.timepicker.impl.presenter.NewTimePickerPresenter$3", 138);
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_reserve_confirm_ck");
                    FormStore.getInstance().setTransportTime(j * 1000);
                    NewTimePickerPresenter.this.doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_TIME_CHANGED);
                    NewTimePickerPresenter.this.updateConfig();
                }

                public void onCancelClick() {
                    SystemUtils.log(6, "dongxt", "cancel ", (Throwable) null, "com.didi.component.timepicker.impl.presenter.NewTimePickerPresenter$3", 147);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        LEGODatePicker lEGODatePicker = this.f16116a;
        if (lEGODatePicker == null || !lEGODatePicker.isShowing()) {
            return super.onBackPressed(backType);
        }
        this.f16116a.dismiss();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11819d() {
        BubbleItemModel bubble;
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.carBubbleModule != null && (bubble = new BubbleSourceManager(this.mContext).getBubble(2, newEstimateItem.carBubbleModule, false)) != null) {
            this.f16118c = true;
            ((ITimePickerView) this.mView).showBookingGuideTips(bubble);
        }
    }

    public String getCarType() {
        return String.valueOf(FormStore.getInstance().getCarLevel());
    }

    public int getProductId() {
        return BusinessUtils.getCurrentBID(this.f16117b);
    }
}
