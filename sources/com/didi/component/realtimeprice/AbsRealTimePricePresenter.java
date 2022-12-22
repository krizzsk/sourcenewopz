package com.didi.component.realtimeprice;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.PriceUtils;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.realtimeprice.IRealTimePriceView;
import com.didi.component.realtimeprice.model.RealTimePrice;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;

public abstract class AbsRealTimePricePresenter extends AbsLoadingPresenter<IRealTimePriceView> implements IRealTimePriceView.OnActionListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f15247a = false;

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener f15248b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(str, BaseEventKeys.Service.OnService.EVENT_ONSERVICE_REAL_TIME_PRICE_SHOWED)) {
                CarOrder order = CarOrderHelper.getOrder();
                if (order != null && order.payInfo != null) {
                    AbsRealTimePricePresenter.this.decideShowRealPriceNewbieGuide(order.payInfo.isOnlinePay);
                }
            } else if (TextUtils.equals(str, BaseEventKeys.Service.OnService.EVENT_ONSERVICE_FIXED_PRICE_GUIDE_SHOWED)) {
                AbsRealTimePricePresenter.this.m10944b();
            }
        }
    };

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<Integer> f15249c = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (!BaseEventKeys.XPanel.EVENT_TOUCH_SCROLL_STATE.equals(str)) {
                return;
            }
            if (num.intValue() == 2) {
                boolean unused = AbsRealTimePricePresenter.this.f15247a = true;
            } else {
                boolean unused2 = AbsRealTimePricePresenter.this.f15247a = false;
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Address> f15250d = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, Address address) {
            if (BaseEventKeys.OnService.EVENT_MAP_UPDATE_DEST.equals(str) && address != null) {
                ((IRealTimePriceView) AbsRealTimePricePresenter.this.mView).hideOnTripCoupon();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Runnable f15251e = new Runnable() {
        public void run() {
            AbsRealTimePricePresenter.this.doPublish(BaseEventKeys.Service.EVENT_PAY_WAY_GUIDE_SHOW);
        }
    };

    /* renamed from: f */
    private Runnable f15252f = new Runnable() {
        public void run() {
            UiThreadHandler.post(AbsRealTimePricePresenter.this.f15251e);
            ((IRealTimePriceView) AbsRealTimePricePresenter.this.mView).showNewbieGuide(AbsRealTimePricePresenter.this.mContext.getString(R.string.global_real_time_price_newbie_guide));
            GlobalSPUtil.setShowRealPriceNewbieGuideByUser(AbsRealTimePricePresenter.this.mContext, true);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f15253g = new Runnable() {
        public void run() {
            if (AbsRealTimePricePresenter.this.mContext == null) {
                return;
            }
            if (!AbsRealTimePricePresenter.this.f15247a) {
                ((IRealTimePriceView) AbsRealTimePricePresenter.this.mView).showFixedPriceGuidePopup(AbsRealTimePricePresenter.this.getFixedPriceGuideContent());
            } else {
                UiThreadHandler.postOnceDelayed(AbsRealTimePricePresenter.this.f15253g, 1000);
            }
        }
    };

    /* renamed from: h */
    private boolean f15254h;
    protected BusinessContext mBusinessContext;

    public AbsRealTimePricePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
    }

    public void onClickAction() {
        handleAction();
    }

    /* access modifiers changed from: protected */
    public void handleAction() {
        ((IRealTimePriceView) this.mView).hideNewbieGuide();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.OnService.EVENT_ONSERVICE_REAL_TIME_PRICE_SHOWED, this.f15248b);
        subscribe(BaseEventKeys.Service.OnService.EVENT_ONSERVICE_FIXED_PRICE_GUIDE_SHOWED, this.f15248b);
        subscribe(BaseEventKeys.OnService.EVENT_MAP_UPDATE_DEST, this.f15250d);
        subscribe(BaseEventKeys.XPanel.EVENT_TOUCH_SCROLL_STATE, this.f15249c);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.OnService.EVENT_ONSERVICE_REAL_TIME_PRICE_SHOWED, this.f15248b);
        unsubscribe(BaseEventKeys.Service.OnService.EVENT_ONSERVICE_FIXED_PRICE_GUIDE_SHOWED, this.f15248b);
        unsubscribe(BaseEventKeys.OnService.EVENT_MAP_UPDATE_DEST, this.f15250d);
        unsubscribe(BaseEventKeys.XPanel.EVENT_TOUCH_SCROLL_STATE, this.f15249c);
        ((IRealTimePriceView) this.mView).hideNewbieGuide();
        UiThreadHandler.removeCallbacks(this.f15251e);
        UiThreadHandler.removeCallbacks(this.f15252f);
        UiThreadHandler.removeCallbacks(this.f15253g);
    }

    /* access modifiers changed from: protected */
    public void decideShowRealPriceNewbieGuide(boolean z) {
        if (this.mBusinessContext.getCountryInfo() != null) {
            BusinessContext businessContext = this.mBusinessContext;
            if ((businessContext == null || businessContext.getCountryInfo() == null || this.mBusinessContext.getCountryInfo().getCountryId() == 61 || GlobalSPUtil.isShowRealPriceNewbieGuideByUser(this.mContext) || !z) ? false : true) {
                UiThreadHandler.postOnceDelayed(this.f15252f, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10944b() {
        CarOrder order = CarOrderHelper.getOrder();
        boolean z = false;
        boolean z2 = (order == null || order.payInfo == null) ? false : order.payInfo.isOnlinePay;
        if (order == null || !order.isJPFixPrice()) {
            boolean z3 = order != null && order.orderSource == 2;
            BusinessContext businessContext = this.mBusinessContext;
            if (!(businessContext == null || businessContext.getCountryInfo() == null || this.mBusinessContext.getCountryInfo().getCountryId() == 61 || GlobalSPUtil.isShowRealPriceNewbieGuideByUser(this.mContext) || !z2)) {
                z = true;
            }
            int fixedPriceGuildeShownTimeByUser = GlobalSPUtil.getFixedPriceGuildeShownTimeByUser(this.mContext);
            if (!this.f15254h && !z3 && fixedPriceGuildeShownTimeByUser < 3 && !z) {
                this.f15254h = true;
                UiThreadHandler.postOnceDelayed(this.f15253g, 1000);
                GlobalSPUtil.setFixedPriceGuildeShownTimeByUser(this.mContext, fixedPriceGuildeShownTimeByUser + 1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getFixedPriceGuideContent() {
        return this.mContext.getString(R.string.global_fixed_price_guide);
    }

    public String getPrice(RealTimePrice realTimePrice) {
        try {
            return PriceUtils.getFeeDisplay(this.mBusinessContext, (double) Float.parseFloat(realTimePrice.totalPrice), realTimePrice.totalPriceDisplay, PriceUtils.TYPE_REALTIME_TOTAL_FEE);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public String getCurrencyId(BusinessContext businessContext) {
        CarOrder order = CarOrderHelper.getOrder();
        return m10940a((order == null || order.currency == null || TextUtils.isEmpty(order.currency.abbr)) ? "" : order.currency.abbr);
    }

    /* renamed from: a */
    private String m10940a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
