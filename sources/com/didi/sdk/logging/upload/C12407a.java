package com.didi.sdk.logging.upload;

import android.util.Pair;
import com.didi.sdk.logging.LoggerContext;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.logging.net.FileRequestBody;
import com.didi.sdk.logging.upload.persist.TaskRecord;
import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.ReportUtils;
import com.didi.sdk.logging.util.StringUtils;
import com.didi.soda.customer.biz.popdialog.AppsFlyerHelperKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* renamed from: com.didi.sdk.logging.upload.a */
/* compiled from: RequestManager */
class C12407a {

    /* renamed from: a */
    public static final String f36603a = "omg";

    /* renamed from: b */
    public static final int f36604b = 0;

    /* renamed from: c */
    public static final int f36605c = -1;

    /* renamed from: d */
    public static final int f36606d = -2;

    /* renamed from: e */
    public static final int f36607e = -3;

    /* renamed from: f */
    public static final String f36608f = "ret";

    /* renamed from: g */
    static OkHttpClient f36609g = new OkHttpClient.Builder().connectTimeout(150, TimeUnit.SECONDS).readTimeout(150, TimeUnit.SECONDS).readTimeout(150, TimeUnit.SECONDS).build();

    /* renamed from: h */
    private static final String f36610h = "api/v2/slice/upload";

    /* renamed from: i */
    private static final String f36611i = "catch/log/upload/status";

    /* renamed from: j */
    private static final String f36612j = "catch/upload_tree";

    /* renamed from: k */
    private static final String f36613k = "api/v2/task/uncompleted";

    /* renamed from: l */
    private static final String f36614l = "api";

    /* renamed from: m */
    private static final String f36615m = "token";

    /* renamed from: n */
    private static final String f36616n = "appname";

    /* renamed from: o */
    private static final String f36617o = "networkType";

    /* renamed from: p */
    private static final String f36618p = "android";

    /* renamed from: q */
    private static final String f36619q = "file";

    /* renamed from: r */
    private static final String f36620r = "ts";

    /* renamed from: s */
    private static final String f36621s = "taskId";

    /* renamed from: t */
    private static final String f36622t = "sliceIndex";

    /* renamed from: u */
    private static final String f36623u = "totalLength";

    /* renamed from: v */
    private static final String f36624v = "osType";

    C12407a() {
    }

