package com.didi.travel.psnger.core.order;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.listener.IDiDiMatchInfoCallback;
import com.didi.travel.psnger.core.model.request.BaseCancelOrderParams;
import com.didi.travel.psnger.core.model.request.BaseCancelTripParams;
import com.didi.travel.psnger.core.model.request.BaseOrderDetailParams;
import com.didi.travel.psnger.core.model.request.BaseOrderParams;
import com.didi.travel.psnger.core.model.request.OrderStatusParams;
import com.didi.travel.psnger.core.model.response.ICancelOrder;
import com.didi.travel.psnger.core.model.response.ICarCancelTrip;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.response.DTSDKShareCouponModel;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;

public interface OrderService {
    void addOrderPushCallback(IDiDiCoreCallback iDiDiCoreCallback);

    void addOrderServiceCallback(IDiDiCoreCallback iDiDiCoreCallback);

    void cancelOrder(Context context, BaseCancelOrderParams baseCancelOrderParams, ResponseListener<? extends ICancelOrder> responseListener);

    void cancelTrip(Context context, BaseCancelTripParams baseCancelTripParams, ResponseListener<? extends ICarCancelTrip> responseListener);

    void createOrder(Context context, BaseOrderParams baseOrderParams, ResponseListener<? extends ICarOrder> responseListener);

    void getEndServiceShareInfo(Context context, String str, ResponseListener<DTSDKShareCouponModel> responseListener);

    void getOnServiceRealtimePrice(Context context, String str, ResponseListener<OrderRealtimePriceCount> responseListener);

    void getOrderDetail(Context context, BaseOrderDetailParams baseOrderDetailParams, ITravelOrderListener iTravelOrderListener);

    OrderPollingManager getOrderPollingManager();

    void getOrderStatus(Context context, OrderStatusParams orderStatusParams, ResponseListener<? extends IOrderStatus> responseListener);

    void registerPush();

    void removeOrderPushCallback(IDiDiCoreCallback iDiDiCoreCallback);

    void removeOrderServiceCallback(IDiDiCoreCallback iDiDiCoreCallback);

    void setMatchInfoCallback(IDiDiMatchInfoCallback iDiDiMatchInfoCallback);

    void startOrderService(boolean z);

    void stopOrderService();

    void unregisterPush();
}
