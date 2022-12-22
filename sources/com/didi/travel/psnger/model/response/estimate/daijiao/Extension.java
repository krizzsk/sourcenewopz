package com.didi.travel.psnger.model.response.estimate.daijiao;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/travel/psnger/model/response/estimate/daijiao/Extension;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "logData", "Lcom/google/gson/JsonObject;", "getLogData", "()Lcom/google/gson/JsonObject;", "setLogData", "(Lcom/google/gson/JsonObject;)V", "selectValueParams", "getSelectValueParams", "setSelectValueParams", "tebridge_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Extension.kt */
public final class Extension implements BffGsonStruct {
    @SerializedName("log_data")
    private JsonObject logData;
    @SerializedName("select_value_params")
    private JsonObject selectValueParams;

    public Object clone() {
        return super.clone();
    }

    public final JsonObject getSelectValueParams() {
        return this.selectValueParams;
    }

    public final void setSelectValueParams(JsonObject jsonObject) {
        this.selectValueParams = jsonObject;
    }

    public final JsonObject getLogData() {
        return this.logData;
    }

    public final void setLogData(JsonObject jsonObject) {
        this.logData = jsonObject;
    }
}
