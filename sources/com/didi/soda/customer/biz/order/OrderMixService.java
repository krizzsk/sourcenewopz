package com.didi.soda.customer.biz.order;

import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Response;
import com.didi.soda.customer.app.ApplicationForegroundListener;
import com.didi.soda.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.soda.customer.biz.order.OrderMonitorLooper;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;
import com.didi.soda.customer.foundation.push.model.AbsPushModel;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.TypeUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import java.lang.reflect.Type;

public final class OrderMixService {

    /* renamed from: a */
    private static final String f40415a = "OrderMixService";

    /* renamed from: b */
    private static final int f40416b = 1;

    /* renamed from: c */
    private OrderMonitorLooper f40417c;

    /* renamed from: d */
    private int f40418d;

    /* renamed from: e */
    private MessageListener f40419e;

    /* renamed from: f */
    private OrderMonitorLooper.MonitorLooperListener f40420f;

    /* renamed from: g */
    private ApplicationForegroundListener f40421g;

    private OrderMixService() {
        this.f40418d = 30000;
        this.f40419e = new MessageListener() {
            public int getPushKey() {
                return 3793;
            }

            public void onReceive(final Response response) {
                UiHandlerUtil.post(new Runnable() {
                    public void run() {
                        String str = new String(response.getData());
                        LogUtil.m29104i("DPushListenerImp", "data: " + str);
                        try {
                            AbsPushModel absPushModel = (AbsPushModel) GsonUtil.fromJson(str, (Type) new TypeUtil.ParameterizedTypeImpl((Type) null, AbsPushModel.class, OrderInfoEntity.class));
                            if (1 == absPushModel.type) {
                                LogUtil.m29104i(OrderMixService.f40415a, "order status push data,before update repo:" + ((OrderInfoEntity) absPushModel.data).toString());
                                OrderMixService.this.updatePushOrderData((OrderInfoEntity) absPushModel.data);
                            }
                        } catch (Exception e) {
                            LogUtil.m29102e(OrderMixService.f40415a, "pushBody  push_topic:259  convert data Error:" + e.getMessage());
                        }
                    }
                });
            }
        };
        this.f40420f = new OrderMonitorLooper.MonitorLooperListener() {
            public void looperWork() {
                OrderMixService.this.doWork();
            }
        };
        this.f40421g = new ApplicationForegroundListener() {
            public void onBecomeBackground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f40415a).setMessage("ApplicationForegroundListener --> onBecomeBackground").setOtherParam("currentBackgroundTime", Long.valueOf(j)).setOtherParam("lastForegroundTime", Long.valueOf(j2)).build().info();
                OrderMixService.this.pause();
            }

            public void onBecomeForeground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f40415a).setMessage("ApplicationForegroundListener --> onBecomeForeground").setOtherParam("currentForegroundTime", Long.valueOf(j)).setOtherParam("lastBackgroundTime", Long.valueOf(j2)).setOtherParam("isLoopWorking", Boolean.valueOf(OrderMixService.this.isLoopWorking())).build().info();
                if (!OrderMixService.this.isLoopWorking()) {
                    OrderMixService.this.reset();
                }
            }
        };
        m28658a();
    }

    public static OrderMixService getInstance() {
        return InstanceHolder.HOLDER;
    }

    public void setPeriod(int i) {
        this.f40417c.mo102011a(i);
    }

    public boolean isLoopWorking() {
        return this.f40417c.mo102013a();
    }

    public void pause() {
        LogUtil.m29104i(f40415a, "pause");
        this.f40417c.mo102017d();
    }

    public void reset() {
        LogUtil.m29104i(f40415a, "reset");
        this.f40417c.mo102014b();
    }

    public void start() {
        LogUtil.m29104i(f40415a, "start");
        this.f40417c.mo102012a(this.f40420f);
        this.f40417c.mo102011a(this.f40418d);
        this.f40417c.mo102016c();
        LongConnectionProvider.getInstance().registerMessageListener(this.f40419e);
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(this.f40421g);
    }

    public void stop() {
        LogUtil.m29104i(f40415a, "stop");
        this.f40417c.mo102015b(this.f40420f);
        this.f40417c.mo102017d();
        LongConnectionProvider.getInstance().unRegisterMessageListener(this.f40419e);
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(this.f40421g);
    }

    /* access modifiers changed from: protected */
    public void doWork() {
        LogUtil.m29104i(f40415a, "order status looper, doWork()");
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateAllOrdersInMonitor();
    }

    /* access modifiers changed from: protected */
    public void updatePushOrderData(OrderInfoEntity orderInfoEntity) {
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).addOrderEntity2Monitor(orderInfoEntity, 3);
    }

    /* renamed from: a */
    private void m28658a() {
        this.f40417c = new OrderMonitorLooper();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OrderMixService HOLDER = new OrderMixService();

        private InstanceHolder() {
        }
    }
}
