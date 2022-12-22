package com.didiglobal.scan.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didiglobal/scan/data/ScanResultModel;", "Ljava/io/Serializable;", "()V", "action_type", "", "getAction_type", "()Ljava/lang/String;", "setAction_type", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "source", "Lcom/google/gson/JsonObject;", "getSource", "()Lcom/google/gson/JsonObject;", "setSource", "(Lcom/google/gson/JsonObject;)V", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScanResultModel.kt */
public final class ScanResultModel implements Serializable {
    @SerializedName("action_type")
    private String action_type = "";
    @SerializedName("schema")
    private String schema = "";
    @SerializedName("source")
    private JsonObject source = new JsonObject();

    public final String getAction_type() {
        return this.action_type;
    }

    public final void setAction_type(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.action_type = str;
    }

    public final JsonObject getSource() {
        return this.source;
    }

    public final void setSource(JsonObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "<set-?>");
        this.source = jsonObject;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setSchema(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.schema = str;
    }
}
