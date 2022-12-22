package com.adyen.checkout.adyen3ds2;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.adyen.checkout.adyen3ds2.Adyen3DS2Component", mo176687f = "Adyen3DS2Component.kt", mo176688i = {0, 0}, mo176689l = {267}, mo176690m = "submitFingerprintAutomatically", mo176691n = {"this", "activity"}, mo176692s = {"L$0", "L$1"})
/* compiled from: Adyen3DS2Component.kt */
final class Adyen3DS2Component$submitFingerprintAutomatically$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Adyen3DS2Component this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Adyen3DS2Component$submitFingerprintAutomatically$1(Adyen3DS2Component adyen3DS2Component, Continuation<? super Adyen3DS2Component$submitFingerprintAutomatically$1> continuation) {
        super(continuation);
        this.this$0 = adyen3DS2Component;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1026a((Activity) null, (String) null, (Continuation<? super Unit>) this);
    }
}
