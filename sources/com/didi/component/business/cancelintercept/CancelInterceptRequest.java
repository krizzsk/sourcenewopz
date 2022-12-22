package com.didi.component.business.cancelintercept;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.bizconfig.BizConfigFacade;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.RPCServiceWrapper;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.common.net.host.HostGroupManager;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.host.HostManager;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.taxis99.R;
import java.util.Map;

public class CancelInterceptRequest extends BaseRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f11176a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private final String f11177b = HostManager.SHARE_PATH_BIZ_V1;

    /* renamed from: c */
    private ICancelIntercept f11178c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f11179d;

    /* renamed from: e */
    private final HttpRpcClient f11180e;

    /* renamed from: f */
    private Object f11181f;

    public CancelInterceptRequest(Context context) {
        this.f11179d = context.getApplicationContext();
        RpcServiceFactory rpcServiceFactory = new RpcServiceFactory(context);
        this.f11178c = (ICancelIntercept) RPCServiceWrapper.wrap(this.f11179d, (ICancelIntercept) rpcServiceFactory.newRpcService(ICancelIntercept.class, HostGroupManager.getInstance().getDiDiBizHost() + HostManager.SHARE_PATH_BIZ_V1));
        this.f11180e = (HttpRpcClient) rpcServiceFactory.getRpcClient("http");
    }

    public void loadOrderDetailAndJump(final ComponentParams componentParams, String str, final ResponseListener<CarOrder> responseListener) {
        if (componentParams != null) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order == null) {
                if (responseListener != null) {
                    responseListener.onFinish(CarOrderHelper.getOrder());
                }
            } else if (GlobalApolloUtil.canJumpPageByCancelIntercept()) {
                if (!TextUtils.isEmpty(str)) {
                    if (GlobalApolloUtil.canJumpPageByCancelInterceptAssignment()) {
                        order.oid = str;
                        CarOrderHelper.saveOrder(order);
                        CarOrderHelper.setReassignOid(str);
                        TravelUtil.updateOrderId(componentParams.pageID, order.oid);
                    } else {
                        return;
                    }
                }
                final String str2 = order.oid;
                TravelUtil.getOrderDetail((Session) null, str2, new ITravelOrderListener() {
                    public void onSuccess(ICarOrder iCarOrder) {
                        Logger a = CancelInterceptRequest.this.f11176a;
                        a.info("CancelInterceptRequest#loadOrderDetailAndJump onSuccess " + iCarOrder, new Object[0]);
                        CarOrder carOrder = (CarOrder) iCarOrder;
                        CancelInterceptRequest.this.m7604a(carOrder, componentParams.bid, str2, componentParams.bizCtx);
                        ResponseListener responseListener = responseListener;
                        if (responseListener != null) {
                            responseListener.onSuccess(carOrder);
                            responseListener.onFinish(carOrder);
                        }
                        CarOrderHelper.setReassignOid("");
                    }

                    public void onError(int i, String str) {
                        Logger a = CancelInterceptRequest.this.f11176a;
                        a.info("CancelInterceptRequest#loadOrderDetailAndJump onError " + i + ":" + str, new Object[0]);
                        ResponseListener responseListener = responseListener;
                        if (responseListener != null) {
                            responseListener.onError(CarOrderHelper.getOrder());
                            responseListener.onFinish(CarOrderHelper.getOrder());
                        }
                        CarOrderHelper.setReassignOid("");
                        ToastHelper.showShortInfo(CancelInterceptRequest.this.f11179d, (int) R.string.car_get_order_detail_fail);
                    }

                    public void onFail(int i, String str) {
                        Logger a = CancelInterceptRequest.this.f11176a;
                        a.info("CancelInterceptRequest#loadOrderDetailAndJump onFail " + i + ":" + str, new Object[0]);
                        ResponseListener responseListener = responseListener;
                        if (responseListener != null) {
                            responseListener.onFail(CarOrderHelper.getOrder());
                            responseListener.onFinish(CarOrderHelper.getOrder());
                        }
                        CarOrderHelper.setReassignOid("");
                        ToastHelper.showShortInfo(CancelInterceptRequest.this.f11179d, (int) R.string.car_get_order_detail_fail);
                    }

                    public void onTimeout(String str) {
                        Logger a = CancelInterceptRequest.this.f11176a;
                        a.info("CancelInterceptRequest#loadOrderDetailAndJump onTimeout " + str, new Object[0]);
                        CarOrderHelper.setReassignOid("");
                        if (!TextUtils.isEmpty(str)) {
                            ToastHelper.showShortInfo(CancelInterceptRequest.this.f11179d, str);
                        } else {
                            ToastHelper.showShortInfo(CancelInterceptRequest.this.f11179d, (int) R.string.car_get_order_detail_fail);
                        }
                    }
                });
            }
        } else if (responseListener != null) {
            responseListener.onFinish(CarOrderHelper.getOrder());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7604a(CarOrder carOrder, int i, String str, BusinessContext businessContext) {
        if (carOrder == null) {
            Context context = this.f11179d;
            ToastHelper.showShortInfo(context, ResourcesHelper.getString(context, R.string.global_history_order_error));
        } else if (businessContext != null) {
            FormStore.getInstance().setStartAddress(carOrder.startAddress);
            FormStore.getInstance().setEndAddress(carOrder.endAddress);
            GlobalOmegaUtils.setOrderType(carOrder.orderType);
            Bundle bundle = new Bundle();
            if (i > 0) {
                bundle.putInt(BaseExtras.Common.EXTRA_CURRENT_BID, i);
            }
            bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
            bundle.putInt(BaseExtras.Common.EXTRA_CURRENT_COMBOTYPE, carOrder.comboType);
            bundle.putInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 2);
            carOrder.orderSource = 2;
            DDTravelOrderStore.setOrder(carOrder);
            bundle.putBoolean(INavigation.BUNDLE_KEY_ALLOW_COVER_PAGE, !TextUtils.isEmpty(str));
            BizConfigFacade instance = BizConfigFacade.getInstance();
            instance.doubleCheckBizConfig(businessContext, i + "");
            Logger logger = this.f11176a;
            logger.info("CancelInterceptRequest#onOrderDetailGot jumppage and the status is :" + carOrder.status, new Object[0]);
            switch (carOrder.status) {
                case 1:
                case 4:
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, new CancelInterceptJumpEvent(1010, bundle));
                    return;
                case 2:
                case 6:
                    if (6002 == carOrder.substatus) {
                        bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
                    }
                    bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
                    bundle.putBoolean(BaseExtras.EndService.EXTRA_CANCEL_INTERCEPT_JUMP, true);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, new CancelInterceptJumpEvent(1015, bundle));
                    return;
                case 3:
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
                    if (2001 == carOrder.substatus) {
                        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_DETAIL, true);
                    } else {
                        bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 1);
                    }
                    bundle.putBoolean(BaseExtras.EndService.EXTRA_CANCEL_INTERCEPT_JUMP, true);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, new CancelInterceptJumpEvent(1015, bundle));
                    NotificationUtils.getInstance(this.f11179d).hideNotification();
                    return;
                case 5:
                    bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
                    if (5001 == carOrder.substatus) {
                        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_DETAIL, true);
                    } else {
                        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
                    }
                    bundle.putBoolean(BaseExtras.EndService.EXTRA_CANCEL_INTERCEPT_JUMP, true);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, new CancelInterceptJumpEvent(1015, bundle));
                    return;
                case 7:
                    bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
                    if (7005 == carOrder.substatus || 7003 == carOrder.substatus || 7007 == carOrder.substatus || 7008 == carOrder.substatus || 7004 == carOrder.substatus) {
                        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, new CancelInterceptJumpEvent(1025, bundle));
                        return;
                    }
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, new CancelInterceptJumpEvent(1005, bundle));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private String m7602a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder(str);
        boolean z = true;
        for (String next : map.keySet()) {
            if (!(next == null || map.get(next) == null)) {
                if (z) {
                    z = false;
                    sb.append("?");
                } else {
                    sb.append(ParamKeys.SIGN_AND);
                }
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
            }
        }
        return sb.toString();
    }
}
