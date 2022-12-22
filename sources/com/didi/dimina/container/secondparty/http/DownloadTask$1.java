package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.http.ProgressResponseBody;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.JSONUtil;
import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import didihttp.Call;
import didihttp.Callback;
import didihttp.Response;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class DownloadTask$1 implements Callback {
    final /* synthetic */ C7531a this$0;
    final /* synthetic */ NetworkService.ITaskCallback val$callback;
    final /* synthetic */ NetworkService.NetworkTaskModel.Download val$model;
    final /* synthetic */ String val$taskId;

    DownloadTask$1(C7531a aVar, String str, NetworkService.ITaskCallback iTaskCallback, NetworkService.NetworkTaskModel.Download download) {
        this.this$0 = aVar;
        this.val$taskId = str;
        this.val$callback = iTaskCallback;
        this.val$model = download;
    }

    public void onFailure(Call call, IOException iOException) {
        if (!TextUtils.isEmpty(this.val$taskId)) {
            this.this$0.f17119a.remove(this.val$taskId);
        }
        this.val$callback.onFailure(iOException);
    }

    public void onResponse(Call call, Response response) {
        if (!TextUtils.isEmpty(this.val$taskId)) {
            this.this$0.f17119a.remove(this.val$taskId);
        }
        if (!response.isSuccessful()) {
            JSONObject jSONObject = new JSONObject();
            JSONUtil.put(jSONObject, "data", (Object) new JSONObject());
            JSONUtil.put(jSONObject, "statusCode", response.code());
            this.val$callback.onSuccess(jSONObject);
        } else if (C7535e.m12711a(new ProgressResponseBody(response.body(), new ProgressResponseBody.ProgressListener() {
            public void onProgressUpdate(long j, long j2) {
                DownloadTask$1.this.val$callback.onProgressUpdate(j, (float) j2);
            }
        }).byteStream(), response.header("content-type"), this.val$model.filePath)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tempFilePath", (Object) null);
                JSONObject jSONObject3 = JSONUtil.toJSONObject(JSONUtil.toJson(response.headers().toMultimap()));
                jSONObject2.put(FlutterShareMethod.filePathKey, this.val$model.filePath);
                jSONObject2.put("header", jSONObject3);
                jSONObject2.put("statusCode", response.code());
                this.val$callback.onSuccess(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
                this.val$callback.onFailure(new Exception("An unexpected error occurred while build jsonObject result"));
            }
        } else {
            this.val$callback.onFailure(new Exception("An unexpected error occurred while write stream to file"));
        }
        this.val$callback.onComplete();
    }
}
