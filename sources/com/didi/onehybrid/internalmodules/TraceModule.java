package com.didi.onehybrid.internalmodules;

import android.app.Activity;
import android.widget.Toast;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onehybrid.log.FusionLogHelper;
import com.didi.sdk.apm.SystemUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TraceModule extends BaseHybridModule {

    /* renamed from: a */
    private static final String f29595a = "HybridH5Log";

    public TraceModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
    }

    @JsInterface({"nativeLog"})
    public synchronized void nativeLog(final String str, final String str2) {
        new Thread(new Runnable() {
            public void run() {
                StringBuilder sb = new StringBuilder();
                String str = str;
                if (str != null && str.length() > 0) {
                    sb.append(str);
                    sb.append(":");
                }
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            sb.append(jSONObject.getString(keys.next()));
                            sb.append(",");
                        }
                    }
                } catch (JSONException unused) {
                    String str2 = str2;
                    if (str2 != null && str2.length() > 0) {
                        sb.append(str2);
                    }
                }
                String sb2 = sb.toString();
                Activity activity = TraceModule.this.mHybridContainer.getActivity();
                if (!FusionLogHelper.isFusionLogOpen(activity) || sb2.length() <= 0) {
                    SystemUtils.log(4, TraceModule.f29595a, sb2, (Throwable) null, "com.didi.onehybrid.internalmodules.TraceModule$1", 74);
                } else if (activity instanceof UpdateUIHandler) {
                    ((UpdateUIHandler) activity).updateUI("debug_log", sb2);
                }
            }
        }).start();
    }

    @JsInterface({"test"})
    public void test(String str) {
        SystemUtils.showToast(Toast.makeText(this.mHybridContainer.getActivity(), str, 0));
    }

    @JsInterface({"testBridge"})
    public void onlyForTest(String str, CallbackFunction callbackFunction) {
        SystemUtils.showToast(Toast.makeText(this.mHybridContainer.getActivity(), str, 0));
        if (callbackFunction != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("module", "TraceModule");
                jSONObject.put("content", "response from testBridge");
            } catch (JSONException unused) {
            }
            callbackFunction.onCallBack(jSONObject);
        }
    }
}
