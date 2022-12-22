package com.didi.security.wireless;

import android.os.Build;
import android.text.TextUtils;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.didi.component.common.net.CarServerParam;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class TouchManager {

    /* renamed from: a */
    private static final String f38580a = "TOUCHMANAGER";

    /* renamed from: c */
    private static final int f38581c = 50;

    /* renamed from: b */
    private ReentrantLock f38582b;

    /* renamed from: d */
    private ArrayList<TouchListener> f38583d;

    private static class SingletonClassInstance {
        /* access modifiers changed from: private */
        public static final TouchManager INSTANCE = new TouchManager();

        private SingletonClassInstance() {
        }
    }

    public static TouchManager getInstance() {
        return SingletonClassInstance.INSTANCE;
    }

    private TouchManager() {
        this.f38582b = new ReentrantLock();
        this.f38583d = new ArrayList<>();
    }

    public class TouchListener implements View.OnTouchListener {
        private static final int ACTION_MOVE_RESET = 0;
        private static final int ACTION_MOVE_SET = 1;
        private int capacity = 50;
        private ArrayList<String> data = new ArrayList<>();
        private JSONObject deviceInfo;
        private int moveState = 0;
        /* access modifiers changed from: private */
        public String name;
        private String type;

        public TouchListener(String str, String str2) {
            this.name = str;
            this.type = str2;
        }

        public void reset() {
            this.moveState = 0;
            ArrayList<String> arrayList = this.data;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                String data2String = data2String();
                jSONObject.put("data", data2String);
                jSONObject.put("type", this.type);
                if (TextUtils.isEmpty(data2String)) {
                    jSONObject.put("device", "");
                } else if (this.deviceInfo != null) {
                    jSONObject.put("device", this.deviceInfo);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        private String data2String() {
            ArrayList<String> arrayList = this.data;
            if (arrayList == null || arrayList.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.data.size(); i++) {
                if (i != 0) {
                    sb.append("|");
                }
                sb.append(this.data.get(i));
            }
            return sb.toString();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.deviceInfo == null) {
                this.deviceInfo = TouchManager.getDeviceInfo2(motionEvent.getDevice());
            }
            if (motionEvent.getAction() == 0) {
                this.moveState = 0;
            }
            if (motionEvent.getAction() == 2) {
                int i = this.moveState;
                if (i == 1) {
                    return false;
                }
                if (i == 0) {
                    this.moveState = 1;
                }
            }
            ArrayList<String> arrayList = this.data;
            if (arrayList != null) {
                if (arrayList.size() == this.capacity) {
                    this.data.remove(0);
                }
                this.data.add(TouchManager.genResult(motionEvent));
            }
            return false;
        }
    }

    public TouchListener make(String str, String str2) {
        this.f38582b.lock();
        TouchListener touchListener = new TouchListener(str, str2);
        ArrayList<TouchListener> arrayList = this.f38583d;
        if (arrayList != null) {
            arrayList.add(touchListener);
        }
        this.f38582b.unlock();
        return touchListener;
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f38582b.lock();
            Iterator<TouchListener> it = this.f38583d.iterator();
            while (it.hasNext()) {
                if (it.next().name.equals(str)) {
                    it.remove();
                }
            }
            this.f38582b.unlock();
        }
    }

    public String getData() {
        this.f38582b.lock();
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        while (i < this.f38583d.size()) {
            try {
                TouchListener touchListener = this.f38583d.get(i);
                JSONObject json = touchListener.toJson();
                if (json != null && !TextUtils.isEmpty(touchListener.name)) {
                    jSONObject.put(touchListener.name, json);
                }
                touchListener.reset();
                i++;
            } catch (JSONException unused) {
            }
        }
        String jSONObject2 = jSONObject.toString();
        Logger.m27324i(f38580a, "touch:" + jSONObject2);
        this.f38582b.unlock();
        return jSONObject2;
    }

    public void report(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CarServerParam.PARAM_PRODUCTID, str);
            jSONObject.put("orderid", str2);
        } catch (JSONException unused) {
        }
        SecurityManager.report("touch2", jSONObject.toString());
    }

    public void report(String str) {
        SecurityManager.report("touch2", str);
    }

    /* renamed from: a */
    private static String m27334a(int i) {
        StringBuilder sb = new StringBuilder();
        m27335a(sb, i, 257, "keyboard");
        m27335a(sb, i, 513, "dpad");
        m27335a(sb, i, 4098, "touchscreen");
        m27335a(sb, i, 8194, "mouse");
        m27335a(sb, i, 16386, "stylus");
        m27335a(sb, i, 65540, "trackball");
        m27335a(sb, i, InputDeviceCompat.SOURCE_TOUCHPAD, "touchpad");
        m27335a(sb, i, InputDeviceCompat.SOURCE_JOYSTICK, "joystick");
        m27335a(sb, i, 1025, "gamepad");
        return sb.toString();
    }

    /* renamed from: a */
    private static void m27335a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(" ");
            sb.append(str);
        }
    }

    public static String getDeviceInfo(InputDevice inputDevice) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("{name:");
            sb.append(inputDevice.getName());
            int i = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT > 15) {
                sb.append(",virtual:");
                sb.append(inputDevice.isVirtual() ? "true" : SDKConsts.BOOLEAN_FALSE);
            }
            int sources = inputDevice.getSources();
            sb.append(",source:");
            sb.append("0x");
            sb.append(Integer.toHexString(sources));
            sb.append("(");
            sb.append(m27334a(inputDevice.getSources()));
            sb.append(" )}");
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static JSONObject getDeviceInfo2(InputDevice inputDevice) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", inputDevice.getName());
            if (Build.VERSION.SDK_INT > 15) {
                jSONObject.put("virtual", inputDevice.isVirtual() ? "true" : SDKConsts.BOOLEAN_FALSE);
            }
            int sources = inputDevice.getSources();
            jSONObject.put("source", "0x" + Integer.toHexString(sources) + "(" + m27334a(inputDevice.getSources()) + " )");
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String genResult(MotionEvent motionEvent) {
        return motionEvent.getAction() + "," + motionEvent.getToolType(0) + "," + motionEvent.getRawX() + "," + motionEvent.getRawY() + "," + motionEvent.getSize() + "," + motionEvent.getPressure() + "," + (motionEvent.getEventTime() - motionEvent.getDownTime()) + "," + System.currentTimeMillis();
    }
}
