package com.didi.dimina.container.secondparty.pushpage;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DiminaPushPageHelper.kt */
final class DiminaPushPageHelper$pushPageAfterDomReady$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $diminaUrlPath;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiminaPushPageHelper$pushPageAfterDomReady$1(String str) {
        super(0);
        this.$diminaUrlPath = str;
    }

    public final void invoke() {
        DiminaPushPageHelper.INSTANCE.m12968a(this.$diminaUrlPath);
    }
}
