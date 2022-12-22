package com.didi.soda.blocks.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R:\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/blocks/model/ActionModel;", "Ljava/io/Serializable;", "()V", "actionType", "", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "event", "getEvent", "setEvent", "onError", "", "getOnError", "()Ljava/util/List;", "setOnError", "(Ljava/util/List;)V", "onSuccess", "getOnSuccess", "setOnSuccess", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ActionModel.kt */
public final class ActionModel implements Serializable {
    private String actionType;
    private String event;
    private List<ActionModel> onError;
    private List<ActionModel> onSuccess;
    private HashMap<String, Object> params;

    public final String getEvent() {
        return this.event;
    }

    public final void setEvent(String str) {
        this.event = str;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String str) {
        this.actionType = str;
    }

    public final HashMap<String, Object> getParams() {
        return this.params;
    }

    public final void setParams(HashMap<String, Object> hashMap) {
        this.params = hashMap;
    }

    public final List<ActionModel> getOnSuccess() {
        return this.onSuccess;
    }

    public final void setOnSuccess(List<ActionModel> list) {
        this.onSuccess = list;
    }

    public final List<ActionModel> getOnError() {
        return this.onError;
    }

    public final void setOnError(List<ActionModel> list) {
        this.onError = list;
    }
}