    /* renamed from: a */
    public static void m25967a(String str, int i, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = LoggerFactory.getConfig().getServerHost() + f36611i;
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(i));
        hashMap.put("ts", Long.valueOf(currentTimeMillis));
        hashMap.put("taskId", str);
        hashMap.put("sdk_ver", "1.0");
        try {
            Response execute = f36609g.newCall(new Request.Builder().url(str3).header("taskId", str).post(new FormBody.Builder().add("status", String.valueOf(i)).add("message", str2).add("ts", String.valueOf(currentTimeMillis)).add("sdk_ver", "1.0").build()).build()).execute();
            ReportUtils.reportRequest(str3, hashMap, execute.toString());
            execute.body().close();
        } catch (IOException e) {
            Debug.m25982e("uploadTaskStatus error", e);
        }
    }

    /* renamed from: a */
    static RequestResult<String> m25966a(String str, File file, String str2, int i, long j) {
        boolean z;
        String str3;
        int i2;
        String str4 = str;
        RequestResult<String> requestResult = new RequestResult<>();
        HashMap hashMap = new HashMap();
        hashMap.put("taskId", str);
        hashMap.put(f36622t, Integer.valueOf(i));
        hashMap.put(f36623u, Long.valueOf(j));
        hashMap.put("osType", "android");
        String str5 = LoggerFactory.getConfig().getServerHost() + f36610h;
        boolean z2 = false;
        try {
            Response execute = f36609g.newCall(new Request.Builder().url(str5).post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("taskId", str).addFormDataPart(f36622t, String.valueOf(i)).addFormDataPart(f36623u, String.valueOf(j)).addFormDataPart("osType", "android").addFormDataPart("file", file.getName(), FileRequestBody.create(file)).build()).build()).execute();
            ResponseBody body = execute.body();
            str3 = body.string();
            ReportUtils.reportRequest(str5, hashMap, str3);
            int code = execute.code();
            if (execute.isSuccessful()) {
                code = new JSONObject(str3).optInt(f36608f, -1);
                if (code == -2 || (code != -1 && code == 0)) {
                    i2 = code;
                    z = true;
                    requestResult.setCode(i2);
                    ReportUtils.reportUploadSliceResult(execute.isSuccessful(), str2, file.length(), i, str, i2, str3, file.getName());
                    body.close();
                    requestResult.setSuccess(z).setMsg(str3);
                    return requestResult;
                }
            }
            i2 = code;
            z = false;
            try {
                requestResult.setCode(i2);
                ReportUtils.reportUploadSliceResult(execute.isSuccessful(), str2, file.length(), i, str, i2, str3, file.getName());
                body.close();
            } catch (Exception e) {
                e = e;
                z2 = z;
            }
        } catch (Exception e2) {
            e = e2;
            Debug.m25982e("uploadSectionFile error", e);
            str3 = e.getMessage();
            z = z2;
            requestResult.setSuccess(z).setMsg(str3);
            return requestResult;
        }
        requestResult.setSuccess(z).setMsg(str3);
        return requestResult;
    }

    /* renamed from: a */
    static Pair<TaskRecord, String> m25965a(String str) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = LoggerFactory.getConfig().getServerHost() + f36613k;
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("ts", Long.valueOf(currentTimeMillis));
        hashMap.put("sdk_ver", "1.0");
        Request build = new Request.Builder().url(str3).post(new FormBody.Builder().add("uid", str).add("ts", String.valueOf(currentTimeMillis)).add(AppsFlyerHelperKt.appLinkAppName, LoggerContext.getDefault().getPackageName()).add("osType", "android").build()).build();
        TaskRecord taskRecord = null;
        try {
            Response execute = f36609g.newCall(build).execute();
            ReportUtils.reportRequest(str3, hashMap, execute.toString());
            ResponseBody body = execute.body();
            str2 = body.string();
            try {
                if (execute.isSuccessful()) {
                    ReportUtils.reportQueryTaskResult(str2);
                    JsonElement jsonElement = new JsonParser().parse(str2).getAsJsonObject().get("data");
                    if (jsonElement != null) {
                        taskRecord = TaskRecord.fromJson(jsonElement);
                    }
                }
                body.close();
            } catch (IOException e) {
                e = e;
                Debug.m25982e("queryTask error", e);
                return new Pair<>(taskRecord, str2);
            }
        } catch (IOException e2) {
            e = e2;
            str2 = null;
            Debug.m25982e("queryTask error", e);
            return new Pair<>(taskRecord, str2);
        }
        return new Pair<>(taskRecord, str2);
    }

    /* renamed from: a */
    public static void m25968a(String str, String str2, FileTree fileTree) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Response execute = f36609g.newCall(new Request.Builder().url(LoggerFactory.getConfig().getServerHost() + f36612j).header("token", StringUtils.MD5(f36603a + currentTimeMillis + "api")).post(new FormBody.Builder().add(f36616n, LoggerContext.getDefault().getPackageName()).add("ts", String.valueOf(currentTimeMillis)).add("networkType", str2).add("sdk_ver", "1.0").add("taskid", str).add("content", fileTree.toJson()).build()).build()).execute();
            ResponseBody body = execute.body();
            ReportUtils.reportUploadFileTreeResult(execute.isSuccessful(), str2, str, body.string());
            body.close();
        } catch (IOException e) {
            Debug.m25982e("uploadFileTree error", e);
        }
    }
}
