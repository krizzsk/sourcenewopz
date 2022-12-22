package com.didichuxing.dfbasesdk.logupload2;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.logupload.UploadObj;
import com.didichuxing.dfbasesdk.logupload2.LogUploadModel;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didichuxing.dfbasesdk.logupload2.a */
/* compiled from: LogUploader2 */
class C15304a {

    /* renamed from: a */
    private final Handler f46659a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f46660b;

    /* renamed from: c */
    private RpcServiceFactory f46661c = new RpcServiceFactory(AppContextHolder.getAppContext());

    C15304a(Handler handler) {
        this.f46659a = handler;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33505a(int i, Object obj) {
        Message obtain = Message.obtain(this.f46659a);
        obtain.what = i;
        obtain.obj = obj;
        obtain.sendToTarget();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115710a(String str, UploadObj uploadObj, String str2, boolean z) {
        if (!z) {
            mo115708a(str, uploadObj, str2);
            return;
        }
        this.f46660b = true;
        List<Object> list = uploadObj.ids;
        HashMap hashMap = new HashMap();
        try {
            JsonObject asJsonObject = new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject();
            if (TextUtils.isEmpty(str2) || !str2.equals("data")) {
                hashMap.put("jsonArray", asJsonObject.get(str2).getAsString());
            } else {
                hashMap.put("data", asJsonObject.get(str2).getAsString());
            }
            hashMap.put("sc", asJsonObject.get("sc").getAsString());
            ((LogUploadModel.ILogUploadRequester) this.f46661c.newRpcService(LogUploadModel.ILogUploadRequester.class, str)).logUploadRequester(HttpParamUtils.getQueryParam(GsonUtils.toJson(hashMap)), hashMap, new LogUploader2$1(this, list));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115708a(String str, UploadObj uploadObj, String str2) {
        this.f46660b = true;
        List<Object> list = uploadObj.ids;
        HashMap hashMap = new HashMap();
        try {
            if (TextUtils.isEmpty(str2) || !str2.equals("data")) {
                hashMap.put("jsonArray", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$3(this).getType()));
            } else {
                hashMap.put("data", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$2(this).getType()));
            }
            ((LogUploadModel.ILogUploadRequester) this.f46661c.newRpcService(LogUploadModel.ILogUploadRequester.class, str)).logUploadRequester(HttpParamUtils.getQueryParam(GsonUtils.toJson(hashMap)), hashMap, new LogUploader2$4(this, list));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115709a(String str, UploadObj uploadObj, String str2, String str3) {
        int i = 1;
        this.f46660b = true;
        List<Object> list = uploadObj.ids;
        HashMap hashMap = new HashMap();
        try {
            if (TextUtils.isEmpty(str2) || !str2.equals("data")) {
                hashMap.put("jsonArray", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$6(this).getType()));
            } else {
                hashMap.put("data", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$5(this).getType()));
            }
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append("_1_");
                if (TextUtils.isEmpty(uploadObj.jsonBody)) {
                    i = 0;
                }
                sb.append(i);
                hashMap.put("extraData", sb.toString());
            }
            ((LogUploadModel.ILogUploadRequester) this.f46661c.newRpcService(LogUploadModel.ILogUploadRequester.class, str)).logUploadRequester(HttpParamUtils.getQueryParam(GsonUtils.toJson(hashMap)), hashMap, new LogUploader2$7(this, list));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo115711a() {
        return this.f46660b;
    }
}
