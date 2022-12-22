package com.didi.soda.compose.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u0001¢\u0006\u0002\u0010\u0006R\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/compose/event/ComposeAction;", "", "type", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getType", "()Ljava/lang/String;", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ComposeAction.kt */
public final class ComposeAction {

    /* renamed from: a */
    private final String f40121a;

    /* renamed from: b */
    private final Object[] f40122b;

    public ComposeAction(String str, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(objArr, "args");
        this.f40121a = str;
        this.f40122b = objArr;
    }

    public final Object[] getArgs() {
        return this.f40122b;
    }

    public final String getType() {
        return this.f40121a;
    }
}
