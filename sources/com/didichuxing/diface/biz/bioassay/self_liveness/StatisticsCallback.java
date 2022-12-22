package com.didichuxing.diface.biz.bioassay.self_liveness;

import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessCallbackAdapter;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StatisticsCallback extends LivenessCallbackAdapter {

    /* renamed from: a */
    private final String f47360a;

    /* renamed from: b */
    private int f47361b = 0;

    /* renamed from: c */
    private boolean f47362c = false;

    public StatisticsCallback(String str) {
        this.f47360a = str;
    }

    public void onStartAction(int[] iArr) {
        JSONObject a = mo116374a();
        JSONArray jSONArray = new JSONArray();
        if (iArr != null && iArr.length > 0) {
            for (int put : iArr) {
                jSONArray.put(put);
            }
        }
        try {
            a.put("liveness_action_label", jSONArray);
            a.put("video_collect_source", this.f47360a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SELF_LIVENESS_ACTION_CONF, a);
    }

    public void onActionChange(int i, int i2, int i3, int i4) {
        if (ActionType.index(i2) != null) {
            JSONObject a = mo116374a();
            try {
                a.put("action", i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SELF_LIVENESS_ACTION_START, a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final JSONObject mo116374a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bioType", "3");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void onActionSuccess(List<ILivenessCallback.PicWithScore> list) {
        this.f47362c = true;
        LivenessEnd();
    }

    public void onMirrorSuccess(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3) {
        DiFaceFacade.getInstance().report("12");
    }

    public void LivenessEnd() {
        JSONObject a = mo116374a();
        try {
            a.put("liveness_end", this.f47362c ? "success" : "fail");
            a.put("attempt_number", this.f47361b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SELF_LIVENESS_ACTION_END, a);
    }

    public void onActionInfo(int i, int i2, int i3, int[] iArr) {
        JSONObject a = mo116374a();
        try {
            a.put("action_success", i);
            if (i == 0) {
                a.put("fail_reason", i2 == 1 ? "face_lost" : "timeout");
            }
            a.put("action", i3);
            JSONObject jSONObject = new JSONObject();
            if (iArr != null && iArr.length == 7) {
                jSONObject.put("total_frame", iArr[0]);
                jSONObject.put("no_face_frame", iArr[1]);
                jSONObject.put("center_fail_frame", iArr[2]);
                jSONObject.put("yaw_pitch_frame", iArr[3]);
                jSONObject.put("occ_frame", iArr[4]);
                jSONObject.put("blur_frame", iArr[5]);
                jSONObject.put("illum_frame", iArr[6]);
            }
            a.put("action_info", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SELF_LIVENESS_ACTION_STOP, a);
    }

    public void onRestart() {
        this.f47361b++;
        JSONObject a = mo116374a();
        try {
            a.put("attempt_number", this.f47361b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SELF_LIVENESS_LIVE_START, a);
    }
}
