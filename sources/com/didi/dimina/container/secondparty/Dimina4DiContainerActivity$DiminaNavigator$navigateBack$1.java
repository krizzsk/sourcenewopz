package com.didi.dimina.container.secondparty;

import com.didi.dimina.container.secondparty.Dimina4DiContainerActivity;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: Dimina4DiContainerActivity.kt */
final class Dimina4DiContainerActivity$DiminaNavigator$navigateBack$1 implements Runnable {
    final /* synthetic */ Dimina4DiContainerActivity.DiminaNavigator this$0;

    Dimina4DiContainerActivity$DiminaNavigator$navigateBack$1(Dimina4DiContainerActivity.DiminaNavigator diminaNavigator) {
        this.this$0 = diminaNavigator;
    }

    public final void run() {
        if (this.this$0.mPageStack.isEmpty()) {
            Dimina4DiContainerActivity.this.m12569b();
        }
    }
}
