package com.didi.entrega.order.pool;

import com.didi.entrega.customer.app.ApplicationForegroundListener;
import com.didi.entrega.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.push.LongConnectionProvider;
import com.didi.entrega.customer.foundation.push.model.AbsPushModel;
import com.didi.entrega.customer.foundation.rpc.entity.order.PushOrderEntity;
import com.didi.entrega.customer.foundation.rpc.net.TypeUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.order.pool.OrderMonitorLooper;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Response;
import java.lang.reflect.Type;

public final class OrderMixService {

    /* renamed from: a */
    private static final String f20916a = "EntregaOrderMixService";

    /* renamed from: c */
    private static final int f20917c = 2;

    /* renamed from: d */
    private static final int f20918d = 30000;

    /* renamed from: b */
    private OrderMonitorLooper f20919b;

    /* renamed from: e */
    private MessageListener f20920e;

    /* renamed from: f */
    private OrderMonitorLooper.MonitorLooperListener f20921f;

    /* renamed from: g */
    private ApplicationForegroundListener f20922g;

    private OrderMixService() {
        this.f20920e = new MessageListener() {
            public int getPushKey() {
                return 3794;
            }

            public void onReceive(final Response response) {
                UiHandlerUtil.post(new Runnable() {
                    public void run() {
                        String str = new String(response.getData());
                        LogUtil.m14765i("DPushListenerImp", "data: " + str);
                        try {
                            AbsPushModel absPushModel = (AbsPushModel) GsonUtil.fromJson(str, (Type) new TypeUtil.ParameterizedTypeImpl((Type) null, AbsPushModel.class, PushOrderEntity.class));
                            if (2 == absPushModel.type) {
                                LogUtil.m14765i(OrderMixService.f20916a, "order status push data,before update repo:" + ((PushOrderEntity) absPushModel.data).toString());
                                ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderInfoById(((PushOrderEntity) absPushModel.data).getOrderId(), 3);
                            }
                        } catch (Exception e) {
                            LogUtil.m14763e(OrderMixService.f20916a, "pushBody  push_topic: order changed,  convert data Error:" + e.getMessage());
                        }
                    }
                });
            }
        };
        this.f20921f = new OrderMonitorLooper.MonitorLooperListener() {
            public void looperWork() {
                OrderMixService.this.doWork();
            }
        };
        this.f20922g = new ApplicationForegroundListener() {
            public void onBecomeBackground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f20916a).setMessage("ApplicationForegroundListener --> onBecomeBackground").setOtherParam("currentBackgroundTime", Long.valueOf(j)).setOtherParam("lastForegroundTime", Long.valueOf(j2)).build().info();
                OrderMixService.this.pause();
            }

            public void onBecomeForeground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f20916a).setMessage("ApplicationForegroundListener --> onBecomeForeground").setOtherParam("currentForegroundTime", Long.valueOf(j)).setOtherParam("lastBackgroundTime", Long.valueOf(j2)).setOtherParam("isLoopWorking", Boolean.valueOf(OrderMixService.this.isLoopWorking())).build().info();
                if (!OrderMixService.this.isLoopWorking()) {
                    OrderMixService.this.reset();
                }
            }
        };
        m15337a();
    }

    public static OrderMixService getInstance() {
        return InstanceHolder.HOLDER;
    }

    public void setPeriod(int i) {
        this.f20919b.mo62468a(i);
    }

    public boolean isLoopWorking() {
        return this.f20919b.mo62470a();
    }

    public void pause() {
        LogUtil.m14765i(f20916a, "pause");
        this.f20919b.mo62474d();
    }

    public void reset() {
        LogUtil.m14765i(f20916a, "reset");
        this.f20919b.mo62471b();
    }

    public void start() {
        LogUtil.m14765i(f20916a, "start");
        this.f20919b.mo62469a(this.f20921f);
        this.f20919b.mo62468a(30000);
        this.f20919b.mo62473c();
        LongConnectionProvider.getInstance().registerMessageListener(this.f20920e);
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(this.f20922g);
    }

    public void stop() {
        LogUtil.m14765i(f20916a, "stop");
        this.f20919b.mo62472b(this.f20921f);
        this.f20919b.mo62474d();
        LongConnectionProvider.getInstance().unRegisterMessageListener(this.f20920e);
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(this.f20922g);
    }

    /* access modifiers changed from: protected */
    public void doWork() {
        LogUtil.m14765i(f20916a, "order status looper, doWork()");
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateAllOrdersInMonitor();
    }

    /* renamed from: a */
    private void m15337a() {
        this.f20919b = new OrderMonitorLooper();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OrderMixService HOLDER = new OrderMixService();

        private InstanceHolder() {
        }
    }
}
