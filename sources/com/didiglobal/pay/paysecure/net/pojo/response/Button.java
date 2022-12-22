package com.didiglobal.pay.paysecure.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/net/pojo/response/Button;", "Ljava/io/Serializable;", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "buttonType", "getButtonType", "setButtonType", "eventId", "getEventId", "setEventId", "nodismiss", "", "getNodismiss", "()I", "setNodismiss", "(I)V", "text", "getText", "setText", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ErrorData.kt */
public final class Button implements Serializable {
    @SerializedName("action")
    private String action;
    @SerializedName("button_type")
    private String buttonType;
    @SerializedName("event_id")
    private String eventId;
    @SerializedName("nodismiss")
    private int nodismiss;
    @SerializedName("text")
    private String text;

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final int getNodismiss() {
        return this.nodismiss;
    }

    public final void setNodismiss(int i) {
        this.nodismiss = i;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final void setButtonType(String str) {
        this.buttonType = str;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }
}
