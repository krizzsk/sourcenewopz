package com.didichuxing.omega.sdk.cdnmonitor.detectionjob;

import com.didichuxing.omega.sdk.common.backend.UploadStrategy;
import com.didichuxing.omega.sdk.common.transport.HttpSender;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DetectionJobFetcher {
    public DetectionJobs fetch() {
        String httpResponse = getHttpResponse();
        DetectionJobs detectionJobs = new DetectionJobs();
        return (httpResponse == null || httpResponse.length() <= 0) ? detectionJobs : parseResponse(httpResponse);
    }

    private String getHttpResponse() {
        try {
            return HttpSender.get(UploadStrategy.getUploadCNDUrl(), (Map<String, String>) null).getBody();
        } catch (Throwable th) {
            OLog.m34763e("Throwable getHttpResponse fail" + th.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public DetectionJobs parseResponse(String str) {
        DetectionJobs detectionJobs = new DetectionJobs();
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            detectionJobs.setErrorNo(jSONObject.getInt("errno"));
            if (detectionJobs.getErrorNo() == 0) {
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("cdn_list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    detectionJobs.addDetectionJob((String) jSONObject2.get("url"), (String) jSONObject2.get("md5"), jSONObject2.has("ccc") ? (String) jSONObject2.get("ccc") : "");
                }
            }
        } catch (Exception unused) {
            OLog.m34769w("other exception parseResponse.");
        }
        return detectionJobs;
    }
}
