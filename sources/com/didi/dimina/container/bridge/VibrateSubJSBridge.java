package com.didi.dimina.container.bridge;

import android.os.Vibrator;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

public class VibrateSubJSBridge {

    /* renamed from: a */
    private final DMMina f16670a;

    private interface VibrationType {
        public static final String HEAVY = "heavy";
        public static final String LIGHT = "light";
        public static final String MEDIUM = "medium";
    }

    public VibrateSubJSBridge(DMMina dMMina) {
        this.f16670a = dMMina;
        LogUtil.m13411i("VibrateSubJSBridge init");
    }

    public void vibrateShort(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            ((Vibrator) this.f16670a.getActivity().getSystemService("vibrator")).vibrate(m12290a(jSONObject.optString("type")), -1);
            CallBackUtil.onSuccess(callbackFunction);
        } catch (Exception e) {
            e.printStackTrace();
            CallBackUtil.onFail("震动处理失败", callbackFunction);
        }
    }

    /* renamed from: a */
    private long[] m12290a(String str) {
        if (TextUtils.equals(VibrationType.HEAVY, str)) {
            return new long[]{15, 40, 0, 0};
        }
        if (TextUtils.equals("medium", str)) {
            return new long[]{15, 35, 0, 0};
        }
        return new long[]{15, 30, 0, 0};
    }

    public void vibrateLong(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            ((Vibrator) this.f16670a.getActivity().getSystemService("vibrator")).vibrate(new long[]{15, 400}, -1);
            CallBackUtil.onSuccess(callbackFunction);
        } catch (Exception e) {
            e.printStackTrace();
            CallBackUtil.onFail("震动处理失败", callbackFunction);
        }
    }
}
