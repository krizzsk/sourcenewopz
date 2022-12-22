package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh;

import android.content.Context;
import android.view.View;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\nH&R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/ACallFloatViewHolder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindView", "", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "getView", "Landroid/view/View;", "performDestroy", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.ACallFloatViewHolder */
/* compiled from: ACallFloatViewHolder.kt */
public abstract class ACallFloatViewHolder {

    /* renamed from: a */
    private final String f46345a = "ACallFloatViewHolder";

    public abstract void bindView(VoipAudioCall voipAudioCall);

    public abstract View getView();

    public abstract void performDestroy();

    public ACallFloatViewHolder(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.f46345a;
    }
}
