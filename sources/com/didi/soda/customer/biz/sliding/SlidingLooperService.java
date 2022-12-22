package com.didi.soda.customer.biz.sliding;

import android.text.TextUtils;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Request;
import com.didi.foundation.sdk.liveconnection.Response;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.soda.customer.biz.order.looper.trigger.TimerTriggerManager;
import com.didi.soda.customer.biz.sliding.p163pb.BinaryMsg;
import com.didi.soda.customer.biz.sliding.p163pb.PassengerDiverLocGetByIdReq;
import com.didi.soda.customer.biz.sliding.param.OrderStat;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusModel;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusRepo;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;
import com.didi.soda.customer.foundation.rpc.Clock;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.OrderData;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.rpc.extra.CustomerCommonRpcManager;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.sliding.callback.DriverCallback;
import com.didi.soda.customer.foundation.rpc.sliding.entity.NearDriversEntity;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didichuxing.carsliding.model.DriverCollection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okio.ByteString;

public class SlidingLooperService implements ISlidingLooperService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TimerTriggerManager f40533a;

    /* renamed from: b */
    private List<DriverSlidingListener> f40534b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f40535c;

    /* renamed from: d */
    private OrderMapStatusModel f40536d;

    /* renamed from: e */
    private ITriggerManager.TriggerListener f40537e = new ITriggerManager.TriggerListener() {
        public void doLoopWork(String str) {
            SlidingLooperService.this.m28782c();
            SlidingLooperService.this.f40533a.notifyWorkFinish();
        }
    };

    /* renamed from: f */
    private MessageListener f40538f = new MessageListener() {
        public int getPushKey() {
            return 259;
        }

        public void onReceive(Response response) {
            NearDriversEntity parseNearDriver = PushDataParserHelper.parseNearDriver(response.getData());
            if (!(parseNearDriver == null || parseNearDriver.drivers == null || parseNearDriver.drivers.size() <= 0)) {
                SlidingLooperService.this.m28778a(parseNearDriver.drivers);
            }
            LogUtil.m29100d("mPushListener", parseNearDriver.toString());
        }
    };

    public interface DriverSlidingListener {
        void onDriverSlidingChange(DriverCollection driverCollection);
    }

    public SlidingLooperService(int i) {
        TimerTriggerManager timerTriggerManager = new TimerTriggerManager(i);
        this.f40533a = timerTriggerManager;
        timerTriggerManager.setTriggerListener(this.f40537e);
    }

    public void addDriverSlidingListener(DriverSlidingListener driverSlidingListener) {
        if (!this.f40534b.contains(driverSlidingListener)) {
            this.f40534b.add(driverSlidingListener);
        }
    }

    public void removeDriverSlidingListener(DriverSlidingListener driverSlidingListener) {
        this.f40534b.remove(driverSlidingListener);
    }

    public void start(OrderMapStatusModel orderMapStatusModel) {
        this.f40536d = orderMapStatusModel;
        if (!this.f40535c) {
            this.f40535c = true;
            this.f40533a.start();
        }
    }

    public void stop() {
        if (this.f40535c) {
            this.f40535c = false;
            this.f40533a.stop();
        }
    }

    /* renamed from: a */
    private boolean m28779a() {
        return LongConnectionProvider.getInstance().isConnected() && GlobalContext.isEmbed();
    }

    /* renamed from: b */
    private void m28781b() {
        OrderMapStatusModel orderMapStatusModel = this.f40536d;
        if (orderMapStatusModel != null && orderMapStatusModel.mMapData != null && !TextUtils.isEmpty(this.f40536d.mMapData.getRiderId())) {
            double userLat = this.f40536d.mMapData.getUserLat();
            double userLng = this.f40536d.mMapData.getUserLng();
            long parseLong = Long.parseLong(this.f40536d.mMapData.getRiderId());
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(parseLong));
            String loginPhoneNum = CustomerSystemUtil.getLoginPhoneNum();
            if (TextUtils.isEmpty(loginPhoneNum)) {
                loginPhoneNum = "";
            }
            PassengerDiverLocGetByIdReq.Builder builder = new PassengerDiverLocGetByIdReq.Builder();
            builder.phone_num(loginPhoneNum);
            builder.role(1);
            OrderStat orderStat = OrderStat.DeliveryGoods;
            builder.lat(Double.valueOf(userLat));
            builder.lng(Double.valueOf(userLng));
            builder.channel(602);
            builder.diverIds(arrayList);
            builder.order_stat(orderStat);
            builder.timestamp(Long.valueOf(Clock.timeAtSeconds()));
            builder.passLocPoints(PushDataParserHelper.getLocPointsList(userLat, userLng));
            byte[] byteArray = builder.build().toByteArray();
            BinaryMsg.Builder builder2 = new BinaryMsg.Builder();
            builder2.type(10);
            builder2.payload(ByteString.m3608of(byteArray, 0, byteArray.length));
            byte[] byteArray2 = builder2.build().toByteArray();
            Request request = new Request();
            request.setMessageType(2049);
            request.setData(byteArray2);
            LongConnectionProvider.getInstance().sendRequest(request);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m28782c() {
        OrderMapStatusModel orderMapStatusModel = this.f40536d;
        if (orderMapStatusModel != null && orderMapStatusModel.mMapData != null && !TextUtils.isEmpty(this.f40536d.getOrderId()) && !TextUtils.isEmpty(this.f40536d.mMapData.getRiderId())) {
            double userLat = this.f40536d.mMapData.getUserLat();
            double userLng = this.f40536d.mMapData.getUserLng();
            long parseLong = Long.parseLong(this.f40536d.mMapData.getRiderId());
            OrderStat orderStat = OrderStat.DeliveryGoods;
            HashMap hashMap = new HashMap();
            hashMap.put("diverIds", Long.valueOf(parseLong));
            hashMap.put("phone_num", CustomerSystemUtil.getLoginPhoneNum());
            hashMap.put("role", 1);
            hashMap.put("token", LoginUtil.getToken());
            hashMap.put("lat", Double.valueOf(userLat));
            hashMap.put("lng", Double.valueOf(userLng));
            hashMap.put("product_id", 602);
            hashMap.put("type", 0);
            hashMap.put("order_stat", Integer.valueOf(orderStat.getValue()));
            hashMap.put("timestamp", Long.valueOf(Clock.timeAtSeconds()));
            hashMap.put("platform", 1);
            hashMap.put("ostype", 2);
            hashMap.put("passLocPoints", PushDataParserHelper.getLocPointsString(userLat, userLng));
            hashMap.put("pid", LoginUtil.getUid());
            m28784d();
            CustomerCommonRpcManager.getInstance().sendLocationCallNearDriversForDriverService(hashMap, new DriverCallback<NearDriversEntity>(new NearDriversEntity()) {
                public void onFailure(IOException iOException) {
                    super.onFailure(iOException);
                    ErrorTracker.create(ErrorConst.ErrorName.TECH_C_SERVICE_API_SLIDING_ERROR).addModuleName("order").addErrorType(ErrorTracker.getErrorType(iOException)).addErrorMsg(ErrorTracker.getExceptionMsg(iOException)).build().trackError();
                }

                public void onSuccess(NearDriversEntity nearDriversEntity) {
                    if (nearDriversEntity != null && nearDriversEntity.drivers != null && nearDriversEntity.drivers.size() > 0) {
                        LogUtil.m29100d("sendLocationCallNearDriversForDriverService", nearDriversEntity.toString());
                        SlidingLooperService.this.m28778a(nearDriversEntity.drivers);
                    }
                }
            });
        }
    }

    /* renamed from: d */
    private void m28784d() {
        OrderMapStatusModel orderMapStatusModel = this.f40536d;
        if (orderMapStatusModel == null) {
            return;
        }
        if (orderMapStatusModel.getOrderStatus() == 400 || OrderMapUtil.needShowRiderForBusinessPrepare(this.f40536d)) {
            CustomerRpcManagerProxy.get().getOrderMapInfo(this.f40536d.getOrderId(), new CustomerRpcCallback<OrderLayoutEntity>() {
                public void onRpcSuccess(OrderLayoutEntity orderLayoutEntity, long j) {
                    if (orderLayoutEntity != null && SlidingLooperService.this.f40535c) {
                        SlidingLooperService.this.m28777a(orderLayoutEntity.getOrderData());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28777a(OrderData orderData) {
        if (orderData == null) {
            return;
        }
        if (orderData.getStatus() == 400 || orderData.getStatus() == 200 || orderData.getStatus() == 300) {
            ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).setValue(new OrderMapStatusModel(orderData.getOrderId(), orderData.getStatus(), orderData.getDeliveryType(), orderData.getBusinessMode(), orderData.getMapData(), orderData.getCeta21AB(), orderData.getShowDeliveryStatus(), orderData.getBusinessMode()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28778a(DriverCollection driverCollection) {
        if (this.f40534b.size() > 0) {
            for (DriverSlidingListener onDriverSlidingChange : this.f40534b) {
                onDriverSlidingChange.onDriverSlidingChange(driverCollection);
            }
        }
    }
}
