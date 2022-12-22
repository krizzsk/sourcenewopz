package com.didi.component.timepicker.impl.util;

import android.os.Handler;
import android.text.TextUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.timepicker.TimePickerModel;
import com.didi.sdk.componentconfig.ComponentConfigEvent;
import com.didi.sdk.componentconfig.ComponentConfigInfo;
import com.didi.sdk.componentconfig.ComponentStore;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.view.timepicker.TimeStrategy;
import com.didi.travel.psnger.utils.TextUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TimeConfigData {
    public static final int MIS_DELAY = 500;

    /* renamed from: a */
    private TimeConfigParams f16123a;

    /* renamed from: b */
    private ConfigChangeListener f16124b;

    /* renamed from: c */
    private TimeInfo f16125c;

    /* renamed from: d */
    private TimeInfo f16126d;

    /* renamed from: e */
    private Handler f16127e;

    /* renamed from: f */
    private int f16128f;

    /* renamed from: g */
    private Runnable f16129g;

    public interface ConfigChangeListener {
        void configChange(TimePickerModel timePickerModel);
    }

    public TimeConfigData() {
        this.f16127e = new Handler();
        this.f16128f = 500;
        this.f16129g = new Runnable() {
            public void run() {
                TimeConfigData.this.m11828b();
            }
        };
        this.f16123a = new TimeConfigParams();
        this.f16126d = new TimeInfo(3, 15);
        m11826a();
    }

    public TimeConfigData(TimeConfigParams timeConfigParams) {
        this.f16127e = new Handler();
        this.f16128f = 500;
        this.f16129g = new Runnable() {
            public void run() {
                TimeConfigData.this.m11828b();
            }
        };
        this.f16123a = timeConfigParams;
    }

    public void initConfigData() {
        m11826a();
    }

    public void setDefaultTimeInfo(TimeInfo timeInfo) {
        this.f16126d = timeInfo;
    }

    public void setConfigChangeListener(ConfigChangeListener configChangeListener) {
        this.f16124b = configChangeListener;
    }

    public void setCarType(String str) {
        if (this.f16123a == null) {
            this.f16123a = new TimeConfigParams();
        }
        this.f16123a.carType = str;
        m11826a();
    }

    public void setProductId(int i) {
        if (this.f16123a == null) {
            this.f16123a = new TimeConfigParams();
        }
        this.f16123a.productId = i;
        m11826a();
    }

    public void setScene(String str) {
        if (this.f16123a == null) {
            this.f16123a = new TimeConfigParams();
        }
        this.f16123a.sceneType = str;
        m11826a();
    }

    /* renamed from: a */
    private void m11826a() {
        this.f16127e.removeCallbacks(this.f16129g);
        this.f16127e.postDelayed(this.f16129g, (long) this.f16128f);
    }

    public void setDelay(int i) {
        this.f16128f = i;
    }

    @EventReceiver
    public void onReceive(ComponentConfigEvent componentConfigEvent) {
        GLog.m7964d("TimeConfigData onReceive  " + componentConfigEvent);
        if (componentConfigEvent == null || TextUtils.isEmpty(componentConfigEvent.getEvent())) {
            GLog.m7964d("TimeConfigData onReceive event == null or empty");
            return;
        }
        GLog.m7964d("TimeConfigData onReceive  " + componentConfigEvent.getEvent());
        if (ComponentStore.EVENT.equals(componentConfigEvent.getEvent())) {
            m11826a();
        }
    }

    /* renamed from: a */
    private static TimeInfo m11824a(ComponentConfigInfo componentConfigInfo, TimeConfigParams timeConfigParams) {
        JSONObject optJSONObject;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("TimeConfigData processComponentConfig timeConfigParams=");
            sb.append(timeConfigParams != null ? timeConfigParams.toString() : null);
            sb.append(" configInfo=");
            sb.append(componentConfigInfo != null ? componentConfigInfo.data : null);
            GLog.m7964d(sb.toString());
            if (componentConfigInfo != null) {
                if (!TextUtils.isEmpty(componentConfigInfo.data)) {
                    if (!"0".equals(componentConfigInfo.errno)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(componentConfigInfo.data);
                    GLog.m7964d("TimeConfigData processComponentConfig data=" + componentConfigInfo.data);
                    if (timeConfigParams == null || (optJSONObject = jSONObject.optJSONObject("timer")) == null) {
                        return null;
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("" + timeConfigParams.productId);
                    if (optJSONArray == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        TimeInfo timeInfo = new TimeInfo();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        timeInfo.orderType = jSONObject2.optString("order_type");
                        timeInfo.productId = jSONObject2.optInt("product_id");
                        timeInfo.carLevel = jSONObject2.optString("car_level");
                        timeInfo.scence = jSONObject2.optString("scence");
                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                        timeInfo.appointDay = optJSONObject2.optInt("max_apoint_day");
                        timeInfo.advanceMin = optJSONObject2.optInt("min_advance_min");
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("time_span");
                        if (optJSONObject3 != null) {
                            timeInfo.from = optJSONObject3.optInt("from");
                            timeInfo.f16130to = optJSONObject3.optInt("to");
                            if (timeInfo.f16130to == 0) {
                                timeInfo.f16130to = 24;
                            }
                        }
                        arrayList.add(timeInfo);
                    }
                    TimeInfo a = m11825a((List<TimeInfo>) arrayList, timeConfigParams);
                    if (a != null) {
                        GLog.m7964d("TimeConfigData processComponentConfig  " + a);
                    }
                    return a;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static TimeInfo m11825a(List<TimeInfo> list, TimeConfigParams timeConfigParams) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TimeInfo timeInfo = list.get(i);
            if (((TextUtils.isEmpty(timeInfo.scence) && TextUtils.isEmpty(timeConfigParams.sceneType)) || (timeInfo.scence != null && timeInfo.scence.equals(timeConfigParams.sceneType))) && ((TextUtil.isEmpty(timeInfo.carLevel) && TextUtil.isEmpty(timeConfigParams.carType)) || (timeInfo.carLevel != null && timeInfo.carLevel.equals(timeConfigParams.carType)))) {
                return timeInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11828b() {
        TimeInfo a = m11823a(this.f16123a);
        if ((a == null && this.f16125c == null) || (a != null && this.f16125c != null && a.advanceMin == this.f16125c.advanceMin && a.appointDay == this.f16125c.appointDay && a.from == this.f16125c.from && a.f16130to == this.f16125c.f16130to)) {
            GLog.m7964d("TimeConfigData handlerComponent data is not change " + this.f16125c);
            return;
        }
        this.f16125c = a;
        GLog.m7964d("TimeConfigData handlerComponent data " + this.f16125c);
        if (this.f16124b != null) {
            TimePickerModel timePickerModel = null;
            if (this.f16125c != null) {
                timePickerModel = new TimePickerModel();
                timePickerModel.appointmentDay = this.f16125c.appointDay;
                timePickerModel.earliestDelta = this.f16125c.advanceMin;
                timePickerModel.from = this.f16125c.from;
                timePickerModel.f16115to = this.f16125c.f16130to;
            }
            this.f16124b.configChange(timePickerModel);
        }
    }

    /* renamed from: a */
    private static TimeInfo m11823a(TimeConfigParams timeConfigParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("TimeConfigData getComponentConfig ");
        sb.append(timeConfigParams != null ? timeConfigParams.toString() : null);
        GLog.m7964d(sb.toString());
        return m11824a(ComponentStore.getInstance().getComponentInfo(), timeConfigParams);
    }

    public static class TimeInfo {
        int advanceMin;
        int appointDay;
        String carLevel;
        int from = 0;
        String orderType;
        int productId;
        String scence;

        /* renamed from: to */
        int f16130to = 24;

        public TimeInfo(int i, int i2) {
            this.appointDay = i;
            this.advanceMin = i2;
        }

        public TimeInfo(int i, int i2, int i3, int i4) {
            this.appointDay = i;
            this.advanceMin = i2;
            this.from = i3;
            this.f16130to = i4;
        }

        public TimeInfo() {
        }

        public String toString() {
            return "TimeInfo{productId='" + this.productId + '\'' + ", orderType='" + this.orderType + '\'' + ", scence='" + this.scence + '\'' + ", carLevel='" + this.carLevel + '\'' + ", appointDay=" + this.appointDay + ", advanceMin=" + this.advanceMin + ", from=" + this.from + ", to=" + this.f16130to + '}';
        }
    }

    public static class TimeConfigParams {
        public String carType = "0";
        public int productId;
        public String sceneType;

        public TimeConfigParams() {
        }

        public TimeConfigParams(int i, String str, String str2) {
            this.productId = i;
            this.sceneType = str;
            this.carType = str2;
        }

        public String toString() {
            return "TimeConfigParams{productId='" + this.productId + '\'' + ", sceneType='" + this.sceneType + '\'' + ", carType='" + this.carType + '\'' + '}';
        }
    }

    public static boolean checkTimeValidate(long j, TimeConfigParams timeConfigParams, TimeInfo timeInfo, boolean z) {
        TimeStrategy timeStrategy = new TimeStrategy();
        TimeInfo a = m11823a(timeConfigParams);
        if (a != null) {
            timeInfo = a;
        }
        if (timeInfo == null) {
            return false;
        }
        timeStrategy.setAppointmentDay(timeInfo.appointDay);
        timeStrategy.setEarliestDelta(timeInfo.advanceMin);
        timeStrategy.setBeginHourInDay(timeInfo.from);
        timeStrategy.setEndHourInDay(timeInfo.f16130to);
        timeStrategy.setIsSupportNow(z);
        return !timeStrategy.isInvalid(j);
    }

    public static long getLatestAvailableTime(TimeConfigParams timeConfigParams, TimeInfo timeInfo) {
        TimeStrategy timeStrategy = new TimeStrategy();
        TimeInfo a = m11823a(timeConfigParams);
        if (a != null) {
            timeInfo = a;
        }
        GLog.m7964d("TimeConfigData getLatestAvailableTime " + timeInfo);
        if (timeInfo == null) {
            return 0;
        }
        timeStrategy.setAppointmentDay(timeInfo.appointDay);
        timeStrategy.setEarliestDelta(timeInfo.advanceMin);
        timeStrategy.setBeginHourInDay(timeInfo.from);
        timeStrategy.setEndHourInDay(timeInfo.f16130to);
        return timeStrategy.getLatestAvailableTime();
    }
}
