package com.pay99.diff_base.model;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/pay99/diff_base/model/ReceiveCodeMsg;", "", "pushMsg", "", "(Ljava/lang/String;)V", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getPushMsg", "()Ljava/lang/String;", "setPushMsg", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveCodeMsg.kt */
public final class ReceiveCodeMsg {

    /* renamed from: a */
    private String f55811a;

    /* renamed from: b */
    private Integer f55812b;

    public final String getPushMsg() {
        return this.f55811a;
    }

    public final void setPushMsg(String str) {
        this.f55811a = str;
    }

    public final Integer getType() {
        return this.f55812b;
    }

    public final void setType(Integer num) {
        this.f55812b = num;
    }

    public ReceiveCodeMsg(String str) {
        this.f55811a = str;
    }

    public ReceiveCodeMsg(String str, Integer num) {
        this.f55811a = str;
        this.f55812b = num;
    }
}
