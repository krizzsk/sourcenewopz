package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.JSONUtil;
import didihttp.Call;
import didihttp.Callback;
import didihttp.Response;
import java.io.IOException;
import org.json.JSONObject;

class UploadTask$2 implements Callback {
    final /* synthetic */ C7534d this$0;
    final /* synthetic */ NetworkService.ITaskCallback val$callback;
    final /* synthetic */ String val$taskId;

    UploadTask$2(C7534d dVar, String str, NetworkService.ITaskCallback iTaskCallback) {
        this.this$0 = dVar;
        this.val$taskId = str;
        this.val$callback = iTaskCallback;
    }

    public void onFailure(Call call, IOException iOException) {
        if (!TextUtils.isEmpty(this.val$taskId)) {
            this.this$0.f17126a.remove(this.val$taskId);
        }
        this.val$callback.onFailure(iOException);
        this.val$callback.onComplete();
    }

    public void onResponse(Call call, Response response) {
        if (!TextUtils.isEmpty(this.val$taskId)) {
            this.this$0.f17126a.remove(this.val$taskId);
        }
        JSONObject jSONObject = new JSONObject();
        if (response.isSuccessful()) {
            try {
                JSONUtil.put(jSONObject, "data", (Object) response.body().string());
                JSONUtil.put(jSONObject, "statusCode", response.code());
                this.val$callback.onSuccess(jSONObject);
            } catch (IOException e) {
                e.printStackTrace();
                this.val$callback.onFailure(e);
            }
        } else {
            JSONUtil.put(jSONObject, "data", (Object) new JSONObject());
            JSONUtil.put(jSONObject, "statusCode", response.code());
            this.val$callback.onSuccess(jSONObject);
        }
        this.val$callback.onComplete();
    }
}
