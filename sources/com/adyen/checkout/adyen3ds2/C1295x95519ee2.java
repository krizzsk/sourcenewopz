package com.adyen.checkout.adyen3ds2;

import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.log.Logger;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, mo175978d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.adyen.checkout.adyen3ds2.Adyen3DS2Component$identifyShopper$$inlined$CoroutineExceptionHandler$1 */
/* compiled from: CoroutineExceptionHandler.kt */
public final class C1295x95519ee2 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Adyen3DS2Component this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1295x95519ee2(CoroutineExceptionHandler.Key key, Adyen3DS2Component adyen3DS2Component) {
        super(key);
        this.this$0 = adyen3DS2Component;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        Logger.m1079e(Adyen3DS2Component.f528g, "Unexpected uncaught 3DS2 Exception", th);
        this.this$0.notifyException(new CheckoutException("Unexpected 3DS2 exception.", th));
    }
}
