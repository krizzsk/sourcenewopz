package com.didi.payment.base.view.webview.util;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H@"}, mo175978d2 = {"<anonymous>", "Lcom/didi/payment/base/view/webview/util/Result;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.base.view.webview.util.ChooseFileHelper$handleActivityResult$1$res$1", mo176687f = "ChooseFileHelper.kt", mo176688i = {}, mo176689l = {}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: ChooseFileHelper.kt */
final class ChooseFileHelper$handleActivityResult$1$res$1 extends SuspendLambda implements Function1<Continuation<? super Result>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ChooseFileHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseFileHelper$handleActivityResult$1$res$1(ChooseFileHelper chooseFileHelper, Uri uri, Continuation<? super ChooseFileHelper$handleActivityResult$1$res$1> continuation) {
        super(1, continuation);
        this.this$0 = chooseFileHelper;
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ChooseFileHelper$handleActivityResult$1$res$1(this.this$0, this.$uri, continuation);
    }

    public final Object invoke(Continuation<? super Result> continuation) {
        return ((ChooseFileHelper$handleActivityResult$1$res$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.m21048a(this.$uri);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
