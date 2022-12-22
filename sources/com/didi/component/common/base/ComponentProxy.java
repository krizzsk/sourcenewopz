package com.didi.component.common.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.session.OrderEvent;
import com.didi.travel.psnger.p170v2.session.SessionEvent;

public class ComponentProxy {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11469a = ComponentProxy.class.getSimpleName();
    protected final ComponentCallback mComponentCallback;
    protected BaseEventPublisher.OnEventListener<OrderEvent> mOrderEventListener = new BaseEventPublisher.OnEventListener<OrderEvent>() {
        public void onEvent(String str, OrderEvent orderEvent) {
            String a = ComponentProxy.f11469a;
            StringBuilder sb = new StringBuilder();
            sb.append("Order.onEvent:s = ");
            sb.append(str);
            sb.append(", event = ");
            sb.append(orderEvent);
            sb.append(", mOrderId = ");
            sb.append(TravelUtil.getRichOid(ComponentProxy.this.mOrderId));
            sb.append(", event.getOrderId = ");
            sb.append(orderEvent == null ? "null" : TravelUtil.getRichOid(orderEvent.getOrderId()));
            sb.append(", mTag = ");
            sb.append(ComponentProxy.this.mTag);
            LogUtils.m31493i(a, sb.toString());
            if (orderEvent == null) {
                LogUtils.m31492e(ComponentProxy.f11469a, "Order.onEvent:event is null");
            } else if (orderEvent.getPageId() != ComponentProxy.this.mComponentCallback.getPageId()) {
                String a2 = ComponentProxy.f11469a;
                LogUtils.m31495w(a2, "Order.onEvent:page not match, curPageId = " + ComponentProxy.this.mComponentCallback.getPageId() + ", event.pageId = " + orderEvent.getPageId());
            } else if (!EventKeys.Session.EVENT_TRAVEL_SDK_UPDATE_ORDER_ID.equals(str)) {
                String a3 = ComponentProxy.f11469a;
                LogUtils.m31492e(a3, "Order.Event:invalid event, s = " + str);
            } else if (TextUtils.equals(ComponentProxy.this.mOrderId, orderEvent.getOrderId())) {
                String a4 = ComponentProxy.f11469a;
                LogUtils.m31492e(a4, "Order.onEvent:order is equals, mOrderId = " + TravelUtil.getRichOid(ComponentProxy.this.mOrderId));
            } else {
                ComponentProxy.this.mComponentCallback.beforeOrderIdUpdate();
                ComponentProxy.this.mOrderId = orderEvent.getOrderId();
                ComponentProxy.this.mComponentCallback.afterOrderIdUpdate();
            }
        }
    };
    protected String mOrderId;
    protected Session mSession;
    protected BaseEventPublisher.OnEventListener<SessionEvent> mSessionListener = new BaseEventPublisher.OnEventListener<SessionEvent>() {
        public void onEvent(String str, SessionEvent sessionEvent) {
            String a = ComponentProxy.f11469a;
            LogUtils.m31493i(a, "Session.onEvent:s = " + str + ", event = " + sessionEvent + ", mSession = " + ComponentProxy.this.mSession + ", mTag = " + ComponentProxy.this.mTag);
            if (sessionEvent == null) {
                LogUtils.m31495w(ComponentProxy.f11469a, "Session.onEvent:event is null");
            } else if (EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_CREATE_SESSION.equals(str)) {
                if (ComponentProxy.this.mComponentCallback.getPageId() != sessionEvent.getPageId()) {
                    String a2 = ComponentProxy.f11469a;
                    LogUtils.m31495w(a2, "Session.onEvent:return create session not match, current page id = " + ComponentProxy.this.mComponentCallback.getPageId() + ", event page id = " + sessionEvent.getPageId());
                    return;
                }
                ComponentProxy.this.mComponentCallback.beforeCreateSession();
                ComponentProxy.this.mSession = TravelSDKV2.getSession(sessionEvent.getSessionKey());
                ComponentProxy.this.mComponentCallback.afterCreateSession();
            } else if (!EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_DESTROY_SESSION.equals(str)) {
                String a3 = ComponentProxy.f11469a;
                LogUtils.m31492e(a3, "Session.onEvent:invalid session event, s = " + str + ", event = " + sessionEvent);
            } else if (ComponentProxy.this.mSession == null) {
                LogUtils.m31492e(ComponentProxy.f11469a, "Session.onEvent : return destroy session, mSession is null");
            } else if (!TextUtils.equals(ComponentProxy.this.mSession.getKey(), sessionEvent.getSessionKey())) {
                String a4 = ComponentProxy.f11469a;
                LogUtils.m31492e(a4, "Session.onEvent : return destroy session not match, current session key = " + ComponentProxy.this.mSession.getKey() + ", event session key = " + sessionEvent.getSessionKey());
            } else {
                if (ComponentProxy.this.mComponentCallback.getPageId() != sessionEvent.getPageId()) {
                    String a5 = ComponentProxy.f11469a;
                    LogUtils.m31495w(a5, "Session.onEvent:return destroy session page not match, cur page id = " + ComponentProxy.this.mComponentCallback.getPageId() + ", event page id = " + sessionEvent.getPageId());
                }
                ComponentProxy.this.mComponentCallback.beforeDestroySession();
                ComponentProxy.this.mSession = null;
                ComponentProxy.this.mComponentCallback.afterDestroySession();
            }
        }
    };
    protected final String mTag;

