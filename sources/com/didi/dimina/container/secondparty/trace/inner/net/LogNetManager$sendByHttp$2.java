package com.didi.dimina.container.secondparty.trace.inner.net;

import android.util.Log;
import com.didi.dimina.container.secondparty.trace.inner.LogManager;
import com.didi.dimina.container.util.LogUtil;
import didihttp.Call;
import didihttp.Callback;
import didihttp.Response;
import java.io.IOException;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/dimina/container/secondparty/trace/inner/net/LogNetManager$sendByHttp$2", "Ldidihttp/Callback;", "onFailure", "", "p0", "Ldidihttp/Call;", "p1", "Ljava/io/IOException;", "onResponse", "call", "response", "Ldidihttp/Response;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogNetManager.kt */
public final class LogNetManager$sendByHttp$2 implements Callback {
    LogNetManager$sendByHttp$2() {
    }

    public void onFailure(Call call, IOException iOException) {
        LogUtil.iRelease(LogNetManager.TAG, "onFailure:" + Log.getStackTraceString(iOException));
    }

    public void onResponse(Call call, Response response) {
        if (response != null) {
            String string = response.body().string();
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.optBoolean("success")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    LogManager.INSTANCE.onUploadSuccess(optJSONObject);
                    return;
                }
                return;
            }
            LogUtil.eRelease(LogNetManager.TAG, string);
        }
    }
}
