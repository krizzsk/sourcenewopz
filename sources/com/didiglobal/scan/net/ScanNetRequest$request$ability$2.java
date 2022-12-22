package com.didiglobal.scan.net;

import android.content.Context;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.scan.data.ScanResultModel;
import com.didiglobal.scan.net.ScanNetRequest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didiglobal/scan/net/ScanNetRequest$request$ability$2", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/google/gson/JsonObject;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScanNetRequest.kt */
public final class ScanNetRequest$request$ability$2 implements RpcService.Callback<JsonObject> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ScanNetRequest.ErrorActionDelegate $errorDelegate;
    final /* synthetic */ ScanNetRequest.LoadingDelegate $loadingDelegate;

    ScanNetRequest$request$ability$2(ScanNetRequest.LoadingDelegate loadingDelegate, ScanNetRequest.ErrorActionDelegate errorActionDelegate, Context context) {
        this.$loadingDelegate = loadingDelegate;
        this.$errorDelegate = errorActionDelegate;
        this.$context = context;
    }

    public void onSuccess(JsonObject jsonObject) {
        ScanNetRequest.LoadingDelegate loadingDelegate = this.$loadingDelegate;
        if (loadingDelegate != null) {
            loadingDelegate.hideLoading();
        }
        if (jsonObject != null) {
            JsonElement jsonElement = jsonObject.get("errno");
            Intrinsics.checkExpressionValueIsNotNull(jsonElement, "value!![\"errno\"]");
            int asInt = jsonElement.getAsInt();
            JsonElement jsonElement2 = jsonObject.get("errmsg");
            Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "value!![\"errmsg\"]");
            String asString = jsonElement2.getAsString();
            if (asInt == 0) {
                try {
                    UiThreadHandler.post(new ScanNetRequest$request$ability$2$onSuccess$1((ScanResultModel) ScanNetRequest.f51363b.fromJson(jsonObject.get("data"), ScanResultModel.class)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ScanNetRequest.LoadingDelegate loadingDelegate2 = this.$loadingDelegate;
                if (loadingDelegate2 != null) {
                    loadingDelegate2.hideLoading();
                }
                ScanNetRequest.ErrorActionDelegate errorActionDelegate = this.$errorDelegate;
                if (errorActionDelegate != null) {
                    Intrinsics.checkExpressionValueIsNotNull(asString, "errmsg");
                    errorActionDelegate.showError(asString);
                }
            }
        }
    }

    public void onFailure(IOException iOException) {
        if (iOException != null) {
            iOException.printStackTrace();
        }
        ScanNetRequest.LoadingDelegate loadingDelegate = this.$loadingDelegate;
        if (loadingDelegate != null) {
            loadingDelegate.hideLoading();
        }
        ScanNetRequest.ErrorActionDelegate errorActionDelegate = this.$errorDelegate;
        if (errorActionDelegate != null) {
            String string = ResourcesHelper.getString(this.$context, R.string.Finance_LightSpeedPC_Identification_failed_wKuB);
            Intrinsics.checkExpressionValueIsNotNull(string, "ResourcesHelper.getStrin…KuB\n                    )");
            errorActionDelegate.showError(string);
        }
    }
}
