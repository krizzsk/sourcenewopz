package com.didi.component.timepicker;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.timepicker.impl.util.TimeConfigData;
import com.didi.sdk.util.TextUtil;

public abstract class AbsTimePickerPresenter extends BaseExpressPresenter<ITimePickerView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TimeConfigData f16109a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TimePickerModel f16110b;

    /* renamed from: c */
    private TimePickerModel f16111c;

    /* renamed from: d */
    private long f16112d;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16113e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsTimePickerPresenter.this.f16109a != null) {
                AbsTimePickerPresenter.this.f16109a.setCarType(AbsTimePickerPresenter.this.getCarType());
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16114f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsTimePickerPresenter.this.showTimePickerDialog();
        }
    };

    public abstract String getCarType();

    /* access modifiers changed from: protected */
    public abstract TimePickerModel getModel();

    public abstract int getProductId();

    public abstract String getScene();

    public boolean onInterceptModifyDepartTime() {
        return false;
    }

    public void onSimpleTimePickerSelected(int i) {
    }

    public AbsTimePickerPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f16112d = FormStore.getInstance().getTransportTime();
        m11809b();
        ((ITimePickerView) this.mView).getView().postDelayed(new Runnable() {
            public void run() {
                AbsTimePickerPresenter.this.updateConfig();
            }
        }, 600);
        m11811d();
    }

    /* renamed from: b */
    private void m11809b() {
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOOK_TIME_ERROR, this.f16114f);
    }

    /* renamed from: c */
    private void m11810c() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOOK_TIME_ERROR, this.f16114f);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m11810c();
    }

    /* renamed from: d */
    private void m11811d() {
        TimeConfigData timeConfigData = new TimeConfigData(new TimeConfigData.TimeConfigParams(getProductId(), getScene(), getCarType()));
        this.f16109a = timeConfigData;
        timeConfigData.setDelay(500);
        this.f16109a.initConfigData();
        this.f16109a.setConfigChangeListener(new TimeConfigData.ConfigChangeListener() {
            public void configChange(TimePickerModel timePickerModel) {
                TimePickerModel unused = AbsTimePickerPresenter.this.f16110b = timePickerModel;
                AbsTimePickerPresenter.this.updateConfig();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void updateConfig() {
        TimePickerModel model = getModel();
        if (model != null) {
            if (model.model == 0) {
                TimePickerModel timePickerModel = this.f16110b;
                if (timePickerModel != null) {
                    model.appointmentDay = timePickerModel.appointmentDay;
                    model.earliestDelta = this.f16110b.earliestDelta;
                    model.from = this.f16110b.from;
                    model.f16115to = this.f16110b.f16115to;
                }
                if (!m11808a(model.appointmentDay, model.earliestDelta, model.from, model.f16115to, model.isSupportnow)) {
                    model.textContent = "";
                    onTimePickerSelected(0);
                }
            }
            this.f16111c = model;
            m11812e();
        }
    }

    /* renamed from: e */
    private void m11812e() {
        TimePickerModel timePickerModel = this.f16111c;
        if (timePickerModel == null) {
            ((ITimePickerView) this.mView).setLabel("");
        } else if (!TextUtil.isEmpty(timePickerModel.textContent)) {
            ((ITimePickerView) this.mView).setLabel(this.f16111c.textContent);
        } else if (!TextUtil.isEmpty(this.f16111c.hint)) {
            ((ITimePickerView) this.mView).setLabel(this.f16111c.hint);
        }
    }

    /* renamed from: a */
    private boolean m11808a(int i, int i2, int i3, int i4, boolean z) {
        TimeConfigData.TimeConfigParams timeConfigParams = new TimeConfigData.TimeConfigParams();
        timeConfigParams.productId = getProductId();
        timeConfigParams.sceneType = getScene();
        timeConfigParams.carType = getCarType();
        return TimeConfigData.checkTimeValidate(this.f16112d, timeConfigParams, new TimeConfigData.TimeInfo(i, i2, i3, i4), z);
    }

    public void showTimePickerDialog() {
        if (this.f16111c != null) {
            ((ITimePickerView) this.mView).showTimepickerDialog(this.f16111c, this.f16112d);
        } else {
            ((ITimePickerView) this.mView).showTimepickerDialog(getModel(), this.f16112d);
        }
    }

    public void onTimePickerSelected(long j) {
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_time_ck");
        this.f16112d = j;
        if (j > 0) {
            GlobalOmegaUtils.trackEvent("ReservationPage_Enter");
        }
        FormStore.getInstance().setTransportTime(this.f16112d);
        doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_TIME_CHANGED);
        updateConfig();
    }

    /* access modifiers changed from: protected */
    public long getCurrentSelected() {
        return this.f16112d;
    }

    /* access modifiers changed from: protected */
    public void restore() {
        this.f16112d = 0;
    }
}
