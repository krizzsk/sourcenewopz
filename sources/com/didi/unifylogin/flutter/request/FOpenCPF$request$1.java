package com.didi.unifylogin.flutter.request;

import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.spi.CPFVerifySerialInterface;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, mo175978d2 = {"<anonymous>", "", "errno", "", "error", "", "kotlin.jvm.PlatformType", "onResult"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: FOpenCPF.kt */
final class FOpenCPF$request$1 implements CPFVerifySerialInterface.CpfCallback {
    final /* synthetic */ FOpenCPF this$0;

    FOpenCPF$request$1(FOpenCPF fOpenCPF) {
        this.this$0 = fOpenCPF;
    }

    public final void onResult(int i, String str) {
        this.this$0.resultSuccess(Result.error(i, str));
    }
}
