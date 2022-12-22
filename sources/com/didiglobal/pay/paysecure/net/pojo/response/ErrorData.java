package com.didiglobal.pay.paysecure.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001a"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/net/pojo/response/ErrorData;", "Ljava/io/Serializable;", "()V", "body", "", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "buttons", "", "Lcom/didiglobal/pay/paysecure/net/pojo/response/Button;", "getButtons", "()[Lcom/didiglobal/pay/paysecure/net/pojo/response/Button;", "setButtons", "([Lcom/didiglobal/pay/paysecure/net/pojo/response/Button;)V", "[Lcom/didiglobal/pay/paysecure/net/pojo/response/Button;", "eventId", "getEventId", "setEventId", "style", "getStyle", "setStyle", "title", "getTitle", "setTitle", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ErrorData.kt */
public final class ErrorData implements Serializable {
    @SerializedName("body")
    private String body;
    @SerializedName("buttons")
    private Button[] buttons;
    @SerializedName("event_id")
    private String eventId;
    @SerializedName("style")
    private String style;
    @SerializedName("title")
    private String title;

    public final String getStyle() {
        return this.style;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getBody() {
        return this.body;
    }

    public final void setBody(String str) {
        this.body = str;
    }

    public final Button[] getButtons() {
        return this.buttons;
    }

    public final void setButtons(Button[] buttonArr) {
        this.buttons = buttonArr;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }
}
