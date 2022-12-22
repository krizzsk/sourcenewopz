package com.didi.one.netdetect.task;

import android.text.TextUtils;
import com.datadog.android.rum.internal.ndk.NdkCrashLog;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.util.MD5;
import com.didi.one.netdetect.util.ONDLog;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.gson.Gson;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.Request;
import didihttp.Response;
import didihttp.ServerCallItem;
import didihttp.StatisticalCallback;
import didihttp.StatisticalContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DidiHttpTask implements Task<HttpTaskResult> {

    /* renamed from: b */
    private static final String f29454b = "OND_HttpTask";

    /* renamed from: c */
    private static final String f29455c = "connect";

    /* renamed from: d */
    private static final String f29456d = "read";

    /* renamed from: e */
    private static final String f29457e = "ssl";

    /* renamed from: f */
    private static volatile DidiHttpTask f29458f;

    /* renamed from: a */
    Logger f29459a = LoggerFactory.getLogger("OneNetDetect");

    /* renamed from: g */
    private DidiHttpClient f29460g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public DataCallback f29461h;

    public interface DataCallback {
        void onDataStatistic(StatisticalContext statisticalContext);
    }

    public static class TaskParams {
        public int mTimeout;
    }

    public DidiHttpTask(TaskParams taskParams) {
        DidiHttpClient.Builder readTimeout = new DidiHttpClient.Builder().connectTimeout((long) taskParams.mTimeout, TimeUnit.MILLISECONDS).readTimeout((long) taskParams.mTimeout, TimeUnit.MILLISECONDS);
        readTimeout.setUseGlobalStatisticalManagerCallback(false);
        readTimeout.setHttpDnsOwner(true);
        readTimeout.setStatisticalCallback(new StatisticalCallback() {
            public void onStatisticalDataCallback(StatisticalContext statisticalContext) {
                if (DidiHttpTask.this.f29461h != null) {
                    DidiHttpTask.this.f29461h.onDataStatistic(statisticalContext);
                }
            }
        });
        this.f29460g = readTimeout.build();
    }

    public HttpTaskResult doTask(DetectionItem detectionItem) {
        if (TextUtils.isEmpty(detectionItem.url)) {
            return null;
        }
        if (!detectionItem.type.equals("http") && !detectionItem.type.equals("tcp")) {
            return null;
        }
        final HttpTaskResult httpTaskResult = new HttpTaskResult();
        this.f29461h = new DataCallback() {
            public void onDataStatistic(StatisticalContext statisticalContext) {
                ServerCallItem currentServerCallData;
                if (statisticalContext != null && (currentServerCallData = statisticalContext.currentServerCallData()) != null) {
                    httpTaskResult.setConsumeTime((int) currentServerCallData.getTotalCostTime());
                    httpTaskResult.setDetectIp(currentServerCallData.getRemoteAddress().getHostAddress());
                    httpTaskResult.setLocalDns("");
                    httpTaskResult.setDnsTime((int) currentServerCallData.getDnsLookupTime());
                    httpTaskResult.setInitialConnTime((int) (currentServerCallData.getConnectTime() - currentServerCallData.getHandShakeTime()));
                    httpTaskResult.setSslTime((int) currentServerCallData.getHandShakeTime());
                    httpTaskResult.setReqSentTime((int) currentServerCallData.getRequestSendTime());
                    httpTaskResult.setResReadTime((int) currentServerCallData.getResponseReceiveTime());
                    httpTaskResult.setWaitingTime((int) ((((currentServerCallData.getTotalCostTime() - currentServerCallData.getConnectTime()) - currentServerCallData.getDnsLookupTime()) - currentServerCallData.getRequestSendTime()) - currentServerCallData.getResponseReceiveTime()));
                }
            }
        };
        Request.Builder builder = new Request.Builder();
        builder.url(detectionItem.url).get();
        if (detectionItem.requestHeaders != null) {
            for (String next : detectionItem.requestHeaders.keySet()) {
                builder.addHeader(next, detectionItem.requestHeaders.get(next));
            }
        }
        if (detectionItem.type.equals("tcp")) {
            ONDLog.m20755d(f29454b, "addheader user_trans");
            builder.addHeader("use_trans", "1");
        }
        try {
            Response execute = this.f29460g.newCall(builder.build()).execute();
            ONDLog.m20755d(f29454b, "response code :" + String.valueOf(execute.code()));
            httpTaskResult.setCode(execute.code() + 2000);
            if (execute.header("use_trans", "0").equals("1")) {
                httpTaskResult.setDetectType("tcp");
            } else {
                httpTaskResult.setDetectType("http");
            }
            if (detectionItem.responseHeaders == 1) {
                httpTaskResult.setResHeaders(m20751a(execute.headers()));
                ONDLog.m20755d(f29454b, "response headers:" + httpTaskResult.getResHeaders());
            }
            if (detectionItem.md5Check == 1) {
                httpTaskResult.setDownFileMd5(MD5.computeMD5(execute.body().byteStream()));
                ONDLog.m20755d(f29454b, "md5:" + httpTaskResult.getDownFileMd5());
            }
        } catch (IOException e) {
            ONDLog.m20755d(f29454b, "exception :" + e.getMessage());
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            HashMap hashMap = new HashMap();
            hashMap.put(NdkCrashLog.STACKTRACE_KEY_NAME, stringWriter2);
            this.f29459a.errorEvent("OND_Exception", (Map<?, ?>) hashMap);
            httpTaskResult.setCode(1000);
            if (e instanceof SocketTimeoutException) {
                httpTaskResult.setCode(1003);
                if (!TextUtils.isEmpty(e.getMessage())) {
                    String lowerCase = e.getMessage().toLowerCase();
                    if (lowerCase.contains("connect")) {
                        httpTaskResult.setCode(1004);
                    } else if (lowerCase.contains(f29457e)) {
                        httpTaskResult.setCode(1005);
                    } else if (lowerCase.contains(f29456d)) {
                        httpTaskResult.setCode(1006);
                    }
                }
            } else if (e instanceof ConnectException) {
                httpTaskResult.setCode(1002);
            } else if (e instanceof UnknownHostException) {
                httpTaskResult.setCode(1001);
            }
        } catch (Throwable th) {
            ONDLog.m20755d(f29454b, "exception :" + th.getMessage());
            httpTaskResult.setCode(1000);
        }
        return httpTaskResult;
    }

    /* renamed from: a */
    private String m20751a(Headers headers) {
        HashMap hashMap = new HashMap();
        for (String next : headers.names()) {
            String str = headers.get(next);
            if (!next.equals("use_trans")) {
                hashMap.put(next, str);
            }
        }
        return new Gson().toJson((Object) hashMap);
    }

    public static class HttpTaskResult {
        private int code;
        private int consumeTime = -1;
        private String detectIp;
        private String detectType;
        private int dnsTime = -1;
        private String downFileMd5;
        private int initialConnTime = -1;
        private String localDns;
        private int reqSentTime = -1;
        private String resHeaders;
        private int resReadTime = -1;
        private int sslTime = -1;
        private int waitingTime = -1;

        public int getCode() {
            return this.code;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public int getConsumeTime() {
            return this.consumeTime;
        }

        public void setConsumeTime(int i) {
            this.consumeTime = i;
        }

        public String getDetectIp() {
            return this.detectIp;
        }

        public void setDetectIp(String str) {
            this.detectIp = str;
        }

        public String getLocalDns() {
            return this.localDns;
        }

        public void setLocalDns(String str) {
            this.localDns = str;
        }

        public int getDnsTime() {
            return this.dnsTime;
        }

        public void setDnsTime(int i) {
            this.dnsTime = i;
        }

        public int getInitialConnTime() {
            return this.initialConnTime;
        }

        public void setInitialConnTime(int i) {
            this.initialConnTime = i;
        }

        public int getSslTime() {
            return this.sslTime;
        }

        public void setSslTime(int i) {
            this.sslTime = i;
        }

        public int getReqSentTime() {
            return this.reqSentTime;
        }

        public void setReqSentTime(int i) {
            this.reqSentTime = i;
        }

        public int getWaitingTime() {
            return this.waitingTime;
        }

        public void setWaitingTime(int i) {
            this.waitingTime = i;
        }

        public int getResReadTime() {
            return this.resReadTime;
        }

        public void setResReadTime(int i) {
            this.resReadTime = i;
        }

        public String getResHeaders() {
            return this.resHeaders;
        }

        public void setResHeaders(String str) {
            this.resHeaders = str;
        }

        public String getDownFileMd5() {
            return this.downFileMd5;
        }

        public void setDownFileMd5(String str) {
            this.downFileMd5 = str;
        }

        public String getDetectType() {
            return this.detectType;
        }

        public void setDetectType(String str) {
            this.detectType = str;
        }
    }
}