    public static abstract class ComponentCallback {
        public void afterCreateSession() {
        }

        public void afterDestroySession() {
        }

        public void afterOrderIdUpdate() {
        }

        public void beforeCreateSession() {
        }

        public void beforeDestroySession() {
        }

        public void beforeOrderIdUpdate() {
        }

        public abstract int getPageId();
    }

    public ComponentProxy(ComponentCallback componentCallback, String str) {
        if (componentCallback != null) {
            this.mComponentCallback = componentCallback;
            this.mTag = str;
            return;
        }
        throw new IllegalArgumentException(f11469a + ".new:callback is null");
    }

    public String getTag() {
        return this.mTag;
    }

    public int getPageId() {
        return this.mComponentCallback.getPageId();
    }

    public Session getSession() {
        return this.mSession;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public CarOrder getCarOrder() {
        if (TextUtils.isEmpty(this.mOrderId)) {
            String str = f11469a;
            LogUtils.m31492e(str, "getCarOrder:mOrderId is empty, tag = " + this.mTag);
            return null;
        }
        String generateCarOrderStoreKey = TravelUtil.generateCarOrderStoreKey(this.mOrderId);
        Store store = Store.getStore(generateCarOrderStoreKey);
        if (store != null) {
            return (CarOrder) store.getData();
        }
        String str2 = f11469a;
        LogUtils.m31492e(str2, "getCarOrder:store is null, storeKey = " + generateCarOrderStoreKey + ", tag = " + this.mTag);
        return null;
    }

    public Bundle getBundle() {
        if (this.mSession == null && TextUtils.isEmpty(this.mOrderId)) {
            return null;
        }
        Bundle bundle = new Bundle();
        Session session = this.mSession;
        if (session != null) {
            bundle.putString(TravelConstant.EXTRA_SESSION_KEY, session.getKey());
        }
        if (!TextUtils.isEmpty(this.mOrderId)) {
            bundle.putString(TravelConstant.EXTRA_ORDER_ID, this.mOrderId);
        }
        return bundle;
    }

    public void createSession(String str) {
        String str2 = f11469a;
        StringBuilder sb = new StringBuilder();
        sb.append("createSession: tag = ");
        sb.append(str);
        sb.append(", mSessionKey = ");
        Session session = this.mSession;
        sb.append(session == null ? "" : session.getKey());
        sb.append(", mTag = ");
        sb.append(this.mTag);
        LogUtils.m31493i(str2, sb.toString());
        BaseEventPublisher.getPublisher().publishSync(EventKeys.Session.EVENT_TRAVEL_SDK_CREATE_SESSION, new SessionEvent(this.mComponentCallback.getPageId(), str, ""));
    }

    public void destroySession() {
        String str = f11469a;
        LogUtils.m31493i(str, "destroySession: mTag = " + this.mTag);
        if (this.mSession == null) {
            LogUtils.m31492e(f11469a, "destroySession:mSession = null");
            return;
        }
        BaseEventPublisher.getPublisher().publishSync(EventKeys.Session.EVENT_TRAVEL_SDK_DESTROY_SESSION, new SessionEvent(this.mComponentCallback.getPageId(), this.mSession.getTag(), this.mSession.getKey()));
    }

    public void updateOrderId(int i, String str) {
        String str2 = f11469a;
        LogUtils.m31493i(str2, "updateOrderId:pageId = " + i + ", orderId = " + TravelUtil.getRichOid(str) + ", mTag = " + this.mTag);
        StringBuilder sb = new StringBuilder();
        sb.append(f11469a);
        sb.append(".");
        sb.append(this.mTag);
        TravelUtil.checkAndStoreOid(str, sb.toString());
        TravelUtil.updateOrderId(i, str);
    }

    public void onAdd(Bundle bundle) {
        String str = f11469a;
        LogUtils.m31493i(str, "onAdd: bundle = " + bundle + ", mTag = " + this.mTag);
        if (bundle != null) {
            String string = bundle.getString(TravelConstant.EXTRA_SESSION_KEY);
            if (TextUtils.isEmpty(string)) {
                this.mSession = null;
            } else {
                this.mSession = TravelSDKV2.getSession(string);
            }
            this.mOrderId = bundle.getString(TravelConstant.EXTRA_ORDER_ID);
            String str2 = f11469a;
            LogUtils.m31493i(str2, "onAttach : sessionKey = " + string + ", orderId = " + TravelUtil.getRichOid(this.mOrderId) + ", mTag = " + this.mTag);
            BaseEventPublisher.getPublisher().subscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_CREATE_SESSION, this.mSessionListener);
            BaseEventPublisher.getPublisher().subscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_DESTROY_SESSION, this.mSessionListener);
            BaseEventPublisher.getPublisher().subscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_UPDATE_ORDER_ID, this.mOrderEventListener);
        }
    }

    public void onRemove() {
        String str = f11469a;
        LogUtils.m31493i(str, "onRemove:mSession = " + this.mSession + ", mOrderId = " + TravelUtil.getRichOid(this.mOrderId) + ", mTag = " + this.mTag);
        this.mSession = null;
        this.mOrderId = "";
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_CREATE_SESSION, this.mSessionListener);
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_DESTROY_SESSION, this.mSessionListener);
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_UPDATE_ORDER_ID, this.mOrderEventListener);
    }
}
