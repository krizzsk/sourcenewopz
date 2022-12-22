package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.service.NetworkService;
import didihttp.Call;
import didihttp.Callback;
import didihttp.Headers;
import didihttp.Response;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class RequestTask$1 implements Callback {
    final /* synthetic */ C7533c this$0;
    final /* synthetic */ NetworkService.ITaskCallback val$callback;
    final /* synthetic */ NetworkService.NetworkTaskModel.Request val$model;
    final /* synthetic */ String val$taskId;

    RequestTask$1(C7533c cVar, String str, NetworkService.ITaskCallback iTaskCallback, NetworkService.NetworkTaskModel.Request request) {
        this.this$0 = cVar;
        this.val$taskId = str;
        this.val$callback = iTaskCallback;
        this.val$model = request;
    }

    public void onFailure(Call call, IOException iOException) {
        if (!TextUtils.isEmpty(this.val$taskId)) {
            this.this$0.f17125e.remove(this.val$taskId);
        }
        this.val$callback.onFailure(iOException);
        this.val$callback.onComplete();
    }

    public void onResponse(Call call, Response response) {
        if (!TextUtils.isEmpty(this.val$taskId)) {
            this.this$0.f17125e.remove(this.val$taskId);
        }
        String str = "";
        try {
            if (response.body() != null) {
                str = response.body().string();
            }
            Headers headers = response.headers();
            int code = response.code();
            if (response.isSuccessful()) {
                this.val$callback.onSuccess(this.this$0.m12694a(this.val$model.dataType, str, headers, code));
            } else {
                this.val$callback.onSuccess(this.this$0.m12694a(this.val$model.dataType, new JSONObject().toString(), headers, code));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            this.val$callback.onFailure(e);
        }
        this.val$callback.onComplete();
    }
}
