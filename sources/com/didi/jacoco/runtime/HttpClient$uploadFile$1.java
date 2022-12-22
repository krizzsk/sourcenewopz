package com.didi.jacoco.runtime;

import androidx.core.app.NotificationCompat;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/jacoco/runtime/HttpClient$uploadFile$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: HttpClient.kt */
public final class HttpClient$uploadFile$1 implements Callback {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ HttpCallback $callback;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7600291914559099199L, "com/didi/jacoco/runtime/HttpClient$uploadFile$1", 17);
        $jacocoData = probes;
        return probes;
    }

    HttpClient$uploadFile$1(HttpCallback httpCallback) {
        boolean[] $jacocoInit = $jacocoInit();
        this.$callback = httpCallback;
        $jacocoInit[16] = true;
    }

    public void onFailure(Call call, IOException iOException) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(iOException, "e");
        $jacocoInit[0] = true;
        this.$callback.onFailure(iOException.getMessage());
        $jacocoInit[1] = true;
    }

    public void onResponse(Call call, Response response) throws IOException {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(response, "response");
        $jacocoInit[2] = true;
        ResponseBody body = response.body();
        if (body != null) {
            $jacocoInit[3] = true;
        } else {
            Intrinsics.throwNpe();
            $jacocoInit[4] = true;
        }
        String string = body.string();
        $jacocoInit[5] = true;
        if (response.isSuccessful()) {
            $jacocoInit[6] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("onSuccess ");
            if (string != null) {
                $jacocoInit[7] = true;
                str = string;
            } else {
                $jacocoInit[8] = true;
                str = "";
            }
            sb.append(str);
            SystemUtils.log(6, "ec", sb.toString(), (Throwable) null, "com.didi.jacoco.runtime.HttpClient$uploadFile$1", 85);
            $jacocoInit[9] = true;
            ResponseResult responseResult = (ResponseResult) new Gson().fromJson(string, ResponseResult.class);
            $jacocoInit[10] = true;
            if (responseResult.getErrno() == 0) {
                $jacocoInit[11] = true;
                this.$callback.onSuccess();
                $jacocoInit[12] = true;
            } else {
                HttpCallback httpCallback = this.$callback;
                httpCallback.onFailure("error code : " + responseResult.getErrno());
                $jacocoInit[13] = true;
            }
        } else {
            this.$callback.onFailure(string);
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
    }
}
