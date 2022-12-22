package com.didi.entrega.customer.biz.sliding;

import android.text.TextUtils;
import com.didi.entrega.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.entrega.customer.biz.order.looper.trigger.TimerTriggerManager;
import com.didi.entrega.customer.biz.sliding.param.OrderStat;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.Clock;
import com.didi.entrega.customer.foundation.rpc.extra.CustomerCommonRpcManager;
import com.didi.entrega.customer.foundation.rpc.sliding.callback.DriverCallback;
import com.didi.entrega.customer.foundation.rpc.sliding.entity.NearDriversEntity;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.NumberParseUtil;
import com.didi.entrega.order.data.model.OrderMapStatusModel;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Response;
import com.didichuxing.carsliding.model.DriverCollection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingLooperService implements ISlidingLooperService {

    /* renamed from: a */
    private static final String f19837a = "SlidingLooperService";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TimerTriggerManager f19838b;

    /* renamed from: c */
    private List<DriverSlidingListener> f19839c = new ArrayList();

    /* renamed from: d */
    private boolean f19840d;

    /* renamed from: e */
    private OrderMapStatusModel f19841e;

    /* renamed from: f */
    private ITriggerManager.TriggerListener f19842f = new ITriggerManager.TriggerListener() {
        public void doLoopWork(String str) {
            SlidingLooperService.this.m14703a();
            SlidingLooperService.this.f19838b.notifyWorkFinish();
        }
    };

    /* renamed from: g */
    private MessageListener f19843g = new MessageListener() {
        public int getPushKey() {
            return 259;
        }

        public void onReceive(Response response) {
            NearDriversEntity parseNearDriver = PushDataParserHelper.parseNearDriver(response.getData());
            if (!(parseNearDriver == null || parseNearDriver.drivers == null || parseNearDriver.drivers.size() <= 0)) {
                SlidingLooperService.this.m14706a(parseNearDriver.drivers);
            }
            LogUtil.m14761d("mPushListener", parseNearDriver.toString());
        }
    };

    public interface DriverSlidingListener {
        void onDriverSlidingChange(DriverCollection driverCollection);
    }

    public SlidingLooperService(int i) {
        TimerTriggerManager timerTriggerManager = new TimerTriggerManager(i);
        this.f19838b = timerTriggerManager;
        timerTriggerManager.setTriggerListener(this.f19842f);
    }

    public void addDriverSlidingListener(DriverSlidingListener driverSlidingListener) {
        if (!this.f19839c.contains(driverSlidingListener)) {
            this.f19839c.add(driverSlidingListener);
        }
    }

    public void removeDriverSlidingListener(DriverSlidingListener driverSlidingListener) {
        this.f19839c.remove(driverSlidingListener);
    }

    public void start(OrderMapStatusModel orderMapStatusModel) {
        this.f19841e = orderMapStatusModel;
        if (!this.f19840d) {
            this.f19840d = true;
            this.f19838b.start();
        }
    }

    public void stop() {
        if (this.f19840d) {
            this.f19840d = false;
            this.f19838b.stop();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14703a() {
        double d;
        OrderMapStatusModel orderMapStatusModel = this.f19841e;
        if (orderMapStatusModel == null || orderMapStatusModel.getMapData() == null || TextUtils.isEmpty(this.f19841e.getMapData().getRiderUid())) {
            LogUtil.m14765i(f19837a, "MapStatus Model is empty");
            return;
        }
        double d2 = 0.0d;
        if (1200 == this.f19841e.getOrderStatus()) {
            d2 = this.f19841e.getMapData().getSenderLat();
            d = this.f19841e.getMapData().getSenderLng();
        } else if (1400 == this.f19841e.getOrderStatus()) {
            d2 = this.f19841e.getMapData().getReceiverLat();
            d = this.f19841e.getMapData().getReceiverLng();
        } else {
            d = 0.0d;
        }
        long parseLong = NumberParseUtil.parseLong(this.f19841e.getMapData().getRiderUid());
        OrderStat orderStat = OrderStat.DeliveryGoods;
        HashMap hashMap = new HashMap();
        hashMap.put("phone_num", CustomerSystemUtil.getLoginPhoneNum());
        hashMap.put("role", 1);
        hashMap.put("token", LoginUtil.getToken());
        hashMap.put("product_id", 602);
        hashMap.put("type", 0);
        hashMap.put("order_stat", Integer.valueOf(orderStat.getValue()));
        hashMap.put("timestamp", Long.valueOf(Clock.timeAtSeconds()));
        hashMap.put("platform", 1);
        hashMap.put("ostype", 2);
        hashMap.put("diverIds", Long.valueOf(parseLong));
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        hashMap.put("passLocPoints", PushDataParserHelper.getLocPointsString(d2, d));
        hashMap.put("pid", LoginUtil.getUid());
        CustomerCommonRpcManager.getInstance().sendLocationCallNearDriversForDriverService(hashMap, new DriverCallback<NearDriversEntity>(new NearDriversEntity()) {
            public void onFailure(IOException iOException) {
                super.onFailure(iOException);
                SlidingLooperService.this.m14706a((DriverCollection) null);
                ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_E_SERVICE_SLIDING_ERROR).addModuleName("order").addErrorType(ErrorTracker.getErrorType(iOException)).addErrorMsg(ErrorTracker.getExceptionMsg(iOException)).build().trackError();
            }

            public void onSuccess(NearDriversEntity nearDriversEntity) {
                if (nearDriversEntity == null || nearDriversEntity.drivers == null || nearDriversEntity.drivers.size() <= 0) {
                    SlidingLooperService.this.m14706a((DriverCollection) null);
                    return;
                }
                LogUtil.m14761d("sendLocationCallNearDriversForDriverService", nearDriversEntity.toString());
                SlidingLooperService.this.m14706a(nearDriversEntity.drivers);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14706a(DriverCollection driverCollection) {
        if (this.f19839c.size() > 0) {
            for (DriverSlidingListener onDriverSlidingChange : this.f19839c) {
                onDriverSlidingChange.onDriverSlidingChange(driverCollection);
            }
        }
    }
}
