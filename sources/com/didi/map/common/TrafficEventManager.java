package com.didi.map.common;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrafficEventManager {

    /* renamed from: b */
    private static final String f24659b = "traffic_event_preferences";

    /* renamed from: c */
    private static final String f24660c = "traffic_event_self";

    /* renamed from: d */
    private static volatile TrafficEventManager f24661d = null;

    /* renamed from: h */
    private static final int f24662h = 600000;

    /* renamed from: a */
    boolean f24663a = true;

    /* renamed from: e */
    private List<TrafficEventObserver> f24664e = new ArrayList();

    /* renamed from: f */
    private Timer f24665f = null;

    /* renamed from: g */
    private TimerTask f24666g = null;

    /* renamed from: i */
    private HashSet<Long> f24667i = new HashSet<>();

    public static TrafficEventManager getInstance() {
        if (f24661d == null) {
            synchronized (TrafficEventManager.class) {
                if (f24661d == null) {
                    f24661d = new TrafficEventManager();
                }
            }
        }
        return f24661d;
    }

    private TrafficEventManager() {
    }

    public synchronized void addObserver(TrafficEventObserver trafficEventObserver) {
        this.f24664e.add(0, trafficEventObserver);
    }

    public synchronized void delObserver(TrafficEventObserver trafficEventObserver) {
        this.f24664e.remove(trafficEventObserver);
    }

    public synchronized void notifyObservers() {
        for (TrafficEventObserver next : this.f24664e) {
            if (this.f24663a) {
                next.showLocalTrafficIcon();
            }
        }
    }

    public synchronized void reportTrafficEvent(int i, long j, LatLng latLng) {
        HWLog.m16761i("traffic_event", "type=" + i + ",eventId=" + j);
        this.f24667i.add(Long.valueOf(j));
        startTimer();
        if (!(MapUtil.m_Context == null || latLng == null)) {
            TrafficEventModel trafficEventModel = new TrafficEventModel();
            trafficEventModel.event_id = j;
            trafficEventModel.event_lat = latLng.latitude;
            trafficEventModel.event_lng = latLng.longitude;
            trafficEventModel.event_priority = 1;
            trafficEventModel.event_time = System.currentTimeMillis();
            trafficEventModel.event_type = i;
            List<TrafficEventModel> a = m17558a();
            a.add(trafficEventModel);
            m17559a(a);
            setChanged(true);
        }
        notifyObservers();
    }

    public synchronized void clearLocalTrafficIcon(DidiMap didiMap) {
        if (didiMap != null) {
            didiMap.updateLocalTrafficIcon(new TrafficEventModel[0]);
        }
    }

    class MyTimerTask extends TimerTask {
        MyTimerTask() {
        }

        public void run() {
            TrafficEventManager.this.updateReportTraffic();
        }
    }

    public synchronized void updateReportTraffic() {
        List<TrafficEventModel> a = m17558a();
        m17560b(a);
        if (this.f24663a) {
            m17559a(a);
            notifyObservers();
        }
    }

    /* renamed from: a */
    private List<TrafficEventModel> m17558a() {
        ArrayList arrayList = new ArrayList();
        if (MapUtil.m_Context != null) {
            String string = SystemUtils.getSharedPreferences(MapUtil.m_Context, f24659b, 0).getString(f24660c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            TrafficEventModel trafficEventModel = new TrafficEventModel();
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject != null) {
                                trafficEventModel.event_id = jSONObject.optLong(ParamKeys.PARAM_EVENT_ID);
                                trafficEventModel.event_time = jSONObject.optLong("event_time");
                                trafficEventModel.event_lat = jSONObject.optDouble("event_lat");
                                trafficEventModel.event_lng = jSONObject.optDouble("event_lng");
                                trafficEventModel.event_priority = jSONObject.optInt("event_priority");
                                trafficEventModel.event_type = jSONObject.optInt("event_type");
                                arrayList.add(trafficEventModel);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m17559a(List<TrafficEventModel> list) {
        String str;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                TrafficEventModel trafficEventModel = list.get(i);
                if (trafficEventModel != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ParamKeys.PARAM_EVENT_ID, trafficEventModel.event_id);
                        jSONObject.put("event_time", trafficEventModel.event_time);
                        jSONObject.put("event_lat", trafficEventModel.event_lat);
                        jSONObject.put("event_lng", trafficEventModel.event_lng);
                        jSONObject.put("event_priority", trafficEventModel.event_priority);
                        jSONObject.put("event_type", trafficEventModel.event_type);
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            str = jSONArray.toString();
        }
        if (MapUtil.m_Context != null) {
            SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(MapUtil.m_Context, f24659b, 0).edit();
            edit.putString(f24660c, str);
            edit.apply();
        }
    }

    /* renamed from: b */
    private void m17560b(List<TrafficEventModel> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<TrafficEventModel> it = list.iterator();
            while (it.hasNext()) {
                if (System.currentTimeMillis() - it.next().event_time > 600000) {
                    it.remove();
                    setChanged(true);
                }
            }
        }
    }

    public void setChanged(boolean z) {
        this.f24663a = z;
    }

    public synchronized void showTrafficLocalIcon(DidiMap didiMap) {
        if (ApolloHawaii.isTrafficEventOpen()) {
            HWLog.m16761i("traffic_event", "showTrafficLocalIcon");
            if (!(MapUtil.m_Context == null || didiMap == null)) {
                HWLog.m16758d(1, "traffic_event", "isShowFakeTrafficEvent=" + didiMap.isShowFakeTrafficEvent());
                if (didiMap.isShowFakeTrafficEvent()) {
                    List<TrafficEventModel> a = m17558a();
                    if (!a.isEmpty()) {
                        startTimer();
                        TrafficEventModel[] trafficEventModelArr = (TrafficEventModel[]) a.toArray(new TrafficEventModel[a.size()]);
                        HWLog.m16758d(1, "traffic_event", "updateLocalTrafficIcon: size =" + trafficEventModelArr.length);
                        didiMap.updateLocalTrafficIcon(trafficEventModelArr);
                    } else {
                        clearLocalTrafficIcon(didiMap);
                        stopTimer();
                    }
                } else {
                    clearLocalTrafficIcon(didiMap);
                }
                setChanged(false);
            }
        } else {
            HWLog.m16761i("traffic_event", "showTrafficLocalIcon apollo close");
        }
    }

    /* renamed from: c */
    private void m17561c(List<TrafficEventModel> list) {
        StringBuilder sb = new StringBuilder("TrafficEventManager showTrafficLocalIcon size=");
        sb.append(list.size());
        sb.append(";");
        for (int i = 0; i < list.size(); i++) {
            TrafficEventModel trafficEventModel = list.get(i);
            sb.append(trafficEventModel.event_lng + "," + trafficEventModel.event_lat + ";");
        }
        HWLog.m16761i("hw", sb.toString());
    }

    public void startTimer() {
        if (this.f24665f == null || this.f24666g == null) {
            stopTimer();
            this.f24665f = new Timer();
            MyTimerTask myTimerTask = new MyTimerTask();
            this.f24666g = myTimerTask;
            this.f24665f.schedule(myTimerTask, 1000, 2000);
            HWLog.m16761i("hw", "TrafficEventManager startTimer");
        }
    }

    public void stopTimer() {
        Timer timer = this.f24665f;
        if (timer != null) {
            timer.cancel();
            this.f24665f = null;
        }
        TimerTask timerTask = this.f24666g;
        if (timerTask != null) {
            timerTask.cancel();
            this.f24666g = null;
        }
        HWLog.m16761i("hw", "TrafficEventManager stopTimer");
    }

    public String getDateTime(long j) {
        return new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒").format(new Date(j));
    }

    public boolean getIconState(long j) {
        if (this.f24667i.contains(Long.valueOf(j))) {
            return false;
        }
        if (MapUtil.m_Context == null) {
            return true;
        }
        String string = SystemUtils.getSharedPreferences(MapUtil.m_Context, f24659b, 0).getString(f24660c, "");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 0) {
                return true;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null && jSONObject.optLong(ParamKeys.PARAM_EVENT_ID) == j) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
