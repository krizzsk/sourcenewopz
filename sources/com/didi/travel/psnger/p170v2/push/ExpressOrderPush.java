package com.didi.travel.psnger.p170v2.push;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.push.PushCallBackListener;
import com.didi.travel.psnger.common.push.PushCenter;
import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.log.LogOutput;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didi.travel.psnger.utils.UIThreadHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.didi.travel.psnger.v2.push.ExpressOrderPush */
public class ExpressOrderPush {
    public static final int COMMON_RECOMMEND_TYPE_ORDER_STATUS = 101;
    public static final String DIDI_TRAVEL_EVENT_PUSH_ORDER_STATUS = "didi_travel_event_push_order_status";

    /* renamed from: a */
    private static final String f44273a = ExpressOrderPush.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ArraySet<IDiDiCoreCallback> f44274b = new ArraySet<>(2);

    /* renamed from: c */
    private boolean f44275c = false;

    public void addCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        this.f44274b.add(iDiDiCoreCallback);
    }

    public void removeCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        this.f44274b.remove(iDiDiCoreCallback);
    }

    public synchronized void registerPushListener() {
        if (!this.f44275c) {
            PushCenter.registerCommonMessageListener(new PushCenter.CommonMessageListener() {
                public void onMessageReceived(final int i, final String str) {
                    LogUtil.m31432fi("OrderPushManager mCommonMsgListener recommendType=" + i + " recommendMessage=" + str);
                    if (i == 101) {
                        ICarOrder order = DDTravelOrderStore.getOrder();
                        DTSDKOrderStatus dTSDKOrderStatus = new DTSDKOrderStatus();
                        dTSDKOrderStatus.parseRecommendMsg(str);
                        if (order == null) {
                            ExpressOrderPush.sendOrderStatusEvent(TravelUtil.getScene(1007), dTSDKOrderStatus);
                        } else if (TextUtils.equals(dTSDKOrderStatus.oid(), order.getOid())) {
                            ExpressOrderPush.sendOrderStatusEvent(TravelUtil.getScene(1007), dTSDKOrderStatus);
                        }
                        ExpressOrderPush.this.m31472a(order, dTSDKOrderStatus);
                    } else if (i == 17) {
                        ExpressOrderPush.this.m31471a(i, str);
                    } else {
                        UiThreadHandler.postOnceDelayed(new Runnable() {
                            public void run() {
                                ExpressOrderPush.this.m31471a(i, str);
                            }
                        }, 2000);
                    }
                }
            });
            PushCenter.registerOrderRealtimePriceCountListener(new PushCallBackListener<OrderRealtimePriceCount>() {
                public void onReceive(final OrderRealtimePriceCount orderRealtimePriceCount) {
                    LogUtil.m31432fi("OrderPushManager mRealtimePriceCountListener " + LogOutput.showOutputLog(orderRealtimePriceCount, ""));
                    ICarOrder order = DDTravelOrderStore.getOrder();
                    if (order != null && !TextUtils.isEmpty(order.getOid()) && orderRealtimePriceCount != null && order.getOid().equals(orderRealtimePriceCount.oid)) {
                        if (4 == order.getStatus() && 4006 != order.getSubStatus()) {
                            final DTSDKOrderStatus dTSDKOrderStatus = (DTSDKOrderStatus) order.getOrderStatus();
                            if (dTSDKOrderStatus == null) {
                                dTSDKOrderStatus = new DTSDKOrderStatus();
                                dTSDKOrderStatus.setOid(orderRealtimePriceCount.oid);
                            }
                            dTSDKOrderStatus.setStatus(4);
                            dTSDKOrderStatus.setSubStatus(4006);
                            ExpressOrderPush.sendOrderStatusEvent(TravelUtil.getScene(1007), dTSDKOrderStatus);
                            UIThreadHandler.post(new Runnable() {
                                public void run() {
                                    if (ExpressOrderPush.this.f44274b != null) {
                                        Iterator it = ExpressOrderPush.this.f44274b.iterator();
                                        while (it.hasNext()) {
                                            IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                                            if (iDiDiCoreCallback != null) {
                                                iDiDiCoreCallback.onOrderStatusChange(dTSDKOrderStatus);
                                            }
                                        }
                                    }
                                }
                            });
                        }
                        order.setRealtimePriceCount(orderRealtimePriceCount);
                        UIThreadHandler.post(new Runnable() {
                            public void run() {
                                if (ExpressOrderPush.this.f44274b != null) {
                                    Iterator it = ExpressOrderPush.this.f44274b.iterator();
                                    while (it.hasNext()) {
                                        IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                                        if (iDiDiCoreCallback != null) {
                                            iDiDiCoreCallback.onRealtimePriceRefresh(orderRealtimePriceCount);
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            });
            PushCenter.registerOrderTotalFeeDetailListener(new PushCallBackListener<NextTotalFeeDetail>() {
                public void onReceive(final NextTotalFeeDetail nextTotalFeeDetail) {
                    LogUtil.m31432fi("OrderPushManager mTotalFeeDetailListener " + LogOutput.showOutputLog(nextTotalFeeDetail, ""));
                    ICarOrder order = DDTravelOrderStore.getOrder();
                    if (order != null && 3 != order.getStatus()) {
                        String oid = order.getOid();
                        if (!TextUtils.isEmpty(oid) && nextTotalFeeDetail != null) {
                            if (TextUtils.isEmpty(oid) || oid.equals(nextTotalFeeDetail.oid)) {
                                UIThreadHandler.post(new Runnable() {
                                    public void run() {
                                        if (ExpressOrderPush.this.f44274b != null) {
                                            Iterator it = ExpressOrderPush.this.f44274b.iterator();
                                            while (it.hasNext()) {
                                                IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                                                if (iDiDiCoreCallback != null) {
                                                    iDiDiCoreCallback.onTotalFeeDetailReceive(nextTotalFeeDetail);
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            });
            PushCenter.registerPayResultMessageListener(new PushCallBackListener<NextPayResult>() {
                public void onReceive(final NextPayResult nextPayResult) {
                    LogUtil.m31432fi("OrderPushManager mPayResultListener " + LogOutput.showOutputLog(nextPayResult, ""));
                    ICarOrder order = DDTravelOrderStore.getOrder();
                    if (order == null) {
                        return;
                    }
                    if (nextPayResult == null || order.getOid().equals(nextPayResult.oid)) {
                        order.setPayResult(nextPayResult);
                        UIThreadHandler.post(new Runnable() {
                            public void run() {
                                if (ExpressOrderPush.this.f44274b != null) {
                                    Iterator it = ExpressOrderPush.this.f44274b.iterator();
                                    while (it.hasNext()) {
                                        IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                                        if (iDiDiCoreCallback != null) {
                                            iDiDiCoreCallback.onPayResultReceive(nextPayResult);
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            });
            this.f44275c = true;
        }
    }

    public synchronized void unregisterPushListener() {
        PushCenter.unregisterCommonMessageListener();
        PushCenter.unregisterOrderRealtimePriceCountListener();
        PushCenter.unregisterOrderTotalFeeDetailListener();
        PushCenter.unregisterPayResultMessageListener();
        this.f44275c = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31471a(final int i, final String str) {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (ExpressOrderPush.this.f44274b != null) {
                    Iterator it = ExpressOrderPush.this.f44274b.iterator();
                    while (it.hasNext()) {
                        IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                        if (iDiDiCoreCallback != null) {
                            iDiDiCoreCallback.onCommonMessageReceive(i, str);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31472a(ICarOrder iCarOrder, DTSDKOrderStatus dTSDKOrderStatus) {
        HashMap hashMap = new HashMap();
        if (iCarOrder != null) {
            hashMap.put("oid", iCarOrder.getOid());
        }
        if (dTSDKOrderStatus != null) {
            hashMap.put("status", Integer.valueOf(dTSDKOrderStatus.status));
            hashMap.put("subStatus", Integer.valueOf(dTSDKOrderStatus.subStatus));
        }
        OmegaUtils.trackEvent("push_order_status", (Map<String, Object>) hashMap);
    }

    public static void sendOrderStatusEvent(Scene scene, DTSDKOrderStatus dTSDKOrderStatus) {
        String str = f44273a;
        LogUtils.m31493i(str, "sendOrderStatusEvent:oid = " + dTSDKOrderStatus.oid + ", orderStatus = " + dTSDKOrderStatus);
        BaseEventPublisher.getPublisher().publishSync(EventKeys.Poll.EVENT_TRAVEL_SDK_ORDER_STATUS_CHANGE_BY_PUSH, dTSDKOrderStatus);
    }
}
