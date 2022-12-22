package com.didi.payment.base.view.webview.util.image;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PickImageHelper.kt */
final class PickImageHelper$dispatchTakePhoto$1 extends Lambda implements Function1<String[], Unit> {
    final /* synthetic */ PickImageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PickImageHelper$dispatchTakePhoto$1(PickImageHelper pickImageHelper) {
        super(1);
        this.this$0 = pickImageHelper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String[]) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "it");
        this.this$0.m21090e();
    }
}
