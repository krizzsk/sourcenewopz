package com.didi.payment.base.view.webview.util;

import android.net.Uri;
import com.didi.payment.base.net.WalletNet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.base.view.webview.util.ChooseFileHelper$handleActivityResult$1", mo176687f = "ChooseFileHelper.kt", mo176688i = {}, mo176689l = {95, 99}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: ChooseFileHelper.kt */
final class ChooseFileHelper$handleActivityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChooseFileHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseFileHelper$handleActivityResult$1(ChooseFileHelper chooseFileHelper, Uri uri, Continuation<? super ChooseFileHelper$handleActivityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = chooseFileHelper;
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChooseFileHelper$handleActivityResult$1 chooseFileHelper$handleActivityResult$1 = new ChooseFileHelper$handleActivityResult$1(this.this$0, this.$uri, continuation);
        chooseFileHelper$handleActivityResult$1.L$0 = obj;
        return chooseFileHelper$handleActivityResult$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChooseFileHelper$handleActivityResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WalletNet walletNet = WalletNet.INSTANCE;
            this.label = 1;
            obj = WalletNet.withContext$default(walletNet, (CoroutineScope) this.L$0, new ChooseFileHelper$handleActivityResult$1$res$1(this.this$0, this.$uri, (Continuation<? super ChooseFileHelper$handleActivityResult$1$res$1>) null), (Function1) null, this, 4, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final Result result = (Result) obj;
        final ChooseFileHelper chooseFileHelper = this.this$0;
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new C105361((Continuation<? super C105361>) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @DebugMetadata(mo176686c = "com.didi.payment.base.view.webview.util.ChooseFileHelper$handleActivityResult$1$1", mo176687f = "ChooseFileHelper.kt", mo176688i = {}, mo176689l = {}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
    /* renamed from: com.didi.payment.base.view.webview.util.ChooseFileHelper$handleActivityResult$1$1 */
    /* compiled from: ChooseFileHelper.kt */
    static final class C105361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C105361(chooseFileHelper, result, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C105361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChooseFileHelper chooseFileHelper = chooseFileHelper;
                Result result = result;
                int access$getERR_CODE_READ_FAIL$p = result == null ? chooseFileHelper.f30058g : result.getErrno();
                Result result2 = result;
                chooseFileHelper.m21051a(access$getERR_CODE_READ_FAIL$p, result2 == null ? null : result2.getBase64());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
