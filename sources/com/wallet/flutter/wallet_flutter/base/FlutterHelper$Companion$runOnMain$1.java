package com.wallet.flutter.wallet_flutter.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterHelper.kt */
public final class FlutterHelper$Companion$runOnMain$1 implements Runnable {
    final /* synthetic */ Function0<Unit> $block;

    public FlutterHelper$Companion$runOnMain$1(Function0<Unit> function0) {
        this.$block = function0;
    }

    public final void run() {
        this.$block.invoke();
        Unit unit = Unit.INSTANCE;
    }
}
