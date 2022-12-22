package com.didi.unifylogin.flutter.request;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.spi.CPFVerifySerialInterface;
import com.didi.unifylogin.spi.CPFVerifyService;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FOpenCPFForce$request$1", "Lcom/didi/unifylogin/spi/CPFVerifySerialInterface$TestCallback;", "onFailed", "", "onSuccess", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FOpenCPFForce.kt */
public final class FOpenCPFForce$request$1 implements CPFVerifySerialInterface.TestCallback {
    final /* synthetic */ FOpenCPFForce this$0;

    FOpenCPFForce$request$1(FOpenCPFForce fOpenCPFForce) {
        this.this$0 = fOpenCPFForce;
    }

    public void onSuccess() {
        Context context = this.this$0.getContext();
        if (context != null) {
            CPFVerifyService.cpfJumpTo((Activity) context, (Fragment) null, new FOpenCPFForce$request$1$onSuccess$1(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }

    public void onFailed() {
        this.this$0.resultSuccess(Result.m31807ok());
    }
}
