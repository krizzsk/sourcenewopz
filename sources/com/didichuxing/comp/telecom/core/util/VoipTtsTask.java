package com.didichuxing.comp.telecom.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/VoipTtsTask;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TtsServiceHelper.kt */
public final class VoipTtsTask {

    /* renamed from: a */
    private final String f46423a;

    public VoipTtsTask(String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        this.f46423a = str;
    }

    public final String getText() {
        return this.f46423a;
    }
}
