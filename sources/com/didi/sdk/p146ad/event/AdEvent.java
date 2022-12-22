package com.didi.sdk.p146ad.event;

import com.didi.sdk.p146ad.model.AdConfigItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/sdk/ad/event/AdEvent;", "", "()V", "adConfigItem", "Lcom/didi/sdk/ad/model/AdConfigItem;", "getAdConfigItem", "()Lcom/didi/sdk/ad/model/AdConfigItem;", "setAdConfigItem", "(Lcom/didi/sdk/ad/model/AdConfigItem;)V", "ddlType", "", "getDdlType", "()Ljava/lang/String;", "setDdlType", "(Ljava/lang/String;)V", "type", "getType", "setType", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.event.AdEvent */
/* compiled from: AdEvent.kt */
public final class AdEvent {

    /* renamed from: a */
    private AdConfigItem f34921a;

    /* renamed from: b */
    private String f34922b = "";

    /* renamed from: c */
    private String f34923c = "";

    public final AdConfigItem getAdConfigItem() {
        return this.f34921a;
    }

    public final void setAdConfigItem(AdConfigItem adConfigItem) {
        this.f34921a = adConfigItem;
    }

    public final String getType() {
        return this.f34922b;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f34922b = str;
    }

    public final String getDdlType() {
        return this.f34923c;
    }

    public final void setDdlType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f34923c = str;
    }
}
