package com.didichuxing.mlcp.drtc.utils;

import com.didichuxing.mlcp.drtc.models.LogModel;
import com.google.gson.Gson;
import com.koushikdutta.async.http.AsyncHttpClient;
import java.util.UUID;

public class MetricReporter extends HttpUtils {
    private static MetricReporter instance = null;
    private static final String log_upload_svr_uri = "http://%s/gateway/drtc/sys/sessions/logs";
    private static final String metric_upload_svr_uri = "http://%s/gateway/drtc/uploadLiveRecord";
    private final String domainUri;
    private String j_SessionId = "";
    private String log_unique_id = "";

    private MetricReporter(String str) {
        this.domainUri = str;
    }

    public static MetricReporter getInstance(String str) {
        if (instance == null) {
            instance = new MetricReporter(str);
        }
        return instance;
    }

    public void Clear() {
        this.j_SessionId = null;
        this.log_unique_id = UUID.randomUUID().toString().substring(0, 31);
    }

    public void SetReporterSession(String str) {
        this.j_SessionId = str;
    }

    public void metricsReport(String str) {
        HttpPost_Async(String.format(metric_upload_svr_uri, new Object[]{this.domainUri}), str, (AsyncHttpClient.JSONObjectCallback) null);
    }

    public synchronized void systemLogReporter(LogModel logModel) {
        Gson gson = new Gson();
        logModel.mo118970b(this.j_SessionId).mo118971c(this.log_unique_id);
        HttpPost_Async(String.format(log_upload_svr_uri, new Object[]{this.domainUri}), gson.toJson((Object) logModel), (AsyncHttpClient.JSONObjectCallback) null);
    }

    public static MetricReporter getInstance() {
        if (instance == null) {
            instance = new MetricReporter("drtc-api.didiglobal.com");
        }
        return instance;
    }
}
