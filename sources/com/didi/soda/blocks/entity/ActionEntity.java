package com.didi.soda.blocks.entity;

import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/blocks/entity/ActionEntity;", "Ljava/io/Serializable;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "method", "getMethod", "setMethod", "onError", "", "getOnError", "()Ljava/util/List;", "setOnError", "(Ljava/util/List;)V", "onReject", "getOnReject", "setOnReject", "onResolve", "getOnResolve", "setOnResolve", "onSuccess", "getOnSuccess", "setOnSuccess", "params", "Lcom/google/gson/JsonObject;", "getParams", "()Lcom/google/gson/JsonObject;", "setParams", "(Lcom/google/gson/JsonObject;)V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ActionEntity.kt */
public final class ActionEntity implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 4913340410519207700L;
    private String actionType;
    private String method;
    private List<ActionEntity> onError;
    private List<ActionEntity> onReject;
    private List<ActionEntity> onResolve;
    private List<ActionEntity> onSuccess;
    private JsonObject params;

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String str) {
        this.actionType = str;
    }

    public final List<ActionEntity> getOnSuccess() {
        return this.onSuccess;
    }

    public final void setOnSuccess(List<ActionEntity> list) {
        this.onSuccess = list;
    }

    public final List<ActionEntity> getOnError() {
        return this.onError;
    }

    public final void setOnError(List<ActionEntity> list) {
        this.onError = list;
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final JsonObject getParams() {
        return this.params;
    }

    public final void setParams(JsonObject jsonObject) {
        this.params = jsonObject;
    }

    public final List<ActionEntity> getOnResolve() {
        return this.onResolve;
    }

    public final void setOnResolve(List<ActionEntity> list) {
        this.onResolve = list;
    }

    public final List<ActionEntity> getOnReject() {
        return this.onReject;
    }

    public final void setOnReject(List<ActionEntity> list) {
        this.onReject = list;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/entity/ActionEntity$Companion;", "", "()V", "serialVersionUID", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ActionEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
