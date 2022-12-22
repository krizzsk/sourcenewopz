package com.didi.component.carpool.info.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.PriceUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.carpool.info.model.CarPoolCardInfo;
import com.didi.component.carpool.info.view.ICarpoolInfoView;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import java.util.Collection;
import org.json.JSONObject;

public class OnServiceCarpoolInfoPresenter extends AbsCarpoolInfoPresenter implements XpNewAdapter {

    /* renamed from: a */
    private IXpCardBindDataReadyCallback f11428a;

    /* renamed from: b */
    private final BusinessContext f11429b;

    /* renamed from: c */
    private CarPoolCardInfo f11430c;

    /* renamed from: d */
    private final BaseEventPublisher.OnEventListener<OrderRealtimePriceCount> f11431d = new BaseEventPublisher.OnEventListener<OrderRealtimePriceCount>() {
        public void onEvent(String str, OrderRealtimePriceCount orderRealtimePriceCount) {
            OnServiceCarpoolInfoPresenter.this.m7748a(orderRealtimePriceCount);
        }
    };

    public void onEditClick() {
    }

    public OnServiceCarpoolInfoPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f11429b = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.OnService.EVENT_REALTIME_TIME_PRICE_COUNT, this.f11431d);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.OnService.EVENT_REALTIME_TIME_PRICE_COUNT, this.f11431d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7748a(OrderRealtimePriceCount orderRealtimePriceCount) {
        String str;
        String str2 = "";
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && orderRealtimePriceCount != null) {
            try {
                str = PriceUtils.getFeeDisplay(this.f11429b, (double) Float.parseFloat(orderRealtimePriceCount.totalFee), orderRealtimePriceCount.totalFeeText, false, PriceUtils.TYPE_REALTIME_TOTAL_FEE);
            } catch (Exception e) {
                e.printStackTrace();
                str = str2;
            }
            DTSDKOrderDetail.PaymentsWayInfo paymentsWayInfo = order.payInfo;
            if (paymentsWayInfo != null && !TextUtils.isEmpty(paymentsWayInfo.text)) {
                str2 = paymentsWayInfo.text;
                if (!TextUtils.isEmpty(paymentsWayInfo.suffix)) {
                    str2 = str2 + " " + paymentsWayInfo.suffix;
                }
            }
            ((ICarpoolInfoView) this.mView).setRealtimeFee(str, str2);
        }
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (jSONObject != null) {
            CarPoolCardInfo carPoolCardInfo = new CarPoolCardInfo();
            this.f11430c = carPoolCardInfo;
            carPoolCardInfo.parse(jSONObject);
            if (!CollectionUtils.isEmpty((Collection) this.f11430c.waitPoints) || !CollectionUtils.isEmpty((Collection) this.f11430c.travelInfoMsgList)) {
                ((ICarpoolInfoView) this.mView).setData(this.f11430c);
                iXpCardBindDataReadyCallback.ready(true);
                return;
            }
            iXpCardBindDataReadyCallback.ready(false);
            return;
        }
        iXpCardBindDataReadyCallback.ready(false);
    }
}
