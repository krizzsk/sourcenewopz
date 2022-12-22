package com.didi.component.payentrance.presenter;

import android.content.Context;
import com.didi.component.payentrance.model.FareDetailsModel;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/payentrance/presenter/FareDetailsObtain$obtainFareDetails$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/google/gson/JsonObject;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailsObtain.kt */
public final class FareDetailsObtain$obtainFareDetails$1 implements RpcService.Callback<JsonObject> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ResponseListener<FareDetailsModel> $listener;

    FareDetailsObtain$obtainFareDetails$1(Context context, ResponseListener<FareDetailsModel> responseListener) {
        this.$context = context;
        this.$listener = responseListener;
    }

    public void onSuccess(JsonObject jsonObject) {
        String str;
        FareDetailsModel fareDetailsModel = new FareDetailsModel(this.$context);
        if (jsonObject == null) {
            str = null;
        } else {
            str = jsonObject.toString();
        }
        fareDetailsModel.parse(str);
        if (fareDetailsModel.isAvailable()) {
            this.$listener.onSuccess(fareDetailsModel);
        } else {
            this.$listener.onFail(fareDetailsModel);
        }
        this.$listener.onFinish(fareDetailsModel);
    }

    public void onFailure(IOException iOException) {
        FareDetailsModel fareDetailsModel = new FareDetailsModel(this.$context);
        this.$listener.onError(fareDetailsModel);
        this.$listener.onFinish(fareDetailsModel);
    }
}
