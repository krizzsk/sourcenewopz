package com.didi.travel.psnger.core.order;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.common.push.PushCallBackListener;
import com.didi.travel.psnger.common.push.PushCenter;
import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.log.LogOutput;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didi.travel.psnger.utils.UIThreadHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OrderPushManager {
    public static final int COMMON_RECOMMEND_TYPE_ORDER_STATUS = 101;
    public static final String DIDI_TRAVEL_EVENT_PUSH_ORDER_STATUS = "didi_travel_event_push_order_status";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArraySet<IDiDiCoreCallback> f44192a = new ArraySet<>(2);

    OrderPushManager() {
    }

    public void addCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        this.f44192a.add(iDiDiCoreCallback);
    }

    public void removeCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        this.f44192a.remove(iDiDiCoreCallback);
    }

    public void registerPushListener() {
        PushCenter.registerCommonMessageListener(new PushCenter.CommonMessageListener() {
            public void onMessageReceived(final int i, final String str) {
                LogUtil.m31432fi("OrderPushManager mCommonMsgListener recommendType=" + i + " recommendMessage=" + str);
                if (i == 101) {
                    ICarOrder order = DDTravelOrderStore.getOrder();
                    DTSDKOrderStatus dTSDKOrderStatus = new DTSDKOrderStatus();
                    dTSDKOrderStatus.parseRecommendMsg(str);
                    if (order == null) {
                        OrderEventManager.m31369a().mo110152a("didi_travel_event_push_order_status", (Object) dTSDKOrderStatus);
                    } else if (TextUtils.equals(dTSDKOrderStatus.oid(), order.getOid())) {
                        OrderEventManager.m31369a().mo110152a("didi_travel_event_push_order_status", (Object) dTSDKOrderStatus);
                    }
                    OrderPushManager.this.m31394a(order, dTSDKOrderStatus);
                } else if (i == 17) {
                    OrderPushManager.this.m31393a(i, str);
                } else {
                    UiThreadHandler.postOnceDelayed(new Runnable() {
                        public void run() {
                            OrderPushManager.this.m31393a(i, str);
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
                        final IOrderStatus orderStatus = order.getOrderStatus();
                        if (orderStatus == null) {
                            orderStatus = new DTSDKOrderStatus();
                            orderStatus.setOid(orderRealtimePriceCount.oid);
                        }
                        orderStatus.setStatus(4);
                        orderStatus.setSubStatus(4006);
                        OrderEventManager.m31369a().mo110152a("didi_travel_event_push_order_status", (Object) orderStatus);
                        UIThreadHandler.post(new Runnable() {
                            public void run() {
                                if (OrderPushManager.this.f44192a != null) {
                                    Iterator it = OrderPushManager.this.f44192a.iterator();
                                    while (it.hasNext()) {
                                        IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                                        if (iDiDiCoreCallback != null) {
                                            iDiDiCoreCallback.onOrderStatusChange(orderStatus);
                                        }
                                    }
                                }
                            }
                        });
                    }
                    order.setRealtimePriceCount(orderRealtimePriceCount);
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            if (OrderPushManager.this.f44192a != null) {
                                Iterator it = OrderPushManager.this.f44192a.iterator();
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
                                    if (OrderPushManager.this.f44192a != null) {
                                        Iterator it = OrderPushManager.this.f44192a.iterator();
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
                            if (OrderPushManager.this.f44192a != null) {
                                Iterator it = OrderPushManager.this.f44192a.iterator();
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
    }

    public void unregisterPushListener() {
        PushCenter.unregisterCommonMessageListener();
        PushCenter.unregisterOrderRealtimePriceCountListener();
        PushCenter.unregisterOrderTotalFeeDetailListener();
        PushCenter.unregisterPayResultMessageListener();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31393a(final int i, final String str) {
        UIThreadHandler.post(new Runnable() {
            public void run() {
                if (OrderPushManager.this.f44192a != null) {
                    Iterator it = OrderPushManager.this.f44192a.iterator();
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
    public void m31394a(ICarOrder iCarOrder, DTSDKOrderStatus dTSDKOrderStatus) {
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

    public static void sendOrderStatusEvent(DTSDKOrderStatus dTSDKOrderStatus) {
        OrderEventManager.m31369a().mo110152a("didi_travel_event_push_order_status", (Object) dTSDKOrderStatus);
    }
}
