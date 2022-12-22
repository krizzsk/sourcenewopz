package com.datadog.android.rum.resource;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Ljava/io/InputStream;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumResourceInputStream.kt */
final class RumResourceInputStream$read$1 extends Lambda implements Function1<InputStream, Integer> {
    final /* synthetic */ RumResourceInputStream this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RumResourceInputStream$read$1(RumResourceInputStream rumResourceInputStream) {
        super(1);
        this.this$0 = rumResourceInputStream;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(invoke((InputStream) obj));
    }

    public final int invoke(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$callWithErrorTracking");
        int read = inputStream.read();
        RumResourceInputStream rumResourceInputStream = this.this$0;
        if (read >= 0) {
            rumResourceInputStream.setSize$dd_sdk_android_release(rumResourceInputStream.getSize$dd_sdk_android_release() + 1);
        }
        rumResourceInputStream.f4021h = System.nanoTime();
        return read;
    }
}
