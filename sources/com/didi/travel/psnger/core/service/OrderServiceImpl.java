package com.didi.travel.psnger.core.service;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.BaseCancelOrderParams;
import com.didi.travel.psnger.core.model.request.BaseCancelTripParams;
import com.didi.travel.psnger.core.model.request.BaseOrderDetailParams;
import com.didi.travel.psnger.core.model.request.BaseOrderParams;
import com.didi.travel.psnger.core.model.request.OrderStatusParams;
import com.didi.travel.psnger.core.model.response.ICancelOrder;
import com.didi.travel.psnger.core.model.response.ICarCancelTrip;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.core.order.AbsOrderService;
import com.didi.travel.psnger.core.order.OrderService;
import com.didi.travel.psnger.model.response.DTSDKShareCouponModel;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.utils.OrderStatusOmegaEvent;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({OrderService.class})
public class OrderServiceImpl extends AbsOrderService {
    public void createOrder(Context context, BaseOrderParams baseOrderParams, ResponseListener<? extends ICarOrder> responseListener) {
        CoreHttpRequest.createOrder(context, baseOrderParams.getParams(), responseListener);
    }

    public void cancelOrder(Context context, BaseCancelOrderParams baseCancelOrderParams, ResponseListener<? extends ICancelOrder> responseListener) {
        CoreHttpRequest.cancelOrder(context, baseCancelOrderParams.getParams(), responseListener);
    }

    public void cancelTrip(Context context, BaseCancelTripParams baseCancelTripParams, ResponseListener<? extends ICarCancelTrip> responseListener) {
        CoreHttpRequest.cancelTrip(context, baseCancelTripParams.getParams(), responseListener);
    }

    public void getOrderDetail(Context context, BaseOrderDetailParams baseOrderDetailParams, ITravelOrderListener iTravelOrderListener) {
        CoreHttpRequest.getOrderDetail(context, baseOrderDetailParams, iTravelOrderListener);
    }

    public void getEndServiceShareInfo(Context context, String str, ResponseListener<DTSDKShareCouponModel> responseListener) {
        CoreHttpRequest.getEndServiceShareInfo(context, str, responseListener);
    }

    public void getOrderStatus(Context context, OrderStatusParams orderStatusParams, ResponseListener<? extends IOrderStatus> responseListener) {
        CoreHttpRequest.getOrderStatus(context, orderStatusParams, responseListener);
    }

    public void getOnServiceRealtimePrice(Context context, String str, ResponseListener<OrderRealtimePriceCount> responseListener) {
        CoreHttpRequest.getOnServiceRealtimePrice(context, str, responseListener);
    }

    /* access modifiers changed from: protected */
    public long pollingIntervalMills() {
        return (long) (DDTravelConfigStore.getInstance().getOrderStatusIntervalTime() * 1000);
    }

    public void startOrderService(boolean z) {
        super.startOrderService(z);
        OrderStatusOmegaEvent.orderStatusOmegaTrace("tech_pax_order_status_start", false);
    }

    public void stopOrderService() {
        super.stopOrderService();
        OrderStatusOmegaEvent.orderStatusOmegaTrace("tech_pax_order_status_finish", false);
    }
}
