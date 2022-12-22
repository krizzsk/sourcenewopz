package com.datadog.android.rum.resource;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Ljava/io/InputStream;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumResourceInputStream.kt */
final class RumResourceInputStream$reset$1 extends Lambda implements Function1<InputStream, Unit> {
    public static final RumResourceInputStream$reset$1 INSTANCE = new RumResourceInputStream$reset$1();

    RumResourceInputStream$reset$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InputStream) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$callWithErrorTracking");
        inputStream.reset();
    }
}
