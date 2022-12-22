package com.didi.component.driverbar.presenter;

import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didiglobal.travel.infra.rxjava2.CompletableSubscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didiglobal/travel/infra/rxjava2/CompletableSubscribe;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarV2Presenter.kt */
final class DriverBarV2Presenter$setViewWithData$1$1 extends Lambda implements Function1<CompletableSubscribe, Unit> {
    final /* synthetic */ IXpCardBindDataReadyCallback $callback;
    final /* synthetic */ DriverBarV2Presenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DriverBarV2Presenter$setViewWithData$1$1(IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback, DriverBarV2Presenter driverBarV2Presenter) {
        super(1);
        this.$callback = iXpCardBindDataReadyCallback;
        this.this$0 = driverBarV2Presenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CompletableSubscribe) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CompletableSubscribe completableSubscribe) {
        Intrinsics.checkNotNullParameter(completableSubscribe, "$this$subscribeBy");
        final IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = this.$callback;
        completableSubscribe.onComplete(new Function0<Unit>() {
            public final void invoke() {
                IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = iXpCardBindDataReadyCallback;
                if (iXpCardBindDataReadyCallback != null) {
                    iXpCardBindDataReadyCallback.ready(true);
                }
            }
        });
        final DriverBarV2Presenter driverBarV2Presenter = this.this$0;
        final IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback2 = this.$callback;
        completableSubscribe.onError(new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                driverBarV2Presenter.getMLogger().info("DriverBarV2Presenter", "Fail to process driver-bar data.", th);
                IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = iXpCardBindDataReadyCallback2;
                if (iXpCardBindDataReadyCallback != null) {
                    iXpCardBindDataReadyCallback.ready(false);
                }
            }
        });
    }
}
